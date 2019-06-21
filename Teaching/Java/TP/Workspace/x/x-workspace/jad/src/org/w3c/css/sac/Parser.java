// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;

import java.io.IOException;
import java.util.Locale;

// Referenced classes of package org.w3c.css.sac:
//            CSSException, DocumentHandler, SelectorFactory, ConditionFactory, 
//            ErrorHandler, InputSource, SelectorList, LexicalUnit

public interface Parser
{

    public abstract void setLocale(Locale locale)
        throws CSSException;

    public abstract void setDocumentHandler(DocumentHandler documenthandler);

    public abstract void setSelectorFactory(SelectorFactory selectorfactory);

    public abstract void setConditionFactory(ConditionFactory conditionfactory);

    public abstract void setErrorHandler(ErrorHandler errorhandler);

    public abstract void parseStyleSheet(InputSource inputsource)
        throws CSSException, IOException;

    public abstract void parseStyleSheet(String s)
        throws CSSException, IOException;

    public abstract void parseStyleDeclaration(InputSource inputsource)
        throws CSSException, IOException;

    public abstract void parseRule(InputSource inputsource)
        throws CSSException, IOException;

    public abstract String getParserVersion();

    public abstract SelectorList parseSelectors(InputSource inputsource)
        throws CSSException, IOException;

    public abstract LexicalUnit parsePropertyValue(InputSource inputsource)
        throws CSSException, IOException;

    public abstract boolean parsePriority(InputSource inputsource)
        throws CSSException, IOException;
}
