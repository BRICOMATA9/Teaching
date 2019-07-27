// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultPointsHandler, ParseException, PointsHandler

public class PointsParser extends NumberParser
{

    public PointsParser()
    {
        pointsHandler = DefaultPointsHandler.INSTANCE;
    }

    public void setPointsHandler(PointsHandler pointshandler)
    {
        pointsHandler = pointshandler;
    }

    public PointsHandler getPointsHandler()
    {
        return pointsHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        pointsHandler.startPoints();
        current = reader.read();
        skipSpaces();
        while(current != -1) 
        {
            float f = parseFloat();
            skipCommaSpaces();
            float f1 = parseFloat();
            pointsHandler.point(f, f1);
            skipCommaSpaces();
        }
        pointsHandler.endPoints();
    }

    protected PointsHandler pointsHandler;
    protected boolean eRead;
}
