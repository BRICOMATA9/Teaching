import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.protocol.JProtocol;

public class TestArp {

    public static void main( String[] args ) {
        String s="      00010101 0006100b a99e71bc 08060001"
                + "08000604 0001100b a99e71bc c0a80110"
                + "00000000 0000c0a80 0186";
        JMemoryPacket packet=new JMemoryPacket(JProtocol.ETHERNET_ID, s );
        System.out.println( packet.toString() );
        
    }
}
