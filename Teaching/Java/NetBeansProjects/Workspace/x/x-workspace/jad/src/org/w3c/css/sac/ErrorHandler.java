// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            CSSException, CSSParseException

public interface ErrorHandler
{

    public abstract void warning(CSSParseException cssparseexception)
        throws CSSException;

    public abstract void error(CSSParseException cssparseexception)
        throws CSSException;

    public abstract void fatalError(CSSParseException cssparseexception)
        throws CSSException;
}
