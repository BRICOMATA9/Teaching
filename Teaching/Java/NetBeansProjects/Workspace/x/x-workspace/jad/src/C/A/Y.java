// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;

import C.E.M;
import java.lang.reflect.Array;
import java.util.*;

// Referenced classes of package C.A:
//            I, P

public class Y
    implements Collection, List
{
    public class _B
        implements I
    {

        public boolean C()
        {
            return A != null;
        }

        public void B()
        {
            A = A.A;
        }

        public void G()
        {
            A = A.B;
        }

        public void E()
        {
            A = Y.this.E;
        }

        public void A()
        {
            A = Y.this.C;
        }

        public int F()
        {
            return Y.this.D;
        }

        public Object D()
        {
            return A.C;
        }

        P A;

        protected _B()
        {
            E();
        }
    }

    static final class _C
        implements ListIterator
    {

        private final void A()
        {
            if(E != D.F)
                throw new ConcurrentModificationException();
            else
                return;
        }

        public void set(Object obj)
        {
            A();
            if(B != null)
                B.A(obj);
            else
                throw new IllegalStateException();
        }

        public void add(Object obj)
        {
            A();
            if(A != null)
                D.B(obj, A);
            else
                D.add(obj);
            E = D.F;
            C++;
            B = null;
        }

        public void remove()
        {
            A();
            if(B != null)
            {
                if(B.A == A)
                    C--;
                D.A(B);
                B = null;
                E = D.F;
            } else
            {
                throw new IllegalStateException();
            }
        }

        public int previousIndex()
        {
            A();
            return C - 1;
        }

        public Object previous()
        {
            A();
            if(A != null)
                if(A.B != null)
                {
                    A = A.B;
                    B = A;
                    C--;
                    return A.C;
                } else
                {
                    throw new NoSuchElementException();
                }
            A = D.C;
            if(A != null)
            {
                C--;
                return A.C;
            } else
            {
                throw new NoSuchElementException();
            }
        }

        public int nextIndex()
        {
            A();
            return C;
        }

        public Object next()
        {
            A();
            if(A != null)
            {
                Object obj = A.A();
                B = A;
                C++;
                A = A.C();
                return obj;
            } else
            {
                throw new NoSuchElementException();
            }
        }

        public boolean hasPrevious()
        {
            A();
            return A == null && D.C != null || A.B != null;
        }

        public boolean hasNext()
        {
            A();
            return A != null;
        }

        final Y D;
        private int C;
        private int E;
        private P B;
        private P A;

        _C(Y y, int i, P p)
        {
            D = y;
            C = i;
            A = p;
            E = y.F;
        }
    }

    static final class _A
        implements Iterator
    {

        private final void A()
        {
            if(C != B.F)
                throw new ConcurrentModificationException();
            else
                return;
        }

        public final boolean hasNext()
        {
            A();
            return A != null;
        }

        public final void remove()
        {
            A();
            if(A == null)
            {
                if(B.C != null)
                    B.A(B.C);
                else
                    throw new IllegalStateException();
                C = B.F;
            } else
            if(A.B != null)
            {
                B.A(A.B);
                C = B.F;
            } else
            {
                throw new IllegalStateException();
            }
        }

        public final Object next()
        {
            A();
            if(A != null)
            {
                Object obj = A.A();
                A = A.C();
                return obj;
            } else
            {
                throw new NoSuchElementException();
            }
        }

        private P A;
        private final Y B;
        private int C;

        _A(Y y, P p)
        {
            A = p;
            B = y;
            C = y.F;
        }
    }


    public Y()
    {
        F = 0x80000000;
    }

    public Y(I i)
    {
        i.E();
        for(; i.C(); i.B())
            E(i.D());

        F = 0x80000000;
    }

    public Y(Object aobj[])
    {
        for(int i = aobj.length - 1; i >= 0; i--)
            B(aobj[i]);

        F = 0x80000000;
    }

    public P B(Object obj)
    {
        P p = D(obj);
        if(E == null)
        {
            E = C = p;
        } else
        {
            E.B = p;
            p.A = E;
            E = p;
        }
        D++;
        F++;
        return p;
    }

    public P E(Object obj)
    {
        P p = D(obj);
        if(C == null)
        {
            E = C = p;
        } else
        {
            C.A = p;
            p.B = C;
            C = p;
        }
        D++;
        F++;
        return p;
    }

    public void B(P p)
    {
        p.B = null;
        p.A = null;
        if(C == null)
        {
            E = C = p;
        } else
        {
            C.A = p;
            p.B = C;
            C = p;
        }
        F++;
        D++;
    }

    public void C(P p)
    {
        p.B = null;
        p.A = null;
        if(E == null)
        {
            E = C = p;
        } else
        {
            E.B = p;
            p.A = E;
            E = p;
        }
        F++;
        D++;
    }

    public boolean add(Object obj)
    {
        E(obj);
        return true;
    }

    public boolean addAll(Collection collection)
    {
        boolean flag = false;
        if(collection instanceof Y)
        {
            for(P p = ((Y)collection).I(); p != null; p = p.C())
                if(add(p.A()))
                    flag = true;

        } else
        {
            Iterator iterator1 = collection.iterator();
            do
            {
                if(!iterator1.hasNext())
                    break;
                if(add(iterator1.next()))
                    flag = true;
            } while(true);
        }
        return flag;
    }

    public void A(I i)
    {
        for(; i.C(); i.B())
            E(i.D());

    }

    public P B(Object obj, P p)
    {
        if(p == E)
            return B(obj);
        if(p == null)
        {
            return E(obj);
        } else
        {
            P p1 = D(obj);
            B(p1, p);
            return p1;
        }
    }

    public void B(P p, P p1)
    {
        if(p1 == null)
            C(p);
        else
        if(p1 == E)
        {
            C(p);
        } else
        {
            if(C == null)
            {
                p.B = null;
                p.A = null;
                E = C = p;
            } else
            {
                P p2 = p1.B;
                p1.B = p;
                p.A = p1;
                p2.A = p;
                p.B = p2;
            }
            D++;
            F++;
        }
    }

    public void A(P p, P p1)
    {
        if(p1 == null)
            B(p);
        else
        if(p1 == C)
        {
            B(p);
        } else
        {
            if(E == null)
            {
                p.B = null;
                p.A = null;
                E = C = p;
            } else
            {
                P p2 = p1.A;
                p1.A = p;
                p.A = p2;
                p2.B = p;
                p.B = p1;
            }
            D++;
            F++;
        }
    }

    public P A(Object obj, P p)
    {
        if(p == C)
            return E(obj);
        if(p == null)
        {
            return B(obj);
        } else
        {
            P p1 = D(obj);
            A(p1, p);
            return p1;
        }
    }

    public int size()
    {
        return D;
    }

    public boolean isEmpty()
    {
        return D == 0;
    }

    public void clear()
    {
        if(D > 0)
        {
            E = C = null;
            D = 0;
            F++;
        }
    }

    public Object F()
    {
        return E.C;
    }

    public Object C()
    {
        Object obj = F();
        A(I());
        return obj;
    }

    public P A(Object obj)
    {
        return B(obj);
    }

    public Object H()
    {
        return C.C;
    }

    public Object E()
    {
        return A(C);
    }

    public Object B(int i)
    {
        if(i < 0 || i >= size())
            return null;
        int j = 0;
        for(P p = E; p != null;)
        {
            if(i == j)
                return p.C;
            p = p.A;
            j++;
        }

        return null;
    }

    public int indexOf(Object obj)
    {
        int i = 0;
        for(P p = E; p != null;)
        {
            if(p.C == obj || p.C != null && p.C.equals(obj))
                return i;
            p = p.A;
            i++;
        }

        return -1;
    }

    public P I()
    {
        return E;
    }

    public P G()
    {
        return C;
    }

    public boolean remove(Object obj)
    {
        P p = C(obj);
        if(p != null)
        {
            A(p);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean removeAll(Collection collection)
    {
        int i = size();
        Object obj = (collection instanceof Set) ? ((Object) ((Set)collection)) : ((Object) (new HashSet(collection)));
        for(P p = I(); p != null; p = p.C())
            if(((Set) (obj)).contains(p.A()))
                A(p);

        return i != size();
    }

    public boolean retainAll(Collection collection)
    {
        int i = size();
        Object obj = (collection instanceof Set) ? ((Object) ((Set)collection)) : ((Object) (new HashSet(collection)));
        for(P p = I(); p != null; p = p.C())
            if(!((Set) (obj)).contains(p.A()))
                A(p);

        return i != size();
    }

    public Object A(P p)
    {
        if(p != E)
            p.B.A = p.A;
        else
            E = p.A;
        if(p != C)
            p.A.B = p.B;
        else
            C = p.B;
        F++;
        D--;
        return p.C;
    }

    public Object B(I i)
    {
        return A(((_B)i).A);
    }

    public I B()
    {
        return new _B();
    }

    public Iterator iterator()
    {
        return new _A(this, E);
    }

    public ListIterator listIterator()
    {
        return new _C(this, 0, E);
    }

    public boolean contains(Object obj)
    {
        return C(obj) != null;
    }

    public boolean containsAll(Collection collection)
    {
        for(Iterator iterator1 = collection.iterator(); iterator1.hasNext();)
        {
            Object obj = iterator1.next();
            if(!contains(obj))
                return false;
        }

        return true;
    }

    public P C(Object obj)
    {
        for(P p = E; p != null; p = p.A)
            if(p.C == obj || p.C != null && p.C.equals(obj))
                return p;

        return null;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(80);
        stringbuffer.append('[');
        for(P p = E; p != C; p = p.A)
        {
            stringbuffer.append(p.C);
            stringbuffer.append(',');
        }

        if(C != null)
            stringbuffer.append(C.C);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }

    public Object[] toArray()
    {
        Object aobj[] = new Object[size()];
        int i = 0;
        for(P p = E; p != null;)
        {
            aobj[i] = p.C;
            p = p.A;
            i++;
        }

        return aobj;
    }

    public Object[] toArray(Object aobj[])
    {
        if(aobj.length < D)
            aobj = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), D);
        int i = 0;
        for(P p = E; p != null; p = p.A)
            aobj[i++] = p.C;

        if(aobj.length > i)
            aobj[i] = null;
        return aobj;
    }

    public void D()
    {
        for(P p2 = E; p2 != null; p2 = p2.B)
        {
            P p = p2.A;
            p2.A = p2.B;
            p2.B = p;
        }

        P p1 = E;
        E = C;
        C = p1;
        F++;
    }

    public void A(Comparator comparator)
    {
        if(D > 1)
            if(D == 2 && comparator != null)
            {
                if(comparator.compare(E.C, C.C) > 0)
                {
                    Object obj = E.C;
                    E.C = C.C;
                    C.C = obj;
                }
            } else
            {
                Object aobj[] = toArray();
                Arrays.sort(aobj, comparator);
                int i = 0;
                for(P p = E; p != null;)
                {
                    p.C = aobj[i];
                    p = p.A;
                    i++;
                }

            }
    }

    public void A(Y y)
    {
        if(y.D > 0)
        {
            if(E == null)
            {
                E = y.E;
                C = y.C;
            } else
            if(y.E != null)
            {
                C.A = y.E;
                y.E.B = C;
                C = y.C;
            }
            D += y.D;
            y.E = y.C = null;
            y.D = 0;
            y.F++;
            F++;
        }
    }

    private P D(Object obj)
    {
        return new P(obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        P p = A(i);
        if(p.A == null)
        {
            for(Iterator iterator1 = collection.iterator(); iterator1.hasNext(); add(iterator1.next()));
        } else
        {
            for(Iterator iterator2 = collection.iterator(); iterator2.hasNext();)
                p = A(iterator2.next(), p);

        }
        return !collection.isEmpty();
    }

    public final P A(int i)
    {
        if(i < 0 || i >= D)
            throw new IndexOutOfBoundsException(Integer.toString(i));
        if(i > D / 2)
        {
            int j = D - 1;
            P p1;
            for(p1 = C; j > i; p1 = p1.B)
                j--;

            return p1;
        }
        P p;
        for(p = E; i > 0; p = p.A)
            i--;

        return p;
    }

    public int lastIndexOf(Object obj)
    {
        int i = D - 1;
        for(P p = C; p != null;)
        {
            if(p.C == obj || p.C != null && p.C.equals(obj))
                return i;
            p = p.B;
            i--;
        }

        return -1;
    }

    public Object set(int i, Object obj)
    {
        P p = A(i);
        Object obj1 = p.C;
        p.C = obj;
        return obj1;
    }

    public Object remove(int i)
    {
        return A(A(i));
    }

    public ListIterator listIterator(int i)
    {
        if(i == D)
        {
            _C _lc = new _C(this, i - 1, C);
            _lc.next();
            return _lc;
        } else
        {
            return new _C(this, i, A(i));
        }
    }

    public Object get(int i)
    {
        return A(i).C;
    }

    public void add(int i, Object obj)
    {
        if(i == D)
            E(obj);
        else
            B(obj, A(i));
    }

    public List subList(int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof List))
            return false;
        if(obj == this)
            return true;
        List list = (List)obj;
        if(list.size() != D)
            return false;
        P p = E;
        for(Iterator iterator1 = list.iterator(); iterator1.hasNext();)
        {
            Object obj1 = iterator1.next();
            if(p.C != obj1 && (obj1 == null || !obj1.equals(p.C)))
                return false;
            p = p.A;
        }

        return true;
    }

    public int hashCode()
    {
        int i = 1;
        for(P p = E; p != null; p = p.C())
        {
            Object obj = p.C;
            if(obj == null)
                i *= 31;
            else
                i = i * 31 + obj.hashCode();
        }

        return i;
    }

    int D;
    P E;
    P C;
    int F;

    static 
    {
        new M();
    }
}
