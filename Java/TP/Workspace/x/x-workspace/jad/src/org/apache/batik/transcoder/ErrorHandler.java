// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;


// Referenced classes of package org.apache.batik.transcoder:
//            TranscoderException

public interface ErrorHandler
{

    public abstract void error(TranscoderException transcoderexception)
        throws TranscoderException;

    public abstract void fatalError(TranscoderException transcoderexception)
        throws TranscoderException;

    public abstract void warning(TranscoderException transcoderexception)
        throws TranscoderException;
}
