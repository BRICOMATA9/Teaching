// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.J;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

// Referenced classes of package C.J:
//            EA, U, G, n, 
//            Y, W

public class q
    implements EA._N
{

    public q()
    {
    }

    public byte A(U u, G g, GeneralPath generalpath, Point2D point2d, Point2D point2d1)
    {
        boolean flag = false;
        if(u.C6().H())
        {
            if(g.isEmpty())
            {
                Y y = u.C2();
                u.F(u.k().B(y), u.k().A(y) - 10D - y.D());
            }
            flag = g.size() == 1;
        }
        if(flag)
            return W.C(u, generalpath, point2d, point2d1);
        else
            return W.A(u, generalpath, point2d, point2d1);
    }
}
