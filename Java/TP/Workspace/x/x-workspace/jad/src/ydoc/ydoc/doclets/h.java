// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            O, A

final class h extends O
    implements PackageDoc
{

    h(PackageDoc packagedoc)
    {
        super(packagedoc);
    }

    private PackageDoc E()
    {
        return (PackageDoc)A();
    }

    public ClassDoc[] allClasses()
    {
        return allClasses(true);
    }

    public ClassDoc[] allClasses(boolean flag)
    {
        return A.A(E().allClasses());
    }

    public ClassDoc[] errors()
    {
        return A.A(E().errors());
    }

    public ClassDoc[] exceptions()
    {
        return A.A(E().exceptions());
    }

    public ClassDoc findClass(String s)
    {
        return A.B(E().findClass(s));
    }

    public ClassDoc[] interfaces()
    {
        return A.A(E().interfaces());
    }

    public ClassDoc[] ordinaryClasses()
    {
        return A.A(E().ordinaryClasses());
    }

    public ClassDoc[] enums()
    {
        return A.A(E().enums());
    }

    public AnnotationTypeDoc[] annotationTypes()
    {
        return A.A(E().annotationTypes());
    }

    public AnnotationDesc[] annotations()
    {
        return E().annotations();
    }
}
