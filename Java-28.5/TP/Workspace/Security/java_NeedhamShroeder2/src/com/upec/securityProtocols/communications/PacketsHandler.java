package com.upec.securityProtocols.communications;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.util.PcapPacketArrayList;

public class PacketsHandler implements PcapPacketHandler<PcapPacketArrayList>{

    @Override
    public void nextPacket( PcapPacket packet, PcapPacketArrayList packets ) {
        PcapPacket permanent=new PcapPacket( packet );
        packets.add( permanent );
    }
}
