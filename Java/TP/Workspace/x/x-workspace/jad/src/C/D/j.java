// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;


// Referenced classes of package C.D:
//            D, c

public class j extends D
{

    public j(String s, Boolean boolean1)
    {
        super(s, boolean1);
        A(Boolean.TYPE);
    }

    public j(String s, boolean flag)
    {
        this(s, flag ? Boolean.TRUE : Boolean.FALSE);
    }

    public String C()
    {
        return "Bool";
    }

    public void A(Object obj)
    {
        super.A(c.A(obj));
    }

    public void B(String s)
    {
        A(c.A(s));
    }
}
