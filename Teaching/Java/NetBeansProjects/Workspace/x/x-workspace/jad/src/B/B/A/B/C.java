// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;

import C.A.M;
import C.E.T;
import java.util.*;

// Referenced classes of package B.B.A.B:
//            A, F, E

public class C
{
    private static final class _E
        implements _D
    {

        public Iterator A()
        {
            E e = B.B.A.B.E.D();
            return e.A();
        }

        public Iterator B()
        {
            E e = B.B.A.B.E.D();
            return e.B();
        }

        private _E()
        {
        }

    }

    private static class _A extends T
    {

        public Object D(Object obj)
        {
            return n.A((String)obj);
        }

        private final A n;

        _A(A a)
        {
            n = a;
        }
    }

    private static final class _B
    {

        Object A(String s, String s1, boolean flag)
        {
            Object obj = null;
            Object obj1 = s;
            boolean flag1 = true;
            do
            {
                Map map = (Map)B.get(obj1);
                if(map != null && map.containsKey(s1))
                {
                    flag1 = false;
                    obj = map.get(s1);
                }
            } while(flag && flag1 && (obj1 = A.get(obj1)) != null);
            return obj;
        }

        void A(String s, String s1, Object obj)
        {
            Map map = (Map)B.get(s);
            if(map == null)
                map = A(s);
            map.put(s1, obj);
        }

        boolean A(String s, String s1)
        {
            Map map = (Map)B.get(s);
            return map != null && map.containsKey(s1);
        }

        Map A(String s)
        {
            HashMap hashmap = new HashMap();
            B.put(s, hashmap);
            return hashmap;
        }

        Set A()
        {
            HashSet hashset = new HashSet(B.size() + A.size());
            hashset.addAll(B.keySet());
            hashset.addAll(A.keySet());
            return hashset;
        }

        final Map B = new HashMap();
        final Map A = new HashMap();

        _B()
        {
        }
    }

    private static final class _C
        implements A
    {

        public byte B()
        {
            return B;
        }

        public String C()
        {
            return A;
        }

        public A D()
        {
            String s = (String)C.A.get(A);
            if(s != null)
                return new _C(C, D, s, B);
            else
                return null;
        }

        public void A(A a)
        {
            if(a != null)
                C.A.put(A, a.C());
            else
                C.A.remove(A);
        }

        public Object A(String s)
        {
            return A(s, true);
        }

        public Object A(String s, boolean flag)
        {
            return C.A(A, s, flag);
        }

        public boolean B(String s)
        {
            return C.A(A, s);
        }

        public void A(String s, Object obj)
        {
            C.A(A, s, obj);
        }

        public Iterator A()
        {
            return 0 != B ? D.B() : D.A();
        }

        private final _B C;
        private final _D D;
        private final byte B;
        private String A;

        _C(_B _pb, _D _pd, String s, byte byte0)
        {
            C = _pb;
            D = _pd;
            A = s;
            B = byte0;
        }
    }

    public static interface _D
    {

        public abstract Iterator B();

        public abstract Iterator A();
    }


    public C()
    {
        A = null;
    }

    public _D A()
    {
        return A;
    }

    public void A(_D _pd)
    {
        A = _pd;
    }

    public A B(String s)
    {
        Object obj;
        if(A == null)
            obj = new _E();
        else
            obj = A;
        return new _C(C, ((_D) (obj)), s, (byte)1);
    }

    public Set D()
    {
        return C.A();
    }

    public A A(String s)
    {
        Object obj;
        if(A == null)
            obj = new _E();
        else
            obj = A;
        return new _C(B, ((_D) (obj)), s, (byte)0);
    }

    public Set C()
    {
        return B.A();
    }

    public void B()
    {
        C.B.clear();
        C.A.clear();
        B.B.clear();
        B.A.clear();
    }

    public M A(A a)
    {
        return new _A(a);
    }

    F F()
    {
        return new F() {

            public A A(String s)
            {
                return C.this.A(s);
            }

            public Set A()
            {
                return C.this.C();
            }

        };
    }

    F E()
    {
        return new F() {

            public A A(String s)
            {
                return B(s);
            }

            public Set A()
            {
                return D();
            }

        };
    }

    private final _B C = new _B();
    private final _B B = new _B();
    private _D A;
}
