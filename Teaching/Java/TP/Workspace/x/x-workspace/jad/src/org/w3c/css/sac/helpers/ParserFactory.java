// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac.helpers;

import org.w3c.css.sac.Parser;

public class ParserFactory
{

    public ParserFactory()
    {
    }

    public Parser makeParser()
        throws ClassNotFoundException, IllegalAccessException, InstantiationException, NullPointerException, ClassCastException
    {
        String s = System.getProperty("org.w3c.css.sac.parser");
        if(s == null)
            throw new NullPointerException("No value for sac.parser property");
        else
            return (Parser)Class.forName(s).newInstance();
    }
}
