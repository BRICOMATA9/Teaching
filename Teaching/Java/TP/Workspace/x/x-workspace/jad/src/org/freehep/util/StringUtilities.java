// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilities
{

    private StringUtilities()
    {
    }

    public static String replace(CharSequence charsequence, CharSequence charsequence1, String s)
    {
        return Pattern.compile(quote(charsequence.toString())).matcher(s).replaceAll(quoteReplacement(charsequence1.toString()));
    }

    private static String quote(String s)
    {
        int i = s.indexOf("\\E");
        if(i == -1)
            return "\\Q" + s + "\\E";
        StringBuffer stringbuffer = new StringBuffer(s.length() * 2);
        stringbuffer.append("\\Q");
        i = 0;
        int j = 0;
        while((i = s.indexOf("\\E", j)) != -1) 
        {
            stringbuffer.append(s.substring(j, i));
            j = i + 2;
            stringbuffer.append("\\E\\\\E\\Q");
        }
        stringbuffer.append(s.substring(j, s.length()));
        stringbuffer.append("\\E");
        return stringbuffer.toString();
    }

    private static String quoteReplacement(String s)
    {
        if(s.indexOf('\\') == -1 && s.indexOf('$') == -1)
            return s;
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '\\')
            {
                stringbuffer.append('\\');
                stringbuffer.append('\\');
                continue;
            }
            if(c == '$')
            {
                stringbuffer.append('\\');
                stringbuffer.append('$');
            } else
            {
                stringbuffer.append(c);
            }
        }

        return stringbuffer.toString();
    }
}
