// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.MemberDoc;

// Referenced classes of package ydoc.doclets:
//            c

class _ extends c
    implements MemberDoc
{

    _(MemberDoc memberdoc)
    {
        super(memberdoc);
    }

    private MemberDoc I()
    {
        return (MemberDoc)A();
    }

    public boolean isSynthetic()
    {
        return I().isSynthetic();
    }
}
