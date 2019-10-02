// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            A

final class T
    implements Parameter
{

    T(Parameter parameter)
    {
        A = parameter;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof T)
            A.equals(((T)obj).A);
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

    public Type type()
    {
        return ydoc.doclets.A.A(A.type());
    }

    public String name()
    {
        return A.name();
    }

    public String typeName()
    {
        return A.typeName();
    }

    public AnnotationDesc[] annotations()
    {
        return ydoc.doclets.A.A(A.annotations());
    }

    private final Parameter A;
}
