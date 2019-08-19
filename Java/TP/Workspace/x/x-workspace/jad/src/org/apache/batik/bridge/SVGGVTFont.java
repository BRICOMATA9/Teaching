// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.font.FontRenderContext;
import java.text.*;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.util.XMLSupport;
import org.apache.batik.gvt.font.*;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.gvt.text.TextPaintInfo;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            CSSUtilities, BridgeContext, SVGHKernElementBridge, SVGVKernElementBridge, 
//            SVGGlyphElementBridge

public final class SVGGVTFont
    implements GVTFont, SVGConstants
{

    public SVGGVTFont(float f, GVTFontFace gvtfontface, String as[], String as1[], String as2[], String as3[], String as4[], 
            BridgeContext bridgecontext, Element aelement[], Element element, Element aelement1[], Element aelement2[], Element element1)
    {
        lineMetrics = null;
        fontFace = gvtfontface;
        fontSize = f;
        glyphUnicodes = as;
        glyphNames = as1;
        glyphLangs = as2;
        glyphOrientations = as3;
        glyphForms = as4;
        ctx = bridgecontext;
        glyphElements = aelement;
        missingGlyphElement = element;
        hkernElements = aelement1;
        vkernElements = aelement2;
        scale = f / gvtfontface.getUnitsPerEm();
        textElement = element1;
        language = XMLSupport.getXMLLang(element1);
        Value value = CSSUtilities.getComputedStyle(element1, 59);
        if(value.getStringValue().startsWith("tb"))
            orientation = "v";
        else
            orientation = "h";
        createKerningTables();
    }

    private void createKerningTables()
    {
        Kern akern[] = new Kern[hkernElements.length];
        for(int i = 0; i < hkernElements.length; i++)
        {
            Element element = hkernElements[i];
            SVGHKernElementBridge svghkernelementbridge = (SVGHKernElementBridge)ctx.getBridge(element);
            Kern kern = svghkernelementbridge.createKern(ctx, element, this);
            akern[i] = kern;
        }

        hKerningTable = new KerningTable(akern);
        Kern akern1[] = new Kern[vkernElements.length];
        for(int j = 0; j < vkernElements.length; j++)
        {
            Element element1 = vkernElements[j];
            SVGVKernElementBridge svgvkernelementbridge = (SVGVKernElementBridge)ctx.getBridge(element1);
            Kern kern1 = svgvkernelementbridge.createKern(ctx, element1, this);
            akern1[j] = kern1;
        }

        vKerningTable = new KerningTable(akern1);
    }

    public float getHKern(int i, int j)
    {
        if(i < 0 || i >= glyphUnicodes.length || j < 0 || j >= glyphUnicodes.length)
        {
            return 0.0F;
        } else
        {
            float f = hKerningTable.getKerningValue(i, j, glyphUnicodes[i], glyphUnicodes[j]);
            return f * scale;
        }
    }

    public float getVKern(int i, int j)
    {
        if(i < 0 || i >= glyphUnicodes.length || j < 0 || j >= glyphUnicodes.length)
        {
            return 0.0F;
        } else
        {
            float f = vKerningTable.getKerningValue(i, j, glyphUnicodes[i], glyphUnicodes[j]);
            return f * scale;
        }
    }

    public int[] getGlyphCodesForName(String s)
    {
        Vector vector = new Vector();
        for(int i = 0; i < glyphNames.length; i++)
            if(glyphNames[i] != null && glyphNames[i].equals(s))
                vector.add(new Integer(i));

        int ai[] = new int[vector.size()];
        for(int j = 0; j < vector.size(); j++)
            ai[j] = ((Integer)vector.elementAt(j)).intValue();

        return ai;
    }

    public int[] getGlyphCodesForUnicode(String s)
    {
        Vector vector = new Vector();
        for(int i = 0; i < glyphUnicodes.length; i++)
            if(glyphUnicodes[i] != null && glyphUnicodes[i].equals(s))
                vector.add(new Integer(i));

        int ai[] = new int[vector.size()];
        for(int j = 0; j < vector.size(); j++)
            ai[j] = ((Integer)vector.elementAt(j)).intValue();

        return ai;
    }

    private boolean languageMatches(String s)
    {
        if(s == null || s.length() == 0)
            return true;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens();)
        {
            String s1 = stringtokenizer.nextToken();
            if(s1.equals(language) || s1.startsWith(language) && s1.length() > language.length() && s1.charAt(language.length()) == '-')
                return true;
        }

        return false;
    }

    private boolean orientationMatches(String s)
    {
        if(s == null || s.length() == 0)
            return true;
        else
            return s.equals(orientation);
    }

    private boolean formMatches(String s, String s1, AttributedCharacterIterator attributedcharacteriterator, int i)
    {
        if(attributedcharacteriterator == null || s1 == null || s1.length() == 0)
            return true;
        char c = attributedcharacteriterator.setIndex(i);
        Integer integer = (Integer)attributedcharacteriterator.getAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_FORM);
        if(integer == null || integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_NONE))
            return false;
        if(s.length() > 1)
        {
            boolean flag = true;
            int j = 1;
            do
            {
                if(j >= s.length())
                    break;
                char c1 = attributedcharacteriterator.next();
                if(s.charAt(j) != c1)
                {
                    flag = false;
                    break;
                }
                j++;
            } while(true);
            attributedcharacteriterator.setIndex(i);
            if(flag)
            {
                attributedcharacteriterator.setIndex((i + s.length()) - 1);
                Integer integer1 = (Integer)attributedcharacteriterator.getAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_FORM);
                attributedcharacteriterator.setIndex(i);
                if(integer != null && integer1 != null)
                {
                    if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_TERMINAL) && integer1.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_INITIAL))
                        return s1.equals("isolated");
                    if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_TERMINAL))
                        return s1.equals("terminal");
                    if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_MEDIAL) && integer1.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_MEDIAL))
                        return s1.equals("medial");
                }
            }
        }
        if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_ISOLATED))
            return s1.equals("isolated");
        if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_TERMINAL))
            return s1.equals("terminal");
        if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_INITIAL))
            return s1.equals("initial");
        if(integer.equals(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ARABIC_MEDIAL))
            return s1.equals("medial");
        else
            return false;
    }

    public boolean canDisplayGivenName(String s)
    {
        for(int i = 0; i < glyphNames.length; i++)
            if(glyphNames[i] != null && glyphNames[i].equals(s) && languageMatches(glyphLangs[i]) && orientationMatches(glyphOrientations[i]))
                return true;

        return false;
    }

    public boolean canDisplay(char c)
    {
        for(int i = 0; i < glyphUnicodes.length; i++)
            if(glyphUnicodes[i].indexOf(c) != -1 && languageMatches(glyphLangs[i]) && orientationMatches(glyphOrientations[i]))
                return true;

        return false;
    }

    public int canDisplayUpTo(char ac[], int i, int j)
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(new String(ac));
        return canDisplayUpTo(((CharacterIterator) (stringcharacteriterator)), i, j);
    }

    public int canDisplayUpTo(CharacterIterator characteriterator, int i, int j)
    {
        AttributedCharacterIterator attributedcharacteriterator = null;
        if(characteriterator instanceof AttributedCharacterIterator)
            attributedcharacteriterator = (AttributedCharacterIterator)characteriterator;
        char c = characteriterator.setIndex(i);
        for(int k = i; c != '\uFFFF' && k < j; k = characteriterator.getIndex())
        {
            boolean flag = false;
            for(int l = 0; l < glyphUnicodes.length; l++)
            {
                if(glyphUnicodes[l].indexOf(c) != 0 || !languageMatches(glyphLangs[l]) || !orientationMatches(glyphOrientations[l]) || !formMatches(glyphUnicodes[l], glyphForms[l], attributedcharacteriterator, k))
                    continue;
                if(glyphUnicodes[l].length() == 1)
                {
                    flag = true;
                    break;
                }
                boolean flag1 = true;
                int i1 = 1;
                do
                {
                    if(i1 >= glyphUnicodes[l].length())
                        break;
                    c = characteriterator.next();
                    if(glyphUnicodes[l].charAt(i1) != c)
                    {
                        flag1 = false;
                        break;
                    }
                    i1++;
                } while(true);
                if(flag1)
                {
                    flag = true;
                    break;
                }
                c = characteriterator.setIndex(k);
            }

            if(!flag)
                return k;
            c = characteriterator.next();
        }

        return -1;
    }

    public int canDisplayUpTo(String s)
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        return canDisplayUpTo(((CharacterIterator) (stringcharacteriterator)), 0, s.length());
    }

    public GVTGlyphVector createGlyphVector(FontRenderContext fontrendercontext, char ac[])
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(new String(ac));
        return createGlyphVector(fontrendercontext, ((CharacterIterator) (stringcharacteriterator)));
    }

    public GVTGlyphVector createGlyphVector(FontRenderContext fontrendercontext, CharacterIterator characteriterator)
    {
        AttributedCharacterIterator attributedcharacteriterator = null;
        if(characteriterator instanceof AttributedCharacterIterator)
            attributedcharacteriterator = (AttributedCharacterIterator)characteriterator;
        Vector vector = new Vector();
        for(char c = characteriterator.first(); c != '\uFFFF'; c = characteriterator.next())
        {
            boolean flag = false;
            for(int j = 0; j < glyphUnicodes.length; j++)
            {
                if(glyphUnicodes[j].indexOf(c) != 0 || !languageMatches(glyphLangs[j]) || !orientationMatches(glyphOrientations[j]) || !formMatches(glyphUnicodes[j], glyphForms[j], attributedcharacteriterator, characteriterator.getIndex()))
                    continue;
                if(glyphUnicodes[j].length() == 1)
                {
                    Element element = glyphElements[j];
                    SVGGlyphElementBridge svgglyphelementbridge1 = (SVGGlyphElementBridge)ctx.getBridge(element);
                    TextPaintInfo textpaintinfo1 = null;
                    if(attributedcharacteriterator != null)
                        textpaintinfo1 = (TextPaintInfo)attributedcharacteriterator.getAttribute(PAINT_INFO);
                    Glyph glyph1 = svgglyphelementbridge1.createGlyph(ctx, element, textElement, j, fontSize, fontFace, textpaintinfo1);
                    vector.add(glyph1);
                    flag = true;
                    break;
                }
                int k = characteriterator.getIndex();
                boolean flag1 = true;
                int i1 = 1;
                do
                {
                    if(i1 >= glyphUnicodes[j].length())
                        break;
                    c = characteriterator.next();
                    if(glyphUnicodes[j].charAt(i1) != c)
                    {
                        flag1 = false;
                        break;
                    }
                    i1++;
                } while(true);
                if(flag1)
                {
                    Element element1 = glyphElements[j];
                    SVGGlyphElementBridge svgglyphelementbridge2 = (SVGGlyphElementBridge)ctx.getBridge(element1);
                    TextPaintInfo textpaintinfo2 = null;
                    if(attributedcharacteriterator != null)
                    {
                        attributedcharacteriterator.setIndex(characteriterator.getIndex());
                        textpaintinfo2 = (TextPaintInfo)attributedcharacteriterator.getAttribute(PAINT_INFO);
                    }
                    Glyph glyph2 = svgglyphelementbridge2.createGlyph(ctx, element1, textElement, j, fontSize, fontFace, textpaintinfo2);
                    vector.add(glyph2);
                    flag = true;
                    break;
                }
                c = characteriterator.setIndex(k);
            }

            if(flag)
                continue;
            SVGGlyphElementBridge svgglyphelementbridge = (SVGGlyphElementBridge)ctx.getBridge(missingGlyphElement);
            TextPaintInfo textpaintinfo = null;
            if(attributedcharacteriterator != null)
            {
                attributedcharacteriterator.setIndex(characteriterator.getIndex());
                textpaintinfo = (TextPaintInfo)attributedcharacteriterator.getAttribute(PAINT_INFO);
            }
            Glyph glyph = svgglyphelementbridge.createGlyph(ctx, missingGlyphElement, textElement, -1, fontSize, fontFace, textpaintinfo);
            vector.add(glyph);
        }

        int i = vector.size();
        Glyph aglyph[] = new Glyph[i];
        for(int l = 0; l < i; l++)
            aglyph[l] = (Glyph)vector.get(l);

        return new SVGGVTGlyphVector(this, aglyph, fontrendercontext);
    }

    public GVTGlyphVector createGlyphVector(FontRenderContext fontrendercontext, int ai[], CharacterIterator characteriterator)
    {
        String s = "";
        for(int i = 0; i < ai.length; i++)
            s = s + glyphUnicodes[ai[i]];

        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        return createGlyphVector(fontrendercontext, ((CharacterIterator) (stringcharacteriterator)));
    }

    public GVTGlyphVector createGlyphVector(FontRenderContext fontrendercontext, String s)
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        return createGlyphVector(fontrendercontext, ((CharacterIterator) (stringcharacteriterator)));
    }

    public GVTFont deriveFont(float f)
    {
        return new SVGGVTFont(f, fontFace, glyphUnicodes, glyphNames, glyphLangs, glyphOrientations, glyphForms, ctx, glyphElements, missingGlyphElement, hkernElements, vkernElements, textElement);
    }

    protected GVTLineMetrics getLineMetrics(int i, int j)
    {
        if(lineMetrics != null)
        {
            return lineMetrics;
        } else
        {
            float f = fontFace.getUnitsPerEm();
            float f1 = fontSize / f;
            float f2 = fontFace.getAscent() * f1;
            float f3 = fontFace.getDescent() * f1;
            float af[] = new float[3];
            af[0] = 0.0F;
            af[1] = (f2 + f3) / 2.0F - f2;
            af[2] = -f2;
            float f4 = fontFace.getStrikethroughPosition() * -f1;
            float f5 = fontFace.getStrikethroughThickness() * f1;
            float f6 = fontFace.getUnderlinePosition() * f1;
            float f7 = fontFace.getUnderlineThickness() * f1;
            float f8 = fontFace.getOverlinePosition() * -f1;
            float f9 = fontFace.getOverlineThickness() * f1;
            lineMetrics = new GVTLineMetrics(f2, 0, af, f3, f, f, j - i, f4, f5, f6, f7, f8, f9);
            return lineMetrics;
        }
    }

    public GVTLineMetrics getLineMetrics(char ac[], int i, int j, FontRenderContext fontrendercontext)
    {
        return getLineMetrics(i, j);
    }

    public GVTLineMetrics getLineMetrics(CharacterIterator characteriterator, int i, int j, FontRenderContext fontrendercontext)
    {
        return getLineMetrics(i, j);
    }

    public GVTLineMetrics getLineMetrics(String s, FontRenderContext fontrendercontext)
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        return getLineMetrics(((CharacterIterator) (stringcharacteriterator)), 0, s.length(), fontrendercontext);
    }

    public GVTLineMetrics getLineMetrics(String s, int i, int j, FontRenderContext fontrendercontext)
    {
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        return getLineMetrics(((CharacterIterator) (stringcharacteriterator)), i, j, fontrendercontext);
    }

    public float getSize()
    {
        return fontSize;
    }

    public String toString()
    {
        return fontFace.getFamilyName() + " " + fontFace.getFontWeight() + " " + fontFace.getFontStyle();
    }

    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO;
    private float fontSize;
    private GVTFontFace fontFace;
    private String glyphUnicodes[];
    private String glyphNames[];
    private String glyphLangs[];
    private String glyphOrientations[];
    private String glyphForms[];
    private Element glyphElements[];
    private Element hkernElements[];
    private Element vkernElements[];
    private BridgeContext ctx;
    private Element textElement;
    private Element missingGlyphElement;
    private KerningTable hKerningTable;
    private KerningTable vKerningTable;
    private String language;
    private String orientation;
    private float scale;
    private GVTLineMetrics lineMetrics;

    static 
    {
        PAINT_INFO = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.PAINT_INFO;
    }
}
