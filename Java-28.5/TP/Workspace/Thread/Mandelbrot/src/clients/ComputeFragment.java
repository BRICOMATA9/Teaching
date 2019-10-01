package clients;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.List;

import serialization.SerializerBuffer;
import serveurs.ComputingServer;
import utilities.FractalRequest;
import utilities.FractalUtilities;
import utilities.Pixel;

/**
 * Cette classe represente la tache de chaque client de calcul A partir de l'id
 * du bloc reçu elle determine la portion de l'image qui la concerne.
 */
public class ComputeFragment {
    private SocketChannel    socket;
    private Client           computer;
    private SerializerBuffer buffer;

    public ComputeFragment( SocketChannel socket, Client computer ) {
        this.socket = socket;
        this.computer = computer;
        buffer = new SerializerBuffer( ComputingServer.BUFFER_SIZE );
    }

    public void start() {
        while ( computer.isConnected() ) {
            try {
                buffer.getBuffer().clear();
                if ( socket.read( buffer.getBuffer() ) != -1 ) {
                    buffer.getBuffer().flip();
                    int blockId = buffer.readInt();
                    FractalRequest request = buffer.readMySerializable( FractalRequest.CREATOR );
                    List<Pixel> pixels = FractalUtilities.getFractalPixels( blockId, request, ComputingServer.CADRE );
                    buffer.getBuffer().clear();
                    if ( pixels.size() == 0 )
                        buffer.writeInt( 0 );
                    else {
                        buffer.writeInt( pixels.size() );
                        for ( Pixel p : pixels ) {
                            buffer.writeMySerializable( p );
                        }
                    }
                    buffer.getBuffer().flip();
                    while ( ( buffer.getBuffer().hasRemaining() ) ) {
                        socket.write( buffer.getBuffer() );
                    }
                } else
                    throw new IOException( "Echec!" );
            } catch ( Exception e ) {
                computer.disconnect();
            }
        }
    }
}
