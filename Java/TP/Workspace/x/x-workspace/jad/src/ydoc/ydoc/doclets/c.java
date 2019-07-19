// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            O, A

class c extends O
    implements ProgramElementDoc
{

    c(ProgramElementDoc programelementdoc)
    {
        super(programelementdoc);
    }

    private ProgramElementDoc F()
    {
        return (ProgramElementDoc)A();
    }

    public ClassDoc containingClass()
    {
        return A.A(F().containingClass());
    }

    public PackageDoc containingPackage()
    {
        return A.B(F().containingPackage());
    }

    public boolean isFinal()
    {
        return F().isFinal();
    }

    public boolean isPackagePrivate()
    {
        return F().isPackagePrivate();
    }

    public boolean isPrivate()
    {
        return F().isPrivate();
    }

    public boolean isProtected()
    {
        return F().isProtected();
    }

    public boolean isPublic()
    {
        return F().isPublic();
    }

    public boolean isStatic()
    {
        return F().isStatic();
    }

    public String modifiers()
    {
        return F().modifiers();
    }

    public int modifierSpecifier()
    {
        return F().modifierSpecifier();
    }

    public String qualifiedName()
    {
        return F().qualifiedName();
    }

    public AnnotationDesc[] annotations()
    {
        return F().annotations();
    }
}
