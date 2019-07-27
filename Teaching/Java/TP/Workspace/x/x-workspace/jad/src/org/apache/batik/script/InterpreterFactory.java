// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;

import java.net.URL;

// Referenced classes of package org.apache.batik.script:
//            Interpreter

public interface InterpreterFactory
{

    public abstract String getMimeType();

    public abstract Interpreter createInterpreter(URL url);
}
