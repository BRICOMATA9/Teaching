// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.Locale;
import java.util.MissingResourceException;
import org.apache.batik.i18n.LocalizableSupport;

public class Messages
{

    protected Messages()
    {
    }

    public static void setLocale(Locale locale)
    {
        localizableSupport.setLocale(locale);
    }

    public static Locale getLocale()
    {
        return localizableSupport.getLocale();
    }

    public static String formatMessage(String s, Object aobj[])
        throws MissingResourceException
    {
        return localizableSupport.formatMessage(s, aobj);
    }

    public static String getMessage(String s)
        throws MissingResourceException
    {
        return formatMessage(s, null);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    protected static final String RESOURCES = "org.apache.batik.bridge.resources.Messages";
    protected static LocalizableSupport localizableSupport;

    static 
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.bridge.resources.Messages", (org.apache.batik.bridge.Messages.class).getClassLoader());
    }
}
