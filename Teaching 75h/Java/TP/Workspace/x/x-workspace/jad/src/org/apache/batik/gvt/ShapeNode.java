// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.batik.util.HaltingThread;

// Referenced classes of package org.apache.batik.gvt:
//            AbstractGraphicsNode, ShapePainter, StrokeShapePainter, FillShapePainter, 
//            CompositeShapePainter

public class ShapeNode extends AbstractGraphicsNode
{

    public ShapeNode()
    {
    }

    public void setShape(Shape shape1)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        shape = shape1;
        if(shapePainter != null)
            if(shape1 != null)
                shapePainter.setShape(shape1);
            else
                shapePainter = null;
        fireGraphicsNodeChangeCompleted();
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShapePainter(ShapePainter shapepainter)
    {
        if(shape == null)
            return;
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        shapePainter = shapepainter;
        if(shapePainter != null && shape != shapePainter.getShape())
            shapePainter.setShape(shape);
        fireGraphicsNodeChangeCompleted();
    }

    public ShapePainter getShapePainter()
    {
        return shapePainter;
    }

    public void paint(Graphics2D graphics2d)
    {
        if(isVisible)
            super.paint(graphics2d);
    }

    public void primitivePaint(Graphics2D graphics2d)
    {
        if(shapePainter != null)
            shapePainter.paint(graphics2d);
    }

    protected void invalidateGeometryCache()
    {
        super.invalidateGeometryCache();
        primitiveBounds = null;
        geometryBounds = null;
        sensitiveBounds = null;
        paintedArea = null;
        sensitiveArea = null;
    }

    public void setPointerEventType(int i)
    {
        super.setPointerEventType(i);
        sensitiveBounds = null;
        sensitiveArea = null;
    }

    public boolean contains(Point2D point2d)
    {
        switch(pointerEventType)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            if(!isVisible)
                return false;
            // fall through

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            Rectangle2D rectangle2d = getSensitiveBounds();
            if(rectangle2d == null || !rectangle2d.contains(point2d))
                return false;
            else
                return inSensitiveArea(point2d);

        case 8: // '\b'
        default:
            return false;
        }
    }

    public boolean intersects(Rectangle2D rectangle2d)
    {
        Rectangle2D rectangle2d1 = getBounds();
        if(rectangle2d1 != null)
            return rectangle2d1.intersects(rectangle2d) && paintedArea != null && paintedArea.intersects(rectangle2d);
        else
            return false;
    }

    public Rectangle2D getPrimitiveBounds()
    {
        if(!isVisible)
            return null;
        if(shape == null)
            return null;
        if(primitiveBounds != null)
            return primitiveBounds;
        if(shapePainter == null)
            primitiveBounds = shape.getBounds2D();
        else
            primitiveBounds = shapePainter.getPaintedBounds2D();
        if(HaltingThread.hasBeenHalted())
            invalidateGeometryCache();
        return primitiveBounds;
    }

    public boolean inSensitiveArea(Point2D point2d)
    {
        if(shapePainter == null)
            return false;
        ShapePainter shapepainter = null;
        ShapePainter shapepainter1 = null;
        if(shapePainter instanceof StrokeShapePainter)
            shapepainter = shapePainter;
        else
        if(shapePainter instanceof FillShapePainter)
            shapepainter1 = shapePainter;
        else
        if(shapePainter instanceof CompositeShapePainter)
        {
            CompositeShapePainter compositeshapepainter = (CompositeShapePainter)shapePainter;
            for(int i = 0; i < compositeshapepainter.getShapePainterCount(); i++)
            {
                ShapePainter shapepainter2 = compositeshapepainter.getShapePainter(i);
                if(shapepainter2 instanceof StrokeShapePainter)
                    shapepainter = shapepainter2;
                else
                if(shapepainter2 instanceof FillShapePainter)
                    shapepainter1 = shapepainter2;
            }

        } else
        {
            return false;
        }
        switch(pointerEventType)
        {
        case 8: // '\b'
        default:
            break;

        case 0: // '\0'
        case 4: // '\004'
            return shapePainter.inPaintedArea(point2d);

        case 3: // '\003'
        case 7: // '\007'
            return shapePainter.inSensitiveArea(point2d);

        case 1: // '\001'
        case 5: // '\005'
            if(shapepainter1 != null)
                return shapepainter1.inSensitiveArea(point2d);
            break;

        case 2: // '\002'
        case 6: // '\006'
            if(shapepainter != null)
                return shapepainter.inSensitiveArea(point2d);
            break;
        }
        return false;
    }

    public Rectangle2D getSensitiveBounds()
    {
        if(sensitiveBounds != null)
            return sensitiveBounds;
        if(shapePainter == null)
            return null;
        ShapePainter shapepainter = null;
        ShapePainter shapepainter1 = null;
        if(shapePainter instanceof StrokeShapePainter)
            shapepainter = shapePainter;
        else
        if(shapePainter instanceof FillShapePainter)
            shapepainter1 = shapePainter;
        else
        if(shapePainter instanceof CompositeShapePainter)
        {
            CompositeShapePainter compositeshapepainter = (CompositeShapePainter)shapePainter;
            for(int i = 0; i < compositeshapepainter.getShapePainterCount(); i++)
            {
                ShapePainter shapepainter2 = compositeshapepainter.getShapePainter(i);
                if(shapepainter2 instanceof StrokeShapePainter)
                    shapepainter = shapepainter2;
                else
                if(shapepainter2 instanceof FillShapePainter)
                    shapepainter1 = shapepainter2;
            }

        } else
        {
            return null;
        }
        switch(pointerEventType)
        {
        case 8: // '\b'
        default:
            break;

        case 0: // '\0'
        case 4: // '\004'
            sensitiveBounds = shapePainter.getPaintedBounds2D();
            break;

        case 1: // '\001'
        case 5: // '\005'
            if(shapepainter1 != null)
                sensitiveBounds = shapepainter1.getSensitiveBounds2D();
            break;

        case 2: // '\002'
        case 6: // '\006'
            if(shapepainter != null)
                sensitiveBounds = shapepainter.getSensitiveBounds2D();
            break;

        case 3: // '\003'
        case 7: // '\007'
            sensitiveBounds = shapePainter.getSensitiveBounds2D();
            break;
        }
        return sensitiveBounds;
    }

    public Shape getSensitiveArea()
    {
        if(sensitiveArea != null)
            return sensitiveArea;
        if(shapePainter == null)
            return null;
        ShapePainter shapepainter = null;
        ShapePainter shapepainter1 = null;
        if(shapePainter instanceof StrokeShapePainter)
            shapepainter = shapePainter;
        else
        if(shapePainter instanceof FillShapePainter)
            shapepainter1 = shapePainter;
        else
        if(shapePainter instanceof CompositeShapePainter)
        {
            CompositeShapePainter compositeshapepainter = (CompositeShapePainter)shapePainter;
            for(int i = 0; i < compositeshapepainter.getShapePainterCount(); i++)
            {
                ShapePainter shapepainter2 = compositeshapepainter.getShapePainter(i);
                if(shapepainter2 instanceof StrokeShapePainter)
                    shapepainter = shapepainter2;
                else
                if(shapepainter2 instanceof FillShapePainter)
                    shapepainter1 = shapepainter2;
            }

        } else
        {
            return null;
        }
        switch(pointerEventType)
        {
        case 8: // '\b'
        default:
            break;

        case 0: // '\0'
        case 4: // '\004'
            sensitiveArea = shapePainter.getPaintedArea();
            break;

        case 1: // '\001'
        case 5: // '\005'
            if(shapepainter1 != null)
                sensitiveArea = shapepainter1.getSensitiveArea();
            break;

        case 2: // '\002'
        case 6: // '\006'
            if(shapepainter != null)
                sensitiveArea = shapepainter.getSensitiveArea();
            break;

        case 3: // '\003'
        case 7: // '\007'
            sensitiveArea = shapePainter.getSensitiveArea();
            break;
        }
        return sensitiveArea;
    }

    public Rectangle2D getGeometryBounds()
    {
        if(geometryBounds == null)
        {
            if(shape == null)
                return null;
            geometryBounds = normalizeRectangle(shape.getBounds2D());
        }
        return geometryBounds;
    }

    public Shape getOutline()
    {
        return shape;
    }

    protected Shape shape;
    protected ShapePainter shapePainter;
    private Rectangle2D primitiveBounds;
    private Rectangle2D geometryBounds;
    private Rectangle2D sensitiveBounds;
    private Shape paintedArea;
    private Shape sensitiveArea;
}
