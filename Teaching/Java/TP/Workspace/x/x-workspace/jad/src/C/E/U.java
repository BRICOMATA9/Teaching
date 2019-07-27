// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.*;
import java.util.*;

public class U
{
    static final class _A
    {

        List C;
        List B;
        List A;

        public _A()
        {
            C = new ArrayList(32);
            B = new ArrayList(32);
            A = new ArrayList(16);
        }
    }


    public U(D d, M m)
    {
        B = true;
        F = d;
        D = new ArrayList(d.S());
        C = new ArrayList(d.I());
        A(m);
    }

    public void A(M m)
    {
        E = new HashMap();
        G = m;
        for(F f = F.H(); f.C(); f.B())
        {
            T t = f.H();
            Object obj = m.D(t);
            _A _la = (_A)E.get(obj != null ? obj : A);
            if(_la == null)
            {
                _la = new _A();
                E.put(obj != null ? obj : A, _la);
            }
            _la.C.add(t);
            for(J j = t.W(); j != null; j = j.C())
            {
                Object obj1 = m.D(j.G());
                if(obj1 != obj && (obj1 == null || !obj1.equals(obj)))
                    _la.A.add(j);
            }

            for(J j1 = t.T(); j1 != null; j1 = j1.F())
            {
                Object obj2 = m.D(j1.E());
                if(obj2 == obj || obj2 != null && obj2.equals(obj))
                    _la.B.add(j1);
                else
                    _la.A.add(j1);
            }

        }

    }

    public void A(Object obj)
    {
        for(F f = F.H(); f.C(); f.B())
        {
            T t = f.H();
            Object obj1 = G.D(t);
            if(obj1 != obj && (obj == null || !obj.equals(obj1)))
                B(t);
        }

        _A _la = (_A)E.get(obj != null ? obj : A);
        if(_la != null)
        {
            for(int i = _la.C.size() - 1; i >= 0; i--)
            {
                T t1 = (T)_la.C.get(i);
                if(!F.E(t1))
                    A(t1);
            }

            for(int j = _la.B.size() - 1; j >= 0; j--)
            {
                J j1 = (J)_la.B.get(j);
                if(!F.A(j1))
                    A(j1);
            }

        }
    }

    public void B()
    {
        C();
        A();
    }

    public void C()
    {
        for(int i = C.size() - 1; i >= 0; i--)
        {
            T t = (T)C.get(i);
            if(!F.E(t))
                A(t);
        }

        C.clear();
    }

    public void A()
    {
        for(int i = D.size() - 1; i >= 0; i--)
        {
            J j = (J)D.get(i);
            if(!F.A(j))
                A(j);
        }

        D.clear();
    }

    public void B(T t)
    {
        if(!F.E(t))
            return;
        for(J j = t.W(); j != null;)
        {
            J j2 = j;
            j = j.C();
            D.add(j2);
            if(B)
                F.B(j2);
            else
                F.E(j2);
        }

        for(J j1 = t.T(); j1 != null;)
        {
            J j3 = j1;
            j1 = j1.F();
            D.add(j3);
            if(B)
                F.B(j3);
            else
                F.E(j3);
        }

        C.add(t);
        if(B)
            F.G(t);
        else
            F.A(t);
    }

    protected void A(J j)
    {
        if(B)
            F.C(j);
        else
            F.G(j);
    }

    protected void A(T t)
    {
        if(B)
            F.H(t);
        else
            F.D(t);
    }

    private D F;
    private List D;
    private List C;
    private boolean B;
    private M G;
    private Map E;
    private static final Object A = new Object();

}
