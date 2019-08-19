// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.CSSStylableElement;
import org.apache.batik.css.engine.value.ListValue;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.css.engine.value.svg.ICCColor;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.ext.awt.MultipleGradientPaint;
import org.apache.batik.ext.awt.image.renderable.ClipRable;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.filter.Mask;
import org.apache.batik.util.CSSConstants;
import org.apache.batik.util.XMLConstants;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, BridgeContext, CursorManager, FilterBridge, 
//            BridgeException, ClipBridge, MaskBridge, PaintServer

public abstract class CSSUtilities
    implements CSSConstants, ErrorConstants, XMLConstants
{

    protected CSSUtilities()
    {
    }

    public static CSSEngine getCSSEngine(Element element)
    {
        return ((SVGOMDocument)element.getOwnerDocument()).getCSSEngine();
    }

    public static Value getComputedStyle(Element element, int i)
    {
        CSSEngine cssengine = getCSSEngine(element);
        if(cssengine == null)
            return null;
        else
            return cssengine.getComputedStyle((CSSStylableElement)element, null, i);
    }

    public static int convertPointerEvents(Element element)
    {
        Value value = getComputedStyle(element, 40);
        String s = value.getStringValue();
        switch(s.charAt(0))
        {
        case 118: // 'v'
            if(s.length() == 7)
                return 3;
            switch(s.charAt(7))
            {
            case 112: // 'p'
                return 0;

            case 102: // 'f'
                return 1;

            case 115: // 's'
                return 2;
            }
            throw new Error();

        case 112: // 'p'
            return 4;

        case 102: // 'f'
            return 5;

        case 115: // 's'
            return 6;

        case 97: // 'a'
            return 7;

        case 110: // 'n'
            return 8;
        }
        throw new Error();
    }

    public static Rectangle2D convertEnableBackground(Element element)
    {
        Value value = getComputedStyle(element, 14);
        if(value.getCssValueType() != 2)
            return null;
        ListValue listvalue = (ListValue)value;
        int i = listvalue.getLength();
        switch(i)
        {
        case 1: // '\001'
            return CompositeGraphicsNode.VIEWPORT;

        case 5: // '\005'
            float f = listvalue.item(1).getFloatValue();
            float f1 = listvalue.item(2).getFloatValue();
            float f2 = listvalue.item(3).getFloatValue();
            float f3 = listvalue.item(4).getFloatValue();
            return new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
        }
        throw new InternalError();
    }

    public static boolean convertColorInterpolationFilters(Element element)
    {
        Value value = getComputedStyle(element, 7);
        return "linearrgb" == value.getStringValue();
    }

    public static org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum convertColorInterpolation(Element element)
    {
        Value value = getComputedStyle(element, 6);
        return "linearrgb" != value.getStringValue() ? MultipleGradientPaint.SRGB : MultipleGradientPaint.LINEAR_RGB;
    }

    public static boolean isAutoCursor(Element element)
    {
        Value value = getComputedStyle(element, 10);
        boolean flag = false;
        if(value != null)
            if(value.getCssValueType() == 1 && value.getPrimitiveType() == 21 && value.getStringValue().charAt(0) == 'a')
                flag = true;
            else
            if(value.getCssValueType() == 2 && value.getLength() == 1)
            {
                Value value1 = value.item(0);
                if(value1 != null && value1.getCssValueType() == 1 && value1.getPrimitiveType() == 21 && value1.getStringValue().charAt(0) == 'a')
                    flag = true;
            }
        return flag;
    }

    public static Cursor convertCursor(Element element, BridgeContext bridgecontext)
    {
        return bridgecontext.getCursorManager().convertCursor(element);
    }

    public static RenderingHints convertShapeRendering(Element element, RenderingHints renderinghints)
    {
        Value value = getComputedStyle(element, 42);
        String s = value.getStringValue();
        int i = s.length();
        if(i == 4 && s.charAt(0) == 'a')
            return renderinghints;
        if(i < 10)
            return renderinghints;
        if(renderinghints == null)
            renderinghints = new RenderingHints(null);
        switch(s.charAt(0))
        {
        case 111: // 'o'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            break;

        case 99: // 'c'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            break;

        case 103: // 'g'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            renderinghints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            break;
        }
        return renderinghints;
    }

    public static RenderingHints convertTextRendering(Element element, RenderingHints renderinghints)
    {
        Value value = getComputedStyle(element, 55);
        String s = value.getStringValue();
        int i = s.length();
        if(i == 4 && s.charAt(0) == 'a')
            return renderinghints;
        if(i < 13)
            return renderinghints;
        if(renderinghints == null)
            renderinghints = new RenderingHints(null);
        switch(s.charAt(8))
        {
        case 115: // 's'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            renderinghints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            break;

        case 108: // 'l'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            renderinghints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            break;

        case 99: // 'c'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            renderinghints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            renderinghints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            renderinghints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            renderinghints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            break;
        }
        return renderinghints;
    }

    public static RenderingHints convertImageRendering(Element element, RenderingHints renderinghints)
    {
        Value value = getComputedStyle(element, 30);
        String s = value.getStringValue();
        int i = s.length();
        if(i == 4 && s.charAt(0) == 'a')
            return renderinghints;
        if(i < 13)
            return renderinghints;
        if(renderinghints == null)
            renderinghints = new RenderingHints(null);
        switch(s.charAt(8))
        {
        case 115: // 's'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
            renderinghints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            break;

        case 113: // 'q'
            renderinghints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            renderinghints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            break;
        }
        return renderinghints;
    }

    public static RenderingHints convertColorRendering(Element element, RenderingHints renderinghints)
    {
        Value value = getComputedStyle(element, 9);
        String s = value.getStringValue();
        int i = s.length();
        if(i == 4 && s.charAt(0) == 'a')
            return renderinghints;
        if(i < 13)
            return renderinghints;
        if(renderinghints == null)
            renderinghints = new RenderingHints(null);
        switch(s.charAt(8))
        {
        case 115: // 's'
            renderinghints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            renderinghints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            break;

        case 113: // 'q'
            renderinghints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            renderinghints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            break;
        }
        return renderinghints;
    }

    public static boolean convertDisplay(Element element)
    {
        Value value = getComputedStyle(element, 12);
        return value.getStringValue().charAt(0) != 'n';
    }

    public static boolean convertVisibility(Element element)
    {
        Value value = getComputedStyle(element, 57);
        return value.getStringValue().charAt(0) == 'v';
    }

    public static Composite convertOpacity(Element element)
    {
        Value value = getComputedStyle(element, 38);
        float f = value.getFloatValue();
        if(f <= 0.0F)
            return TRANSPARENT;
        if(f >= 1.0F)
            return AlphaComposite.SrcOver;
        else
            return AlphaComposite.getInstance(3, f);
    }

    public static boolean convertOverflow(Element element)
    {
        Value value = getComputedStyle(element, 39);
        String s = value.getStringValue();
        return s.charAt(0) == 'h' || s.charAt(0) == 's';
    }

    public static float[] convertClip(Element element)
    {
        Value value = getComputedStyle(element, 2);
        switch(value.getPrimitiveType())
        {
        case 24: // '\030'
            float af[] = new float[4];
            af[0] = value.getTop().getFloatValue();
            af[1] = value.getRight().getFloatValue();
            af[2] = value.getBottom().getFloatValue();
            af[3] = value.getLeft().getFloatValue();
            return af;

        case 21: // '\025'
            return null;
        }
        throw new Error();
    }

    public static Filter convertFilter(Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 18);
        switch(value.getPrimitiveType())
        {
        case 21: // '\025'
            return null;

        case 20: // '\024'
            String s = value.getStringValue();
            Element element1 = bridgecontext.getReferencedElement(element, s);
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge == null || !(bridge instanceof FilterBridge))
                throw new BridgeException(element, "css.uri.badTarget", new Object[] {
                    s
                });
            else
                return ((FilterBridge)bridge).createFilter(bridgecontext, element1, element, graphicsnode);
        }
        throw new InternalError();
    }

    public static ClipRable convertClipPath(Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 3);
        switch(value.getPrimitiveType())
        {
        case 21: // '\025'
            return null;

        case 20: // '\024'
            String s = value.getStringValue();
            Element element1 = bridgecontext.getReferencedElement(element, s);
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge == null || !(bridge instanceof ClipBridge))
                throw new BridgeException(element, "css.uri.badTarget", new Object[] {
                    s
                });
            else
                return ((ClipBridge)bridge).createClip(bridgecontext, element1, element, graphicsnode);
        }
        throw new InternalError();
    }

    public static int convertClipRule(Element element)
    {
        Value value = getComputedStyle(element, 4);
        return value.getStringValue().charAt(0) != 'n' ? 0 : 1;
    }

    public static Mask convertMask(Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 37);
        switch(value.getPrimitiveType())
        {
        case 21: // '\025'
            return null;

        case 20: // '\024'
            String s = value.getStringValue();
            Element element1 = bridgecontext.getReferencedElement(element, s);
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge == null || !(bridge instanceof MaskBridge))
                throw new BridgeException(element, "css.uri.badTarget", new Object[] {
                    s
                });
            else
                return ((MaskBridge)bridge).createMask(bridgecontext, element1, element, graphicsnode);
        }
        throw new InternalError();
    }

    public static int convertFillRule(Element element)
    {
        Value value = getComputedStyle(element, 17);
        return value.getStringValue().charAt(0) != 'n' ? 0 : 1;
    }

    public static Color convertLightingColor(Element element, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 33);
        if(value.getCssValueType() == 1)
            return PaintServer.convertColor(value, 1.0F);
        else
            return PaintServer.convertRGBICCColor(element, value.item(0), (ICCColor)value.item(1), 1.0F, bridgecontext);
    }

    public static Color convertFloodColor(Element element, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 19);
        Value value1 = getComputedStyle(element, 20);
        float f = PaintServer.convertOpacity(value1);
        if(value.getCssValueType() == 1)
            return PaintServer.convertColor(value, f);
        else
            return PaintServer.convertRGBICCColor(element, value.item(0), (ICCColor)value.item(1), f, bridgecontext);
    }

    public static Color convertStopColor(Element element, float f, BridgeContext bridgecontext)
    {
        Value value = getComputedStyle(element, 43);
        Value value1 = getComputedStyle(element, 44);
        f *= PaintServer.convertOpacity(value1);
        if(value.getCssValueType() == 1)
            return PaintServer.convertColor(value, f);
        else
            return PaintServer.convertRGBICCColor(element, value.item(0), (ICCColor)value.item(1), f, bridgecontext);
    }

    public static void computeStyleAndURIs(Element element, Element element1, String s)
    {
        int i = s.indexOf('#');
        if(i != -1)
            s = s.substring(0, i);
        if(s.length() != 0)
            element1.setAttributeNS("http://www.w3.org/XML/1998/namespace", "base", s);
        CSSEngine cssengine = getCSSEngine(element1);
        CSSEngine cssengine1 = getCSSEngine(element);
        cssengine.importCascadedStyleMaps(element, cssengine1, element1);
    }

    protected static int rule(CSSValue cssvalue)
    {
        return ((CSSPrimitiveValue)cssvalue).getStringValue().charAt(0) != 'n' ? 0 : 1;
    }

    public static final Composite TRANSPARENT = AlphaComposite.getInstance(3, 0.0F);

}
