// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.*;

public class Base64EncoderStream extends OutputStream
{

    public Base64EncoderStream(OutputStream outputstream)
    {
        atom = new byte[3];
        atomLen = 0;
        encodeBuf = new byte[4];
        lineLen = 0;
        out = new PrintStream(outputstream);
        closeOutOnClose = true;
    }

    public Base64EncoderStream(OutputStream outputstream, boolean flag)
    {
        atom = new byte[3];
        atomLen = 0;
        encodeBuf = new byte[4];
        lineLen = 0;
        out = new PrintStream(outputstream);
        closeOutOnClose = flag;
    }

    public void close()
        throws IOException
    {
        if(out != null)
        {
            encodeAtom();
            out.flush();
            if(closeOutOnClose)
                out.close();
            out = null;
        }
    }

    public void flush()
        throws IOException
    {
        out.flush();
    }

    public void write(int i)
        throws IOException
    {
        atom[atomLen++] = (byte)i;
        if(atomLen == 3)
            encodeAtom();
    }

    public void write(byte abyte0[])
        throws IOException
    {
        encodeFromArray(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        encodeFromArray(abyte0, i, j);
    }

    void encodeAtom()
        throws IOException
    {
        switch(atomLen)
        {
        case 0: // '\0'
            return;

        case 1: // '\001'
            byte byte0 = atom[0];
            encodeBuf[0] = pem_array[byte0 >>> 2 & 0x3f];
            encodeBuf[1] = pem_array[byte0 << 4 & 0x30];
            encodeBuf[2] = encodeBuf[3] = 61;
            break;

        case 2: // '\002'
            byte byte1 = atom[0];
            byte byte3 = atom[1];
            encodeBuf[0] = pem_array[byte1 >>> 2 & 0x3f];
            encodeBuf[1] = pem_array[byte1 << 4 & 0x30 | byte3 >>> 4 & 0xf];
            encodeBuf[2] = pem_array[byte3 << 2 & 0x3c];
            encodeBuf[3] = 61;
            break;

        default:
            byte byte2 = atom[0];
            byte byte4 = atom[1];
            byte byte5 = atom[2];
            encodeBuf[0] = pem_array[byte2 >>> 2 & 0x3f];
            encodeBuf[1] = pem_array[byte2 << 4 & 0x30 | byte4 >>> 4 & 0xf];
            encodeBuf[2] = pem_array[byte4 << 2 & 0x3c | byte5 >>> 6 & 3];
            encodeBuf[3] = pem_array[byte5 & 0x3f];
            break;
        }
        if(lineLen == 64)
        {
            out.println();
            lineLen = 0;
        }
        out.write(encodeBuf);
        lineLen += 4;
        atomLen = 0;
    }

    void encodeFromArray(byte abyte0[], int i, int j)
        throws IOException
    {
        if(j == 0)
            return;
        if(atomLen != 0)
        {
            switch(atomLen)
            {
            case 1: // '\001'
                atom[1] = abyte0[i++];
                j--;
                atomLen++;
                if(j == 0)
                    return;
                atom[2] = abyte0[i++];
                j--;
                atomLen++;
                break;

            case 2: // '\002'
                atom[2] = abyte0[i++];
                j--;
                atomLen++;
                break;
            }
            encodeAtom();
        }
        for(; j >= 3; j -= 3)
        {
            byte byte0 = abyte0[i++];
            byte byte1 = abyte0[i++];
            byte byte2 = abyte0[i++];
            encodeBuf[0] = pem_array[byte0 >>> 2 & 0x3f];
            encodeBuf[1] = pem_array[byte0 << 4 & 0x30 | byte1 >>> 4 & 0xf];
            encodeBuf[2] = pem_array[byte1 << 2 & 0x3c | byte2 >>> 6 & 3];
            encodeBuf[3] = pem_array[byte2 & 0x3f];
            out.write(encodeBuf);
            lineLen += 4;
            if(lineLen == 64)
            {
                out.println();
                lineLen = 0;
            }
        }

        switch(j)
        {
        case 1: // '\001'
            atom[0] = abyte0[i];
            break;

        case 2: // '\002'
            atom[0] = abyte0[i];
            atom[1] = abyte0[i + 1];
            break;
        }
        atomLen = j;
    }

    private static final byte pem_array[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    byte atom[];
    int atomLen;
    byte encodeBuf[];
    int lineLen;
    PrintStream out;
    boolean closeOutOnClose;

}
