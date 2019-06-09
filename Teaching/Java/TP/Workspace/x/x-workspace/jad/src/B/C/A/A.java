// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.C.A;

import C.H.L;
import C.J.K;
import C.J.b;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.*;
import java.util.*;
import org.freehep.graphics2d.AbstractVectorGraphics;

public abstract class A extends L
{

    A()
    {
        I = "yExport 1.1";
    }

    public void A(b b1, InputStream inputstream)
        throws IOException
    {
        throw new UnsupportedOperationException("Can't read " + A().toUpperCase() + " format");
    }

    public void A(b b1, OutputStream outputstream)
        throws IOException
    {
        K k = (K)b1.i();
        K k1;
        if(k == null)
            k1 = B(b1);
        else
            k1 = k;
        Dimension dimension = k1.j();
        AbstractVectorGraphics abstractvectorgraphics = A(outputstream, dimension);
        abstractvectorgraphics.setCreator(H());
        if(!J.isEmpty())
        {
            java.util.Map.Entry entry;
            java.awt.RenderingHints.Key key;
            for(Iterator iterator = J.entrySet().iterator(); iterator.hasNext(); abstractvectorgraphics.setRenderingHint(key, entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                key = (java.awt.RenderingHints.Key)entry.getKey();
            }

        }
        A(abstractvectorgraphics, k1);
        if(k1 != k)
            b1.B(k1);
    }

    public K B(b b1)
    {
        K k = new K(b1);
        Rectangle rectangle = b1.X();
        Dimension dimension = new Dimension(rectangle.width, rectangle.height);
        k.setSize(dimension);
        k.setPreferredSize(dimension);
        k.B(rectangle.x - 10, rectangle.y - 10, rectangle.width + 20, rectangle.height + 20);
        k.C(0.0D);
        return k;
    }

    public String H()
    {
        return I;
    }

    abstract AbstractVectorGraphics A(OutputStream outputstream, Dimension dimension);

    void A(AbstractVectorGraphics abstractvectorgraphics, K k)
        throws IOException
    {
        throw new InternalError("Badly shrinked");
    }

    private static Map I()
    {
        return new HashMap();
    }

    final Map J = I();
    String I;
}
