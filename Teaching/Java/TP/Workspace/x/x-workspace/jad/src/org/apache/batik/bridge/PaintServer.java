// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.*;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.css.engine.value.svg.ICCColor;
import org.apache.batik.ext.awt.color.ICCColorSpaceExt;
import org.apache.batik.gvt.*;
import org.apache.batik.util.CSSConstants;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, CSSUtilities, BridgeContext, MarkerBridge, 
//            BridgeException, PaintBridge, SVGColorProfileElementBridge

public abstract class PaintServer
    implements SVGConstants, CSSConstants, ErrorConstants
{

    protected PaintServer()
    {
    }

    public static ShapePainter convertMarkers(Element element, ShapeNode shapenode, BridgeContext bridgecontext)
    {
        Value value = CSSUtilities.getComputedStyle(element, 36);
        Marker marker = convertMarker(element, value, bridgecontext);
        value = CSSUtilities.getComputedStyle(element, 35);
        Marker marker1 = convertMarker(element, value, bridgecontext);
        value = CSSUtilities.getComputedStyle(element, 34);
        Marker marker2 = convertMarker(element, value, bridgecontext);
        if(marker != null || marker1 != null || marker2 != null)
        {
            MarkerShapePainter markershapepainter = new MarkerShapePainter(shapenode.getShape());
            markershapepainter.setStartMarker(marker);
            markershapepainter.setMiddleMarker(marker1);
            markershapepainter.setEndMarker(marker2);
            return markershapepainter;
        } else
        {
            return null;
        }
    }

    public static Marker convertMarker(Element element, Value value, BridgeContext bridgecontext)
    {
        if(value.getPrimitiveType() == 21)
            return null;
        String s = value.getStringValue();
        Element element1 = bridgecontext.getReferencedElement(element, s);
        Bridge bridge = bridgecontext.getBridge(element1);
        if(bridge == null || !(bridge instanceof MarkerBridge))
            throw new BridgeException(element, "css.uri.badTarget", new Object[] {
                s
            });
        else
            return ((MarkerBridge)bridge).createMarker(bridgecontext, element1, element);
    }

    public static ShapePainter convertFillAndStroke(Element element, ShapeNode shapenode, BridgeContext bridgecontext)
    {
        java.awt.Shape shape = shapenode.getShape();
        if(shape == null)
            return null;
        Paint paint = convertFillPaint(element, shapenode, bridgecontext);
        FillShapePainter fillshapepainter = new FillShapePainter(shape);
        fillshapepainter.setPaint(paint);
        Stroke stroke = convertStroke(element);
        if(stroke == null)
        {
            return fillshapepainter;
        } else
        {
            Paint paint1 = convertStrokePaint(element, shapenode, bridgecontext);
            StrokeShapePainter strokeshapepainter = new StrokeShapePainter(shape);
            strokeshapepainter.setStroke(stroke);
            strokeshapepainter.setPaint(paint1);
            CompositeShapePainter compositeshapepainter = new CompositeShapePainter(shape);
            compositeshapepainter.addShapePainter(fillshapepainter);
            compositeshapepainter.addShapePainter(strokeshapepainter);
            return compositeshapepainter;
        }
    }

    public static ShapePainter convertStrokePainter(Element element, ShapeNode shapenode, BridgeContext bridgecontext)
    {
        java.awt.Shape shape = shapenode.getShape();
        if(shape == null)
            return null;
        Stroke stroke = convertStroke(element);
        if(stroke == null)
        {
            return null;
        } else
        {
            Paint paint = convertStrokePaint(element, shapenode, bridgecontext);
            StrokeShapePainter strokeshapepainter = new StrokeShapePainter(shape);
            strokeshapepainter.setStroke(stroke);
            strokeshapepainter.setPaint(paint);
            return strokeshapepainter;
        }
    }

    public static Paint convertStrokePaint(Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        Value value = CSSUtilities.getComputedStyle(element, 51);
        float f = convertOpacity(value);
        value = CSSUtilities.getComputedStyle(element, 45);
        return convertPaint(element, graphicsnode, value, f, bridgecontext);
    }

    public static Paint convertFillPaint(Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        Value value = CSSUtilities.getComputedStyle(element, 16);
        float f = convertOpacity(value);
        value = CSSUtilities.getComputedStyle(element, 15);
        return convertPaint(element, graphicsnode, value, f, bridgecontext);
    }

    public static Paint convertPaint(Element element, GraphicsNode graphicsnode, Value value, float f, BridgeContext bridgecontext)
    {
        if(value.getCssValueType() == 1)
        {
            switch(value.getPrimitiveType())
            {
            case 21: // '\025'
                return null;

            case 25: // '\031'
                return convertColor(value, f);

            case 20: // '\024'
                return convertURIPaint(element, graphicsnode, value, f, bridgecontext);
            }
            throw new Error();
        }
        Value value1 = value.item(0);
        switch(value1.getPrimitiveType())
        {
        case 25: // '\031'
            return convertRGBICCColor(element, value1, (ICCColor)value.item(1), f, bridgecontext);

        case 20: // '\024'
            Paint paint = silentConvertURIPaint(element, graphicsnode, value1, f, bridgecontext);
            if(paint != null)
                return paint;
            value1 = value.item(1);
            switch(value1.getPrimitiveType())
            {
            case 21: // '\025'
                return null;

            case 25: // '\031'
                if(value.getLength() == 2)
                    return convertColor(value1, f);
                else
                    return convertRGBICCColor(element, value1, (ICCColor)value.item(2), f, bridgecontext);
            }
            throw new Error();
        }
        throw new Error("Unallowed Value: " + value1.getPrimitiveType());
    }

    public static Paint silentConvertURIPaint(Element element, GraphicsNode graphicsnode, Value value, float f, BridgeContext bridgecontext)
    {
        Paint paint = null;
        try
        {
            paint = convertURIPaint(element, graphicsnode, value, f, bridgecontext);
        }
        catch(BridgeException bridgeexception) { }
        return paint;
    }

    public static Paint convertURIPaint(Element element, GraphicsNode graphicsnode, Value value, float f, BridgeContext bridgecontext)
    {
        String s = value.getStringValue();
        Element element1 = bridgecontext.getReferencedElement(element, s);
        Bridge bridge = bridgecontext.getBridge(element1);
        if(bridge == null || !(bridge instanceof PaintBridge))
            throw new BridgeException(element, "css.uri.badTarget", new Object[] {
                s
            });
        else
            return ((PaintBridge)bridge).createPaint(bridgecontext, element1, element, graphicsnode, f);
    }

    public static Color convertRGBICCColor(Element element, Value value, ICCColor icccolor, float f, BridgeContext bridgecontext)
    {
        Color color = null;
        if(icccolor != null)
            color = convertICCColor(element, icccolor, f, bridgecontext);
        if(color == null)
            color = convertColor(value, f);
        return color;
    }

    public static Color convertICCColor(Element element, ICCColor icccolor, float f, BridgeContext bridgecontext)
    {
        String s = icccolor.getColorProfile();
        if(s == null)
            return null;
        SVGColorProfileElementBridge svgcolorprofileelementbridge = (SVGColorProfileElementBridge)bridgecontext.getBridge("http://www.w3.org/2000/svg", "color-profile");
        if(svgcolorprofileelementbridge == null)
            return null;
        ICCColorSpaceExt icccolorspaceext = svgcolorprofileelementbridge.createICCColorSpaceExt(bridgecontext, element, s);
        if(icccolorspaceext == null)
            return null;
        int i = icccolor.getNumberOfColors();
        float af[] = new float[i];
        if(i == 0)
            return null;
        for(int j = 0; j < i; j++)
            af[j] = icccolor.getColor(j);

        float af1[] = icccolorspaceext.intendedToRGB(af);
        return new Color(af1[0], af1[1], af1[2], f);
    }

    public static Color convertColor(Value value, float f)
    {
        int i = resolveColorComponent(value.getRed());
        int j = resolveColorComponent(value.getGreen());
        int k = resolveColorComponent(value.getBlue());
        return new Color(i, j, k, Math.round(f * 255F));
    }

    public static Stroke convertStroke(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 52);
        float f = value.getFloatValue();
        if(f == 0.0F)
            return null;
        value = CSSUtilities.getComputedStyle(element, 48);
        int i = convertStrokeLinecap(value);
        value = CSSUtilities.getComputedStyle(element, 49);
        int j = convertStrokeLinejoin(value);
        value = CSSUtilities.getComputedStyle(element, 50);
        float f1 = convertStrokeMiterlimit(value);
        value = CSSUtilities.getComputedStyle(element, 46);
        float af[] = convertStrokeDasharray(value);
        float f2 = 0.0F;
        if(af != null)
        {
            Value value1 = CSSUtilities.getComputedStyle(element, 47);
            f2 = value1.getFloatValue();
            if(f2 < 0.0F)
            {
                float f3 = 0.0F;
                for(int k = 0; k < af.length; k++)
                    f3 += af[k];

                if(af.length % 2 != 0)
                    f3 *= 2.0F;
                if(f3 == 0.0F)
                    f2 = 0.0F;
                else
                    for(; f2 < 0.0F; f2 += f3);
            }
        }
        return new BasicStroke(f, i, j, f1, af, f2);
    }

    public static float[] convertStrokeDasharray(Value value)
    {
        float af[] = null;
        if(value.getCssValueType() == 2)
        {
            int i = value.getLength();
            af = new float[i];
            float f = 0.0F;
            for(int j = 0; j < af.length; j++)
            {
                af[j] = value.item(j).getFloatValue();
                f += af[j];
            }

            if(f == 0.0F)
                af = null;
        }
        return af;
    }

    public static float convertStrokeMiterlimit(Value value)
    {
        float f = value.getFloatValue();
        return f >= 1.0F ? f : 1.0F;
    }

    public static int convertStrokeLinecap(Value value)
    {
        String s = value.getStringValue();
        switch(s.charAt(0))
        {
        case 98: // 'b'
            return 0;

        case 114: // 'r'
            return 1;

        case 115: // 's'
            return 2;
        }
        throw new Error();
    }

    public static int convertStrokeLinejoin(Value value)
    {
        String s = value.getStringValue();
        switch(s.charAt(0))
        {
        case 109: // 'm'
            return 0;

        case 114: // 'r'
            return 1;

        case 98: // 'b'
            return 2;
        }
        throw new Error();
    }

    public static int resolveColorComponent(Value value)
    {
        switch(value.getPrimitiveType())
        {
        case 2: // '\002'
            float f = value.getFloatValue();
            f = f <= 100F ? f >= 0.0F ? f : 0.0F : 100F;
            return Math.round((255F * f) / 100F);

        case 1: // '\001'
            float f1 = value.getFloatValue();
            f1 = f1 <= 255F ? f1 >= 0.0F ? f1 : 0.0F : 255F;
            return Math.round(f1);
        }
        throw new Error();
    }

    public static float convertOpacity(Value value)
    {
        float f = value.getFloatValue();
        return f >= 0.0F ? f <= 1.0F ? f : 1.0F : 0.0F;
    }
}
