// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.F;
import C.A.J;
import C.A.K;
import C.A.L;
import C.A.T;
import C.A.U;
import C.K.G;
import C.K.M;

// Referenced classes of package C.G:
//            k, j, Q, I, 
//            o, D, Z, f, 
//            V, K

public class m
    implements k
{

    public m()
    {
        _fld0105 = false;
        _fld0104 = true;
        _fld0103 = false;
        _fld0109 = true;
    }

    public void A(j j1)
    {
        _fld0108 = j1;
    }

    public void A(I l)
    {
        if(_fld0108 != null)
        {
            if(n() || o())
                j(l);
            _fld0108.A(l);
            i(l);
            h(l);
        }
    }

    private void j(I l)
    {
        C.A.M m1 = l.B(Q.C);
        if(m1 == null && n())
        {
            _fld0106 = l.V();
            l.A(Q.C, _fld0106);
            for(U u = l.M(); u.C(); u.B())
            {
                J j1 = u.I();
                f f2 = l.E(j1.G());
                f f3 = l.E(j1.E());
                C.G.M m3 = l.H(j1);
                D ad[] = l.F(j1);
                o ao1[] = new o[ad.length];
                for(int k1 = 0; k1 < ad.length; k1++)
                {
                    G g1 = ad[k1].A();
                    ao1[k1] = new o(g1.Q(), g1.R(), ad[k1].L());
                    M m5 = ad[k1].K().A(g1, m3, f2, f3, ad[k1].B());
                    ao1[k1].A(m5.A - (f2.C() + f2.B() * 0.5D), m5.D - (f2.A() + f2.D() * 0.5D));
                }

                _fld0106.A(j1, ao1);
            }

        }
        C.A.M m2 = l.B(Q.D);
        if(m2 == null && o())
        {
            _fld0107 = l.W();
            l.A(Q.D, _fld0107);
            for(F f1 = l.H(); f1.C(); f1.B())
            {
                T t = f1.H();
                f f4 = l.E(t);
                V av[] = l.G(t);
                o ao[] = new o[av.length];
                for(int i1 = 0; i1 < av.length; i1++)
                {
                    G g = av[i1].A();
                    ao[i1] = new o(g.Q(), g.R());
                    M m4 = av[i1].C().A(g, f4, av[i1].B());
                    ao[i1].A(m4.A - (f4.C() + f4.B() * 0.5D), m4.D - (f4.A() + f4.D() * 0.5D));
                }

                _fld0107.A(t, ao);
            }

        }
    }

    private void h(I l)
    {
        if(_fld0106 != null)
        {
            l.D(Q.C);
            l.A(_fld0106);
            _fld0106 = null;
        }
        if(_fld0107 != null)
        {
            l.D(Q.D);
            l.A(_fld0107);
            _fld0107 = null;
        }
    }

    private void i(I l)
    {
        C.A.M m1 = l.B(Q.C);
        C.A.M m2 = l.B(Q.D);
        if(m1 == null && m2 == null)
            return;
        if(!_fld0109 && !_fld0103)
            return;
        for(F f1 = l.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            if(m2 != null && _fld0103)
            {
                o ao[] = (o[])m2.D(t);
                V av[] = l.G(t);
                if(ao != null && av != null && ao.length == av.length)
                {
                    for(int i1 = 0; i1 < av.length; i1++)
                        A(l, t, av[i1], ao[i1]);

                }
            }
            if(m1 == null || !_fld0109)
                continue;
            for(J j1 = t.T(); j1 != null; j1 = j1.F())
            {
                o ao1[] = (o[])m1.D(j1);
                D ad[] = l.F(j1);
                if(ao1 == null || ad == null || ao1.length != ad.length)
                    continue;
                for(int k1 = 0; k1 < ad.length; k1++)
                    A(l, j1, ad[k1], ao1[k1]);

            }

        }

    }

    private void A(I l, J j1, D d, o o1)
    {
        Z z = d.K();
        d.A(z.A(o1.J(), l.H(j1), l.E(j1.G()), l.E(j1.E())));
    }

    private void A(I l, T t, V v, o o1)
    {
        C.G.K k1 = v.C();
        v.A(k1.A(o1.J(), l.E(t)));
    }

    public void U(boolean flag)
    {
        _fld0109 = flag;
    }

    public void W(boolean flag)
    {
        _fld0103 = flag;
    }

    public boolean o()
    {
        return _fld0105;
    }

    public void V(boolean flag)
    {
        _fld0105 = flag;
    }

    public boolean n()
    {
        return _fld0104;
    }

    public void T(boolean flag)
    {
        _fld0104 = flag;
    }

    private j _fld0108;
    private L _fld0106;
    private K _fld0107;
    private boolean _fld0105;
    private boolean _fld0104;
    private boolean _fld0103;
    private boolean _fld0109;
}
