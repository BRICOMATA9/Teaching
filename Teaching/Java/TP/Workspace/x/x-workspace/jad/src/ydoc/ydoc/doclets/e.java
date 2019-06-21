// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            E, A

class e extends E
    implements ThrowsTag
{

    public e(ThrowsTag throwstag)
    {
        super(throwstag);
    }

    private ThrowsTag D()
    {
        return (ThrowsTag)A();
    }

    public String exceptionName()
    {
        return D().exceptionName();
    }

    public String exceptionComment()
    {
        return D().exceptionComment();
    }

    public ClassDoc exception()
    {
        return A.B(D().exception());
    }

    public Type exceptionType()
    {
        return A.A(D().exceptionType());
    }
}
