// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;


// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphics2DIOException, SVGGraphics2DRuntimeException

public interface ErrorHandler
{

    public abstract void handleError(SVGGraphics2DIOException svggraphics2dioexception)
        throws SVGGraphics2DIOException;

    public abstract void handleError(SVGGraphics2DRuntimeException svggraphics2druntimeexception)
        throws SVGGraphics2DRuntimeException;
}
