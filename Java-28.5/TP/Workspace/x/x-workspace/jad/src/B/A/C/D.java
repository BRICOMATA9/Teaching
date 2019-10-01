// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.C;

import C.J.b;
import java.awt.Graphics2D;

// Referenced classes of package B.A.C:
//            E

public class D extends E
{
    private class _B
    {
    }

    private class _A
    {
    }


    public D()
    {
        K = 3;
    }

    public void A(Graphics2D graphics2d, b b)
    {
        F();
        super.A(graphics2d, b);
    }

    public void B(Graphics2D graphics2d, b b)
    {
        F();
        super.B(graphics2d, b);
    }

    protected void F()
    {
        throw new InternalError("Badly shrinked");
    }

    public void A(byte byte0)
    {
        K = byte0;
    }

    private static final _A J[] = new _A[0];
    private static final _B I[] = new _B[0];
    private byte K;

}
