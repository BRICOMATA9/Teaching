// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.color.ICC_Profile;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Rectangle2D;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.SVGOMElement;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.color.ICCColorSpaceExt;
import org.apache.batik.ext.awt.image.renderable.ClipRable8Bit;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.spi.ImageTagRegistry;
import org.apache.batik.gvt.CanvasGraphicsNode;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.ImageNode;
import org.apache.batik.gvt.RasterImageNode;
import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.parser.UnitProcessor;
import org.apache.batik.util.MimeTypeConstants;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.events.MutationEvent;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractGraphicsNodeBridge, BridgeException, CSSUtilities, BridgeContext, 
//            UserAgent, DocumentLoader, UnitProcessor, ViewBox, 
//            GVTBuilder, SVGColorProfileElementBridge, SVGBrokenLinkProvider, Bridge

public class SVGImageElementBridge extends AbstractGraphicsNodeBridge
{
    protected static class ForwardEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            MouseEvent mouseevent = (MouseEvent)event;
            MouseEvent mouseevent1 = (MouseEvent)((DocumentEvent)imgElement.getOwnerDocument()).createEvent("MouseEvents");
            mouseevent1.initMouseEvent(mouseevent.getType(), mouseevent.getBubbles(), mouseevent.getCancelable(), mouseevent.getView(), mouseevent.getDetail(), mouseevent.getScreenX(), mouseevent.getScreenY(), mouseevent.getClientX(), mouseevent.getClientY(), mouseevent.getCtrlKey(), mouseevent.getAltKey(), mouseevent.getShiftKey(), mouseevent.getMetaKey(), mouseevent.getButton(), (EventTarget)imgElement);
            ((EventTarget)imgElement).dispatchEvent(mouseevent1);
        }

        protected Element svgElement;
        protected Element imgElement;

        public ForwardEventListener(Element element, Element element1)
        {
            svgElement = element;
            imgElement = element1;
        }
    }

    public static class ProtectedStream extends BufferedInputStream
    {

        public boolean markSupported()
        {
            return false;
        }

        public void mark(int i)
        {
        }

        public void reset()
            throws IOException
        {
            throw new IOException("Reset unsupported");
        }

        public void retry()
            throws IOException
        {
            super.reset();
        }

        public void close()
            throws IOException
        {
        }

        public void release()
        {
            try
            {
                super.close();
            }
            catch(IOException ioexception) { }
        }

        static final int BUFFER_SIZE = 8192;

        ProtectedStream(InputStream inputstream)
        {
            super(inputstream, 8192);
            super.mark(8192);
        }

        ProtectedStream(InputStream inputstream, int i)
        {
            super(inputstream, i);
            super.mark(i);
        }
    }


    public SVGImageElementBridge()
    {
        listener = null;
        subCtx = null;
        hitCheckChildren = false;
    }

    public String getLocalName()
    {
        return "image";
    }

    public Bridge getInstance()
    {
        return new SVGImageElementBridge();
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        ImageNode imagenode = (ImageNode)super.createGraphicsNode(bridgecontext, element);
        if(imagenode == null)
            return null;
        hitCheckChildren = false;
        GraphicsNode graphicsnode = buildImageGraphicsNode(bridgecontext, element);
        if(graphicsnode == null)
        {
            String s = XLinkSupport.getXLinkHref(element);
            throw new BridgeException(element, "uri.image.invalid", new Object[] {
                s
            });
        }
        imagenode.setImage(graphicsnode);
        imagenode.setHitCheckChildren(hitCheckChildren);
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertImageRendering(element, renderinghints);
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        if(renderinghints != null)
            imagenode.setRenderingHints(renderinghints);
        return imagenode;
    }

    protected GraphicsNode buildImageGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        String s = XLinkSupport.getXLinkHref(element);
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "xlink:href"
            });
        if(s.indexOf('#') != -1)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "xlink:href", s
            });
        String s1 = XMLBaseSupport.getCascadedXMLBase(element);
        ParsedURL parsedurl;
        if(s1 == null)
            parsedurl = new ParsedURL(s);
        else
            parsedurl = new ParsedURL(s1, s);
        return createImageGraphicsNode(bridgecontext, element, parsedurl);
    }

    protected GraphicsNode createImageGraphicsNode(BridgeContext bridgecontext, Element element, ParsedURL parsedurl)
    {
        DocumentLoader documentloader;
        ImageTagRegistry imagetagregistry;
        ICCColorSpaceExt icccolorspaceext;
        Rectangle2D rectangle2d = getImageBounds(bridgecontext, element);
        if(rectangle2d.getWidth() == 0.0D || rectangle2d.getHeight() == 0.0D)
        {
            ShapeNode shapenode = new ShapeNode();
            shapenode.setShape(rectangle2d);
            return shapenode;
        }
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        String s = svgdocument.getURL();
        ParsedURL parsedurl1 = null;
        if(s != null)
            parsedurl1 = new ParsedURL(s);
        UserAgent useragent = bridgecontext.getUserAgent();
        try
        {
            useragent.checkLoadExternalResource(parsedurl, parsedurl1);
        }
        catch(SecurityException securityexception)
        {
            throw new BridgeException(element, "uri.unsecure", new Object[] {
                parsedurl
            });
        }
        documentloader = bridgecontext.getDocumentLoader();
        imagetagregistry = ImageTagRegistry.getRegistry();
        icccolorspaceext = extractColorSpace(element, bridgecontext);
        org.w3c.dom.Document document = documentloader.checkCache(parsedurl.toString());
        if(document == null)
            break MISSING_BLOCK_LABEL_189;
        imgDocument = (SVGDocument)document;
        return createSVGImageNode(bridgecontext, element, imgDocument);
        Object obj;
        obj;
        throw obj;
        obj;
        Object obj1;
        obj1 = imagetagregistry.checkCache(parsedurl, icccolorspaceext);
        if(obj1 != null)
            return createRasterImageNode(bridgecontext, element, ((Filter) (obj1)));
        obj1 = null;
        try
        {
            obj1 = openStream(element, parsedurl);
        }
        catch(SecurityException securityexception1)
        {
            throw new BridgeException(element, "uri.unsecure", new Object[] {
                parsedurl
            });
        }
        catch(IOException ioexception)
        {
            return createBrokenImageNode(bridgecontext, element, parsedurl.toString());
        }
        Filter filter = imagetagregistry.readURL(((InputStream) (obj1)), parsedurl, icccolorspaceext, false, false);
        if(filter != null)
            return createRasterImageNode(bridgecontext, element, filter);
        try
        {
            ((ProtectedStream) (obj1)).retry();
        }
        catch(IOException ioexception1)
        {
            try
            {
                obj1 = openStream(element, parsedurl);
            }
            catch(IOException ioexception3)
            {
                return createBrokenImageNode(bridgecontext, element, parsedurl.toString());
            }
        }
        org.w3c.dom.Document document1 = documentloader.loadDocument(parsedurl.toString(), ((InputStream) (obj1)));
        imgDocument = (SVGDocument)document1;
        return createSVGImageNode(bridgecontext, element, imgDocument);
        Object obj2;
        obj2;
        throw obj2;
        obj2;
        throw new BridgeException(element, "uri.unsecure", new Object[] {
            parsedurl
        });
        obj2;
        try
        {
            ((ProtectedStream) (obj1)).retry();
        }
        catch(IOException ioexception2)
        {
            try
            {
                obj1 = openStream(element, parsedurl);
            }
            catch(IOException ioexception4)
            {
                return createBrokenImageNode(bridgecontext, element, parsedurl.toString());
            }
        }
        GraphicsNode graphicsnode;
        Filter filter1 = imagetagregistry.readURL(((InputStream) (obj1)), parsedurl, icccolorspaceext, true, true);
        if(filter1 == null)
            break MISSING_BLOCK_LABEL_455;
        graphicsnode = createRasterImageNode(bridgecontext, element, filter1);
        ((ProtectedStream) (obj1)).release();
        return graphicsnode;
        ((ProtectedStream) (obj1)).release();
        break MISSING_BLOCK_LABEL_473;
        Exception exception;
        exception;
        ((ProtectedStream) (obj1)).release();
        throw exception;
        return null;
    }

    protected ProtectedStream openStream(Element element, ParsedURL parsedurl)
        throws IOException
    {
        ArrayList arraylist = new ArrayList(ImageTagRegistry.getRegistry().getRegisteredMimeTypes());
        arraylist.add(MimeTypeConstants.MIME_TYPES_SVG);
        InputStream inputstream = parsedurl.openStream(arraylist.iterator());
        return new ProtectedStream(inputstream);
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return new ImageNode();
    }

    public boolean isComposite()
    {
        return false;
    }

    protected void initializeDynamicSupport(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        if(!bridgecontext.isInteractive())
            return;
        ImageNode imagenode = (ImageNode)graphicsnode;
        bridgecontext.bind(element, graphicsnode);
        if(bridgecontext.isDynamic())
        {
            e = element;
            node = graphicsnode;
            ctx = bridgecontext;
            ((SVGOMElement)element).setSVGContext(this);
        }
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        Node node = mutationevent.getRelatedNode();
        if(s.equals("x") || s.equals("y") || s.equals("preserveAspectRatio"))
            updateImageBounds();
        else
        if("http://www.w3.org/1999/xlink".equals(node.getNamespaceURI()) && "href".equals(node.getLocalName()))
            rebuildImageNode();
        else
        if(s.equals("width") || s.equals("height"))
        {
            float f = 0.0F;
            float f1 = 0.0F;
            String s1 = mutationevent.getPrevValue();
            org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(ctx, e);
            if(s1.length() != 0)
                f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s1, s, context);
            s1 = mutationevent.getNewValue();
            if(s1.length() != 0)
                f1 = UnitProcessor.svgHorizontalCoordinateToUserSpace(s1, s, context);
            if(f == f1)
                return;
            if(f == 0.0F || f1 == 0.0F)
                rebuildImageNode();
            else
                updateImageBounds();
        } else
        {
            super.handleDOMAttrModifiedEvent(mutationevent);
        }
    }

    protected void updateImageBounds()
    {
        Rectangle2D rectangle2d = getImageBounds(ctx, e);
        GraphicsNode graphicsnode = ((ImageNode)node).getImage();
        float af[] = null;
        if(graphicsnode instanceof RasterImageNode)
        {
            Rectangle2D rectangle2d1 = ((RasterImageNode)graphicsnode).getImageBounds();
            af = new float[4];
            af[0] = 0.0F;
            af[1] = 0.0F;
            af[2] = (float)rectangle2d1.getWidth();
            af[3] = (float)rectangle2d1.getHeight();
        } else
        if(imgDocument != null)
        {
            SVGSVGElement svgsvgelement = imgDocument.getRootElement();
            String s = svgsvgelement.getAttributeNS(null, "viewBox");
            af = ViewBox.parseViewBoxAttribute(e, s);
        }
        if(graphicsnode != null)
            initializeViewport(ctx, e, graphicsnode, af, rectangle2d);
    }

    protected void rebuildImageNode()
    {
        if(imgDocument != null && listener != null)
        {
            SVGSVGElement svgsvgelement = imgDocument.getRootElement();
            svgsvgelement.removeEventListener("click", listener, false);
            svgsvgelement.removeEventListener("keydown", listener, false);
            svgsvgelement.removeEventListener("keypress", listener, false);
            svgsvgelement.removeEventListener("keyup", listener, false);
            svgsvgelement.removeEventListener("mousedown", listener, false);
            svgsvgelement.removeEventListener("mousemove", listener, false);
            svgsvgelement.removeEventListener("mouseout", listener, false);
            svgsvgelement.removeEventListener("mouseover", listener, false);
            svgsvgelement.removeEventListener("mouseup", listener, false);
            listener = null;
        }
        if(imgDocument != null)
        {
            SVGSVGElement svgsvgelement1 = imgDocument.getRootElement();
            disposeTree(svgsvgelement1);
        }
        imgDocument = null;
        subCtx = null;
        GraphicsNode graphicsnode = buildImageGraphicsNode(ctx, e);
        ImageNode imagenode = (ImageNode)node;
        imagenode.setImage(graphicsnode);
        if(graphicsnode == null)
        {
            String s = XLinkSupport.getXLinkHref(e);
            throw new BridgeException(e, "uri.image.invalid", new Object[] {
                s
            });
        } else
        {
            return;
        }
    }

    protected void handleCSSPropertyChanged(int i)
    {
        switch(i)
        {
        case 6: // '\006'
        case 30: // '\036'
            java.awt.RenderingHints renderinghints = CSSUtilities.convertImageRendering(e, null);
            renderinghints = CSSUtilities.convertColorRendering(e, renderinghints);
            if(renderinghints != null)
                node.setRenderingHints(renderinghints);
            break;

        default:
            super.handleCSSPropertyChanged(i);
            break;
        }
    }

    protected GraphicsNode createRasterImageNode(BridgeContext bridgecontext, Element element, Filter filter)
    {
        Rectangle2D rectangle2d = getImageBounds(bridgecontext, element);
        if(rectangle2d.getWidth() == 0.0D || rectangle2d.getHeight() == 0.0D)
        {
            ShapeNode shapenode = new ShapeNode();
            shapenode.setShape(rectangle2d);
            return shapenode;
        }
        Object obj = filter.getProperty("org.apache.batik.bridge.BrokenLinkDocument");
        if(obj != null && (obj instanceof SVGDocument))
        {
            SVGOMDocument svgomdocument = (SVGOMDocument)obj;
            return createSVGImageNode(bridgecontext, element, svgomdocument);
        } else
        {
            RasterImageNode rasterimagenode = new RasterImageNode();
            rasterimagenode.setImage(filter);
            Rectangle2D rectangle2d1 = filter.getBounds2D();
            float af[] = new float[4];
            af[0] = 0.0F;
            af[1] = 0.0F;
            af[2] = (float)rectangle2d1.getWidth();
            af[3] = (float)rectangle2d1.getHeight();
            initializeViewport(bridgecontext, element, rasterimagenode, af, rectangle2d);
            return rasterimagenode;
        }
    }

    protected GraphicsNode createSVGImageNode(BridgeContext bridgecontext, Element element, SVGDocument svgdocument)
    {
        CSSEngine cssengine = ((SVGOMDocument)svgdocument).getCSSEngine();
        if(cssengine != null)
        {
            subCtx = (BridgeContext)cssengine.getCSSContext();
        } else
        {
            subCtx = new BridgeContext(bridgecontext.getUserAgent(), bridgecontext.getDocumentLoader());
            subCtx.setGVTBuilder(bridgecontext.getGVTBuilder());
            subCtx.setDocument(svgdocument);
            subCtx.initializeDocument(svgdocument);
        }
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        Rectangle2D rectangle2d = getImageBounds(bridgecontext, element);
        if(rectangle2d.getWidth() == 0.0D || rectangle2d.getHeight() == 0.0D)
        {
            ShapeNode shapenode = new ShapeNode();
            shapenode.setShape(rectangle2d);
            compositegraphicsnode.getChildren().add(shapenode);
            return compositegraphicsnode;
        }
        Rectangle2D rectangle2d1 = CSSUtilities.convertEnableBackground(element);
        if(rectangle2d1 != null)
            compositegraphicsnode.setBackgroundEnable(rectangle2d1);
        SVGSVGElement svgsvgelement = svgdocument.getRootElement();
        CanvasGraphicsNode canvasgraphicsnode = (CanvasGraphicsNode)subCtx.getGVTBuilder().build(subCtx, svgsvgelement);
        if(cssengine == null)
            subCtx.addUIEventListeners(svgdocument);
        canvasgraphicsnode.setClip(null);
        canvasgraphicsnode.setViewingTransform(new AffineTransform());
        compositegraphicsnode.getChildren().add(canvasgraphicsnode);
        String s = svgsvgelement.getAttributeNS(null, "viewBox");
        float af[] = ViewBox.parseViewBoxAttribute(element, s);
        initializeViewport(bridgecontext, element, compositegraphicsnode, af, rectangle2d);
        if(bridgecontext.isInteractive())
        {
            listener = new ForwardEventListener(svgsvgelement, element);
            SVGSVGElement svgsvgelement1 = svgsvgelement;
            svgsvgelement1.addEventListener("click", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "click", listener, false);
            svgsvgelement1.addEventListener("keydown", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "keydown", listener, false);
            svgsvgelement1.addEventListener("keypress", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "keypress", listener, false);
            svgsvgelement1.addEventListener("keyup", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "keyup", listener, false);
            svgsvgelement1.addEventListener("mousedown", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "mousedown", listener, false);
            svgsvgelement1.addEventListener("mousemove", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "mousemove", listener, false);
            svgsvgelement1.addEventListener("mouseout", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "mouseout", listener, false);
            svgsvgelement1.addEventListener("mouseover", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "mouseover", listener, false);
            svgsvgelement1.addEventListener("mouseup", listener, false);
            subCtx.storeEventListener(svgsvgelement1, "mouseup", listener, false);
        }
        return compositegraphicsnode;
    }

    public void dispose()
    {
        if(imgDocument != null && listener != null)
        {
            SVGSVGElement svgsvgelement = imgDocument.getRootElement();
            svgsvgelement.removeEventListener("click", listener, false);
            svgsvgelement.removeEventListener("keydown", listener, false);
            svgsvgelement.removeEventListener("keypress", listener, false);
            svgsvgelement.removeEventListener("keyup", listener, false);
            svgsvgelement.removeEventListener("mousedown", listener, false);
            svgsvgelement.removeEventListener("mousemove", listener, false);
            svgsvgelement.removeEventListener("mouseout", listener, false);
            svgsvgelement.removeEventListener("mouseover", listener, false);
            svgsvgelement.removeEventListener("mouseup", listener, false);
            listener = null;
        }
        if(imgDocument != null)
        {
            SVGSVGElement svgsvgelement1 = imgDocument.getRootElement();
            disposeTree(svgsvgelement1);
            imgDocument = null;
            subCtx = null;
        }
        super.dispose();
    }

    protected static void initializeViewport(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode, float af[], Rectangle2D rectangle2d)
    {
        float f = (float)rectangle2d.getX();
        float f1 = (float)rectangle2d.getY();
        float f2 = (float)rectangle2d.getWidth();
        float f3 = (float)rectangle2d.getHeight();
        AffineTransform affinetransform = ViewBox.getPreserveAspectRatioTransform(element, af, f2, f3);
        affinetransform.preConcatenate(AffineTransform.getTranslateInstance(f, f1));
        graphicsnode.setTransform(affinetransform);
        Object obj = null;
        if(CSSUtilities.convertOverflow(element))
        {
            float af1[] = CSSUtilities.convertClip(element);
            if(af1 == null)
                obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
            else
                obj = new java.awt.geom.Rectangle2D.Float(f + af1[3], f1 + af1[0], f2 - af1[1] - af1[3], f3 - af1[2] - af1[0]);
        }
        if(obj != null)
            try
            {
                affinetransform = affinetransform.createInverse();
                Filter filter = graphicsnode.getGraphicsNodeRable(true);
                obj = affinetransform.createTransformedShape(((java.awt.Shape) (obj)));
                graphicsnode.setClip(new ClipRable8Bit(filter, ((java.awt.Shape) (obj))));
            }
            catch(NoninvertibleTransformException noninvertibletransformexception) { }
    }

    protected static ICCColorSpaceExt extractColorSpace(Element element, BridgeContext bridgecontext)
    {
        String s = CSSUtilities.getComputedStyle(element, 8).getStringValue();
        ICCColorSpaceExt icccolorspaceext = null;
        if("srgb".equalsIgnoreCase(s))
            icccolorspaceext = new ICCColorSpaceExt(ICC_Profile.getInstance(1000), 4);
        else
        if(!"auto".equalsIgnoreCase(s) && !"".equalsIgnoreCase(s))
        {
            SVGColorProfileElementBridge svgcolorprofileelementbridge = (SVGColorProfileElementBridge)bridgecontext.getBridge("http://www.w3.org/2000/svg", "color-profile");
            if(svgcolorprofileelementbridge != null)
                icccolorspaceext = svgcolorprofileelementbridge.createICCColorSpaceExt(bridgecontext, element, s);
        }
        return icccolorspaceext;
    }

    protected static Rectangle2D getImageBounds(BridgeContext bridgecontext, Element element)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        String s = element.getAttributeNS(null, "x");
        float f = 0.0F;
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x", context);
        s = element.getAttributeNS(null, "y");
        float f1 = 0.0F;
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y", context);
        s = element.getAttributeNS(null, "width");
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "width"
            });
        float f2 = UnitProcessor.svgHorizontalLengthToUserSpace(s, "width", context);
        s = element.getAttributeNS(null, "height");
        if(s.length() == 0)
        {
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "height"
            });
        } else
        {
            float f3 = UnitProcessor.svgVerticalLengthToUserSpace(s, "height", context);
            return new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
        }
    }

    GraphicsNode createBrokenImageNode(BridgeContext bridgecontext, Element element, String s)
    {
        String s1 = "<Unknown Element>";
        SVGDocument svgdocument = null;
        if(element != null)
        {
            svgdocument = (SVGDocument)element.getOwnerDocument();
            s1 = element.getLocalName();
        }
        String s2;
        if(svgdocument == null)
            s2 = "<Unknown Document>";
        else
            s2 = svgdocument.getURL();
        int i = bridgecontext.getDocumentLoader().getLineNumber(element);
        Object aobj[] = new Object[4];
        aobj[0] = s2;
        aobj[1] = new Integer(i);
        aobj[2] = s1;
        aobj[3] = s;
        SVGDocument svgdocument1 = brokenLinkProvider.getBrokenLinkDocument(this, "uri.io", aobj);
        hitCheckChildren = true;
        return createSVGImageNode(bridgecontext, element, svgdocument1);
    }

    protected SVGDocument imgDocument;
    protected EventListener listener;
    protected BridgeContext subCtx;
    protected boolean hitCheckChildren;
    static SVGBrokenLinkProvider brokenLinkProvider;

    static 
    {
        brokenLinkProvider = new SVGBrokenLinkProvider();
        ImageTagRegistry.setBrokenLinkProvider(brokenLinkProvider);
    }
}
