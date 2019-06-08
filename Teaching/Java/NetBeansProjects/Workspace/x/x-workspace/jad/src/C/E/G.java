// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.I;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class G
{
    private static final class _A
        implements Iterator
    {

        public boolean hasNext()
        {
            return A.C();
        }

        public Object next()
        {
            if(!A.C())
            {
                throw new NoSuchElementException();
            } else
            {
                Object obj = A.D();
                A.B();
                return obj;
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Removal not supported in Cursors!");
        }

        private I A;

        public _A(I i)
        {
            A = i;
        }
    }


    public static Iterator A(I i)
    {
        return new _A(i);
    }
}
