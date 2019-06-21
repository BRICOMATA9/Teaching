// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.F;
import C.A.J;
import C.A.T;
import C.A.U;
import C.C.B;
import C.E.M;
import C.G.D;
import C.G.K;
import C.G.V;
import C.G.Z;
import C.G.f;
import C.G.n;
import C.K.A;
import C.K.G;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

// Referenced classes of package C.J:
//            K, b, Y, DA, 
//            U, n, Q, f

public class d
    implements B
{

    public d(C.J.K k, C.G.F f1)
    {
        T = false;
        R = true;
        F = false;
        E = k.d();
        N = k;
        O = f1;
        K = 300L;
    }

    public long B()
    {
        return K;
    }

    public void A()
    {
        I = N.c();
        L = 0.0D;
        S = N.Z();
        V = N.n();
        H = new double[E.G()];
        G = new double[E.G()];
        int i = 0;
        for(F f1 = E.H(); f1.C();)
        {
            T t = f1.H();
            f f2 = O.E(f1.H());
            double d1 = E.M(t);
            double d2 = E.T(t);
            if(f2.B() != d1 || f2.D() != d2)
                E.A(t, f2.B(), f2.D());
            H[i] = E.Q(t);
            G[i] = E.J(t);
            V av[] = O.G(t);
            if(av != null && av.length > 0)
                E.U(t).H().A(av[0].B());
            f1.B();
            i++;
        }

        Q = new double[E.F()][];
        P = new double[E.F()][];
        C = new int[E.F()][];
        int j = 0;
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double();
        for(U u = E.M(); u.C();)
        {
            J j1 = u.I();
            C.J.U u1 = E.R(j1);
            u1.C(double1);
            C.G.M m = O.H(j1);
            if(m == null)
            {
                C.E.M.A("edgelayout is null! " + j1);
            } else
            {
                int k = u1.i();
                int l = m.e();
                C.K.M m1 = m.f();
                u1.k().A(m1.B(), m1.A());
                m1 = m.g();
                u1.s().A(m1.B(), m1.A());
                if(l > k)
                {
                    Q[j] = new double[l];
                    P[j] = new double[l];
                    C[j] = new int[l];
                    Arrays.fill(C[j], -1);
                    int i1 = 0;
                    int i2 = 0;
                    for(int l2 = u1.e(); i2 < l2;)
                    {
                        i1 = A(u1.B(i2), m, i1, l2 - i2 - 1);
                        C[j][i1] = i2;
                        i2++;
                        i1++;
                    }

                    i2 = -1;
                    for(int i3 = 0; i3 < C[j].length; i3++)
                        if(C[j][i3] > -1)
                        {
                            A(u1, m, j, i2, i3);
                            i2 = i3;
                        }

                    A(u1, m, j, i2, l);
                    int j3 = 0;
                    for(Q q1 = u1.t(); q1.C();)
                    {
                        C.K.M m2 = m.B(j3);
                        Q[j][j3] = m2.A - q1.J().A();
                        P[j][j3] = m2.D - q1.J().C();
                        q1.B();
                        j3++;
                    }

                    C[j] = null;
                } else
                if(l < k)
                {
                    Q[j] = new double[k];
                    P[j] = new double[k];
                    C[j] = new int[k];
                    Arrays.fill(C[j], -1);
                    int k1 = 0;
                    for(int j2 = 0; j2 < l;)
                    {
                        C.K.M m3 = m.B(j2);
                        k1 = A(m3, ((C.G.M) (u1)), k1, l - j2 - 1);
                        C[j][k1] = j2;
                        C.J.f f4 = u1.C(k1);
                        Q[j][k1] = m3.B() - f4.A();
                        P[j][k1] = m3.A() - f4.C();
                        j2++;
                        k1++;
                    }

                    int k2 = -1;
                    for(int k3 = 0; k3 < C[j].length; k3++)
                        if(C[j][k3] > -1)
                        {
                            A(m, u1, j, k2, k3);
                            k2 = k3;
                        }

                    A(m, u1, j, k2, u1.e());
                } else
                {
                    Q[j] = new double[k];
                    P[j] = new double[k];
                    int l1 = 0;
                    for(Q q = u1.t(); q.C();)
                    {
                        C.K.M m4 = m.B(l1);
                        Q[j][l1] = m4.B() - q.J().A();
                        P[j][l1] = m4.A() - q.J().C();
                        q.B();
                        l1++;
                    }

                }
                D ad[] = E.F(j1);
                D ad1[] = O.F(j1);
                if(ad != null && ad1 != null)
                {
                    for(int l3 = 0; l3 < ad.length; l3++)
                        ad[l3].A(ad1[l3].B());

                }
            }
            u.B();
            j++;
        }

        if(J != null)
        {
            f f3 = O.E(J);
            U = new java.awt.geom.Point2D.Double(f3.C() + f3.B() * 0.5D, f3.A() + f3.D() * 0.5D);
        } else
        if(T)
        {
            N.A(21, 31);
            N.f();
            java.awt.Rectangle rectangle = O.X();
            Rectangle2D rectangle2d = A(((C.A.D) (E)), O, ((Rectangle2D) (rectangle)));
            U = new java.awt.geom.Point2D.Double(rectangle2d.getX() + rectangle2d.getWidth() * 0.5D, rectangle2d.getY() + rectangle2d.getHeight() * 0.5D);
            java.awt.Rectangle rectangle2 = N.getVisibleRect();
            D = N.h();
            N.B(rectangle);
            M = N.h();
            N.B(rectangle2);
            N.D(D);
        } else
        if(F)
        {
            N.A(21, 31);
            N.f();
        } else
        {
            java.awt.Rectangle rectangle1 = O.X();
            if(rectangle1 != null)
            {
                A(((C.A.D) (E)), O, ((Rectangle2D) (rectangle1)));
                N.A(21, 31);
                N.f();
                N.B(rectangle1);
            }
        }
    }

    private void A(C.J.U u, C.G.M m, int i, int j, int k)
    {
        if(j >= k - 1)
            return;
        C.K.M m1;
        if(j == -1)
        {
            Y y = u.C2();
            m1 = u.f();
            m1 = new C.K.M(m1.B() + y.N(), m1.A() + y.V());
        } else
        {
            m1 = u.B(C[i][j]);
        }
        C.K.M m2;
        if(m.e() == k)
        {
            Y y1 = u.m();
            m2 = u.g();
            m2 = new C.K.M(m2.B() + y1.N(), m2.A() + y1.V());
        } else
        {
            m2 = u.B(C[i][k]);
        }
        if(u.i() == 0 || m.e() == k)
        {
            int l = j + 1;
            do
            {
                if(l >= k)
                    break;
                C.K.M m3 = A(m.B(l), m1, m2);
                C.J.f f2 = u.F(m3.B(), m3.A());
                if(f2 == null)
                    break;
                l++;
            } while(true);
        } else
        {
            C.J.f f1 = u.C(C[i][k]);
            int i1 = j + 1;
            do
            {
                if(i1 >= k)
                    break;
                C.K.M m4 = A(m.B(i1), m1, m2);
                C.J.f f3 = u.A(m4.B(), m4.A(), f1, 1);
                if(f3 == null)
                    break;
                i1++;
            } while(true);
        }
    }

    private void A(C.G.M m, C.J.U u, int i, int j, int k)
    {
        if(j >= k - 1)
            return;
        C.K.M m1;
        if(-1 == j)
        {
            f f1 = O.E(u.C6().G());
            m1 = m.f();
            m1 = new C.K.M(m1.B() + f1.C() + f1.B() * 0.5D, m1.A() + f1.A() + f1.D() * 0.5D);
        } else
        {
            m1 = m.B(C[i][j]);
        }
        C.K.M m2;
        if(u.e() == k)
        {
            f f2 = O.E(u.C6().E());
            m2 = m.g();
            m2 = new C.K.M(m2.B() + f2.C() + f2.B() * 0.5D, m2.A() + f2.A() + f2.D() * 0.5D);
        } else
        {
            m2 = m.B(C[i][k]);
        }
        for(int l = j + 1; l < k; l++)
        {
            C.J.f f3 = u.C(l);
            C.K.M m3 = A(f3.A(), f3.C(), m1, m2);
            Q[i][l] = m3.B() - f3.A();
            P[i][l] = m3.A() - f3.C();
        }

    }

    private int A(C.K.M m, C.G.M m1, int i, int j)
    {
        double d1 = 1.7976931348623157E+308D;
        int k = i;
        int l = i;
        for(int i1 = m1.e(); l + j < i1 && l < i1; l++)
        {
            C.K.M m2 = m1.B(l);
            double d2 = m.B() - m2.B();
            double d3 = m.A() - m2.A();
            double d4 = d2 * d2 + d3 * d3;
            if(d1 > d4)
            {
                d1 = d4;
                k = l;
            }
        }

        return k;
    }

    protected Rectangle2D A(C.A.D d1, C.G.F f1, Rectangle2D rectangle2d)
    {
        for(F f2 = d1.H(); f2.C(); f2.B())
        {
            f f3 = f1.E(f2.H());
            if(rectangle2d.getWidth() < 0.0D)
                rectangle2d.setFrame(f3.C(), f3.A(), f3.B(), f3.D());
            rectangle2d.add(f3.C(), f3.A());
            rectangle2d.add(f3.C() + f3.B(), f3.A() + f3.D());
            V av[] = f1.G(f2.H());
            if(av == null || av.length <= 0)
                continue;
            for(int i = 0; i < av.length; i++)
            {
                K k = av[i].C();
                G g = av[i].A();
                C.K.M m1 = k.A(g, f3, av[i].B());
                rectangle2d.add(m1.A, m1.D);
                rectangle2d.add(m1.A + g.J, m1.D + g.I);
            }

        }

        for(U u = d1.M(); u.C(); u.B())
        {
            D ad[] = f1.F(u.I());
            C.G.M m = f1.H(u.I());
            f f4 = f1.E(u.I().G());
            f f5 = f1.E(u.I().E());
            rectangle2d.add(f4.C() + f4.B() * 0.5D + m.f().A, f4.A() + f4.D() * 0.5D + m.f().D);
            rectangle2d.add(f5.C() + f5.B() * 0.5D + m.g().A, f5.A() + f5.D() * 0.5D + m.g().D);
            for(int j = 0; j < m.e(); j++)
            {
                C.K.M m2 = m.B(j);
                rectangle2d.add(m2.A, m2.D);
            }

            if(ad == null || ad.length <= 0)
                continue;
            for(int l = 0; l < ad.length; l++)
            {
                Z z = ad[l].K();
                G g1 = ad[l].A();
                C.K.M m3 = z.A(g1, m, f4, f5, ad[l].B());
                rectangle2d.add(m3.A, m3.D);
                rectangle2d.add(m3.A + g1.J, m3.D + g1.I);
            }

        }

        return rectangle2d;
    }

    public void A(double d1)
    {
        double d2 = d1 - L;
        double d3 = 1.0D - d1;
        L = d1;
        if(d1 < 1.0D)
        {
            int i = 0;
            for(F f1 = E.H(); f1.C();)
            {
                f f2 = O.E(f1.H());
                Y y = E.U(f1.H());
                y.B(d3 * H[i] + d1 * f2.C());
                y.A(d3 * G[i] + d1 * f2.A());
                f1.B();
                i++;
            }

            i = 0;
            for(U u = E.M(); u.C();)
            {
                int j = 0;
                for(Q q = E.R(u.I()).t(); q.C();)
                {
                    q.J().B(d2 * Q[i][j], d2 * P[i][j]);
                    q.B();
                    j++;
                }

                u.B();
                i++;
            }

        } else
        {
            n.A(E, O);
        }
        if(J != null)
            N.C(d3 * I.getX() + d1 * U.getX(), d3 * I.getY() + d1 * U.getY());
        else
        if(T)
        {
            N.C(d3 * I.getX() + d1 * U.getX(), d3 * I.getY() + d1 * U.getY());
            N.D(d3 * D + d1 * M);
        }
    }

    public void C()
    {
        N.A(S, V);
        N.m();
        N.f();
    }

    private static C.K.M A(C.K.M m, C.K.M m1, C.K.M m2)
    {
        return C.K.A.B(m.B(), m.A(), m1.B(), m1.A(), m2.B(), m2.A());
    }

    private static C.K.M A(double d1, double d2, C.K.M m, C.K.M m1)
    {
        return C.K.A.B(d1, d2, m.B(), m.A(), m1.B(), m1.A());
    }

    b E;
    C.G.F O;
    Point2D I;
    double D;
    double H[];
    double G[];
    double Q[][];
    double P[][];
    Point2D U;
    double M;
    double L;
    T J;
    C.J.K N;
    boolean T;
    int C[][];
    long K;
    private boolean R;
    int S;
    int V;
    private boolean F;
}
