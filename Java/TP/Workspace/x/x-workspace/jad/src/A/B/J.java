// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.A;
import C.A.L;
import C.A.S;
import C.A.T;
import C.A.U;
import C.F.F;
import C.G.E.A.O;
import C.G.E.A.Q;
import C.G.E.A.u;
import C.G.E.A.v;
import C.G.I;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class J
    implements O
{
    private static final class _A
    {

        void A(I i)
        {
            U u1 = D.L();
            if(u1.C())
            {
                i.E(u1.I());
                u1.B();
            }
            for(; u1.C(); u1.B())
            {
                C.A.J j = u1.I();
                C.add(j.G());
                i.E(j);
            }

            for(C.A.F f = C.O(); f.C(); f.B())
            {
                T t = f.H();
                A a = new A(t.M());
                for(U u2 = a.L(); u2.C(); u2.B())
                {
                    C.A.J j1 = u2.I();
                    if(j1.G() != A)
                    {
                        F.put(j1, j1.E());
                        i.B(j1, j1.G(), A);
                    } else
                    {
                        B.add(j1);
                        i.E(j1);
                    }
                }

                A a1 = new A(t.Z());
                for(U u3 = a1.L(); u3.C(); u3.B())
                {
                    C.A.J j2 = u3.I();
                    if(A != j2.E())
                    {
                        E.put(j2, j2.G());
                        i.B(j2, A, j2.E());
                    } else
                    {
                        B.add(j2);
                        i.E(j2);
                    }
                }

                i.A(t);
            }

        }

        void B(I i)
        {
            C.A.F f = C.O();
            f.A();
            for(; f.C(); f.G())
                i.D(f.H());

            for(U u1 = B.L(); u1.C(); u1.B())
                i.G(u1.I());

            java.util.Map.Entry entry;
            C.A.J j;
            for(Iterator iterator = E.entrySet().iterator(); iterator.hasNext(); i.B(j, (T)entry.getValue(), j.E()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                j = (C.A.J)entry.getKey();
            }

            java.util.Map.Entry entry1;
            C.A.J j1;
            for(Iterator iterator1 = F.entrySet().iterator(); iterator1.hasNext(); i.B(j1, j1.G(), (T)entry1.getValue()))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
                j1 = (C.A.J)entry1.getKey();
            }

            U u2 = D.L();
            u2.A();
            for(; u2.C(); u2.G())
                i.G(u2.I());

        }

        final T A;
        final A D;
        final S C = new S();
        private final A B = new A();
        private final Map E = new HashMap();
        private final Map F = new HashMap();

        _A(A a)
        {
            A = a.K().G();
            D = a;
        }
    }


    public J(O o)
    {
        E = o;
        F = true;
    }

    public void C(boolean flag)
    {
        F = flag;
    }

    public void A(I i, Q q, v v)
    {
        if(E == null)
            return;
        if(F)
            B(i, q, v);
        else
            C(i, q, v);
    }

    private void C(I i, Q q, v v)
    {
        L l = i.V();
        C.A.M m = i.B(D);
        if(m != null)
            C.F.F.A(i, l, m);
        else
            C.F.F.B(i, l);
        A a = new A();
        for(U u1 = i.M(); u1.C(); u1.B())
        {
            C.A.J j = u1.I();
            if(l.B(j))
                a.add(j);
        }

        i.A(l);
        for(U u2 = a.L(); u2.C(); u2.B())
            i.E(u2.I());

        E.A(i, q, v);
        for(U u3 = a.L(); u3.C(); u3.B())
            i.G(u3.I());

    }

    private void B(I i, Q q, v v)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        for(A a = C.F.F.A(i, true); !a.isEmpty(); a = C.F.F.A(i, true))
        {
            _A _la = new _A(a);
            _la.A(i);
            Object obj = (List)linkedhashmap.get(_la.A);
            if(obj == null)
            {
                obj = new ArrayList(1);
                linkedhashmap.put(_la.A, obj);
            }
            ((List) (obj)).add(_la);
        }

        E.A(i, q, v);
        HashMap hashmap = new HashMap();
        int j = 0;
        for(int k = q.B(); j < k; j++)
        {
            u u1 = q.B(j);
            for(C.A.F f = u1.A().O(); f.C(); f.B())
                hashmap.put(f.H(), u1);

        }

        ArrayList arraylist = new ArrayList(linkedhashmap.size());
        for(Iterator iterator = linkedhashmap.keySet().iterator(); iterator.hasNext(); arraylist.add(iterator.next()));
        for(int l = arraylist.size(); l-- > 0;)
        {
            List list = (List)linkedhashmap.get(arraylist.get(l));
            int k1 = list.size();
            while(k1-- > 0) 
            {
                _A _la1 = (_A)list.get(k1);
                _la1.B(i);
                u u3 = (u)hashmap.get(_la1.A);
                C.A.F f2 = _la1.C.O();
                while(f2.C()) 
                {
                    u3.A(f2.H());
                    hashmap.put(f2.H(), u3);
                    f2.B();
                }
            }
        }

        hashmap.clear();
        int i1 = 0;
        for(int j1 = q.B(); i1 < j1; i1++)
        {
            u u2 = q.B(i1);
            for(C.A.F f1 = u2.A().O(); f1.C(); f1.B())
                hashmap.put(f1.H(), u2);

        }

    }

    public static final Object D = "CycleAwareLayerer.EDGE_WEIGHT_DP_KEY";
    private final O E;
    private boolean F;

}
