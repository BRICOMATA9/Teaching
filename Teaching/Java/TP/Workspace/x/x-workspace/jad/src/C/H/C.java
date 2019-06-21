// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.util.*;

public class C
{

    public C()
    {
        A = new HashMap(1);
    }

    public String B(String s)
    {
        return (String)A.get(s);
    }

    public boolean A(String s)
    {
        return A.containsKey(s);
    }

    public void A(String s, String s1)
    {
        A.put(s, s1);
    }

    public Iterator A()
    {
        return A.keySet().iterator();
    }

    private Map A;
}
