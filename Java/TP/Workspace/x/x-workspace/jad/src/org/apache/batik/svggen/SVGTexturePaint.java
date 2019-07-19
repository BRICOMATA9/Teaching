// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGPaintDescriptor, SVGGeneratorContext, GenericImageHandler, 
//            SVGIDGenerator, SVGDescriptor

public class SVGTexturePaint extends AbstractSVGConverter
{

    public SVGTexturePaint(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG((TexturePaint)graphiccontext.getPaint());
    }

    public SVGPaintDescriptor toSVG(TexturePaint texturepaint)
    {
        SVGPaintDescriptor svgpaintdescriptor = (SVGPaintDescriptor)descMap.get(texturepaint);
        Document document = generatorContext.domFactory;
        if(svgpaintdescriptor == null)
        {
            Rectangle2D rectangle2d = texturepaint.getAnchorRect();
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "pattern");
            element.setAttributeNS(null, "patternUnits", "userSpaceOnUse");
            element.setAttributeNS(null, "x", doubleString(rectangle2d.getX()));
            element.setAttributeNS(null, "y", doubleString(rectangle2d.getY()));
            element.setAttributeNS(null, "width", doubleString(rectangle2d.getWidth()));
            element.setAttributeNS(null, "height", doubleString(rectangle2d.getHeight()));
            BufferedImage bufferedimage = texturepaint.getImage();
            if(bufferedimage.getWidth() > 0 && bufferedimage.getHeight() > 0 && ((double)bufferedimage.getWidth() != rectangle2d.getWidth() || (double)bufferedimage.getHeight() != rectangle2d.getHeight()) && rectangle2d.getWidth() > 0.0D && rectangle2d.getHeight() > 0.0D)
            {
                double d = rectangle2d.getWidth() / (double)bufferedimage.getWidth();
                double d1 = rectangle2d.getHeight() / (double)bufferedimage.getHeight();
                BufferedImage bufferedimage1 = new BufferedImage((int)(d * (double)bufferedimage.getWidth()), (int)(d1 * (double)bufferedimage.getHeight()), 2);
                Graphics2D graphics2d = bufferedimage1.createGraphics();
                graphics2d.scale(d, d1);
                graphics2d.drawImage(bufferedimage, 0, 0, null);
                graphics2d.dispose();
                bufferedimage = bufferedimage1;
            }
            Element element1 = generatorContext.genericImageHandler.createElement(generatorContext);
            generatorContext.genericImageHandler.handleImage(bufferedimage, element1, 0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), generatorContext);
            element.appendChild(element1);
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("pattern"));
            StringBuffer stringbuffer = new StringBuffer("url(");
            stringbuffer.append("#");
            stringbuffer.append(element.getAttributeNS(null, "id"));
            stringbuffer.append(")");
            svgpaintdescriptor = new SVGPaintDescriptor(stringbuffer.toString(), "1", element);
            descMap.put(texturepaint, svgpaintdescriptor);
            defSet.add(element);
        }
        return svgpaintdescriptor;
    }
}
