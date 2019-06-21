package test;

import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class ArpPacketCapture {

    public static void main( String[] args ) {
        StringBuilder errors = new StringBuilder();
        List<PcapIf> devices = new ArrayList<PcapIf>();

        int status = Pcap.findAllDevs( devices, errors );
        if ( status != Pcap.OK ) {
            System.err.println( "Errors occured: " + errors.toString() );
            return;
        }

        PcapIf device = null;

        for ( PcapIf d : devices ) {
            if ( d.getName().contains( "any" ) ) {
                device = d;
                break;
            }
        }

        int snaplen = 1024;
        int timeout = 1000;
        int mode = Pcap.MODE_PROMISCUOUS;

        Pcap pcap = Pcap.openLive( device.getName(), snaplen, mode, timeout, errors );

        PcapBpfProgram program = new PcapBpfProgram();
        String expression = "arp";
        int optimize = 0; // 0 = false
        int netmask = 0xFFFFFF00; // 255.255.255.0
        if ( pcap.compile( program, expression, optimize, netmask ) != Pcap.OK ) {
            System.err.println( pcap.getErr() );
            return;
        }

        if ( pcap.setFilter( program ) != Pcap.OK ) {
            System.err.println( pcap.getErr() );
            return;
        }

        List<PcapPacket> paquets = new ArrayList<>();
        PcapPacketHandler<List<PcapPacket>> handler = new MyPcapPacketHandler();
        pcap.loop( 20, handler, paquets );
        System.out.println( paquets.size() );
        pcap.close();
    }

}
