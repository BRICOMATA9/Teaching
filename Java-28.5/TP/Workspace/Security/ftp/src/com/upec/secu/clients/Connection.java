package com.upec.secu.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class Connection {
    String           address;
    Integer          port;
    String           errormessage;
    boolean          finishedOK;
    Socket           s;
    DataOutputStream out;
    DataInputStream  in;

    public Connection( String addr, Integer port ) {
        this.address = addr;
        this.port = port;
    }

    public void connect() throws Exception {
        this.s = new Socket( this.address, this.port );
        this.out = new DataOutputStream( s.getOutputStream() );
        this.in = new DataInputStream( s.getInputStream() );
    }

    public abstract void run() throws Exception;

    public boolean finishedWell() {
        return finishedOK;
    }

    public String getErrorMessage() {
        return this.errormessage;
    }

    public byte[] read() throws IOException {
        byte[] result = new byte[4096];
        int read = this.in.read( result );
        if ( read == -1 ) {
            throw new IOException();
        }

        byte[] res_fitted = new byte[read];
        for ( int i = 0; i < read; i++ ) {
            res_fitted[i] = result[i];
        }
        return res_fitted;
    }

    public void close() throws IOException {
        this.s.close();
    }

}
