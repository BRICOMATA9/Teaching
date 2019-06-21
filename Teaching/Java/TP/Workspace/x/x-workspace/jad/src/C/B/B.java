// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.B;

import java.util.ArrayList;

// Referenced classes of package C.B:
//            C, E, A

public class B
{

    public B(A a)
    {
        if(a == null)
        {
            throw new NullPointerException();
        } else
        {
            B = a;
            return;
        }
    }

    public void A()
    {
        if(E())
            A(new C(B, (short)0));
    }

    public void C()
    {
        if(E())
            A(new C(B, (short)4));
    }

    public void D()
    {
        if(E())
            A(new C(B, (short)1));
    }

    public void B()
    {
        if(E())
            A(new C(B, (short)2));
    }

    public void A(Throwable throwable)
    {
        if(E())
            A(new C(B, throwable));
    }

    public boolean E()
    {
        return A != null && A.size() > 0;
    }

    public void A(C c)
    {
label0:
        {
            synchronized(this)
            {
                if(A != null)
                    break label0;
            }
            return;
        }
        ArrayList arraylist = (ArrayList)A.clone();
        b;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        for(int i = 0; i < arraylist.size(); i++)
            ((E)arraylist.get(i)).A(c);

        return;
    }

    private A B;
    private transient ArrayList A;
}
