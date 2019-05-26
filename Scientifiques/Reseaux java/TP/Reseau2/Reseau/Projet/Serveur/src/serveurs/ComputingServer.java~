package serveurs;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import serialization.SerializerBuffer;
import utilities.FractalRequest;
import utilities.Frame;
import utilities.Pixel;

/**
 * Notre serveur de calcul Maintient une file fifo des requetes de fractale et
 * Une map des fractales pretes.
 */
public class ComputingServer extends Thread {
    public static final int               VERTICAL_DIV   = 20;
    public static final int               HORIZONTAL_DIV = 30;
    public static final int               BUFFER_SIZE    = 16 * 1024;
    public static final Frame             CADRE          = new Frame( 600, 400 );
    ServerSocketChannel                   computingService;
    Selector                              computerSelector;
    SerializerBuffer                      computingBuffer;
    ConcurrentLinkedQueue<FractalRequest> requests;
    Map<Integer, BufferedImage>           images         = new HashMap<Integer, BufferedImage>();

    public ComputingServer( int port ) {
        try {
            computingService = ServerSocketChannel.open();
            computingService.bind( new InetSocketAddress( port ) );
            computerSelector = Selector.open();
            computingService.configureBlocking( false );
            computingService.register( computerSelector, SelectionKey.OP_ACCEPT );
            System.out.println( "Serveur de calcul à l'écoute sur le port " + port );
            requests = new ConcurrentLinkedQueue<FractalRequest>();
            computingBuffer = new SerializerBuffer( BUFFER_SIZE );
        } catch ( IOException e ) {
            System.err.println( "Echec de lancement du service de calcul: " + e.getMessage() );
        }
    }

    public void acceptComputer() {
        try {
            SocketChannel computer = computingService.accept();
            System.out.println( computer );
            computer.configureBlocking( false );
            computer.register( computerSelector, SelectionKey.OP_WRITE );
        } catch ( IOException e ) {
            System.err.println( "Echec de connexion au client de calcul: " + e.getMessage() );
        }
    }

    public void addRequest( FractalRequest request ) {
        this.requests.add( request );
    }

    public void removeRequest( FractalRequest request ) {
        this.requests.remove( request );
    }

    public void run() {
        try {
            while ( true ) {
                FractalRequest r = requests.poll();
                if ( r != null ) {
                    makeFractal( r );
                } else {
                    acceptComputers();
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void acceptComputers() throws IOException {
        Set<SelectionKey> computers;
        computerSelector.select();
        computers = computerSelector.selectedKeys();
        for ( SelectionKey k : computers ) {
            if ( k.isValid() && k.isAcceptable() ) {
                acceptComputer();
            }
        }
        computers.clear();
    }

    public void makeFractal( FractalRequest request ) throws IOException {
        BufferedImage img = new BufferedImage( CADRE.getLargeur(), CADRE.getHauteur(),
                BufferedImage.TYPE_3BYTE_BGR );
        int writeblocks = 0, readblocks = 0;
        while ( readblocks < VERTICAL_DIV * HORIZONTAL_DIV ) {
            Set<SelectionKey> computers;
            computerSelector.select();
            computers = computerSelector.selectedKeys();
            for ( SelectionKey k : computers ) {
                if ( k.isValid() ) {
                    if ( k.isAcceptable() ) {
                        acceptComputer();
                    } else if ( k.isReadable() ) {
                            readPixels( k, img, request.getIteration() );
                            readblocks++;
                    } else if ( k.isWritable() ) {
                        if ( writeblocks < VERTICAL_DIV * HORIZONTAL_DIV ) {
		                      sendFragment( k, request, writeblocks );
		                      writeblocks++;
                        }
                    }
                }
            }
            computers.clear();
        }
        addImage( request.getOwnerId(), img );
        acceptComputers();
    }

    public void sendFragment( SelectionKey k, FractalRequest request, int blockid ) throws IOException {
        SocketChannel sc = (SocketChannel) k.channel();
        computingBuffer.getBuffer().clear();
        computingBuffer.writeInt( blockid );
        computingBuffer.writeMySerializable( request );
        computingBuffer.getBuffer().flip();
        while ( computingBuffer.getBuffer().hasRemaining() ) {
            sc.write( computingBuffer.getBuffer() );
        }
        sc.register( computerSelector, SelectionKey.OP_READ );
    }

    public void readPixels( SelectionKey k, BufferedImage imag, int iteration ) throws IOException {
        SocketChannel sc = (SocketChannel) k.channel();
        computingBuffer.getBuffer().clear();
        if ( sc.read( computingBuffer.getBuffer() ) == -1 ) {
            throw new IOException( "Echec de lecture des données!" );
        }
        computingBuffer.getBuffer().flip();
        int n = computingBuffer.readInt();
        if ( n > 0 ) {
            for ( int i = 0; i < n; i++ ) {
                Pixel p = computingBuffer.readMySerializable( Pixel.CREATOR );
                imag.setRGB( p.getAbscisse(), CADRE.getHauteur() - p.getOrdonne() - 1,
                        p.getValue() == iteration ? 0 : p.getValue() * 255 / iteration );
            }
        }
        sc.register( computerSelector, SelectionKey.OP_WRITE );
    }

    public synchronized void addImage( int id, BufferedImage img ) {
        this.images.put( id, img );
        notifyAll();
    }

    public synchronized BufferedImage getImage( int id ) {
        while ( images.get( id ) == null )
            try {
                wait();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        BufferedImage img = images.get( id );
        if ( img == null )
            images.remove( id );
        return img;
    }
}
