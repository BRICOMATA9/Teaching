// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            A

class d
    implements Type
{

    d(Type type)
    {
        A = type;
    }

    Type A()
    {
        return A;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof d)
            A.equals(((d)obj).A);
        return A.equals(obj);
    }

    public int hashCode()
    {
        return A.hashCode();
    }

    public String toString()
    {
        return A.toString();
    }

    public String typeName()
    {
        return A.typeName();
    }

    public String qualifiedTypeName()
    {
        return A.qualifiedTypeName();
    }

    public String simpleTypeName()
    {
        return A.simpleTypeName();
    }

    public String dimension()
    {
        return A.dimension();
    }

    public boolean isPrimitive()
    {
        return A.isPrimitive();
    }

    public ClassDoc asClassDoc()
    {
        return ydoc.doclets.A.A(A.asClassDoc());
    }

    public ParameterizedType asParameterizedType()
    {
        return ydoc.doclets.A.A(A.asParameterizedType());
    }

    public TypeVariable asTypeVariable()
    {
        return ydoc.doclets.A.A(A.asTypeVariable());
    }

    public WildcardType asWildcardType()
    {
        return ydoc.doclets.A.A(A.asWildcardType());
    }

    public AnnotationTypeDoc asAnnotationTypeDoc()
    {
        return ydoc.doclets.A.A(A.asAnnotationTypeDoc());
    }

    private Type A;
}
