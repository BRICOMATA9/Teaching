// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.B;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.taglets.TagletWriter;
import java.util.*;

// Referenced classes of package ydoc.B:
//            D

class B
    implements D
{

    public B(String s, String s1, String s2, String s3, String s4, String s5)
        throws IllegalArgumentException
    {
        G = s1;
        if(!s1.equals("none") && !s1.equals("first-whitespace") && !s1.equals("whitespace") && s1.length() > 1)
        {
            String s6 = (new StringBuilder()).append("Invalid separator attribute: ").append(s1).append(". ").append("Valid attributes are: ").append("none").append(", ").append("first-whitespace").append(", ").append("whitespace").append(", or any single character.").toString();
            throw new IllegalArgumentException(s6);
        } else
        {
            E = s2;
            H = s4;
            D = s5;
            F = A(s, true);
            C = A(s3, true);
            return;
        }
    }

    public String A(Tag atag[], String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(A(s));
        stringbuffer.append(E);
        stringbuffer.append(C(atag[0].text()));
        for(int i = 1; i < atag.length; i++)
        {
            stringbuffer.append(D);
            stringbuffer.append(C(atag[i].text()));
        }

        stringbuffer.append(H);
        stringbuffer.append("\n");
        return stringbuffer.toString();
    }

    public String A(Tag atag[], String s, TagletWriter tagletwriter)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(A(s));
        stringbuffer.append(E);
        stringbuffer.append(C(tagletwriter.commentTagsToOutput(atag[0], atag[0].inlineTags()).toString()));
        for(int i = 1; i < atag.length; i++)
        {
            stringbuffer.append(D);
            stringbuffer.append(C(tagletwriter.commentTagsToOutput(atag[i], atag[i].inlineTags()).toString()));
        }

        stringbuffer.append(H);
        stringbuffer.append("\n");
        return stringbuffer.toString();
    }

    private int D(String s)
    {
        char ac[] = s.toCharArray();
        if(ac.length == 2 && ac[0] == '#')
            return Integer.parseInt(Character.toString(ac[1]));
        else
            return -1;
    }

    private String C(String s)
    {
        return A(B(s), C);
    }

    private String A(String s)
    {
        return A(new String[] {
            s
        }, F);
    }

    private String A(String as[], String as1[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < as1.length; i++)
        {
            int j = D(as1[i]);
            if(j > -1 && j < as.length)
                stringbuffer.append(as[j]);
            else
                stringbuffer.append(as1[i]);
        }

        return stringbuffer.toString();
    }

    private String[] B(String s)
    {
        StringTokenizer stringtokenizer = null;
        if(G.equals("none"))
            return (new String[] {
                s
            });
        if(G.equals("first-whitespace"))
        {
            stringtokenizer = new StringTokenizer(s);
            String as[] = {
                s
            };
            if(stringtokenizer.hasMoreTokens())
            {
                as = new String[1];
                as[0] = stringtokenizer.nextToken();
                if(stringtokenizer.hasMoreTokens())
                {
                    String s1 = as[0];
                    as = new String[2];
                    as[0] = s1;
                    as[1] = s.substring(s.indexOf(stringtokenizer.nextToken()));
                }
            }
            return as;
        }
        if(G.equals("whitespace"))
            stringtokenizer = new StringTokenizer(s);
        else
            stringtokenizer = new StringTokenizer(s, G);
        String as1[] = new String[stringtokenizer.countTokens()];
        for(int i = 0; stringtokenizer.hasMoreTokens(); i++)
            as1[i] = stringtokenizer.nextToken();

        return as1;
    }

    private String[] A(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        StringBuffer stringbuffer = new StringBuffer();
        char ac[] = s.toCharArray();
        for(int i = 0; i < ac.length; i++)
        {
            if(ac[i] != '#')
            {
                stringbuffer.append(ac[i]);
                continue;
            }
            if(i + 1 < ac.length && Character.isDigit(ac[i + 1]))
            {
                arraylist.add(stringbuffer.toString());
                stringbuffer = new StringBuffer();
                if(flag)
                {
                    stringbuffer.append(ac[i]).append(ac[i + 1]);
                    arraylist.add(stringbuffer.toString());
                    stringbuffer = new StringBuffer();
                }
                i++;
            } else
            {
                stringbuffer.append(ac[i]);
            }
        }

        arraylist.add(stringbuffer.toString());
        String as[] = new String[arraylist.size()];
        int j = 0;
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            as[j] = (String)iterator.next();
            j++;
        }

        return as;
    }

    private final String E;
    private final String H;
    private final String D;
    private final String G;
    private final String F[];
    private final String C[];
}
