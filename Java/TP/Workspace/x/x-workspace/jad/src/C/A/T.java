// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;

import java.util.Arrays;
import java.util.Comparator;

// Referenced classes of package C.A:
//            H, D, J, U, 
//            F

public class T extends H
{
    class _C extends _E
        implements F
    {

        public Object D()
        {
            return E.I;
        }

        public T H()
        {
            return E.I;
        }

        _C()
        {
        }
    }

    class _F extends _B
        implements F
    {

        public Object D()
        {
            return B.H;
        }

        public T H()
        {
            return B.H;
        }

        _F()
        {
        }
    }

    class _A extends _D
        implements F
    {

        public Object D()
        {
            return C.A(T.this);
        }

        public T H()
        {
            return C.A(T.this);
        }

        _A()
        {
        }
    }

    class _B
        implements U
    {

        public boolean C()
        {
            return B != null;
        }

        public void B()
        {
            B = B.K;
        }

        public void G()
        {
            B = B.J;
        }

        public void E()
        {
            B = R;
        }

        public void A()
        {
            B = P;
        }

        public int F()
        {
            return T.this.T;
        }

        public Object D()
        {
            return B;
        }

        public J I()
        {
            return B;
        }

        J B;

        _B()
        {
            B = R;
        }
    }

    class _E
        implements U
    {

        public boolean C()
        {
            return E != null;
        }

        public void B()
        {
            E = E.E;
        }

        public void G()
        {
            E = E.G;
        }

        public void E()
        {
            E = S;
        }

        public void A()
        {
            E = Q;
        }

        public int F()
        {
            return N;
        }

        public Object D()
        {
            return E;
        }

        public J I()
        {
            return E;
        }

        J E;

        _E()
        {
            E = S;
        }
    }

    class _D
        implements U
    {

        public void B()
        {
            if(!D)
            {
                C = C.E;
                if(C == null)
                {
                    C = R;
                    D = true;
                }
            } else
            {
                C = C.K;
            }
        }

        public void G()
        {
            if(D)
            {
                C = C.J;
                if(C == null)
                {
                    C = Q;
                    D = false;
                }
            } else
            {
                C = C.G;
            }
        }

        public void E()
        {
            C = S;
            if(C == null)
            {
                C = R;
                D = true;
            } else
            {
                D = false;
            }
        }

        public void A()
        {
            C = P;
            if(C == null)
            {
                C = Q;
                D = false;
            } else
            {
                D = true;
            }
        }

        public boolean C()
        {
            return C != null;
        }

        public Object D()
        {
            return C;
        }

        public J I()
        {
            return C;
        }

        public int F()
        {
            return S();
        }

        boolean D;
        J C;

        _D()
        {
            E();
        }
    }


    protected T(D d)
    {
        d.B(this);
    }

    public int S()
    {
        return N + T;
    }

    public int P()
    {
        return T;
    }

    public int Y()
    {
        return N;
    }

    public int Q()
    {
        if(M.F)
            M.T();
        return O;
    }

    public D _()
    {
        return M;
    }

    public J T()
    {
        return S;
    }

    public J W()
    {
        return R;
    }

    public J U()
    {
        return Q;
    }

    public J N()
    {
        return P;
    }

    public U R()
    {
        return new _D();
    }

    public U M()
    {
        return new _B();
    }

    public U Z()
    {
        return new _E();
    }

    public F X()
    {
        return new _A();
    }

    public F V()
    {
        return new _F();
    }

    public F a()
    {
        return new _C();
    }

    public J D(T t)
    {
        if(t.T < N)
            return t.C(this);
        for(J j = S; j != null; j = j.E)
            if(j.I == t)
                return j;

        return null;
    }

    public J C(T t)
    {
        if(t.N < T)
            return t.D(this);
        for(J j = R; j != null; j = j.K)
            if(j.H == t)
                return j;

        return null;
    }

    public J B(T t)
    {
        J j = D(t);
        if(j == null)
            j = C(t);
        return j;
    }

    public void B(Comparator comparator)
    {
        if(T > 1)
            if(T > 2 || comparator == null)
                A(comparator, new J[T]);
            else
                A(comparator, ((J []) (null)));
    }

    public void A(Comparator comparator)
    {
        if(N > 1)
            if(N > 2 || comparator == null)
                B(comparator, new J[N]);
            else
                B(comparator, null);
    }

    public String toString()
    {
        if(_() != null)
            return "node index:" + Q();
        else
            return "node without a graph";
    }

    void A(D d, int i)
    {
        A(i);
        M = d;
    }

    void B(D d)
    {
        M = d;
    }

    void E(J j)
    {
        j.G = Q;
        j.E = null;
        if(Q != null)
            Q.E = j;
        else
            S = j;
        Q = j;
        N++;
    }

    void C(J j)
    {
        j.E = S;
        j.G = null;
        if(S != null)
            S.G = j;
        else
            Q = j;
        S = j;
        N++;
    }

    void B(J j, J j1, int i)
    {
        if(i == 0)
        {
            if(j1 == null)
                E(j);
            else
            if(j1 == Q)
            {
                E(j);
            } else
            {
                if(Q == null)
                {
                    j.G = null;
                    j.E = null;
                    S = Q = j;
                } else
                {
                    J j2 = j1.E;
                    j1.E = j;
                    j.E = j2;
                    j2.G = j;
                    j.G = j1;
                }
                N++;
            }
        } else
        if(j1 == null)
            E(j);
        else
        if(j1 == S)
        {
            C(j);
        } else
        {
            if(Q == null)
            {
                j.G = null;
                j.E = null;
                S = Q = j;
            } else
            {
                J j3 = j1.G;
                j1.G = j;
                j.G = j3;
                j3.E = j;
                j.E = j1;
            }
            N++;
        }
    }

    void B(J j)
    {
        j.J = P;
        j.K = null;
        if(P != null)
            P.K = j;
        else
            R = j;
        P = j;
        T++;
    }

    void D(J j)
    {
        j.K = R;
        j.J = null;
        if(R != null)
            R.J = j;
        else
            P = j;
        R = j;
        T++;
    }

    void A(J j, J j1, int i)
    {
        if(i == 0)
        {
            if(j1 == null)
                B(j);
            else
            if(j1 == P)
            {
                B(j);
            } else
            {
                if(P == null)
                {
                    j.J = null;
                    j.K = null;
                    R = P = j;
                } else
                {
                    J j2 = j1.K;
                    j1.K = j;
                    j.K = j2;
                    j2.J = j;
                    j.J = j1;
                }
                T++;
            }
        } else
        if(j1 == null)
            B(j);
        else
        if(j1 == R)
        {
            D(j);
        } else
        {
            if(P == null)
            {
                j.J = null;
                j.K = null;
                R = P = j;
            } else
            {
                J j3 = j1.J;
                j1.J = j;
                j.J = j3;
                j3.K = j;
                j.K = j1;
            }
            T++;
        }
    }

    void F(J j)
    {
        if(j != S)
            j.G.E = j.E;
        else
            S = j.E;
        if(j != Q)
            j.E.G = j.G;
        else
            Q = j.G;
        N--;
    }

    void A(J j)
    {
        if(j != R)
            j.J.K = j.K;
        else
            R = j.K;
        if(j != P)
            j.K.J = j.J;
        else
            P = j.J;
        T--;
    }

    void O()
    {
        S = R = P = Q = null;
        N = T = 0;
    }

    void B(Comparator comparator, J aj[])
    {
        if(N < 2)
            return;
        if(N == 2 && comparator != null)
        {
            if(comparator.compare(S, Q) > 0)
            {
                Q = S;
                S = Q.E;
                Q.G = S;
                S.E = Q;
                Q.E = S.G = null;
            }
            return;
        }
        int l = N;
        int i = 0;
        J j;
        for(j = S; j != null; j = j.E)
        {
            aj[i] = j;
            i++;
        }

        Arrays.sort(aj, 0, l, comparator);
        J j1 = S = aj[0];
        j1.G = null;
        for(int k = 1; k < l;)
        {
            j = aj[k];
            j.G = j1;
            j1.E = j;
            k++;
            j1 = j;
        }

        Q = j;
        j.E = null;
    }

    void A(Comparator comparator, J aj[])
    {
        if(T < 2)
            return;
        if(T == 2 && comparator != null)
        {
            if(comparator.compare(R, P) > 0)
            {
                P = R;
                R = P.K;
                P.J = R;
                R.K = P;
                P.K = R.J = null;
            }
            return;
        }
        int l = T;
        int i = 0;
        J j;
        for(j = R; j != null; j = j.K)
        {
            aj[i] = j;
            i++;
        }

        Arrays.sort(aj, 0, l, comparator);
        J j1 = R = aj[0];
        j1.J = null;
        for(int k = 1; k < l;)
        {
            j = aj[k];
            j.J = j1;
            j1.K = j;
            k++;
            j1 = j;
        }

        P = j;
        j.K = null;
    }

    D M;
    J R;
    J S;
    J Q;
    J P;
    int N;
    int T;
    int O;
}
