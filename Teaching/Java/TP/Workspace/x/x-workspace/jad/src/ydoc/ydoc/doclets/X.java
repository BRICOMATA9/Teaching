// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            d, A

final class X extends d
    implements TypeVariable
{

    X(TypeVariable typevariable)
    {
        super(typevariable);
    }

    private TypeVariable C()
    {
        return (TypeVariable)A();
    }

    public Type[] bounds()
    {
        return A.A(C().bounds());
    }

    public ProgramElementDoc owner()
    {
        return A.A(C().owner());
    }
}
