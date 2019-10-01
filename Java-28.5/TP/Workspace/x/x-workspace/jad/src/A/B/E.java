// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.F;
import C.A.K;
import C.A.M;
import C.A.T;
import C.G.I;
import C.G.h;
import C.G.j;

// Referenced classes of package A.B:
//            L, D, C, K, 
//            F

abstract class E
    implements j
{

    E()
    {
        G = true;
        E = true;
    }

    public void A(I i)
    {
        boolean flag = i.B(F) == null;
        if(flag)
        {
            final M nodeInfos = i.B(A.L);
            if(nodeInfos != null)
            {
                C.E.T t = new C.E.T() {

                    public int A(Object obj)
                    {
                        A.C.A._D _ld = (A.C.A._D)nodeInfos.D(obj);
                        if(_ld != null)
                            return _ld.C();
                        else
                            return -1;
                    }

                };
                i.A(F, t);
            } else
            {
                K k = i.W();
                for(F f = i.H(); f.C(); f.B())
                {
                    T t1 = f.H();
                    k.A(t1, t1.S());
                }

                i.A(F, k);
            }
        }
        h h1 = new h();
        h1.A(B());
        h1.C(new L());
        if(A())
            h1.C(new D());
        h1.C(new L());
        if(E)
            h1.C(new C());
        if(G)
            A.B.K.A(i, E);
        h1.A(i);
        if(G)
            A.B.K.A(i);
        if(flag)
        {
            M m = i.B(F);
            if(m instanceof K)
                i.A((K)m);
            i.D(F);
        }
    }

    public boolean C()
    {
        return G;
    }

    public void A(boolean flag)
    {
        G = flag;
    }

    public boolean D()
    {
        return E;
    }

    public void B(boolean flag)
    {
        E = flag;
    }

    public abstract boolean A();

    abstract j B();

    private static final Object F;
    boolean G;
    boolean E;

    static 
    {
        F = F.B;
    }
}
