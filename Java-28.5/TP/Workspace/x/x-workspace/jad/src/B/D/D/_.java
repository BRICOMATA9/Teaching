// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import B.D.C.A;
import C.A.D;
import C.A.J;
import C.J.U;
import C.J.b;
import org.graphdrawing.graphml.writer.*;

// Referenced classes of package B.D.D:
//            B, P

public class _ extends A
{

    public _()
    {
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "edgegraphics");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(d instanceof b)
            A(((b)d).R((J)obj), xmlwriter, graphmlwritecontext);
    }

    public static void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        P p = null;
        B b1 = (B)graphmlwritecontext.lookup(B.D.D.B.class);
        if(b1 != null)
            p = b1.A(u, graphmlwritecontext);
        if(p == null)
            p = B.D.D.B.A().A(u, graphmlwritecontext);
        if(p == null)
        {
            graphmlwritecontext.getErrorHandler().warning("yext.graphml.graph2D.WriteNodeRealizerHandler#writeRealizer", "Realizer not recognized: " + u.getClass().getName(), null, graphmlwritecontext);
        } else
        {
            xmlwriter.writeStartElement(p.C(), p.A(), p.D());
            p.A(u, xmlwriter, graphmlwritecontext);
            p.B(u, xmlwriter, graphmlwritecontext);
            xmlwriter.writeEndElement();
        }
    }
}
