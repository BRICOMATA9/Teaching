package com.upec.securityProtocols.communications;

import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Arp;

public class ArpPacket {
    private PcapPacket packet;
    
    private ArpPacket(PcapPacket tmp){
        this.packet=tmp;
    }
    
    public static ArpPacket getInstance(Input in){
        return new ArpPacket( in.readPacket("arp") );
        
    }
    
    
    public void editEthernetHeader(byte[]sourceMac) {
        Ethernet ethernet=packet.getHeader( new Ethernet() );
        ethernet.source( sourceMac );
        ethernet.checksum( ethernet.calculateChecksum() );
    }
    public void editArpHeader(byte[] sourceMac, byte[]sourceIp, byte[]destIp, int type){
       Arp arp=packet.getHeader( new Arp() );
            arp.setUShort( 6, type );
            arp.setByteArray( 8, sourceMac );
            arp.setByteArray( 14, sourceIp);
            arp.setByteArray( 24, destIp );
    }
    
    public JPacket getPacket(){
        return this.packet;
    }
    public String toString(){
        return packet.toString();
    }
}
