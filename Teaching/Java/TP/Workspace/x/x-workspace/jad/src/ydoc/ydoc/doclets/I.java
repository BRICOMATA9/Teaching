// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            _, A

class I extends _
    implements ExecutableMemberDoc
{

    I(ExecutableMemberDoc executablememberdoc)
    {
        super(executablememberdoc);
    }

    private ExecutableMemberDoc K()
    {
        return (ExecutableMemberDoc)A();
    }

    public String flatSignature()
    {
        return K().flatSignature();
    }

    public boolean isNative()
    {
        return K().isNative();
    }

    public boolean isSynchronized()
    {
        return K().isSynchronized();
    }

    public Parameter[] parameters()
    {
        return A.A(K().parameters());
    }

    public ParamTag[] paramTags()
    {
        return A.A(K().paramTags());
    }

    public String signature()
    {
        return K().signature();
    }

    public ClassDoc[] thrownExceptions()
    {
        return A.A(K().thrownExceptions());
    }

    public ThrowsTag[] throwsTags()
    {
        return A.A(K().throwsTags());
    }

    public Type[] thrownExceptionTypes()
    {
        return A.A(K().thrownExceptionTypes());
    }

    public boolean isVarArgs()
    {
        return K().isVarArgs();
    }

    public ParamTag[] typeParamTags()
    {
        return A.A(K().typeParamTags());
    }

    public TypeVariable[] typeParameters()
    {
        return A.A(K().typeParameters());
    }
}
