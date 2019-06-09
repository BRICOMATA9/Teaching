package test;

import java.util.List;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Arp;

public class MyPcapPacketHandler implements PcapPacketHandler<List<PcapPacket>> {

	@Override
	public void nextPacket(PcapPacket packet, List<PcapPacket> queue) {
		PcapPacket permanent=new PcapPacket(packet);
		System.out.println( packet );
		System.out.println( "**************************" );
		System.out.println( packet.toHexdump() );
		Arp arp=packet.getHeader( new Arp() );
        System.out.println( "---------------------------------" );
        if(arp!=null)
        System.out.println( arp.toHexdump() );
		System.out.println( "####################################################" );
		
		queue.add(permanent);
	}
}
