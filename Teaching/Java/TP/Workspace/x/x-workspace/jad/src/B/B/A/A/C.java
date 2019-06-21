// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import B.B.A.F;
import B.B.B.*;
import java.util.Map;
import javax.swing.Icon;

// Referenced classes of package B.B.A.A:
//            D

public class C
    implements F
{

    public C()
    {
    }

    public void A(Map map)
    {
        B = map;
    }

    public Icon A(H h)
    {
        return A(h, 1.0F);
    }

    public Icon A(H h, float f)
    {
        D d = new D();
        if(h instanceof G)
        {
            String s = h.B();
            if(s == null || s.length() == 0)
                d.A((byte)3);
            else
                d.A((byte)1);
        } else
        if(h instanceof B)
            d.A((byte)2);
        d.A(h.D());
        d.A(f);
        if(B != null)
            d.A(B);
        return d;
    }

    private Map B;
}
