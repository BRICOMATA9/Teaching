// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

// Referenced classes of package org.apache.batik.i18n:
//            Localizable, LocaleGroup

public class LocalizableSupport
    implements Localizable
{

    public LocalizableSupport(String s)
    {
        this(s, null);
    }

    public LocalizableSupport(String s, ClassLoader classloader)
    {
        localeGroup = LocaleGroup.DEFAULT;
        bundleName = s;
        classLoader = classloader;
    }

    public void setLocale(Locale locale1)
    {
        if(locale != locale1)
        {
            locale = locale1;
            resourceBundle = null;
        }
    }

    public Locale getLocale()
    {
        return locale;
    }

    public void setLocaleGroup(LocaleGroup localegroup)
    {
        localeGroup = localegroup;
    }

    public LocaleGroup getLocaleGroup()
    {
        return localeGroup;
    }

    public void setDefaultLocale(Locale locale1)
    {
        localeGroup.setLocale(locale1);
    }

    public Locale getDefaultLocale()
    {
        return localeGroup.getLocale();
    }

    public String formatMessage(String s, Object aobj[])
    {
        getResourceBundle();
        return MessageFormat.format(resourceBundle.getString(s), aobj);
    }

    public ResourceBundle getResourceBundle()
    {
        Locale locale2;
        if(resourceBundle == null)
        {
            Locale locale1;
            if(locale == null)
            {
                if((locale1 = localeGroup.getLocale()) == null)
                    usedLocale = Locale.getDefault();
                else
                    usedLocale = locale1;
            } else
            {
                usedLocale = locale;
            }
            if(classLoader == null)
                resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale);
            else
                resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale, classLoader);
        } else
        if(locale == null)
            if((locale2 = localeGroup.getLocale()) == null)
            {
                if(usedLocale != (locale2 = Locale.getDefault()))
                {
                    usedLocale = locale2;
                    if(classLoader == null)
                        resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale);
                    else
                        resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale, classLoader);
                }
            } else
            if(usedLocale != locale2)
            {
                usedLocale = locale2;
                if(classLoader == null)
                    resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale);
                else
                    resourceBundle = ResourceBundle.getBundle(bundleName, usedLocale, classLoader);
            }
        return resourceBundle;
    }

    protected LocaleGroup localeGroup;
    protected String bundleName;
    protected ClassLoader classLoader;
    protected Locale locale;
    protected Locale usedLocale;
    protected ResourceBundle resourceBundle;
}
