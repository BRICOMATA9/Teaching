// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.PadRable8Bit;

// Referenced classes of package org.apache.batik.gvt:
//            CompositeGraphicsNode, PatternPaintContext, GraphicsNode

public class PatternPaint
    implements Paint
{
    static class PatternPaintContextWrapper
        implements PaintContext
    {

        public void dispose()
        {
        }

        public ColorModel getColorModel()
        {
            return ppc.getColorModel();
        }

        public Raster getRaster(int i, int j, int k, int l)
        {
            return ppc.getRaster(i + xShift, j + yShift, k, l);
        }

        PatternPaintContext ppc;
        int xShift;
        int yShift;

        PatternPaintContextWrapper(PatternPaintContext patternpaintcontext, int i, int j)
        {
            ppc = patternpaintcontext;
            xShift = i;
            yShift = j;
        }
    }


    public PatternPaint(GraphicsNode graphicsnode, Rectangle2D rectangle2d, boolean flag, AffineTransform affinetransform)
    {
        if(graphicsnode == null)
            throw new IllegalArgumentException();
        if(rectangle2d == null)
            throw new IllegalArgumentException();
        node = graphicsnode;
        patternRegion = rectangle2d;
        overflow = flag;
        patternTransform = affinetransform;
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        compositegraphicsnode.getChildren().add(graphicsnode);
        Filter filter = compositegraphicsnode.getGraphicsNodeRable(true);
        Rectangle2D rectangle2d1 = (Rectangle2D)rectangle2d.clone();
        if(flag)
        {
            Rectangle2D rectangle2d2 = compositegraphicsnode.getBounds();
            rectangle2d1.add(rectangle2d2);
        }
        tile = new PadRable8Bit(filter, rectangle2d1, PadMode.ZERO_PAD);
    }

    public GraphicsNode getGraphicsNode()
    {
        return node;
    }

    public Rectangle2D getPatternRect()
    {
        return (Rectangle2D)patternRegion.clone();
    }

    public AffineTransform getPatternTransform()
    {
        return patternTransform;
    }

    public PaintContext createContext(ColorModel colormodel, Rectangle rectangle, Rectangle2D rectangle2d, AffineTransform affinetransform, RenderingHints renderinghints)
    {
        if(patternTransform != null)
        {
            affinetransform = new AffineTransform(affinetransform);
            affinetransform.concatenate(patternTransform);
        }
        if(lastContext != null && lastContext.getColorModel().equals(colormodel))
        {
            double ad[] = new double[6];
            double ad1[] = new double[6];
            affinetransform.getMatrix(ad);
            lastContext.getUsr2Dev().getMatrix(ad1);
            if(ad[0] == ad1[0] && ad[1] == ad1[1] && ad[2] == ad1[2] && ad[3] == ad1[3])
                if(ad[4] == ad1[4] && ad[5] == ad1[5])
                    return lastContext;
                else
                    return new PatternPaintContextWrapper(lastContext, (int)((ad1[4] - ad[4]) + 0.5D), (int)((ad1[5] - ad[5]) + 0.5D));
        }
        lastContext = new PatternPaintContext(colormodel, affinetransform, renderinghints, tile, patternRegion, overflow);
        return lastContext;
    }

    public int getTransparency()
    {
        return 3;
    }

    private GraphicsNode node;
    private Rectangle2D patternRegion;
    private AffineTransform patternTransform;
    private Filter tile;
    private boolean overflow;
    private PatternPaintContext lastContext;
}
