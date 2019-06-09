// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.F;
import C.A.S;
import C.A.T;
import C.A.Y;
import C.G.E.A.AA;
import C.G.E.A.Q;
import C.G.E.A.r;
import C.G.E.A.u;
import C.G.E.A.v;
import C.G.I;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class H
    implements r
{
    private static final class _A
    {

        final Y B = new Y();
        final Y C = new Y();
        final Y A = new Y();

        _A()
        {
        }
    }


    public H(r r1)
    {
        B = r1;
        C = false;
        A = null;
    }

    public Comparator A()
    {
        return A;
    }

    public void A(Comparator comparator)
    {
        A = comparator;
    }

    public void A(boolean flag)
    {
        C = flag;
    }

    public void A(I i, Q q, v v1, AA aa)
    {
        if(B == null)
            return;
        B.A(i, q, v1, aa);
        int j = 0;
        for(int k = q.B(); j < k; j++)
        {
            u u1 = q.B(j);
            S s = u1.A();
            _A _la = new _A();
            ArrayList arraylist = new ArrayList();
            arraylist.add(_la);
            for(F f = s.O(); f.C(); f.B())
            {
                T t = f.H();
                C.G.E.A.H h = v1.A(t);
                if(h.E() == 13)
                {
                    if(A != null)
                        _la.A.A(A);
                    if(C)
                    {
                        _la.B.A(_la.A);
                        _la.B.A(_la.C);
                    } else
                    {
                        _la.B.A(_la.C);
                        _la.B.A(_la.A);
                    }
                    _A _la1 = (_A)arraylist.remove(arraylist.size() - 1);
                    _la = (_A)arraylist.get(arraylist.size() - 1);
                    _la.C.A(_la1.B);
                    _la.C.add(t);
                    continue;
                }
                if(h.E() == 12)
                {
                    _la.C.add(t);
                    _la = new _A();
                    arraylist.add(_la);
                    continue;
                }
                if(h.E() != 0 || h.A() + t.S() > 0)
                    _la.C.add(t);
                else
                    _la.A.add(t);
            }

            if(!_la.A.isEmpty() || !_la.C.isEmpty())
            {
                if(A != null)
                    _la.A.A(A);
                if(C)
                {
                    _la.B.A(_la.A);
                    _la.B.A(_la.C);
                } else
                {
                    _la.B.A(_la.C);
                    _la.B.A(_la.A);
                }
            }
            u1.A(_la.B);
        }

    }

    private final r B;
    private Comparator A;
    private boolean C;
}
