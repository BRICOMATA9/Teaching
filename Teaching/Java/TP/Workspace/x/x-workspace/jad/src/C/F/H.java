// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;
import C.E.O;

public class H
{
    private static class _A
    {

        private void A(D d, int ai[])
        {
            for(int i = d.I() - 1; i >= 0; i--)
                ai[i] = -1;

            J aj[] = new J[d.I()];
            A = 0;
            F f = d.H();
            do
            {
                if(!f.C())
                    break;
                T t = f.H();
                if(t.P() == 0)
                {
                    A(t, aj, ai);
                    break;
                }
                f.B();
            } while(true);
            for(F f1 = d.H(); f1.C(); f1.B())
            {
                T t1 = f1.H();
                if(ai[t1.Q()] == -1)
                    A(t1, aj, ai);
            }

        }

        private S A(D d)
        {
            S s = new S();
            byte abyte0[] = new byte[d.I()];
            J aj[] = new J[d.I()];
            boolean flag = false;
            F f = d.H();
            do
            {
                if(!f.C())
                    break;
                T t = f.H();
                if(t.P() == 0)
                {
                    A(t, aj, abyte0, s);
                    break;
                }
                f.B();
            } while(true);
            for(F f1 = d.H(); f1.C(); f1.B())
            {
                T t1 = f1.H();
                if(abyte0[t1.Q()] == 0)
                    A(t1, aj, abyte0, s);
            }

            return s;
        }

        private final void A(T t, J aj[], int ai[])
        {
            if(t.Y() == 0)
            {
                ai[t.Q()] = A++;
            } else
            {
                int i = 0;
                ai[t.Q()] = -2;
                aj[i] = t.T();
                while(i >= 0) 
                {
                    J j = aj[i];
                    T t1 = j.E();
                    int k = t1.Q();
                    if(ai[k] == -1)
                    {
                        if(t1.Y() == 0)
                        {
                            ai[k] = A++;
                        } else
                        {
                            ai[k] = -2;
                            aj[++i] = t1.T();
                        }
                    } else
                    {
                        J j1 = j.F();
                        if(j1 == null)
                        {
                            ai[j.G().Q()] = A++;
                            i--;
                        } else
                        {
                            aj[i] = j1;
                        }
                    }
                }
            }
        }

        private final void A(T t, J aj[], byte abyte0[], S s)
        {
            if(t.Y() == 0)
            {
                abyte0[t.Q()] = -2;
                s.add(t);
            } else
            {
                int i = 0;
                abyte0[t.Q()] = -1;
                aj[i] = t.T();
                while(i >= 0) 
                {
                    J j = aj[i];
                    T t1 = j.E();
                    int k = t1.Q();
                    if(abyte0[k] == 0)
                    {
                        if(t1.Y() == 0)
                        {
                            abyte0[k] = -2;
                            s.add(t1);
                        } else
                        {
                            abyte0[k] = -1;
                            aj[++i] = t1.T();
                        }
                    } else
                    {
                        J j1 = j.F();
                        if(j1 == null)
                        {
                            abyte0[j.G().Q()] = -2;
                            s.add(j.G());
                            i--;
                        } else
                        {
                            aj[i] = j1;
                        }
                    }
                }
            }
        }

        private int A;



        private _A()
        {
        }

    }


    public static boolean B(D d, int ai[])
    {
        return A(d, ai);
    }

    public static S B(D d)
    {
        int ai[] = new int[d.I()];
        if(!B(d, ai))
            throw new IllegalArgumentException("Graph is not acyclic");
        else
            return C(d, ai);
    }

    public static void D(D d, int ai[])
    {
        (new _A()).A(d, ai);
    }

    public static S A(D d)
    {
        return (new _A()).A(d);
    }

    public static S C(D d, int ai[])
    {
        T at[] = new T[d.G()];
        boolean flag = false;
        for(F f = d.H(); f.C(); f.B())
        {
            T t = f.H();
            int i = t.Q();
            at[ai[i]] = t;
        }

        return new S(at);
    }

    public static void A(S s, K k)
    {
        int i = 0;
        for(F f = s.O(); f.C();)
        {
            k.A(f.H(), i);
            f.B();
            i++;
        }

    }

    private static boolean A(D d, int ai[])
    {
        int ai1[] = new int[d.G()];
        O o = new O(d.G());
        int i = 0;
        for(F f = d.H(); f.C(); f.B())
        {
            T t1 = f.H();
            int k = t1.Q();
            if((ai1[k] = t1.P()) == 0)
                o.A(t1);
            ai[k] = -1;
        }

        while(!o.B()) 
        {
            T t = (T)o.D();
            int j = t.Q();
            ai[j] = i++;
            J j1 = t.T();
            while(j1 != null) 
            {
                if(--ai1[j1.E().Q()] == 0)
                    o.A(j1.E());
                j1 = j1.F();
            }
        }
        return i == d.G();
    }
}
