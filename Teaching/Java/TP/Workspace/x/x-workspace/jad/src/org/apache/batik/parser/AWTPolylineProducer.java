// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package org.apache.batik.parser:
//            PointsHandler, ShapeProducer, ParseException, PointsParser

public class AWTPolylineProducer
    implements PointsHandler, ShapeProducer
{

    public AWTPolylineProducer()
    {
    }

    public static Shape createShape(Reader reader, int i)
        throws IOException, ParseException
    {
        PointsParser pointsparser = new PointsParser();
        AWTPolylineProducer awtpolylineproducer = new AWTPolylineProducer();
        awtpolylineproducer.setWindingRule(i);
        pointsparser.setPointsHandler(awtpolylineproducer);
        pointsparser.parse(reader);
        return awtpolylineproducer.getShape();
    }

    public void setWindingRule(int i)
    {
        windingRule = i;
    }

    public int getWindingRule()
    {
        return windingRule;
    }

    public Shape getShape()
    {
        return path;
    }

    public void startPoints()
        throws ParseException
    {
        path = new GeneralPath(windingRule);
        newPath = true;
    }

    public void point(float f, float f1)
        throws ParseException
    {
        if(newPath)
        {
            newPath = false;
            path.moveTo(f, f1);
        } else
        {
            path.lineTo(f, f1);
        }
    }

    public void endPoints()
        throws ParseException
    {
    }

    protected GeneralPath path;
    protected boolean newPath;
    protected int windingRule;
}
