// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import org.apache.batik.css.engine.CSSEngineEvent;
import org.apache.batik.dom.svg.SVGContext;
import org.apache.batik.dom.svg.SVGOMElement;
import org.w3c.dom.Element;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, GenericBridge, BridgeUpdateHandler, BridgeContext, 
//            UserAgent

public abstract class SVGDescriptiveElementBridge extends AbstractSVGBridge
    implements GenericBridge, BridgeUpdateHandler, SVGContext
{

    public SVGDescriptiveElementBridge()
    {
    }

    public void handleElement(BridgeContext bridgecontext, Element element)
    {
        UserAgent useragent = bridgecontext.getUserAgent();
        useragent.handleElement(element, Boolean.TRUE);
        if(bridgecontext.isDynamic())
        {
            SVGDescriptiveElementBridge svgdescriptiveelementbridge = (SVGDescriptiveElementBridge)getInstance();
            svgdescriptiveelementbridge.theElt = element;
            svgdescriptiveelementbridge.parent = (Element)element.getParentNode();
            svgdescriptiveelementbridge.theCtx = bridgecontext;
            ((SVGOMElement)element).setSVGContext(svgdescriptiveelementbridge);
        }
    }

    public void dispose()
    {
        UserAgent useragent = theCtx.getUserAgent();
        ((SVGOMElement)theElt).setSVGContext(null);
        useragent.handleElement(theElt, parent);
        theElt = null;
        parent = null;
    }

    public void handleDOMNodeInsertedEvent(MutationEvent mutationevent)
    {
        UserAgent useragent = theCtx.getUserAgent();
        useragent.handleElement(theElt, Boolean.TRUE);
    }

    public void handleDOMCharacterDataModified(MutationEvent mutationevent)
    {
        UserAgent useragent = theCtx.getUserAgent();
        useragent.handleElement(theElt, Boolean.TRUE);
    }

    public void handleDOMNodeRemovedEvent(MutationEvent mutationevent)
    {
        dispose();
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
    }

    public void handleCSSEngineEvent(CSSEngineEvent cssengineevent)
    {
    }

    public float getPixelUnitToMillimeter()
    {
        return theCtx.getUserAgent().getPixelUnitToMillimeter();
    }

    public float getPixelToMM()
    {
        return getPixelUnitToMillimeter();
    }

    public Rectangle2D getBBox()
    {
        return null;
    }

    public AffineTransform getScreenTransform()
    {
        return theCtx.getUserAgent().getTransform();
    }

    public void setScreenTransform(AffineTransform affinetransform)
    {
        theCtx.getUserAgent().setTransform(affinetransform);
    }

    public AffineTransform getCTM()
    {
        return null;
    }

    public AffineTransform getGlobalTransform()
    {
        return null;
    }

    public float getViewportWidth()
    {
        return theCtx.getBlockWidth(theElt);
    }

    public float getViewportHeight()
    {
        return theCtx.getBlockHeight(theElt);
    }

    public float getFontSize()
    {
        return 0.0F;
    }

    Element theElt;
    Element parent;
    BridgeContext theCtx;
}
