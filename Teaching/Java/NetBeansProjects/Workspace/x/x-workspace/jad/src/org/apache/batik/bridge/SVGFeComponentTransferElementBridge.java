// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.batik.ext.awt.image.*;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeContext, AbstractSVGBridge, 
//            BridgeException

public class SVGFeComponentTransferElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{
    protected static abstract class SVGFeFuncElementBridge extends AbstractSVGBridge
    {

        public ComponentTransferFunction createComponentTransferFunction(Element element, Element element1)
        {
            int i = convertType(element1);
            switch(i)
            {
            case 2: // '\002'
                float af[] = convertTableValues(element1);
                if(af == null)
                    return ConcreteComponentTransferFunction.getIdentityTransfer();
                else
                    return ConcreteComponentTransferFunction.getDiscreteTransfer(af);

            case 0: // '\0'
                return ConcreteComponentTransferFunction.getIdentityTransfer();

            case 4: // '\004'
                float f = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "amplitude", 1.0F);
                float f2 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "exponent", 1.0F);
                float f4 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "offset", 0.0F);
                return ConcreteComponentTransferFunction.getGammaTransfer(f, f2, f4);

            case 3: // '\003'
                float f1 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "slope", 1.0F);
                float f3 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "intercept", 0.0F);
                return ConcreteComponentTransferFunction.getLinearTransfer(f1, f3);

            case 1: // '\001'
                float af1[] = convertTableValues(element1);
                if(af1 == null)
                    return ConcreteComponentTransferFunction.getIdentityTransfer();
                else
                    return ConcreteComponentTransferFunction.getTableTransfer(af1);
            }
            throw new Error();
        }

        protected static float[] convertTableValues(Element element)
        {
            String s = element.getAttributeNS(null, "tableValues");
            if(s.length() == 0)
                return null;
            StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
            float af[] = new float[stringtokenizer.countTokens()];
            try
            {
                for(int i = 0; stringtokenizer.hasMoreTokens(); i++)
                    af[i] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());

            }
            catch(NumberFormatException numberformatexception)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "tableValues", s
                });
            }
            return af;
        }

        protected static int convertType(Element element)
        {
            String s = element.getAttributeNS(null, "type");
            if(s.length() == 0)
                throw new BridgeException(element, "attribute.missing", new Object[] {
                    "type"
                });
            if("discrete".equals(s))
                return 2;
            if("identity".equals(s))
                return 0;
            if("gamma".equals(s))
                return 4;
            if("linear".equals(s))
                return 3;
            if("table".equals(s))
                return 1;
            else
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "type", s
                });
        }

        protected SVGFeFuncElementBridge()
        {
        }
    }

    public static class SVGFeFuncBElementBridge extends SVGFeFuncElementBridge
    {

        public String getLocalName()
        {
            return "feFuncB";
        }

        public SVGFeFuncBElementBridge()
        {
        }
    }

    public static class SVGFeFuncGElementBridge extends SVGFeFuncElementBridge
    {

        public String getLocalName()
        {
            return "feFuncG";
        }

        public SVGFeFuncGElementBridge()
        {
        }
    }

    public static class SVGFeFuncRElementBridge extends SVGFeFuncElementBridge
    {

        public String getLocalName()
        {
            return "feFuncR";
        }

        public SVGFeFuncRElementBridge()
        {
        }
    }

    public static class SVGFeFuncAElementBridge extends SVGFeFuncElementBridge
    {

        public String getLocalName()
        {
            return "feFuncA";
        }

        public SVGFeFuncAElementBridge()
        {
        }
    }


    public SVGFeComponentTransferElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feComponentTransfer";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
            return null;
        Rectangle2D rectangle2d1 = filter1.getBounds2D();
        Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        ComponentTransferFunction componenttransferfunction = null;
        ComponentTransferFunction componenttransferfunction1 = null;
        ComponentTransferFunction componenttransferfunction2 = null;
        ComponentTransferFunction componenttransferfunction3 = null;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element2);
            if(bridge == null || !(bridge instanceof SVGFeFuncElementBridge))
                continue;
            SVGFeFuncElementBridge svgfefuncelementbridge = (SVGFeFuncElementBridge)bridge;
            ComponentTransferFunction componenttransferfunction4 = svgfefuncelementbridge.createComponentTransferFunction(element, element2);
            if(svgfefuncelementbridge instanceof SVGFeFuncRElementBridge)
            {
                componenttransferfunction = componenttransferfunction4;
                continue;
            }
            if(svgfefuncelementbridge instanceof SVGFeFuncGElementBridge)
            {
                componenttransferfunction1 = componenttransferfunction4;
                continue;
            }
            if(svgfefuncelementbridge instanceof SVGFeFuncBElementBridge)
            {
                componenttransferfunction2 = componenttransferfunction4;
                continue;
            }
            if(svgfefuncelementbridge instanceof SVGFeFuncAElementBridge)
                componenttransferfunction3 = componenttransferfunction4;
        }

        Object obj = new ComponentTransferRable8Bit(filter1, componenttransferfunction3, componenttransferfunction, componenttransferfunction1, componenttransferfunction2);
        handleColorInterpolationFilters(((Filter) (obj)), element);
        obj = new PadRable8Bit(((Filter) (obj)), rectangle2d2, PadMode.ZERO_PAD);
        updateFilterMap(element, ((Filter) (obj)), map);
        return ((Filter) (obj));
    }
}
