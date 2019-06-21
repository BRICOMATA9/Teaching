package test;

import java.io.IOException;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import com.upec.securityProtocols.communications.Output;
import com.upec.securityProtocols.communications.Packet;
import com.upec.securityProtocols.communications.PcapUtils;

public class App4 {

    public static void main( String[] args ) throws IOException {
        StringBuilder erreurs=new StringBuilder();
        PcapIf device=PcapUtils.getDevice( "wlan", erreurs );
        Pcap pcap=PcapUtils.createPcap( device, Pcap.OK, erreurs );
        Output out=new Output( pcap );
        byte[]mac=new byte[]{0, 0x0f, 0x0a, 0, 6, 0};
        byte[]ip=new byte[]{(byte)192,(byte)168,1,2 };
        out.setSourceMac( mac );
        out.setSourceIp( ip );
        out.setSourcePort( 0 );
        String [] names=new String[]{"Franck", "Paul", "Pascal", "Herman", "Roland"};
        for ( int i = 0; i < names.length; i++ ) {
            out.sendArpMessage( ip, Packet.BROADCAST_MAC, 2 );
            try {
                Thread.sleep( 1000);
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                pcap.close();
            }
        }
    }
    
}
