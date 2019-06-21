package serveurs;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import utilities.FractalRequest;
import utilities.HttpUtilities;

public class HttpRequestManager implements Runnable {
    private SocketChannel socket;
    ByteBuffer            buffer;
    String                request;
    ComputingServer       computer;

    public HttpRequestManager( SocketChannel socket, ComputingServer computer ) {
        this.socket = socket;
        this.computer = computer;
        buffer = ByteBuffer.allocateDirect( ServerHttp.BUFFER_SIZE );

    }

    @Override
    public void run() {
        try {
            readWebRequest();
            writeWebResponse();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void readWebRequest() throws Exception {
        buffer.clear();
        if ( socket.read( buffer ) == -1 )
            throw new IOException( "Echec de la lecture de la requete du client" );
        buffer.flip();
        String req = Charset.forName( "UTF-8" ).decode( buffer ).toString();
        StringTokenizer tokens = new StringTokenizer( req );
        tokens.nextToken();
        request = tokens.nextToken();
        System.out.println( request );
    }

    public void writeWebResponse() throws Exception {
        String fileName = HttpUtilities.extractFileName( request );
        File file = new File( fileName );
        int id = System.identityHashCode( socket );
        if ( fileName.equals( "index.html" ) && HttpUtilities.hasParameters( request ) ) {
            FractalRequest fr = FractalRequest.request( request );
            fr.setOwnerId( id );
            computer.addRequest( fr );
            BufferedImage bufferedImage = computer.getImage( id ); // bloquante
            File image = new File( "mandelbrotset" + id + ".png" );
            ImageIO.write( bufferedImage, "png", image );
            sendTextFile( socket, file, id );
            file = new File( "tmp" + id + ".html" );
        }

        String header = HttpUtilities.makeResponseHead( file );
        header += file.exists() ? "" : HttpUtilities.NOT_FOUND_BODY;
        socket.write( ByteBuffer.wrap( header.getBytes() ) );

        if ( file.exists() ) {
            HttpUtilities.sendBytes( socket, file, buffer );
            if ( ( fileName.startsWith( "mandelbrotset" ) && fileName.length() > 17 )
                    || file.getName().equals( "tmp" + id + ".html" ) )
                file.delete();
        }
        socket.finishConnect();
        socket.close();

    }

    public void sendTextFile( SocketChannel socket, File file, int id ) throws Exception {
        if ( file.getName().equals( "index.html" ) ) {
            String fileString = readFile( file, id );
            BufferedWriter bw = new BufferedWriter( new FileWriter( "tmp" + id + ".html" ) );
            bw.write( fileString );
            bw.close();
        }
    }

    public static String readFile( File file, int id ) throws Exception {
        String str = "";
        String imgLink = "<img id=\"img\" src=\"mandelbrotset.png?Xmin=-2&Ymin=-1&Xmax=1&Ymax=1&Iteration=50\"";
        BufferedReader br = new BufferedReader( new FileReader( file ) );
        String s;
        while ( ( s = br.readLine() ) != null ) {
            if ( s.equals( imgLink ) ) {
                s = "<img id=\"img\" src=\"mandelbrotset" + id
                        + ".png\" width=\"600\" height=\"400\" style=\"border: 1px solid #000;\">\n</img>";
                br.readLine();
                br.readLine();
            }
            str += s + "\n";
        }
        br.close();
        return str;
    }
}
