// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;


// Referenced classes of package C.J:
//            EA, f, G, U

public class x
    implements EA._H
{

    public x()
    {
    }

    public f A(U u, G g, double d, double d1, f f1, 
            int i)
    {
        f f2 = new f(u, d, d1);
        A(u, g, f2, f1, i);
        return f2;
    }

    public void A(U u, G g, f f1, f f2, int i)
    {
        if(i == 0)
        {
            if(g.size() > 0 && f2 == g.H())
                g.A(f1, g.G());
            else
                g.A(f1, g.C(f2));
        } else
        if(g.size() > 0 && f2 == g.F())
            g.B(f1, g.I());
        else
            g.B(f1, g.C(f2));
        u.C4();
    }

    public void A(U u, G g, f f1, double d, double d1)
    {
    }
}
