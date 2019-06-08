// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.U;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseException;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.Node;

public interface P
{

    public abstract String A();

    public abstract String D();

    public abstract String C();

    public abstract Class B();

    public abstract void A(U u, Node node, GraphMLParseContext graphmlparsecontext);

    public abstract void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext);

    public abstract void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext);

    public abstract boolean A(U u, GraphMLWriteContext graphmlwritecontext);

    public abstract boolean A(Node node, GraphMLParseContext graphmlparsecontext);

    public abstract U B(Node node, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException;
}
