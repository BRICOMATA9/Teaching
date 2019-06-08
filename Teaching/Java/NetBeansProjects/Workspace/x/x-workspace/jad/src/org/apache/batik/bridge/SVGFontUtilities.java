// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.*;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.FontFaceRule;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.gvt.font.*;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, SVGFontFaceElementBridge, CSSFontFace, FontFace

public abstract class SVGFontUtilities
    implements SVGConstants
{

    public SVGFontUtilities()
    {
    }

    public static List getFontFaces(Document document, BridgeContext bridgecontext)
    {
        Map map = bridgecontext.getFontFamilyMap();
        Object obj = (List)map.get(document);
        if(obj != null)
            return ((List) (obj));
        obj = new LinkedList();
        NodeList nodelist = document.getElementsByTagNameNS("http://www.w3.org/2000/svg", "font-face");
        SVGFontFaceElementBridge svgfontfaceelementbridge = (SVGFontFaceElementBridge)bridgecontext.getBridge("http://www.w3.org/2000/svg", "font-face");
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Element element = (Element)nodelist.item(i);
            ((List) (obj)).add(svgfontfaceelementbridge.createFontFace(bridgecontext, element));
        }

        CSSEngine cssengine = ((SVGOMDocument)document).getCSSEngine();
        List list = cssengine.getFontFaces();
        FontFaceRule fontfacerule;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(CSSFontFace.createCSSFontFace(cssengine, fontfacerule)))
            fontfacerule = (FontFaceRule)iterator.next();

        return ((List) (obj));
    }

    public static GVTFontFamily getFontFamily(Element element, BridgeContext bridgecontext, String s, String s1, String s2)
    {
        String s3 = s.toLowerCase() + " " + s1 + " " + s2;
        Map map = bridgecontext.getFontFamilyMap();
        GVTFontFamily gvtfontfamily = (GVTFontFamily)map.get(s3);
        if(gvtfontfamily != null)
            return gvtfontfamily;
        Document document = element.getOwnerDocument();
        List list = (List)map.get(document);
        if(list == null)
        {
            list = getFontFaces(document, bridgecontext);
            map.put(document, list);
        }
        Iterator iterator = list.iterator();
        LinkedList linkedlist = new LinkedList();
        do
        {
            if(!iterator.hasNext())
                break;
            FontFace fontface = (FontFace)iterator.next();
            if(fontface.hasFamilyName(s))
            {
                String s5 = fontface.getFontStyle();
                if(s5.equals("all") || s5.indexOf(s2) != -1)
                {
                    GVTFontFamily gvtfontfamily1 = fontface.getFontFamily(bridgecontext);
                    if(gvtfontfamily1 != null)
                        linkedlist.add(gvtfontfamily1);
                }
            }
        } while(true);
        if(linkedlist.size() == 1)
        {
            map.put(s3, linkedlist.get(0));
            return (GVTFontFamily)linkedlist.get(0);
        }
        if(linkedlist.size() > 1)
        {
            String s4 = getFontWeightNumberString(s1);
            ArrayList arraylist = new ArrayList(linkedlist.size());
            String s6;
            for(Iterator iterator1 = linkedlist.iterator(); iterator1.hasNext(); arraylist.add(s6))
            {
                GVTFontFace gvtfontface = ((GVTFontFamily)iterator1.next()).getFontFace();
                s6 = gvtfontface.getFontWeight();
                s6 = getFontWeightNumberString(s6);
            }

            ArrayList arraylist1 = new ArrayList(arraylist);
            for(int i = 100; i <= 900; i += 100)
            {
                String s7 = String.valueOf(i);
                boolean flag = false;
                int k = 1000;
                int l = 0;
label0:
                for(int i1 = 0; i1 < arraylist.size(); i1++)
                {
                    String s10 = (String)arraylist.get(i1);
                    if(s10.indexOf(s7) > -1)
                    {
                        flag = true;
                        break;
                    }
                    StringTokenizer stringtokenizer = new StringTokenizer(s10, " ,");
                    do
                    {
                        if(!stringtokenizer.hasMoreTokens())
                            continue label0;
                        int j1 = Integer.parseInt(stringtokenizer.nextToken());
                        int k1 = Math.abs(j1 - i);
                        if(k1 < k)
                        {
                            k = k1;
                            l = i1;
                        }
                    } while(true);
                }

                if(!flag)
                {
                    String s9 = arraylist1.get(l) + ", " + s7;
                    arraylist1.set(l, s9);
                }
            }

            for(int j = 0; j < linkedlist.size(); j++)
            {
                String s8 = (String)arraylist1.get(j);
                if(s8.indexOf(s4) > -1)
                {
                    map.put(s3, linkedlist.get(j));
                    return (GVTFontFamily)linkedlist.get(j);
                }
            }

            map.put(s3, linkedlist.get(0));
            return (GVTFontFamily)linkedlist.get(0);
        } else
        {
            UnresolvedFontFamily unresolvedfontfamily = new UnresolvedFontFamily(s);
            map.put(s3, unresolvedfontfamily);
            return unresolvedfontfamily;
        }
    }

    protected static String getFontWeightNumberString(String s)
    {
        if(s.equals("normal"))
            return "400";
        if(s.equals("bold"))
            return "700";
        if(s.equals("all"))
            return "100, 200, 300, 400, 500, 600, 700, 800, 900";
        else
            return s;
    }
}
