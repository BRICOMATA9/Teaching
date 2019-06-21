// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.awt.geom.AffineTransform;
import java.io.Reader;

// Referenced classes of package org.apache.batik.parser:
//            TransformListHandler, ParseException, TransformListParser

public class AWTTransformProducer
    implements TransformListHandler
{

    public AWTTransformProducer()
    {
    }

    public static AffineTransform createAffineTransform(Reader reader)
        throws ParseException
    {
        TransformListParser transformlistparser = new TransformListParser();
        AWTTransformProducer awttransformproducer = new AWTTransformProducer();
        transformlistparser.setTransformListHandler(awttransformproducer);
        transformlistparser.parse(reader);
        return awttransformproducer.getAffineTransform();
    }

    public static AffineTransform createAffineTransform(String s)
        throws ParseException
    {
        TransformListParser transformlistparser = new TransformListParser();
        AWTTransformProducer awttransformproducer = new AWTTransformProducer();
        transformlistparser.setTransformListHandler(awttransformproducer);
        transformlistparser.parse(s);
        return awttransformproducer.getAffineTransform();
    }

    public AffineTransform getAffineTransform()
    {
        return affineTransform;
    }

    public void startTransformList()
        throws ParseException
    {
        affineTransform = new AffineTransform();
    }

    public void matrix(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
        affineTransform.concatenate(new AffineTransform(f, f1, f2, f3, f4, f5));
    }

    public void rotate(float f)
        throws ParseException
    {
        affineTransform.concatenate(AffineTransform.getRotateInstance((3.1415926535897931D * (double)f) / 180D));
    }

    public void rotate(float f, float f1, float f2)
        throws ParseException
    {
        AffineTransform affinetransform = AffineTransform.getRotateInstance((3.1415926535897931D * (double)f) / 180D, f1, f2);
        affineTransform.concatenate(affinetransform);
    }

    public void translate(float f)
        throws ParseException
    {
        AffineTransform affinetransform = AffineTransform.getTranslateInstance(f, 0.0D);
        affineTransform.concatenate(affinetransform);
    }

    public void translate(float f, float f1)
        throws ParseException
    {
        AffineTransform affinetransform = AffineTransform.getTranslateInstance(f, f1);
        affineTransform.concatenate(affinetransform);
    }

    public void scale(float f)
        throws ParseException
    {
        affineTransform.concatenate(AffineTransform.getScaleInstance(f, f));
    }

    public void scale(float f, float f1)
        throws ParseException
    {
        affineTransform.concatenate(AffineTransform.getScaleInstance(f, f1));
    }

    public void skewX(float f)
        throws ParseException
    {
        affineTransform.concatenate(AffineTransform.getShearInstance(Math.tan((3.1415926535897931D * (double)f) / 180D), 0.0D));
    }

    public void skewY(float f)
        throws ParseException
    {
        affineTransform.concatenate(AffineTransform.getShearInstance(0.0D, Math.tan((3.1415926535897931D * (double)f) / 180D)));
    }

    public void endTransformList()
        throws ParseException
    {
    }

    protected AffineTransform affineTransform;
}
