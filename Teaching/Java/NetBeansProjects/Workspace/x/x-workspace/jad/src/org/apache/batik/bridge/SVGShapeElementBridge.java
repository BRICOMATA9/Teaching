// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.css.engine.CSSEngineEvent;
import org.apache.batik.gvt.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractGraphicsNodeBridge, CSSUtilities, PaintServer, BridgeContext

public abstract class SVGShapeElementBridge extends AbstractGraphicsNodeBridge
{

    protected SVGShapeElementBridge()
    {
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        ShapeNode shapenode = (ShapeNode)super.createGraphicsNode(bridgecontext, element);
        if(shapenode == null)
            return null;
        buildShape(bridgecontext, element, shapenode);
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        renderinghints = CSSUtilities.convertShapeRendering(element, renderinghints);
        if(renderinghints != null)
            shapenode.setRenderingHints(renderinghints);
        return shapenode;
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return new ShapeNode();
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        ShapeNode shapenode = (ShapeNode)graphicsnode;
        shapenode.setShapePainter(createShapePainter(bridgecontext, element, shapenode));
        super.buildGraphicsNode(bridgecontext, element, graphicsnode);
    }

    protected ShapePainter createShapePainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        return PaintServer.convertFillAndStroke(element, shapenode, bridgecontext);
    }

    protected abstract void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode);

    public boolean isComposite()
    {
        return false;
    }

    protected void handleGeometryChanged()
    {
        super.handleGeometryChanged();
        ShapeNode shapenode = (ShapeNode)node;
        shapenode.setShapePainter(createShapePainter(ctx, e, shapenode));
    }

    public void handleCSSEngineEvent(CSSEngineEvent cssengineevent)
    {
        hasNewShapePainter = false;
        super.handleCSSEngineEvent(cssengineevent);
    }

    protected void handleCSSPropertyChanged(int i)
    {
        switch(i)
        {
        case 15: // '\017'
        case 16: // '\020'
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
            if(!hasNewShapePainter)
            {
                hasNewShapePainter = true;
                ShapeNode shapenode = (ShapeNode)node;
                shapenode.setShapePainter(createShapePainter(ctx, e, shapenode));
            }
            break;

        case 42: // '*'
            java.awt.RenderingHints renderinghints = node.getRenderingHints();
            renderinghints = CSSUtilities.convertShapeRendering(e, renderinghints);
            if(renderinghints != null)
                node.setRenderingHints(renderinghints);
            break;

        case 9: // '\t'
            java.awt.RenderingHints renderinghints1 = node.getRenderingHints();
            renderinghints1 = CSSUtilities.convertColorRendering(e, renderinghints1);
            if(renderinghints1 != null)
                node.setRenderingHints(renderinghints1);
            break;

        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 43: // '+'
        case 44: // ','
        default:
            super.handleCSSPropertyChanged(i);
            break;
        }
    }

    protected boolean hasNewShapePainter;
}
