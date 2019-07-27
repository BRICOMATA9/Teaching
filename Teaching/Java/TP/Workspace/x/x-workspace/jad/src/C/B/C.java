// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.B;

import java.util.EventObject;

// Referenced classes of package C.B:
//            A

public class C extends EventObject
{

    public C(A a, Throwable throwable)
    {
        this(a, (short)3, throwable);
    }

    public C(A a, short word0)
    {
        this(a, word0, null);
    }

    private C(A a, short word0, Throwable throwable)
    {
        super(a);
        B = word0;
        A = throwable;
    }

    private final short B;
    private final Throwable A;
}
