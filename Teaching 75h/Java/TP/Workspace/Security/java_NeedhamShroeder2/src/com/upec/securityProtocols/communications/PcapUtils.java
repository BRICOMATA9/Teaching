package com.upec.securityProtocols.communications;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class PcapUtils {

    public static PcapIf getDevice( String description, StringBuilder erreurs ) {
        List<PcapIf> devices = new ArrayList<>();
        int status = Pcap.findAllDevs( devices, erreurs );
        if ( status == Pcap.OK ) {
            for ( PcapIf device : devices ) {
                if ( device.getName().contains( description ) ) {
                    return device;
                }
            }
        }
        return null;
    }
    
    public static Pcap createPcap( PcapIf device, int flags, StringBuilder errors ) {
        if ( device == null ) {
            return null;
        }
        int snapLen = 64 * 1024;
        int timeout = 10 * 1000;
        Pcap pcap = Pcap.openLive( device.getName(), snapLen, flags, timeout,
                errors );
        return pcap;
    }
    
    public static byte[] randomMACAddress(){
        Random rand=new Random();
        byte[] macAddr=new byte[6];
        rand.nextBytes( macAddr );
        macAddr[0]=(byte)(macAddr[0] & (byte)254);
        return macAddr;
    }
    
    public static byte[] randomIpV4ddress(){
        Random rand=new Random();
        byte []ip=new byte[4];
        for ( int i = 0; i < ip.length; i++ ) {
            ip[i]=(byte)rand.nextInt( 256 );
            
        }
        return ip;
    }
}

