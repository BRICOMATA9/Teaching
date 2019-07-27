// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.A.A.G;
import B.B.A.B.C;
import B.B.B.A;
import B.B.B.D;
import B.B.B.E;
import B.B.B.F;
import B.B.C.J;
import C.A.T;
import C.J.DA;
import C.J.N;
import C.J.O;
import C.J.U;
import C.J.Y;
import C.J._;
import C.J.b;
import C.K.M;
import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

// Referenced classes of package B.B.A:
//            A, E, K, B, 
//            J, N, D, L, 
//            F, C

public class H
{

    protected H()
    {
        E = 0.0D;
        F = null;
        C = new C();
        D = new B.B.A.A();
    }

    public E A(T t)
    {
        Y y = ((b)t._()).U(t);
        if(y instanceof B.B.A.E)
            return ((B.B.A.E)y).EE();
        else
            return null;
    }

    public B.B.B.C B(T t)
    {
        Y y = ((b)t._()).U(t);
        if(y instanceof B.B.A.E)
            return ((B.B.A.E)y).EE();
        if(y instanceof K)
            return ((K)y).EC();
        if(y instanceof B)
            return ((B)y).F2();
        else
            return null;
    }

    public D A(C.A.J j)
    {
        U u = ((b)j.K()).R(j);
        return ((B.B.A.J)u).CA();
    }

    public void A(B.B.A.N n)
    {
        if(n != null)
            D = n;
        else
            D = new B.B.A.A();
    }

    public String B(B.B.B.H h)
    {
        return D.A(h);
    }

    public C A()
    {
        return C;
    }

    public void A(C c)
    {
        C = c;
    }

    public String A(B.B.B.C c)
    {
        if(c instanceof E)
        {
            E e = (E)c;
            if(e.B() == 1)
                return "interface";
            if(Modifier.isAbstract(e.C()))
                return "abstract";
            else
                return "class";
        }
        if(c instanceof A)
            return "note";
        if(c instanceof F)
            return "package";
        else
            throw new IllegalArgumentException("Can't identify type");
    }

    public String A(D d)
    {
        switch(d.D())
        {
        case 0: // '\0'
            return "aggregation";

        case 1: // '\001'
            return "association";

        case 2: // '\002'
            return "composition";

        case 3: // '\003'
            return "dependency";

        case 4: // '\004'
            return "generalization";

        case 5: // '\005'
            return "navigation";

        case 6: // '\006'
            return "realization";
        }
        throw new IllegalArgumentException("Can't identify type");
    }

    public Icon C(B.B.B.H h)
    {
        B.B.A.B.A a = A(h);
        Object obj = a.A("icon.style");
        if("image".equals(obj) || "jbuilder".equals(obj))
        {
            if(!(F instanceof B.B.A.D))
                F = new B.B.A.D();
        } else
        if("ascii".equals(obj))
        {
            if(!(F instanceof L))
                F = new L();
        } else
        if(("vectorgraphics".equals(obj) || "high-quality".equals(obj)) && !(F instanceof B.B.A.A.C))
        {
            F = new B.B.A.A.C();
            HashMap hashmap = new HashMap();
            Color color = (Color)a.A("icon.visibility.color");
            if(color != null)
            {
                hashmap.put(G.H, color);
                hashmap.put(G.M, color);
                hashmap.put(G.Q, color);
            }
            color = (Color)a.A("icon.visibility.border.color");
            if(color != null)
            {
                hashmap.put(G.J, color);
                hashmap.put(G.P, color);
                hashmap.put(G.I, color);
            }
            color = (Color)a.A("icon.operation.color");
            if(color != null)
            {
                hashmap.put(G.C, color);
                hashmap.put(G.G, color);
            }
            color = (Color)a.A("icon.staticoperation.color");
            if(color != null)
                hashmap.put(G.G, color);
            color = (Color)a.A("icon.field.color");
            if(color != null)
            {
                hashmap.put(G.E, color);
                hashmap.put(G.A, color);
            }
            color = (Color)a.A("icon.staticfield.color");
            if(color != null)
                hashmap.put(G.A, color);
            ((B.B.A.A.C)F).A(hashmap);
        }
        if(F != null)
            return F.A(h);
        else
            return null;
    }

    protected B.B.A.B.A A(B.B.B.H h)
    {
        return A().A("classifier");
    }

    public void A(Y y, B.B.B.C c, boolean flag)
    {
        if(c instanceof E)
        {
            E e = (E)c;
            B.B.A.E e1 = (B.B.A.E)y;
            B.B.A.B.A a1 = A().A(A(((B.B.B.C) (e))));
            Object obj = a1.A("shape");
            e1.D(A((String)obj));
            obj = a1.A("shadow.color");
            e1.F((Color)obj);
            obj = a1.A("shadow.width");
            e1.B(A((Number)obj));
            obj = a1.A("shadow.height");
            e1.C(A((Number)obj));
            obj = a1.A("shadow.style");
            if("soft".equals(obj))
                e1.E((byte)1);
            else
                e1.E((byte)0);
            obj = a1.A("line.color");
            e1.A((Color)obj);
            obj = a1.A("line.stroke");
            e1.A((O)obj);
            B.B.A.C.E e2 = A(e, e1);
            if(flag)
            {
                double d = e2.C(e1);
                double d2 = e2.A(e1);
                if(E > 0.0D)
                {
                    int i = (int)Math.ceil(d / E);
                    if(i % 2 == 0)
                        i++;
                    for(; (double)i * E < 70D; i += 2);
                    d = (double)i * E;
                    i = (int)Math.ceil(d2 / E);
                    if(i % 2 == 0)
                        i++;
                    d2 = (double)i * E;
                }
                e1.B(d, d2);
                e2.B(e1, e1.C(), e1.A(), e1.B(), e1.D());
            }
            e1.A(e2);
            e1.A(e);
        } else
        if(c instanceof A)
        {
            A a = (A)c;
            K k = (K)y;
            B.B.A.B.A a2 = A().A(A(c));
            Object obj1 = a2.A("shadow.color");
            k.F((Color)obj1);
            obj1 = a2.A("shadow.width");
            k.B(A((Number)obj1));
            obj1 = a2.A("shadow.height");
            k.C(A((Number)obj1));
            obj1 = a2.A("shadow.style");
            if("soft".equals(obj1))
                k.E((byte)1);
            obj1 = a2.A("line.color");
            k.A((Color)obj1);
            obj1 = a2.A("line.stroke");
            k.A((O)obj1);
            obj1 = a2.A("fill.color");
            k.B((Color)obj1);
            obj1 = a2.A("gradient.color");
            k.C((Color)obj1);
            obj1 = a2.A("dogear.color");
            k.G((Color)obj1);
            k.A(a.H());
            if(flag)
            {
                C.K.G g = k.H().A();
                double d1 = Math.max(80D, g.Q());
                double d3 = Math.max(60D, g.R());
                if(E > 0.0D)
                {
                    d1 = Math.ceil(d1 / E) * E;
                    d3 = Math.ceil(d3 / E) * E;
                }
                k.B(d1, d3);
            }
            k.A(a);
        } else
        if(c instanceof F)
        {
            F f = (F)c;
            B b1 = (B)y;
            B.B.A.B.A a3 = A().A(A(c));
            Object obj2 = a3.A("shape");
            b1.D(A((String)obj2));
            obj2 = a3.A("shadow.color");
            b1.F((Color)obj2);
            obj2 = a3.A("shadow.width");
            b1.B(A((Number)obj2));
            obj2 = a3.A("shadow.height");
            b1.(A((Number)obj2));
            obj2 = a3.A("shadow.style");
            if("soft".equals(obj2))
                b1.E((byte)1);
            obj2 = a3.A("line.color");
            b1.A((Color)obj2);
            obj2 = a3.A("line.stroke");
            b1.A((O)obj2);
            B.B.A.C.C c1 = A(f, b1);
            b1.A(c1);
            b1.A(f);
            if(flag)
            {
                DA da = c1.A();
                b1.D(Math.max(c1.C(b1), da.g() * 1.03D));
                b1.A(new Insets(2 + (int)Math.ceil(da.V()), 2, 2, 2));
                c1.A(b1, b1.(), b1.A(), b1.B(), b1.D());
            }
        }
    }

    private byte A(String s)
    {
        return s == null ? 0 : A.D(s).byteValue();
    }

    public void A(U u, D d)
    {
        B.B.A.J j = (B.B.A.J)u;
        B.B.A.B.A a = A().B(A(d));
        u.B((O)a.A("line.stroke"));
        u.D((Color)a.A("line.color"));
        u.A((_)a.A("source.arrow"));
        u.C((_)a.A("target.arrow"));
        u.H(u.AA().A() != 0);
        j.I("smooth".equals(a.A("bend.style")));
        M m = null;
        if(j.w() > 0)
            m = j.h()._();
        for(; j.w() > 0; j.A(j.D(0)));
        String s = d.F();
        if(s != null && s.length() > 0)
        {
            N n = j.C5();
            j.B(n);
            n.B(s);
            n.B((byte)6);
            if(m != null)
                n.A(n.F(m.A, m.D));
            else
                n.E(0.5D);
        }
        s = d.E();
        if(s != null && s.length() > 0)
        {
            N n1 = j.C5();
            n1.B((byte)2);
            n1.F((byte)13);
            n1.B(s);
            j.B(n1);
        }
        s = d.B();
        if(s != null && s.length() > 0)
        {
            N n2 = j.C5();
            n2.B((byte)2);
            n2.F((byte)15);
            n2.B(s);
            j.B(n2);
        }
        s = d.C();
        if(s != null && s.length() > 0)
        {
            N n3 = j.C5();
            n3.B((byte)2);
            n3.F((byte)14);
            n3.B(s);
            j.B(n3);
        }
        s = d.A();
        if(s != null && s.length() > 0)
        {
            N n4 = j.C5();
            n4.B((byte)2);
            n4.F((byte)16);
            n4.B(s);
            j.B(n4);
        }
        j.A(d);
    }

    public DA B(Y y)
    {
        if(y instanceof B.B.A.E)
            return ((B.B.A.E)y).EF().D();
        else
            return null;
    }

    public DA A(Y y)
    {
        if(y instanceof B)
            return ((B)y).F3().A();
        else
            return null;
    }

    protected B.B.A.C.C A(F f, B b1)
    {
        C c = A();
        B.B.A.B.A a = c.A(A(((B.B.B.C) (f))));
        return new B.B.A.C.C(f, b1, c.A(a));
    }

    protected B.B.A.C.E A(E e, B.B.A.E e1)
    {
        C c = A();
        B.B.A.B.A a = c.A(A(((B.B.B.C) (e))));
        B.B.A.C.E e2 = new B.B.A.C.E(e, e1, c.A(a));
        B.B.A.C.M m = A(((B.B.B.C) (e)), ((Y) (e1)));
        java.util.List list = e.F();
        if(list != null && !list.isEmpty())
        {
            e2.A(m);
            e2.A(A(((Collection) (list)), e, e1));
        }
        java.util.List list1 = e.A();
        if(list1 != null && !list1.isEmpty())
        {
            e2.A(m);
            e2.A(A(((Collection) (list1)), e, e1));
        }
        return e2;
    }

    protected B.B.A.C.M A(Collection collection, E e, B.B.A.E e1)
    {
        C c = A();
        B.B.A.B.A a = c.A(A(((B.B.B.C) (e))));
        return new B.B.A.C.N(collection, e1, c.A(a), this);
    }

    protected B.B.A.C.M A(B.B.B.C c, Y y)
    {
        B.B.A.B.A a = A().A(A(c));
        return new B.B.A.C.G((Color)a.A("separator.fill.color"));
    }

    public static H C()
    {
        return B;
    }

    private static H B()
    {
        B.B.A.C.A();
        H h = new H();
        InputStream inputstream = null;
        try
        {
            inputstream = (B.B.A.H.class).getResource("resource/gradient-style.xml").openStream();
            B.B.A.B.D d = new B.B.A.B.D();
            d.A(h.A(), inputstream);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        finally
        {
            if(inputstream != null)
                try
                {
                    inputstream.close();
                }
                catch(IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                }
        }
        return h;
    }

    private static byte A(Number number)
    {
        return number == null ? 0 : number.byteValue();
    }

    static final H B = B();
    double E;
    B.B.A.F F;
    C C;
    B.B.A.N D;
    final J A = new J();

}
