// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.util.StringTokenizer;
import org.apache.batik.parser.*;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, BridgeException

public abstract class ViewBox
    implements SVGConstants, ErrorConstants
{
    protected static class ViewHandler extends AWTTransformProducer
        implements FragmentIdentifierHandler
    {

        public void endTransformList()
            throws ParseException
        {
            super.endTransformList();
            hasTransform = true;
        }

        public void startFragmentIdentifier()
            throws ParseException
        {
        }

        public void idReference(String s)
            throws ParseException
        {
            id = s;
            hasId = true;
        }

        public void viewBox(float f, float f1, float f2, float f3)
            throws ParseException
        {
            hasViewBox = true;
            viewBox = new float[4];
            viewBox[0] = f;
            viewBox[1] = f1;
            viewBox[2] = f2;
            viewBox[3] = f3;
        }

        public void startViewTarget()
            throws ParseException
        {
        }

        public void viewTarget(String s)
            throws ParseException
        {
            viewTargetParams = s;
            hasViewTargetParams = true;
        }

        public void endViewTarget()
            throws ParseException
        {
        }

        public void zoomAndPan(boolean flag)
        {
            isMagnify = flag;
            hasZoomAndPanParams = true;
        }

        public void endFragmentIdentifier()
            throws ParseException
        {
        }

        public void startPreserveAspectRatio()
            throws ParseException
        {
        }

        public void none()
            throws ParseException
        {
            align = 1;
        }

        public void xMaxYMax()
            throws ParseException
        {
            align = 10;
        }

        public void xMaxYMid()
            throws ParseException
        {
            align = 7;
        }

        public void xMaxYMin()
            throws ParseException
        {
            align = 4;
        }

        public void xMidYMax()
            throws ParseException
        {
            align = 9;
        }

        public void xMidYMid()
            throws ParseException
        {
            align = 6;
        }

        public void xMidYMin()
            throws ParseException
        {
            align = 3;
        }

        public void xMinYMax()
            throws ParseException
        {
            align = 8;
        }

        public void xMinYMid()
            throws ParseException
        {
            align = 5;
        }

        public void xMinYMin()
            throws ParseException
        {
            align = 2;
        }

        public void meet()
            throws ParseException
        {
            meet = true;
        }

        public void slice()
            throws ParseException
        {
            meet = false;
        }

        public void endPreserveAspectRatio()
            throws ParseException
        {
            hasPreserveAspectRatio = true;
        }

        public boolean hasTransform;
        public boolean hasId;
        public boolean hasViewBox;
        public boolean hasViewTargetParams;
        public boolean hasZoomAndPanParams;
        public String id;
        public float viewBox[];
        public String viewTargetParams;
        public boolean isMagnify;
        public boolean hasPreserveAspectRatio;
        public short align;
        public boolean meet;

        protected ViewHandler()
        {
            meet = true;
        }
    }


    protected ViewBox()
    {
    }

    public static AffineTransform getViewTransform(String s, Element element, float f, float f1)
    {
        if(s == null || s.length() == 0)
            return getPreserveAspectRatioTransform(element, f, f1);
        ViewHandler viewhandler = new ViewHandler();
        FragmentIdentifierParser fragmentidentifierparser = new FragmentIdentifierParser();
        fragmentidentifierparser.setFragmentIdentifierHandler(viewhandler);
        fragmentidentifierparser.parse(s);
        Element element1 = element;
        if(viewhandler.hasId)
        {
            Document document = element.getOwnerDocument();
            element1 = document.getElementById(viewhandler.id);
        }
        if(element1 == null)
            throw new BridgeException(element, "uri.malformed", new Object[] {
                s
            });
        if(!element1.getNamespaceURI().equals("http://www.w3.org/2000/svg") || !element1.getLocalName().equals("view"))
            element1 = getClosestAncestorSVGElement(element);
        float af[];
        if(viewhandler.hasViewBox)
        {
            af = viewhandler.viewBox;
        } else
        {
            String s1 = element1.getAttributeNS(null, "viewBox");
            af = parseViewBoxAttribute(element1, s1);
        }
        short word0;
        boolean flag;
        if(viewhandler.hasPreserveAspectRatio)
        {
            word0 = viewhandler.align;
            flag = viewhandler.meet;
        } else
        {
            String s2 = element1.getAttributeNS(null, "preserveAspectRatio");
            PreserveAspectRatioParser preserveaspectratioparser = new PreserveAspectRatioParser();
            ViewHandler viewhandler1 = new ViewHandler();
            preserveaspectratioparser.setPreserveAspectRatioHandler(viewhandler1);
            try
            {
                preserveaspectratioparser.parse(s2);
            }
            catch(ParseException parseexception)
            {
                throw new BridgeException(element1, "attribute.malformed", new Object[] {
                    "preserveAspectRatio", s2, parseexception
                });
            }
            word0 = viewhandler1.align;
            flag = viewhandler1.meet;
        }
        AffineTransform affinetransform = getPreserveAspectRatioTransform(af, word0, flag, f, f1);
        if(viewhandler.hasTransform)
            affinetransform.concatenate(viewhandler.getAffineTransform());
        return affinetransform;
    }

    private static Element getClosestAncestorSVGElement(Element element)
    {
        for(Object obj = element; obj != null && ((Node) (obj)).getNodeType() == 1; obj = ((Node) (obj)).getParentNode())
        {
            Element element1 = (Element)obj;
            if(element1.getNamespaceURI().equals("http://www.w3.org/2000/svg") && element1.getLocalName().equals("svg"))
                return element1;
        }

        return null;
    }

    public static AffineTransform getPreserveAspectRatioTransform(Element element, float f, float f1)
    {
        String s = element.getAttributeNS(null, "viewBox");
        String s1 = element.getAttributeNS(null, "preserveAspectRatio");
        return getPreserveAspectRatioTransform(element, s, s1, f, f1);
    }

    public static AffineTransform getPreserveAspectRatioTransform(Element element, String s, String s1, float f, float f1)
    {
        if(s.length() == 0)
            return new AffineTransform();
        float af[] = parseViewBoxAttribute(element, s);
        PreserveAspectRatioParser preserveaspectratioparser = new PreserveAspectRatioParser();
        ViewHandler viewhandler = new ViewHandler();
        preserveaspectratioparser.setPreserveAspectRatioHandler(viewhandler);
        try
        {
            preserveaspectratioparser.parse(s1);
        }
        catch(ParseException parseexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "preserveAspectRatio", s1, parseexception
            });
        }
        return getPreserveAspectRatioTransform(af, viewhandler.align, viewhandler.meet, f, f1);
    }

    public static AffineTransform getPreserveAspectRatioTransform(Element element, float af[], float f, float f1)
    {
        String s = element.getAttributeNS(null, "preserveAspectRatio");
        PreserveAspectRatioParser preserveaspectratioparser = new PreserveAspectRatioParser();
        ViewHandler viewhandler = new ViewHandler();
        preserveaspectratioparser.setPreserveAspectRatioHandler(viewhandler);
        try
        {
            preserveaspectratioparser.parse(s);
        }
        catch(ParseException parseexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "preserveAspectRatio", s, parseexception
            });
        }
        return getPreserveAspectRatioTransform(af, viewhandler.align, viewhandler.meet, f, f1);
    }

    public static float[] parseViewBoxAttribute(Element element, String s)
    {
        if(s.length() == 0)
            return null;
        int i = 0;
        float af[] = new float[4];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        try
        {
            while(i < 4 && stringtokenizer.hasMoreTokens()) 
            {
                af[i] = Float.parseFloat(stringtokenizer.nextToken());
                i++;
            }
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "viewBox", s, numberformatexception
            });
        }
        if(i != 4)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "viewBox", s
            });
        if(af[2] < 0.0F || af[3] < 0.0F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "viewBox", s
            });
        if(af[2] == 0.0F || af[3] == 0.0F)
            return null;
        else
            return af;
    }

    public static AffineTransform getPreserveAspectRatioTransform(float af[], short word0, boolean flag, float f, float f1)
    {
        if(af == null)
            return new AffineTransform();
        AffineTransform affinetransform = new AffineTransform();
        float f2 = af[2] / af[3];
        float f3 = f / f1;
        if(word0 == 1)
        {
            affinetransform.scale(f / af[2], f1 / af[3]);
            affinetransform.translate(-af[0], -af[1]);
        } else
        if(f2 < f3 && flag || f2 >= f3 && !flag)
        {
            float f4 = f1 / af[3];
            affinetransform.scale(f4, f4);
            switch(word0)
            {
            case 2: // '\002'
            case 5: // '\005'
            case 8: // '\b'
                affinetransform.translate(-af[0], -af[1]);
                break;

            case 3: // '\003'
            case 6: // '\006'
            case 9: // '\t'
                affinetransform.translate(-af[0] - (af[2] - (f * af[3]) / f1) / 2.0F, -af[1]);
                break;

            case 4: // '\004'
            case 7: // '\007'
            default:
                affinetransform.translate(-af[0] - (af[2] - (f * af[3]) / f1), -af[1]);
                break;
            }
        } else
        {
            float f5 = f / af[2];
            affinetransform.scale(f5, f5);
            switch(word0)
            {
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                affinetransform.translate(-af[0], -af[1]);
                break;

            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
                affinetransform.translate(-af[0], -af[1] - (af[3] - (f1 * af[2]) / f) / 2.0F);
                break;

            default:
                affinetransform.translate(-af[0], -af[1] - (af[3] - (f1 * af[2]) / f));
                break;
            }
        }
        return affinetransform;
    }
}
