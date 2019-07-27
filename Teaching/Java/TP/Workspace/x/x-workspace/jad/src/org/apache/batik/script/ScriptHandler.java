// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;

import org.w3c.dom.Document;

// Referenced classes of package org.apache.batik.script:
//            Window

public interface ScriptHandler
{

    public abstract void run(Document document, Window window);
}
