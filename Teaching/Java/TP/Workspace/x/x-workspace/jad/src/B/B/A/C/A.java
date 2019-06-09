// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.F;
import C.A.M;
import C.J.DA;
import C.J.Y;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;

// Referenced classes of package B.B.A.C:
//            L, F, O, M

class A extends L
{

    A(F f, Y y, M m)
    {
        B((Color)m.D("header.fill.color"));
        A((Color)m.D("header.gradient.color"));
        DA da = y.H();
        da.D(0.0D);
        da.A(new Insets(2, 6, 2, 6));
        da.B((byte)1);
        O.add(da);
        da.B(f.G());
        da.C((Color)m.D("name.label.text.color"));
        da.A((Font)m.D("name.label.font"));
        P = B(m.D("header.style"));
        Q = !"soft".equals(m.D("shadow.style"));
        switch(P)
        {
        case 0: // '\0'
            da.F((byte)102);
            break;

        case 1: // '\001'
            da.F((byte)117);
            break;

        case 2: // '\002'
            da.F((byte)102);
            break;

        case 4: // '\004'
            da.F((byte)118);
            break;

        case 3: // '\003'
        default:
            da.F((byte)102);
            break;
        }
    }

    A(A a, Y y)
    {
        super(a, y);
        P = a.P;
        Q = a.Q;
        DA da = y.H();
        da.A((DA)a.O.get(0));
        O.add(da);
    }

    byte M()
    {
        return P;
    }

    public B.B.A.C.M B(Y y)
    {
        return new A(this, y);
    }

    public double C(Y y)
    {
        return super.C(y) * 1.03D + 4D;
    }

    public void A(Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        double d4 = 0 != P ? C(y) : d2;
        double d5 = Math.min(d3 + 18D, (y.A() + y.D()) - d1 - 1.0D);
        double d6;
        if(2 == P)
            d6 = 0.5D * (d2 - d4);
        else
        if(4 == P)
            d6 = d2 - d4;
        else
            d6 = 0.0D;
        O o = F.A().B;
        o.B(y);
        boolean flag = 0 == o.E3();
        o.B(d + d6, d1, d4, flag ? d3 : d5);
        o.B(J());
        o.C(I());
        if(Q)
            o.M(graphics2d);
        o.N(graphics2d);
        B(((Color) (null)));
        A(null);
        super.A(graphics2d, y, d + d6, d1, d4, d3);
        A(o.U());
        B(o.M());
        o.O(graphics2d);
    }

    protected void C(Y y, double d, double d1, double d2, 
            double d3)
    {
    }

    private static byte B(Object obj)
    {
        if(obj instanceof String)
        {
            String s = ((String)obj).toLowerCase();
            if("left_tab".equals(s))
                return 1;
            if("center_tab".equals(s))
                return 2;
            if("right_tab".equals(s))
                return 4;
        }
        return 0;
    }

    private byte P;
    private final boolean Q;
}
