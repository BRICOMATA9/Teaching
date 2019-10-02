// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.util.StringTokenizer;

public class G
{

    public G()
    {
    }

    public int A(String s, String s1)
    {
        int ai[] = A(s);
        int ai1[] = A(s1);
        int i = Math.min(ai.length, ai1.length);
        int j = 0;
        for(int k = 0; j == 0 && k < i; k++)
            j = ai[k] - ai1[k];

        return j;
    }

    private int[] A(String s)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, "._");
        int ai[] = new int[stringtokenizer.countTokens()];
        for(int i = 0; i < ai.length; i++)
            try
            {
                ai[i] = Integer.parseInt(stringtokenizer.nextToken());
            }
            catch(NumberFormatException numberformatexception) { }

        return ai;
    }

    public static final boolean A;

    static 
    {
        G g = new G();
        String s = System.getProperty("java.version");
        A = g.A("1.4", s) <= 0;
    }
}
