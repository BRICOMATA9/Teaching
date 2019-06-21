// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.IOException;
import java.io.InputStream;

public class Base64DecodeStream extends InputStream
{

    public Base64DecodeStream(InputStream inputstream)
    {
        decode_buffer = new byte[4];
        out_buffer = new byte[3];
        out_offset = 3;
        EOF = false;
        src = inputstream;
    }

    public boolean markSupported()
    {
        return false;
    }

    public void close()
        throws IOException
    {
        EOF = true;
    }

    public int available()
        throws IOException
    {
        return 3 - out_offset;
    }

    public int read()
        throws IOException
    {
        if(out_offset == 3 && (EOF || getNextAtom()))
        {
            EOF = true;
            return -1;
        } else
        {
            return out_buffer[out_offset++] & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k;
        for(k = 0; k < j; k++)
        {
            if(out_offset == 3 && (EOF || getNextAtom()))
            {
                EOF = true;
                if(k == 0)
                    return -1;
                else
                    return k;
            }
            abyte0[i + k] = out_buffer[out_offset++];
        }

        return k;
    }

    final boolean getNextAtom()
        throws IOException
    {
        int l;
        for(int j = 0; j != 4; j = l)
        {
            int i = src.read(decode_buffer, j, 4 - j);
            if(i == -1)
                return true;
            int k = j;
            l = j;
            for(; k < j + i; k++)
                if(decode_buffer[k] != 10 && decode_buffer[k] != 13 && decode_buffer[k] != 32)
                    decode_buffer[l++] = decode_buffer[k];

        }

        byte byte0 = pem_array[decode_buffer[0] & 0xff];
        byte byte1 = pem_array[decode_buffer[1] & 0xff];
        byte byte2 = pem_array[decode_buffer[2] & 0xff];
        byte byte3 = pem_array[decode_buffer[3] & 0xff];
        out_buffer[0] = (byte)(byte0 << 2 | byte1 >>> 4);
        out_buffer[1] = (byte)(byte1 << 4 | byte2 >>> 2);
        out_buffer[2] = (byte)(byte2 << 6 | byte3);
        if(decode_buffer[3] != 61)
            out_offset = 0;
        else
        if(decode_buffer[2] == 61)
        {
            out_buffer[2] = out_buffer[0];
            out_offset = 2;
            EOF = true;
        } else
        {
            out_buffer[2] = out_buffer[1];
            out_buffer[1] = out_buffer[0];
            out_offset = 1;
            EOF = true;
        }
        return false;
    }

    InputStream src;
    private static final byte pem_array[];
    byte decode_buffer[];
    byte out_buffer[];
    int out_offset;
    boolean EOF;

    static 
    {
        pem_array = new byte[256];
        for(int i = 0; i < pem_array.length; i++)
            pem_array[i] = -1;

        int j = 0;
        for(char c = 'A'; c <= 90; c++)
            pem_array[c] = (byte)(j++);

        for(char c1 = 'a'; c1 <= 122; c1++)
            pem_array[c1] = (byte)(j++);

        for(char c2 = '0'; c2 <= 57; c2++)
            pem_array[c2] = (byte)(j++);

        pem_array[43] = (byte)(j++);
        pem_array[47] = (byte)(j++);
    }
}
