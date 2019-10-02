// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import java.awt.font.LineMetrics;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGFontDescriptor, SVGGeneratorContext, SVGPath, 
//            SVGIDGenerator, SVGDescriptor

public class SVGFont extends AbstractSVGConverter
{

    public SVGFont(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        fontStringMap = new HashMap();
    }

    public void recordFontUsage(String s, Font font)
    {
        Font font1 = createCommonSizeFont(font);
        String s1 = font1.getFamily() + font1.getStyle();
        String s2 = (String)fontStringMap.get(s1);
        if(s2 == null)
            s2 = "";
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(s2.indexOf(c) == -1)
                s2 = s2 + c;
        }

        fontStringMap.put(s1, s2);
    }

    private static Font createCommonSizeFont(Font font)
    {
        HashMap hashmap = new HashMap(font.getAttributes());
        hashmap.put(TextAttribute.SIZE, new Float(100F));
        return new Font(hashmap);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getFont(), graphiccontext.getFontRenderContext());
    }

    public SVGFontDescriptor toSVG(Font font, FontRenderContext fontrendercontext)
    {
        String s = "" + doubleString(font.getSize2D());
        String s1 = weightToSVG(font);
        String s2 = styleToSVG(font);
        String s3 = familyToSVG(font);
        Font font1 = createCommonSizeFont(font);
        String s4 = font1.getFamily() + font1.getStyle();
        String s5 = (String)fontStringMap.get(s4);
        if(s5 == null)
            return new SVGFontDescriptor(s, s1, s2, s3, null);
        Document document = generatorContext.domFactory;
        SVGFontDescriptor svgfontdescriptor = (SVGFontDescriptor)descMap.get(s4);
        Element element;
        if(svgfontdescriptor != null)
        {
            element = svgfontdescriptor.getDef();
        } else
        {
            element = document.createElementNS("http://www.w3.org/2000/svg", "font");
            Element element1 = document.createElementNS("http://www.w3.org/2000/svg", "font-face");
            String s6 = s3;
            if(s3.startsWith("'") && s3.endsWith("'"))
                s6 = s3.substring(1, s3.length() - 1);
            element1.setAttributeNS(null, "font-family", s6);
            element1.setAttributeNS(null, "font-weight", s1);
            element1.setAttributeNS(null, "font-style", s2);
            element1.setAttributeNS(null, "units-per-em", "100");
            element.appendChild(element1);
            Element element2 = document.createElementNS("http://www.w3.org/2000/svg", "missing-glyph");
            int ai[] = new int[1];
            ai[0] = font1.getMissingGlyphCode();
            GlyphVector glyphvector = font1.createGlyphVector(fontrendercontext, ai);
            java.awt.Shape shape = glyphvector.getGlyphOutline(0);
            GlyphMetrics glyphmetrics = glyphvector.getGlyphMetrics(0);
            AffineTransform affinetransform = AffineTransform.getScaleInstance(1.0D, -1D);
            shape = affinetransform.createTransformedShape(shape);
            element2.setAttributeNS(null, "d", SVGPath.toSVGPathData(shape, generatorContext));
            element2.setAttributeNS(null, "horiz-adv-x", "" + glyphmetrics.getAdvance());
            element.appendChild(element2);
            element.setAttributeNS(null, "horiz-adv-x", "" + glyphmetrics.getAdvance());
            LineMetrics linemetrics = font1.getLineMetrics("By", fontrendercontext);
            element1.setAttributeNS(null, "ascent", "" + linemetrics.getAscent());
            element1.setAttributeNS(null, "descent", "" + linemetrics.getDescent());
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("font"));
        }
        int i = s5.length() - 1;
        do
        {
            if(i < 0)
                break;
            char c = s5.charAt(i);
            boolean flag = false;
            NodeList nodelist = element.getChildNodes();
            for(int j = 0; j < nodelist.getLength(); j++)
            {
                if(!(nodelist.item(j) instanceof Element))
                    continue;
                Element element4 = (Element)nodelist.item(j);
                if(!element4.getAttributeNS(null, "unicode").equals("" + c))
                    continue;
                flag = true;
                break;
            }

            if(flag)
                break;
            Element element3 = document.createElementNS("http://www.w3.org/2000/svg", "glyph");
            GlyphVector glyphvector1 = font1.createGlyphVector(fontrendercontext, "" + c);
            java.awt.Shape shape1 = glyphvector1.getGlyphOutline(0);
            GlyphMetrics glyphmetrics1 = glyphvector1.getGlyphMetrics(0);
            AffineTransform affinetransform1 = AffineTransform.getScaleInstance(1.0D, -1D);
            shape1 = affinetransform1.createTransformedShape(shape1);
            element3.setAttributeNS(null, "d", SVGPath.toSVGPathData(shape1, generatorContext));
            element3.setAttributeNS(null, "horiz-adv-x", "" + glyphmetrics1.getAdvance());
            element3.setAttributeNS(null, "unicode", "" + c);
            element.appendChild(element3);
            i--;
        } while(true);
        SVGFontDescriptor svgfontdescriptor1 = new SVGFontDescriptor(s, s1, s2, s3, element);
        if(svgfontdescriptor == null)
        {
            descMap.put(s4, svgfontdescriptor1);
            defSet.add(element);
        }
        return svgfontdescriptor1;
    }

    public static String familyToSVG(Font font)
    {
        String s = font.getFamily();
        String s1 = (String)logicalFontMap.get(font.getName().toLowerCase());
        if(s1 != null)
        {
            s = s1;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer("'");
            stringbuffer.append(s);
            stringbuffer.append("'");
            s = stringbuffer.toString();
        }
        return s;
    }

    public static String styleToSVG(Font font)
    {
        Map map = font.getAttributes();
        Float float1 = (Float)map.get(TextAttribute.POSTURE);
        if(float1 == null)
            if(font.isItalic())
                float1 = TextAttribute.POSTURE_OBLIQUE;
            else
                float1 = TextAttribute.POSTURE_REGULAR;
        float f = float1.floatValue();
        int i = 0;
        for(i = 0; i < fontStyles.length && f > fontStyles[i]; i++);
        return svgStyles[i];
    }

    public static String weightToSVG(Font font)
    {
        Map map = font.getAttributes();
        Float float1 = (Float)map.get(TextAttribute.WEIGHT);
        if(float1 == null)
            if(font.isBold())
                float1 = TextAttribute.WEIGHT_BOLD;
            else
                float1 = TextAttribute.WEIGHT_REGULAR;
        float f = float1.floatValue();
        int i = 0;
        for(i = 0; i < fontWeights.length && f > fontWeights[i]; i++);
        return svgWeights[i];
    }

    public static final float EXTRA_LIGHT;
    public static final float LIGHT;
    public static final float DEMILIGHT;
    public static final float REGULAR;
    public static final float SEMIBOLD;
    public static final float MEDIUM;
    public static final float DEMIBOLD;
    public static final float BOLD;
    public static final float HEAVY;
    public static final float EXTRABOLD;
    public static final float ULTRABOLD;
    public static final float POSTURE_REGULAR;
    public static final float POSTURE_OBLIQUE;
    static final float fontStyles[];
    static final String svgStyles[] = {
        "normal", "italic"
    };
    static final float fontWeights[];
    static final String svgWeights[] = {
        "100", "200", "300", "normal", "500", "500", "600", "bold", "800", "800", 
        "900"
    };
    static Map logicalFontMap;
    static final int COMMON_FONT_SIZE = 100;
    Map fontStringMap;

    static 
    {
        EXTRA_LIGHT = TextAttribute.WEIGHT_EXTRA_LIGHT.floatValue();
        LIGHT = TextAttribute.WEIGHT_LIGHT.floatValue();
        DEMILIGHT = TextAttribute.WEIGHT_DEMILIGHT.floatValue();
        REGULAR = TextAttribute.WEIGHT_REGULAR.floatValue();
        SEMIBOLD = TextAttribute.WEIGHT_SEMIBOLD.floatValue();
        MEDIUM = TextAttribute.WEIGHT_MEDIUM.floatValue();
        DEMIBOLD = TextAttribute.WEIGHT_DEMIBOLD.floatValue();
        BOLD = TextAttribute.WEIGHT_BOLD.floatValue();
        HEAVY = TextAttribute.WEIGHT_HEAVY.floatValue();
        EXTRABOLD = TextAttribute.WEIGHT_EXTRABOLD.floatValue();
        ULTRABOLD = TextAttribute.WEIGHT_ULTRABOLD.floatValue();
        POSTURE_REGULAR = TextAttribute.POSTURE_REGULAR.floatValue();
        POSTURE_OBLIQUE = TextAttribute.POSTURE_OBLIQUE.floatValue();
        fontStyles = (new float[] {
            POSTURE_REGULAR + (POSTURE_OBLIQUE - POSTURE_REGULAR) / 2.0F
        });
        fontWeights = (new float[] {
            EXTRA_LIGHT + (LIGHT - EXTRA_LIGHT) / 2.0F, LIGHT + (DEMILIGHT - LIGHT) / 2.0F, DEMILIGHT + (REGULAR - DEMILIGHT) / 2.0F, REGULAR + (SEMIBOLD - REGULAR) / 2.0F, SEMIBOLD + (MEDIUM - SEMIBOLD) / 2.0F, MEDIUM + (DEMIBOLD - MEDIUM) / 2.0F, DEMIBOLD + (BOLD - DEMIBOLD) / 2.0F, BOLD + (HEAVY - BOLD) / 2.0F, HEAVY + (EXTRABOLD - HEAVY) / 2.0F, EXTRABOLD + (ULTRABOLD - EXTRABOLD)
        });
        logicalFontMap = new HashMap();
        logicalFontMap.put("dialog", "sans-serif");
        logicalFontMap.put("dialoginput", "monospace");
        logicalFontMap.put("monospaced", "monospace");
        logicalFontMap.put("serif", "serif");
        logicalFontMap.put("sansserif", "sans-serif");
        logicalFontMap.put("symbol", "'WingDings'");
    }
}
