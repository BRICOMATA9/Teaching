// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import C.A.I;
import C.A.Y;
import java.util.Vector;

// Referenced classes of package C.K:
//            M, J, D, L

public final class C
{
    class _B
        implements L
    {

        public boolean C()
        {
            return K.C();
        }

        public void B()
        {
            J = K.K();
            K.B();
        }

        public void E()
        {
            K.E();
            if(K.C())
            {
                J = K.K();
                K.B();
            }
        }

        public Object D()
        {
            return L();
        }

        public J L()
        {
            M m = K.K();
            if(J == null || m == null)
                throw new NullPointerException();
            else
                return new J(J, m);
        }

        D K;
        M J;

        _B(D d)
        {
            J = null;
            K = d;
            if(K.C())
            {
                J = K.K();
                K.B();
            }
        }
    }

    class _A
        implements D
    {

        public boolean C()
        {
            return I.C();
        }

        public void B()
        {
            I.B();
        }

        public void E()
        {
            I.E();
        }

        public Object D()
        {
            return I.D();
        }

        public M K()
        {
            return (M)I.D();
        }

        I I;

        _A(I i)
        {
            I = i;
        }
    }


    public C()
    {
        B = new Y();
    }

    public C(Vector vector)
    {
        if(vector == null)
        {
            B = new Y();
        } else
        {
            B = new Y();
            for(int i = 0; i < vector.size(); i++)
                B.add(vector.elementAt(i));

        }
    }

    public C(M am[])
    {
        if(am == null)
            B = new Y();
        else
            B = new Y(am);
    }

    public I B()
    {
        return B.B();
    }

    public D C()
    {
        return new _A(B.B());
    }

    public int D()
    {
        return B.size();
    }

    public L A()
    {
        return new _B(C());
    }

    public J A(int i)
    {
        if(i + 1 > B.size())
            return null;
        M m = (M)B.B(i);
        M m1 = (M)B.B(i + 1);
        if(m == null || m1 == null)
            return null;
        else
            return new J(m, m1);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("YPointPath:\n");
        for(I i = B(); i.C(); i.B())
        {
            M m = (M)i.D();
            stringbuffer.append(m.toString() + "\n");
        }

        return stringbuffer.toString();
    }

    public static final C A = new C();
    Y B;

}
