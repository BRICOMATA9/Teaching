package test;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class MyHandler implements PcapPacketHandler<PcapPacket> {

    @Override
    public void nextPacket( PcapPacket packet, PcapPacket permanent ) {
         permanent = new PcapPacket( packet );
        
    }
}
