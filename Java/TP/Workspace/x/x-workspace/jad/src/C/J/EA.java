// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.P;
import C.H.H;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

// Referenced classes of package C.J:
//            U, S, G, f, 
//            M, x, q

public class EA extends U
    implements S
{
    public static final class _C
    {

        public Map C()
        {
            HashMap hashmap = new HashMap();
            hashmap.put(EA.class$C$J$EA$_H != null ? ((Object) (EA.class$C$J$EA$_H)) : ((Object) (EA.class$C$J$EA$_H = EA._mthclass$("C.J.EA$_H"))), new x());
            hashmap.put(EA.class$C$J$EA$_N != null ? ((Object) (EA.class$C$J$EA$_N)) : ((Object) (EA.class$C$J$EA$_N = EA._mthclass$("C.J.EA$_N"))), new q());
            return hashmap;
        }

        public void A(String s, Map map)
        {
            _D _ld = new _D(s);
            _ld.N = (_K)map.get(EA.class$C$J$EA$_K != null ? ((Object) (EA.class$C$J$EA$_K)) : ((Object) (EA.class$C$J$EA$_K = EA._mthclass$("C.J.EA$_K"))));
            _ld.E = (_O)map.get(EA.class$C$J$EA$_O != null ? ((Object) (EA.class$C$J$EA$_O)) : ((Object) (EA.class$C$J$EA$_O = EA._mthclass$("C.J.EA$_O"))));
            _ld.L = (_I)map.get(EA.class$C$J$EA$_I != null ? ((Object) (EA.class$C$J$EA$_I)) : ((Object) (EA.class$C$J$EA$_I = EA._mthclass$("C.J.EA$_I"))));
            _ld.H = (_A)map.get(EA.class$C$J$EA$_A != null ? ((Object) (EA.class$C$J$EA$_A)) : ((Object) (EA.class$C$J$EA$_A = EA._mthclass$("C.J.EA$_A"))));
            _ld.D = (_L)map.get(EA.class$C$J$EA$_L != null ? ((Object) (EA.class$C$J$EA$_L)) : ((Object) (EA.class$C$J$EA$_L = EA._mthclass$("C.J.EA$_L"))));
            _ld.K = (_N)map.get(EA.class$C$J$EA$_N != null ? ((Object) (EA.class$C$J$EA$_N)) : ((Object) (EA.class$C$J$EA$_N = EA._mthclass$("C.J.EA$_N"))));
            _ld.F = (_B)map.get(EA.class$C$J$EA$_B != null ? ((Object) (EA.class$C$J$EA$_B)) : ((Object) (EA.class$C$J$EA$_B = EA._mthclass$("C.J.EA$_B"))));
            _ld.I = (_E)map.get(EA.class$C$J$EA$_E != null ? ((Object) (EA.class$C$J$EA$_E)) : ((Object) (EA.class$C$J$EA$_E = EA._mthclass$("C.J.EA$_E"))));
            _ld.J = (_G)map.get(EA.class$C$J$EA$_G != null ? ((Object) (EA.class$C$J$EA$_G)) : ((Object) (EA.class$C$J$EA$_G = EA._mthclass$("C.J.EA$_G"))));
            _ld.M = (_F)map.get(EA.class$C$J$EA$_F != null ? ((Object) (EA.class$C$J$EA$_F)) : ((Object) (EA.class$C$J$EA$_F = EA._mthclass$("C.J.EA$_F"))));
            _ld.A = (_H)map.get(EA.class$C$J$EA$_H != null ? ((Object) (EA.class$C$J$EA$_H)) : ((Object) (EA.class$C$J$EA$_H = EA._mthclass$("C.J.EA$_H"))));
            _ld.G = (_M)map.get(EA.class$C$J$EA$_M != null ? ((Object) (EA.class$C$J$EA$_M)) : ((Object) (EA.class$C$J$EA$_M = EA._mthclass$("C.J.EA$_M"))));
            _ld.B = (_J)map.get(EA.class$C$J$EA$_J != null ? ((Object) (EA.class$C$J$EA$_J)) : ((Object) (EA.class$C$J$EA$_J = EA._mthclass$("C.J.EA$_J"))));
            if(_ld.K == null)
                throw new IllegalArgumentException("Need PathCalculator instance!");
            if(_ld.A == null)
            {
                throw new IllegalArgumentException("Need BendHandler instance!");
            } else
            {
                C.put(s, _ld);
                return;
            }
        }

        _D B()
        {
            return A;
        }

        public void A(EA ea, String s)
        {
            _D _ld = (_D)C.get(s);
            if(_ld != null)
            {
                if(ea.D3 != _ld)
                {
                    ea.D3 = _ld;
                    ea.C4();
                }
            } else
            {
                throw new IllegalArgumentException();
            }
        }

        public Set A()
        {
            return B;
        }

        private _D A;
        Map C;
        Set B;

        private _C()
        {
            A = new _D("DEFAULT");
            C = new HashMap();
            B = Collections.unmodifiableSet(C.keySet());
            A.A = new x();
            A.K = new q();
        }

    }

    static final class _D
    {

        final String C;
        _A H;
        _O E;
        _J B;
        _K N;
        _M G;
        _I L;
        _L D;
        _N K;
        _B F;
        _H A;
        _E I;
        _G J;
        _F M;

        _D(String s)
        {
            C = s;
        }
    }

    public static interface _G
    {

        public abstract void A(U u, Object obj, ObjectOutputStream objectoutputstream)
            throws IOException;

        public abstract Object A(U u, ObjectInputStream objectinputstream)
            throws IOException;

        public abstract Object A(U u, Object obj, U u1);
    }

    public static interface _K
    {

        public abstract void A(U u, G g, GeneralPath generalpath, Graphics2D graphics2d);
    }

    public static interface _O
    {

        public abstract void A(U u, Graphics2D graphics2d);
    }

    public static interface _A
    {
    }

    public static interface _I
    {

        public abstract void B(U u, G g, GeneralPath generalpath, Graphics2D graphics2d, boolean flag);

        public abstract void A(U u, G g, GeneralPath generalpath, Graphics2D graphics2d, boolean flag);
    }

    public static interface _J
    {

        public abstract void A(U u, G g, GeneralPath generalpath, M m);
    }

    public static interface _H
    {

        public abstract f A(U u, G g, double d, double d1, f f1, 
                int i);

        public abstract void A(U u, G g, f f1, double d, double d1);
    }

    public static interface _E
    {
    }

    public static interface _B
    {
    }

    public static interface _N
    {

        public abstract byte A(U u, G g, GeneralPath generalpath, Point2D point2d, Point2D point2d1);
    }

    public static interface _L
    {

        public abstract void A(U u, G g, GeneralPath generalpath, Graphics2D graphics2d);
    }

    public static interface _M
    {

        public abstract void A(U u, G g, GeneralPath generalpath, Rectangle2D rectangle2d);
    }

    public static interface _F
    {

        public abstract void A(U u, G g, GeneralPath generalpath, Graphics2D graphics2d, boolean flag);
    }


    public static _C D8()
    {
        return D4;
    }

    public EA()
    {
        D3 = D8().B();
    }

    public EA(U u)
    {
        if(u instanceof EA)
            A((EA)u);
        else
            D3 = D8().B();
        super.B(u);
    }

    public Object DA()
    {
        return D2;
    }

    public void A(Object obj)
    {
        D2 = obj;
    }

    private void A(EA ea)
    {
        D3 = ea.D3;
        if(D2() != null)
            D2 = D2().A(ea, ea.D2, this);
        else
            D2 = ea.D2;
    }

    public void C(Rectangle2D rectangle2d)
    {
        _M _lm = D4();
        if(_lm != null)
        {
            _lm.A(this, A2, r, rectangle2d);
        } else
        {
            super.C(rectangle2d);
            if(A4())
            {
                for(P p = A2.I(); p != null; p = p.C())
                {
                    f f1 = (f)p.A();
                    rectangle2d.add(f1.A(), f1.C());
                }

            } else
            {
                for(P p1 = A2.I(); p1 != null; p1 = p1.C())
                {
                    f f2 = (f)p1.A();
                    if(f2.B())
                        rectangle2d.add(f2.A(), f2.C());
                }

            }
        }
    }

    public U A(U u)
    {
        return new EA(u);
    }

    public f A(double d, double d1, f f1, int i)
    {
        return DE().A(this, A2, d, d1, f1, i);
    }

    protected void K(Graphics2D graphics2d)
    {
        _K _lk = D1();
        if(_lk != null)
            _lk.A(this, A2, r, graphics2d);
        else
            super.K(graphics2d);
    }

    protected void F(Graphics2D graphics2d)
    {
        _O _lo = DD();
        if(_lo != null)
            _lo.A(this, graphics2d);
        else
            super.F(graphics2d);
    }

    public void A(f f1, double d, double d1)
    {
        DE().A(this, A2, f1, d, d1);
    }

    public void A(M m)
    {
        _J _lj = DB();
        if(_lj != null)
        {
            if(q())
                j();
            _lj.A(this, A2, r, m);
        } else
        {
            super.A(m);
        }
    }

    private final _J DB()
    {
        return D3.B;
    }

    private final _I D3()
    {
        return D3.L;
    }

    private final _O DD()
    {
        return D3.E;
    }

    private final _K D1()
    {
        return D3.N;
    }

    private final _H DE()
    {
        return D3.A;
    }

    private final _N DC()
    {
        return D3.K;
    }

    private _M D4()
    {
        return D3.G;
    }

    private _L D5()
    {
        return D3.D;
    }

    private final _G D2()
    {
        return D3.J;
    }

    private final _F D6()
    {
        return D3.M;
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        return DC().A(this, A2, r, point2d, point2d1);
    }

    public void H(Graphics2D graphics2d)
    {
        if((n & 1) == 0)
            return;
        if(q())
            j();
        if((n & 2) == 0)
            return;
        _I _li = D3();
        if(_li != null)
            _li.B(this, A2, r, graphics2d, A4());
        else
            super.H(graphics2d);
    }

    protected void G(Graphics2D graphics2d)
    {
        _L _ll = D5();
        if(_ll != null)
            _ll.A(this, A2, r, graphics2d);
        else
            super.G(graphics2d);
    }

    protected void I(Graphics2D graphics2d)
    {
        _F _lf = D6();
        if(_lf != null)
            _lf.A(this, A2, r, graphics2d, true);
        else
            super.I(graphics2d);
    }

    protected void L(Graphics2D graphics2d)
    {
        _F _lf = D6();
        if(_lf != null)
            _lf.A(this, A2, r, graphics2d, false);
        else
            super.L(graphics2d);
    }

    public void J(Graphics2D graphics2d)
    {
        if((n & 1) == 0)
            return;
        _I _li = D3();
        if(_li != null)
        {
            if(q())
                j();
            if((n & 2) == 0)
                return;
            _li.A(this, A2, r, graphics2d, A4());
        } else
        {
            super.J(graphics2d);
        }
    }

    public void C(String s)
    {
        D8().A(this, s);
    }

    public String D9()
    {
        return D3.C;
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.G(objectinputstream);
            D8().A(this, (String)objectinputstream.readObject());
            boolean flag = objectinputstream.readBoolean();
            if(flag)
                if(D2() != null)
                    D2 = D2().A(this, objectinputstream);
                else
                    throw new H("No UserDataHandler registered to read userData!");
            break;

        default:
            throw new H();
        }
    }

    public void B(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(0);
        super.B(objectoutputstream);
        objectoutputstream.writeObject(D3.C);
        if(D2() != null)
        {
            objectoutputstream.writeBoolean(true);
            D2().A(this, D2, objectoutputstream);
        } else
        {
            objectoutputstream.writeBoolean(false);
        }
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private _D D3;
    private Object D2;
    static _C D4 = new _C();
    static Class class$C$J$EA$_H; /* synthetic field */
    static Class class$C$J$EA$_N; /* synthetic field */
    static Class class$C$J$EA$_K; /* synthetic field */
    static Class class$C$J$EA$_O; /* synthetic field */
    static Class class$C$J$EA$_I; /* synthetic field */
    static Class class$C$J$EA$_A; /* synthetic field */
    static Class class$C$J$EA$_L; /* synthetic field */
    static Class class$C$J$EA$_B; /* synthetic field */
    static Class class$C$J$EA$_E; /* synthetic field */
    static Class class$C$J$EA$_G; /* synthetic field */
    static Class class$C$J$EA$_F; /* synthetic field */
    static Class class$C$J$EA$_M; /* synthetic field */
    static Class class$C$J$EA$_J; /* synthetic field */



}
