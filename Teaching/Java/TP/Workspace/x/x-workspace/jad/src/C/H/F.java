// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.J.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package C.H:
//            G, D

public class F extends G
{

    public F()
    {
    }

    public String A()
    {
        return "gif";
    }

    protected void A(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        D d = new D(bufferedimage, outputstream);
        d.A();
    }

    protected BufferedImage A(int i, int j)
    {
        return new BufferedImage(i, j, 2);
    }

    public K E(b b)
    {
        K k = super.E(b);
        m m1 = new m(k);
        m1.A(new Color(255, 255, 255, 0));
        k.B(m1);
        return k;
    }
}
