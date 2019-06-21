// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik;


public final class Version
{

    public Version()
    {
    }

    public static String getVersion()
    {
        String s = "$Name: batik-1_6 $";
        if(s.startsWith("$Name:"))
            s = s.substring(6, s.length() - 1);
        else
            s = "";
        if(s.trim().intern().equals(""))
            s = "development.build";
        return s;
    }

    public static final String LABEL_DEVELOPMENT_BUILD = "development.build";
}
