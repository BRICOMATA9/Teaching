// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.C;
import C.A.F;
import C.A.J;
import C.A.T;
import C.A.U;
import C.A.Y;
import C.E.S;
import C.G.D;
import C.G.I;
import C.G.M;
import C.G.V;
import C.G.f;
import C.J.A.G;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package C.J:
//            g, c, U, u, 
//            Y, P, DA, N, 
//            FA, K, r, T, 
//            IA, F

public class b extends I
{
    public static interface _A
    {

        public abstract void A(b b1, U u1);

        public abstract void A(b b1, F f1);
    }


    public b()
    {
        A(new g(), new c());
    }

    private void A(C.J.Y y, C.J.U u1)
    {
        a = y;
        b = u1;
        d = new Y();
        c = new Y();
        e = new ArrayList();
        i = new ArrayList();
    }

    public void A(J j1, T t, J j2, int i1, T t1, J j3, int k1)
    {
        super.A(j1, t, j2, i1, t1, j3, k1);
        C.J.U u1 = R(j1);
        if(u1 != null)
            u1.C4();
    }

    public void B(J j1, T t, T t1)
    {
        super.B(j1, t, t1);
        C.J.U u1 = R(j1);
        if(u1 != null)
            u1.C4();
    }

    public void A(G g1)
    {
        g = g1;
    }

    public G h()
    {
        return g;
    }

    public J B(T t, T t1)
    {
        return A(t, t1, b.C7());
    }

    public J A(T t, T t1, C.J.U u1)
    {
        return A(t, ((J) (null)), t1, ((J) (null)), 0, 0, u1);
    }

    public J A(T t, J j1, T t1, J j2, int i1, int k1)
    {
        return A(t, j1, t1, j2, i1, k1, b.C7());
    }

    public J A(T t, J j1, T t1, J j2, int i1, int k1, C.J.U u1)
    {
        u u2 = new u(this, t, j1, t1, j2, i1, k1, u1);
        if(O())
            A(new C(this, (byte)1, u2));
        return u2;
    }

    public T K()
    {
        return B(a.F());
    }

    public T B(C.J.Y y)
    {
        P p = new P(this, y);
        if(O())
            A(new C(this, (byte)0, p));
        return p;
    }

    public Rectangle X()
    {
        Rectangle rectangle = new Rectangle(0, 0, -1, -1);
        for(F f1 = H(); f1.C(); f1.B())
            U(f1.H()).A(rectangle);

        for(U u1 = M(); u1.C(); u1.B())
            R(u1.I()).C(rectangle);

        return rectangle;
    }

    public Rectangle A(byte byte0)
    {
        Rectangle rectangle = new Rectangle(0, 0, -1, -1);
        for(F f1 = H(); f1.C(); f1.B())
            U(f1.H()).A(rectangle, byte0);

        for(U u1 = M(); u1.C(); u1.B())
        {
            C.J.U u2 = R(u1.I());
            if(u2.p() == byte0)
                u2.C(rectangle);
        }

        return rectangle;
    }

    public void A(C.J.Y y)
    {
        a = y;
    }

    public void A(C.J.U u1)
    {
        b = u1;
    }

    public C.J.Y f()
    {
        return a;
    }

    public C.J.U l()
    {
        return b;
    }

    public C.J.Y U(T t)
    {
        return ((P)t).U;
    }

    public C.J.U R(J j1)
    {
        return ((u)j1).L;
    }

    public void A(T t, C.J.Y y)
    {
        C.J.Y y1 = ((P)t).U;
        y.A(t);
        ((P)t).U = y;
        A(t, "realizer", y1, y);
    }

    public void A(J j1, C.J.U u1)
    {
        C.J.U u2 = ((u)j1).L;
        u1.A(j1);
        ((u)j1).L = u1;
        A(j1, "realizer", u2, u1);
    }

    public f S(T t)
    {
        return U(t);
    }

    public M M(J j1)
    {
        return R(j1);
    }

    public V[] R(T t)
    {
        C.J.Y y = U(t);
        V av[] = new V[y.L()];
        for(int i1 = 0; i1 < av.length; i1++)
            av[i1] = y.A(i1);

        return av;
    }

    public D[] I(J j1)
    {
        C.J.U u1 = R(j1);
        D ad[] = new D[u1.w()];
        for(int i1 = 0; i1 < ad.length; i1++)
            ad[i1] = u1.D(i1);

        return ad;
    }

    public T A(V v)
    {
        DA da = (DA)v;
        return da.w();
    }

    public J A(D d1)
    {
        N n = (N)d1;
        return n.AA();
    }

    public void A(J j1, boolean flag)
    {
        R(j1).G(flag);
    }

    public void A(T t, boolean flag)
    {
        U(t).A(flag);
    }

    public boolean S(J j1)
    {
        return R(j1).A4();
    }

    public boolean V(T t)
    {
        return U(t).I();
    }

    public double O(T t)
    {
        return U(t).N();
    }

    public double K(T t)
    {
        return U(t).V();
    }

    public double Q(T t)
    {
        return U(t).C();
    }

    public double J(T t)
    {
        return U(t).A();
    }

    public double M(T t)
    {
        return U(t).B();
    }

    public double T(T t)
    {
        return U(t).D();
    }

    public void D(T t, double d1, double d2)
    {
        U(t).C(d1, d2);
    }

    public void A(T t, double d1, double d2)
    {
        U(t).B(d1, d2);
    }

    public void B(T t, double d1, double d2)
    {
        U(t).A(d1, d2);
    }

    public void A(URL url)
    {
        URL url1 = e();
        _ = url;
        A(this, "URL", url1, url);
    }

    public URL e()
    {
        return _;
    }

    public C.A.I j()
    {
        return c.B();
    }

    public FA i()
    {
        if(f != null)
            return f;
        if(d.size() > 0)
            return (FA)d.F();
        else
            return null;
    }

    public void C(FA fa)
    {
        f = fa;
    }

    public void A(FA fa)
    {
        d.E(fa);
    }

    public void B(FA fa)
    {
        if(i() == fa)
            C(null);
        d.remove(fa);
    }

    public void c()
    {
        for(C.A.I i1 = d.B(); i1.C(); i1.B())
            ((FA)i1.D()).A();

    }

    public void d()
    {
        if(!(i() instanceof K))
        {
            return;
        } else
        {
            ((K)i()).e();
            return;
        }
    }

    public void b()
    {
        N();
        A(H());
        A(M());
        P();
    }

    public void A(U u1)
    {
        if(h != null)
            h.A(this, u1);
    }

    public void A(F f1)
    {
        if(h != null)
            h.A(this, f1);
    }

    public void A(C.J.T t)
    {
        e.add(t);
    }

    public Iterator g()
    {
        return e.iterator();
    }

    public void K(Object obj)
    {
        r r1 = new r(this, obj);
        for(int i1 = 0; i1 < e.size(); i1++)
            ((C.J.T)e.get(i1)).A(r1);

    }

    public void A(C.J.F f1)
    {
        i.add(f1);
    }

    public Iterator k()
    {
        return i.iterator();
    }

    public void A(Object obj, String s, Object obj1, Object obj2)
    {
        IA ia = new IA(this, obj, s, obj1, obj2);
        for(int i1 = 0; i1 < i.size(); i1++)
            ((C.J.F)i.get(i1)).A(ia);

    }

    private C.J.Y a;
    private C.J.U b;
    private Y d;
    private Y c;
    private FA f;
    private URL _;
    private G g;
    private _A h;
    private ArrayList e;
    private ArrayList i;
}
