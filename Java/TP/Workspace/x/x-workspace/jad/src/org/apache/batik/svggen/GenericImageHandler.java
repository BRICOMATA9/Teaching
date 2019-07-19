// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            DOMTreeManager, SVGGeneratorContext

public interface GenericImageHandler
{

    public abstract void setDOMTreeManager(DOMTreeManager domtreemanager);

    public abstract Element createElement(SVGGeneratorContext svggeneratorcontext);

    public abstract AffineTransform handleImage(Image image, Element element, int i, int j, int k, int l, SVGGeneratorContext svggeneratorcontext);

    public abstract AffineTransform handleImage(RenderedImage renderedimage, Element element, int i, int j, int k, int l, SVGGeneratorContext svggeneratorcontext);

    public abstract AffineTransform handleImage(RenderableImage renderableimage, Element element, double d, double d1, double d2, double d3, SVGGeneratorContext svggeneratorcontext);
}
