// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.D;
import C.A.F;
import C.A.J;
import C.A.K;
import C.A.M;
import C.A.S;
import C.A.T;
import C.A.U;
import java.util.ArrayList;
import java.util.Stack;

// Referenced classes of package C.F:
//            H, G

class B
{
    static final class _B
    {

        public void A(_A _pa)
        {
            _pa.D = null;
            _pa.B = null;
            if(A == null)
            {
                B = A = _pa;
            } else
            {
                A.B = _pa;
                _pa.D = A;
                A = _pa;
            }
        }

        public void B(_A _pa)
        {
            if(_pa != B)
                _pa.D.B = _pa.B;
            else
                B = _pa.B;
            if(_pa != A)
                _pa.B.D = _pa.D;
            else
                A = _pa.D;
        }

        public _A B;
        public _A A;

        _B()
        {
        }
    }

    static final class _A
    {

        _A B;
        _A D;
        final int A;
        int E;
        final J C;

        _A(int i, J j)
        {
            A = i;
            C = j;
        }
    }


    B()
    {
    }

    public int A(D d, K k, M m, M m1, M m2, T t, boolean flag)
    {
        if(d.G() < 1)
            return 0;
        if(d.G() == 1)
        {
            k.A(d.L(), 0);
            return 1;
        }
        Y = d;
        A(k, m, m1, flag, t, m2);
        J j;
        while((j = C()) != null) 
        {
            J j1 = A(j);
            B(j, j1);
        }
        int i = F();
        for(F f = d.H(); f.C(); f.B())
            k.A(f.H(), E[f.H().Q()]);

        return i;
    }

    private void A(K k, M m, M m1, boolean flag, T t, M m2)
    {
        K = Y.G();
        L = Y.F();
        Q = new int[L];
        if(m != null)
        {
            for(U u = Y.M(); u.C(); u.B())
            {
                J j1 = u.I();
                Q[j1.L()] = m.A(j1);
            }

        } else
        {
            for(int i = 0; i < Q.length; i++)
                Q[i] = 1;

        }
        a = new int[L];
        if(m1 != null)
        {
            for(U u1 = Y.M(); u1.C(); u1.B())
            {
                J j2 = u1.I();
                a[j2.L()] = m1.A(j2);
            }

        } else
        {
            for(int j = 0; j < Q.length; j++)
                a[j] = 1;

        }
        E = new int[K];
        if(flag)
        {
            for(F f = Y.H(); f.C(); f.B())
            {
                T t1 = f.H();
                E[t1.Q()] = k.A(t1);
            }

        } else
        {
            A();
        }
        P = new int[K];
        V = new int[K];
        M = new int[K];
        S = new J[K];
        B = new int[L];
        T = new _B();
        if(t == null)
            W = Y.H().H();
        else
            W = t;
        C = new _A[L];
        N = new _A[L];
        for(U u2 = Y.M(); u2.C(); u2.B())
        {
            J j3 = u2.I();
            int k1 = j3.L();
            C[k1] = new _A(k1, j3);
            N[k1] = new _A(k1, j3);
        }

        Z = new _B[K];
        for(int l = 0; l < Z.length; l++)
            Z[l] = new _B();

        H = new boolean[L];
        if(m2 != null)
        {
            for(U u3 = Y.M(); u3.C(); u3.B())
            {
                J j4 = u3.I();
                if(m2.B(j4))
                    H[j4.L()] = true;
            }

        } else
        {
            E();
        }
        D();
        A = T.B;
        G = new boolean[L];
        X = new int[K];
        F = new int[K];
        O = new int[L];
        _ = new int[L];
        D = Y.Q();
        for(int i1 = 0; i1 < L; i1++)
        {
            J j5 = D[i1];
            O[i1] = j5.G().Q();
            _[i1] = j5.E().Q();
        }

        U = new ArrayList(K);
        I = new ArrayList(K);
        J = new int[K];
        B();
    }

    private void A()
    {
        S s = C.F.H.B(Y);
        for(F f = s.O(); f.C(); f.B())
        {
            T t = f.H();
            int i = E[t.Q()];
            for(U u = t.Z(); u.C(); u.B())
            {
                J j = u.I();
                if(i + a[j.L()] > E[j.E().Q()])
                    E[j.E().Q()] = i + a[j.L()];
            }

        }

    }

    private void E()
    {
        G g = new G();
        g.A(Y, E, a);
        Stack stack = new Stack();
        stack.push(W);
        boolean aflag[] = new boolean[K];
        U au[] = new U[K];
        for(F f = Y.H(); f.C(); f.B())
            au[f.H().Q()] = f.H().R();

        do
        {
            if(stack.isEmpty())
                break;
            T t = (T)stack.peek();
            aflag[t.Q()] = true;
            U u = au[t.Q()];
            do
            {
                if(!u.C())
                    break;
                J j = u.I();
                T t1 = j.A(t);
                if(!aflag[t1.Q()] && E[j.E().Q()] - E[j.G().Q()] - a[j.L()] == 0)
                {
                    H[j.L()] = true;
                    stack.push(t1);
                    break;
                }
                u.B();
            } while(true);
            if(stack.peek() == t)
                stack.pop();
        } while(true);
    }

    private void D()
    {
        Stack stack = new Stack();
        stack.push(W);
        boolean aflag[] = new boolean[K];
        U au[] = new U[K];
        for(F f = Y.H(); f.C(); f.B())
            au[f.H().Q()] = f.H().R();

        do
        {
            if(stack.isEmpty())
                break;
            T t = (T)stack.peek();
            aflag[t.Q()] = true;
            U u = au[t.Q()];
            do
            {
                if(!u.C())
                    break;
                J j = u.I();
                T t1 = j.A(t);
                if(!aflag[t1.Q()] && H[j.L()])
                {
                    _A _la = C[j.L()];
                    _la.E = t1.Q();
                    Z[t.Q()].A(_la);
                    S[t1.Q()] = j;
                    T.A(N[j.L()]);
                    stack.push(t1);
                    break;
                }
                u.B();
            } while(true);
            if(stack.peek() == t)
                stack.pop();
        } while(true);
    }

    private void B()
    {
        B(W, null, 1, 0);
        int i = Y.G();
        C.E.A.B b = new C.E.A.B(Y, i + 1);
        for(F f = Y.H(); f.C(); f.B())
        {
            T t = f.H();
            b.A(t, i - M[t.Q()]);
        }

        for(; !b.B(); A(b.C()));
        b.A();
    }

    private void A(T t)
    {
        if(t == W)
            return;
        J j = S[t.Q()];
        int i = Q[j.L()];
        for(U u = t.R(); u.C(); u.B())
        {
            J j1 = u.I();
            int k = j1.L();
            if(H[k])
            {
                if(j1 == j)
                    continue;
                if(A(j1, j))
                    i += B[k] - Q[k];
                else
                    i += Q[k] - B[k];
                continue;
            }
            if(A(j, j1))
                i -= Q[k];
            else
                i += Q[k];
        }

        B[j.L()] = i;
    }

    private boolean A(J j, J j1)
    {
        return j.G() == j1.E() || j.E() == j1.G();
    }

    private void B(T t, T t1, int i, int j)
    {
        A(t, t1, i, j);
    }

    private void A(T t, T t1, int i, int j)
    {
        R = i;
        int k = 0;
        int l = t1 != null ? t1.Q() : -1;
        int i1 = t.Q();
        J[0] = i1;
        F[i1] = 0;
        while(k >= 0) 
        {
            int j1 = J[k];
            if(X[j1] % 2 == 0)
            {
                int k1 = F[j1];
                X[j1]++;
                V[j1] = R;
                M[j1] = j;
                if(j1 == l)
                {
                    J j2 = S[l];
                    T t2 = j2.G();
                    k1 = t2 != t1 ? (a[j2.L()] + E[t2.Q()]) - E[j2.E().Q()] : (-a[j2.L()] - E[t2.Q()]) + E[j2.E().Q()];
                }
                E[j1] += k1;
                j++;
                _A _la = Z[j1].B;
                while(_la != null) 
                {
                    F[_la.E] = k1;
                    J[++k] = _la.E;
                    _la = _la.B;
                }
            } else
            {
                X[j1]++;
                P[j1] = R++;
                k--;
                j--;
            }
        }
    }

    private boolean A(J j, T t)
    {
        return !A(j, t, W);
    }

    private boolean A(J j, T t, T t1)
    {
        int i = j.E().Q();
        int k = j.G().Q();
        return A(i, k, t.Q(), t1.Q());
    }

    private boolean A(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(P[i] > P[j])
        {
            i1 = P[j];
            j1 = V[j];
        } else
        {
            i1 = P[i];
            j1 = V[i];
        }
        int k1 = P[k];
        int l1 = P[l];
        return (j1 > k1 || j1 > l1 || i1 < k1 || i1 < l1) && (j1 <= k1 && i1 >= k1 || j1 <= l1 && i1 >= l1);
    }

    private T A(T t, T t1, ArrayList arraylist, boolean aflag[])
    {
        int i = t.Q();
        int k = t1.Q();
        I.clear();
        for(; M[i] < M[k]; k = t1.Q())
        {
            J j2 = S[k];
            I.add(j2);
            aflag[j2.L()] = j2.E() != t1;
            t1 = j2.A(t1);
        }

        for(; M[i] > M[k]; i = t.Q())
        {
            J j = S[i];
            arraylist.add(j);
            aflag[j.L()] = j.G() != t;
            t = j.A(t);
        }

        while(t != t1) 
        {
            J j1 = S[i];
            arraylist.add(j1);
            aflag[j1.L()] = j1.G() != t;
            t = j1.A(t);
            i = t.Q();
            J j3 = S[k];
            I.add(j3);
            aflag[j3.L()] = j3.E() != t1;
            t1 = j3.A(t1);
            k = t1.Q();
        }
        for(int l = I.size() - 1; l >= 0; l--)
            arraylist.add(I.get(l));

        return t;
    }

    private J C()
    {
        for(int i = 0; i++ < K;)
        {
            if(A == null)
                A = T.B;
            J j = A.C;
            int k = A.A;
            A = A.B;
            if(B[k] < 0)
                return j;
        }

        return null;
    }

    private J A(J j)
    {
        int i = -1;
        int k = 0x7fffffff;
        T t = j.E();
        int l = j.G().Q();
        int i1 = t.Q();
        int j1 = P[i1];
        int k1;
        int l1;
        if(P[l] > P[i1])
        {
            k1 = P[i1];
            l1 = V[i1];
        } else
        {
            k1 = P[l];
            l1 = V[l];
        }
        for(int i2 = L - 1; i2 >= 0; i2--)
        {
            int j2 = O[i2];
            int k2 = _[i2];
            int l2 = P[j2];
            int i3 = P[k2];
            if(l1 <= l2 && l1 <= i3 && k1 >= l2 && k1 >= i3 || (l1 > l2 || k1 < l2) && (l1 > i3 || k1 < i3) || l1 <= j1 && l1 <= i3 && k1 >= j1 && k1 >= i3 || (l1 > j1 || k1 < j1) && (l1 > i3 || k1 < i3))
                continue;
            int j3 = E[k2] - E[j2] - a[i2];
            if(k > j3)
            {
                k = j3;
                i = i2;
            }
        }

        return D[i];
    }

    private void B(J j, J j1)
    {
        U.clear();
        int i = j.L();
        int k = j1.L();
        T t2 = j1.G();
        T t3 = j1.E();
        T t;
        T t1;
        if(A(j, t3))
        {
            t = t2;
            G[k] = true;
            t1 = A(t2, t3, U, G);
        } else
        {
            t = t3;
            G[k] = false;
            t1 = A(t3, t2, U, G);
        }
        J j2 = j1;
        boolean flag = true;
        int l = B[i];
        boolean flag1 = G[i];
        int i1 = t.Q();
        for(int k1 = 0; k1 < U.size(); k1++)
        {
            J j3 = (J)U.get(k1);
            int i2 = j3.L();
            if(G[i2] == flag1)
                B[i2] -= l;
            else
                B[i2] += l;
            if(!flag)
                continue;
            S[i1] = j2;
            int k2 = i1;
            t = j3.A(t);
            i1 = t.Q();
            _A _la1 = C[i2];
            Z[i1].B(_la1);
            if(j3 != j)
            {
                Z[k2].A(_la1);
                _la1.E = i1;
                j2 = j3;
            } else
            {
                flag = false;
            }
        }

        B[k] = G[i] != G[k] ? l : -l;
        H[i] = false;
        H[k] = true;
        T.B(N[i]);
        T.A(N[k]);
        int l1 = t1.Q();
        _A _la = C[k];
        if(A(j, t2))
        {
            _la.E = t3.Q();
            Z[t2.Q()].A(_la);
            B(t1, t3, V[l1], M[l1]);
        } else
        {
            _la.E = t2.Q();
            Z[t3.Q()].A(_la);
            B(t1, t2, V[l1], M[l1]);
        }
    }

    private int F()
    {
        int i = 0x7fffffff;
        int j = 0x80000001;
        for(int l = 0; l < E.length; l++)
        {
            int k = E[l];
            if(k < i)
                i = k;
            if(k > j)
                j = k;
        }

        if(i != 0)
        {
            for(int i1 = 0; i1 < E.length; i1++)
                E[i1] -= i;

            j -= i;
        }
        return j + 1;
    }

    private D Y;
    private int Q[];
    private int a[];
    private int E[];
    private T W;
    private int R;
    private int P[];
    private int V[];
    private J S[];
    private int M[];
    private _B Z[];
    private _A A;
    private boolean H[];
    private _B T;
    private int B[];
    private int K;
    private int L;
    private boolean G[];
    private int X[];
    private int J[];
    private int F[];
    private J D[];
    private int O[];
    private int _[];
    private ArrayList U;
    private ArrayList I;
    private _A C[];
    private _A N[];
}
