// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import C.J.DA;
import C.J.Y;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package B.B.A.C:
//            D, M

class L extends D
    implements M
{

    L()
    {
        O = new ArrayList(1);
    }

    L(L l, Y y)
    {
        super(l, y);
        int i = l.O.size();
        O = new ArrayList(i);
        for(int j = 0; j < i; j++)
        {
            DA da = y.E();
            da.A((DA)l.O.get(j));
            O.add(da);
        }

    }

    public DA B(int i)
    {
        return (DA)O.get(i);
    }

    public double C(Y y)
    {
        double d = 0.0D;
        for(int i = 0; i < O.size(); i++)
            d = Math.max(((DA)O.get(i)).g(), d);

        return d * 1.03D;
    }

    public double A(Y y)
    {
        double d = 0.0D;
        for(int i = 0; i < O.size(); i++)
            d += ((DA)O.get(i)).V();

        return d;
    }

    public void A(java.awt.Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        super.A(graphics2d, y, d, d1, d2, d3);
        for(int i = 0; i < O.size(); i++)
        {
            DA da = (DA)O.get(i);
            da.A(graphics2d);
        }

    }

    public M B(Y y)
    {
        throw new InternalError("Badly shrinked");
    }

    protected List L()
    {
        return O;
    }

    protected void C(Y y, double d, double d1, double d2, 
            double d3)
    {
        double d4 = d;
        for(int i = 0; i < O.size(); i++)
        {
            DA da = (DA)O.get(i);
            da.A(y);
            double d5;
            switch(da.c())
            {
            case 0: // '\0'
                d5 = d;
                break;

            case 1: // '\001'
                d5 = (d + 0.5D * d2) - 0.5D * da.g();
                break;

            case 2: // '\002'
                d5 = (d + d2) - da.g();
                break;

            default:
                d5 = d;
                break;
            }
            da.E(d5 - y.C(), d1 - y.A());
            d1 += da.V();
        }

    }

    List O;
}
