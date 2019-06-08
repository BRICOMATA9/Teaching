// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.io.PrintStream;

// Referenced classes of package org.apache.batik.svggen:
//            ErrorHandler, SVGGraphics2DIOException, SVGGraphics2DRuntimeException

public class DefaultErrorHandler
    implements ErrorHandler
{

    public DefaultErrorHandler()
    {
    }

    public void handleError(SVGGraphics2DIOException svggraphics2dioexception)
        throws SVGGraphics2DIOException
    {
        throw svggraphics2dioexception;
    }

    public void handleError(SVGGraphics2DRuntimeException svggraphics2druntimeexception)
        throws SVGGraphics2DRuntimeException
    {
        System.err.println(svggraphics2druntimeexception.getMessage());
    }
}
