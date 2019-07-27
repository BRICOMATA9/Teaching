// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.J;
import C.A.M;
import C.E.T;
import C.G.c;
import C.G.f;

// Referenced classes of package C.J:
//            b, Y

public class v extends T
    implements M
{
    static final class _A
        implements c
    {

        public C.K.M A(f f1, double d, double d1, double d2, 
                double d3)
        {
            Y y;
            if(E)
                y = F.U(D.G());
            else
                y = F.U(D.E());
            double d4 = y.N();
            double d5 = y.V();
            if(y.D(d4 + d, d5 + d1))
                return null;
            if(y.B() != f1.B() || y.D() != f1.D())
                return null;
            double d6 = (d4 + d) - d2 * 5D;
            double d7 = (d5 + d1) - d3 * 5D;
            double d8 = 10D + Math.max(y.B(), y.D());
            double d9 = d4;
            double d10 = d5;
            double d11 = 0.0D;
            do
            {
                if(d11 >= d8 * 2D)
                    break;
                double d12 = d6 + d2 * d11;
                double d13 = d7 + d3 * d11;
                if(y.D(d12, d13))
                {
                    d9 = d12;
                    d10 = d13;
                    d6 = d9 - d2 * 2D;
                    d7 = d10 - d3 * 2D;
                    break;
                }
                d11++;
            } while(true);
            if(y.D(d9, d10))
                if(y.A(d9, d10, d6, d7, C))
                    return new C.K.M(C.x - d4, C.y - d5);
                else
                    return new C.K.M(d, d1);
            if(G)
            {
                if(y.A(d4, d5, d6, d7, C))
                    return new C.K.M(C.x - d4, C.y - d5);
                else
                    return new C.K.M(d, d1);
            } else
            {
                return null;
            }
        }

        private b F;
        private boolean E;
        private boolean G;
        J D;
        java.awt.geom.Point2D.Double C;

        public _A(b b1, boolean flag, boolean flag1)
        {
            C = new java.awt.geom.Point2D.Double();
            F = b1;
            E = flag1;
            G = flag;
        }
    }


    public v(b b, boolean flag)
    {
        this(b, true, flag);
    }

    public v(b b, boolean flag, boolean flag1)
    {
        if(b == null)
        {
            throw new NullPointerException();
        } else
        {
            w = new _A(b, flag, flag1);
            return;
        }
    }

    public Object D(Object obj)
    {
        if(!(obj instanceof J))
        {
            return null;
        } else
        {
            J j = (J)obj;
            w.D = j;
            return w;
        }
    }

    private _A w;
}
