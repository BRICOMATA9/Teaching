// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.T;
import C.G.*;
import C.H.H;
import C.K.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package C.J:
//            k, b, Y, p

public class DA extends k
    implements V
{
    static final class _B
        implements k._E
    {

        public void A(k k1, FontRenderContext fontrendercontext)
        {
            if(k1 instanceof DA)
            {
                DA da = (DA)k1;
                da.j = false;
                C.J.k._G.B.A(k1, fontrendercontext, da.Z);
                double d1 = da.f;
                double d2 = da.m;
                switch(da.Z)
                {
                case 4: // '\004'
                default:
                    break;

                case 2: // '\002'
                    Y y1 = da.x();
                    if(y1 != null)
                        d1 = y1.D();
                    break;

                case 3: // '\003'
                    Y y2 = da.x();
                    if(y2 != null)
                    {
                        d2 = y2.B();
                        d1 = y2.D();
                    }
                    break;

                case 1: // '\001'
                    Y y3 = da.x();
                    if(y3 != null)
                        d2 = y3.B();
                    break;
                }
                da.C(d2, d1);
            }
        }

        _B()
        {
        }
    }

    static final class _A
        implements k._E
    {

        public void A(k k1, FontRenderContext fontrendercontext)
        {
            if(k1 instanceof DA)
            {
                DA da = (DA)k1;
                k._F.A.A(k1, fontrendercontext);
                da.j = false;
                double d1 = da.f;
                double d2 = da.m;
                switch(da.Z)
                {
                case 4: // '\004'
                default:
                    break;

                case 2: // '\002'
                    Y y1 = da.x();
                    if(y1 != null)
                        d1 = Math.max(d1, y1.D());
                    break;

                case 3: // '\003'
                    Y y2 = da.x();
                    if(y2 != null)
                    {
                        d2 = Math.max(d2, y2.B());
                        d1 = Math.max(d1, y2.D());
                    }
                    break;

                case 1: // '\001'
                    Y y3 = da.x();
                    if(y3 != null)
                        d2 = Math.max(d2, y3.B());
                    break;
                }
                da.C(d2, d1);
            }
        }

        _A()
        {
        }
    }


    public void H(byte byte0)
    {
        super.H(byte0);
    }

    public void C(String s1)
    {
        y().A(this, s1);
    }

    public static k._A y()
    {
        return r;
    }

    public DA(String s1, byte byte0)
    {
        s = new Integer(1);
        q = 4D;
        w = new _(0x1ff00, q);
        s = w.A();
        B(byte0);
        B(s1);
    }

    public DA(String s1)
    {
        this(s1, (byte)1);
    }

    public DA()
    {
        this("");
    }

    public Object clone()
    {
        DA da = new DA();
        da.A(this);
        return da;
    }

    public void A(k k1)
    {
        super.A(k1);
        if(k1 instanceof DA)
        {
            DA da = (DA)k1;
            D(da.v());
            if(da.x() != null)
                A(da.C().A(da.A(), da.x()));
        }
    }

    public void E(double d1, double d2)
    {
        super.E(d1, d2);
        if(w instanceof b)
            ((b)w).A(R(), U());
    }

    public void t()
    {
        if(Z == 2 || Z == 1 || Z == 3)
            l();
        super.t();
    }

    k._D d()
    {
        return t;
    }

    public void B(String s1)
    {
        String s2 = f();
        if(s1.equals(s2))
            return;
        super.B(s1);
        C.J.b b1 = z();
        if(b1 != null)
            b1.A(this, "text", s2, f());
    }

    public void D(double d1)
    {
        q = d1;
        if(w instanceof _)
            ((_)w).A(q);
        t();
    }

    public double v()
    {
        return q;
    }

    public K C()
    {
        return w;
    }

    public void A(K k1)
    {
        w = k1;
        t();
    }

    public Object B()
    {
        return s;
    }

    public void A(Object obj)
    {
        s = obj;
        g = p();
        t();
    }

    public void B(byte byte0)
    {
        if(byte0 >= 0 && byte0 <= 6)
        {
            N = byte0;
            K k1 = w;
            t();
            switch(N)
            {
            case 0: // '\0'
                w = new _(198, q);
                break;

            case 1: // '\001'
                w = new _(0x1ff00, q);
                break;

            case 2: // '\002'
                w = new _(33, q);
                break;

            case 3: // '\003'
                w = new _(57, q);
                break;

            case 4: // '\004'
                w = new b();
                break;

            case 5: // '\005'
                w = new _(255, q);
                break;

            case 6: // '\006'
                w = new U(z(), w());
                break;
            }
            if((k1 instanceof _) && (w instanceof _))
            {
                _ _l = (_)w;
                if(_l.A(s))
                    return;
            }
            if(w instanceof b)
            {
                b b1 = (b)w;
                b1.A(e, c);
            }
            s = w.A();
            g = p();
        }
    }

    public void F(byte byte0)
    {
        if(!(w instanceof _))
            return;
        _ _l = (_)w;
        int i = 0;
        switch(byte0)
        {
        case 100: // 'd'
            i = 256;
            break;

        case 101: // 'e'
            i = 512;
            break;

        case 102: // 'f'
            i = 1024;
            break;

        case 117: // 'u'
            i = 8192;
            break;

        case 118: // 'v'
            i = 16384;
            break;

        case 119: // 'w'
            i = 32768;
            break;

        case 120: // 'x'
            i = 0x10000;
            break;

        case 115: // 's'
            i = 2048;
            break;

        case 116: // 't'
            i = 4096;
            break;

        case 104: // 'h'
            i = 2;
            break;

        case 105: // 'i'
            i = 4;
            break;

        case 106: // 'j'
            i = 128;
            break;

        case 107: // 'k'
            i = 64;
            break;

        case 108: // 'l'
            i = 1;
            break;

        case 109: // 'm'
            i = 32;
            break;

        case 110: // 'n'
            i = 8;
            break;

        case 111: // 'o'
            i = 16;
            break;
        }
        Integer integer = new Integer(i);
        if(_l.A(integer))
        {
            s = integer;
        } else
        {
            System.err.println("NLabel::setPos: ERROR: pos " + byte0 + " not valid for model " + N);
            return;
        }
        t();
    }

    public byte p()
    {
        if(w instanceof _)
        {
            int i = ((Integer)s).intValue();
            switch(i)
            {
            case 256: 
                return 100;

            case 1024: 
                return 102;

            case 512: 
                return 101;

            case 8192: 
                return 117;

            case 16384: 
                return 118;

            case 32768: 
                return 119;

            case 65536: 
                return 120;

            case 2048: 
                return 115;

            case 4096: 
                return 116;

            case 4: // '\004'
                return 105;

            case 2: // '\002'
                return 104;

            case 128: 
                return 106;

            case 64: // '@'
                return 107;

            case 1: // '\001'
                return 108;

            case 8: // '\b'
                return 110;

            case 16: // '\020'
                return 111;

            case 32: // ' '
                return 109;
            }
        }
        if(w instanceof b)
            return 114;
        return ((byte)(!(w instanceof U) ? 113 : 112));
    }

    public M _()
    {
        return new M(u.C() + R(), u.A() + U());
    }

    public boolean n()
    {
        if(N == 6)
            return true;
        else
            return Y;
    }

    public void q()
    {
        Y y1 = u;
        M m = C().A(new B(g(), V()), y1, B());
        E(m.B() - y1.C(), m.A() - y1.A());
    }

    public T w()
    {
        if(u != null)
            return u.Q();
        else
            return null;
    }

    public Y x()
    {
        return u;
    }

    public C.J.b z()
    {
        T t1 = w();
        if(t1 != null)
            return (C.J.b)t1._();
        else
            return null;
    }

    public void A(Y y1)
    {
        u = y1;
        t();
    }

    public G A()
    {
        return new G(R() + u.C(), U() + u.A(), g(), V());
    }

    public void A(Rectangle2D rectangle2d)
    {
        if(o())
            T();
        if(n())
            q();
        double d1 = e + u.C();
        double d2 = c + u.A();
        if(rectangle2d.getWidth() < 0.0D)
            rectangle2d.setFrame(d1, d2, J, M);
        else
            rectangle2d.setFrameFromDiagonal(Math.min(d1, rectangle2d.getX()), Math.min(d2, rectangle2d.getY()), Math.max(d1 + J, rectangle2d.getX() + rectangle2d.getWidth()), Math.max(d2 + M, rectangle2d.getY() + rectangle2d.getHeight()));
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(2);
        super.A(objectoutputstream);
        objectoutputstream.writeDouble(v());
    }

    public void C(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.C(objectinputstream);
            break;

        case 1: // '\001'
            super.C(objectinputstream);
            D(objectinputstream.readDouble());
            H(objectinputstream.readByte());
            break;

        case 2: // '\002'
            super.C(objectinputstream);
            D(objectinputstream.readDouble());
            break;

        default:
            throw new H();
        }
    }

    static Class _mthclass$(String s1)
    {
        return Class.forName(s1);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private static final byte v[][] = {
        {
            104, 105, 106, 107
        }, {
            100, 102, 101, 115, 116, 117, 118, 119, 120
        }, {
            108, 109
        }, {
            108, 109, 111, 110
        }, {
            114
        }, {
            108, 109, 110, 111, 104, 105, 107, 106
        }, {
            112
        }
    };
    Y u;
    private K w;
    private Object s;
    private double q;
    private static final k._D t;
    private static final k._A r;

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(C.J.k$_H.class, k._F.A);
        hashmap.put(C.J.k$_B.class, k._F.A);
        hashmap.put(C.J.k$_E.class, new _A());
        hashmap.put(C.J.k$_C.class, new p((byte)0));
        t = new k._D(hashmap, hashmap, null);
        r = new k._A(hashmap);
        hashmap = new HashMap();
        hashmap.put(C.J.k$_E.class, new _B());
        hashmap.put(C.J.k$_H.class, new k._G());
        r.A("CroppingLabel", hashmap);
    }
}
