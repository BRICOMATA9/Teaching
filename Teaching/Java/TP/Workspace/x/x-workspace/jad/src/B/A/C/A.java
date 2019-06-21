// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.C;

import C.J.b;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package B.A.C:
//            C

public class A extends C
{

    public A()
    {
    }

    public String B()
    {
        return "SVGZ Format";
    }

    public String A()
    {
        return "svgz";
    }

    public void A(b b, OutputStream outputstream)
        throws IOException
    {
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(outputstream);
        super.A(b, gzipoutputstream);
        gzipoutputstream.finish();
    }
}
