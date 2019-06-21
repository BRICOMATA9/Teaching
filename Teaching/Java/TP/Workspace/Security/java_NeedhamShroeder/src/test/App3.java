package test;

import java.io.IOException;

import org.jnetpcap.protocol.network.Ip4.Ip4Type;

import com.upec.securityProtocols.communications.Packet;

public class App3 {
    public static void main( String[] args ) throws IOException {
        Packet paquet=new Packet( 96 );
        byte[]mac=new byte[]{0,0,0,0,0,0};
        byte [] ip=new byte[]{1,2,3,4};
        paquet.addEthernetHeader( mac, mac, 0x0800 );
       // paquet.addARPHeader( mac, ip, ip, 0x01 );
       paquet.addIPHeader( ip, ip, Ip4Type.UDP );
       paquet.addUdpHeader( 809, 999 );
       paquet.addData( "Bonjour à tous!".getBytes() );
        System.out.println( paquet);
    }
}
