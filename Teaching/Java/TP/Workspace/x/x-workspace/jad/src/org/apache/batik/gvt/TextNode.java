// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import org.apache.batik.gvt.renderer.StrokingTextPainter;
import org.apache.batik.gvt.text.AttributedCharacterSpanIterator;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.gvt.text.Mark;
import org.apache.batik.gvt.text.TextPaintInfo;
import org.apache.batik.gvt.text.TextSpanLayout;

// Referenced classes of package org.apache.batik.gvt:
//            AbstractGraphicsNode, Selectable, TextPainter

public class TextNode extends AbstractGraphicsNode
    implements Selectable
{
    public static final class Anchor
        implements Serializable
    {

        public int getType()
        {
            return type;
        }

        private Object readResolve()
            throws ObjectStreamException
        {
            switch(type)
            {
            case 0: // '\0'
                return START;

            case 1: // '\001'
                return MIDDLE;

            case 2: // '\002'
                return END;
            }
            throw new Error("Unknown Anchor type");
        }

        public static final int ANCHOR_START = 0;
        public static final int ANCHOR_MIDDLE = 1;
        public static final int ANCHOR_END = 2;
        public static final Anchor START = new Anchor(0);
        public static final Anchor MIDDLE = new Anchor(1);
        public static final Anchor END = new Anchor(2);
        private int type;


        private Anchor(int i)
        {
            type = i;
        }
    }


    public TextNode()
    {
        location = new java.awt.geom.Point2D.Float(0.0F, 0.0F);
        beginMark = null;
        endMark = null;
        textPainter = StrokingTextPainter.getInstance();
    }

    public void setTextPainter(TextPainter textpainter)
    {
        if(textpainter == null)
            textPainter = StrokingTextPainter.getInstance();
        else
            textPainter = textpainter;
    }

    public TextPainter getTextPainter()
    {
        return textPainter;
    }

    public java.util.List getTextRuns()
    {
        return textRuns;
    }

    public void setTextRuns(java.util.List list)
    {
        textRuns = list;
    }

    public String getText()
    {
        if(text == null)
        {
            StringBuffer stringbuffer = new StringBuffer(aci.getEndIndex());
            for(char c = aci.first(); c != '\uFFFF'; c = aci.next())
                stringbuffer.append(c);

            text = stringbuffer.toString();
        }
        return text;
    }

    public void setLocation(Point2D point2d)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        location = point2d;
        fireGraphicsNodeChangeCompleted();
    }

    public Point2D getLocation()
    {
        return location;
    }

    public void swapTextPaintInfo(TextPaintInfo textpaintinfo, TextPaintInfo textpaintinfo1)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        textpaintinfo1.set(textpaintinfo);
        fireGraphicsNodeChangeCompleted();
    }

    public void setAttributedCharacterIterator(AttributedCharacterIterator attributedcharacteriterator)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        aci = attributedcharacteriterator;
        text = null;
        textRuns = null;
        fireGraphicsNodeChangeCompleted();
    }

    public AttributedCharacterIterator getAttributedCharacterIterator()
    {
        return aci;
    }

    protected void invalidateGeometryCache()
    {
        super.invalidateGeometryCache();
        primitiveBounds = null;
        geometryBounds = null;
        outline = null;
    }

    public Rectangle2D getPrimitiveBounds()
    {
        if(primitiveBounds == null && aci != null)
            primitiveBounds = textPainter.getBounds2D(this);
        return primitiveBounds;
    }

    public Rectangle2D getGeometryBounds()
    {
        if(geometryBounds == null && aci != null)
            geometryBounds = textPainter.getGeometryBounds(this);
        return geometryBounds;
    }

    public Rectangle2D getSensitiveBounds()
    {
        return getGeometryBounds();
    }

    public Shape getOutline()
    {
        if(outline == null && aci != null)
            outline = textPainter.getOutline(this);
        return outline;
    }

    public Mark getMarkerForChar(int i, boolean flag)
    {
        return textPainter.getMark(this, i, flag);
    }

    public void setSelection(Mark mark, Mark mark1)
    {
        if(mark.getTextNode() != this || mark1.getTextNode() != this)
        {
            throw new Error("Markers not from this TextNode");
        } else
        {
            beginMark = mark;
            endMark = mark1;
            return;
        }
    }

    public boolean selectAt(double d, double d1)
    {
        beginMark = textPainter.selectAt(d, d1, this);
        return true;
    }

    public boolean selectTo(double d, double d1)
    {
        Mark mark = textPainter.selectTo(d, d1, beginMark);
        if(mark == null)
            return false;
        if(mark != endMark)
        {
            endMark = mark;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean selectAll(double d, double d1)
    {
        beginMark = textPainter.selectFirst(this);
        endMark = textPainter.selectLast(this);
        return true;
    }

    public Object getSelection()
    {
        int ai[] = textPainter.getSelected(beginMark, endMark);
        AttributedCharacterSpanIterator attributedcharacterspaniterator = null;
        if(ai != null && ai.length > 1)
        {
            if(ai[0] > ai[1])
            {
                int i = ai[1];
                ai[1] = ai[0];
                ai[0] = i;
            }
            attributedcharacterspaniterator = new AttributedCharacterSpanIterator(aci, ai[0], ai[1] + 1);
        }
        return attributedcharacterspaniterator;
    }

    public Shape getHighlightShape()
    {
        Shape shape = textPainter.getHighlightShape(beginMark, endMark);
        AffineTransform affinetransform = getGlobalTransform();
        shape = affinetransform.createTransformedShape(shape);
        return shape;
    }

    public void primitivePaint(Graphics2D graphics2d)
    {
        Shape shape = graphics2d.getClip();
        if(shape != null && !(shape instanceof GeneralPath))
            graphics2d.setClip(new GeneralPath(shape));
        textPainter.paint(this, graphics2d);
    }

    public boolean contains(Point2D point2d)
    {
        if(!super.contains(point2d))
            return false;
        java.util.List list = getTextRuns();
        for(int i = 0; i < list.size(); i++)
        {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
            TextSpanLayout textspanlayout = textrun.getLayout();
            float f = (float)point2d.getX();
            float f1 = (float)point2d.getY();
            org.apache.batik.gvt.text.TextHit texthit = textspanlayout.hitTestChar(f, f1);
            if(texthit != null && contains(point2d, textspanlayout.getBounds2D()))
                return true;
        }

        return false;
    }

    protected boolean contains(Point2D point2d, Rectangle2D rectangle2d)
    {
        if(rectangle2d == null || !rectangle2d.contains(point2d))
            return false;
        switch(pointerEventType)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return isVisible;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return true;

        case 8: // '\b'
            return false;
        }
        return false;
    }

    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO;
    protected Point2D location;
    protected AttributedCharacterIterator aci;
    protected String text;
    protected Mark beginMark;
    protected Mark endMark;
    protected java.util.List textRuns;
    protected TextPainter textPainter;
    private Rectangle2D geometryBounds;
    private Rectangle2D primitiveBounds;
    private Shape outline;

    static 
    {
        PAINT_INFO = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.PAINT_INFO;
    }
}
