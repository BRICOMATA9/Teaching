// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.ConstructorDoc;

// Referenced classes of package ydoc.doclets:
//            I

final class R extends I
    implements ConstructorDoc
{

    R(ConstructorDoc constructordoc)
    {
        super(constructordoc);
    }

    private ConstructorDoc L()
    {
        return (ConstructorDoc)A();
    }

    public String qualifiedName()
    {
        return L().qualifiedName();
    }
}
