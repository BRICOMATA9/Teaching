// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;

import java.util.*;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.util.Service;
import org.w3c.dom.Document;

// Referenced classes of package org.apache.batik.script:
//            InterpreterFactory, Interpreter

public class InterpreterPool
{

    public InterpreterPool()
    {
        factories = new HashMap(7);
        factories.putAll(defaultFactories);
    }

    public Interpreter createInterpreter(Document document, String s)
    {
        InterpreterFactory interpreterfactory = (InterpreterFactory)factories.get(s);
        Interpreter interpreter = null;
        if(interpreterfactory != null)
            interpreter = interpreterfactory.createInterpreter(((SVGOMDocument)document).getURLObject());
        if(document != null)
            interpreter.bindObject("document", document);
        return interpreter;
    }

    public void putInterpreterFactory(String s, InterpreterFactory interpreterfactory)
    {
        factories.put(s, interpreterfactory);
    }

    public void removeInterpreterFactory(String s)
    {
        factories.remove(s);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private static final String RHINO = "org.apache.batik.script.rhino.RhinoInterpreterFactory";
    private static final String JPYTHON = "org.apache.batik.script.jpython.JPythonInterpreterFactory";
    private static final String JACL = "org.apache.batik.script.jacl.JaclInterpreterFactory";
    public static final String BIND_NAME_DOCUMENT = "document";
    protected static Map defaultFactories;
    protected Map factories;

    static 
    {
        defaultFactories = new HashMap(7);
        InterpreterFactory interpreterfactory;
        for(Iterator iterator = Service.providers(org.apache.batik.script.InterpreterFactory.class); iterator.hasNext(); defaultFactories.put(interpreterfactory.getMimeType(), interpreterfactory))
        {
            interpreterfactory = null;
            interpreterfactory = (InterpreterFactory)iterator.next();
        }

    }
}
