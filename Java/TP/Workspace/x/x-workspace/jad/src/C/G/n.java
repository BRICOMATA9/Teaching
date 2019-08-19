// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.A;
import C.A.F;
import C.A.I;
import C.A.J;
import C.A.P;
import C.A.U;
import C.A.Y;
import C.K.B;
import C.K.C;
import C.K.G;
import C.K.M;
import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import java.util.Vector;

// Referenced classes of package C.G:
//            I, f, M, V, 
//            K, D, Z, F

public class n
{

    public static void A(C.G.I i, boolean flag)
    {
        if(flag)
        {
            for(U u = i.M(); u.C(); u.B())
            {
                J j = u.I();
                i.A(j, A);
                i.C(j, A);
                i.A(j, B);
            }

        } else
        {
            for(U u1 = i.M(); u1.C(); u1.B())
                i.A(u1.I(), B);

        }
    }

    public static Rectangle2D A(C.G.I i, F f1, U u)
    {
        Rectangle2D rectangle2d = A(i, f1);
        Rectangle2D rectangle2d1 = A(i, u);
        if(rectangle2d.getWidth() < 0.0D)
            return rectangle2d1;
        if(rectangle2d1.getWidth() < 0.0D)
        {
            return rectangle2d;
        } else
        {
            rectangle2d.add(rectangle2d1);
            return rectangle2d;
        }
    }

    public static Rectangle2D A(C.G.I i, F f1)
    {
        if(!f1.C())
            return new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, -1D, -1D);
        double d = 1.7976931348623157E+308D;
        double d1 = 1.7976931348623157E+308D;
        double d2 = -1.7976931348623157E+308D;
        double d3 = -1.7976931348623157E+308D;
        for(; f1.C(); f1.B())
        {
            f f2 = i.S(f1.H());
            d = Math.min(d, f2.C());
            d1 = Math.min(d1, f2.A());
            d2 = Math.max(d2, f2.C() + f2.B());
            d3 = Math.max(d3, f2.A() + f2.D());
        }

        return new java.awt.geom.Rectangle2D.Double(d, d1, d2 - d, d3 - d1);
    }

    public static Rectangle2D A(C.G.I i, U u)
    {
        if(!u.C())
            return new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, -1D, -1D);
        M m = i.O(u.I());
        double d = m.A;
        double d1 = m.A;
        double d2 = m.D;
        double d3 = m.D;
        for(; u.C(); u.B())
        {
            J j = u.I();
            C.G.M m3 = i.M(j);
            for(int k = m3.e() - 1; k >= 0; k--)
            {
                M m1 = m3.B(k);
                d = Math.min(d, m1.A);
                d1 = Math.max(d1, m1.A);
                d2 = Math.min(d2, m1.D);
                d3 = Math.max(d3, m1.D);
            }

            M m2 = i.O(j);
            d = Math.min(d, m2.A);
            d1 = Math.max(d1, m2.A);
            d2 = Math.min(d2, m2.D);
            d3 = Math.max(d3, m2.D);
            m2 = i.K(j);
            d = Math.min(d, m2.A);
            d1 = Math.max(d1, m2.A);
            d2 = Math.min(d2, m2.D);
            d3 = Math.max(d3, m2.D);
        }

        return new java.awt.geom.Rectangle2D.Double(d, d2, d1 - d, d3 - d2);
    }

    public static Rectangle2D A(C.G.I i, F f1, U u, boolean flag)
    {
        Rectangle2D rectangle2d = A(i, f1, u);
        if(flag)
        {
            f1.E();
            for(; f1.C(); f1.B())
            {
                V av[] = i.G(f1.H());
                f f2 = i.S(f1.H());
                if(av == null || av.length <= 0)
                    continue;
                for(int j = 0; j < av.length; j++)
                {
                    K k = av[j].C();
                    G g = av[j].A();
                    M m1 = k.A(g, f2, av[j].B());
                    rectangle2d.add(m1.A, m1.D);
                    rectangle2d.add(m1.A + g.J, m1.D + g.I);
                }

            }

            u.E();
            for(; u.C(); u.B())
            {
                D ad[] = i.F(u.I());
                C.G.M m = i.H(u.I());
                f f3 = i.E(u.I().G());
                f f4 = i.E(u.I().E());
                if(ad == null || ad.length <= 0)
                    continue;
                for(int l = 0; l < ad.length; l++)
                {
                    Z z = ad[l].K();
                    G g1 = ad[l].A();
                    M m2 = z.A(g1, m, f3, f4, ad[l].B());
                    rectangle2d.add(m2.A, m2.D);
                    rectangle2d.add(m2.A + g1.J, m2.D + g1.I);
                }

            }

        }
        return rectangle2d;
    }

    public static C A(C.G.M m, f f1, f f2)
    {
        return A(m, f1, f2, 0.0D);
    }

    public static C A(C.G.I i, J j)
    {
        return A(i.M(j), i.S(j.G()), i.S(j.E()));
    }

    public static C A(C.G.M m, f f1, f f2, double d)
    {
        M m1 = new M(f1.C() - d, f1.A() - d);
        B b = new B(f1.B() + 2D * d, f1.D() + 2D * d);
        M m2 = new M(f2.C() - d, f2.A() - d);
        B b1 = new B(f2.B() + 2D * d, f2.D() + 2D * d);
        Vector vector = new Vector(m.e() + 2);
        M m3 = new M(m.f().B() + m1.B() + b.Q() / 2D, m.f().A() + m1.A() + b.R() / 2D);
        vector.addElement(m3);
        for(int i = 0; i < m.e(); i++)
            vector.addElement(m.B(i));

        M m4 = new M(m.g().B() + m2.B() + b1.Q() / 2D, m.g().A() + m2.A() + b1.R() / 2D);
        vector.addElement(m4);
        M m5 = (M)vector.firstElement();
        M m6 = (M)vector.lastElement();
        Vector vector1 = new Vector();
        int j;
        for(j = 0; A(m1, b, (M)vector.elementAt(j));)
            if(++j == vector.size())
                return new C();

        if(j > 0)
            vector1.addElement(A(m1, b, (M)vector.elementAt(j - 1), (M)vector.elementAt(j)));
        while(!A(m2, b1, (M)vector.elementAt(j))) 
        {
            vector1.addElement(vector.elementAt(j));
            if(++j == vector.size())
                return new C(vector1);
        }
        if(j > 0)
            vector1.addElement(A(m2, b1, (M)vector.elementAt(j), (M)vector1.lastElement()));
        else
            vector1 = vector;
        return new C(vector1);
    }

    public static void A(C.G.I i, J j, J j1, double d, boolean flag, double d1, 
            double d2)
    {
        int k = i.P(j).D();
        M am[] = new M[k];
        int l = 0;
        for(I i1 = i.P(j).B(); i1.C(); i1.B())
        {
            M m2 = (M)i1.D();
            if(l <= 0 || !m2.equals(am[l - 1]))
            {
                am[l] = new M(m2.B(), m2.A());
                l++;
            }
        }

        k = l;
        if(k < 2)
            return;
        Y y = new Y();
        C.K.F f1 = new C.K.F(am[1], am[0]);
        C.K.F f2 = C.K.F.C(f1);
        f2.A(d);
        M m = C.K.F.A(am[0], f2);
        if(flag)
        {
            C.K.F f3 = new C.K.F(f1);
            double d3 = f3.D();
            f3.A((d2 * d3 + d1) / d3);
            f3.A(f2);
            y.add(C.K.F.A(am[0], f3));
            m = am[0];
        } else
        {
            m = C.K.F.A(am[0], f2);
        }
        M m3 = C.K.F.A(am[1], f2);
        C.K.I k1 = new C.K.I(m, m3);
        for(int l1 = 1; l1 < k - 1; l1++)
        {
            C.K.I i2 = k1;
            C.K.F f6 = C.K.F.C(new C.K.F(am[l1 + 1], am[l1]));
            f6.A(d);
            M m4 = C.K.F.A(am[l1], f6);
            M m5 = C.K.F.A(am[l1 + 1], f6);
            k1 = new C.K.I(m4, m5);
            M m6 = C.K.I.A(i2, k1);
            if(m6 != null)
                y.add(m6);
        }

        C.K.F f4 = new C.K.F(am[k - 1], am[k - 2]);
        M m1;
        if(flag)
        {
            C.K.F f5 = new C.K.F(f4);
            f4 = C.K.F.C(f4);
            f4.A(d);
            double d4 = f5.D();
            f5.A((d2 * d4 + d1) / -d4);
            f4.A(f5);
            y.add(C.K.F.A(am[k - 1], f4));
            m1 = am[k - 1];
        } else
        {
            f4 = C.K.F.C(f4);
            f4.A(d);
            m1 = C.K.F.A(am[k - 1], f4);
        }
        if(j.G().equals(j1.G()))
        {
            i.A(j1, y);
            i.A(j1, m, m1);
        } else
        {
            y.D();
            i.A(j1, y);
            i.A(j1, m1, m);
        }
    }

    public static void A(C.G.I i, J j, A a, double d, boolean flag, boolean flag1, double d1, double d2)
    {
        double d3 = d;
        double d4 = 0.0D;
        if(flag && a.size() % 2 == 1)
            d4 -= d * 0.5D;
        for(U u = a.L(); u.C(); u.B())
        {
            J j1 = u.I();
            A(i, j, j1, d3 + d4, flag1, d1, d2);
            if(d3 < 0.0D)
                d3 -= d;
            d3 = -d3;
        }

        if(flag && a.size() % 2 == 1)
            A(i, j, j, -d * 0.5D, flag1, d1, d2);
    }

    private static boolean A(M m, B b, M m1)
    {
        return m1.A >= m.A && m1.D >= m.D && m1.A <= m.A + b.Q() && m1.D <= m.D + b.R();
    }

    private static M A(M m, B b, M m1, M m2)
    {
        java.awt.geom.Point2D.Double double1 = A(m.A, m.D, b.Q(), b.R(), m1.A, m1.D, m2.A, m2.D, null);
        return new M(double1.x, double1.y);
    }

    private static java.awt.geom.Point2D.Double A(double d, double d1, double d2, double d3, 
            double d4, double d5, double d6, double d7, java.awt.geom.Point2D.Double double1)
    {
        if(double1 == null)
            double1 = new java.awt.geom.Point2D.Double();
        if(d4 >= d && d5 >= d1 && d4 <= d + d2 && d5 <= d1 + d3)
        {
            double d8 = d6 - d4;
            double d9 = d7 - d5;
            if(d8 == 0.0D)
                if(d9 < 0.0D)
                {
                    double1.x = d4;
                    double1.y = d1;
                    return double1;
                } else
                {
                    double1.x = d4;
                    double1.y = d1 + d3;
                    return double1;
                }
            if(d9 == 0.0D)
                if(d8 < 0.0D)
                {
                    double1.x = d;
                    double1.y = d5;
                    return double1;
                } else
                {
                    double1.x = d + d2;
                    double1.y = d5;
                    return double1;
                }
            double d10 = d9 / d8;
            if(d8 > 0.0D)
            {
                double d11 = d5 + d10 * ((d + d2) - d4);
                if(d11 < d1)
                {
                    double1.x = d4 + (d1 - d5) / d10;
                    double1.y = d1;
                    return double1;
                }
                if(d11 <= d1 + d3)
                {
                    double1.x = d + d2;
                    double1.y = d11;
                    return double1;
                } else
                {
                    double1.x = d4 + ((d1 + d3) - d5) / d10;
                    double1.y = d1 + d3;
                    return double1;
                }
            }
            double d12 = d5 + d10 * (d - d4);
            if(d12 < d1)
            {
                double1.x = d4 + (d1 - d5) / d10;
                double1.y = d1;
                return double1;
            }
            if(d12 <= d1 + d3)
            {
                double1.x = d;
                double1.y = d12;
                return double1;
            } else
            {
                double1.x = d4 + ((d1 + d3) - d5) / d10;
                double1.y = d1 + d3;
                return double1;
            }
        } else
        {
            double1.x = d4;
            double1.y = d5;
            return double1;
        }
    }

    public static final int A(Rectangle2D arectangle2d[], Rectangle2D rectangle2d, double d)
    {
        return A(arectangle2d, rectangle2d, d, 1);
    }

    static final void A(Rectangle2D arectangle2d[], Rectangle2D rectangle2d, double d, int ai[])
    {
        if(arectangle2d == null || arectangle2d.length < 1)
        {
            if(rectangle2d != null)
                rectangle2d.setFrame(0.0D, 0.0D, 0.0D, 0.0D);
            ai[0] = ai[1] = 0;
        }
        double d1 = 0.0D;
        double d2 = 0.0D;
        for(int i = 0; i < arectangle2d.length; i++)
        {
            Rectangle2D rectangle2d1 = arectangle2d[i];
            d1 = Math.max(d1, rectangle2d1.getWidth());
            d2 = Math.max(d2, rectangle2d1.getHeight());
        }

        double d3 = d1 * d2 * (double)arectangle2d.length;
        double d4 = Math.sqrt(d3 / d);
        double d5 = d3 / d4;
        int j = (int)Math.floor(d5 / d1);
        int k = (int)Math.ceil(d5 / d1);
        int l = (int)Math.ceil((double)arectangle2d.length / (double)j);
        int i1 = (int)Math.ceil((double)arectangle2d.length / (double)k);
        int j1;
        int k1;
        if(j * l < k * i1)
        {
            j1 = j;
            k1 = l;
        } else
        {
            j1 = k;
            k1 = i1;
        }
        int l1 = 0;
        int i2 = 0;
        double d6 = 0.0D;
        double d7 = 0.0D;
        if(d1 > d2)
        {
            for(int j2 = 0; j2 < arectangle2d.length; j2++)
            {
                arectangle2d[j2].setFrame((double)i2 * d1, (double)l1 * d2, arectangle2d[j2].getWidth(), arectangle2d[j2].getHeight());
                d6 = Math.max(d6, arectangle2d[j2].getMaxX());
                d7 = Math.max(d7, arectangle2d[j2].getMaxY());
                if(++i2 >= j1)
                {
                    l1++;
                    i2 = 0;
                }
            }

        } else
        {
            for(int k2 = 0; k2 < arectangle2d.length; k2++)
            {
                arectangle2d[k2].setFrame((double)i2 * d1, (double)l1 * d2, arectangle2d[k2].getWidth(), arectangle2d[k2].getHeight());
                d6 = Math.max(d6, arectangle2d[k2].getMaxX());
                d7 = Math.max(d7, arectangle2d[k2].getMaxY());
                if(++l1 >= k1)
                {
                    i2++;
                    l1 = 0;
                }
            }

        }
        if(rectangle2d != null)
            rectangle2d.setFrame(0.0D, 0.0D, d6, d7);
        ai[0] = k1;
        ai[1] = j1;
    }

    public static final int A(Rectangle2D arectangle2d[], Rectangle2D rectangle2d, double d, int i)
    {
        if(arectangle2d == null || arectangle2d.length < 1)
        {
            if(rectangle2d != null)
                rectangle2d.setFrame(0.0D, 0.0D, 0.0D, 0.0D);
            return 0;
        }
        double d2;
        double d1 = d2 = arectangle2d[0].getWidth();
        double d4;
        double d3 = d4 = arectangle2d[0].getHeight();
        for(int j = 1; j < arectangle2d.length; j++)
        {
            double d5 = arectangle2d[j].getWidth();
            d1 = Math.min(d1, d5);
            d2 = Math.max(d2, d5);
            double d7 = arectangle2d[j].getHeight();
            d3 = Math.min(d3, d7);
            d4 = Math.max(d4, d7);
        }

        if(d3 / d4 > 0.94999999999999996D && d1 / d2 > 0.94999999999999996D)
        {
            int ai[] = new int[2];
            A(arectangle2d, rectangle2d, d, ai);
            return ai[0];
        }
        Y y = new Y();
        double d6 = 0.0D;
        boolean flag = false;
        for(int k = 0; k < arectangle2d.length; k++)
        {
            Rectangle2D rectangle2d1 = arectangle2d[k];
            y.add(arectangle2d[k]);
            d6 += rectangle2d1.getWidth() * rectangle2d1.getHeight();
        }

        y.A(new Comparator() {

            public int compare(Object obj, Object obj1)
            {
                Rectangle2D rectangle2d7 = (Rectangle2D)obj;
                Rectangle2D rectangle2d8 = (Rectangle2D)obj1;
                int k2 = (int)rectangle2d8.getHeight() - (int)rectangle2d7.getHeight();
                if(k2 == 0)
                    return (int)rectangle2d8.getWidth() - (int)rectangle2d7.getWidth();
                else
                    return k2;
            }

        });
        double d8 = 0.0D;
        double d9 = 0.0D;
        double d10 = Math.max(d1, 0.90000000000000002D * (d * Math.sqrt(d6 / d)));
        double d11 = 0.0D;
        double d13 = 0.0D;
        double d15 = 0.0D;
        double d16 = 0.0D;
        double d18 = d10;
        double d19 = 1.7976931348623157E+308D;
        Y y2 = null;
        Y y1 = new Y();
        boolean flag1 = false;
        int l = 0;
        boolean flag2 = false;
        do
        {
            l++;
            double d20 = 1.7976931348623157E+308D;
            Y y3 = new Y();
            y1.add(y3);
            double d12;
            double d14;
            double d17 = d12 = d14 = 0.0D;
            for(P p = y.I(); p != null; p = p.C())
            {
                Rectangle2D rectangle2d2 = (Rectangle2D)p.A();
                if(d17 + rectangle2d2.getWidth() > d18 && y3.size() > 0)
                {
                    d20 = Math.min(d17 + rectangle2d2.getWidth(), d20);
                    d14 = Math.max(d14, d17);
                    y3 = new Y();
                    y3.add(rectangle2d2);
                    y1.add(y3);
                    d17 = rectangle2d2.getWidth();
                } else
                {
                    y3.add(rectangle2d2);
                    d17 += rectangle2d2.getWidth();
                }
                if(y3.size() == 1)
                    d12 += ((Rectangle2D)y3.F()).getHeight();
                d14 = Math.max(d14, d17);
            }

            int i1 = y1.size();
            double d22 = d14 / d12;
            if(d22 > 0.0D)
            {
                double d27 = Math.max(d22, d) / Math.min(d22, d);
                if(d27 < d19)
                {
                    d19 = d27;
                    y2 = y1;
                    y1 = new Y();
                }
            }
            flag1 = true;
            if(d * d12 > d14 && i1 > 1)
            {
                flag1 = false;
                y1.clear();
                if(d20 < 1.7976931348623157E+308D)
                    d18 = Math.max(1.1000000000000001D * d18, d20);
                else
                    d18 *= 1.1000000000000001D;
            }
            if(l > 50)
                flag1 = true;
        } while(!flag1);
        if(y2 != null)
            y1 = y2;
        double d21 = 0.0D;
        for(I j1 = y1.B(); j1.C(); j1.B())
        {
            double d23 = 0.0D;
            Y y6 = (Y)j1.D();
            for(I j2 = y6.B(); j2.C(); j2.B())
            {
                Rectangle2D rectangle2d3 = (Rectangle2D)j2.D();
                rectangle2d3.setFrame(d23, d21, rectangle2d3.getWidth(), rectangle2d3.getHeight());
                d23 += rectangle2d3.getWidth();
            }

            d8 = Math.max(d8, d23);
            d21 += B(y6);
            d9 = Math.max(d9, d21);
        }

        switch(i)
        {
        case 4: // '\004'
            for(I k1 = y1.B(); k1.C(); k1.B())
            {
                Y y4 = (Y)k1.D();
                double d25 = (d8 - A(y4)) / 2D;
                for(P p1 = y4.I(); p1 != null; p1 = p1.C())
                {
                    Rectangle2D rectangle2d4 = (Rectangle2D)p1.A();
                    rectangle2d4.setFrame(rectangle2d4.getX() + d25, rectangle2d4.getY(), rectangle2d4.getWidth(), rectangle2d4.getHeight());
                }

            }

            break;

        case 2: // '\002'
            for(I l1 = y1.B(); l1.C(); l1.B())
            {
                Y y5 = (Y)l1.D();
                double d26 = d8 - A(y5);
                for(P p2 = y5.I(); p2 != null; p2 = p2.C())
                {
                    Rectangle2D rectangle2d5 = (Rectangle2D)p2.A();
                    rectangle2d5.setFrame(rectangle2d5.getX() + d26, rectangle2d5.getY(), rectangle2d5.getWidth(), rectangle2d5.getHeight());
                }

            }

            break;

        case 3: // '\003'
            for(I i2 = y1.B(); i2.C(); i2.B())
            {
                double d24 = 0.0D;
                Y y7 = (Y)i2.D();
                if(y7.size() <= 1)
                    continue;
                double d28 = (d8 - A(y7)) / (double)(y7.size() - 1);
                for(P p3 = y7.I(); p3 != null; p3 = p3.C())
                {
                    Rectangle2D rectangle2d6 = (Rectangle2D)p3.A();
                    rectangle2d6.setFrame(d24, rectangle2d6.getY(), rectangle2d6.getWidth(), rectangle2d6.getHeight());
                    d24 += rectangle2d6.getWidth() + d28;
                }

            }

            break;
        }
        if(rectangle2d != null)
            rectangle2d.setFrame(0.0D, 0.0D, d8, d9);
        return y1.size();
    }

    private static double B(Y y)
    {
        double d = 0.0D;
        for(P p = y.I(); p != null; p = p.C())
            d = Math.max(((Rectangle2D)p.A()).getHeight(), d);

        return d;
    }

    private static double A(Y y)
    {
        double d = 0.0D;
        for(P p = y.I(); p != null; p = p.C())
            d += ((Rectangle2D)p.A()).getWidth();

        return d;
    }

    public static void A(C.G.I i, C.G.F f1)
    {
        for(F f2 = i.H(); f2.C(); f2.B())
        {
            C.A.T t = f2.H();
            f f3 = f1.E(t);
            if(f3 != null)
            {
                i.A(t, f3.B(), f3.D());
                i.B(t, f3.C(), f3.A());
            }
            V av[] = f1.G(t);
            V av1[] = i.G(t);
            if(av == null || av1 == null)
                continue;
            for(int i1 = 0; i1 < av.length && i1 < av1.length; i1++)
                av1[i1].A(av[i1].B());

        }

        for(U u = i.M(); u.C(); u.B())
        {
            J j = u.I();
            C.G.M m = f1.H(j);
            if(m != null)
            {
                C.G.M m1 = i.H(j);
                m1.A(m.f());
                m1.B(m.g());
                if(m1.e() != m.e())
                {
                    m1.d();
                    for(int k = 0; k < m.e(); k++)
                    {
                        M m2 = m.B(k);
                        m1.E(m2.B(), m2.A());
                    }

                } else
                {
                    for(int l = 0; l < m.e(); l++)
                    {
                        M m3 = m.B(l);
                        m1.A(l, m3.B(), m3.A());
                    }

                }
            }
            D ad[] = f1.F(j);
            D ad1[] = i.F(j);
            if(ad == null || ad1 == null)
                continue;
            for(int j1 = 0; j1 < ad.length && j1 < ad1.length; j1++)
                ad1[j1].A(ad[j1].B());

        }

    }

    private static final C B = new C();
    private static final M A;

    static 
    {
        A = M.B;
    }
}
