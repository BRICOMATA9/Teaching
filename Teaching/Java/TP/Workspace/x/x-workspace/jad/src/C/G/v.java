// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.K.M;
import java.util.ArrayList;

// Referenced classes of package C.G:
//            M

public class v
    implements C.G.M
{

    public v()
    {
        e = M.B;
        f = M.B;
        g = new ArrayList(5);
    }

    public v(C.G.M m)
    {
        this();
        for(int i = 0; i < m.e(); i++)
            g.add(m.B(i));

        e = m.f();
        f = m.g();
    }

    public int e()
    {
        return g.size();
    }

    public M B(int i)
    {
        return (M)g.get(i);
    }

    public void A(int i, double d1, double d2)
    {
        g.set(i, new M(d1, d2));
    }

    public void E(double d1, double d2)
    {
        g.add(new M(d1, d2));
    }

    public void d()
    {
        g.clear();
    }

    public M f()
    {
        return e;
    }

    public M g()
    {
        return f;
    }

    public void A(M m)
    {
        e = m;
    }

    public void B(M m)
    {
        f = m;
    }

    private ArrayList g;
    private M e;
    private M f;
}
