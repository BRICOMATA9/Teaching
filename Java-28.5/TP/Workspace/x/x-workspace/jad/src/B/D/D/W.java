// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseException;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.Node;

public interface W
{

    public abstract String A();

    public abstract String D();

    public abstract String C();

    public abstract Class B();

    public abstract void A(Y y, Node node, GraphMLParseContext graphmlparsecontext);

    public abstract void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext);

    public abstract void A(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext);

    public abstract boolean A(Y y, GraphMLWriteContext graphmlwritecontext);

    public abstract boolean B(Node node, GraphMLParseContext graphmlparsecontext);

    public abstract Y A(Node node, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException;
}
