// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;

public class XMLResourceDescriptor
{

    public XMLResourceDescriptor()
    {
    }

    protected static synchronized Properties getParserProps()
    {
        if(parserProps != null)
            return parserProps;
        parserProps = new Properties();
        try
        {
            Class class1 = org.apache.batik.util.XMLResourceDescriptor.class;
            java.io.InputStream inputstream = class1.getResourceAsStream("resources/XMLResourceDescriptor.properties");
            parserProps.load(inputstream);
        }
        catch(IOException ioexception)
        {
            throw new MissingResourceException(ioexception.getMessage(), "resources/XMLResourceDescriptor.properties", null);
        }
        return parserProps;
    }

    public static String getXMLParserClassName()
    {
        if(xmlParserClassName == null)
            xmlParserClassName = getParserProps().getProperty("org.xml.sax.driver");
        return xmlParserClassName;
    }

    public static void setXMLParserClassName(String s)
    {
        xmlParserClassName = s;
    }

    public static String getCSSParserClassName()
    {
        if(cssParserClassName == null)
            cssParserClassName = getParserProps().getProperty("org.w3c.css.sac.driver");
        return cssParserClassName;
    }

    public static void setCSSParserClassName(String s)
    {
        cssParserClassName = s;
    }

    public static final String XML_PARSER_CLASS_NAME_KEY = "org.xml.sax.driver";
    public static final String CSS_PARSER_CLASS_NAME_KEY = "org.w3c.css.sac.driver";
    public static final String RESOURCES = "resources/XMLResourceDescriptor.properties";
    protected static Properties parserProps = null;
    protected static String xmlParserClassName;
    protected static String cssParserClassName;

}
