// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.util.Comparator;

public class VersionComparator
    implements Comparator
{

    public VersionComparator()
    {
    }

    public int versionNumberCompare(String s, String s1)
        throws NumberFormatException
    {
        String as[] = replaceSpecials(s).split(pattern);
        String as1[] = replaceSpecials(s1).split(pattern);
        int i = Math.max(as.length, as1.length);
        for(int j = 0; j < i; j++)
        {
            int k = j >= as.length ? 0 : Integer.parseInt(as[j]);
            int l = j >= as1.length ? 0 : Integer.parseInt(as1[j]);
            if(k != l)
                return k - l;
        }

        return 0;
    }

    private String replaceSpecials(String s)
    {
        for(int i = 0; i < special.length; i++)
        {
            int j = -special.length + i;
            s = s.replaceAll(special[i], "." + j + ".");
        }

        return s;
    }

    public int compare(Object obj, Object obj1)
    {
        return versionNumberCompare(obj.toString(), obj1.toString());
    }

    private static String special[] = {
        "alpha", "beta", "rc"
    };
    private static String pattern = "\\.+";

}
