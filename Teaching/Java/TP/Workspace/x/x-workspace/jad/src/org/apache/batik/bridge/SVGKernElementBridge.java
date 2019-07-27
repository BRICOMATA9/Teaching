// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.*;
import org.apache.batik.gvt.font.Kern;
import org.apache.batik.gvt.font.UnicodeRange;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, SVGGVTFont, BridgeContext

public abstract class SVGKernElementBridge extends AbstractSVGBridge
{

    public SVGKernElementBridge()
    {
    }

    public Kern createKern(BridgeContext bridgecontext, Element element, SVGGVTFont svggvtfont)
    {
        String s = element.getAttributeNS(null, "u1");
        String s1 = element.getAttributeNS(null, "u2");
        String s2 = element.getAttributeNS(null, "g1");
        String s3 = element.getAttributeNS(null, "g2");
        String s4 = element.getAttributeNS(null, "k");
        if(s4.length() == 0)
            s4 = "0";
        float f = Float.parseFloat(s4);
        int i = 0;
        int j = 0;
        int ai[] = null;
        int ai1[] = null;
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens();)
        {
            String s5 = stringtokenizer.nextToken();
            if(s5.startsWith("U+"))
            {
                arraylist.add(new UnicodeRange(s5));
            } else
            {
                int ai3[] = svggvtfont.getGlyphCodesForUnicode(s5);
                if(ai == null)
                {
                    ai = ai3;
                    i = ai3.length;
                } else
                {
                    if(i + ai3.length > ai.length)
                    {
                        int k = ai.length * 2;
                        if(k < i + ai3.length)
                            k = i + ai3.length;
                        int ai8[] = new int[k];
                        for(int k2 = 0; k2 < i; k2++)
                            ai8[k2] = ai[k2];

                        ai = ai8;
                    }
                    int l = 0;
                    while(l < ai3.length) 
                    {
                        ai[i++] = ai3[l];
                        l++;
                    }
                }
            }
        }

        for(StringTokenizer stringtokenizer1 = new StringTokenizer(s1, ","); stringtokenizer1.hasMoreTokens();)
        {
            String s6 = stringtokenizer1.nextToken();
            if(s6.startsWith("U+"))
            {
                arraylist1.add(new UnicodeRange(s6));
            } else
            {
                int ai4[] = svggvtfont.getGlyphCodesForUnicode(s6);
                if(ai1 == null)
                {
                    ai1 = ai4;
                    j = ai4.length;
                } else
                {
                    if(j + ai4.length > ai1.length)
                    {
                        int i1 = ai1.length * 2;
                        if(i1 < j + ai4.length)
                            i1 = j + ai4.length;
                        int ai9[] = new int[i1];
                        for(int l2 = 0; l2 < j; l2++)
                            ai9[l2] = ai1[l2];

                        ai1 = ai9;
                    }
                    int j1 = 0;
                    while(j1 < ai4.length) 
                    {
                        ai1[j++] = ai4[j1];
                        j1++;
                    }
                }
            }
        }

        for(StringTokenizer stringtokenizer2 = new StringTokenizer(s2, ","); stringtokenizer2.hasMoreTokens();)
        {
            String s7 = stringtokenizer2.nextToken();
            int ai5[] = svggvtfont.getGlyphCodesForName(s7);
            if(ai == null)
            {
                ai = ai5;
                i = ai5.length;
            } else
            {
                if(i + ai5.length > ai.length)
                {
                    int k1 = ai.length * 2;
                    if(k1 < i + ai5.length)
                        k1 = i + ai5.length;
                    int ai10[] = new int[k1];
                    for(int i3 = 0; i3 < i; i3++)
                        ai10[i3] = ai[i3];

                    ai = ai10;
                }
                int l1 = 0;
                while(l1 < ai5.length) 
                {
                    ai[i++] = ai5[l1];
                    l1++;
                }
            }
        }

        for(StringTokenizer stringtokenizer3 = new StringTokenizer(s3, ","); stringtokenizer3.hasMoreTokens();)
        {
            String s8 = stringtokenizer3.nextToken();
            int ai6[] = svggvtfont.getGlyphCodesForName(s8);
            if(ai1 == null)
            {
                ai1 = ai6;
                j = ai6.length;
            } else
            {
                if(j + ai6.length > ai1.length)
                {
                    int i2 = ai1.length * 2;
                    if(i2 < j + ai6.length)
                        i2 = j + ai6.length;
                    int ai11[] = new int[i2];
                    for(int j3 = 0; j3 < j; j3++)
                        ai11[j3] = ai1[j3];

                    ai1 = ai11;
                }
                int j2 = 0;
                while(j2 < ai6.length) 
                {
                    ai1[j++] = ai6[j2];
                    j2++;
                }
            }
        }

        int ai2[];
        if(i == 0 || i == ai.length)
        {
            ai2 = ai;
        } else
        {
            ai2 = new int[i];
            System.arraycopy(ai, 0, ai2, 0, i);
        }
        int ai7[];
        if(j == 0 || j == ai1.length)
        {
            ai7 = ai1;
        } else
        {
            ai7 = new int[j];
            System.arraycopy(ai1, 0, ai7, 0, j);
        }
        UnicodeRange aunicoderange[] = new UnicodeRange[arraylist.size()];
        arraylist.toArray(aunicoderange);
        UnicodeRange aunicoderange1[] = new UnicodeRange[arraylist1.size()];
        arraylist1.toArray(aunicoderange1);
        return new Kern(ai2, ai7, aunicoderange, aunicoderange1, f);
    }
}
