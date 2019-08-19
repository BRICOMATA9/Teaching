// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.G.C.C;
import C.G.D.A;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package C.G:
//            j, i, a, w, 
//            A, H, k, I

public abstract class d
    implements j
{
    class _A
        implements j
    {

        public void A(I l)
        {
            B(l);
        }

        _A()
        {
        }
    }


    public d()
    {
        i = true;
        e = true;
        j = true;
        f = false;
        Y = true;
        X = false;
        h = true;
        a = new ArrayList(5);
        V = new ArrayList(5);
        W = new i();
        c = new a();
        d = new w();
        _ = new C.G.A();
        g = new H();
        b = new C();
        Z = new A();
    }

    protected abstract void B(I l);

    public k R()
    {
        return b;
    }

    public void A(k k1)
    {
        b = k1;
    }

    public k Q()
    {
        return d;
    }

    public void B(k k1)
    {
        d = k1;
    }

    public k P()
    {
        return g;
    }

    public void O(boolean flag)
    {
        e = flag;
    }

    public void N(boolean flag)
    {
        X = flag;
    }

    public void M(boolean flag)
    {
        h = flag;
    }

    public void P(boolean flag)
    {
        j = flag;
    }

    public void L(boolean flag)
    {
        i = flag;
    }

    private j S()
    {
        Object obj = new _A();
        for(int l = V.size() - 1; l >= 0; l--)
        {
            k k1 = (k)V.get(l);
            k1.A(((j) (obj)));
            obj = k1;
        }

        if(e)
        {
            W.A(((j) (obj)));
            obj = W;
        }
        if(i)
        {
            c.A(((j) (obj)));
            obj = c;
        }
        if(Y)
        {
            g.A(((j) (obj)));
            obj = g;
        }
        if(X)
        {
            b.A(((j) (obj)));
            obj = b;
        }
        if(j)
        {
            d.A(((j) (obj)));
            obj = d;
        }
        if(f)
        {
            _.A(((j) (obj)));
            obj = _;
        }
        if(h)
        {
            Z.A(((j) (obj)));
            obj = Z;
        }
        for(int i1 = 0; i1 < a.size(); i1++)
        {
            k k2 = (k)a.get(i1);
            k2.A(((j) (obj)));
            obj = k2;
        }

        return ((j) (obj));
    }

    public void A(I l)
    {
        j j1 = S();
        j1.A(l);
    }

    private k W;
    private k c;
    private k d;
    private k _;
    private k g;
    private k b;
    private k Z;
    boolean i;
    boolean e;
    boolean j;
    boolean f;
    boolean Y;
    boolean X;
    boolean h;
    List a;
    List V;
}
