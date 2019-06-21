// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.LinkedList;
import java.util.List;
import org.apache.batik.css.engine.*;
import org.apache.batik.css.engine.value.*;
import org.apache.batik.gvt.font.GVTFontFamily;
import org.apache.batik.util.ParsedURL;
import org.apache.batik.util.SVGConstants;

// Referenced classes of package org.apache.batik.bridge:
//            FontFace, BridgeContext

public class CSSFontFace extends FontFace
    implements SVGConstants
{

    public CSSFontFace(List list, String s, float f, String s1, String s2, String s3, String s4, 
            float f1, String s5, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8, float f9)
    {
        super(list, s, f, s1, s2, s3, s4, f1, s5, f2, f3, f4, f5, f6, f7, f8, f9);
        fontFamily = null;
    }

    protected CSSFontFace(String s)
    {
        super(s);
        fontFamily = null;
    }

    public static CSSFontFace createCSSFontFace(CSSEngine cssengine, FontFaceRule fontfacerule)
    {
        StyleMap stylemap = fontfacerule.getStyleMap();
        String s = getStringProp(stylemap, cssengine, 21);
        CSSFontFace cssfontface = new CSSFontFace(s);
        Value value = stylemap.getValue(27);
        if(value != null)
            cssfontface.fontWeight = value.getCssText();
        value = stylemap.getValue(25);
        if(value != null)
            cssfontface.fontStyle = value.getCssText();
        value = stylemap.getValue(26);
        if(value != null)
            cssfontface.fontVariant = value.getCssText();
        value = stylemap.getValue(24);
        if(value != null)
            cssfontface.fontStretch = value.getCssText();
        value = stylemap.getValue(41);
        ParsedURL parsedurl = fontfacerule.getURL();
        if(value != null && value != ValueConstants.NONE_VALUE)
            if(value.getCssValueType() == 1)
            {
                cssfontface.srcs = new LinkedList();
                cssfontface.srcs.add(getSrcValue(value, parsedurl));
            } else
            if(value.getCssValueType() == 2)
            {
                cssfontface.srcs = new LinkedList();
                for(int i = 0; i < value.getLength(); i++)
                    cssfontface.srcs.add(getSrcValue(value.item(i), parsedurl));

            }
        return cssfontface;
    }

    public static Object getSrcValue(Value value, ParsedURL parsedurl)
    {
        if(value.getCssValueType() != 1)
            return null;
        if(value.getPrimitiveType() == 20)
            if(parsedurl != null)
                return new ParsedURL(parsedurl, value.getStringValue());
            else
                return new ParsedURL(value.getStringValue());
        if(value.getPrimitiveType() == 19)
            return value.getStringValue();
        else
            return null;
    }

    public static String getStringProp(StyleMap stylemap, CSSEngine cssengine, int i)
    {
        Value value = stylemap.getValue(i);
        ValueManager avaluemanager[] = cssengine.getValueManagers();
        if(value == null)
        {
            ValueManager valuemanager = avaluemanager[i];
            value = valuemanager.getDefaultValue();
        }
        for(; value.getCssValueType() == 2; value = value.item(0));
        return value.getStringValue();
    }

    public static float getFloatProp(StyleMap stylemap, CSSEngine cssengine, int i)
    {
        Value value = stylemap.getValue(i);
        ValueManager avaluemanager[] = cssengine.getValueManagers();
        if(value == null)
        {
            ValueManager valuemanager = avaluemanager[i];
            value = valuemanager.getDefaultValue();
        }
        for(; value.getCssValueType() == 2; value = value.item(0));
        return value.getFloatValue();
    }

    public GVTFontFamily getFontFamily(BridgeContext bridgecontext)
    {
        if(fontFamily != null)
        {
            return fontFamily;
        } else
        {
            fontFamily = super.getFontFamily(bridgecontext);
            return fontFamily;
        }
    }

    GVTFontFamily fontFamily;
}
