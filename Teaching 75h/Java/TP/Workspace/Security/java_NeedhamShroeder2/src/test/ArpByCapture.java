package test;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.protocol.lan.Ethernet;

public class ArpByCapture {

    public static void main( String[] args ) {
        StringBuilder errors = new StringBuilder();
        PcapIf device = PcapUtils.getDevice( "any", errors );
        if ( device != null ) {
            System.out.println( "Device OK" );
        }
        Pcap pcap = PcapUtils.createPcap( device, Pcap.MODE_PROMISCUOUS, errors );
        if ( pcap != null ) {
            System.out.println( "Pcap OK" );
        }
        PcapPacket packet=new PcapPacket( Ethernet.ID );
        PcapUtils.getArpPacket( pcap, packet );
        System.out.println( packet );
        pcap.close();
    }
}
