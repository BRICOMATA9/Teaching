// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.ParamTag;

// Referenced classes of package ydoc.doclets:
//            E

class Y extends E
    implements ParamTag
{

    Y(ParamTag paramtag)
    {
        super(paramtag);
    }

    private ParamTag B()
    {
        return (ParamTag)A();
    }

    public String parameterName()
    {
        return B().parameterName();
    }

    public String parameterComment()
    {
        return B().parameterComment();
    }

    public boolean isTypeParameter()
    {
        return B().isTypeParameter();
    }
}
