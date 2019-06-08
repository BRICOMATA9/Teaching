// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import B.D.A.B;
import B.D.B.A;
import C.A.D;
import C.A.J;
import C.A.M;
import C.H.L;
import C.J.A.G;
import C.J.EA;
import C.J.HA;
import C.J.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.graphdrawing.graphml.reader.GraphElementFactory;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.reader.GraphMLParseException;
import org.graphdrawing.graphml.reader.IdAcceptor;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParser;
import org.graphdrawing.graphml.reader.dom.DOMInputHandler;
import org.graphdrawing.graphml.writer.DirectGraphMLWriter;
import org.graphdrawing.graphml.writer.DomXmlWriter;
import org.graphdrawing.graphml.writer.GraphElementProvider;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.IdProvider;
import org.graphdrawing.graphml.writer.OutputHandler;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.Node;

// Referenced classes of package B.D.D:
//            B, E, _, L, 
//            M, D, F, a, 
//            e, C, W, c, 
//            P

public class T extends L
{
    private class _A
        implements IdProvider
    {

        public String getGraphId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            if((obj instanceof D) && m != null && graphmlwritecontext.getContainers().size() > 1)
            {
                Object obj1 = m.D(graphmlwritecontext.getSecondToCurrentContainer());
                if(obj1 != null)
                    return obj1.toString();
            }
            return (String)A3.D(obj);
        }

        public String getNodeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            return (String)A3.D(obj);
        }

        public String getEdgeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            return (String)A3.D(obj);
        }

        public String getPortId(Object obj, Object obj1, GraphMLWriteContext graphmlwritecontext)
        {
            return null;
        }

        public String getHyperedgeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            return null;
        }

        private _A()
        {
        }

    }

    private class _B
        implements IdAcceptor
    {

        public void setId(Object obj, String s1, GraphMLParseContext graphmlparsecontext)
        {
            if(obj instanceof D)
            {
                if(graphmlparsecontext.getContainers().size() == 1)
                {
                    AA.A(obj, s1);
                    if(p != null)
                        p.A(obj, s1);
                } else
                {
                    Object obj1 = graphmlparsecontext.getSecondToCurrentContainer();
                    G g = G.H((D)obj);
                    if(g.C((C.A.T)obj1))
                        AA.A(obj, s1);
                    if(p != null)
                        p.A(obj1, s1);
                }
            } else
            {
                AA.A(obj, s1);
            }
        }

        private _B()
        {
        }

    }

    private static class _C
        implements GraphMLParseErrorHandler
    {

        public void error(Object obj, String s1, Exception exception, GraphMLParseContext graphmlparsecontext)
            throws GraphMLParseException
        {
            C.E.M.A("ERROR: Encountered parse error at " + obj + ": " + s1);
            A.error(obj, s1, exception, graphmlparsecontext);
        }

        public void fatal(Object obj, String s1, Exception exception, GraphMLParseContext graphmlparsecontext)
            throws GraphMLParseException
        {
            C.E.M.A("FATAL: Encountered fatal parse error at " + obj + ": " + s1);
            A.fatal(obj, s1, exception, graphmlparsecontext);
        }

        public void warning(Object obj, String s1, Exception exception, GraphMLParseContext graphmlparsecontext)
        {
            D d = null;
            int i = graphmlparsecontext.getContainers().size();
            Object obj1 = null;
            Object obj3 = null;
            if(i > 0)
                obj1 = graphmlparsecontext.getCurrentContainer();
            if(obj1 instanceof D)
                d = (D)obj1;
            else
            if((obj1 instanceof C.A.T) || (obj1 instanceof J))
            {
                obj3 = obj1;
                if(i > 1)
                {
                    Object obj2 = graphmlparsecontext.getSecondToCurrentContainer();
                    if(obj2 instanceof D)
                        d = (D)obj2;
                }
            }
            if("yext.graphml.graph2D.GenericNodeRealizerSerializer#parse".equals(obj))
            {
                Object obj4 = graphmlparsecontext.lookup(T.class$C$J$Y != null ? T.class$C$J$Y : (T.class$C$J$Y = T._mthclass$("C.J.Y")));
                String s2 = "yext.graphml.graph2D.GenericNodeRealizerSerializer#parse#dummy";
                if(graphmlparsecontext instanceof DOMGraphMLParseContext)
                    s2 = graphmlparsecontext.getAttributeValue("configuration");
                if(obj4 != null && (obj4 instanceof HA))
                {
                    HA ha = (HA)obj4;
                    C.J.HA._D _ld = HA.E1();
                    if(!_ld.A().contains(s2))
                        _ld.A(s2, _ld.C());
                    ha.D(s2);
                }
                C.E.M.A("WARNING: " + s1 + ", substituting dummy configuration");
                A.warning(obj, s1 + ", substituting dummy configuration", exception, graphmlparsecontext);
                return;
            }
            if("yext.graphml.graph2D.GenericEdgeRealizerSerializer#parse".equals(obj))
            {
                Object obj5 = graphmlparsecontext.lookup(T.class$C$J$U != null ? T.class$C$J$U : (T.class$C$J$U = T._mthclass$("C.J.U")));
                String s3 = "yext.graphml.graph2D.GenericEdgeRealizerSerializer#parse#dummy";
                if(graphmlparsecontext instanceof DOMGraphMLParseContext)
                    s3 = graphmlparsecontext.getAttributeValue("configuration");
                if(obj5 != null && (obj5 instanceof EA))
                {
                    EA ea = (EA)obj5;
                    C.J.EA._C _lc = EA.D8();
                    if(!_lc.A().contains(s3))
                        _lc.A(s3, _lc.C());
                    ea.C(s3);
                }
                C.E.M.A("WARNING: " + s1 + ", substituting dummy configuration");
                A.warning(obj, s1 + ", substituting dummy configuration", exception, graphmlparsecontext);
                return;
            }
            if("yext.graphml.graph2D.ReadNodeRealizerHandler#parseRealizer".equals(obj))
            {
                C.A.T t1 = (C.A.T)obj3;
                Node node = (Node)graphmlparsecontext.lookup(T.class$org$w3c$dom$Node != null ? T.class$org$w3c$dom$Node : (T.class$org$w3c$dom$Node = T._mthclass$("org.w3c.dom.Node")));
                if(node != null && (d instanceof b))
                {
                    C.E.M.A("WARNING: " + s1 + ", using default realizer instead");
                    A.warning(obj, s1 + ", using default realizer instead", exception, graphmlparsecontext);
                    b b1 = (b)d;
                    C c1 = new C();
                    c1.A(b1.U(t1), node, graphmlparsecontext);
                    return;
                }
            }
            if("yext.graphml.graph2D.ReadEdgeRealizerHandler#parseRealizer".equals(obj))
            {
                J j = (J)obj3;
                Node node1 = (Node)graphmlparsecontext.lookup(T.class$org$w3c$dom$Node != null ? T.class$org$w3c$dom$Node : (T.class$org$w3c$dom$Node = T._mthclass$("org.w3c.dom.Node")));
                if(node1 != null && (d instanceof b))
                {
                    C.E.M.A("WARNING: " + s1 + ", using default realizer instead");
                    A.warning(obj, s1 + ", using default realizer instead", exception, graphmlparsecontext);
                    b b2 = (b)d;
                    c c2 = new c();
                    c2.A(b2.R(j), node1, graphmlparsecontext);
                    return;
                }
            }
            C.E.M.A("WARNING: " + s1 + " at: " + obj);
            A.warning(obj, s1, exception, graphmlparsecontext);
        }

        private GraphMLParseErrorHandler A;

        public _C(GraphMLParseErrorHandler graphmlparseerrorhandler)
        {
            A = graphmlparseerrorhandler;
        }
    }


    public String R()
    {
        return A4;
    }

    public boolean P()
    {
        return x;
    }

    public boolean N()
    {
        return s;
    }

    public boolean T()
    {
        return n;
    }

    public B.D.D.B O()
    {
        return C0;
    }

    public GraphMLParseErrorHandler M()
    {
        return q;
    }

    public T()
    {
        o = false;
        r = true;
        w = false;
        z = false;
        B5 = new LinkedList();
        t = new LinkedList();
        C1 = new LinkedList();
        C2 = new LinkedList();
        u = new LinkedList();
        A5 = new LinkedList();
        n = false;
        A4 = "UTF-8";
        x = true;
        s = true;
        C0 = new B.D.D.B();
        y = "http://graphml.graphdrawing.org/xmlns/graphml";
        A2 = new A();
        B5.add(A2);
        v = new HashMap();
        BA = new HashMap();
    }

    public String A()
    {
        return "graphml";
    }

    public Collection U()
    {
        return B5;
    }

    public Collection C(int i)
    {
        switch(i)
        {
        case 3: // '\003'
            return t;

        case 1: // '\001'
            return u;

        case 2: // '\002'
            return A5;

        case 7: // '\007'
            return C1;

        case 6: // '\006'
            return C2;

        case 4: // '\004'
        case 5: // '\005'
        default:
            throw new IllegalArgumentException("unknown scope " + i);
        }
    }

    protected DirectGraphMLWriter C(D d)
    {
        DirectGraphMLWriter directgraphmlwriter = new DirectGraphMLWriter();
        directgraphmlwriter.setWriteXMLSchemaEnabled(r);
        if(Q())
            directgraphmlwriter.setDtd("http://graphml.graphdrawing.org/dtds/graphml.dtd");
        G g = G.H(d);
        if(!v.containsKey(y))
            v.put(y, "");
        directgraphmlwriter.setGraphmlCoreNS(y);
        if(!S())
        {
            if(!v.containsKey("http://www.yworks.com/xml/graphml"))
                v.put("http://www.yworks.com/xml/graphml", "y");
            if(!BA.containsKey(y))
                BA.put(y, "http://www.yworks.com/xml/schema/graphml/1.0/ygraphml.xsd");
            E e1 = new E();
            directgraphmlwriter.addNodeOutputHandler(e1);
            _ _l = new _();
            directgraphmlwriter.addEdgeOutputHandler(_l);
            directgraphmlwriter.setContextLookup(B.D.D.B.class, O());
            directgraphmlwriter.setContextProperty("writeSelectionState", Boolean.valueOf(T()));
            if(g != null)
                directgraphmlwriter.addXMLAttributeProvider(new B.D.D.L(g));
        } else
        if(!BA.containsKey(y))
            BA.put(y, "http://www.yworks.com/xml/schema/graphml/1.0/graphml-attributes.xsd");
        directgraphmlwriter.setContextProperty("useEmbeddedResources", Boolean.valueOf(N()));
        if(A3 != null)
            directgraphmlwriter.setIdProvider(new _A());
        String s1;
        String s3;
        for(Iterator iterator = v.keySet().iterator(); iterator.hasNext(); directgraphmlwriter.addNamespace(s1, s3))
        {
            s1 = iterator.next().toString();
            s3 = (String)v.get(s1);
        }

        directgraphmlwriter.addNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        String s2;
        String s4;
        for(Iterator iterator1 = BA.keySet().iterator(); iterator1.hasNext(); directgraphmlwriter.addSchemaLocation(s2, s4))
        {
            s2 = iterator1.next().toString();
            s4 = (String)BA.get(s2);
        }

        GraphElementProvider graphelementprovider = A(d);
        directgraphmlwriter.setGraphElementProvider(graphelementprovider);
        OutputHandler outputhandler;
        for(Iterator iterator2 = t.iterator(); iterator2.hasNext(); directgraphmlwriter.addGraphOutputHandler(outputhandler))
            outputhandler = (OutputHandler)iterator2.next();

        OutputHandler outputhandler1;
        for(Iterator iterator3 = C1.iterator(); iterator3.hasNext(); directgraphmlwriter.addOutputHandler(outputhandler1, 7))
            outputhandler1 = (OutputHandler)iterator3.next();

        OutputHandler outputhandler2;
        for(Iterator iterator4 = u.iterator(); iterator4.hasNext(); directgraphmlwriter.addNodeOutputHandler(outputhandler2))
            outputhandler2 = (OutputHandler)iterator4.next();

        OutputHandler outputhandler3;
        for(Iterator iterator5 = A5.iterator(); iterator5.hasNext(); directgraphmlwriter.addEdgeOutputHandler(outputhandler3))
            outputhandler3 = (OutputHandler)iterator5.next();

        OutputHandler outputhandler4;
        for(Iterator iterator6 = C2.iterator(); iterator6.hasNext(); directgraphmlwriter.addOutputHandler(outputhandler4, 6))
            outputhandler4 = (OutputHandler)iterator6.next();

        return directgraphmlwriter;
    }

    public boolean S()
    {
        return z;
    }

    public boolean Q()
    {
        return o;
    }

    public void A(b b, OutputStream outputstream)
        throws IOException
    {
        if(b == null || outputstream == null)
        {
            return;
        } else
        {
            DomXmlWriter domxmlwriter = A(outputstream);
            DirectGraphMLWriter directgraphmlwriter = C(b);
            A(((XmlWriter) (domxmlwriter)), ((D) (b)));
            A(directgraphmlwriter, ((D) (b)), ((XmlWriter) (domxmlwriter)));
            return;
        }
    }

    protected void A(XmlWriter xmlwriter, D d)
    {
        xmlwriter.setEncoding(A4);
    }

    private void A(DirectGraphMLWriter directgraphmlwriter, D d, XmlWriter xmlwriter)
        throws IOException
    {
        directgraphmlwriter.write(xmlwriter);
    }

    protected GraphElementProvider A(D d)
    {
        return new B.D.D.M(d);
    }

    protected DomXmlWriter A(OutputStream outputstream)
        throws UnsupportedEncodingException
    {
        return new DomXmlWriter(new OutputStreamWriter(outputstream, R()));
    }

    public void A(b b, InputStream inputstream)
        throws IOException
    {
        DOMGraphMLParser domgraphmlparser = B(b);
        domgraphmlparser.parse(inputstream, new B());
    }

    protected DOMGraphMLParser B(D d)
    {
        DOMGraphMLParser domgraphmlparser = new DOMGraphMLParser();
        domgraphmlparser.getDocumentBuilderFactory().setValidating(w);
        domgraphmlparser.getDocumentBuilderFactory().setNamespaceAware(true);
        if(q != null)
            domgraphmlparser.setParseErrorHandler(M());
        else
            domgraphmlparser.setParseErrorHandler(new _C(domgraphmlparser.getParseErrorHandler()));
        if(!S())
        {
            B.D.D.D d1 = new B.D.D.D();
            F f = new F();
            domgraphmlparser.addDOMInputHandler(d1);
            domgraphmlparser.addDOMInputHandler(f);
            domgraphmlparser.setContextLookup(B.D.D.B.class, O());
            G g = G.H(d);
            if(g != null)
                domgraphmlparser.addXMLAttributeParser(new a(g));
        }
        domgraphmlparser.setContextProperty("useEmbeddedResources", Boolean.valueOf(P()));
        GraphElementFactory graphelementfactory = D(d);
        domgraphmlparser.setGraphElementFactory(graphelementfactory);
        if(AA != null)
            domgraphmlparser.setIdAcceptor(new _B());
        DOMInputHandler dominputhandler;
        for(Iterator iterator = B5.iterator(); iterator.hasNext(); domgraphmlparser.addDOMInputHandler(dominputhandler))
            dominputhandler = (DOMInputHandler)iterator.next();

        return domgraphmlparser;
    }

    protected GraphElementFactory D(D d)
    {
        return new e(d);
    }

    protected boolean o;
    protected boolean r;
    protected boolean w;
    protected boolean z;
    protected List B5;
    protected List t;
    protected List C1;
    protected List C2;
    protected List u;
    protected List A5;
    private boolean n;
    private String A4;
    private boolean x;
    private boolean s;
    private B.D.D.B C0;
    private GraphMLParseErrorHandler q;
    private String y;
    A A2;
    private Map v;
    private Map BA;
    private M A3;
    private M m;
    private C.A.G AA;
    private C.A.G p;
    static Class class$C$J$Y; /* synthetic field */
    static Class class$C$J$U; /* synthetic field */
    static Class class$org$w3c$dom$Node; /* synthetic field */




}
