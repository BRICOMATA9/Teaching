// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.C;

import B.B.A.A;
import B.B.A.B;
import B.B.A.C.N;
import B.B.A.E;
import B.B.A.H;
import B.B.A.J;
import B.B.A.K;
import B.B.B.D;
import B.B.B.F;
import B.B.B.G;
import C.A.M;
import C.A.T;
import C.J.DA;
import C.J.U;
import C.J.Y;
import C.J.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package A.C:
//            A, D

final class C extends H
{
    private static final class _B
    {

        B.B.A.B.C A(URL url)
        {
            B.B.A.B.C c;
            B.B.A.B.D d;
            if(B.containsKey(url))
                break MISSING_BLOCK_LABEL_109;
            c = new B.B.A.B.C();
            c.A(A.C.D.F());
            d = new B.B.A.B.D();
            InputStream inputstream = null;
            inputstream = url.openStream();
            d.A(c, inputstream);
            if(inputstream != null)
                inputstream.close();
            break MISSING_BLOCK_LABEL_80;
            Exception exception;
            exception;
            if(inputstream != null)
                inputstream.close();
            throw exception;
            B.put(url, c);
            break MISSING_BLOCK_LABEL_109;
            IOException ioexception;
            ioexception;
            B.put(url, null);
            return (B.B.A.B.C)B.get(url);
        }

        static final _B A = new _B();
        private Map B;


        private _B()
        {
            B = new HashMap();
        }
    }

    private static final class _A extends N
    {

        public B.B.A.C.M B(Y y)
        {
            return new _A(this, y);
        }

        protected List L()
        {
            return super.L();
        }

        _A(Collection collection, Y y, M m, H h)
        {
            super(collection, y, new _F(m, "methods."), h);
        }

        _A(N n, Y y)
        {
            super(n, y);
        }
    }

    private static final class _E extends N
    {

        public B.B.A.C.M B(Y y)
        {
            return new _E(this, y);
        }

        protected List L()
        {
            return super.L();
        }

        _E(Collection collection, Y y, M m, H h)
        {
            super(collection, y, new _F(m, "constructors."), h);
        }

        _E(N n, Y y)
        {
            super(n, y);
        }
    }

    private static final class _C extends N
    {

        public B.B.A.C.M B(Y y)
        {
            return new _C(this, y);
        }

        protected List L()
        {
            return super.L();
        }

        _C(Collection collection, Y y, M m, H h)
        {
            super(collection, y, new _F(m, "fields."), h);
        }

        _C(N n, Y y)
        {
            super(n, y);
        }
    }

    private static final class _F extends C.E.T
    {

        public Object D(Object obj)
        {
            if(obj instanceof String)
            {
                Matcher matcher = l.matcher((String)obj);
                return m.D(matcher.replaceAll(k));
            } else
            {
                return m.D(obj);
            }
        }

        private static final Pattern l = Pattern.compile("^(section\\.feature\\.|section\\.)");
        private M m;
        private final String k;


        _F(M m1, String s)
        {
            m = m1;
            k = s;
        }
    }

    private static final class _D extends B.B.A.C.E
    {

        public B.B.A.C.M B(Y y)
        {
            return new _D(this, y);
        }

        _D(B.B.B.E e, Y y, M m)
        {
            super(e, y, m);
        }

        _D(B.B.A.C.E e, Y y)
        {
            super(e, y);
        }
    }


    C(M m)
    {
        I = m;
        G = null;
        H = null;
        A a = new A() {

            protected boolean B(B.B.B.B b1)
            {
                return true;
            }

            protected boolean B(G g)
            {
                return true;
            }

        };
        a.D(" : ");
        a.B(" : ");
        a.A(" : ");
        a.C(", ");
        A(a);
        A(((URL) (null)));
    }

    boolean B(URL url)
    {
        return A(url);
    }

    private boolean A(URL url)
    {
        B.B.A.B.C c;
        if(url == null)
            c = B.B.A.H.C().A();
        else
            c = A.C._B.A.A(url);
        if(c != null)
        {
            if(!(c.A() instanceof A.C.D))
                c.A(A.C.D.F());
            A(c);
        }
        return c != null;
    }

    public String A(B.B.B.C c)
    {
        String s = D();
        if(s == null)
            return super.A(c);
        else
            return s;
    }

    public String A(D d)
    {
        String s = E();
        if(s == null)
            return super.A(d);
        else
            return s;
    }

    protected B.B.A.B.A A(B.B.B.H h)
    {
        String s = D();
        if(s == null)
            return super.A(h);
        else
            return A().A(s);
    }

    String D()
    {
        return G;
    }

    void B(String s)
    {
        G = s;
    }

    String E()
    {
        return H;
    }

    void C(String s)
    {
        H = s;
    }

    public DA D(T t)
    {
        C.A.D d = t._();
        if(d instanceof b)
        {
            Y y = ((b)d).U(t);
            if(y instanceof E)
                return super.B(y);
        }
        return null;
    }

    public DA E(T t)
    {
        C.A.D d = t._();
        if(d instanceof b)
        {
            Y y = ((b)d).U(t);
            if(y instanceof B)
                return super.A(y);
        }
        return null;
    }

    public List F(T t)
    {
        _D _ld = G(t);
        if(_ld != null)
        {
            int i = 0;
            for(int j = _ld.C(); i < j; i++)
                if(_ld.A(i) instanceof _C)
                    return ((_C)_ld.A(i)).L();

        }
        return null;
    }

    public List H(T t)
    {
        _D _ld = G(t);
        if(_ld != null)
        {
            int i = 0;
            for(int j = _ld.C(); i < j; i++)
                if(_ld.A(i) instanceof _E)
                    return ((_E)_ld.A(i)).L();

        }
        return null;
    }

    public List C(T t)
    {
        _D _ld = G(t);
        if(_ld != null)
        {
            int i = 0;
            for(int j = _ld.C(); i < j; i++)
                if(_ld.A(i) instanceof _A)
                    return ((_A)_ld.A(i)).L();

        }
        return null;
    }

    private _D G(T t)
    {
        C.A.D d = t._();
        if(d instanceof b)
        {
            Y y = ((b)d).U(t);
            if(y instanceof E)
            {
                B.B.A.C.E e = ((E)y).EF();
                if(e instanceof _D)
                    return (_D)e;
            }
        }
        return null;
    }

    public Y B(B.B.B.C c)
    {
        Object obj = null;
        if(c instanceof B.B.B.E)
        {
            E e = new E();
            e.A((B.B.B.E)c);
            obj = e;
        } else
        if(c instanceof B.B.B.A)
        {
            K k = new K();
            k.A((B.B.B.A)c);
            obj = k;
        } else
        if(c instanceof F)
        {
            B b1 = new B();
            b1.A((F)c);
            obj = b1;
        } else
        {
            throw new IllegalArgumentException("Unknown type");
        }
        return ((Y) (obj));
    }

    public U B(D d)
    {
        J j = new J();
        j.A(d);
        return j;
    }

    public void A(Y y, B.B.B.C c, boolean flag)
    {
        B.B.A.B.A a = A().A(G);
        if(G.endsWith(".detailed"))
            a.A("header.style", "default");
        else
        if(G.endsWith(".compact"))
        {
            String s = (String)a.A("header.style");
            if(!"default".equals(s) && !"iconified".equals(s))
                a.A("header.style", "default");
        } else
        if("package".equals(G) || "group".equals(G))
        {
            String s1 = (String)a.A("header.style");
            if("default".equals(s1) || "iconified".equals(s1))
                a.A("header.style", "span_section");
            s1 = (String)a.A("shape");
            if(!"rectangle".equals(s1) && !"roundrectangle".equals(s1))
                a.A("shape", "rectangle");
        }
        super.A(y, c, flag);
        if(flag && (c instanceof B.B.B.E) && !((E)y).EF().E())
        {
            switch(((E)y).E3())
            {
            case 2: // '\002'
                A(y, K);
                break;

            case 3: // '\003'
                y.D(y.B() * 1.25D);
                break;

            case 4: // '\004'
                y.D(y.B() * 1.25D);
                break;

            case 5: // '\005'
                y.B(y.B() * 2D, y.D() * 2D);
                break;

            case 7: // '\007'
                A(y, J);
                break;

            case 8: // '\b'
                A(y, 0.5D);
                break;

            case 9: // '\t'
            case 10: // '\n'
                y.D(y.B() * 2D);
                break;
            }
            ((E)y).EF().B(y, y.C(), y.A(), y.B(), y.D());
        }
    }

    private static void A(Y y, double d)
    {
        double d1 = y.C();
        double d2 = y.A();
        double d3 = y.B();
        double d4 = y.D();
        double d5 = y.N() - d1;
        double d6 = y.V() - d2;
        double d7 = Math.sqrt(d5 * d5 + d6 * d6);
        d5 = d * 0.5D * d3;
        d6 = d * 0.5D * d4;
        double d8 = Math.sqrt(d5 * d5 + d6 * d6);
        double d9 = d7 / d8;
        y.B(d9 * d3, d9 * d4);
    }

    protected B.B.A.C.E A(B.B.B.E e, E e1)
    {
        T t = e1.Q();
        B.B.A.B.C c = A();
        M m = c.A(c.A(A(((B.B.B.C) (e)))));
        _D _ld = new _D(e, e1, m);
        B.B.A.C.M m1 = A(((B.B.B.C) (e)), ((Y) (e1)));
        List list = e.F();
        if(list != null && !list.isEmpty())
        {
            _ld.A(m1);
            _C _lc = new _C(list, e1, m, this);
            _ld.A(_lc);
        }
        List list1 = e.A();
        if(list1 != null && !list1.isEmpty())
        {
            String s = ((A._D)I.D(t)).E();
            ArrayList arraylist = new ArrayList(list1.size());
            ArrayList arraylist1 = new ArrayList(list1.size());
            for(Iterator iterator = list1.iterator(); iterator.hasNext();)
            {
                G g = (G)iterator.next();
                if(g.C().startsWith(s))
                    arraylist.add(g);
                else
                    arraylist1.add(g);
            }

            _ld.A(m1);
            _E _le = new _E(arraylist, e1, m, this);
            _ld.A(_le);
            _ld.A(m1);
            _A _la = new _A(arraylist1, e1, m, this);
            _ld.A(_la);
        }
        return _ld;
    }

    private M I;
    private String G;
    private String H;
    private static final double K = 0.5D * Math.sqrt(2D);
    private static final double J = 1.0D / (1.0D + 0.25D * Math.sqrt(2D));

}
