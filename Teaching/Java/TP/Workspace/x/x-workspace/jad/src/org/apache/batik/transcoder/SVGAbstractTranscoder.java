// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.StringTokenizer;
import org.apache.batik.bridge.BaseScriptingEnvironment;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.BridgeException;
import org.apache.batik.bridge.DefaultScriptSecurity;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.bridge.NoLoadScriptSecurity;
import org.apache.batik.bridge.RelaxedScriptSecurity;
import org.apache.batik.bridge.ScriptSecurity;
import org.apache.batik.bridge.UserAgent;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.bridge.ViewBox;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.DOMUtilities;
import org.apache.batik.dom.util.DocumentFactory;
import org.apache.batik.gvt.CanvasGraphicsNode;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.transcoder.keys.BooleanKey;
import org.apache.batik.transcoder.keys.FloatKey;
import org.apache.batik.transcoder.keys.LengthKey;
import org.apache.batik.transcoder.keys.Rectangle2DKey;
import org.apache.batik.transcoder.keys.StringKey;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

// Referenced classes of package org.apache.batik.transcoder:
//            XMLAbstractTranscoder, TranscodingHints, TranscoderException, TranscoderInput, 
//            TranscoderOutput, ErrorHandler

public abstract class SVGAbstractTranscoder extends XMLAbstractTranscoder
{
    protected class SVGAbstractTranscoderUserAgent extends UserAgentAdapter
    {

        public AffineTransform getTransform()
        {
            return curTxf;
        }

        public void setTransform(AffineTransform affinetransform)
        {
            curTxf = affinetransform;
        }

        public Dimension2D getViewportSize()
        {
            return new Dimension((int)width, (int)height);
        }

        public void displayError(String s)
        {
            try
            {
                handler.error(new TranscoderException(s));
            }
            catch(TranscoderException transcoderexception)
            {
                throw new RuntimeException();
            }
        }

        public void displayError(Exception exception)
        {
            try
            {
                exception.printStackTrace();
                handler.error(new TranscoderException(exception));
            }
            catch(TranscoderException transcoderexception)
            {
                throw new RuntimeException();
            }
        }

        public void displayMessage(String s)
        {
            try
            {
                handler.warning(new TranscoderException(s));
            }
            catch(TranscoderException transcoderexception)
            {
                throw new RuntimeException();
            }
        }

        public float getPixelUnitToMillimeter()
        {
            Object obj = hints.get(SVGAbstractTranscoder.KEY_PIXEL_UNIT_TO_MILLIMETER);
            if(obj != null)
                return ((Float)obj).floatValue();
            else
                return getPixelUnitToMillimeter();
        }

        public String getLanguages()
        {
            if(hints.containsKey(SVGAbstractTranscoder.KEY_LANGUAGE))
                return (String)hints.get(SVGAbstractTranscoder.KEY_LANGUAGE);
            else
                return getLanguages();
        }

        public String getMedia()
        {
            String s = (String)hints.get(SVGAbstractTranscoder.KEY_MEDIA);
            if(s != null)
                return s;
            else
                return getMedia();
        }

        public String getDefaultFontFamily()
        {
            String s = (String)hints.get(SVGAbstractTranscoder.KEY_DEFAULT_FONT_FAMILY);
            if(s != null)
                return s;
            else
                return getDefaultFontFamily();
        }

        public String getAlternateStyleSheet()
        {
            String s = (String)hints.get(SVGAbstractTranscoder.KEY_ALTERNATE_STYLESHEET);
            if(s != null)
                return s;
            else
                return getAlternateStyleSheet();
        }

        public String getUserStyleSheetURI()
        {
            String s = (String)hints.get(SVGAbstractTranscoder.KEY_USER_STYLESHEET_URI);
            if(s != null)
                return s;
            else
                return getUserStyleSheetURI();
        }

        public String getXMLParserClassName()
        {
            String s = (String)hints.get(XMLAbstractTranscoder.KEY_XML_PARSER_CLASSNAME);
            if(s != null)
                return s;
            else
                return getXMLParserClassName();
        }

        public boolean isXMLParserValidating()
        {
            Boolean boolean1 = (Boolean)hints.get(XMLAbstractTranscoder.KEY_XML_PARSER_VALIDATING);
            if(boolean1 != null)
                return boolean1.booleanValue();
            else
                return isXMLParserValidating();
        }

        public ScriptSecurity getScriptSecurity(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
        {
            if(scripts == null)
                computeAllowedScripts();
            if(!scripts.contains(s))
                return new NoLoadScriptSecurity(s);
            boolean flag = true;
            if(hints.containsKey(SVGAbstractTranscoder.KEY_CONSTRAIN_SCRIPT_ORIGIN))
                flag = ((Boolean)hints.get(SVGAbstractTranscoder.KEY_CONSTRAIN_SCRIPT_ORIGIN)).booleanValue();
            if(flag)
                return new DefaultScriptSecurity(s, parsedurl, parsedurl1);
            else
                return new RelaxedScriptSecurity(s, parsedurl, parsedurl1);
        }

        protected void computeAllowedScripts()
        {
            scripts = new LinkedList();
            if(!hints.containsKey(SVGAbstractTranscoder.KEY_ALLOWED_SCRIPT_TYPES))
                return;
            String s = (String)hints.get(SVGAbstractTranscoder.KEY_ALLOWED_SCRIPT_TYPES);
            for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens(); scripts.add(stringtokenizer.nextToken()));
        }

        protected java.util.List scripts;

        public SVGAbstractTranscoderUserAgent()
        {
            addStdFeatures();
        }
    }


    protected SVGAbstractTranscoder()
    {
        width = 400F;
        height = 400F;
        userAgent = createUserAgent();
        hints.put(KEY_DOCUMENT_ELEMENT_NAMESPACE_URI, "http://www.w3.org/2000/svg");
        hints.put(KEY_DOCUMENT_ELEMENT, "svg");
        hints.put(KEY_DOM_IMPLEMENTATION, SVGDOMImplementation.getDOMImplementation());
        hints.put(KEY_MEDIA, "screen");
        hints.put(KEY_DEFAULT_FONT_FAMILY, "Arial, Helvetica, sans-serif");
        hints.put(KEY_EXECUTE_ONLOAD, Boolean.FALSE);
        hints.put(KEY_ALLOWED_SCRIPT_TYPES, "text/ecmascript, application/java-archive");
    }

    protected UserAgent createUserAgent()
    {
        return new SVGAbstractTranscoderUserAgent();
    }

    protected DocumentFactory createDocumentFactory(DOMImplementation domimplementation, String s)
    {
        return new SAXSVGDocumentFactory(s);
    }

    public void transcode(TranscoderInput transcoderinput, TranscoderOutput transcoderoutput)
        throws TranscoderException
    {
        transcode(transcoderinput, transcoderoutput);
        if(ctx != null)
            ctx.dispose();
    }

    protected void transcode(Document document, String s, TranscoderOutput transcoderoutput)
        throws TranscoderException
    {
        if(document != null && !(document.getImplementation() instanceof SVGDOMImplementation))
        {
            DOMImplementation domimplementation = (DOMImplementation)hints.get(KEY_DOM_IMPLEMENTATION);
            document = DOMUtilities.deepCloneDocument(document, domimplementation);
            if(s != null)
                try
                {
                    URL url = new URL(s);
                    ((SVGOMDocument)document).setURLObject(url);
                }
                catch(MalformedURLException malformedurlexception) { }
        }
        ctx = createBridgeContext();
        SVGOMDocument svgomdocument = (SVGOMDocument)document;
        org.w3c.dom.svg.SVGSVGElement svgsvgelement = svgomdocument.getRootElement();
        builder = new GVTBuilder();
        boolean flag = hints.containsKey(KEY_EXECUTE_ONLOAD) && ((Boolean)hints.get(KEY_EXECUTE_ONLOAD)).booleanValue() && ctx.isDynamicDocument(svgomdocument);
        GraphicsNode graphicsnode;
        try
        {
            if(flag)
                ctx.setDynamicState(2);
            graphicsnode = builder.build(ctx, svgomdocument);
            if(ctx.isDynamic())
            {
                BaseScriptingEnvironment basescriptingenvironment = new BaseScriptingEnvironment(ctx);
                basescriptingenvironment.loadScripts();
                basescriptingenvironment.dispatchSVGLoadEvent();
            }
        }
        catch(BridgeException bridgeexception)
        {
            throw new TranscoderException(bridgeexception);
        }
        float f = (float)ctx.getDocumentSize().getWidth();
        float f1 = (float)ctx.getDocumentSize().getHeight();
        setImageSize(f, f1);
        AffineTransform affinetransform;
        if(hints.containsKey(KEY_AOI))
        {
            Rectangle2D rectangle2d = (Rectangle2D)hints.get(KEY_AOI);
            affinetransform = new AffineTransform();
            double d = (double)width / rectangle2d.getWidth();
            double d1 = (double)height / rectangle2d.getHeight();
            double d2 = Math.min(d, d1);
            affinetransform.scale(d2, d2);
            double d3 = -rectangle2d.getX() + ((double)width / d2 - rectangle2d.getWidth()) / 2D;
            double d4 = -rectangle2d.getY() + ((double)height / d2 - rectangle2d.getHeight()) / 2D;
            affinetransform.translate(d3, d4);
            curAOI = rectangle2d;
        } else
        {
            String s1 = (new ParsedURL(s)).getRef();
            try
            {
                affinetransform = ViewBox.getViewTransform(s1, svgsvgelement, width, height);
            }
            catch(BridgeException bridgeexception1)
            {
                throw new TranscoderException(bridgeexception1);
            }
            if(affinetransform.isIdentity() && (width != f || height != f1))
            {
                float f2 = width / f;
                float f3 = height / f1;
                float f4 = Math.min(f2, f3);
                affinetransform = AffineTransform.getScaleInstance(f4, f4);
            }
            curAOI = new Float(0.0F, 0.0F, width, height);
        }
        CanvasGraphicsNode canvasgraphicsnode = getCanvasGraphicsNode(graphicsnode);
        if(canvasgraphicsnode != null)
        {
            canvasgraphicsnode.setViewingTransform(affinetransform);
            curTxf = new AffineTransform();
        } else
        {
            curTxf = affinetransform;
        }
        root = graphicsnode;
    }

    protected CanvasGraphicsNode getCanvasGraphicsNode(GraphicsNode graphicsnode)
    {
        if(!(graphicsnode instanceof CompositeGraphicsNode))
            return null;
        CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)graphicsnode;
        java.util.List list = compositegraphicsnode.getChildren();
        if(list.size() == 0)
            return null;
        graphicsnode = (GraphicsNode)list.get(0);
        if(!(graphicsnode instanceof CanvasGraphicsNode))
            return null;
        else
            return (CanvasGraphicsNode)graphicsnode;
    }

    protected BridgeContext createBridgeContext()
    {
        return new BridgeContext(userAgent);
    }

    protected void setImageSize(float f, float f1)
    {
        float f2 = -1F;
        if(hints.containsKey(KEY_WIDTH))
            f2 = ((Float)hints.get(KEY_WIDTH)).floatValue();
        float f3 = -1F;
        if(hints.containsKey(KEY_HEIGHT))
            f3 = ((Float)hints.get(KEY_HEIGHT)).floatValue();
        if(f2 > 0.0F && f3 > 0.0F)
        {
            width = f2;
            height = f3;
        } else
        if(f3 > 0.0F)
        {
            width = (f * f3) / f1;
            height = f3;
        } else
        if(f2 > 0.0F)
        {
            width = f2;
            height = (f1 * f2) / f;
        } else
        {
            width = f;
            height = f1;
        }
        float f4 = -1F;
        if(hints.containsKey(KEY_MAX_WIDTH))
            f4 = ((Float)hints.get(KEY_MAX_WIDTH)).floatValue();
        float f5 = -1F;
        if(hints.containsKey(KEY_MAX_HEIGHT))
            f5 = ((Float)hints.get(KEY_MAX_HEIGHT)).floatValue();
        if(f5 > 0.0F && height > f5)
        {
            width = (f * f5) / f1;
            height = f5;
        }
        if(f4 > 0.0F && width > f4)
        {
            width = f4;
            height = (f1 * f4) / f;
        }
    }

    public static final String DEFAULT_DEFAULT_FONT_FAMILY = "Arial, Helvetica, sans-serif";
    protected Rectangle2D curAOI;
    protected AffineTransform curTxf;
    protected GraphicsNode root;
    protected BridgeContext ctx;
    protected GVTBuilder builder;
    protected float width;
    protected float height;
    protected UserAgent userAgent;
    public static final TranscodingHints.Key KEY_WIDTH = new LengthKey();
    public static final TranscodingHints.Key KEY_HEIGHT = new LengthKey();
    public static final TranscodingHints.Key KEY_MAX_WIDTH = new LengthKey();
    public static final TranscodingHints.Key KEY_MAX_HEIGHT = new LengthKey();
    public static final TranscodingHints.Key KEY_AOI = new Rectangle2DKey();
    public static final TranscodingHints.Key KEY_LANGUAGE = new StringKey();
    public static final TranscodingHints.Key KEY_MEDIA = new StringKey();
    public static final TranscodingHints.Key KEY_DEFAULT_FONT_FAMILY = new StringKey();
    public static final TranscodingHints.Key KEY_ALTERNATE_STYLESHEET = new StringKey();
    public static final TranscodingHints.Key KEY_USER_STYLESHEET_URI = new StringKey();
    public static final TranscodingHints.Key KEY_PIXEL_UNIT_TO_MILLIMETER;
    public static final TranscodingHints.Key KEY_PIXEL_TO_MM;
    public static final TranscodingHints.Key KEY_EXECUTE_ONLOAD = new BooleanKey();
    public static final TranscodingHints.Key KEY_ALLOWED_SCRIPT_TYPES = new StringKey();
    public static final String DEFAULT_ALLOWED_SCRIPT_TYPES = "text/ecmascript, application/java-archive";
    public static final TranscodingHints.Key KEY_CONSTRAIN_SCRIPT_ORIGIN = new BooleanKey();

    static 
    {
        KEY_PIXEL_UNIT_TO_MILLIMETER = new FloatKey();
        KEY_PIXEL_TO_MM = KEY_PIXEL_UNIT_TO_MILLIMETER;
    }
}
