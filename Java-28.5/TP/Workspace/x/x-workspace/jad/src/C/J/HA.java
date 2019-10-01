// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.*;

// Referenced classes of package C.J:
//            Y, S

public class HA extends Y
    implements S
{
    public static final class _D
    {

        public Map C()
        {
            return new HashMap();
        }

        public void A(String s, Map map)
        {
            _E _le = new _E(s);
            _le.J = (_H)map.get(HA.class$C$J$HA$_H != null ? ((Object) (HA.class$C$J$HA$_H)) : ((Object) (HA.class$C$J$HA$_H = HA._mthclass$("C.J.HA$_H"))));
            _le.F = (_B)map.get(HA.class$C$J$HA$_B != null ? ((Object) (HA.class$C$J$HA$_B)) : ((Object) (HA.class$C$J$HA$_B = HA._mthclass$("C.J.HA$_B"))));
            _le.E = (_I)map.get(HA.class$C$J$HA$_I != null ? ((Object) (HA.class$C$J$HA$_I)) : ((Object) (HA.class$C$J$HA$_I = HA._mthclass$("C.J.HA$_I"))));
            _le.I = (_K)map.get(HA.class$C$J$HA$_K != null ? ((Object) (HA.class$C$J$HA$_K)) : ((Object) (HA.class$C$J$HA$_K = HA._mthclass$("C.J.HA$_K"))));
            _le.C = (_A)map.get(HA.class$C$J$HA$_A != null ? ((Object) (HA.class$C$J$HA$_A)) : ((Object) (HA.class$C$J$HA$_A = HA._mthclass$("C.J.HA$_A"))));
            _le.G = (_F)map.get(HA.class$C$J$HA$_F != null ? ((Object) (HA.class$C$J$HA$_F)) : ((Object) (HA.class$C$J$HA$_F = HA._mthclass$("C.J.HA$_F"))));
            _le.H = (_G)map.get(HA.class$C$J$HA$_G != null ? ((Object) (HA.class$C$J$HA$_G)) : ((Object) (HA.class$C$J$HA$_G = HA._mthclass$("C.J.HA$_G"))));
            _le.D = (_L)map.get(HA.class$C$J$HA$_L != null ? ((Object) (HA.class$C$J$HA$_L)) : ((Object) (HA.class$C$J$HA$_L = HA._mthclass$("C.J.HA$_L"))));
            _le.B = (_C)map.get(HA.class$C$J$HA$_C != null ? ((Object) (HA.class$C$J$HA$_C)) : ((Object) (HA.class$C$J$HA$_C = HA._mthclass$("C.J.HA$_C"))));
            _le.K = (_J)map.get(HA.class$C$J$HA$_J != null ? ((Object) (HA.class$C$J$HA$_J)) : ((Object) (HA.class$C$J$HA$_J = HA._mthclass$("C.J.HA$_J"))));
            C.put(s, _le);
        }

        _E B()
        {
            return A;
        }

        public void A(HA ha, String s)
        {
            _E _le = (_E)C.get(s);
            if(_le != null)
            {
                if(ha.D6 != _le)
                    ha.D6 = _le;
            } else
            {
                throw new IllegalArgumentException();
            }
        }

        public Set A()
        {
            return B;
        }

        private _E A;
        Map C;
        Set B;

        private _D()
        {
            A = new _E("DEFAULT");
            C = new HashMap();
            B = Collections.unmodifiableSet(C.keySet());
        }

    }

    static final class _E
    {

        final String A;
        _B F;
        _J K;
        _L D;
        _H J;
        _I E;
        _K I;
        _F G;
        _A C;
        _G H;
        _C B;

        _E(String s)
        {
            A = s;
        }
    }

    public static interface _G
    {

        public abstract void A(Y y, Object obj, ObjectOutputStream objectoutputstream)
            throws IOException;

        public abstract Object A(Y y, ObjectInputStream objectinputstream)
            throws IOException;

        public abstract Object A(Y y, Object obj, Y y1);
    }

    public static interface _I
    {
    }

    public static interface _J
    {
    }

    public static interface _C
    {

        public abstract void A(Y y);
    }

    public static interface _L
    {

        public abstract void A(Y y, Rectangle2D rectangle2d);
    }

    public static interface _K
    {

        public abstract void A(Y y, Graphics2D graphics2d);
    }

    public static interface _B
    {
    }

    public static interface _H
    {

        public abstract void B(Y y, Graphics2D graphics2d);

        public abstract void A(Y y, Graphics2D graphics2d);
    }

    public static interface _F
    {

        public abstract boolean A(Y y, double d, double d1, double d2, 
                double d3, Point2D point2d);
    }

    public static interface _A
    {

        public abstract boolean A(Y y, double d, double d1);
    }


    public static _D E1()
    {
        return D8;
    }

    public HA()
    {
        D6 = E1().B();
    }

    public HA(Y y)
    {
        super(y);
        if(y instanceof HA)
            A((HA)y);
        else
            D6 = E1().B();
    }

    public String DF()
    {
        return D6.A;
    }

    public void D(String s)
    {
        E1().A(this, s);
    }

    protected void A(HA ha)
    {
        D6 = ha.D6;
        if(D6.H != null)
            D5 = D6.H.A(ha, ha.D5, this);
        else
            D5 = ha.D5;
    }

    public Y A(Y y)
    {
        return new HA(y);
    }

    public void D(Graphics2D graphics2d)
    {
        if(I())
            C(graphics2d);
        super.B(graphics2d);
        A(graphics2d);
    }

    protected void K()
    {
        if(D6.B != null)
            D6.B.A(this);
    }

    public void E(Graphics2D graphics2d)
    {
        Graphics2D graphics2d1;
        if(D6.J == null)
            break MISSING_BLOCK_LABEL_46;
        graphics2d1 = (Graphics2D)graphics2d.create();
        D6.J.B(this, graphics2d1);
        graphics2d1.dispose();
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        graphics2d1.dispose();
        throw exception;
        super.E(graphics2d);
    }

    public void B(Graphics2D graphics2d)
    {
        Graphics2D graphics2d1;
        if(D6.J == null)
            break MISSING_BLOCK_LABEL_46;
        graphics2d1 = (Graphics2D)graphics2d.create();
        D6.J.A(this, graphics2d1);
        graphics2d1.dispose();
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        graphics2d1.dispose();
        throw exception;
        super.B(graphics2d);
    }

    public boolean D(double d, double d1)
    {
        if(D6.C != null)
            return D6.C.A(this, d, d1);
        else
            return super.D(d, d1);
    }

    public boolean A(double d, double d1, double d2, double d3, Point2D point2d)
    {
        if(D6.G != null)
            return D6.G.A(this, d, d1, d2, d3, point2d);
        else
            return super.A(d, d1, d2, d3, point2d);
    }

    public void C(Graphics2D graphics2d)
    {
        Graphics2D graphics2d1;
        if(D6.I == null)
            break MISSING_BLOCK_LABEL_46;
        graphics2d1 = (Graphics2D)graphics2d.create();
        D6.I.A(this, graphics2d1);
        graphics2d1.dispose();
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        graphics2d1.dispose();
        throw exception;
        super.C(graphics2d);
    }

    public void A(Rectangle2D rectangle2d)
    {
        if(D6.D != null)
            D6.D.A(this, rectangle2d);
        else
            super.A(rectangle2d);
    }

    public void A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.A(objectinputstream);
            E1().A(this, (String)objectinputstream.readObject());
            boolean flag = objectinputstream.readBoolean();
            if(flag)
                if(D6.H != null)
                    D5 = D6.H.A(this, objectinputstream);
                else
                    throw new H("No userDataHandler registered to read userData!");
            break;

        default:
            throw new H();
        }
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(0);
        super.A(objectoutputstream);
        objectoutputstream.writeObject(D6.A);
        if(D6.H != null)
        {
            objectoutputstream.writeBoolean(true);
            D6.H.A(this, D5, objectoutputstream);
        } else
        {
            objectoutputstream.writeBoolean(false);
        }
    }

    public Object E0()
    {
        return D5;
    }

    public void B(Object obj)
    {
        D5 = obj;
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    _E D6;
    Object D5;
    static _D D8 = new _D();
    static Class class$C$J$HA$_H; /* synthetic field */
    static Class class$C$J$HA$_B; /* synthetic field */
    static Class class$C$J$HA$_I; /* synthetic field */
    static Class class$C$J$HA$_K; /* synthetic field */
    static Class class$C$J$HA$_A; /* synthetic field */
    static Class class$C$J$HA$_F; /* synthetic field */
    static Class class$C$J$HA$_G; /* synthetic field */
    static Class class$C$J$HA$_L; /* synthetic field */
    static Class class$C$J$HA$_C; /* synthetic field */
    static Class class$C$J$HA$_J; /* synthetic field */

}
