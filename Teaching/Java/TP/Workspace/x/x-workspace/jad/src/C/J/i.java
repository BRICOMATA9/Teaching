// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.I;
import C.A.Y;
import C.K.A;
import java.awt.Graphics2D;
import java.awt.Rectangle;

// Referenced classes of package C.J:
//            V

class i extends Y
    implements V
{

    i()
    {
    }

    public void A(Graphics2D graphics2d)
    {
        for(I j = B(); j.C(); j.B())
            ((V)j.D()).A(graphics2d);

    }

    public Rectangle A()
    {
        if(isEmpty())
            return new Rectangle(0, 0, -1, -1);
        I j = B();
        Rectangle rectangle = ((V)j.D()).A().getBounds();
        j.B();
        for(; j.C(); j.B())
            C.K.A.A(((V)j.D()).A(), rectangle, rectangle);

        return rectangle;
    }
}
