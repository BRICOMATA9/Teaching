// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.io.PrintStream;

// Referenced classes of package org.apache.batik.transcoder:
//            ErrorHandler, TranscoderException

public class DefaultErrorHandler
    implements ErrorHandler
{

    public DefaultErrorHandler()
    {
    }

    public void error(TranscoderException transcoderexception)
        throws TranscoderException
    {
        System.err.println("ERROR: " + transcoderexception.getMessage());
    }

    public void fatalError(TranscoderException transcoderexception)
        throws TranscoderException
    {
        throw transcoderexception;
    }

    public void warning(TranscoderException transcoderexception)
        throws TranscoderException
    {
        System.err.println("WARNING: " + transcoderexception.getMessage());
    }
}
