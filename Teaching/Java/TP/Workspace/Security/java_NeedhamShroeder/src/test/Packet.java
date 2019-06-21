package test;

import org.jnetpcap.protocol.tcpip.Udp;

public class Packet {

    public static void main( String[] args ) {
        Udp pacquet = new Udp();
        System.out.println( pacquet.length() );

    }

}
