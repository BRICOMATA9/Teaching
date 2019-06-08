// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.gvt.TextNode;
import org.apache.batik.parser.UnitProcessor;
import org.apache.batik.util.CSSConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, UnitProcessor, SVGUtilities, BridgeException, 
//            CSSUtilities, BridgeContext

public abstract class TextUtilities
    implements CSSConstants, ErrorConstants
{

    public TextUtilities()
    {
    }

    public static String getElementContent(Element element)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            switch(node.getNodeType())
            {
            case 1: // '\001'
                stringbuffer.append(getElementContent((Element)node));
                break;

            case 3: // '\003'
            case 4: // '\004'
                stringbuffer.append(node.getNodeValue());
                break;
            }

        return stringbuffer.toString();
    }

    public static ArrayList svgHorizontalCoordinateArrayToUserSpace(Element element, String s, String s1, BridgeContext bridgecontext)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        ArrayList arraylist = new ArrayList();
        for(StringTokenizer stringtokenizer = new StringTokenizer(s1, ", ", false); stringtokenizer.hasMoreTokens(); arraylist.add(new Float(UnitProcessor.svgHorizontalCoordinateToUserSpace(stringtokenizer.nextToken(), s, context))));
        return arraylist;
    }

    public static ArrayList svgVerticalCoordinateArrayToUserSpace(Element element, String s, String s1, BridgeContext bridgecontext)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        ArrayList arraylist = new ArrayList();
        for(StringTokenizer stringtokenizer = new StringTokenizer(s1, ", ", false); stringtokenizer.hasMoreTokens(); arraylist.add(new Float(UnitProcessor.svgVerticalCoordinateToUserSpace(stringtokenizer.nextToken(), s, context))));
        return arraylist;
    }

    public static ArrayList svgRotateArrayToFloats(Element element, String s, String s1, BridgeContext bridgecontext)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s1, ", ", false);
        ArrayList arraylist = new ArrayList();
        while(stringtokenizer.hasMoreTokens()) 
            try
            {
                String s2 = stringtokenizer.nextToken();
                arraylist.add(new Float(Math.toRadians(SVGUtilities.convertSVGNumber(s2))));
            }
            catch(NumberFormatException numberformatexception)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    s, s1
                });
            }
        return arraylist;
    }

    public static Float convertFontSize(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 22);
        return new Float(value.getFloatValue());
    }

    public static Float convertFontStyle(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 25);
        switch(value.getStringValue().charAt(0))
        {
        case 110: // 'n'
            return TextAttribute.POSTURE_REGULAR;
        }
        return TextAttribute.POSTURE_OBLIQUE;
    }

    public static Float convertFontStretch(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 24);
        String s = value.getStringValue();
        switch(s.charAt(0))
        {
        case 117: // 'u'
            if(s.charAt(6) == 'c')
                return TextAttribute.WIDTH_CONDENSED;
            else
                return TextAttribute.WIDTH_EXTENDED;

        case 101: // 'e'
            if(s.charAt(6) == 'c')
                return TextAttribute.WIDTH_CONDENSED;
            if(s.length() == 8)
                return TextAttribute.WIDTH_SEMI_EXTENDED;
            else
                return TextAttribute.WIDTH_EXTENDED;

        case 115: // 's'
            if(s.charAt(6) == 'c')
                return TextAttribute.WIDTH_SEMI_CONDENSED;
            else
                return TextAttribute.WIDTH_SEMI_EXTENDED;
        }
        return TextAttribute.WIDTH_REGULAR;
    }

    public static Float convertFontWeight(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 27);
        float f = value.getFloatValue();
        switch((int)f)
        {
        case 100: // 'd'
            return TextAttribute.WEIGHT_EXTRA_LIGHT;

        case 200: 
            return TextAttribute.WEIGHT_LIGHT;

        case 300: 
            return TextAttribute.WEIGHT_DEMILIGHT;

        case 400: 
            return TextAttribute.WEIGHT_REGULAR;

        case 500: 
            return TextAttribute.WEIGHT_SEMIBOLD;
        }
        return TextAttribute.WEIGHT_BOLD;
    }

    public static org.apache.batik.gvt.TextNode.Anchor convertTextAnchor(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 53);
        switch(value.getStringValue().charAt(0))
        {
        case 115: // 's'
            return org.apache.batik.gvt.TextNode.Anchor.START;

        case 109: // 'm'
            return org.apache.batik.gvt.TextNode.Anchor.MIDDLE;
        }
        return org.apache.batik.gvt.TextNode.Anchor.END;
    }

    public static Object convertBaselineShift(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 1);
        if(value.getPrimitiveType() == 21)
        {
            String s = value.getStringValue();
            switch(s.charAt(2))
            {
            case 112: // 'p'
                return TextAttribute.SUPERSCRIPT_SUPER;

            case 98: // 'b'
                return TextAttribute.SUPERSCRIPT_SUB;
            }
            return null;
        } else
        {
            return new Float(value.getFloatValue());
        }
    }

    public static Float convertKerning(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 31);
        if(value.getPrimitiveType() == 21)
            return null;
        else
            return new Float(value.getFloatValue());
    }

    public static Float convertLetterSpacing(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 32);
        if(value.getPrimitiveType() == 21)
            return null;
        else
            return new Float(value.getFloatValue());
    }

    public static Float convertWordSpacing(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 58);
        if(value.getPrimitiveType() == 21)
            return null;
        else
            return new Float(value.getFloatValue());
    }
}
