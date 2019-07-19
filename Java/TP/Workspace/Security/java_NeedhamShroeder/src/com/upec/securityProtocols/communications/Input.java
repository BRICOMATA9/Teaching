package com.upec.securityProtocols.communications;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.util.PcapPacketArrayList;

public class Input {

    private Pcap          pcap;

    public Input( Pcap pcap ) {
        this.pcap = pcap;
    }

    public PcapPacket readPacket(  ) {
        PcapPacketHandler<PcapPacketArrayList> handler = new PacketsHandler();
        PcapPacketArrayList list=new PcapPacketArrayList();
        pcap.loop( 1, handler,  list);
        return new PcapPacket( list.get( 0 ) );
    }

    public void readPackets(PcapPacketArrayList paquets, int n){
        PcapPacketHandler<PcapPacketArrayList> handler=new PacketsHandler();
        pcap.loop( n, handler, paquets );
    }
    
    public PcapPacket readPacket(String filtre ) {
        try {
            setFilter( filtre );
        } catch ( Exception e ) {
        }
        
        return readPacket();
    }

    public void setFilter( String description ) throws Exception {
        PcapBpfProgram filter = new PcapBpfProgram();
        int optimize = 0;
        int netmask = 0xFFFFFF00;
        if ( pcap.compile( filter, description, optimize, netmask ) != Pcap.OK
                || pcap.setFilter( filter ) != Pcap.OK ) {
            throw new Exception( "Errors occured while setting filter " + pcap.getErr() );
        }
    }
}
