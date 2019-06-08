package test;

import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.protocol.lan.Ethernet;

public class ArpTest {
    public static void main( String[] args ) {
        String str="000f0a000600000f0a0006000806"+
    "080006040001000f0a000600c0a80102"+
    "000000000000c0a80102";
        JMemoryPacket packet=new JMemoryPacket(Ethernet.ID, str);
        packet.scan( Ethernet.ID );
        System.out.println( packet );
    }

}
