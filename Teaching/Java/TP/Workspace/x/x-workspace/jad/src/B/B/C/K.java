// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.E;
import B.D.C.A;
import B.D.D.I;
import C.A.D;
import C.A.T;
import C.J.Y;
import C.J.b;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;

public class K extends A
{

    public K()
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(!(obj instanceof T))
            return;
        Y y = ((b)d).U((T)obj);
        if(!(y instanceof E))
            return;
        xmlwriter.writeStartElement("ClassifierLabels", B());
        int i = 0;
        for(int j = y.L(); i < j; i++)
            I.A(xmlwriter, y.A(i), graphmlwritecontext);

        xmlwriter.writeEndElement();
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "classifierlabels");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    private String B()
    {
        return "http://www.yworks.com/xml/graphml";
    }
}
