package com.upec.securityProtocols.communications;

import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class PacketHandler implements PcapPacketHandler<PcapPacket> {
    protected PcapPacket permanent;
    @Override
    public void nextPacket( PcapPacket packet, PcapPacket p ) {
        permanent=new PcapPacket( packet );
    }
    
    public PcapPacket getPermanent(){
        return permanent;
    }
}
