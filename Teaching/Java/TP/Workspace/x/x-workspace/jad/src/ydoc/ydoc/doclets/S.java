// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            _, A

final class S extends _
    implements FieldDoc
{

    S(FieldDoc fielddoc)
    {
        super(fielddoc);
    }

    private FieldDoc J()
    {
        return (FieldDoc)A();
    }

    public Object constantValue()
    {
        return J().constantValue();
    }

    public String constantValueExpression()
    {
        return J().constantValueExpression();
    }

    public boolean isTransient()
    {
        return J().isTransient();
    }

    public boolean isVolatile()
    {
        return J().isVolatile();
    }

    public SerialFieldTag[] serialFieldTags()
    {
        return A.A(J().serialFieldTags());
    }

    public Type type()
    {
        return A.A(J().type());
    }
}
