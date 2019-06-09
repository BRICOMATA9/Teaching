// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.util.*;

public abstract class OptionParser
{

    public OptionParser()
    {
    }

    public static Map parseOptions(String s)
    {
        HashMap hashmap = new HashMap();
        if(s != null)
        {
            for(StringTokenizer stringtokenizer = new StringTokenizer(s, ",;"); stringtokenizer.hasMoreTokens();)
            {
                String s1 = stringtokenizer.nextToken().toLowerCase().trim();
                int i = s1.indexOf('=');
                if(i < 0)
                    hashmap.put(s1, "true");
                else
                    hashmap.put(s1.substring(0, i).trim(), s1.substring(i + 1).trim());
            }

        }
        return hashmap;
    }
}
