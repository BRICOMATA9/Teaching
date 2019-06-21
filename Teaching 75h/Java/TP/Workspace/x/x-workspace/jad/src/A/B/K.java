// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.J;
import C.A.M;
import C.E.T;
import C.G.E;
import C.G.I;

final class K extends T
{

    K(boolean flag, C.A.K k, M m)
    {
        c = flag;
        h = k;
        g = m;
    }

    public Object D(Object obj)
    {
        J j = (J)obj;
        C.A.T t = c ? j.G() : j.E();
        Object aobj[] = (Object[])h.D(t);
        if(aobj == null)
        {
            aobj = new Object[4];
            for(int k = 0; k < aobj.length; k++)
                aobj[k] = new Object();

            h.A(t, ((Object) (aobj)));
        }
        if(g != null)
        {
            A.C.A._C _lc = ((A.C.A._F)g.D(j)).B();
            if(A.W == _lc)
                return aobj[0];
            if(A.E == _lc)
                return aobj[1];
            if(A.P == _lc)
                return aobj[2];
            if(A.J == _lc)
                return aobj[3];
            else
                return t;
        } else
        {
            return t;
        }
    }

    static void A(I j, boolean flag)
    {
        M m = j.B(d);
        if(m != null)
        {
            j.D(d);
            j.A(e, m);
        }
        m = j.B(f);
        if(m != null)
        {
            j.D(f);
            j.A(i, m);
        }
        j.A(flag ? d : f, new K(flag, j.W(), j.B(A.D)));
    }

    static void A(I j)
    {
        M m = j.B(d);
        if(m instanceof K)
        {
            j.A(((K)m).h);
            j.D(d);
        }
        m = j.B(f);
        if(m instanceof K)
        {
            j.A(((K)m).h);
            j.D(f);
        }
        m = j.B(i);
        if(m != null)
        {
            j.D(i);
            j.A(f, m);
        }
        m = j.B(e);
        if(m != null)
        {
            j.D(e);
            j.A(d, m);
        }
    }

    private static final Object e = "BusIdProvider.ORIGINAL_SOURCE_GROUPID_KEY";
    private static final Object i = "BusIdProvider.ORIGINAL_TARGET_GROUPID_KEY";
    private static final Object d;
    private static final Object f;
    private final M g;
    private final C.A.K h;
    private final boolean c;

    static 
    {
        d = E.A;
        f = E.B;
    }
}
