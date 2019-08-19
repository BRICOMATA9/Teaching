package com.upec.securityProtocols.communications;

import java.io.IOException;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.protocol.network.Ip4.Ip4Type;

public class Output {
    public static final int ARP_PACKET_SIZE   = 42;
    public static final int UDP_FRAME_HEADER  = 42;
    public static final int TCP_PACKET_HEADER = 54;

    private Pcap            pcap;
    private byte[]          sourceMac;
    private byte[]          sourceIp;
    private int             sourcePort;

    public Output( Pcap pcap ) throws IOException {
        this.pcap = pcap;
    }

    public Output( Pcap pcap, PcapIf device ) throws IOException {
        this.pcap = pcap;
        if ( !device.getName().contains( "any" ) && !device.getName().contains( "lo" ) ) {
            this.sourceMac = device.getHardwareAddress();
            this.sourceIp = device.getAddresses().get( 0 ).getAddr().getData();
        }
    }

    public void sendArpMessage( byte[] destIp, byte[] destMac, int type ) {
        Packet packet = new Packet( ARP_PACKET_SIZE );
        packet.addEthernetHeader( sourceMac, destMac, 0x0806 );
        packet.addARPHeader( sourceMac, sourceIp, destIp, type );
        pcap.sendPacket( packet.getPacket() );

    }

    public void sendUdpMessage( byte[] destip, byte[] destMac, int destport, byte[] data ) {
        Packet packet = new Packet( UDP_FRAME_HEADER + data.length );
        packet.addEthernetHeader( sourceMac, destMac, 0x0800 );
        packet.addIPHeader( sourceIp, destip, Ip4Type.UDP );
        packet.addUdpHeader( sourcePort, destport );
        packet.addData( data );
        System.out.println( packet );
        pcap.sendPacket( packet.getPacket() );
    }

    public void sendTcpMessage( byte[] destip, byte[] destMac, int destport, byte[] data, int seq, int ack,
            int flags ) {
        Packet packet = new Packet( TCP_PACKET_HEADER + data.length );
        packet.addEthernetHeader( sourceMac, destMac, 0x0800 );
        packet.addIPHeader( sourceIp, destip, Ip4Type.TCP );
        packet.addTcpHeader( sourcePort, destport, seq, ack, flags );
        packet.addData( data );
        System.out.println( packet );
        pcap.sendPacket( packet.getPacket() );
    }

    public void sendPacket( Packet paquet ) {
        pcap.sendPacket( paquet.getPacket() );
    }

    public Pcap getPcap() {
        return pcap;
    }

    public void setPcap( Pcap pcap ) {
        this.pcap = pcap;
    }

    public byte[] getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac( byte[] sourceMac ) {
        this.sourceMac = sourceMac;
    }

    public byte[] getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp( byte[] sourceIp ) {
        this.sourceIp = sourceIp;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort( int sourcePort ) {
        this.sourcePort = sourcePort;
    }
}
