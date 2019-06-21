// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;

import org.apache.batik.bridge.BridgeContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.script:
//            Interpreter

public interface Window
{
    public static interface URLResponseHandler
    {

        public abstract void getURLDone(boolean flag, String s, String s1);
    }


    public abstract Object setInterval(String s, long l);

    public abstract Object setInterval(Runnable runnable, long l);

    public abstract void clearInterval(Object obj);

    public abstract Object setTimeout(String s, long l);

    public abstract Object setTimeout(Runnable runnable, long l);

    public abstract void clearTimeout(Object obj);

    public abstract Node parseXML(String s, Document document);

    public abstract void getURL(String s, URLResponseHandler urlresponsehandler);

    public abstract void getURL(String s, URLResponseHandler urlresponsehandler, String s1);

    public abstract void postURL(String s, String s1, URLResponseHandler urlresponsehandler);

    public abstract void postURL(String s, String s1, URLResponseHandler urlresponsehandler, String s2);

    public abstract void postURL(String s, String s1, URLResponseHandler urlresponsehandler, String s2, String s3);

    public abstract void alert(String s);

    public abstract boolean confirm(String s);

    public abstract String prompt(String s);

    public abstract String prompt(String s, String s1);

    public abstract BridgeContext getBridgeContext();

    public abstract Interpreter getInterpreter();
}
