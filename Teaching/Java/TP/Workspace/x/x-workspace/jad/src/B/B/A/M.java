// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import C.J.Y;
import java.awt.Graphics2D;

// Referenced classes of package B.B.A:
//            G

class M extends G
{

    M()
    {
        ED();
    }

    M(Y y)
    {
        super(y);
        if(y instanceof M)
        {
            M m = (M)y;
            if(m.E6 != null)
                E6 = m.E6.B(this);
        }
    }

    void ED()
    {
        throw new InternalError("Badly shrinked");
    }

    void P(Graphics2D graphics2d)
    {
        java.awt.Shape shape = graphics2d.getClip();
        graphics2d.clip(DD);
        if(E6 != null)
            E6.A(graphics2d, this, S, Q, F, T);
        graphics2d.setClip(shape);
        O(graphics2d);
    }

    B.B.A.C.M E6;
}
