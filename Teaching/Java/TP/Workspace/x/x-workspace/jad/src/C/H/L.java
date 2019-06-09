// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.J.b;
import java.io.*;

public abstract class L
{

    public L()
    {
    }

    public abstract void A(b b1, OutputStream outputstream)
        throws IOException;

    public abstract void A(b b1, InputStream inputstream)
        throws IOException;

    public abstract String A();

    public void B(b b1, String s)
        throws IOException
    {
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        try
        {
            A(b1, fileoutputstream);
        }
        finally
        {
            if(fileoutputstream != null)
            {
                fileoutputstream.flush();
                fileoutputstream.close();
            }
        }
    }

    public void A(b b1, String s)
        throws IOException
    {
        Exception exception;
        FileInputStream fileinputstream = new FileInputStream(s);
        java.net.URL url = b1.e();
        b1.A((new File(s)).toURL());
        try
        {
            A(b1, ((InputStream) (fileinputstream)));
        }
        catch(IOException ioexception)
        {
            b1.A(url);
            throw ioexception;
        }
        finally
        {
            fileinputstream.close();
        }
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_63;
        throw exception;
    }
}
