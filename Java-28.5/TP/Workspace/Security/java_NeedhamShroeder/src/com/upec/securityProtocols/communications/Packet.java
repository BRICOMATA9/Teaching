package com.upec.securityProtocols.communications;

import java.nio.ByteOrder;

import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.network.Ip4.Ip4Type;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;

public class Packet {
    public static final byte[] BROADCAST_MAC = new byte[] { (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff };
    public static final byte[] MAC_NULL      = new byte[] { 0, 0, 0, 0, 0, 0 };
    public static final int    TTL           = 15;
    public static final int    ETHERNET_SIZE = 14;
    public static final int    IP_SIZE       = 20;
    public static final int    ARP_SIZE      = 28;
    public static final int    UDP_SIZE      = 8;
    public static final int    TCP_SIZE      = 32;
    protected JMemoryPacket    packet;
    protected int              headerLength;

    public Packet( int size ) {
        packet = new JMemoryPacket( size );
        packet.order( ByteOrder.BIG_ENDIAN );
        this.headerLength = 0;
    }

    public void addEthernetHeader( byte[] macSource, byte[] macDestination, int type ) {
        packet.scan( Ethernet.ID );
        Ethernet ethernet = packet.getHeader( new Ethernet() );
        ethernet.source( macSource );
        ethernet.destination( macDestination );
        ethernet.type( type );
        // ethernet.checksum( ethernet.calculateChecksum() );
        this.headerLength += ethernet.size();
    }

    public void addARPHeader( byte[] macSource, byte[] sourceip, byte[] destIp, int type ) {
        packet.setUShort( 12, 0x0806 );
        packet.scan( Ethernet.ID );
        Arp arp = packet.getHeader( new Arp() );
        arp.setUShort( 0, 1 );
        arp.setUShort( 2, 0x0800 );
        arp.setUShort( 4, 4 );
        arp.setUShort( 3, 6 );
        arp.setUShort( 6, type );
        packet.setByteArray( 22, macSource );
        packet.setByteArray( 28, sourceip );
        packet.setByteArray( 32, MAC_NULL );
        packet.setByteArray( 38, destIp );
        this.headerLength += arp.size();
    }

    public void addIPHeader( byte[] ipSource, byte[] ipDest, Ip4Type protocol ) {
        packet.setUByte( headerLength, 0x04 | 0x05 );
        packet.scan( Ethernet.ID );
        Ip4 ip = packet.getHeader( new Ip4() );
        ip.source( ipSource );
        ip.destination( ipDest );
        ip.length( packet.size() - this.headerLength );
        ip.type( protocol );
        ip.ttl( TTL );
        ip.flags( 0 );
        ip.offset( 0 );
        ip.checksum( ip.calculateChecksum() );
        this.headerLength += ip.size();
    }

    public void addUdpHeader( int sourcePort, int destPort ) {
        packet.scan( Ethernet.ID );
        Udp udp = packet.getHeader( new Udp() );
        udp.source( sourcePort );
        udp.destination( destPort );
        udp.length( packet.size() - headerLength );
        udp.checksum( udp.calculateChecksum() );
        headerLength += udp.size();
    }

    public void addTcpHeader( int sourcePort, int destPort, int sequence, int ack, int flags ) {
        packet.setUByte( 46, 0x50 );
        packet.scan( Ethernet.ID );
        Tcp tcp = packet.getHeader( new Tcp() );
        tcp.source( sourcePort );
        tcp.destination( destPort );
        tcp.seq( sequence );
        tcp.ack( ack );
        tcp.flags( flags );
        tcp.checksum( tcp.calculateChecksum() );
        headerLength += tcp.size();
    }

    public void addData( byte[] data ) {
        packet.setByteArray( headerLength, data );
        packet.scan( Ethernet.ID );
    }

    public String toString() {
        return packet.toString();
    }

    public JPacket getPacket() {
        return this.packet;
    }
}
