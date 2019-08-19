// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            CSSException, Locator

public class CSSParseException extends CSSException
{

    public CSSParseException(String s, Locator locator)
    {
        super(s);
        code = SAC_SYNTAX_ERR;
        uri = locator.getURI();
        lineNumber = locator.getLineNumber();
        columnNumber = locator.getColumnNumber();
    }

    public CSSParseException(String s, Locator locator, Exception exception)
    {
        super(SAC_SYNTAX_ERR, s, exception);
        uri = locator.getURI();
        lineNumber = locator.getLineNumber();
        columnNumber = locator.getColumnNumber();
    }

    public CSSParseException(String s, String s1, int i, int j)
    {
        super(s);
        code = SAC_SYNTAX_ERR;
        uri = s1;
        lineNumber = i;
        columnNumber = j;
    }

    public CSSParseException(String s, String s1, int i, int j, Exception exception)
    {
        super(SAC_SYNTAX_ERR, s, exception);
        uri = s1;
        lineNumber = i;
        columnNumber = j;
    }

    public String getURI()
    {
        return uri;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }

    public int getColumnNumber()
    {
        return columnNumber;
    }

    private String uri;
    private int lineNumber;
    private int columnNumber;
}
