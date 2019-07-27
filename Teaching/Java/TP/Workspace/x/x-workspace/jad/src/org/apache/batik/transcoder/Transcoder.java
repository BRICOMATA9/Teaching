// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.util.Map;

// Referenced classes of package org.apache.batik.transcoder:
//            TranscodingHints, TranscoderException, TranscoderInput, TranscoderOutput, 
//            ErrorHandler

public interface Transcoder
{

    public abstract void transcode(TranscoderInput transcoderinput, TranscoderOutput transcoderoutput)
        throws TranscoderException;

    public abstract TranscodingHints getTranscodingHints();

    public abstract void addTranscodingHint(TranscodingHints.Key key, Object obj);

    public abstract void removeTranscodingHint(TranscodingHints.Key key);

    public abstract void setTranscodingHints(Map map);

    public abstract void setTranscodingHints(TranscodingHints transcodinghints);

    public abstract void setErrorHandler(ErrorHandler errorhandler);

    public abstract ErrorHandler getErrorHandler();
}
