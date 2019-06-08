// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import ydoc.A.A;
import ydoc.A.D;
import ydoc.filters.B;

// Referenced classes of package ydoc.doclets:
//            E, A

class f extends E
    implements SeeTag
{

    f(SeeTag seetag)
    {
        super(seetag);
        String s = "";
        if(seetag.referencedMember() != null)
        {
            B = ydoc.filters.B.A(seetag.referencedMember());
            if(!B)
                s = seetag.referencedMember().toString();
        } else
        if(seetag.referencedClass() != null)
        {
            B = ydoc.filters.B.A(seetag.referencedClass());
            if(!B)
                s = seetag.referencedClass().qualifiedTypeName();
        } else
        if(seetag.referencedPackage() != null)
        {
            B = ydoc.filters.B.A(seetag.referencedPackage());
            if(!B)
            {
                s = seetag.referencedPackage().name();
                if(s == null || s.trim().length() == 0)
                    s = "<unnamed package>";
            }
        } else
        {
            B = true;
        }
        C = s;
    }

    private SeeTag E()
    {
        return (SeeTag)A();
    }

    public String label()
    {
        return E().label();
    }

    public PackageDoc referencedPackage()
    {
        if(B)
            return ydoc.doclets.A.A(E().referencedPackage());
        else
            return null;
    }

    public String referencedClassName()
    {
        if(B)
            return E().referencedClassName();
        else
            return null;
    }

    public ClassDoc referencedClass()
    {
        if(B)
            return ydoc.doclets.A.B(E().referencedClass());
        else
            return null;
    }

    public String referencedMemberName()
    {
        if(B)
            return E().referencedMemberName();
        else
            return null;
    }

    public MemberDoc referencedMember()
    {
        if(B)
            return ydoc.doclets.A.A(E().referencedMember());
        else
            return null;
    }

    public String text()
    {
        if(B)
            return super.text();
        if(A.B().A("misc.warnings", false))
        {
            String s = (new StringBuilder()).append("Tag ").append(name()).append(" references filtered element ").append(C).append(".").toString();
            D.C(s);
        }
        return "@linkplain".equalsIgnoreCase(name()) ? (new StringBuilder()).append("<span>").append(C).append("</span>").toString() : (new StringBuilder()).append("<code>").append(C).append("</code>").toString();
    }

    private final boolean B;
    private final String C;
}
