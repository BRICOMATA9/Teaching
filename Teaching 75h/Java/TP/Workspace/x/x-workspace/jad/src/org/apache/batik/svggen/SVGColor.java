// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGGeneratorContext, SVGPaintDescriptor, SVGDescriptor

public class SVGColor extends AbstractSVGConverter
{

    public SVGColor(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        java.awt.Paint paint = graphiccontext.getPaint();
        return toSVG((Color)paint, generatorContext);
    }

    public static SVGPaintDescriptor toSVG(Color color, SVGGeneratorContext svggeneratorcontext)
    {
        String s = (String)colorMap.get(color);
        if(s == null)
        {
            StringBuffer stringbuffer = new StringBuffer("rgb(");
            stringbuffer.append(color.getRed());
            stringbuffer.append(",");
            stringbuffer.append(color.getGreen());
            stringbuffer.append(",");
            stringbuffer.append(color.getBlue());
            stringbuffer.append(")");
            s = stringbuffer.toString();
        }
        float f = (float)color.getAlpha() / 255F;
        String s1 = svggeneratorcontext.doubleString(f);
        return new SVGPaintDescriptor(s, s1);
    }

    public static final Color aqua;
    public static final Color black;
    public static final Color blue;
    public static final Color fuchsia;
    public static final Color gray;
    public static final Color green;
    public static final Color lime;
    public static final Color maroon;
    public static final Color navy;
    public static final Color olive;
    public static final Color purple;
    public static final Color red;
    public static final Color silver;
    public static final Color teal;
    public static final Color white;
    public static final Color yellow;
    private static Map colorMap;

    static 
    {
        aqua = new Color(0, 255, 255);
        black = Color.black;
        blue = Color.blue;
        fuchsia = new Color(255, 0, 255);
        gray = new Color(128, 128, 128);
        green = new Color(0, 128, 0);
        lime = new Color(0, 255, 0);
        maroon = new Color(128, 0, 0);
        navy = new Color(0, 0, 128);
        olive = new Color(128, 128, 0);
        purple = new Color(128, 0, 128);
        red = new Color(255, 0, 0);
        silver = new Color(192, 192, 192);
        teal = new Color(0, 128, 128);
        white = Color.white;
        yellow = Color.yellow;
        colorMap = new HashMap();
        colorMap.put(black, "black");
        colorMap.put(silver, "silver");
        colorMap.put(gray, "gray");
        colorMap.put(white, "white");
        colorMap.put(maroon, "maroon");
        colorMap.put(red, "red");
        colorMap.put(purple, "purple");
        colorMap.put(fuchsia, "fuchsia");
        colorMap.put(green, "green");
        colorMap.put(lime, "lime");
        colorMap.put(olive, "olive");
        colorMap.put(yellow, "yellow");
        colorMap.put(navy, "navy");
        colorMap.put(blue, "blue");
        colorMap.put(teal, "teal");
        colorMap.put(aqua, "aqua");
    }
}
