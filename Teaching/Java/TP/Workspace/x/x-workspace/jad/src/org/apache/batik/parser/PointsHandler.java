// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface PointsHandler
{

    public abstract void startPoints()
        throws ParseException;

    public abstract void point(float f, float f1)
        throws ParseException;

    public abstract void endPoints()
        throws ParseException;
}
