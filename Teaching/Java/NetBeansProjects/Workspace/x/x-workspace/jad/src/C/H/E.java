// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.util.*;

class E extends Dictionary
    implements Cloneable
{
    private static final class _B
    {

        protected Object clone()
        {
            _B _lb = new _B();
            _lb.D = D;
            _lb.A = A;
            _lb.C = C;
            _lb.B = B == null ? null : (_B)B.clone();
            return _lb;
        }

        int D;
        int A;
        Object C;
        _B B;

        private _B()
        {
        }

    }

    public class _A
        implements Enumeration
    {

        public boolean hasMoreElements()
        {
            if(B != null)
                return true;
            while(A-- > 0) 
                if((B = C[A]) != null)
                    return true;
            return false;
        }

        public Object nextElement()
        {
            if(B == null)
                while(A-- > 0 && (B = C[A]) == null) ;
            if(B != null)
            {
                _B _lb = B;
                B = _lb.B;
                return D ? new Integer(_lb.A) : _lb.C;
            } else
            {
                throw new NoSuchElementException("IntHashtableEnumerator");
            }
        }

        boolean D;
        int A;
        _B C[];
        _B B;

        _A(_B a_pb[], boolean flag)
        {
            C = a_pb;
            D = flag;
            A = a_pb.length;
        }
    }


    public E(int i, float f)
    {
        if(i <= 0 || (double)f <= 0.0D)
        {
            throw new IllegalArgumentException();
        } else
        {
            D = f;
            C = new _B[i];
            A = (int)((float)i * f);
            return;
        }
    }

    public E()
    {
        this(101, 0.75F);
    }

    public int size()
    {
        return B;
    }

    public boolean isEmpty()
    {
        return B == 0;
    }

    public synchronized Enumeration keys()
    {
        return new _A(C, true);
    }

    public synchronized Enumeration elements()
    {
        return new _A(C, false);
    }

    public synchronized Object B(int i)
    {
        _B a_lb[] = C;
        int j = i;
        int k = (j & 0x7fffffff) % a_lb.length;
        for(_B _lb = a_lb[k]; _lb != null; _lb = _lb.B)
            if(_lb.D == j && _lb.A == i)
                return _lb.C;

        return null;
    }

    public Object get(Object obj)
    {
        if(!(obj instanceof Integer))
        {
            throw new InternalError("key is not an Integer");
        } else
        {
            Integer integer = (Integer)obj;
            int i = integer.intValue();
            return B(i);
        }
    }

    protected void A()
    {
        int i = C.length;
        _B a_lb[] = C;
        int j = i * 2 + 1;
        _B a_lb1[] = new _B[j];
        A = (int)((float)j * D);
        C = a_lb1;
        for(int k = i; k-- > 0;)
        {
            _B _lb = a_lb[k];
            while(_lb != null) 
            {
                _B _lb1 = _lb;
                _lb = _lb.B;
                int l = (_lb1.D & 0x7fffffff) % j;
                _lb1.B = a_lb1[l];
                a_lb1[l] = _lb1;
            }
        }

    }

    public synchronized Object A(int i, Object obj)
    {
        if(obj == null)
            throw new NullPointerException();
        _B a_lb[] = C;
        int j = i;
        int k = (j & 0x7fffffff) % a_lb.length;
        for(_B _lb = a_lb[k]; _lb != null; _lb = _lb.B)
            if(_lb.D == j && _lb.A == i)
            {
                Object obj1 = _lb.C;
                _lb.C = obj;
                return obj1;
            }

        if(B >= A)
        {
            A();
            return A(i, obj);
        } else
        {
            _B _lb1 = new _B();
            _lb1.D = j;
            _lb1.A = i;
            _lb1.C = obj;
            _lb1.B = a_lb[k];
            a_lb[k] = _lb1;
            B++;
            return null;
        }
    }

    public Object put(Object obj, Object obj1)
    {
        if(!(obj instanceof Integer))
        {
            throw new InternalError("key is not an Integer");
        } else
        {
            Integer integer = (Integer)obj;
            int i = integer.intValue();
            return A(i, obj1);
        }
    }

    public synchronized Object A(int i)
    {
        _B a_lb[] = C;
        int j = i;
        int k = (j & 0x7fffffff) % a_lb.length;
        _B _lb = a_lb[k];
        _B _lb1 = null;
        for(; _lb != null; _lb = _lb.B)
        {
            if(_lb.D == j && _lb.A == i)
            {
                if(_lb1 != null)
                    _lb1.B = _lb.B;
                else
                    a_lb[k] = _lb.B;
                B--;
                return _lb.C;
            }
            _lb1 = _lb;
        }

        return null;
    }

    public Object remove(Object obj)
    {
        if(!(obj instanceof Integer))
        {
            throw new InternalError("key is not an Integer");
        } else
        {
            Integer integer = (Integer)obj;
            int i = integer.intValue();
            return A(i);
        }
    }

    public synchronized Object clone()
    {
        E e;
        e = (E)super.clone();
        e.C = new _B[C.length];
        for(int i = C.length; i-- > 0;)
            e.C[i] = C[i] == null ? null : (_B)C[i].clone();

        return e;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        throw new InternalError();
    }

    public synchronized String toString()
    {
        int i = size() - 1;
        StringBuffer stringbuffer = new StringBuffer();
        Enumeration enumeration = keys();
        Enumeration enumeration1 = elements();
        stringbuffer.append("{");
        for(int j = 0; j <= i; j++)
        {
            String s = enumeration.nextElement().toString();
            String s1 = enumeration1.nextElement().toString();
            stringbuffer.append(s + "=" + s1);
            if(j < i)
                stringbuffer.append(", ");
        }

        stringbuffer.append("}");
        return stringbuffer.toString();
    }

    private _B C[];
    private int B;
    private int A;
    private float D;
}
