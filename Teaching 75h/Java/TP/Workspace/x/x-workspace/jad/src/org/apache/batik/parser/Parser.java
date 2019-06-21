// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.Reader;
import org.apache.batik.i18n.Localizable;

// Referenced classes of package org.apache.batik.parser:
//            ParseException, ErrorHandler

public interface Parser
    extends Localizable
{

    public abstract void parse(Reader reader)
        throws ParseException;

    public abstract void parse(String s)
        throws ParseException;

    public abstract void setErrorHandler(ErrorHandler errorhandler);
}
