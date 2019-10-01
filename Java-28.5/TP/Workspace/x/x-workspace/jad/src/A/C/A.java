// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.C;

import B.B.B.B;
import B.B.B.D;
import B.B.B.E;
import B.B.B.F;
import B.B.B.I;
import C.A.J;
import C.A.K;
import C.A.L;
import C.A.M;
import C.A.T;
import C.A.U;
import C.E.V;
import C.F.C;
import C.J.A.G;
import C.J.DA;
import C.J.O;
import C.J.Y;
import C.J.b;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

// Referenced classes of package A.C:
//            C

public class A
{
    private static final class _E extends C.E.T
    {

        public Object D(Object obj)
        {
            return j.A();
        }

        private final A.C.C j;

        _E(A.C.C c)
        {
            j = c;
        }
    }

    private static final class _B
    {

        A A;

        _B()
        {
            A = null;
        }
    }

    public static final class _C
    {

        public String toString()
        {
            return A;
        }

        private final String A;

        private _C(String s)
        {
            A = s;
        }

    }

    public static final class _F
    {

        public boolean C()
        {
            return A;
        }

        public _C B()
        {
            return B;
        }

        public int A()
        {
            return C;
        }

        private boolean A;
        private _C B;
        private int C;





        private _F(boolean flag, _C _pc)
        {
            A = flag;
            B = _pc;
            C = 1;
        }

    }

    public static final class _A
    {

        public String toString()
        {
            return A;
        }

        private final String A;

        private _A(String s)
        {
            A = s;
        }

    }

    public static final class _D
    {

        public String E()
        {
            return C;
        }

        public String B()
        {
            return A;
        }

        public boolean F()
        {
            return E;
        }

        public boolean G()
        {
            return D;
        }

        public _A A()
        {
            return G;
        }

        public int C()
        {
            return F;
        }

        public double D()
        {
            return H;
        }

        public double H()
        {
            return B;
        }

        private final String C;
        private final String A;
        private final boolean E;
        private boolean D;
        private _A G;
        private int F;
        private double H;
        private double B;













        private _D(String s, _A _pa)
        {
            this(s, null, false, false, _pa);
        }

        private _D(String s, String s1, boolean flag, boolean flag1, _A _pa)
        {
            C = s;
            A = s1;
            E = flag;
            D = flag1;
            G = _pa;
            F = 0;
            H = 0.0D;
            B = 0.0D;
        }


    }


    private A(b b1, K k, L l, G g, A.C.C c)
    {
        A = b1;
        X = k;
        V = l;
        H = g;
        U = c;
    }

    public T G(String s, String s1)
    {
        return A(s, s1, Q, false, false);
    }

    public T F(String s, String s1)
    {
        return A(s, s1, I, false, false);
    }

    public T A(String s, String s1)
    {
        return A(s, s1, B, false, false);
    }

    public T E(String s, String s1)
    {
        return A(s, s1, N, false, false);
    }

    public T B(String s, String s1)
    {
        return A(s, s1, G, false, false);
    }

    public T C(String s, String s1)
    {
        return A(s, s1, C, false, false);
    }

    public T D(String s, String s1)
    {
        return A(s, s1, O, false, false);
    }

    private T A(String s, String s1, _A _pa, boolean flag, boolean flag1)
    {
        E e = new E();
        e.A(s);
        e.B(s1);
        e.A(((byte)(O != _pa && I != _pa ? 0 : 1)));
        T t = A.B(U.B(e));
        X.A(t, new _D(s, s1, flag, flag1, _pa));
        return t;
    }

    public T A(String s)
    {
        F f = new F();
        f.C(s);
        Y y = U.B(f);
        T t = A.B(y);
        H.G(t);
        X.A(t, new _D(s, R));
        return t;
    }

    public T B(String s)
    {
        return A(s, false);
    }

    public T A(String s, boolean flag)
    {
        F f = new F();
        f.C(s);
        Y y = U.B(f);
        T t = A.B(y);
        if(y instanceof C.J.A.F)
            ((C.J.A.F)y).J(flag);
        if(flag)
            H.G(t);
        X.A(t, new _D(s, S));
        return t;
    }

    public T A(Y y)
    {
        T t = A.B(y);
        X.A(t, new _D(y.S(), M));
        return t;
    }

    public void A(T t, String s)
    {
    }

    public void B(T t, String s)
    {
    }

    public void B(T t, String s, String s1, int i)
    {
        E e = U.A(t);
        if(e != null)
        {
            Object obj = e.F();
            if(obj == null)
            {
                obj = new ArrayList();
                e.A(((List) (obj)));
            }
            B b1 = new B();
            b1.B(s);
            b1.A(s1);
            b1.A(i);
            ((List) (obj)).add(b1);
        }
    }

    public void A(T t, String s, String s1, int i)
    {
        E e = U.A(t);
        if(e != null)
        {
            Object obj = e.A();
            if(obj == null)
            {
                obj = new ArrayList();
                e.B(((List) (obj)));
            }
            B.B.B.G g = new B.B.B.G();
            g.B(s);
            A(g, s1);
            g.A(i);
            ((List) (obj)).add(g);
        }
    }

    public void A(T t, String s, String s1, String s2, int i)
    {
        E e = U.A(t);
        if(e != null)
        {
            Object obj = e.A();
            if(obj == null)
            {
                obj = new ArrayList();
                e.B(((List) (obj)));
            }
            B.B.B.G g = new B.B.B.G();
            g.B(s);
            A(g, s1);
            g.A(s2);
            g.A(i);
            ((List) (obj)).add(g);
        }
    }

    private void A(B.B.B.G g, String s)
    {
        if(s == null)
            return;
        s = s.trim();
        if(s.charAt(0) == '(')
            s = s.substring(1);
        if(s.charAt(s.length() - 1) == ')')
            s = s.substring(0, s.length() - 1);
        s = s.trim();
        if(s.length() == 0)
            return;
        StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
        ArrayList arraylist = new ArrayList(stringtokenizer.countTokens());
        I i;
        for(; stringtokenizer.hasMoreTokens(); i.A(stringtokenizer.nextToken().trim()))
        {
            i = new I();
            arraylist.add(i);
            i.B(null);
        }

        if(!arraylist.isEmpty())
            g.A(arraylist);
    }

    public J F(T t, T t1)
    {
        D d = new D((byte)1);
        C.J.U u = U.B(d);
        J j = H.C(t, t1);
        A.A(j, u);
        V.A(j, new _F(false, W));
        ++((_D)X.D(t)).F;
        ++((_D)X.D(t1)).F;
        return j;
    }

    public J B(T t, T t1)
    {
        D d = new D((byte)3);
        C.J.U u = U.B(d);
        J j = H.C(t, t1);
        A.A(j, u);
        V.A(j, new _F(false, E));
        ++((_D)X.D(t)).F;
        ++((_D)X.D(t1)).F;
        return j;
    }

    public J E(T t, T t1)
    {
        D d = new D((byte)4);
        C.J.U u = U.B(d);
        J j = H.C(t, t1);
        A.A(j, u);
        V.A(j, new _F(false, P));
        ++((_D)X.D(t)).F;
        ++((_D)X.D(t1)).F;
        return j;
    }

    public J C(T t, T t1)
    {
        D d = new D((byte)6);
        C.J.U u = U.B(d);
        J j = H.C(t, t1);
        A.A(j, u);
        V.A(j, new _F(false, J));
        ++((_D)X.D(t)).F;
        ++((_D)X.D(t1)).F;
        return j;
    }

    public J D(T t, T t1)
    {
        J j = t.D(t1);
        if(j == null)
        {
            D d = new D((byte)3);
            C.J.U u = U.B(d);
            j = H.C(t, t1);
            A.A(j, u);
            V.A(j, new _F(false, T));
            ++((_D)X.D(t)).F;
            ++((_D)X.D(t1)).F;
        } else
        {
            ((_F)V.D(j)).C+= = 1;
        }
        return j;
    }

    public T H(T t)
    {
        return H.J(t);
    }

    public void A(T t, T t1)
    {
        H.A(t, t1);
    }

    public void C()
    {
        L l = A.V();
        C.F.F.B(A, l);
        C.A.A a = new C.A.A();
        for(U u = A.M(); u.C(); u.B())
            if(l.B(u.I()))
            {
                a.add(u.I());
                A.B(u.I());
            }

        C.F.C.B(A);
        C.A.A a1 = new C.A.A();
        for(U u1 = A.M(); u1.C(); u1.B())
        {
            a1.add(u1.I());
            A.B(u1.I());
        }

        for(U u2 = a.L(); u2.C(); u2.B())
            A.C(u2.I());

        C.F.C.B(A);
        for(U u3 = a1.L(); u3.C(); u3.B())
            A.C(u3.I());

        for(C.A.F f = A.H(); f.C(); f.B())
        {
            T t = f.H();
            ((_D)X.D(t)).F = t.S();
        }

        A.A(l);
    }

    public void C(T t)
    {
        _D _ld = (_D)X.D(t);
        _D _ld1 = new _D(_ld.C, _ld.A, true, _ld.D, _ld.G);
        _ld1.H = _ld.H;
        _ld1.B = _ld.B;
        _ld1.F = _ld.F;
        X.A(t, _ld1);
    }

    public T A()
    {
        for(C.A.F f = A.H(); f.C(); f.B())
            if(((_D)X.D(f.H())).F())
                return f.H();

        return null;
    }

    public DA D(T t)
    {
        return U.E(t);
    }

    public DA F(T t)
    {
        return U.D(t);
    }

    public Iterator G(T t)
    {
        List list = U.F(t);
        if(list == null)
            return Y;
        else
            return list.iterator();
    }

    public Iterator E(T t)
    {
        List list = U.H(t);
        if(list == null)
            return Y;
        else
            return list.iterator();
    }

    public Iterator A(T t)
    {
        List list = U.C(t);
        if(list == null)
            return Y;
        else
            return list.iterator();
    }

    public boolean A(URL url, Map map)
    {
        if(!U.B(url))
            return false;
        for(U u = A.M(); u.C(); u.B())
            B(u.I());

        Object obj = map == null ? null : map.get("insets.package");
        java.awt.Insets insets = null;
        if(obj instanceof java.awt.Insets)
            insets = (java.awt.Insets)obj;
        obj = map == null ? null : map.get("insets.group");
        java.awt.Insets insets1 = null;
        if(obj instanceof java.awt.Insets)
            insets1 = (java.awt.Insets)obj;
        for(C.A.F f = A.H(); f.C(); f.B())
            A(f.H(), true, insets, insets1);

        return true;
    }

    public void B(J j)
    {
        C.J.U u = A.R(j);
        Object obj = V.D(j);
        if(obj instanceof _F)
        {
            _F _lf = (_F)obj;
            _C _lc = _lf.B();
            U.C(T == _lc ? E.toString() : _lc.toString());
            U.A(u, U.A(j));
            if(T == _lc)
            {
                O o = u.AA();
                int i = (int)o.getLineWidth();
                int k = _lf.A();
                byte byte0 = 5;
                while(k > 5) 
                {
                    k /= 5;
                    i++;
                }
                u.B(C.J.O.A(i, o.A()));
            }
        }
    }

    public void A(T t, boolean flag, java.awt.Insets insets, java.awt.Insets insets1)
    {
        Y y = A.U(t);
        Object obj = X.D(t);
        if(obj instanceof _D)
        {
            _D _ld = (_D)obj;
            _A _la = _ld.A();
            if(M == _la)
                return;
            String s;
            if(S == _la || R == _la)
                s = _la.toString();
            else
                s = _la.toString() + (_ld.E ? ".detailed" : ".compact");
            U.B(s);
            U.A(y, U.B(t), flag);
            if(S == _la || R == _la)
            {
                DA da = U.A(y);
                _ld.H = da == null ? 0.0D : da.g() * 1.03D;
                if(S == _la && insets != null && (y instanceof C.J.A.F))
                {
                    int i = da == null ? 0 : (int)Math.ceil(da.V());
                    insets.top += i;
                    ((C.J.A.F)y).A(insets);
                    insets.top -= i;
                }
                if(R == _la && insets1 != null && (y instanceof C.J.A.F))
                {
                    int j = da == null ? 0 : (int)Math.ceil(da.V());
                    insets1.top += j;
                    ((C.J.A.F)y).A(insets1);
                    insets1.top -= j;
                }
            }
        }
    }

    public _F A(J j)
    {
        return (_F)V.D(j);
    }

    public void A(J j, _C _pc, boolean flag, int i)
    {
        _F _lf = (_F)V.D(j);
        if(_lf == null)
        {
            _lf = new _F(flag, _pc);
            V.A(j, _lf);
        }
        _lf.A = flag;
        _lf.B = _pc;
        _lf.C = i;
    }

    public _D B(T t)
    {
        return (_D)X.D(t);
    }

    public void A(T t, String s, String s1, _A _pa, boolean flag, boolean flag1, int i)
    {
        _D _ld = new _D(s, s1, flag1, flag, _pa);
        _ld.F = i;
        X.A(t, _ld);
    }

    public void B()
    {
        for(U u = A.M(); u.C(); u.B())
            A.R(u.I()).H(false);

    }

    public static A A(b b1)
    {
        M m = b1.B(K);
        if(m == null)
        {
            _B _lb = new _B();
            _lb.A = B(b1);
            m = C.E.V.A(_lb);
            b1.A(K, m);
        } else
        if(!(m.D(b1) instanceof _B))
            throw new IllegalStateException("META_INFO_DP_KEY -> " + m.getClass().getName() + " not of type " + (A.C.A$_B.class).getName());
        return ((_B)m.D(b1)).A;
    }

    private static A B(b b1)
    {
        Object obj = b1.B(L);
        if(obj == null)
        {
            obj = b1.W();
            b1.A(L, ((M) (obj)));
        } else
        if(!(obj instanceof K))
            throw new IllegalStateException("UML_NODE_INFO_DP_KEY -> " + obj.getClass().getName() + " not of type " + (C.A.K.class).getName());
        Object obj1 = b1.B(D);
        if(obj1 == null)
        {
            obj1 = b1.V();
            b1.A(D, ((M) (obj1)));
        } else
        if(!(obj1 instanceof L))
            throw new IllegalStateException("UML_EDGE_INFO_DP_KEY -> " + obj1.getClass().getName() + " not of type " + (C.A.L.class).getName());
        G g = C.J.A.G.H(b1);
        if(g == null)
            g = new G(b1);
        A.C.C c = new A.C.C(((M) (obj)));
        b1.A(B.B.C.B.C3, new _E(c));
        return new A(b1, (K)obj, (L)obj1, g, c);
    }

    public static final Object L = "yuml.generator.UMLSupport.UML_NODE_INFO_DP_KEY";
    public static final Object D = "yuml.generator.UMLSupport.UML_EDGE_INFO_DP_KEY";
    private static final Object K = "yuml.generator.UMLSupport.META_INFO_DP_KEY";
    public static final _A I = new _A("annotation");
    public static final _A Q = new _A("abstract");
    public static final _A B = new _A("class");
    public static final _A N = new _A("enum");
    public static final _A G = new _A("error");
    public static final _A C = new _A("exception");
    public static final _A O = new _A("interface");
    public static final _A S = new _A("package");
    public static final _A R = new _A("group");
    public static final _A M = new _A("dummy");
    public static final _C W = new _C("association");
    public static final _C E = new _C("dependency");
    public static final _C P = new _C("generalization");
    public static final _C J = new _C("realization");
    public static final _C T = new _C("package-dependency");
    public static final _C F = new _C("dummy");
    private static final Iterator Y = new Iterator() {

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

    };
    private final b A;
    private final K X;
    private final L V;
    private final G H;
    private final A.C.C U;

}
