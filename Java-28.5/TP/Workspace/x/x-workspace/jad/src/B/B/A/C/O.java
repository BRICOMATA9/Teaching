// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.A.G;
import C.J.Y;
import C.J.g;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;

final class O extends G
{

    O()
    {
    }

    protected void D(Graphics2D graphics2d)
    {
        super.D(graphics2d);
    }

    protected void N(Graphics2D graphics2d)
    {
        super.N(graphics2d);
    }

    protected void O(Graphics2D graphics2d)
    {
        super.O(graphics2d);
    }

    protected void M(Graphics2D graphics2d)
    {
        super.M(graphics2d);
    }

    void B(Y y)
    {
        B(null);
        C(null);
        A(y.Y());
        A(y.J());
        D((byte)0);
        F(null);
        if(y instanceof G)
        {
            G g1 = (G)y;
            D(g1.E3());
            F(g1.E5());
            B(g1.E4());
            C(g1.E6());
            E(g1.E9());
        } else
        if(y instanceof g)
        {
            g g2 = (g)y;
            D(g2.E3());
            F(g2.E5());
            B(g2.E4());
            C(g2.E6());
        }
    }

    void E(int i)
    {
        PathIterator pathiterator = (new java.awt.geom.RoundRectangle2D.Double(S, Q, F, T, 8D, 8D)).getPathIterator(null);
        float af[] = new float[6];
        GeneralPath generalpath = new GeneralPath(pathiterator.getWindingRule());
        byte byte0 = 0;
        for(; !pathiterator.isDone(); pathiterator.next())
            switch(pathiterator.currentSegment(af))
            {
            default:
                break;

            case 0: // '\0'
                generalpath.moveTo(af[0], af[1]);
                break;

            case 1: // '\001'
                generalpath.lineTo(af[0], af[1]);
                break;

            case 2: // '\002'
                if(A(byte0, i))
                {
                    A(generalpath, byte0);
                    generalpath.lineTo(af[2], af[3]);
                } else
                {
                    generalpath.quadTo(af[0], af[1], af[2], af[3]);
                }
                byte0++;
                break;

            case 3: // '\003'
                if(A(byte0, i))
                {
                    A(generalpath, byte0);
                    generalpath.lineTo(af[4], af[5]);
                } else
                {
                    generalpath.curveTo(af[0], af[1], af[2], af[3], af[4], af[5]);
                }
                byte0++;
                break;

            case 4: // '\004'
                generalpath.closePath();
                break;
            }

        DD = generalpath;
    }

    private void A(GeneralPath generalpath, byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            generalpath.lineTo((float)S, (float)(Q + T));
            break;

        case 1: // '\001'
            generalpath.lineTo((float)(S + F), (float)(Q + T));
            break;

        case 2: // '\002'
            generalpath.lineTo((float)(S + F), (float)Q);
            break;

        case 3: // '\003'
            generalpath.lineTo((float)S, (float)Q);
            break;
        }
    }

    private static boolean A(byte byte0, int i)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return (i & 1) != 0;

        case 1: // '\001'
            return (i & 2) != 0;

        case 2: // '\002'
            return (i & 4) != 0;

        case 3: // '\003'
            return (i & 8) != 0;
        }
        return false;
    }
}
