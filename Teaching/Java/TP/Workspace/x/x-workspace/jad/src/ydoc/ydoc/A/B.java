// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageWriter;

public final class B
{
    private static final class _B
        implements _A
    {

        public void A()
        {
            if(null != A)
            {
                A.dispose();
                A = null;
            }
        }

        private ImageWriter A;

        public _B(ImageWriter imagewriter)
        {
            A = imagewriter;
        }
    }

    public static interface _A
    {

        public abstract void A();
    }


    private B()
    {
        B = null;
    }

    public void A(ImageWriter imagewriter)
    {
        if(null == B)
            B = new ArrayList(1);
        B.add(new _B(imagewriter));
    }

    public void A()
    {
        if(null != B)
        {
            int i = 0;
            for(int j = B.size(); i < j; i++)
                ((_A)B.get(i)).A();

            B.clear();
            B = null;
        }
    }

    protected void finalize()
        throws Throwable
    {
        A();
        super.finalize();
        break MISSING_BLOCK_LABEL_18;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public static B B()
    {
        if(null == A)
            A = new B();
        return A;
    }

    private static B A;
    private List B;
}
