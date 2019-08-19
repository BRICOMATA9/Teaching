// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;

import java.io.*;
import org.apache.batik.i18n.Localizable;

// Referenced classes of package org.apache.batik.script:
//            InterpreterException

public interface Interpreter
    extends Localizable
{

    public abstract Object evaluate(Reader reader, String s)
        throws InterpreterException, IOException;

    public abstract Object evaluate(Reader reader)
        throws InterpreterException, IOException;

    public abstract Object evaluate(String s)
        throws InterpreterException;

    public abstract void bindObject(String s, Object obj);

    public abstract void setOut(Writer writer);

    public abstract void dispose();
}
