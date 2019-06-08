// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.apache.batik.gvt.text.Mark;

// Referenced classes of package org.apache.batik.gvt:
//            TextNode

public interface TextPainter
{

    public abstract void paint(TextNode textnode, Graphics2D graphics2d);

    public abstract Mark selectAt(double d, double d1, TextNode textnode);

    public abstract Mark selectTo(double d, double d1, Mark mark);

    public abstract Mark selectFirst(TextNode textnode);

    public abstract Mark selectLast(TextNode textnode);

    public abstract Mark getMark(TextNode textnode, int i, boolean flag);

    public abstract int[] getSelected(Mark mark, Mark mark1);

    public abstract Shape getHighlightShape(Mark mark, Mark mark1);

    public abstract Shape getOutline(TextNode textnode);

    public abstract Rectangle2D getBounds2D(TextNode textnode);

    public abstract Rectangle2D getGeometryBounds(TextNode textnode);
}
