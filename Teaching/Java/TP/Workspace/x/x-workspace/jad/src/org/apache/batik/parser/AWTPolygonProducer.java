// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package org.apache.batik.parser:
//            AWTPolylineProducer, ParseException, PointsParser

public class AWTPolygonProducer extends AWTPolylineProducer
{

    public AWTPolygonProducer()
    {
    }

    public static Shape createShape(Reader reader, int i)
        throws IOException, ParseException
    {
        PointsParser pointsparser = new PointsParser();
        AWTPolygonProducer awtpolygonproducer = new AWTPolygonProducer();
        awtpolygonproducer.setWindingRule(i);
        pointsparser.setPointsHandler(awtpolygonproducer);
        pointsparser.parse(reader);
        return awtpolygonproducer.getShape();
    }

    public void endPoints()
        throws ParseException
    {
        path.closePath();
    }
}
