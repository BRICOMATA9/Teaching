// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import B.D.C.A;
import C.A.D;
import C.A.T;
import C.J.Y;
import C.J.b;
import org.graphdrawing.graphml.writer.*;

// Referenced classes of package B.D.D:
//            B, W

public class E extends A
{

    public E()
    {
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "nodegraphics");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(d instanceof b)
        {
            Y y = ((b)d).U((T)obj);
            A(y, xmlwriter, graphmlwritecontext);
        }
    }

    public static void A(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        W w = null;
        B b1 = (B)graphmlwritecontext.lookup(B.D.D.B.class);
        if(b1 != null)
            w = b1.A(y, graphmlwritecontext);
        if(w == null)
            w = B.D.D.B.A().A(y, graphmlwritecontext);
        if(w == null)
        {
            graphmlwritecontext.getErrorHandler().warning("yext.graphml.graph2D.WriteNodeRealizerHandler#writeRealizer", "Realizer not recognized: " + y.getClass().getName(), null, graphmlwritecontext);
        } else
        {
            xmlwriter.writeStartElement(w.C(), w.A(), w.D());
            w.A(y, xmlwriter, graphmlwritecontext);
            w.B(y, xmlwriter, graphmlwritecontext);
            xmlwriter.writeEndElement();
        }
    }
}
