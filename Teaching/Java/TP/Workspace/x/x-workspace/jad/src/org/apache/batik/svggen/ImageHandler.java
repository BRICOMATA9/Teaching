// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGGeneratorContext

public interface ImageHandler
    extends SVGSyntax
{

    public abstract void handleImage(Image image, Element element, SVGGeneratorContext svggeneratorcontext);

    public abstract void handleImage(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext);

    public abstract void handleImage(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext);
}
