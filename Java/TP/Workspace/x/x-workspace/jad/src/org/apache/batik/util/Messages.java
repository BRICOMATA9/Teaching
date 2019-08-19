// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.util.Locale;
import java.util.MissingResourceException;
import org.apache.batik.i18n.LocalizableSupport;
import org.apache.batik.util.gui.resource.ResourceManager;

public class Messages
{

    protected Messages()
    {
    }

    public static void setLocale(Locale locale)
    {
        localizableSupport.setLocale(locale);
        resourceManager = new ResourceManager(localizableSupport.getResourceBundle());
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

    public static String getString(String s)
        throws MissingResourceException
    {
        return resourceManager.getString(s);
    }

    public static int getInteger(String s)
        throws MissingResourceException
    {
        return resourceManager.getInteger(s);
    }

    public static int getCharacter(String s)
        throws MissingResourceException
    {
        return resourceManager.getCharacter(s);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    protected static final String RESOURCES = "org.apache.batik.util.resources.Messages";
    protected static LocalizableSupport localizableSupport;
    protected static ResourceManager resourceManager;

    static 
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.util.resources.Messages", (org.apache.batik.util.Messages.class).getClassLoader());
        resourceManager = new ResourceManager(localizableSupport.getResourceBundle());
    }
}
