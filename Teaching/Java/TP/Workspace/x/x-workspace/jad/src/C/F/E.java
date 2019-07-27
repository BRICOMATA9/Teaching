// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;

public class E
{
    static final class _A
    {

        final boolean C()
        {
            return E < 0;
        }

        final void B()
        {
            E--;
        }

        final T A()
        {
            return B[E];
        }

        final J F()
        {
            return A[E];
        }

        final byte D()
        {
            return C[E];
        }

        final int E()
        {
            return D[E];
        }

        final int A(T t, J j, byte byte0, int i)
        {
            E++;
            if(E == B.length)
            {
                int k = (E + 1) * 2;
                T at[] = new T[k];
                System.arraycopy(B, 0, at, 0, B.length);
                B = at;
                J aj[] = new J[k];
                System.arraycopy(A, 0, aj, 0, A.length);
                A = aj;
                int ai[] = new int[k];
                System.arraycopy(D, 0, ai, 0, D.length);
                D = ai;
                byte abyte0[] = new byte[k];
                System.arraycopy(C, 0, abyte0, 0, C.length);
                C = abyte0;
            }
            B[E] = t;
            A[E] = j;
            C[E] = byte0;
            return D[E] = i;
        }

        final void A(J j, byte byte0)
        {
            A[E] = j;
            C[E] = byte0;
        }

        int E;
        byte C[];
        J A[];
        int D[];
        T B[];

        _A(int i)
        {
            E = -1;
            D = new int[i];
            A = new J[i];
            C = new byte[i];
            B = new T[i];
        }
    }


    public E()
    {
        H = false;
        A = true;
    }

    public void B(boolean flag)
    {
        H = flag;
    }

    public void A(boolean flag)
    {
        A = flag;
    }

    public void A(D d)
    {
        if(d.G() == 0)
        {
            return;
        } else
        {
            A(d, d.L());
            return;
        }
    }

    public void A(D d, T t)
    {
        if(t == null)
            return;
        F = d.W();
        if(!H)
            B = d.V();
        D = 0;
        E = 0;
        int i = Math.min(60, d.I() + 3);
        _A _la = new _A(i);
        try
        {
            A(_la, t);
            if(A)
            {
                for(F f = d.H(); f.C(); f.B())
                {
                    T t1 = f.H();
                    if(F.D(t1) == null)
                    {
                        A(t1);
                        A(_la, t1);
                    }
                }

            }
        }
        finally
        {
            Object obj = null;
            d.A(F);
            F = null;
            if(!H)
            {
                d.A(B);
                B = null;
            }
        }
    }

    private final J A(T t, J j, byte abyte0[])
    {
        switch(abyte0[0])
        {
        case 0: // '\0'
            if(H)
            {
                abyte0[0] = 1;
                return t.T();
            }
            J j1 = t.T();
            if(j1 == null)
            {
                j1 = t.W();
                abyte0[0] = 3;
                return j1;
            } else
            {
                abyte0[0] = 2;
                return j1;
            }

        case 1: // '\001'
            return j.F();

        case 2: // '\002'
            J j2 = j.F();
            if(j2 == null)
            {
                j2 = t.W();
                abyte0[0] = 3;
            }
            return j2;

        case 3: // '\003'
            return j.C();
        }
        throw new InternalError();
    }

    private final void A(_A _pa, T t)
    {
        I[0] = 0;
        T t1 = t;
        F.A(t1, G);
        A(t1, ++D);
        J j = A(t1, ((J) (null)), I);
        _pa.A(t1, j, I[0], D);
        do
        {
            if(_pa.C())
                break;
            J j1 = _pa.F();
            I[0] = _pa.D();
            while(j1 != null) 
                if(H || !B.B(j1))
                {
                    T t2;
                    if(!H)
                    {
                        B.A(j1, true);
                        t2 = j1.A(t1);
                    } else
                    {
                        t2 = j1.E();
                    }
                    if(F.D(t2) == null)
                    {
                        A(j1, t2, true);
                        F.A(t2, G);
                        t1 = t2;
                        A(t1, ++D);
                        I[0] = 0;
                        j1 = A(t1, ((J) (null)), I);
                        _pa.A(t1, j1, I[0], D);
                    } else
                    {
                        A(j1, t2, false);
                        j1 = A(t1, j1, I);
                        _pa.A(j1, I[0]);
                    }
                } else
                {
                    j1 = A(t1, j1, I);
                    _pa.A(j1, I[0]);
                }
            A(t1, _pa.E(), ++E);
            F.A(t1, J);
            _pa.B();
            if(!_pa.C())
            {
                J j2 = _pa.F();
                A(j2, t1);
                t1 = _pa.A();
                I[0] = _pa.D();
                J j3 = A(t1, j2, I);
                _pa.A(j3, I[0]);
            }
        } while(true);
    }

    protected void A(T t, int i)
    {
    }

    protected void A(T t, int i, int j)
    {
    }

    protected void A(J j, T t, boolean flag)
    {
    }

    protected void A(J j, T t)
    {
    }

    protected void A(T t)
    {
    }

    private L B;
    private int D;
    private int E;
    private boolean A;
    private boolean H;
    protected K F;
    protected static final Object C = null;
    protected static final Object G = new Object();
    protected static final Object J = new Object();
    private final byte I[] = new byte[1];

}
