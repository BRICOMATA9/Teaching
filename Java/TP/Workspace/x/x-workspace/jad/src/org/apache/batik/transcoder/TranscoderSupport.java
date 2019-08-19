// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.util.Map;

// Referenced classes of package org.apache.batik.transcoder:
//            TranscodingHints, DefaultErrorHandler, ErrorHandler

public class TranscoderSupport
{

    public TranscoderSupport()
    {
        hints = new TranscodingHints();
        handler = defaultErrorHandler;
    }

    public TranscodingHints getTranscodingHints()
    {
        return new TranscodingHints(hints);
    }

    public void addTranscodingHint(TranscodingHints.Key key, Object obj)
    {
        hints.put(key, obj);
    }

    public void removeTranscodingHint(TranscodingHints.Key key)
    {
        hints.remove(key);
    }

    public void setTranscodingHints(Map map)
    {
        hints.putAll(map);
    }

    public void setTranscodingHints(TranscodingHints transcodinghints)
    {
        hints = transcodinghints;
    }

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        handler = errorhandler;
    }

    public ErrorHandler getErrorHandler()
    {
        return handler;
    }

    static final ErrorHandler defaultErrorHandler = new DefaultErrorHandler();
    protected TranscodingHints hints;
    protected ErrorHandler handler;

}
