package test;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.util.PcapPacketArrayList;

import com.upec.securityProtocols.communications.Input;

public class App2 {
    
    public static void main( String[] args ) throws Exception {
        StringBuilder erreurs=new StringBuilder();
        PcapIf device=PcapUtils.getDevice( "any", erreurs );
        Pcap pcap=PcapUtils.createPcap( device, Pcap.MODE_PROMISCUOUS, erreurs );
        System.out.println( erreurs.toString() );
        Input in=new Input( pcap );
        PcapPacketArrayList list= new PcapPacketArrayList();
        //PcapPacket packet= in.readPacket( "arp");
        //packet.setByteArray( 28, new byte[]{0,0,0,0} );
        in.setFilter("tcp" );
        in.readPackets( list, 10 );
        //System.out.println( packet );
        list.forEach( System.out::println );
        pcap.close();
    }

}
