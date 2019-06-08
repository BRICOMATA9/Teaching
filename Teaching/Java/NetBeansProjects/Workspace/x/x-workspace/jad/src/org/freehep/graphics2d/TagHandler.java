// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.io.PrintStream;

// Referenced classes of package org.freehep.graphics2d:
//            TagString

public class TagHandler
{

    public TagHandler()
    {
    }

    public String parse(TagString tagstring)
    {
        String s = tagstring.toString();
        StringBuffer stringbuffer = new StringBuffer();
        StringBuffer stringbuffer1 = new StringBuffer();
        int i = 0;
        boolean flag = false;
        try
        {
            for(; i < s.length(); i++)
                switch(s.charAt(i))
                {
                case 38: // '&'
                    int j = ++i;
                    for(; s.charAt(i) != ';'; i++);
                    String s1 = s.substring(j, i);
                    if(s1.equals("amp") || s1.equals("gt") || s1.equals("lt") || s1.equals("quot") || s1.equals("apos"))
                        stringbuffer1.append(defaultEntity(s1));
                    else
                        stringbuffer1.append(entity(s1));
                    break;

                case 60: // '<'
                    if(stringbuffer1.length() > 0)
                    {
                        stringbuffer.append(text(stringbuffer1.toString()));
                        stringbuffer1 = new StringBuffer();
                    }
                    int k = ++i;
                    for(; s.charAt(i) != '>'; i++);
                    if(s.charAt(k) == '/')
                        stringbuffer.append(closeTag(s.substring(k + 1, i)));
                    else
                        stringbuffer.append(openTag(s.substring(k, i)));
                    break;

                default:
                    stringbuffer1.append(s.charAt(i));
                    break;
                }

        }
        catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            stringbuffer.append("!PARSEERROR!");
        }
        if(stringbuffer1.length() > 0)
            stringbuffer.append(text(stringbuffer1.toString()));
        return stringbuffer.toString();
    }

    protected String defaultEntity(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if(s.equals("amp"))
            stringbuffer.append('&');
        else
        if(s.equals("gt"))
            stringbuffer.append('>');
        else
        if(s.equals("lt"))
            stringbuffer.append('<');
        else
        if(s.equals("quot"))
            stringbuffer.append('"');
        else
        if(s.equals("apos"))
            stringbuffer.append('\'');
        return stringbuffer.toString();
    }

    protected String entity(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('&');
        stringbuffer.append(s);
        stringbuffer.append(';');
        return stringbuffer.toString();
    }

    protected String openTag(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('<');
        stringbuffer.append(s);
        stringbuffer.append('>');
        return stringbuffer.toString();
    }

    protected String closeTag(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("</");
        stringbuffer.append(s);
        stringbuffer.append('>');
        return stringbuffer.toString();
    }

    protected String text(String s)
    {
        return s;
    }

    public static void main(String args[])
    {
        String s = "&lt;Vector<sup><b>Graphics</b></sup> &amp; Card<i><sub>Adapter</sub></i>&gt;";
        TagString tagstring = new TagString(s);
        TagHandler taghandler = new TagHandler();
        System.out.println("\"" + tagstring + "\"");
        System.out.println(taghandler.parse(tagstring));
    }
}
