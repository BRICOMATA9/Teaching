// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.*;
import java.util.HashMap;
import java.util.Map;

public class W
{
    static class _A extends _D
        implements Q, K, L
    {

        public void A(Object obj, Object obj1)
        {
            H.put(obj, obj1);
        }

        public void A(Object obj, int i)
        {
            H.put(obj, new Integer(i));
        }

        public void A(Object obj, double d)
        {
            H.put(obj, new Double(d));
        }

        public void A(Object obj, boolean flag)
        {
            H.put(obj, flag ? ((Object) (Boolean.TRUE)) : ((Object) (Boolean.FALSE)));
        }

        _A(Map map)
        {
            super(map);
        }
    }

    static class _D
        implements M
    {

        public Object D(Object obj)
        {
            return H.get(obj);
        }

        public int A(Object obj)
        {
            Object obj1 = H.get(obj);
            return (obj1 instanceof Number) ? ((Number)obj1).intValue() : 0;
        }

        public double C(Object obj)
        {
            Object obj1 = H.get(obj);
            return (obj1 instanceof Number) ? ((Number)obj1).doubleValue() : 0.0D;
        }

        public boolean B(Object obj)
        {
            return H.get(obj) == Boolean.TRUE;
        }

        Map H;

        _D(Map map)
        {
            H = map;
        }
    }

    private static final class _C
        implements L
    {

        public Object D(Object obj)
        {
            return P[((J)obj).L()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Edge.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof J) && ((J)obj).K() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
        }

        public double C(Object obj)
        {
            return R[((J)obj).L()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Edge.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof J) && ((J)obj).K() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get double from this type of Map!");
        }

        public int A(Object obj)
        {
            return S[((J)obj).L()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Edge.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof J) && ((J)obj).K() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get int from this type of Map!");
        }

        public boolean B(Object obj)
        {
            return Q[((J)obj).L()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Edge.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof J) && ((J)obj).K() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
        }

        public void A(Object obj, Object obj1)
        {
            try
            {
                P[((J)obj).L()] = obj1;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Edge.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof J) && ((J)obj).K() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
            }
        }

        public void A(Object obj, double d)
        {
            try
            {
                R[((J)obj).L()] = d;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Edge.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof J) && ((J)obj).K() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set double in this type of Map!");
            }
        }

        public void A(Object obj, int i)
        {
            try
            {
                S[((J)obj).L()] = i;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Edge.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof J) && ((J)obj).K() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set int in this type of Map!");
            }
        }

        public void A(Object obj, boolean flag)
        {
            try
            {
                Q[((J)obj).L()] = flag;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Edge.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof J) && ((J)obj).K() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
            }
        }

        double R[];
        int S[];
        boolean Q[];
        Object P[];

        _C(double ad[], int ai[], boolean aflag[], Object aobj[])
        {
            R = ad;
            S = ai;
            Q = aflag;
            P = aobj;
        }
    }

    static final class _B
        implements K
    {

        public Object D(Object obj)
        {
            return T[((T)obj).Q()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Node.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof T) && ((T)obj)._() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
        }

        public double C(Object obj)
        {
            return V[((T)obj).Q()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Node.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof T) && ((T)obj)._() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get double from this type of Map!");
        }

        public int A(Object obj)
        {
            return W[((T)obj).Q()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Node.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof T) && ((T)obj)._() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get int from this type of Map!");
        }

        public boolean B(Object obj)
        {
            return U[((T)obj).Q()];
            Object obj1;
            obj1;
            throw new IllegalArgumentException("Argument must be of type Node.");
            obj1;
            if(obj == null)
                throw new IllegalArgumentException("Argument must be non-null.");
            if((obj instanceof T) && ((T)obj)._() == null)
                throw new IllegalArgumentException("Argument is not in graph");
            else
                throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
        }

        public void A(Object obj, Object obj1)
        {
            try
            {
                T[((T)obj).Q()] = obj1;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Node.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof T) && ((T)obj)._() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
            }
        }

        public void A(Object obj, double d)
        {
            try
            {
                V[((T)obj).Q()] = d;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Node.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof T) && ((T)obj)._() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set double in this type of Map!");
            }
        }

        public void A(Object obj, int i)
        {
            try
            {
                W[((T)obj).Q()] = i;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Node.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof T) && ((T)obj)._() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set int in this type of Map!");
            }
        }

        public void A(Object obj, boolean flag)
        {
            try
            {
                U[((T)obj).Q()] = flag;
            }
            catch(ClassCastException classcastexception)
            {
                throw new IllegalArgumentException("Key must be of type Node.");
            }
            catch(NullPointerException nullpointerexception)
            {
                if(obj == null)
                    throw new IllegalArgumentException("Key must be non-null.");
                if((obj instanceof T) && ((T)obj)._() == null)
                    throw new IllegalArgumentException("Key is not in graph");
                else
                    throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
            }
        }

        double V[];
        int W[];
        boolean U[];
        Object T[];

        _B(double ad[], int ai[], boolean aflag[], Object aobj[])
        {
            V = ad;
            W = ai;
            U = aflag;
            T = aobj;
        }
    }


    public static K A(double ad[])
    {
        return new _B(ad, null, null, null);
    }

    public static K A(int ai[])
    {
        return new _B(null, ai, null, null);
    }

    public static K B(boolean aflag[])
    {
        return new _B(null, null, aflag, null);
    }

    public static L A(boolean aflag[])
    {
        return new _C(null, null, aflag, null);
    }

    public static K A()
    {
        return new _A(new HashMap());
    }

    public static K A(Map map)
    {
        return new _A(map);
    }

    public static L B()
    {
        return new _A(new HashMap());
    }
}
