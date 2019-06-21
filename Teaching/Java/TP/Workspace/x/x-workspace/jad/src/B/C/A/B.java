// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.C.A;

import C.A.F;
import C.A.U;
import C.H.C;
import C.H.N;
import C.J.K;
import C.J.Y;
import C.J.b;
import C.J.k;
import C.K.M;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.OutputStream;
import org.freehep.graphics2d.AbstractVectorGraphics;
import org.freehep.graphicsio.swf.YSWFGraphics2D;

// Referenced classes of package B.C.A:
//            A

public class B extends A
{

    public B()
    {
        M = 7;
        L = null;
        K = 10D;
    }

    public void A(int i)
    {
        switch(i)
        {
        case 7: // '\007'
        case 8: // '\b'
            M = i;
            break;

        default:
            throw new IllegalArgumentException(Integer.toString(i));
        }
    }

    public String A()
    {
        return "swf";
    }

    AbstractVectorGraphics A(OutputStream outputstream, Dimension dimension)
    {
        YSWFGraphics2D yswfgraphics2d = new YSWFGraphics2D(outputstream, dimension);
        yswfgraphics2d.setSWFVersion(M);
        return yswfgraphics2d;
    }

    void A(AbstractVectorGraphics abstractvectorgraphics, K k1)
        throws IOException
    {
        abstractvectorgraphics.startExport();
        k1.F(abstractvectorgraphics);
        if(null != L && (abstractvectorgraphics instanceof YSWFGraphics2D))
        {
            java.awt.geom.AffineTransform affinetransform = abstractvectorgraphics.getTransform();
            abstractvectorgraphics.scale(k1.h(), k1.h());
            abstractvectorgraphics.translate(-k1.k().getX(), -k1.k().getY());
            A((YSWFGraphics2D)abstractvectorgraphics, k1, L);
            abstractvectorgraphics.setTransform(affinetransform);
        }
        abstractvectorgraphics.endExport();
    }

    protected void A(YSWFGraphics2D yswfgraphics2d, K k1, N n)
    {
        b b1 = k1.d();
        for(F f = b1.H(); f.C(); f.B())
        {
            C.A.T t = f.H();
            Y y = b1.U(t);
            C c = n.A(t);
            if(null != c)
                A(yswfgraphics2d, c, y);
            for(int i = 0; i < y.L(); i++)
            {
                C.J.DA da = y.A(i);
                C c1 = n.A(da);
                if(null != c1)
                    A(yswfgraphics2d, c1, ((k) (da)));
            }

        }

        for(U u = b1.M(); u.C(); u.B())
        {
            C.A.J j = u.I();
            C.J.U u1 = b1.R(j);
            C c2 = n.A(j);
            if(null != c2)
                A(yswfgraphics2d, c2, u1);
            for(int l = 0; l < u1.w(); l++)
            {
                C.J.N n1 = u1.D(l);
                C c3 = n.A(n1);
                if(null != c3)
                    A(yswfgraphics2d, c3, ((k) (n1)));
            }

        }

    }

    protected void A(YSWFGraphics2D yswfgraphics2d, C c, Y y)
    {
        java.awt.geom.Rectangle2D.Double double1 = y.X();
        yswfgraphics2d.writeLink(c.B("swf_url"), c.B("swf_target"), double1);
    }

    protected void A(YSWFGraphics2D yswfgraphics2d, C c, C.J.U u)
    {
        Object obj = u.B5();
        BasicStroke basicstroke = new BasicStroke((float)K, 0, 0, 1.41F);
        obj = basicstroke.createStrokedShape(((java.awt.Shape) (obj)));
        yswfgraphics2d.writeLink(c.B("swf_url"), c.B("swf_target"), ((java.awt.Shape) (obj)));
    }

    protected void A(YSWFGraphics2D yswfgraphics2d, C c, k k1)
    {
        M m = k1._();
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(m.B(), m.A(), k1.g(), k1.V());
        yswfgraphics2d.writeLink(c.B("swf_url"), c.B("swf_target"), double1);
    }

    public void A(N n)
    {
        L = n;
    }

    private N L;
    private double K;
    private int M;
}
