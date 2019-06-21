// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.i18n;

import java.util.Locale;
import java.util.MissingResourceException;

public interface Localizable
{

    public abstract void setLocale(Locale locale);

    public abstract Locale getLocale();

    public abstract String formatMessage(String s, Object aobj[])
        throws MissingResourceException;
}
