package test;

import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class PcapUtils {

    public static PcapIf getDevice( String description, StringBuilder erreurs ) {
        List<PcapIf> devices = new ArrayList<>();
        int status = Pcap.findAllDevs( devices, erreurs );
        if ( status == Pcap.OK ) {
            for ( PcapIf device : devices ) {
                if ( device.getName().contains( description ) ) {
                    return device;
                }
            }
        }
        return null;
    }
    
    public static void sendPacket( JPacket paquet, PcapIf outInt, StringBuilder errors ) {
        Pcap pcap = Pcap.create( outInt.getName(), errors );
        pcap.activate();
        pcap.sendPacket( paquet );
    }

    public static List<PcapPacket> getPacket( Pcap pcap, String ip, int port ) {
        PcapBpfProgram program = new PcapBpfProgram();
        String filtre = "host " + ip + " and port " + port;
        int optimize = 0;
        int netmask = 0xFFFFFF00;
        pcap.compile( program, filtre, optimize, netmask );
        pcap.setFilter( program );
        List<PcapPacket> paquets = new ArrayList<>();
        PcapPacketHandler<List<PcapPacket>> handler = new MyPcapPacketHandler();
        pcap.loop( 1, handler, paquets );
        return paquets;
    }

    public static void getArpPacket( Pcap pcap, PcapPacket packet ) {
        setFilter( pcap, "arp" );
        PcapPacketHandler<PcapPacket> handler = new MyHandler();
        pcap.loop( 1, handler, packet);
    }

    public static Pcap createPcap( PcapIf device, int flags, StringBuilder errors ) {
        if ( device == null ) {
            return null;
        }
        int snapLen = 64 * 1024;
        int timeout = 10 * 1000;
        Pcap pcap = Pcap.openLive( device.getName(), snapLen, flags, timeout,
                errors );
        return pcap;
    }

    public static void setFilter( Pcap pcap, String filtre ) {
        PcapBpfProgram program = new PcapBpfProgram();
        int optimize = 0;
        int netmask = 0xFFFFFF00;
        if ( pcap.compile( program, filtre, optimize, netmask ) != Pcap.OK ) {
            System.err.println( pcap.getErr() );
            return;
        }
        
        if ( pcap.setFilter( program ) != Pcap.OK ) {
            System.err.println( pcap.getErr() );
            return;
        }
    }
}
