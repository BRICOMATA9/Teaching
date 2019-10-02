// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import C.J.*;
import java.awt.Graphics2D;

// Referenced classes of package B.B.A:
//            I

public class G extends g
{

    public G()
    {
        DF = 0;
    }

    public G(Y y)
    {
        super(y);
        DF = 0;
        if(y instanceof G)
        {
            G g1 = (G)y;
            E(g1.E9());
        }
    }

    public byte E9()
    {
        return DF;
    }

    public void E(byte byte0)
    {
        DF = byte0;
    }

    protected void D(Graphics2D graphics2d)
    {
        if(I())
            C(graphics2d);
        byte byte0 = E3();
        if(2 == byte0 || 1 == byte0)
            C.J.E.B(graphics2d);
        if(1 == DF && E5() != null && (E4() != 0 || E6() != 0))
        {
            C.J.HA._H _lh = new C.J.HA._H() {

                public void B(Y y, Graphics2D graphics2d1)
                {
                    P(graphics2d1);
                }

                public void A(Y y, Graphics2D graphics2d1)
                {
                }

            };
            I i = new I(_lh);
            i.A(E5());
            i.B(E4());
            i.A(E6());
            i.B(this, graphics2d);
        } else
        {
            M(graphics2d);
            P(graphics2d);
        }
        if(2 == byte0 || 1 == byte0)
            C.J.E.A(graphics2d);
    }

    protected void O(Graphics2D graphics2d)
    {
        byte byte0 = E3();
        java.awt.Color color = graphics2d.getColor();
        if(byte0 == 6)
        {
            java.awt.Color color1 = M();
            if(color1 != null)
            {
                graphics2d.setColor(color1);
                A(graphics2d, true);
            }
        } else
        {
            java.awt.Color color2 = Y();
            C.J.O o = J();
            if(color2 != null && o != null)
            {
                java.awt.Stroke stroke = graphics2d.getStroke();
                graphics2d.setStroke(o);
                graphics2d.setColor(color2);
                if(byte0 == 2)
                {
                    C.J.E.B(graphics2d);
                    graphics2d.draw(DD);
                    C.J.E.A(graphics2d);
                } else
                {
                    graphics2d.draw(DD);
                }
                graphics2d.setStroke(stroke);
            }
        }
        graphics2d.setColor(color);
    }

    void P(Graphics2D graphics2d)
    {
        N(graphics2d);
        A(graphics2d);
        O(graphics2d);
    }

    private byte DF;
}
