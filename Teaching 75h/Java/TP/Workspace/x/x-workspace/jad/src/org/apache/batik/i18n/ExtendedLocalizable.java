// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

// Referenced classes of package org.apache.batik.i18n:
//            Localizable, LocaleGroup

public interface ExtendedLocalizable
    extends Localizable
{

    public abstract void setLocaleGroup(LocaleGroup localegroup);

    public abstract LocaleGroup getLocaleGroup();

    public abstract void setDefaultLocale(Locale locale);

    public abstract Locale getDefaultLocale();

    public abstract ResourceBundle getResourceBundle();
}
