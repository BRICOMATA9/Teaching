// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.C;

import C.A.*;
import org.graphdrawing.graphml.writer.*;

public abstract class A
    implements OutputHandler
{

    public A()
    {
    }

    public void printDataAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printDataOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        Object obj = graphmlwritecontext.getCurrentContainer();
        D d = null;
        if(obj instanceof D)
            d = (D)obj;
        else
        if((obj instanceof T) || (obj instanceof J))
            d = (D)graphmlwritecontext.getSecondToCurrentContainer();
        A(graphmlwritecontext, d, obj, xmlwriter);
    }

    public abstract void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter);
}
