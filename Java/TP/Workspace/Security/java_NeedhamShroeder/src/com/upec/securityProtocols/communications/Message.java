package com.upec.securityProtocols.communications;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Message {
    protected List<byte[]> content;

    public Message() {
        this.content = new ArrayList<>();
    }

    public Message( byte[] block ) {
        this.content = new ArrayList<>();
        this.content.add( block );
    }

    public static String buildStructure( Message msg ) {
        String structure = "" + msg.content.size();
        for ( byte[] b : msg.content ) {
            structure += ";" + b.length;
        }
        structure += "|";
        return structure;
    }

    public void addBloc( byte[] block ) {
        this.content.add( block );
    }

    public int getLength() {
        int length = buildStructure( this ).getBytes().length;
        for ( byte[] block : this.content ) {
            length += block.length;
        }
        return length;
    }

    public byte[] getAsByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate( getLength() );
        buffer.put( buildStructure( this ).getBytes() );
        for ( byte[] block : content ) {
            buffer.put( block );
        }
        return buffer.array();
    }

    public static Message getMessage( String msg ) {
        Message message = new Message();
        if ( !msg.trim().equals( "" ) ) {
            try {
                String[] elements = msg.substring( 0, msg.indexOf( "|" ) ).split( ";" );
                String realMsg = msg.substring( msg.indexOf( "|" ) + 1, msg.length() );
                int position = 0;
                for ( int i = 1; i < elements.length; i++ ) {
                    byte[] block = realMsg.substring( position, position + Integer.parseInt( elements[i] ) ).getBytes();
                    position += Integer.parseInt( elements[i] );
                    message.addBloc( block );
                }
            } catch ( Exception e ) {
                System.err.println( "Mauvais format de message: " + e.getMessage() );
            }
        }
        return message;
    }
}
