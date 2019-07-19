// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.B.*;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package B.B.A:
//            N

public class A
    implements N
{

    public A()
    {
        B = ":";
        A = ":";
        D = ":";
        C = ",";
    }

    public String A()
    {
        return B;
    }

    public void D(String s)
    {
        B = s;
    }

    public String D()
    {
        return A;
    }

    public void B(String s)
    {
        A = s;
    }

    public String B()
    {
        return D;
    }

    public void A(String s)
    {
        D = s;
    }

    public String C()
    {
        return C;
    }

    public void C(String s)
    {
        C = s;
    }

    public String A(H h)
    {
        if(h instanceof B)
            return A((B)h);
        if(h instanceof G)
            return A((G)h);
        else
            return null;
    }

    public String A(B b)
    {
        String s = b.C();
        if((b.A() & 8) != 0 && b.B() != null && !"".equals(b.B()))
            s = s + A() + A(b.B(), B(b));
        return s;
    }

    public String A(G g)
    {
        String s = g.C();
        List list = g.E();
        String s1 = "(";
        boolean flag = B(g);
        if(list != null && (g.A() & 0x20) != 0)
        {
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                I i = (I)iterator.next();
                boolean flag1 = false;
                if(i.B() != null && i.B().length() > 0)
                {
                    s1 = s1 + i.B();
                    flag1 = true;
                }
                if(i.A() != null && i.A().length() > 0)
                {
                    if(flag1)
                        s1 = s1 + D();
                    s1 = s1 + A(i.A(), flag);
                }
                if(iterator.hasNext())
                    s1 = s1 + C();
            } while(true);
        }
        s1 = s1 + ")";
        s = s + s1;
        if((g.A() & 8) != 0 && g.B() != null && g.B().length() > 0)
            s = s + B() + A(g.B(), flag);
        return s;
    }

    protected boolean B(B b)
    {
        return A(b.A());
    }

    protected boolean B(G g)
    {
        return A(g.A());
    }

    boolean A(int i)
    {
        return (i & 0x40) != 0;
    }

    String A(String s, boolean flag)
    {
        if(!flag)
        {
            int i = s.lastIndexOf('.');
            if(i > 0)
                return s.substring(i + 1);
        }
        return s;
    }

    String B;
    String A;
    String D;
    String C;
}
