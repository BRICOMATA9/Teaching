// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.css.engine.value.Value;
import org.apache.batik.parser.ParseException;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeException, BridgeContext, UserAgent, CSSUtilities, 
//            Viewport

public abstract class UnitProcessor extends org.apache.batik.parser.UnitProcessor
{
    public static class DefaultContext
        implements org.apache.batik.parser.Context
    {

        public Element getElement()
        {
            return e;
        }

        public float getPixelUnitToMillimeter()
        {
            return ctx.getUserAgent().getPixelUnitToMillimeter();
        }

        public float getPixelToMM()
        {
            return getPixelUnitToMillimeter();
        }

        public float getFontSize()
        {
            return CSSUtilities.getComputedStyle(e, 22).getFloatValue();
        }

        public float getXHeight()
        {
            return 0.5F;
        }

        public float getViewportWidth()
        {
            return ctx.getViewport(e).getWidth();
        }

        public float getViewportHeight()
        {
            return ctx.getViewport(e).getHeight();
        }

        protected Element e;
        protected BridgeContext ctx;

        public DefaultContext(BridgeContext bridgecontext, Element element)
        {
            ctx = bridgecontext;
            e = element;
        }
    }


    protected UnitProcessor()
    {
    }

    public static org.apache.batik.parser.Context createContext(BridgeContext bridgecontext, Element element)
    {
        return new DefaultContext(bridgecontext, element);
    }

    public static float svgHorizontalCoordinateToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToObjectBoundingBox(s, s1, (short)2, context);
    }

    public static float svgVerticalCoordinateToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToObjectBoundingBox(s, s1, (short)1, context);
    }

    public static float svgOtherCoordinateToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToObjectBoundingBox(s, s1, (short)0, context);
    }

    public static float svgHorizontalLengthToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToObjectBoundingBox(s, s1, (short)2, context);
    }

    public static float svgVerticalLengthToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToObjectBoundingBox(s, s1, (short)1, context);
    }

    public static float svgOtherLengthToObjectBoundingBox(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToObjectBoundingBox(s, s1, (short)0, context);
    }

    public static float svgLengthToObjectBoundingBox(String s, String s1, short word0, org.apache.batik.parser.Context context)
    {
        float f = svgToObjectBoundingBox(s, s1, word0, context);
        if(f < 0.0F)
            throw new BridgeException(context.getElement(), "length.negative", new Object[] {
                s1, s
            });
        else
            return f;
    }

    public static float svgToObjectBoundingBox(String s, String s1, short word0, org.apache.batik.parser.Context context)
    {
        return org.apache.batik.parser.UnitProcessor.svgToObjectBoundingBox(s, s1, word0, context);
        ParseException parseexception;
        parseexception;
        throw new BridgeException(context.getElement(), "attribute.malformed", new Object[] {
            s1, s, parseexception
        });
    }

    public static float svgHorizontalLengthToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToUserSpace(s, s1, (short)2, context);
    }

    public static float svgVerticalLengthToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToUserSpace(s, s1, (short)1, context);
    }

    public static float svgOtherLengthToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgLengthToUserSpace(s, s1, (short)0, context);
    }

    public static float svgHorizontalCoordinateToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToUserSpace(s, s1, (short)2, context);
    }

    public static float svgVerticalCoordinateToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToUserSpace(s, s1, (short)1, context);
    }

    public static float svgOtherCoordinateToUserSpace(String s, String s1, org.apache.batik.parser.Context context)
    {
        return svgToUserSpace(s, s1, (short)0, context);
    }

    public static float svgLengthToUserSpace(String s, String s1, short word0, org.apache.batik.parser.Context context)
    {
        float f = svgToUserSpace(s, s1, word0, context);
        if(f < 0.0F)
            throw new BridgeException(context.getElement(), "length.negative", new Object[] {
                s1, s
            });
        else
            return f;
    }

    public static float svgToUserSpace(String s, String s1, short word0, org.apache.batik.parser.Context context)
    {
        return org.apache.batik.parser.UnitProcessor.svgToUserSpace(s, s1, word0, context);
        ParseException parseexception;
        parseexception;
        throw new BridgeException(context.getElement(), "attribute.malformed", new Object[] {
            s1, s, parseexception
        });
    }
}
