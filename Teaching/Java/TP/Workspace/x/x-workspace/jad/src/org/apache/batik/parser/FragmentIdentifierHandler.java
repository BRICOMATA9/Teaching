// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            PreserveAspectRatioHandler, TransformListHandler, ParseException

public interface FragmentIdentifierHandler
    extends PreserveAspectRatioHandler, TransformListHandler
{

    public abstract void startFragmentIdentifier()
        throws ParseException;

    public abstract void idReference(String s)
        throws ParseException;

    public abstract void viewBox(float f, float f1, float f2, float f3)
        throws ParseException;

    public abstract void startViewTarget()
        throws ParseException;

    public abstract void viewTarget(String s)
        throws ParseException;

    public abstract void endViewTarget()
        throws ParseException;

    public abstract void zoomAndPan(boolean flag);

    public abstract void endFragmentIdentifier()
        throws ParseException;
}
