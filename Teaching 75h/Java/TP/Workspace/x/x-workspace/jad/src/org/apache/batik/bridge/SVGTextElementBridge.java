// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Shape;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import org.apache.batik.css.engine.CSSEngineEvent;
import org.apache.batik.css.engine.CSSStylableElement;
import org.apache.batik.css.engine.StyleMap;
import org.apache.batik.css.engine.value.ListValue;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.svg.SVGContext;
import org.apache.batik.dom.svg.SVGOMElement;
import org.apache.batik.dom.svg.SVGTextContent;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.dom.util.XMLSupport;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.TextNode;
import org.apache.batik.gvt.font.GVTGlyphMetrics;
import org.apache.batik.gvt.font.GVTGlyphVector;
import org.apache.batik.gvt.renderer.StrokingTextPainter;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.gvt.text.TextHit;
import org.apache.batik.gvt.text.TextPaintInfo;
import org.apache.batik.gvt.text.TextPath;
import org.apache.batik.gvt.text.TextSpanLayout;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractGraphicsNodeBridge, SVGAElementBridge, BridgeContext, CSSUtilities, 
//            UnitProcessor, SVGUtilities, SVGTextPathElementBridge, TextUtilities, 
//            SVGAltGlyphHandler, SVGFontUtilities, SVGFontFamily, PaintServer, 
//            UserAgent, Bridge, BridgeUpdateHandler

public class SVGTextElementBridge extends AbstractGraphicsNodeBridge
    implements SVGTextContent
{
    protected static class CharacterInformation
    {

        public boolean isVertical()
        {
            return layout.isVertical();
        }

        public double getComputedOrientationAngle()
        {
            return layout.getComputedOrientationAngle(characterIndex);
        }

        TextSpanLayout layout;
        int glyphIndexStart;
        int glyphIndexEnd;
        int characterIndex;

        protected CharacterInformation()
        {
        }
    }

    protected class TspanBridge extends AbstractTextChildTextContent
    {

        public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
        {
            String s = mutationevent.getAttrName();
            if(s.equals("x") || s.equals("y") || s.equals("dx") || s.equals("dy") || s.equals("rotate"))
                textBridge.computeLaidoutText(ctx, textBridge.e, textBridge.node);
        }

        public TspanBridge(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            super(bridgecontext, svgtextelementbridge1, element);
        }
    }

    protected class TextPathBridge extends AbstractTextChildTextContent
    {

        public TextPathBridge(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            super(bridgecontext, svgtextelementbridge1, element);
        }
    }

    protected class TRefBridge extends AbstractTextChildTextContent
    {

        public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
        {
            String s = mutationevent.getAttrName();
            if(s.equals("x") || s.equals("y") || s.equals("dx") || s.equals("dy") || s.equals("rotate"))
                textBridge.computeLaidoutText(ctx, textBridge.e, textBridge.node);
        }

        public TRefBridge(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            super(bridgecontext, svgtextelementbridge1, element);
        }
    }

    protected class AbstractTextChildTextContent extends AbstractTextChildBridgeUpdateHandler
        implements SVGTextContent
    {

        public int getNumberOfChars()
        {
            return textBridge.getNumberOfChars(e);
        }

        public Rectangle2D getExtentOfChar(int i)
        {
            return textBridge.getExtentOfChar(e, i);
        }

        public Point2D getStartPositionOfChar(int i)
        {
            return textBridge.getStartPositionOfChar(e, i);
        }

        public Point2D getEndPositionOfChar(int i)
        {
            return textBridge.getEndPositionOfChar(e, i);
        }

        public void selectSubString(int i, int j)
        {
            textBridge.selectSubString(e, i, j);
        }

        public float getRotationOfChar(int i)
        {
            return textBridge.getRotationOfChar(e, i);
        }

        public float getComputedTextLength()
        {
            return textBridge.getComputedTextLength(e);
        }

        public float getSubStringLength(int i, int j)
        {
            return textBridge.getSubStringLength(e, i, j);
        }

        public int getCharNumAtPosition(float f, float f1)
        {
            return textBridge.getCharNumAtPosition(e, f, f1);
        }

        public AbstractTextChildTextContent(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            super(bridgecontext, svgtextelementbridge1, element);
        }
    }

    protected abstract class AbstractTextChildBridgeUpdateHandler extends AbstractTextChildSVGContext
        implements BridgeUpdateHandler
    {

        public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
        {
        }

        public void handleDOMNodeInsertedEvent(MutationEvent mutationevent)
        {
            textBridge.handleDOMNodeInsertedEvent(mutationevent);
        }

        public void handleDOMNodeRemovedEvent(MutationEvent mutationevent)
        {
            dispose();
        }

        public void handleDOMCharacterDataModified(MutationEvent mutationevent)
        {
            textBridge.handleDOMCharacterDataModified(mutationevent);
        }

        public void handleCSSEngineEvent(CSSEngineEvent cssengineevent)
        {
            textBridge.handleCSSEngineEvent(cssengineevent);
        }

        public void dispose()
        {
            ((SVGOMElement)e).setSVGContext(null);
            elemTPI.remove(e);
        }

        public AbstractTextChildBridgeUpdateHandler(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            super(bridgecontext, svgtextelementbridge1, element);
        }
    }

    public abstract class AbstractTextChildSVGContext
        implements SVGContext
    {

        public SVGTextElementBridge getTextBridge()
        {
            return textBridge;
        }

        public float getPixelUnitToMillimeter()
        {
            return ctx.getUserAgent().getPixelUnitToMillimeter();
        }

        public float getPixelToMM()
        {
            return getPixelUnitToMillimeter();
        }

        public Rectangle2D getBBox()
        {
            return null;
        }

        public AffineTransform getCTM()
        {
            return null;
        }

        public AffineTransform getGlobalTransform()
        {
            return null;
        }

        public AffineTransform getScreenTransform()
        {
            return null;
        }

        public void setScreenTransform(AffineTransform affinetransform)
        {
        }

        public float getViewportWidth()
        {
            return ctx.getBlockWidth(e);
        }

        public float getViewportHeight()
        {
            return ctx.getBlockHeight(e);
        }

        public float getFontSize()
        {
            return CSSUtilities.getComputedStyle(e, 22).getFloatValue();
        }

        protected BridgeContext ctx;
        protected SVGTextElementBridge textBridge;
        protected Element e;

        public AbstractTextChildSVGContext(BridgeContext bridgecontext, SVGTextElementBridge svgtextelementbridge1, Element element)
        {
            ctx = bridgecontext;
            textBridge = svgtextelementbridge1;
            e = element;
        }
    }

    protected static class AttributedStringBuffer
    {

        public boolean isEmpty()
        {
            return count == 0;
        }

        public int length()
        {
            return length;
        }

        public void append(String s, Map map)
        {
            if(s.length() == 0)
            {
                return;
            } else
            {
                strings.add(s);
                attributes.add(map);
                count++;
                length += s.length();
                return;
            }
        }

        public int getLastChar()
        {
            if(count == 0)
            {
                return -1;
            } else
            {
                String s = (String)strings.get(count - 1);
                return s.charAt(s.length() - 1);
            }
        }

        public void stripFirst()
        {
            String s = (String)strings.get(0);
            if(s.charAt(s.length() - 1) != ' ')
                return;
            length--;
            if(s.length() == 1)
            {
                attributes.remove(0);
                strings.remove(0);
                count--;
                return;
            } else
            {
                strings.set(0, s.substring(1));
                return;
            }
        }

        public void stripLast()
        {
            String s = (String)strings.get(count - 1);
            if(s.charAt(s.length() - 1) != ' ')
                return;
            length--;
            if(s.length() == 1)
            {
                attributes.remove(--count);
                strings.remove(count);
                return;
            } else
            {
                strings.set(count - 1, s.substring(0, s.length() - 1));
                return;
            }
        }

        public AttributedString toAttributedString()
        {
            switch(count)
            {
            case 0: // '\0'
                return new AttributedString(" ");

            case 1: // '\001'
                return new AttributedString((String)strings.get(0), (Map)attributes.get(0));
            }
            StringBuffer stringbuffer = new StringBuffer();
            for(Iterator iterator = strings.iterator(); iterator.hasNext(); stringbuffer.append((String)iterator.next()));
            AttributedString attributedstring = new AttributedString(stringbuffer.toString());
            Iterator iterator1 = strings.iterator();
            Iterator iterator2 = attributes.iterator();
            int j;
            for(int i = 0; iterator1.hasNext(); i = j)
            {
                String s = (String)iterator1.next();
                j = i + s.length();
                Map map = (Map)iterator2.next();
                Iterator iterator3 = map.keySet().iterator();
                Iterator iterator4 = map.values().iterator();
                java.text.AttributedCharacterIterator.Attribute attribute;
                Object obj;
                for(; iterator3.hasNext(); attributedstring.addAttribute(attribute, obj, i, j))
                {
                    attribute = (java.text.AttributedCharacterIterator.Attribute)iterator3.next();
                    obj = iterator4.next();
                }

            }

            return attributedstring;
        }

        public String toString()
        {
            switch(count)
            {
            case 0: // '\0'
                return "";

            case 1: // '\001'
                return (String)strings.get(0);
            }
            StringBuffer stringbuffer = new StringBuffer();
            for(Iterator iterator = strings.iterator(); iterator.hasNext(); stringbuffer.append((String)iterator.next()));
            return stringbuffer.toString();
        }

        protected java.util.List strings;
        protected java.util.List attributes;
        protected int count;
        protected int length;

        public AttributedStringBuffer()
        {
            strings = new ArrayList();
            attributes = new ArrayList();
            count = 0;
            length = 0;
        }
    }

    protected class DOMSubtreeModifiedEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            handleDOMSubtreeModifiedEvent((MutationEvent)event);
        }

        protected DOMSubtreeModifiedEventListener()
        {
        }
    }

    protected class DOMChildNodeRemovedEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            handleDOMChildNodeRemovedEvent((MutationEvent)event);
        }

        protected DOMChildNodeRemovedEventListener()
        {
        }
    }


    public SVGTextElementBridge()
    {
        elemTPI = new WeakHashMap();
        usingComplexSVGFont = false;
        childNodeRemovedEventListener = new DOMChildNodeRemovedEventListener();
        subtreeModifiedEventListener = new DOMSubtreeModifiedEventListener();
    }

    public String getLocalName()
    {
        return "text";
    }

    public Bridge getInstance()
    {
        return new SVGTextElementBridge();
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        TextNode textnode = (TextNode)super.createGraphicsNode(bridgecontext, element);
        if(textnode == null)
            return null;
        if(bridgecontext.getTextPainter() != null)
            textnode.setTextPainter(bridgecontext.getTextPainter());
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        renderinghints = CSSUtilities.convertTextRendering(element, renderinghints);
        if(renderinghints != null)
            textnode.setRenderingHints(renderinghints);
        textnode.setLocation(getLocation(bridgecontext, element));
        return textnode;
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return new TextNode();
    }

    protected Point2D getLocation(BridgeContext bridgecontext, Element element)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        String s = element.getAttributeNS(null, "x");
        float f = 0.0F;
        if(s.length() != 0)
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, ", ", false);
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(stringtokenizer.nextToken(), "x", context);
        }
        s = element.getAttributeNS(null, "y");
        float f1 = 0.0F;
        if(s.length() != 0)
        {
            StringTokenizer stringtokenizer1 = new StringTokenizer(s, ", ", false);
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(stringtokenizer1.nextToken(), "y", context);
        }
        return new java.awt.geom.Point2D.Float(f, f1);
    }

    protected boolean isTextElement(Element element)
    {
        if(!"http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
        {
            return false;
        } else
        {
            String s = element.getLocalName();
            return s.equals("text") || s.equals("tspan") || s.equals("altGlyph") || s.equals("a") || s.equals("textPath") || s.equals("tref");
        }
    }

    protected boolean isTextChild(Element element)
    {
        if(!"http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
        {
            return false;
        } else
        {
            String s = element.getLocalName();
            return s.equals("tspan") || s.equals("altGlyph") || s.equals("a") || s.equals("textPath") || s.equals("tref");
        }
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        element.normalize();
        computeLaidoutText(bridgecontext, element, graphicsnode);
        graphicsnode.setComposite(CSSUtilities.convertOpacity(element));
        graphicsnode.setFilter(CSSUtilities.convertFilter(element, graphicsnode, bridgecontext));
        graphicsnode.setMask(CSSUtilities.convertMask(element, graphicsnode, bridgecontext));
        graphicsnode.setClip(CSSUtilities.convertClipPath(element, graphicsnode, bridgecontext));
        graphicsnode.setPointerEventType(CSSUtilities.convertPointerEvents(element));
        initializeDynamicSupport(bridgecontext, element, graphicsnode);
    }

    public boolean isComposite()
    {
        return false;
    }

    protected void initializeDynamicSupport(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        super.initializeDynamicSupport(bridgecontext, element, graphicsnode);
        if(!bridgecontext.isDynamic())
            return;
        EventTarget eventtarget = (EventTarget)element;
        eventtarget.addEventListener("DOMNodeRemoved", childNodeRemovedEventListener, true);
        bridgecontext.storeEventListener(eventtarget, "DOMNodeRemoved", childNodeRemovedEventListener, true);
        eventtarget.addEventListener("DOMSubtreeModified", subtreeModifiedEventListener, false);
        bridgecontext.storeEventListener(eventtarget, "DOMSubtreeModified", subtreeModifiedEventListener, false);
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1)
                addContextToChild(bridgecontext, (Element)node);

    }

    protected void addContextToChild(BridgeContext bridgecontext, Element element)
    {
        if("http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
            if(element.getLocalName().equals("tspan"))
                ((SVGOMElement)element).setSVGContext(new TspanBridge(bridgecontext, this, element));
            else
            if(element.getLocalName().equals("textPath"))
                ((SVGOMElement)element).setSVGContext(new TextPathBridge(bridgecontext, this, element));
            else
            if(element.getLocalName().equals("tref"))
                ((SVGOMElement)element).setSVGContext(new TRefBridge(bridgecontext, this, element));
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1)
                addContextToChild(bridgecontext, (Element)node);

    }

    public void handleDOMNodeInsertedEvent(MutationEvent mutationevent)
    {
        Node node = (Node)mutationevent.getTarget();
        switch(node.getNodeType())
        {
        case 3: // '\003'
        case 4: // '\004'
            laidoutText = null;
            break;

        case 1: // '\001'
            Element element = (Element)node;
            if(isTextChild(element))
            {
                addContextToChild(ctx, element);
                laidoutText = null;
            }
            break;
        }
        if(laidoutText == null)
            computeLaidoutText(ctx, e, this.node);
    }

    public void handleDOMNodeRemovedEvent(MutationEvent mutationevent)
    {
        EventTarget eventtarget = mutationevent.getTarget();
        eventtarget.removeEventListener("DOMNodeRemoved", childNodeRemovedEventListener, true);
        eventtarget.removeEventListener("DOMSubtreeModified", subtreeModifiedEventListener, false);
        super.handleDOMNodeRemovedEvent(mutationevent);
    }

    public void handleDOMChildNodeRemovedEvent(MutationEvent mutationevent)
    {
        Node node = (Node)mutationevent.getTarget();
        switch(node.getNodeType())
        {
        case 2: // '\002'
        default:
            break;

        case 3: // '\003'
        case 4: // '\004'
            if(isParentDisplayed(node))
                laidoutText = null;
            break;

        case 1: // '\001'
            if(isTextChild((Element)node))
                laidoutText = null;
            break;
        }
    }

    public void handleDOMSubtreeModifiedEvent(MutationEvent mutationevent)
    {
        if(laidoutText == null)
            computeLaidoutText(ctx, e, node);
    }

    public void handleDOMCharacterDataModified(MutationEvent mutationevent)
    {
        Node node = (Node)mutationevent.getTarget();
        if(isParentDisplayed(node))
            laidoutText = null;
    }

    protected boolean isParentDisplayed(Node node)
    {
        Node node1 = node.getParentNode();
        return isTextElement((Element)node1);
    }

    protected void computeLaidoutText(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        AttributedString attributedstring = buildAttributedString(bridgecontext, element);
        addGlyphPositionAttributes(attributedstring, element, bridgecontext);
        if(bridgecontext.isDynamic())
            laidoutText = new AttributedString(attributedstring.getIterator());
        TextNode textnode = (TextNode)graphicsnode;
        elemTPI.clear();
        addNullPaintAttributes(attributedstring, element, bridgecontext);
        textnode.setAttributedCharacterIterator(attributedstring.getIterator());
        TextPaintInfo textpaintinfo = new TextPaintInfo();
        setBaseTextPaintInfo(textpaintinfo, element, graphicsnode, bridgecontext);
        setDecorationTextPaintInfo(textpaintinfo, element);
        addPaintAttributes(attributedstring, element, textnode, textpaintinfo, bridgecontext);
        if(usingComplexSVGFont)
            textnode.setAttributedCharacterIterator(attributedstring.getIterator());
    }

    protected void addNullPaintAttributes(AttributedString attributedstring, Element element, BridgeContext bridgecontext)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()) || !CSSUtilities.convertDisplay(element))
            return;
        AttributedCharacterIterator attributedcharacteriterator = attributedstring.getIterator();
        int i = getElementStartIndex(attributedcharacteriterator, element);
        if(i == -1)
        {
            return;
        } else
        {
            int j = getElementEndIndex(attributedcharacteriterator, element);
            TextPaintInfo textpaintinfo = new TextPaintInfo();
            textpaintinfo.visible = true;
            textpaintinfo.fillPaint = Color.black;
            attributedstring.addAttribute(PAINT_INFO, textpaintinfo, i, j + 1);
            elemTPI.put(element, textpaintinfo);
            addChildNullPaintAttributes(attributedstring, element, bridgecontext);
            return;
        }
    }

    protected void addChildNullPaintAttributes(AttributedString attributedstring, Element element, BridgeContext bridgecontext)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            if(isTextChild(element1))
                addNullPaintAttributes(attributedstring, element1, bridgecontext);
        }

    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("x") || s.equals("y") || s.equals("dx") || s.equals("dy") || s.equals("rotate"))
        {
            if(s.equals("x") || s.equals("y"))
                ((TextNode)node).setLocation(getLocation(ctx, e));
            computeLaidoutText(ctx, e, node);
        } else
        {
            super.handleDOMAttrModifiedEvent(mutationevent);
        }
    }

    public void handleCSSEngineEvent(CSSEngineEvent cssengineevent)
    {
        hasNewACI = false;
        int ai[] = cssengineevent.getProperties();
        for(int i = 0; i < ai.length; i++)
            switch(ai[i])
            {
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
            case 18: // '\022'
            case 19: // '\023'
            case 20: // '\024'
            case 23: // '\027'
            case 26: // '\032'
            case 30: // '\036'
            case 33: // '!'
            case 34: // '"'
            case 35: // '#'
            case 36: // '$'
            case 37: // '%'
            case 38: // '&'
            case 39: // '\''
            case 40: // '('
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 54: // '6'
            case 55: // '7'
            case 57: // '9'
            default:
                break;

            case 1: // '\001'
            case 11: // '\013'
            case 12: // '\f'
            case 21: // '\025'
            case 22: // '\026'
            case 24: // '\030'
            case 25: // '\031'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            case 31: // '\037'
            case 32: // ' '
            case 53: // '5'
            case 56: // '8'
            case 58: // ':'
            case 59: // ';'
                if(!hasNewACI)
                {
                    hasNewACI = true;
                    computeLaidoutText(ctx, e, node);
                }
                break;
            }

        cssProceedElement = cssengineevent.getElement();
        super.handleCSSEngineEvent(cssengineevent);
        cssProceedElement = null;
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
        case 54: // '6'
            rebuildACI();
            break;

        case 57: // '9'
            rebuildACI();
            super.handleCSSPropertyChanged(i);
            break;

        case 55: // '7'
            java.awt.RenderingHints renderinghints = node.getRenderingHints();
            renderinghints = CSSUtilities.convertTextRendering(e, renderinghints);
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
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 53: // '5'
        case 56: // '8'
        default:
            super.handleCSSPropertyChanged(i);
            break;
        }
    }

    protected void rebuildACI()
    {
        if(hasNewACI)
            return;
        TextNode textnode = (TextNode)node;
        TextPaintInfo textpaintinfo;
        TextPaintInfo textpaintinfo1;
        if(cssProceedElement == e)
        {
            textpaintinfo = new TextPaintInfo();
            setBaseTextPaintInfo(textpaintinfo, e, node, ctx);
            setDecorationTextPaintInfo(textpaintinfo, e);
            textpaintinfo1 = (TextPaintInfo)elemTPI.get(e);
        } else
        {
            TextPaintInfo textpaintinfo2 = getParentTextPaintInfo(textnode.getAttributedCharacterIterator(), cssProceedElement);
            textpaintinfo = getTextPaintInfo(cssProceedElement, textnode, textpaintinfo2, ctx);
            textpaintinfo1 = (TextPaintInfo)elemTPI.get(cssProceedElement);
        }
        if(textpaintinfo1 == null)
            return;
        textnode.swapTextPaintInfo(textpaintinfo, textpaintinfo1);
        if(usingComplexSVGFont)
            textnode.setAttributedCharacterIterator(textnode.getAttributedCharacterIterator());
    }

    int getElementStartIndex(AttributedCharacterIterator attributedcharacteriterator, Element element)
    {
        for(int i = 0; i < attributedcharacteriterator.getEndIndex(); i = attributedcharacteriterator.getRunLimit(TEXT_COMPOUND_DELIMITER))
        {
            attributedcharacteriterator.setIndex(i);
            Element element1 = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element1 == element || nodeAncestorOf(element, element1))
                return i;
        }

        return -1;
    }

    int getElementEndIndex(AttributedCharacterIterator attributedcharacteriterator, Element element)
    {
        for(int i = attributedcharacteriterator.getEndIndex() - 1; i >= 0; i = attributedcharacteriterator.getRunStart(TEXT_COMPOUND_DELIMITER) - 1)
        {
            attributedcharacteriterator.setIndex(i);
            Element element1 = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element1 == element || nodeAncestorOf(element, element1))
                return i;
        }

        return -1;
    }

    protected AttributedString buildAttributedString(BridgeContext bridgecontext, Element element)
    {
        AttributedStringBuffer attributedstringbuffer = new AttributedStringBuffer();
        fillAttributedStringBuffer(bridgecontext, element, true, null, null, attributedstringbuffer);
        return attributedstringbuffer.toAttributedString();
    }

    protected void fillAttributedStringBuffer(BridgeContext bridgecontext, Element element, boolean flag, TextPath textpath, Integer integer, AttributedStringBuffer attributedstringbuffer)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()) || !CSSUtilities.convertDisplay(element))
            return;
        String s = XMLSupport.getXMLSpace(element);
        boolean flag1 = s.equals("preserve");
        Element element1 = element;
        if(flag)
            endLimit = 0;
        if(flag1)
            endLimit = attributedstringbuffer.length();
        Map map = getAttributeMap(bridgecontext, element, textpath, integer);
        Object obj = map.get(TextAttribute.BIDI_EMBEDDING);
        Integer integer1 = integer;
        if(obj != null)
            integer1 = (Integer)obj;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            boolean flag2;
            if(flag1)
                flag2 = false;
            else
            if(attributedstringbuffer.length() == 0)
                flag2 = true;
            else
                flag2 = attributedstringbuffer.getLastChar() == 32;
            switch(node.getNodeType())
            {
            case 2: // '\002'
            default:
                break;

            case 1: // '\001'
                if("http://www.w3.org/2000/svg".equals(node.getNamespaceURI()))
                {
                    Element element2 = (Element)node;
                    String s3 = node.getLocalName();
                    if(s3.equals("tspan") || s3.equals("altGlyph"))
                        fillAttributedStringBuffer(bridgecontext, element2, false, textpath, integer1, attributedstringbuffer);
                    else
                    if(s3.equals("textPath"))
                    {
                        SVGTextPathElementBridge svgtextpathelementbridge = (SVGTextPathElementBridge)bridgecontext.getBridge(element2);
                        TextPath textpath1 = svgtextpathelementbridge.createTextPath(bridgecontext, element2);
                        if(textpath1 != null)
                            fillAttributedStringBuffer(bridgecontext, element2, false, textpath1, integer1, attributedstringbuffer);
                    } else
                    if(s3.equals("tref"))
                    {
                        String s4 = XLinkSupport.getXLinkHref((Element)node);
                        Element element3 = bridgecontext.getReferencedElement((Element)node, s4);
                        String s1 = TextUtilities.getElementContent(element3);
                        s1 = normalizeString(s1, flag1, flag2);
                        if(s1 != null)
                        {
                            Map map1 = getAttributeMap(bridgecontext, element2, textpath, integer);
                            attributedstringbuffer.append(s1, map1);
                        }
                    } else
                    if(s3.equals("a"))
                    {
                        EventTarget eventtarget = (EventTarget)element2;
                        UserAgent useragent = bridgecontext.getUserAgent();
                        SVGAElementBridge.AnchorListener anchorlistener = new SVGAElementBridge.AnchorListener(useragent);
                        eventtarget.addEventListener("click", anchorlistener, false);
                        bridgecontext.storeEventListener(eventtarget, "click", anchorlistener, false);
                        fillAttributedStringBuffer(bridgecontext, element2, false, textpath, integer1, attributedstringbuffer);
                    }
                }
                break;

            case 3: // '\003'
            case 4: // '\004'
                String s2 = node.getNodeValue();
                s2 = normalizeString(s2, flag1, flag2);
                attributedstringbuffer.append(s2, map);
                if(flag1)
                    endLimit = attributedstringbuffer.length();
                break;
            }
        }

        if(flag)
            for(; endLimit < attributedstringbuffer.length() && attributedstringbuffer.getLastChar() == 32; attributedstringbuffer.stripLast());
    }

    protected String normalizeString(String s, boolean flag, boolean flag1)
    {
        StringBuffer stringbuffer = new StringBuffer(s.length());
        if(flag)
        {
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                switch(c)
                {
                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                    stringbuffer.append(' ');
                    break;

                case 11: // '\013'
                case 12: // '\f'
                default:
                    stringbuffer.append(c);
                    break;
                }
            }

            return stringbuffer.toString();
        }
        int j = 0;
        if(flag1)
label0:
            do
            {
                if(j >= s.length())
                    break;
                switch(s.charAt(j))
                {
                default:
                    break label0;

                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    j++;
                    break;
                }
            } while(true);
        boolean flag2 = false;
        for(int k = j; k < s.length(); k++)
        {
            char c1 = s.charAt(k);
            switch(c1)
            {
            case 10: // '\n'
            case 13: // '\r'
                break;

            case 9: // '\t'
            case 32: // ' '
                if(!flag2)
                {
                    stringbuffer.append(' ');
                    flag2 = true;
                }
                break;

            default:
                stringbuffer.append(c1);
                flag2 = false;
                break;
            }
        }

        return stringbuffer.toString();
    }

    protected boolean nodeAncestorOf(Node node, Node node1)
    {
        if(node1 == null || node == null)
            return false;
        Node node2;
        for(node2 = node1.getParentNode(); node2 != null && node2 != node; node2 = node2.getParentNode());
        return node2 == node;
    }

    protected void addGlyphPositionAttributes(AttributedString attributedstring, Element element, BridgeContext bridgecontext)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()) || !CSSUtilities.convertDisplay(element))
            return;
        if(element.getLocalName().equals("textPath"))
        {
            addChildGlyphPositionAttributes(attributedstring, element, bridgecontext);
            return;
        }
        AttributedCharacterIterator attributedcharacteriterator = attributedstring.getIterator();
        int i = getElementStartIndex(attributedcharacteriterator, element);
        if(i == -1)
            return;
        int j = getElementEndIndex(attributedcharacteriterator, element);
        String s = element.getAttributeNS(null, "x");
        String s1 = element.getAttributeNS(null, "y");
        String s2 = element.getAttributeNS(null, "dx");
        String s3 = element.getAttributeNS(null, "dy");
        String s4 = element.getAttributeNS(null, "rotate");
        if(s.length() != 0)
        {
            ArrayList arraylist = TextUtilities.svgHorizontalCoordinateArrayToUserSpace(element, "x", s, bridgecontext);
            int k = arraylist.size();
            for(int l1 = 0; l1 < k; l1++)
                if(i + l1 <= j)
                    attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.X, arraylist.get(l1), i + l1, i + l1 + 1);

        }
        if(s1.length() != 0)
        {
            ArrayList arraylist1 = TextUtilities.svgVerticalCoordinateArrayToUserSpace(element, "y", s1, bridgecontext);
            int l = arraylist1.size();
            for(int i2 = 0; i2 < l; i2++)
                if(i + i2 <= j)
                    attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.Y, arraylist1.get(i2), i + i2, i + i2 + 1);

        }
        if(s2.length() != 0)
        {
            ArrayList arraylist2 = TextUtilities.svgHorizontalCoordinateArrayToUserSpace(element, "dx", s2, bridgecontext);
            int i1 = arraylist2.size();
            for(int j2 = 0; j2 < i1; j2++)
                if(i + j2 <= j)
                    attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.DX, arraylist2.get(j2), i + j2, i + j2 + 1);

        }
        if(s3.length() != 0)
        {
            ArrayList arraylist3 = TextUtilities.svgVerticalCoordinateArrayToUserSpace(element, "dy", s3, bridgecontext);
            int j1 = arraylist3.size();
            for(int k2 = 0; k2 < j1; k2++)
                if(i + k2 <= j)
                    attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.DY, arraylist3.get(k2), i + k2, i + k2 + 1);

        }
        if(s4.length() != 0)
        {
            ArrayList arraylist4 = TextUtilities.svgRotateArrayToFloats(element, "rotate", s4, bridgecontext);
            int k1 = arraylist4.size();
            if(k1 == 1)
            {
                attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ROTATION, arraylist4.get(0), i, j + 1);
            } else
            {
                for(int l2 = 0; l2 < k1; l2++)
                    if(i + l2 <= j)
                        attributedstring.addAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ROTATION, arraylist4.get(l2), i + l2, i + l2 + 1);

            }
        }
        addChildGlyphPositionAttributes(attributedstring, element, bridgecontext);
    }

    protected void addChildGlyphPositionAttributes(AttributedString attributedstring, Element element, BridgeContext bridgecontext)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            if(isTextChild(element1))
                addGlyphPositionAttributes(attributedstring, element1, bridgecontext);
        }

    }

    protected void addPaintAttributes(AttributedString attributedstring, Element element, TextNode textnode, TextPaintInfo textpaintinfo, BridgeContext bridgecontext)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()) || !CSSUtilities.convertDisplay(element))
            return;
        Object obj = elemTPI.get(element);
        if(obj == null)
        {
            return;
        } else
        {
            textnode.swapTextPaintInfo(textpaintinfo, (TextPaintInfo)obj);
            addChildPaintAttributes(attributedstring, element, textnode, textpaintinfo, bridgecontext);
            return;
        }
    }

    protected void addChildPaintAttributes(AttributedString attributedstring, Element element, TextNode textnode, TextPaintInfo textpaintinfo, BridgeContext bridgecontext)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            if(isTextChild(element1))
            {
                TextPaintInfo textpaintinfo1 = getTextPaintInfo(element1, textnode, textpaintinfo, bridgecontext);
                addPaintAttributes(attributedstring, element1, textnode, textpaintinfo1, bridgecontext);
            }
        }

    }

    protected Map getFontProperties(BridgeContext bridgecontext, Element element, Map map)
    {
        if(map == null)
            map = new HashMap(4);
        map.put(TEXT_COMPOUND_DELIMITER, element);
        map.put(TextAttribute.SIZE, TextUtilities.convertFontSize(element));
        map.put(TextAttribute.WIDTH, TextUtilities.convertFontStretch(element));
        map.put(TextAttribute.WEIGHT, TextUtilities.convertFontWeight(element));
        map.put(TextAttribute.POSTURE, TextUtilities.convertFontStyle(element));
        return map;
    }

    protected Map getAttributeMap(BridgeContext bridgecontext, Element element, TextPath textpath, Integer integer)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        HashMap hashmap = new HashMap();
        if("http://www.w3.org/2000/svg".equals(element.getNamespaceURI()) && element.getLocalName().equals("altGlyph"))
            hashmap.put(ALT_GLYPH_HANDLER, new SVGAltGlyphHandler(bridgecontext, element));
        if(textpath != null)
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.TEXTPATH, textpath);
        org.apache.batik.gvt.TextNode.Anchor anchor = TextUtilities.convertTextAnchor(element);
        hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ANCHOR_TYPE, anchor);
        getFontProperties(bridgecontext, element, hashmap);
        java.util.List list = getFontFamilyList(element, bridgecontext);
        hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.GVT_FONT_FAMILIES, list);
        Object obj = TextUtilities.convertBaselineShift(element);
        if(obj != null)
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.BASELINE_SHIFT, obj);
        Value value = CSSUtilities.getComputedStyle(element, 56);
        String s = value.getStringValue();
        if(s.charAt(0) == 'n')
        {
            if(integer != null)
                hashmap.put(TextAttribute.BIDI_EMBEDDING, integer);
        } else
        {
            value = CSSUtilities.getComputedStyle(element, 11);
            String s1 = value.getStringValue();
            int i = 0;
            if(integer != null)
                i = integer.intValue();
            if(i < 0)
                i = -i;
            switch(s1.charAt(0))
            {
            case 108: // 'l'
                hashmap.put(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_LTR);
                if((i & 1) == 1)
                    i++;
                else
                    i += 2;
                break;

            case 114: // 'r'
                hashmap.put(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_RTL);
                if((i & 1) == 1)
                    i += 2;
                else
                    i++;
                break;
            }
            switch(s.charAt(0))
            {
            case 98: // 'b'
                i = -i;
                // fall through

            default:
                hashmap.put(TextAttribute.BIDI_EMBEDDING, new Integer(i));
                break;
            }
        }
        value = CSSUtilities.getComputedStyle(element, 59);
        s = value.getStringValue();
        switch(s.charAt(0))
        {
        case 108: // 'l'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE_LTR);
            break;

        case 114: // 'r'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE_RTL);
            break;

        case 116: // 't'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WRITING_MODE_TTB);
            break;
        }
        value = CSSUtilities.getComputedStyle(element, 29);
        switch(value.getPrimitiveType())
        {
        case 21: // '\025'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ORIENTATION_AUTO);
            break;

        case 11: // '\013'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ORIENTATION_ANGLE);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION_ANGLE, new Float(value.getFloatValue()));
            break;

        case 12: // '\f'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ORIENTATION_ANGLE);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION_ANGLE, new Float((double)(value.getFloatValue() * 180F) / 3.1415926535897931D));
            break;

        case 13: // '\r'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ORIENTATION_ANGLE);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.VERTICAL_ORIENTATION_ANGLE, new Float((value.getFloatValue() * 9F) / 5F));
            break;

        default:
            throw new InternalError();
        }
        value = CSSUtilities.getComputedStyle(element, 28);
        switch(value.getPrimitiveType())
        {
        case 11: // '\013'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.HORIZONTAL_ORIENTATION_ANGLE, new Float(value.getFloatValue()));
            break;

        case 12: // '\f'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.HORIZONTAL_ORIENTATION_ANGLE, new Float((double)(value.getFloatValue() * 180F) / 3.1415926535897931D));
            break;

        case 13: // '\r'
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.HORIZONTAL_ORIENTATION_ANGLE, new Float((value.getFloatValue() * 9F) / 5F));
            break;

        default:
            throw new InternalError();
        }
        Float float1 = TextUtilities.convertLetterSpacing(element);
        if(float1 != null)
        {
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.LETTER_SPACING, float1);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.CUSTOM_SPACING, Boolean.TRUE);
        }
        float1 = TextUtilities.convertWordSpacing(element);
        if(float1 != null)
        {
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.WORD_SPACING, float1);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.CUSTOM_SPACING, Boolean.TRUE);
        }
        float1 = TextUtilities.convertKerning(element);
        if(float1 != null)
        {
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.KERNING, float1);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.CUSTOM_SPACING, Boolean.TRUE);
        }
        s = element.getAttributeNS(null, "textLength");
        if(s.length() != 0)
        {
            float f = UnitProcessor.svgOtherLengthToUserSpace(s, "textLength", context);
            hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.BBOX_WIDTH, new Float(f));
            s = element.getAttributeNS(null, "lengthAdjust");
            if(s.length() < 10)
            {
                hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.LENGTH_ADJUST, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ADJUST_SPACING);
                hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.CUSTOM_SPACING, Boolean.TRUE);
            } else
            {
                hashmap.put(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.LENGTH_ADJUST, org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ADJUST_ALL);
            }
        }
        return hashmap;
    }

    protected java.util.List getFontFamilyList(Element element, BridgeContext bridgecontext)
    {
        Value value = CSSUtilities.getComputedStyle(element, 27);
        String s = value.getCssText();
        String s1 = CSSUtilities.getComputedStyle(element, 25).getStringValue();
        Value value1 = CSSUtilities.getComputedStyle(element, 21);
        ArrayList arraylist = new ArrayList();
        int i = value1.getLength();
        for(int j = 0; j < i; j++)
        {
            Value value2 = value1.item(j);
            String s2 = value2.getStringValue();
            org.apache.batik.gvt.font.GVTFontFamily gvtfontfamily = SVGFontUtilities.getFontFamily(element, bridgecontext, s2, s, s1);
            if(gvtfontfamily instanceof SVGFontFamily)
            {
                SVGFontFamily svgfontfamily = (SVGFontFamily)gvtfontfamily;
                if(svgfontfamily.isComplex())
                    usingComplexSVGFont = true;
            }
            arraylist.add(gvtfontfamily);
        }

        return arraylist;
    }

    protected TextPaintInfo getParentTextPaintInfo(AttributedCharacterIterator attributedcharacteriterator, Element element)
    {
        Object obj = null;
        int i = -1;
        int j = 0;
        do
        {
            if(j >= attributedcharacteriterator.getEndIndex())
                break;
            attributedcharacteriterator.setIndex(j);
            Element element1 = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(nodeAncestorOf(element1, element) && (obj == null || nodeAncestorOf(((Node) (obj)), element1)))
            {
                obj = element1;
                i = j;
            }
            if(element1 == element || nodeAncestorOf(element, element1))
                break;
            j = attributedcharacteriterator.getRunLimit(TEXT_COMPOUND_DELIMITER);
        } while(true);
        if(obj == null)
        {
            return new TextPaintInfo();
        } else
        {
            attributedcharacteriterator.setIndex(i);
            return (TextPaintInfo)attributedcharacteriterator.getAttribute(PAINT_INFO);
        }
    }

    protected TextPaintInfo getTextPaintInfo(Element element, GraphicsNode graphicsnode, TextPaintInfo textpaintinfo, BridgeContext bridgecontext)
    {
        Value value = CSSUtilities.getComputedStyle(element, 54);
        TextPaintInfo textpaintinfo1 = new TextPaintInfo(textpaintinfo);
        StyleMap stylemap = ((CSSStylableElement)element).getComputedStyleMap(null);
        if(stylemap.isNullCascaded(54) && stylemap.isNullCascaded(15) && stylemap.isNullCascaded(45) && stylemap.isNullCascaded(52) && stylemap.isNullCascaded(38))
            return textpaintinfo1;
        setBaseTextPaintInfo(textpaintinfo1, element, graphicsnode, bridgecontext);
        if(!stylemap.isNullCascaded(54))
            setDecorationTextPaintInfo(textpaintinfo1, element);
        return textpaintinfo1;
    }

    public void setBaseTextPaintInfo(TextPaintInfo textpaintinfo, Element element, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        if(!element.getLocalName().equals("text"))
            textpaintinfo.composite = CSSUtilities.convertOpacity(element);
        else
            textpaintinfo.composite = AlphaComposite.SrcOver;
        textpaintinfo.visible = CSSUtilities.convertVisibility(element);
        textpaintinfo.fillPaint = PaintServer.convertFillPaint(element, graphicsnode, bridgecontext);
        textpaintinfo.strokePaint = PaintServer.convertStrokePaint(element, graphicsnode, bridgecontext);
        textpaintinfo.strokeStroke = PaintServer.convertStroke(element);
    }

    public void setDecorationTextPaintInfo(TextPaintInfo textpaintinfo, Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 54);
        switch(value.getCssValueType())
        {
        case 2: // '\002'
            ListValue listvalue = (ListValue)value;
            int i = listvalue.getLength();
            for(int j = 0; j < i; j++)
            {
                Value value1 = listvalue.item(j);
                String s = value1.getStringValue();
                switch(s.charAt(0))
                {
                default:
                    break;

                case 117: // 'u'
                    if(textpaintinfo.fillPaint != null)
                        textpaintinfo.underlinePaint = textpaintinfo.fillPaint;
                    if(textpaintinfo.strokePaint != null)
                        textpaintinfo.underlineStrokePaint = textpaintinfo.strokePaint;
                    if(textpaintinfo.strokeStroke != null)
                        textpaintinfo.underlineStroke = textpaintinfo.strokeStroke;
                    break;

                case 111: // 'o'
                    if(textpaintinfo.fillPaint != null)
                        textpaintinfo.overlinePaint = textpaintinfo.fillPaint;
                    if(textpaintinfo.strokePaint != null)
                        textpaintinfo.overlineStrokePaint = textpaintinfo.strokePaint;
                    if(textpaintinfo.strokeStroke != null)
                        textpaintinfo.overlineStroke = textpaintinfo.strokeStroke;
                    break;

                case 108: // 'l'
                    if(textpaintinfo.fillPaint != null)
                        textpaintinfo.strikethroughPaint = textpaintinfo.fillPaint;
                    if(textpaintinfo.strokePaint != null)
                        textpaintinfo.strikethroughStrokePaint = textpaintinfo.strokePaint;
                    if(textpaintinfo.strokeStroke != null)
                        textpaintinfo.strikethroughStroke = textpaintinfo.strokeStroke;
                    break;
                }
            }

            break;

        default:
            textpaintinfo.underlinePaint = null;
            textpaintinfo.underlineStrokePaint = null;
            textpaintinfo.underlineStroke = null;
            textpaintinfo.overlinePaint = null;
            textpaintinfo.overlineStrokePaint = null;
            textpaintinfo.overlineStroke = null;
            textpaintinfo.strikethroughPaint = null;
            textpaintinfo.strikethroughStrokePaint = null;
            textpaintinfo.strikethroughStroke = null;
            break;
        }
    }

    public int getNumberOfChars()
    {
        return getNumberOfChars(e);
    }

    public Rectangle2D getExtentOfChar(int i)
    {
        return getExtentOfChar(e, i);
    }

    public Point2D getStartPositionOfChar(int i)
    {
        return getStartPositionOfChar(e, i);
    }

    public Point2D getEndPositionOfChar(int i)
    {
        return getEndPositionOfChar(e, i);
    }

    public void selectSubString(int i, int j)
    {
        selectSubString(e, i, j);
    }

    public float getRotationOfChar(int i)
    {
        return getRotationOfChar(e, i);
    }

    public float getComputedTextLength()
    {
        return getComputedTextLength(e);
    }

    public float getSubStringLength(int i, int j)
    {
        return getSubStringLength(e, i, j);
    }

    public int getCharNumAtPosition(float f, float f1)
    {
        return getCharNumAtPosition(e, f, f1);
    }

    protected int getNumberOfChars(Element element)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int i = getElementStartIndex(attributedcharacteriterator, element);
        if(i == -1)
        {
            return 0;
        } else
        {
            int j = getElementEndIndex(attributedcharacteriterator, element);
            return (j - i) + 1;
        }
    }

    protected Rectangle2D getExtentOfChar(Element element, int i)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int j = getElementStartIndex(attributedcharacteriterator, element);
        if(j == -1)
            return null;
        java.util.List list = getTextRuns((TextNode)node);
        CharacterInformation characterinformation = getCharacterInformation(list, j, i, attributedcharacteriterator);
        if(characterinformation == null)
            return null;
        GVTGlyphVector gvtglyphvector = characterinformation.layout.getGlyphVector();
        Object obj = null;
        if(characterinformation.glyphIndexStart == characterinformation.glyphIndexEnd)
        {
            if(gvtglyphvector.isGlyphVisible(characterinformation.glyphIndexStart))
                obj = gvtglyphvector.getGlyphOutline(characterinformation.glyphIndexStart);
        } else
        {
            GeneralPath generalpath = null;
            for(int k = characterinformation.glyphIndexStart; k <= characterinformation.glyphIndexEnd; k++)
            {
                if(!gvtglyphvector.isGlyphVisible(k))
                    continue;
                if(generalpath == null)
                    generalpath = new GeneralPath(gvtglyphvector.getGlyphOutline(k));
                else
                    generalpath.append(gvtglyphvector.getGlyphOutline(k), false);
            }

            obj = generalpath;
        }
        if(obj == null)
            return null;
        else
            return ((Shape) (obj)).getBounds2D();
    }

    protected Point2D getStartPositionOfChar(Element element, int i)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int j = getElementStartIndex(attributedcharacteriterator, element);
        if(j == -1)
            return null;
        java.util.List list = getTextRuns((TextNode)node);
        CharacterInformation characterinformation = getCharacterInformation(list, j, i, attributedcharacteriterator);
        if(characterinformation == null)
            return null;
        else
            return getStartPoint(characterinformation);
    }

    protected Point2D getStartPoint(CharacterInformation characterinformation)
    {
        GVTGlyphVector gvtglyphvector = characterinformation.layout.getGlyphVector();
        if(!gvtglyphvector.isGlyphVisible(characterinformation.glyphIndexStart))
            return null;
        Point2D point2d = gvtglyphvector.getGlyphPosition(characterinformation.glyphIndexStart);
        AffineTransform affinetransform = gvtglyphvector.getGlyphTransform(characterinformation.glyphIndexStart);
        java.awt.geom.Point2D.Float float1 = new java.awt.geom.Point2D.Float(0.0F, 0.0F);
        if(affinetransform != null)
            affinetransform.transform(float1, float1);
        float1.x += point2d.getX();
        float1.y += point2d.getY();
        return float1;
    }

    protected Point2D getEndPositionOfChar(Element element, int i)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int j = getElementStartIndex(attributedcharacteriterator, element);
        if(j == -1)
            return null;
        java.util.List list = getTextRuns((TextNode)node);
        CharacterInformation characterinformation = getCharacterInformation(list, j, i, attributedcharacteriterator);
        if(characterinformation == null)
            return null;
        else
            return getEndPoint(characterinformation);
    }

    protected Point2D getEndPoint(CharacterInformation characterinformation)
    {
        GVTGlyphVector gvtglyphvector = characterinformation.layout.getGlyphVector();
        if(!gvtglyphvector.isGlyphVisible(characterinformation.glyphIndexEnd))
            return null;
        Point2D point2d = gvtglyphvector.getGlyphPosition(characterinformation.glyphIndexEnd);
        AffineTransform affinetransform = gvtglyphvector.getGlyphTransform(characterinformation.glyphIndexEnd);
        GVTGlyphMetrics gvtglyphmetrics = gvtglyphvector.getGlyphMetrics(characterinformation.glyphIndexEnd);
        java.awt.geom.Point2D.Float float1 = new java.awt.geom.Point2D.Float(gvtglyphmetrics.getHorizontalAdvance(), 0.0F);
        if(affinetransform != null)
            affinetransform.transform(float1, float1);
        float1.x += point2d.getX();
        float1.y += point2d.getY();
        return float1;
    }

    protected float getRotationOfChar(Element element, int i)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int j = getElementStartIndex(attributedcharacteriterator, element);
        if(j == -1)
            return 0.0F;
        java.util.List list = getTextRuns((TextNode)node);
        CharacterInformation characterinformation = getCharacterInformation(list, j, i, attributedcharacteriterator);
        double d = 0.0D;
        int k = 0;
        if(characterinformation != null)
        {
            GVTGlyphVector gvtglyphvector = characterinformation.layout.getGlyphVector();
            for(int l = characterinformation.glyphIndexStart; l <= characterinformation.glyphIndexEnd; l++)
            {
                if(!gvtglyphvector.isGlyphVisible(l))
                    continue;
                k++;
                AffineTransform affinetransform = gvtglyphvector.getGlyphTransform(l);
                if(affinetransform == null)
                    continue;
                double d1 = 0.0D;
                double d2 = affinetransform.getScaleX();
                double d3 = affinetransform.getShearX();
                if(d2 == 0.0D)
                {
                    if(d3 > 0.0D)
                        d1 = 3.1415926535897931D;
                    else
                        d1 = -3.1415926535897931D;
                } else
                {
                    d1 = Math.atan(d3 / d2);
                    if(d2 < 0.0D)
                        d1 += 3.1415926535897931D;
                }
                d1 = Math.toDegrees(-d1) % 360D;
                d += d1 - characterinformation.getComputedOrientationAngle();
            }

        }
        if(k == 0)
            return 0.0F;
        else
            return (float)(d / (double)k);
    }

    protected float getComputedTextLength(Element element)
    {
        return getSubStringLength(element, 0, getNumberOfChars(element));
    }

    protected float getSubStringLength(Element element, int i, int j)
    {
        if(j == 0)
            return 0.0F;
        float f = 0.0F;
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        TextNode textnode = (TextNode)node;
        int k = getElementStartIndex(attributedcharacteriterator, element);
        if(k == -1)
            return -1F;
        java.util.List list = getTextRuns(textnode);
        CharacterInformation characterinformation = getCharacterInformation(list, k, i, attributedcharacteriterator);
        CharacterInformation characterinformation1 = null;
        int l = characterinformation.characterIndex + 1;
        GVTGlyphVector gvtglyphvector = characterinformation.layout.getGlyphVector();
        float af[] = characterinformation.layout.getGlyphAdvances();
        boolean aflag[] = new boolean[af.length];
        for(int i1 = i + 1; i1 < i + j; i1++)
        {
            if(characterinformation.layout.isOnATextPath())
            {
                for(int k1 = characterinformation.glyphIndexStart; k1 <= characterinformation.glyphIndexEnd; k1++)
                {
                    if(gvtglyphvector.isGlyphVisible(k1) && !aflag[k1])
                        f += af[k1 + 1] - af[k1];
                    aflag[k1] = true;
                }

                CharacterInformation characterinformation2 = getCharacterInformation(list, k, i1, attributedcharacteriterator);
                if(characterinformation2.layout != characterinformation.layout)
                {
                    gvtglyphvector = characterinformation2.layout.getGlyphVector();
                    af = characterinformation2.layout.getGlyphAdvances();
                    aflag = new boolean[af.length];
                    l = characterinformation.characterIndex + 1;
                }
                characterinformation = characterinformation2;
                continue;
            }
            if(characterinformation.layout.hasCharacterIndex(l))
            {
                l++;
            } else
            {
                characterinformation1 = getCharacterInformation(list, k, i1 - 1, attributedcharacteriterator);
                f += distanceFirstLastCharacterInRun(characterinformation, characterinformation1);
                characterinformation = getCharacterInformation(list, k, i1, attributedcharacteriterator);
                l = characterinformation.characterIndex + 1;
                gvtglyphvector = characterinformation.layout.getGlyphVector();
                af = characterinformation.layout.getGlyphAdvances();
                aflag = new boolean[af.length];
                characterinformation1 = null;
            }
        }

        if(characterinformation.layout.isOnATextPath())
        {
            for(int j1 = characterinformation.glyphIndexStart; j1 <= characterinformation.glyphIndexEnd; j1++)
            {
                if(gvtglyphvector.isGlyphVisible(j1) && !aflag[j1])
                    f += af[j1 + 1] - af[j1];
                aflag[j1] = true;
            }

        } else
        {
            if(characterinformation1 == null)
                characterinformation1 = getCharacterInformation(list, k, (i + j) - 1, attributedcharacteriterator);
            f += distanceFirstLastCharacterInRun(characterinformation, characterinformation1);
        }
        return f;
    }

    protected float distanceFirstLastCharacterInRun(CharacterInformation characterinformation, CharacterInformation characterinformation1)
    {
        float af[] = characterinformation.layout.getGlyphAdvances();
        int i = characterinformation.glyphIndexStart;
        int j = characterinformation.glyphIndexEnd;
        int k = characterinformation1.glyphIndexStart;
        int l = characterinformation1.glyphIndexEnd;
        int i1 = i >= k ? k : i;
        int j1 = j >= l ? j : l;
        return af[j1 + 1] - af[i1];
    }

    protected float distanceBetweenRun(CharacterInformation characterinformation, CharacterInformation characterinformation1)
    {
        CharacterInformation characterinformation2 = new CharacterInformation();
        characterinformation2.layout = characterinformation.layout;
        characterinformation2.glyphIndexEnd = characterinformation.layout.getGlyphCount() - 1;
        Point2D point2d = getEndPoint(characterinformation2);
        characterinformation2.layout = characterinformation1.layout;
        characterinformation2.glyphIndexStart = 0;
        Point2D point2d1 = getStartPoint(characterinformation2);
        float f;
        if(characterinformation1.isVertical())
            f = (float)(point2d1.getY() - point2d.getY());
        else
            f = (float)(point2d1.getX() - point2d.getX());
        return f;
    }

    protected void selectSubString(Element element, int i, int j)
    {
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        TextNode textnode = (TextNode)node;
        int k = getElementStartIndex(attributedcharacteriterator, element);
        if(k == -1)
            return;
        java.util.List list = getTextRuns(textnode);
        int l = getElementEndIndex(attributedcharacteriterator, element);
        CharacterInformation characterinformation = getCharacterInformation(list, k, i, attributedcharacteriterator);
        CharacterInformation characterinformation1 = getCharacterInformation(list, k, (i + j) - 1, attributedcharacteriterator);
        org.apache.batik.gvt.text.Mark mark = textnode.getMarkerForChar(characterinformation.characterIndex, true);
        org.apache.batik.gvt.text.Mark mark1;
        if(characterinformation1 != null && characterinformation1.characterIndex <= l)
            mark1 = textnode.getMarkerForChar(characterinformation1.characterIndex, false);
        else
            mark1 = textnode.getMarkerForChar(l, false);
        ctx.getUserAgent().setTextSelection(mark, mark1);
    }

    protected int getCharNumAtPosition(Element element, float f, float f1)
    {
        TextNode textnode = (TextNode)node;
        java.util.List list = getTextRuns(textnode);
        TextHit texthit = null;
        for(int i = list.size() - 1; i >= 0 && texthit == null; i--)
            texthit = ((org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i)).getLayout().hitTestChar(f, f1);

        if(texthit == null)
            return -1;
        AttributedCharacterIterator attributedcharacteriterator = ((TextNode)node).getAttributedCharacterIterator();
        int j = getElementStartIndex(attributedcharacteriterator, element);
        int k = getElementEndIndex(attributedcharacteriterator, element);
        int l = texthit.getCharIndex();
        if(l >= j && l <= k)
            return l - j;
        else
            return -1;
    }

    protected java.util.List getTextRuns(TextNode textnode)
    {
        if(textnode.getTextRuns() == null)
            textnode.getPrimitiveBounds();
        return textnode.getTextRuns();
    }

    protected CharacterInformation getCharacterInformation(java.util.List list, int i, int j, AttributedCharacterIterator attributedcharacteriterator)
    {
        CharacterInformation characterinformation = new CharacterInformation();
        characterinformation.characterIndex = i + j;
        for(int k = 0; k < list.size(); k++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(k);
            if(textrun.getLayout().hasCharacterIndex(characterinformation.characterIndex))
            {
                characterinformation.layout = textrun.getLayout();
                attributedcharacteriterator.setIndex(characterinformation.characterIndex);
                if(attributedcharacteriterator.getAttribute(ALT_GLYPH_HANDLER) != null)
                {
                    characterinformation.glyphIndexStart = 0;
                    characterinformation.glyphIndexEnd = characterinformation.layout.getGlyphCount() - 1;
                } else
                {
                    characterinformation.glyphIndexStart = characterinformation.layout.getGlyphIndex(characterinformation.characterIndex);
                    if(characterinformation.glyphIndexStart == -1)
                    {
                        characterinformation.glyphIndexStart = 0;
                        characterinformation.glyphIndexEnd = characterinformation.layout.getGlyphCount() - 1;
                    } else
                    {
                        characterinformation.glyphIndexEnd = characterinformation.glyphIndexStart;
                    }
                }
                return characterinformation;
            }
        }

        return null;
    }

    public Set getTextIntersectionSet(AffineTransform affinetransform, Rectangle2D rectangle2d)
    {
        TextNode textnode = (TextNode)node;
        java.util.List list = textnode.getTextRuns();
        HashSet hashset = new HashSet();
label0:
        for(int i = 0; i < list.size(); i++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
            TextSpanLayout textspanlayout = textrun.getLayout();
            AttributedCharacterIterator attributedcharacteriterator = textrun.getACI();
            attributedcharacteriterator.first();
            Element element = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element == null || hashset.contains(element) || !isTextSensitive(element))
                continue;
            Rectangle2D rectangle2d1 = textspanlayout.getBounds2D();
            if(rectangle2d1 != null)
                rectangle2d1 = affinetransform.createTransformedShape(rectangle2d1).getBounds2D();
            if(!rectangle2d.intersects(rectangle2d1))
                continue;
            GVTGlyphVector gvtglyphvector = textspanlayout.getGlyphVector();
            int j = 0;
            do
            {
                if(j >= gvtglyphvector.getNumGlyphs())
                    continue label0;
                Object obj = gvtglyphvector.getGlyphLogicalBounds(j);
                if(obj != null)
                    obj = affinetransform.createTransformedShape(((Shape) (obj))).getBounds2D();
                if(((Shape) (obj)).intersects(rectangle2d))
                {
                    hashset.add(element);
                    continue label0;
                }
                j++;
            } while(true);
        }

        return hashset;
    }

    public Set getTextEnclosureSet(AffineTransform affinetransform, Rectangle2D rectangle2d)
    {
        TextNode textnode = (TextNode)node;
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        java.util.List list = textnode.getTextRuns();
        for(int i = 0; i < list.size(); i++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
            TextSpanLayout textspanlayout = textrun.getLayout();
            AttributedCharacterIterator attributedcharacteriterator = textrun.getACI();
            attributedcharacteriterator.first();
            Element element = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element == null || hashset1.contains(element))
                continue;
            if(!isTextSensitive(element))
            {
                hashset1.add(element);
                continue;
            }
            Rectangle2D rectangle2d1 = textspanlayout.getBounds2D();
            if(rectangle2d1 != null)
                rectangle2d1 = affinetransform.createTransformedShape(rectangle2d1).getBounds2D();
            if(rectangle2d.contains(rectangle2d1))
            {
                hashset.add(element);
            } else
            {
                hashset1.add(element);
                hashset.remove(element);
            }
        }

        return hashset;
    }

    public static boolean getTextIntersection(BridgeContext bridgecontext, Element element, AffineTransform affinetransform, Rectangle2D rectangle2d, boolean flag)
    {
        SVGContext svgcontext = null;
        if(element instanceof SVGOMElement)
            svgcontext = ((SVGOMElement)element).getSVGContext();
        if(svgcontext == null)
            return false;
        SVGTextElementBridge svgtextelementbridge = null;
        if(svgcontext instanceof SVGTextElementBridge)
            svgtextelementbridge = (SVGTextElementBridge)svgcontext;
        else
        if(svgcontext instanceof AbstractTextChildSVGContext)
        {
            AbstractTextChildSVGContext abstracttextchildsvgcontext = (AbstractTextChildSVGContext)svgcontext;
            svgtextelementbridge = abstracttextchildsvgcontext.getTextBridge();
        }
        if(svgtextelementbridge == null)
            return false;
        TextNode textnode = (TextNode)svgtextelementbridge.node;
        Element element1 = svgtextelementbridge.e;
        AffineTransform affinetransform1 = textnode.getGlobalTransform();
        affinetransform1.preConcatenate(affinetransform);
        Rectangle2D rectangle2d1 = textnode.getBounds();
        rectangle2d1 = affinetransform1.createTransformedShape(rectangle2d1).getBounds2D();
        if(!rectangle2d.intersects(rectangle2d1))
            return false;
        java.util.List list = textnode.getTextRuns();
label0:
        for(int i = 0; i < list.size(); i++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
            TextSpanLayout textspanlayout = textrun.getLayout();
            AttributedCharacterIterator attributedcharacteriterator = textrun.getACI();
            attributedcharacteriterator.first();
            Element element2 = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element2 == null || flag && !isTextSensitive(element2))
                continue;
            Element element3;
            for(element3 = element2; element3 != null && element3 != element1 && element3 != element; element3 = (Element)element3.getParentNode());
            if(element3 != element)
                continue;
            Rectangle2D rectangle2d2 = textspanlayout.getBounds2D();
            if(rectangle2d2 == null)
                continue;
            rectangle2d2 = affinetransform1.createTransformedShape(rectangle2d2).getBounds2D();
            if(!rectangle2d.intersects(rectangle2d2))
                continue;
            GVTGlyphVector gvtglyphvector = textspanlayout.getGlyphVector();
            int j = 0;
            do
            {
                if(j >= gvtglyphvector.getNumGlyphs())
                    continue label0;
                Object obj = gvtglyphvector.getGlyphLogicalBounds(j);
                if(obj != null)
                    obj = affinetransform1.createTransformedShape(((Shape) (obj))).getBounds2D();
                if(((Shape) (obj)).intersects(rectangle2d))
                    return true;
                j++;
            } while(true);
        }

        return false;
    }

    public static Rectangle2D getTextBounds(BridgeContext bridgecontext, Element element, boolean flag)
    {
        SVGContext svgcontext = null;
        if(element instanceof SVGOMElement)
            svgcontext = ((SVGOMElement)element).getSVGContext();
        if(svgcontext == null)
            return null;
        SVGTextElementBridge svgtextelementbridge = null;
        if(svgcontext instanceof SVGTextElementBridge)
            svgtextelementbridge = (SVGTextElementBridge)svgcontext;
        else
        if(svgcontext instanceof AbstractTextChildSVGContext)
        {
            AbstractTextChildSVGContext abstracttextchildsvgcontext = (AbstractTextChildSVGContext)svgcontext;
            svgtextelementbridge = abstracttextchildsvgcontext.getTextBridge();
        }
        if(svgtextelementbridge == null)
            return null;
        TextNode textnode = (TextNode)svgtextelementbridge.node;
        Element element1 = svgtextelementbridge.e;
        Rectangle2D rectangle2d = null;
        java.util.List list = textnode.getTextRuns();
        if(list == null)
            return null;
        for(int i = 0; i < list.size(); i++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
            TextSpanLayout textspanlayout = textrun.getLayout();
            AttributedCharacterIterator attributedcharacteriterator = textrun.getACI();
            attributedcharacteriterator.first();
            Element element2 = (Element)attributedcharacteriterator.getAttribute(TEXT_COMPOUND_DELIMITER);
            if(element2 == null || flag && !isTextSensitive(element2))
                continue;
            Element element3;
            for(element3 = element2; element3 != null && element3 != element1 && element3 != element; element3 = (Element)element3.getParentNode());
            if(element3 != element)
                continue;
            Rectangle2D rectangle2d1 = textspanlayout.getBounds2D();
            if(rectangle2d1 == null)
                continue;
            if(rectangle2d == null)
                rectangle2d = (Rectangle2D)rectangle2d1.clone();
            else
                rectangle2d.add(rectangle2d1);
        }

        return rectangle2d;
    }

    public static boolean isTextSensitive(Element element)
    {
        int i = CSSUtilities.convertPointerEvents(element);
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return CSSUtilities.convertVisibility(element);

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return true;

        case 8: // '\b'
        default:
            return false;
        }
    }

    protected static final Integer ZERO = new Integer(0);
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER;
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute ALT_GLYPH_HANDLER;
    protected AttributedString laidoutText;
    protected WeakHashMap elemTPI;
    protected boolean usingComplexSVGFont;
    protected DOMChildNodeRemovedEventListener childNodeRemovedEventListener;
    protected DOMSubtreeModifiedEventListener subtreeModifiedEventListener;
    private boolean hasNewACI;
    private Element cssProceedElement;
    protected int endLimit;

    static 
    {
        TEXT_COMPOUND_DELIMITER = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.TEXT_COMPOUND_DELIMITER;
        PAINT_INFO = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.PAINT_INFO;
        ALT_GLYPH_HANDLER = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.ALT_GLYPH_HANDLER;
    }
}
