package test;

import java.io.IOException;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import com.upec.securityProtocols.communications.ArpPacket;
import com.upec.securityProtocols.communications.Input;

public class MyTest1 {

    public static void main( String[] args ) throws IOException {
        StringBuilder erreurs=new StringBuilder();
        PcapIf device=PcapUtils.getDevice( "wlan", erreurs );
        Pcap pcap=PcapUtils.createPcap( device, Pcap.MODE_PROMISCUOUS, erreurs );
        System.out.println( erreurs.toString() );
        Input in=new Input( pcap );
        
        ArpPacket arp=ArpPacket.getInstance( in );
        byte[]mac=new byte[]{0, 0x0f, 0x0a, 0, 6, 0};
        byte[]ip=new byte[]{(byte)192,(byte)168,1,2 };
        arp.editEthernetHeader( mac);
        arp.editArpHeader( mac, ip, ip, 1 );
        
        System.out.println( arp.getPacket().toHexdump() );
        
        System.out.println( arp );
    }
}
