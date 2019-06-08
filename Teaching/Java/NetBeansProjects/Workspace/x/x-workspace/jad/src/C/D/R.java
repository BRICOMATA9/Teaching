// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.util.Vector;

// Referenced classes of package C.D:
//            X, Z, F

public class R extends Vector
    implements X
{

    public R(String s)
    {
        C = s;
    }

    public void A(String s, Object obj)
    {
        D.C(s, obj);
    }

    public String A()
    {
        return C;
    }

    public F A(int i)
    {
        return (F)elementAt(i);
    }

    public static final String B = "OptionSection.context";
    public static final String A = "OptionSection.longDescription";
    String C;
    private final Z D = new Z(this);

}
