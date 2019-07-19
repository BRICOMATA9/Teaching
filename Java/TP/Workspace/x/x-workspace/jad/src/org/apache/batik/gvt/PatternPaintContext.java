// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.awt.image.renderable.RenderContext;
import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.ext.awt.image.rendered.TileCacheRed;

public class PatternPaintContext
    implements PaintContext
{

    public AffineTransform getUsr2Dev()
    {
        return usr2dev;
    }

    public PatternPaintContext(ColorModel colormodel, AffineTransform affinetransform, RenderingHints renderinghints, Filter filter, Rectangle2D rectangle2d, boolean flag)
    {
        if(affinetransform == null)
            throw new IllegalArgumentException();
        if(renderinghints == null)
            renderinghints = new RenderingHints(null);
        if(filter == null)
            throw new IllegalArgumentException();
        usr2dev = affinetransform;
        TileRable8Bit tilerable8bit = new TileRable8Bit(filter, EVERYTHING, rectangle2d, flag);
        ColorSpace colorspace = colormodel.getColorSpace();
        if(colorspace == ColorSpace.getInstance(1000))
            tilerable8bit.setColorSpaceLinear(false);
        else
        if(colorspace == ColorSpace.getInstance(1004))
            tilerable8bit.setColorSpaceLinear(true);
        RenderContext rendercontext = new RenderContext(affinetransform, EVERYTHING, renderinghints);
        tiled = tilerable8bit.createRendering(rendercontext);
        if(tiled != null)
        {
            Rectangle rectangle = affinetransform.createTransformedShape(rectangle2d).getBounds();
            if(rectangle.getWidth() > 128D || rectangle.getHeight() > 128D)
                tiled = new TileCacheRed(GraphicsUtil.wrap(tiled), 256, 64);
        } else
        {
            rasterCM = ColorModel.getRGBdefault();
            WritableRaster writableraster = rasterCM.createCompatibleWritableRaster(32, 32);
            tiled = GraphicsUtil.wrap(new BufferedImage(rasterCM, writableraster, false, null));
            return;
        }
        rasterCM = tiled.getColorModel();
        if(rasterCM.hasAlpha())
            if(colormodel.hasAlpha())
                rasterCM = GraphicsUtil.coerceColorModel(rasterCM, colormodel.isAlphaPremultiplied());
            else
                rasterCM = GraphicsUtil.coerceColorModel(rasterCM, false);
    }

    public void dispose()
    {
        raster = null;
    }

    public ColorModel getColorModel()
    {
        return rasterCM;
    }

    public Raster getRaster(int i, int j, int k, int l)
    {
        if(raster == null || raster.getWidth() < k || raster.getHeight() < l)
            raster = rasterCM.createCompatibleWritableRaster(k, l);
        WritableRaster writableraster = raster.createWritableChild(0, 0, k, l, i, j, null);
        tiled.copyData(writableraster);
        GraphicsUtil.coerceData(writableraster, tiled.getColorModel(), rasterCM.isAlphaPremultiplied());
        if(raster.getWidth() == k && raster.getHeight() == l)
            return raster;
        else
            return writableraster.createTranslatedChild(0, 0);
    }

    private ColorModel rasterCM;
    private WritableRaster raster;
    private RenderedImage tiled;
    protected AffineTransform usr2dev;
    private static Rectangle EVERYTHING = new Rectangle(0xe0000000, 0xe0000000, 0x3fffffff, 0x3fffffff);

}
