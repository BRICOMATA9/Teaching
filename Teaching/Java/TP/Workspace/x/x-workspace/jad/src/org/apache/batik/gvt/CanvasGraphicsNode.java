// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;

// Referenced classes of package org.apache.batik.gvt:
//            CompositeGraphicsNode

public class CanvasGraphicsNode extends CompositeGraphicsNode
{

    public CanvasGraphicsNode()
    {
    }

    public void setBackgroundPaint(Paint paint)
    {
        backgroundPaint = paint;
    }

    public Paint getBackgroundPaint()
    {
        return backgroundPaint;
    }

    public void setPositionTransform(AffineTransform affinetransform)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        positionTransform = affinetransform;
        if(positionTransform != null)
        {
            transform = new AffineTransform(positionTransform);
            if(viewingTransform != null)
                transform.concatenate(viewingTransform);
        } else
        if(viewingTransform != null)
            transform = new AffineTransform(viewingTransform);
        else
            transform = new AffineTransform();
        if(transform.getDeterminant() != 0.0D)
            try
            {
                inverseTransform = transform.createInverse();
            }
            catch(NoninvertibleTransformException noninvertibletransformexception)
            {
                throw new Error();
            }
        else
            inverseTransform = transform;
        fireGraphicsNodeChangeCompleted();
    }

    public AffineTransform getPositionTransform()
    {
        return positionTransform;
    }

    public void setViewingTransform(AffineTransform affinetransform)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        viewingTransform = affinetransform;
        if(positionTransform != null)
        {
            transform = new AffineTransform(positionTransform);
            if(viewingTransform != null)
                transform.concatenate(viewingTransform);
        } else
        if(viewingTransform != null)
            transform = new AffineTransform(viewingTransform);
        else
            transform = new AffineTransform();
        if(transform.getDeterminant() != 0.0D)
            try
            {
                inverseTransform = transform.createInverse();
            }
            catch(NoninvertibleTransformException noninvertibletransformexception)
            {
                throw new Error();
            }
        else
            inverseTransform = transform;
        fireGraphicsNodeChangeCompleted();
    }

    public AffineTransform getViewingTransform()
    {
        return viewingTransform;
    }

    public void primitivePaint(Graphics2D graphics2d)
    {
        if(backgroundPaint != null)
        {
            graphics2d.setPaint(backgroundPaint);
            graphics2d.fill(graphics2d.getClip());
        }
        super.primitivePaint(graphics2d);
    }

    protected AffineTransform positionTransform;
    protected AffineTransform viewingTransform;
    protected Paint backgroundPaint;
}
