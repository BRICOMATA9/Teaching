// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package C.H:
//            C

public class N
{

    public N()
    {
        B = "";
    }

    public String B()
    {
        return B;
    }

    public void A(String s)
    {
        B = s;
    }

    public C A(Object obj)
    {
        return (C)A.get(obj);
    }

    public void A(Object obj, C c)
    {
        A.put(obj, c);
    }

    public void A()
    {
        B = "";
        A.clear();
    }

    private String B;
    private final Map A = new HashMap();
}
