// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.A;
import C.A.F;
import C.A.J;
import C.A.K;
import C.A.M;
import C.A.S;
import C.A.T;
import C.A.U;
import C.F.I;
import C.G.D.D;
import C.K.B;
import C.K.C;
import C.K.G;
import C.K.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

// Referenced classes of package C.G:
//            g, I, n, T, 
//            f, Q, o, O

public class w extends g
{
    static final class _A
    {

        int B;
        _B C;
        int A;

        _A()
        {
        }
    }

    static final class _B
    {

        int C()
        {
            return D;
        }

        int B()
        {
            return B;
        }

        void B(int i1, int j1, int k1, int l1)
        {
            for(int i2 = j1; i2 < l1; i2++)
                A(i1, k1, i2, true);

        }

        void A()
        {
            int ai[] = new int[F];
            int ai1[] = new int[F];
            int ai2[] = new int[C];
            int ai3[] = new int[C];
            for(int i1 = 0; i1 < ai.length; i1++)
            {
                ai[i1] = C;
                ai1[i1] = -1;
            }

            for(int j1 = 0; j1 < ai2.length; j1++)
            {
                ai2[j1] = F;
                ai3[j1] = -1;
            }

            for(int k1 = E.nextSetBit(0); k1 >= 0; k1 = E.nextSetBit(k1 + 1))
            {
                int i2 = k1 % C;
                int k2 = k1 / C;
                ai[k2] = Math.min(ai[k2], i2);
                ai2[i2] = Math.min(ai2[i2], k2);
                ai1[k2] = Math.max(ai1[k2], i2);
                ai3[i2] = Math.max(ai3[i2], k2);
            }

            int l1 = 0;
            for(int j2 = 0; j2 < F; j2++)
            {
                for(int l2 = ai[j2]; l2 < ai1[j2]; l2++)
                {
                    if(ai2[l2] > j2 || ai3[l2] < j2)
                        continue;
                    int i3;
                    for(i3 = l2 + 1; ai2[i3] <= j2 && ai3[i3] >= j2; i3++);
                    E.set(l1 + l2, l1 + i3);
                }

                l1 += C;
            }

        }

        void A(_B _pb, int i1, int j1, double d, boolean flag)
        {
label0:
            {
                int k1 = A + C / 2;
                int l1 = G + F / 2;
                A(i1 - k1, j1 - l1);
                if(flag)
                {
                    for(int i2 = 0; !A(_pb, 0, 0, i2); i2++);
                    break label0;
                }
                int j2 = 0;
                int k2 = 0;
                if(A(_pb, 0, 0))
                {
                    _pb.B(this);
                    return;
                }
                do
                {
                    do
                    {
                        double d1 = (double)(j2 + 1) / (double)k2 / d;
                        double d2 = (double)j2 / (double)(k2 + 1) / d;
                        if(d1 < 1.0D)
                            d1 = 1.0D / d1;
                        if(d2 < 1.0D)
                            d2 = 1.0D / d2;
                        if(d1 >= d2)
                            break;
                        j2++;
                        if(A(_pb, -j2, 0) || A(_pb, j2, 0))
                            break label0;
                        int l2 = 1;
                        while(l2 <= k2) 
                        {
                            if(A(_pb, -j2, -l2) || A(_pb, -j2, l2) || A(_pb, j2, -l2) || A(_pb, j2, l2))
                                break label0;
                            l2++;
                        }
                    } while(true);
                    k2++;
                    if(A(_pb, 0, -k2) || A(_pb, 0, k2))
                        break label0;
                    int i3 = 1;
                    while(i3 <= j2) 
                    {
                        if(A(_pb, i3, -k2) || A(_pb, i3, k2) || A(_pb, -i3, -k2) || A(_pb, -i3, k2))
                            break label0;
                        i3++;
                    }
                } while(true);
            }
            _pb.B(this);
        }

        boolean A(_B _pb, int i1, int j1, int k1)
        {
            if(k1 == 0)
                return A(_pb, i1, j1);
            int l1 = k1;
            int i2 = 0;
            int j2 = k1 * k1;
            int k2 = j2;
            while(l1 >= i2) 
            {
                if(A(_pb, i1 + l1, j1 + i2))
                    return true;
                if(A(_pb, i1 + l1, j1 - i2))
                    return true;
                if(A(_pb, i1 - l1, j1 + i2))
                    return true;
                if(A(_pb, i1 - l1, j1 - i2))
                    return true;
                if(A(_pb, i1 + i2, j1 + l1))
                    return true;
                if(A(_pb, i1 + i2, j1 - l1))
                    return true;
                if(A(_pb, i1 - i2, j1 + l1))
                    return true;
                if(A(_pb, i1 - i2, j1 - l1))
                    return true;
                if(k2 < j2)
                {
                    k2 += 1 + 2 * i2;
                    i2++;
                } else
                {
                    k2 += (2 - 2 * l1) + 2 * i2;
                    l1--;
                    i2++;
                }
            }
            return false;
        }

        private final boolean A(_B _pb, int i1, int j1)
        {
            A += i1;
            G += j1;
            if(!A(_pb))
            {
                D += i1;
                B += j1;
                return true;
            } else
            {
                A -= i1;
                G -= j1;
                return false;
            }
        }

        public void A(int i1, int j1, boolean flag)
        {
            if(i1 < A || i1 >= A + C || j1 < G || j1 >= G + F)
                throw new IndexOutOfBoundsException();
            int k1 = ((j1 - G) * C + i1) - A;
            if(flag)
                E.set(k1);
            else
                E.clear(k1);
        }

        public void A(int i1, int j1, int k1, boolean flag)
        {
            if(i1 < A || j1 >= A + C || k1 < G || k1 >= G + F)
                throw new IndexOutOfBoundsException();
            int l1 = ((k1 - G) * C + i1) - A;
            int i2 = ((k1 - G) * C + j1) - A;
            if(flag)
                E.set(l1, i2);
            else
                E.clear(l1, i2);
        }

        public void A(int i1, int j1)
        {
            A += i1;
            G += j1;
            D += i1;
            B += j1;
        }

        public void B(_B _pb)
        {
            if(_pb.A < A || _pb.A >= A + C || _pb.G < G || _pb.G >= G + F || _pb.A + _pb.C > A + C || _pb.G + _pb.F > G + F)
                A(Math.min(_pb.A, A), Math.min(_pb.G, G), Math.max(_pb.A + _pb.C, A + C), Math.max(_pb.G + _pb.F, G + F));
            for(int i1 = _pb.E.nextSetBit(0); i1 >= 0; i1 = _pb.E.nextSetBit(i1 + 1))
            {
                int j1 = i1 % _pb.C + _pb.A;
                int k1 = i1 / _pb.C + _pb.G;
                int l1 = (j1 - A) + (k1 - G) * C;
                E.set(l1);
            }

        }

        void A(int i1, int j1, int k1, int l1)
        {
            int i2 = k1 - i1;
            O o1 = new O(i2 * (l1 - j1));
            for(int j2 = E.nextSetBit(0); j2 >= 0; j2 = E.nextSetBit(j2 + 1))
            {
                int k2 = j2 % C + A;
                int l2 = j2 / C + G;
                o1.set((k2 - i1) + (l2 - j1) * i2);
            }

            E = o1;
            A = i1;
            G = j1;
            C = i2;
            F = l1 - j1;
        }

        public boolean A(_B _pb)
        {
            if(_pb.A >= A + C || _pb.G >= G + F || _pb.A + _pb.C <= A || _pb.G + _pb.F <= G)
                return false;
            _B _lb = this;
            _B _lb1 = _pb;
            int i1 = Math.max(_lb.A, _lb1.A);
            int j1 = Math.min(_lb.A + _lb.C, _lb1.A + _lb1.C);
            int k1 = Math.max(_lb.G, _lb1.G);
            int l1 = Math.max(_lb.G + _lb.F, _lb1.G + _lb1.F);
            if(i1 < j1 && k1 < l1)
            {
                int i2 = _lb.A(i1, k1, i1, k1, j1, l1);
                for(int j2 = _lb1.A(i1, k1, i1, k1, j1, l1); i2 >= 0 && j2 >= 0;)
                {
                    int k2 = i2 % _lb.C + _lb.A;
                    int l2 = j2 % _lb1.C + _lb1.A;
                    int i3 = i2 / _lb.C + _lb.G;
                    int j3 = j2 / _lb1.C + _lb1.G;
                    if(i3 == j3)
                    {
                        if(k2 == l2)
                            return true;
                        if(k2 < l2)
                            i2 = _lb.A(l2, j3, i1, k1, j1, l1);
                        else
                            j2 = _lb1.A(k2, i3, i1, k1, j1, l1);
                    } else
                    if(i3 < j3)
                        i2 = _lb.A(l2, j3, i1, k1, j1, l1);
                    else
                        j2 = _lb1.A(k2, i3, i1, k1, j1, l1);
                }

                return false;
            } else
            {
                return false;
            }
        }

        public final int A(int i1, int j1, int k1, int l1, int i2, int j2)
        {
            int k2 = (i1 - A) + (j1 - G) * C;
            k1 -= A;
            i2 -= A;
            l1 -= G;
            j2 -= G;
            boolean flag = k2 >= 0 && k2 % C >= k1 && k2 % C < i2 && k2 / C >= l1 && k2 / C < j2;
            do
            {
                if(!flag)
                    if(k2 % C < k1)
                        k2 += k1 - k2 % C;
                    else
                        k2 += C - k2 % C;
                k2 = E.nextSetBit(k2);
                if(k2 < 0)
                    return -1;
                flag = k2 % C >= k1 && k2 % C < i2 && k2 / C >= l1 && k2 / C < j2;
            } while(!flag);
            return k2;
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer(C * F + F + 1);
            int i1 = 0;
            for(int j1 = 0; j1 < F; j1++)
            {
                for(int k1 = 0; k1 < C; k1++)
                {
                    if(E.get(i1))
                        stringbuffer.append('#');
                    else
                        stringbuffer.append('.');
                    i1++;
                }

                stringbuffer.append('\n');
            }

            return "x: " + A + " y: " + G + "\n" + stringbuffer.toString();
        }

        int C;
        int F;
        int A;
        int G;
        int D;
        int B;
        private O E;


        _B(int i1, int j1, int k1, int l1)
        {
            C = k1;
            F = l1;
            A = i1;
            D = 0;
            G = j1;
            B = 0;
            E = new O(k1 * l1);
        }
    }

    static final class _C
    {

        S C;
        A F;
        java.awt.geom.Point2D.Double B;
        java.awt.geom.Rectangle2D.Double E;
        java.awt.geom.Point2D.Double A;
        java.awt.geom.Rectangle2D.Double D;
        java.awt.geom.Rectangle2D.Double H;
        G I;
        boolean G;

        _C()
        {
            C = new S();
            F = new A();
            B = new java.awt.geom.Point2D.Double();
            E = new java.awt.geom.Rectangle2D.Double();
            A = new java.awt.geom.Point2D.Double();
            D = new java.awt.geom.Rectangle2D.Double();
            H = new java.awt.geom.Rectangle2D.Double();
            G = true;
        }
    }


    public w()
    {
        FA = 45D;
        F8 = true;
        F5 = true;
        F3 = 1;
        A(400D, 400D);
    }

    public void A(double d, double d1)
    {
        FD = d;
        F4 = d1;
    }

    public B i()
    {
        return new B(FD, F4);
    }

    protected int B(C.G.I i1, K k1)
    {
        M m = i1.B(FE);
        if(m != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put(null, new ArrayList());
            for(F f1 = i1.H(); f1.C(); f1.B())
            {
                T t = f1.H();
                Object obj = m.D(t);
                Object obj1 = (List)hashmap.get(obj);
                if(obj1 == null)
                {
                    obj1 = new ArrayList();
                    hashmap.put(obj, obj1);
                }
                ((List) (obj1)).add(t);
            }

            List list = (List)hashmap.get(null);
            hashmap.remove(null);
            if(list.size() == 0)
            {
                if(hashmap.size() < 2)
                {
                    for(F f2 = i1.H(); f2.C(); f2.B())
                    {
                        T t1 = f2.H();
                        k1.A(t1, 0);
                    }

                    return 1;
                }
                Object aobj[] = hashmap.keySet().toArray(new Object[hashmap.size()]);
                Arrays.sort(aobj);
                for(int l1 = 0; l1 < aobj.length; l1++)
                {
                    Object obj2 = aobj[l1];
                    List list1 = (List)hashmap.get(obj2);
                    T t2;
                    for(Iterator iterator = list1.iterator(); iterator.hasNext(); k1.A(t2, l1))
                        t2 = (T)iterator.next();

                }

                return aobj.length;
            }
            if(!hashmap.isEmpty())
            {
                int j1 = A(i1, k1);
                int ai[] = new int[j1];
                for(int i2 = 0; i2 < ai.length; i2++)
                    ai[i2] = -1;

                Object aobj1[] = hashmap.keySet().toArray(new Object[hashmap.size()]);
                for(int j2 = 0; j2 < aobj1.length; j2++)
                {
                    Object obj3 = aobj1[j2];
                    List list2 = (List)hashmap.get(obj3);
                    for(Iterator iterator2 = list2.iterator(); iterator2.hasNext();)
                    {
                        T t4 = (T)iterator2.next();
                        ai[k1.A(t4)] = j2;
                    }

                }

                int k2 = aobj1.length;
                for(int l2 = 0; l2 < ai.length; l2++)
                {
                    int j3 = ai[l2];
                    if(j3 < 0)
                        ai[l2] = k2++;
                }

                T t3;
                for(Iterator iterator1 = list.iterator(); iterator1.hasNext(); k1.A(t3, ai[k1.A(t3)]))
                    t3 = (T)iterator1.next();

                for(int i3 = 0; i3 < aobj1.length; i3++)
                {
                    Object obj4 = aobj1[i3];
                    List list3 = (List)hashmap.get(obj4);
                    T t5;
                    for(Iterator iterator3 = list3.iterator(); iterator3.hasNext(); k1.A(t5, i3))
                        t5 = (T)iterator3.next();

                }

                return k2;
            } else
            {
                return A(i1, k1);
            }
        } else
        {
            return A(i1, k1);
        }
    }

    private int A(C.G.I i1, K k1)
    {
        if(!h() || !D.B(i1))
            return I.A(i1, k1);
        M m = i1.B(C.G.D.F.D);
        M m1 = i1.B(C.G.D.F.B);
        HashMap hashmap = new HashMap();
        for(F f1 = i1.H(); f1.C(); f1.B())
            hashmap.put(m.D(f1.H()), f1.H());

        A a = new A();
        for(F f2 = i1.H(); f2.C(); f2.B())
        {
            T t = f2.H();
            Object obj = m1.D(t);
            if(obj == null)
                continue;
            T t1 = (T)hashmap.get(obj);
            if(t1 != null)
                a.A(i1.B(t, t1));
        }

        int j1 = I.A(i1, k1);
        for(; a.size() > 0; i1.E(a.J()));
        return j1;
    }

    public void A(C.G.I i1)
    {
        K k1;
        if(i1.J())
            return;
        k1 = i1.W();
        int j1 = B(i1, k1);
        F9 = new _C[j1];
        M m = i1.B(FC);
        for(int l1 = 0; l1 < j1; l1++)
        {
            F9[l1] = new _C();
            F9[l1].G = m == null;
        }

        for(U u = i1.M(); u.C(); u.B())
        {
            J j3 = u.I();
            F9[k1.A(j3.G())].F.add(j3);
            i1.B(j3);
        }

        for(F f1 = i1.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            if(m != null && m.B(t))
                F9[k1.A(t)].G = true;
            F9[k1.A(t)].C.add(t);
            i1.G(f1.H());
        }

        for(int i2 = 0; i2 < j1; i2++)
        {
            _C _lc = F9[i2];
            _lc.A.x = 0.0D;
            _lc.A.y = 0.0D;
            for(F f3 = _lc.C.O(); f3.C(); f3.B())
            {
                _lc.A.x += i1.O(f3.H());
                _lc.A.y += i1.K(f3.H());
                i1.H(f3.H());
            }

            _lc.A.x /= _lc.C.size();
            _lc.A.y /= _lc.C.size();
            for(U u2 = _lc.F.L(); u2.C(); u2.B())
                i1.C(u2.I());

            java.awt.geom.Rectangle2D rectangle2d = g(i1);
            _lc.D = new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
            if(_lc.G)
                D(i1);
            rectangle2d = g(i1);
            _lc.I = new G(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
            _lc.E = new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
            if(FB > 0.0D)
            {
                double d = FA + (Math.ceil((rectangle2d.getWidth() + 1.0D) / FB) + 1.0D) * FB;
                double d1 = FA + (Math.ceil((rectangle2d.getHeight() + 1.0D) / FB) + 1.0D) * FB;
                _lc.H.setFrame(rectangle2d.getX(), rectangle2d.getY(), d, d1);
            } else
            {
                _lc.H.setFrame(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth() + FA, rectangle2d.getHeight() + FA);
            }
            for(U u3 = _lc.F.L(); u3.C(); u3.B())
                i1.B(u3.I());

            for(F f4 = _lc.C.O(); f4.C(); f4.B())
            {
                _lc.B.x += i1.O(f4.H());
                _lc.B.y += i1.K(f4.H());
                i1.G(f4.H());
            }

            _lc.B.x /= _lc.C.size();
            _lc.B.y /= _lc.C.size();
        }

        for(int j2 = 0; j2 < j1; j2++)
        {
            for(F f2 = F9[j2].C.O(); f2.C(); f2.B())
                i1.H(f2.H());

            for(U u1 = F9[j2].F.L(); u1.C(); u1.B())
                i1.C(u1.I());

        }

        if(F5)
        {
            S as[] = new S[j1];
            A aa[] = new A[j1];
            G ag[] = new G[j1];
            java.awt.geom.Rectangle2D.Double adouble[] = new java.awt.geom.Rectangle2D.Double[j1];
            for(int k2 = 0; k2 < j1; k2++)
            {
                as[k2] = F9[k2].C;
                aa[k2] = F9[k2].F;
                ag[k2] = F9[k2].I;
                adouble[k2] = F9[k2].H;
            }

            A(i1, as, aa, ag, ((java.awt.geom.Rectangle2D []) (adouble)));
        }
        C.E.M.A(this, "done !");
        F9 = null;
        i1.A(k1);
        break MISSING_BLOCK_LABEL_1158;
        Exception exception;
        exception;
        F9 = null;
        i1.A(k1);
        throw exception;
    }

    protected java.awt.geom.Rectangle2D g(C.G.I i1)
    {
        return C.G.n.A(i1, i1.H(), i1.M(), k());
    }

    public boolean k()
    {
        return F6;
    }

    protected void A(C.G.I i1, S as[], A aa[], G ag[], java.awt.geom.Rectangle2D arectangle2d[])
    {
        byte byte0 = g();
        if((byte0 & 0x1f) >= 4)
        {
            boolean flag = (byte0 & 0x20) == 32;
            switch(byte0 & 0x1f)
            {
            case 4: // '\004'
            default:
                A(i1, as, aa, ag, arectangle2d, false, true, flag);
                break;

            case 5: // '\005'
                A(i1, as, aa, ag, arectangle2d, false, false, flag);
                break;

            case 6: // '\006'
                A(i1, as, aa, ag, arectangle2d, true, true, flag);
                break;

            case 7: // '\007'
                A(i1, as, aa, ag, arectangle2d, true, false, flag);
                break;
            }
        } else
        {
            switch(byte0 & 0x1f)
            {
            case 1: // '\001'
            default:
                C.G.n.A(arectangle2d, null, FD / F4);
                break;

            case 2: // '\002'
                Integer ainteger[] = new Integer[as.length];
                double d = -1.7976931348623157E+308D;
                for(int j2 = 0; j2 < ainteger.length; j2++)
                {
                    ainteger[j2] = new Integer(j2);
                    d = Math.max(d, F9[j2].E.getHeight());
                }

                if((byte0 & 0x20) == 32)
                    Arrays.sort(ainteger, new Comparator() {

                        public int compare(Object obj, Object obj1)
                        {
                            int i4 = ((Integer)obj).intValue();
                            int j4 = ((Integer)obj1).intValue();
                            double d10 = F9[i4].A.x - F9[j4].A.x;
                            return d10 <= 0.0D ? d10 >= 0.0D ? 0 : -1 : 1;
                        }

                    });
                double d4 = 0.0D;
                for(int i3 = 0; i3 < ainteger.length; i3++)
                {
                    int k3 = ainteger[i3].intValue();
                    arectangle2d[k3].setFrame(d4, (d - arectangle2d[k3].getHeight()) * 0.5D, arectangle2d[k3].getWidth(), arectangle2d[k3].getHeight());
                    d4 += arectangle2d[k3].getWidth();
                }

                break;

            case 3: // '\003'
                Integer ainteger1[] = new Integer[as.length];
                double d1 = -1.7976931348623157E+308D;
                for(int k2 = 0; k2 < ainteger1.length; k2++)
                {
                    ainteger1[k2] = new Integer(k2);
                    d1 = Math.max(d1, F9[k2].E.getWidth());
                }

                if((byte0 & 0x20) == 32)
                    Arrays.sort(ainteger1, new Comparator() {

                        public int compare(Object obj, Object obj1)
                        {
                            int i4 = ((Integer)obj).intValue();
                            int j4 = ((Integer)obj1).intValue();
                            double d10 = F9[i4].A.y - F9[j4].A.y;
                            return d10 <= 0.0D ? d10 >= 0.0D ? 0 : -1 : 1;
                        }

                    });
                double d5 = 0.0D;
                for(int j3 = 0; j3 < ainteger1.length; j3++)
                {
                    int l3 = ainteger1[j3].intValue();
                    arectangle2d[l3].setFrame((d1 - arectangle2d[l3].getWidth()) * 0.5D, d5, arectangle2d[l3].getWidth(), arectangle2d[l3].getHeight());
                    d5 += arectangle2d[l3].getHeight();
                }

                break;

            case 0: // '\0'
                for(int j1 = 0; j1 < arectangle2d.length; j1++)
                {
                    _C _lc = F9[j1];
                    double d3 = _lc.A.x - _lc.B.x;
                    double d7 = _lc.A.y - _lc.B.y;
                    arectangle2d[j1].setRect(arectangle2d[j1].getX() + d3, arectangle2d[j1].getY() + d7, arectangle2d[j1].getWidth(), arectangle2d[j1].getHeight());
                }

                if((byte0 & 0x40) == 64)
                {
                    C.G.T t = new C.G.T();
                    T at[] = new T[F9.length];
                    for(int i2 = 0; i2 < F9.length; i2++)
                    {
                        at[i2] = t.K();
                        f f1 = t.E(at[i2]);
                        f1.B(arectangle2d[i2].getWidth(), arectangle2d[i2].getHeight());
                        f1.A(arectangle2d[i2].getX(), arectangle2d[i2].getY());
                    }

                    C.G.B.A a = new C.G.B.A();
                    a.R(true);
                    a.Q(false);
                    a.D(0.0D);
                    a.F((byte)2);
                    a.A(t);
                    for(int l2 = 0; l2 < F9.length; l2++)
                    {
                        f f2 = t.E(at[l2]);
                        arectangle2d[l2].setFrame(f2.C(), f2.A(), f2.B(), f2.D());
                    }

                }
                break;
            }
            if(FB <= 0.0D)
            {
                for(int k1 = 0; k1 < arectangle2d.length; k1++)
                    B(i1, as[k1], aa[k1], new C.K.M(arectangle2d[k1].getX(), arectangle2d[k1].getY()), ag[k1]);

            } else
            {
                for(int l1 = 0; l1 < arectangle2d.length; l1++)
                {
                    double d2 = Math.floor((arectangle2d[l1].getX() - ag[l1].T()) / FB) * FB;
                    double d6 = Math.floor((arectangle2d[l1].getY() - ag[l1].U()) / FB) * FB;
                    double d8 = ag[l1].T() + d2;
                    double d9 = ag[l1].U() + d6;
                    B(i1, as[l1], aa[l1], new C.K.M(d8, d9), ag[l1]);
                }

            }
        }
    }

    protected void B(C.G.I i1, S s, A a, C.K.M m, G g1)
    {
        double d = -g1.T() + m.B();
        double d1 = -g1.U() + m.A();
        for(F f1 = s.O(); f1.C(); f1.B())
        {
            C.K.M m1 = i1.N(f1.H());
            i1.A(f1.H(), new C.K.M(m1.B() + d, m1.A() + d1));
        }

        for(U u = a.L(); u.C(); u.B())
        {
            J j1 = u.I();
            Vector vector = new Vector();
            for(C.A.I k1 = i1.N(j1).B(); k1.C(); k1.B())
            {
                C.K.M m2 = (C.K.M)k1.D();
                vector.addElement(new C.K.M(m2.B() + d, m2.A() + d1));
            }

            i1.A(j1, new C(vector));
        }

        A(i1, s, a, m, g1);
    }

    private void A(C.G.I i1, S s, A a, C.K.M m, G g1)
    {
        M m1 = i1.B(C.G.Q.C);
        if(m1 != null)
        {
            double d = -g1.T() + m.B();
            double d1 = -g1.U() + m.A();
            for(U u = a.L(); u.C(); u.B())
            {
                o ao[] = (o[])m1.D(u.I());
                if(ao == null)
                    continue;
                for(int j1 = 0; j1 < ao.length; j1++)
                    ao[j1].A(ao[j1].E() + d, ao[j1].H() + d1);

            }

        }
    }

    public double j()
    {
        return FB;
    }

    public void F(double d)
    {
        FB = d;
    }

    public double l()
    {
        return FA;
    }

    public void E(double d)
    {
        FA = d;
    }

    public boolean h()
    {
        return F8;
    }

    public byte g()
    {
        return F3;
    }

    private _B A(C.G.I i1, S s, A a, double d, double d1, 
            boolean flag)
    {
        int j1 = 0x7fffffff;
        int k1 = 0x80000000;
        int l1 = 0x7fffffff;
        int i2 = 0x80000000;
        M m = i1.B(C.G.Q.C);
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double();
        double d2 = l() * 0.5D;
        for(F f1 = s.O(); f1.C(); f1.B())
        {
            f f2 = i1.E(f1.H());
            double1.setFrame(f2.C() - d2, f2.A() - d2, f2.B() + d2 * 2D, f2.D() + d2 * 2D);
            j1 = Math.min((int)Math.floor(double1.x / d), j1);
            l1 = Math.min((int)Math.floor(double1.y / d1), l1);
            k1 = Math.max((int)Math.floor((double1.x + double1.width) / d), k1);
            i2 = Math.max((int)Math.floor((double1.y + double1.height) / d1), i2);
        }

        for(U u = a.L(); u.C(); u.B())
        {
            C c = i1.P(u.I());
            for(C.K.D d3 = c.C(); d3.C(); d3.B())
            {
                j1 = Math.min(j1, (int)Math.floor(d3.K().A / d));
                k1 = Math.max(k1, (int)Math.floor(d3.K().A / d));
                l1 = Math.min(l1, (int)Math.floor(d3.K().D / d1));
                i2 = Math.max(i2, (int)Math.floor(d3.K().D / d1));
            }

        }

        if(m != null)
        {
            for(U u1 = a.L(); u1.C(); u1.B())
            {
                o ao[] = (o[])m.D(u1.I());
                if(ao == null)
                    continue;
                for(int j2 = 0; j2 < ao.length; j2++)
                {
                    o o1 = ao[j2];
                    double1.setFrame(o1.E() - d2, o1.H() - d2, o1.D() + d2 * 2D, o1.F() + d2 * 2D);
                    j1 = Math.min((int)Math.floor(double1.x / d), j1);
                    l1 = Math.min((int)Math.floor(double1.y / d1), l1);
                    k1 = Math.max((int)Math.floor((double1.x + double1.width) / d), k1);
                    i2 = Math.max((int)Math.floor((double1.y + double1.height) / d1), i2);
                }

            }

        }
        j1 -= 2;
        l1 -= 2;
        k1 += 2;
        i2 += 2;
        _B _lb = new _B(j1, l1, k1 - j1, i2 - l1);
        for(F f3 = s.O(); f3.C(); f3.B())
        {
            f f4 = i1.E(f3.H());
            double1.setFrame(f4.C() - d2, f4.A() - d2, f4.B() + d2 * 2D, f4.D() + d2 * 2D);
            _lb.B((int)Math.floor(double1.x / d), (int)Math.floor(double1.y / d1), 1 + (int)Math.floor((double1.x + double1.width) / d), 1 + (int)Math.floor((double1.y + double1.height) / d1));
        }

        for(U u2 = a.L(); u2.C(); u2.B())
        {
            C c1 = i1.P(u2.I());
            for(L l2 = c1.A(); l2.C(); l2.B())
            {
                C.K.J j3 = l2.L();
                A(_lb, j3.Y().A, j3.Y().D, j3.W().A, j3.W().D, d, d1);
            }

        }

        if(m != null)
        {
            for(U u3 = a.L(); u3.C(); u3.B())
            {
                o ao1[] = (o[])m.D(u3.I());
                if(ao1 == null)
                    continue;
                for(int k2 = 0; k2 < ao1.length; k2++)
                {
                    o o2 = ao1[k2];
                    double1.setFrame(o2.E() - d2, o2.H() - d2, o2.D() + d2 * 2D, o2.F() + d2 * 2D);
                    _lb.B((int)Math.floor(double1.x / d), (int)Math.floor(double1.y / d1), 1 + (int)Math.floor((double1.x + double1.width) / d), 1 + (int)Math.floor((double1.y + double1.height) / d1));
                }

            }

        }
        if(flag)
            _lb.A();
        return _lb;
    }

    static void A(_B _pb, double d, double d1, double d2, double d3, double d4, double d5)
    {
        double d6 = d2 - d;
        double d7 = d3 - d1;
        double d8 = 0.10000000000000001D;
        if(d4 > 1.0D)
        {
            for(int i1 = 1 + (int)Math.rint(d4); i1 > 0; i1 /= 10)
                d8 /= 10D;

        }
        d8 = Math.min(d8, 1.0000000000000001E-05D);
        double d9 = 0.10000000000000001D;
        if(d5 > 1.0D)
        {
            for(int j1 = 1 + (int)Math.rint(d5); j1 > 0; j1 /= 10)
                d9 /= 10D;

        }
        d9 = Math.min(d9, 1.0000000000000001E-05D);
        int k1 = (int)Math.floor(d / d4);
        int l1 = (int)Math.floor(d1 / d5);
        int i2 = (int)Math.floor(d2 / d4);
        int j2 = (int)Math.floor(d3 / d5);
        int k2 = i2 - k1;
        int l2 = j2 - l1;
        if(k2 == 0 || Math.abs(d6) < d8)
            _pb.B(k1, Math.min(l1, j2), k1 + 1, Math.max(l1, j2) + 1);
        else
        if(l2 == 0 || Math.abs(d7) < d9)
            _pb.B(Math.min(k1, i2), l1, Math.max(k1, i2) + 1, l1 + 1);
        else
        if(Math.abs(k2) > Math.abs(l2))
        {
            if(k1 > i2)
            {
                double d10 = d7 / d6;
                double d14 = d3;
                double d18 = ((Math.floor(d2 / d4) + 1.0D) - (double)i2) * d10 + d3;
                double d22 = d4 * d10;
                for(int i3 = i2; i3 < k1; i3++)
                {
                    int i5 = (int)Math.floor(d14 / d5);
                    int i6 = (int)Math.floor(d18 / d5);
                    _pb.A(i3, i5, true);
                    if(i5 != i6 && i3 < k1)
                        _pb.A(i3, i6, true);
                    d14 = d18;
                    d18 += d22;
                }

                int j3 = (int)Math.floor(d14 / d5);
                _pb.A(k1, j3, true);
                if(j3 != l1)
                    _pb.A(k1, l1, true);
            } else
            {
                double d11 = d7 / d6;
                double d15 = d1;
                double d19 = ((Math.floor(d / d4) + 1.0D) - (double)k1) * d11 + d1;
                double d23 = d4 * d11;
                for(int k3 = k1; k3 < i2; k3++)
                {
                    int j5 = (int)Math.floor(d15 / d5);
                    int j6 = (int)Math.floor(d19 / d5);
                    _pb.A(k3, j5, true);
                    if(j5 != j6)
                        _pb.A(k3, j6, true);
                    d15 = d19;
                    d19 += d23;
                }

                int l3 = (int)Math.floor(d15 / d5);
                _pb.A(i2, l3, true);
                if(l3 != j2)
                    _pb.A(i2, j2, true);
            }
        } else
        if(l1 > j2)
        {
            double d12 = d6 / d7;
            double d16 = d2;
            double d20 = ((Math.floor(d3 / d5) + 1.0D) - (double)j2) * d12 + d2;
            double d24 = d5 * d12;
            for(int i4 = j2; i4 < l1; i4++)
            {
                int k5 = (int)Math.floor(d16 / d4);
                int k6 = (int)Math.floor(d20 / d4);
                _pb.A(k5, i4, true);
                if(k5 != k6)
                    _pb.A(k6, i4, true);
                d16 = d20;
                d20 += d24;
            }

            int j4 = (int)Math.floor(d16 / d4);
            _pb.A(j4, l1, true);
            if(j4 != k1)
                _pb.A(k1, l1, true);
        } else
        {
            double d13 = d6 / d7;
            double d17 = d;
            double d21 = ((Math.floor(d1 / d5) + 1.0D) - (double)l1) * d13 + d;
            double d25 = d5 * d13;
            for(int k4 = l1; k4 < j2; k4++)
            {
                int l5 = (int)Math.floor(d17 / d4);
                int l6 = (int)Math.floor(d21 / d4);
                _pb.A(l5, k4, true);
                if(l5 != l6)
                    _pb.A(l6, k4, true);
                d17 = d21;
                d21 += d25;
            }

            int l4 = (int)Math.floor(d17 / d4);
            _pb.A(l4, j2, true);
            if(l4 != i2)
                _pb.A(i2, j2, true);
        }
    }

    protected void A(C.G.I i1, S as[], A aa[], G ag[], java.awt.geom.Rectangle2D arectangle2d[], boolean flag, boolean flag1, 
            boolean flag2)
    {
        double d;
        double d1;
        if(j() > 0.0D)
        {
            if(j() > 10D)
            {
                d = j();
                d1 = j();
            } else
            {
                int j1 = (int)Math.ceil(10D / j());
                if(j1 < 1)
                    j1 = 1;
                d = d1 = j() * (double)j1;
            }
        } else
        {
            d = d1 = Math.max(l(), 25D);
        }
        _A a_la[] = new _A[as.length];
        for(int k1 = 0; k1 < as.length; k1++)
        {
            a_la[k1] = new _A();
            a_la[k1].B = k1;
            a_la[k1].C = A(i1, as[k1], aa[k1], d, d1, flag1);
            a_la[k1].A = a_la[k1].C.E.cardinality();
        }

        Arrays.sort(a_la, new Comparator() {

            public int compare(Object obj, Object obj1)
            {
                _A _la1 = (_A)obj;
                _A _la2 = (_A)obj1;
                return _la2.A - _la1.A;
            }

        });
        _B _lb = a_la[0].C;
        for(int l1 = 1; l1 < a_la.length; l1++)
        {
            _A _la = a_la[l1];
            int i2;
            int j2;
            if(flag2)
            {
                G g1 = ag[_la.B];
                i2 = (int)Math.round((g1.T() + g1.Q() * 0.5D) / d);
                j2 = (int)Math.round((g1.U() + g1.R() * 0.5D) / d1);
            } else
            {
                i2 = _lb.A + _lb.C / 2;
                j2 = _lb.G + _lb.F / 2;
            }
            _la.C.A(_lb, i2, j2, FD / F4, flag);
            int k2 = _la.B;
            B(i1, as[k2], aa[k2], new C.K.M(ag[k2].K + (double)_la.C.C() * d, ag[k2].M + (double)_la.C.B() * d1), ag[k2]);
            _la.C = null;
        }

    }

    public static final Object FC = "y.layout.ComponentLayouter.LAYOUT_NODE_DPKEY";
    public static final Object FE = "y.layout.ComponentLayouter.GIVEN_COMPONENT_ID_DPKEY";
    private double FD;
    private double F4;
    private double FB;
    private double FA;
    private boolean F8;
    private boolean F5;
    private byte F3;
    private boolean F6;
    private _C F9[];


}
