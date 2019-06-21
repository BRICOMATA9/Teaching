// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;

// Referenced classes of package ydoc.doclets:
//            d, A

final class W extends d
    implements ParameterizedType
{

    W(ParameterizedType parameterizedtype)
    {
        super(parameterizedtype);
    }

    private ParameterizedType B()
    {
        return (ParameterizedType)A();
    }

    public Type[] typeArguments()
    {
        return A.A(B().typeArguments());
    }

    public Type superclassType()
    {
        return A.A(B().superclassType());
    }

    public Type[] interfaceTypes()
    {
        return A.A(B().interfaceTypes());
    }

    public Type containingType()
    {
        return A.A(B().containingType());
    }
}
