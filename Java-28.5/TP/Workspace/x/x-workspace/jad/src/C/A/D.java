// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;

import C.E.*;
import java.util.*;

// Referenced classes of package C.A:
//            B, V, O, T, 
//            C, J, S, A, 
//            F, U, W, M, 
//            K, L

public class D
    implements B
{

    protected final boolean O()
    {
        return G != null && !G.isEmpty();
    }

    public D()
    {
        C = new V();
        E = new V();
        I = new O(3, 5);
        D = new O(3, 5);
        F = false;
        B = false;
        A = new HashMap(11);
    }

    public T K()
    {
        T t = new T(this);
        if(G != null)
            A(C.A.C.A(this, t));
        return t;
    }

    public J B(T t, T t1)
    {
        return A(t, null, t1, null, 0, 0);
    }

    public J A(T t, J j, T t1, J j1, int i, int k)
    {
        J j2 = new J(this, t, j, t1, j1, i, k);
        if(G != null)
            A(C.A.C.C(this, j2));
        return j2;
    }

    public void A(T t)
    {
        C(t);
    }

    private void C(T t)
    {
        if(t._() != this)
            throw new IllegalArgumentException("Node not in this graph.");
        if(G != null)
        {
            N();
            A(C.A.C.D(this, t));
        }
        J j;
        while((j = t.S) != null) 
            E(j);
        while((j = t.R) != null) 
            E(j);
        C.C(t);
        t.M = null;
        F = true;
        if(G != null)
        {
            A(C.A.C.C(this, t));
            P();
        }
    }

    public void E(J j)
    {
        F(j);
    }

    private void F(J j)
    {
        if(j.K() != this)
            throw new IllegalArgumentException("edge is not in graph");
        if(G != null)
            A(C.A.C.B(this, j));
        T t = j.G();
        T t1 = j.E();
        A(j, t, t1);
        E.C(j);
        j.A(null);
        B = true;
        if(G != null)
            A(C.A.C.A(this, j));
    }

    public void D(T t)
    {
        if(t._() != null)
            throw new IllegalArgumentException("Node " + t + " already in a graph!!!");
        t.O = C.E();
        t.B(this);
        t.O();
        if(t.B.length < I.B)
            I.A(t, t.B.length, I.B);
        C.A(t);
        F = true;
        if(G != null)
            A(C.A.C.B(this, t));
    }

    public void G(J j)
    {
        if(j.K() != null)
            throw new IllegalArgumentException("Edge " + j + " already in a graph!!!");
        if(j.G()._() != this)
            throw new IllegalArgumentException("Source of edge " + j + " not in graph");
        if(j.E()._() != this)
            throw new IllegalArgumentException("Target of edge " + j + " not in graph");
        if(j.B.length < D.B)
            D.A(j, j.B.length, D.B);
        if(j.A() == null || ((J)j.A()).K() != this)
            E.A(j);
        else
            E.A(j, j.A(), 1);
        j.A(this);
        j.D();
        A(j, j.G(), null, j.E(), ((J) (null)), 0, 0);
        B = true;
        if(G != null)
            A(C.A.C.D(this, j));
    }

    public void A(J j, J j1, J j2, int i, int k)
    {
        A(j, j.G(), j1, i, j.E(), j2, k);
    }

    public void A(J j, T t, J j1, int i, T t1, J j2, int k)
    {
        if(G != null)
            A(new C(this, (byte)8, j));
        T t2 = j.G();
        T t3 = j.E();
        if(j == j1)
            j1 = i != 0 ? j1.F() : j1.J();
        if(j == j2)
            j2 = k != 0 ? j2.C() : j2.I();
        A(j, t2, t3);
        if(j1 == null)
            j.H = t;
        else
            j.H = j1.G();
        if(j2 == null)
            j.I = t1;
        else
            j.I = j2.E();
        A(j, j.H, j1, j.I, j2, i, k);
        if(G != null)
            A(new C(this, (byte)9, j));
    }

    public void B(J j, T t, T t1)
    {
        if(G != null)
            A(new C(this, (byte)8, j));
        T t2 = j.G();
        T t3 = j.E();
        if(j.K() == null)
        {
            j.H = t;
            j.I = t1;
        } else
        {
            if(t2 != t)
            {
                t2.F(j);
                j.H = t;
                t.E(j);
            }
            if(t3 != t1)
            {
                t3.A(j);
                j.I = t1;
                t1.B(j);
            }
        }
        if(G != null)
            A(new C(this, (byte)9, j));
    }

    public void D(J j)
    {
        B(j, j.E(), j.G());
    }

    public void B(J j)
    {
        ArrayList arraylist = G;
        G = null;
        F(j);
        G = arraylist;
    }

    public void C(J j)
    {
        ArrayList arraylist = G;
        G = null;
        G(j);
        G = arraylist;
    }

    public void G(T t)
    {
        ArrayList arraylist = G;
        G = null;
        A(t);
        G = arraylist;
    }

    public void H(T t)
    {
        ArrayList arraylist = G;
        G = null;
        D(t);
        G = arraylist;
    }

    public void F(T t)
    {
        if(t._() != this)
        {
            throw new IllegalArgumentException("Node not in this graph.");
        } else
        {
            C.C(t);
            C.A(t, C.C(), 1);
            F = true;
            return;
        }
    }

    public int I()
    {
        return C.E();
    }

    public int G()
    {
        return C.E();
    }

    public int S()
    {
        return E.E();
    }

    public int F()
    {
        return E.E();
    }

    public boolean J()
    {
        return C.F();
    }

    public void R()
    {
        N();
        for(; !C.F(); A((T)C.D()));
        P();
    }

    public boolean E(T t)
    {
        return t._() == this;
    }

    public boolean A(J j)
    {
        return j.K() == this;
    }

    public boolean A(T t, T t1)
    {
        if(t._() != this)
            throw new IllegalArgumentException("source not in this graph.");
        else
            return t.D(t1) != null;
    }

    public T L()
    {
        return (T)C.D();
    }

    public T[] U()
    {
        T at[] = new T[G()];
        for(T t = (T)C.D(); t != null; t = (T)t.C)
            at[t.Q()] = t;

        return at;
    }

    public J[] Q()
    {
        J aj[] = new J[F()];
        for(J j = (J)E.D(); j != null; j = (J)j.C)
            aj[j.L()] = j;

        return aj;
    }

    public F H()
    {
        return C.A();
    }

    public U M()
    {
        return E.A();
    }

    public A A(C.A.S s, D d)
    {
        F f = s.O();
        A a = new A();
        byte abyte0[] = new byte[I()];
        for(; f.C(); f.B())
        {
            T t = f.H();
            abyte0[t.Q()] = 1;
        }

        f.E();
        for(; f.C(); f.B())
        {
            T t1 = f.H();
            for(U u = t1.R(); u.C(); u.B())
                if(abyte0[u.I().A(t1).Q()] == 0)
                {
                    a.B(u.I());
                    E(u.I());
                }

        }

        abyte0 = null;
        f.E();
        for(; f.C(); f.B())
        {
            T t2 = f.H();
            for(U u1 = t2.Z(); u1.C(); u1.B())
            {
                J j = u1.I();
                E.C(j);
                j.A(d);
                if(j.B.length < d.D.B)
                    d.D.A(j, j.B.length, d.D.B);
                d.E.A(u1.I());
            }

            C.C(t2);
            t2.B(d);
            if(t2.B.length < d.I.B)
                d.I.A(t2, t2.B.length, d.I.B);
            d.C.A(t2);
        }

        if(G != null)
            A(new C(this, (byte)11, s));
        if(d.G != null)
            d.A(new C(d, (byte)10, s));
        B = true;
        F = true;
        d.F = true;
        d.B = true;
        return a;
    }

    public void A(Comparator comparator)
    {
        if(comparator != null && !C.F())
        {
            T at[] = U();
            Arrays.sort(at, comparator);
            C.B();
            for(int i = 0; i < at.length; i++)
            {
                T t = at[i];
                C.A(t);
                t.O = i;
            }

            F = false;
        }
    }

    public void A(Comparator comparator, Comparator comparator1)
    {
        if(comparator == null && comparator1 == null)
            return;
        J aj[] = new J[S()];
        if(comparator != null && comparator1 != null)
        {
            for(T t = (T)C.D(); t != null; t = (T)t.C)
            {
                t.A(comparator, aj);
                t.B(comparator1, aj);
            }

        } else
        if(comparator1 == null && comparator != null)
        {
            for(T t1 = (T)C.D(); t1 != null; t1 = (T)t1.C)
                t1.A(comparator, aj);

        } else
        if(comparator1 != null && comparator == null)
        {
            for(T t2 = (T)C.D(); t2 != null; t2 = (T)t2.C)
                t2.B(comparator1, aj);

        }
    }

    public synchronized void A(W w)
    {
        if(G == null)
            G = new ArrayList();
        G.add(w);
    }

    public Iterator E()
    {
        if(G == null)
            return (new ArrayList(1)).iterator();
        else
            return (new ArrayList(G)).iterator();
    }

    public void N()
    {
        if(G != null)
            A(C.A.C.B(this));
    }

    public void P()
    {
        if(G != null)
            A(C.A.C.A(this));
    }

    protected void A(C c)
    {
        if(G != null)
        {
            for(int i = 0; i < G.size(); i++)
                ((W)G.get(i)).A(c);

        }
    }

    public K W()
    {
        return I.B(C, "ANONYMOUS");
    }

    public L V()
    {
        return D.A(E, "ANONYMOUS");
    }

    public void A(K k)
    {
        I.A(k, C);
    }

    public void A(L l)
    {
        D.A(l, E);
    }

    public Object A(Object obj)
    {
        return ((J)obj).G();
    }

    public Object C(Object obj)
    {
        return ((J)obj).E();
    }

    public Iterator B()
    {
        return C.E.G.A(H());
    }

    public Iterator C()
    {
        return C.E.G.A(M());
    }

    public C.A.M B(Object obj)
    {
        return (C.A.M)A.get(obj);
    }

    public void A(Object obj, C.A.M m)
    {
        if(m == null)
        {
            throw new IllegalArgumentException("DataProvider must be non-null!");
        } else
        {
            A.put(obj, m);
            return;
        }
    }

    public void D(Object obj)
    {
        A.remove(obj);
    }

    public Object[] A()
    {
        return A.keySet().toArray();
    }

    private void A(J j, T t, J j1, T t1, J j2, int i, int k)
    {
        t.B(j, j1, i);
        t1.A(j, j2, k);
    }

    private void A(J j, T t, T t1)
    {
        t.F(j);
        t1.A(j);
    }

    void T()
    {
        int i = 0;
        for(T t = (T)C.D(); t != null; t = (T)t.C)
            t.O = i++;

        F = false;
    }

    void D()
    {
        int i = 0;
        for(J j = (J)E.D(); j != null; j = (J)j.C)
            j.F = i++;

        B = false;
    }

    void B(T t)
    {
        t.A(this, I.B);
        t.O = C.E();
        C.A(t);
    }

    void B(J j, T t, J j1, T t1, J j2, int i, int k)
    {
        if(t._() != this || t1._() != this)
            throw new IllegalArgumentException("Both endpoints must reside in this graph.");
        if(j1 != null && j1.G() != t)
            throw new IllegalArgumentException("v must be source of e1.");
        if(j2 != null && j2.E() != t1)
        {
            throw new IllegalArgumentException("w must be target of e2.");
        } else
        {
            j.A(this, t, t1, D.B);
            j.F = E.E();
            E.A(j);
            A(j, j.G(), j1, j.E(), j2, i, k);
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(128 + 4 * I() + 4 * S());
        stringbuffer.append("nodes #").append(G()).append(" [");
        Object obj = H();
        do
        {
            if(!((F) (obj)).C())
                break;
            stringbuffer.append(((F) (obj)).H().toString());
            ((F) (obj)).B();
            if(((F) (obj)).C())
            {
                stringbuffer.append(',');
                stringbuffer.append(' ');
            }
        } while(true);
        stringbuffer.append("]\nedges #").append(F()).append(" [");
        obj = M();
        do
        {
            if(!((U) (obj)).C())
                break;
            stringbuffer.append(((U) (obj)).I().toString());
            ((U) (obj)).B();
            if(((U) (obj)).C())
            {
                stringbuffer.append(',');
                stringbuffer.append(' ');
            }
        } while(true);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }

    V C;
    V E;
    boolean F;
    boolean B;
    private O I;
    private O D;
    private HashMap A;
    private static final C.E.S._A H = new C.E.S._A() {

    };
    private ArrayList G;

    static 
    {
        new M();
    }
}
