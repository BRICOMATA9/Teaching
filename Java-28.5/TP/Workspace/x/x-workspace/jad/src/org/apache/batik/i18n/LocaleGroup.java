// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.i18n;

import java.util.Locale;

public class LocaleGroup
{

    public LocaleGroup()
    {
    }

    public void setLocale(Locale locale1)
    {
        locale = locale1;
    }

    public Locale getLocale()
    {
        return locale;
    }

    public static final LocaleGroup DEFAULT = new LocaleGroup();
    protected Locale locale;

}
