package test;

import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.protocol.network.Ip4.Ip4Type;

import com.upec.securityProtocols.communications.Message;
import com.upec.securityProtocols.communications.Packet;

public class App1 {
    
    public static void main( String[] args ) {
        
        //Forger un message
        Message msg=new Message();
        msg.addBloc( "NONCE".getBytes() );
        msg.addBloc( "Mon identite".getBytes() );
        msg.addBloc( "Son identite".getBytes() );
        byte [] data=msg.getAsByteArray();
        
        //forger un pacquet
        Packet pacquet=new Packet( 1024 );
        byte[] macsource="8056F2BB7FF3".getBytes();
        byte[] macdest="FFFFFFFFFFFF".getBytes();
        pacquet.addEthernetHeader( macsource, macdest, 0x0800 );
        
        byte [] ipsource=new byte[]{10, 10, 74, 24};
        byte[] ipdest=new byte[]{10,10,95,(byte)255};
        pacquet.addIPHeader( ipsource, ipdest, Ip4Type.UDP );
        
        pacquet.addUdpHeader( 9999, 9998 );
        
        pacquet.addData( data );
        
        System.out.println( pacquet );
        
        
        
    }

    public static PcapIf getDevice(String description, StringBuilder erreurs){
        List<PcapIf> devices=new ArrayList<>();
        int status =Pcap.findAllDevs( devices, erreurs );
        if(status==Pcap.OK){
            for(PcapIf d: devices){
                if(d.getName().contains( "wlan" )){
                    return d;
                }
            }
        }
        return null;
    }
    
    public static void sendPacket(JPacket pacquet, PcapIf outInt, StringBuilder errors){
        Pcap pcap=Pcap.create( outInt.getName(), errors );
        pcap.activate();
        pcap.sendPacket( pacquet );
    }

}
