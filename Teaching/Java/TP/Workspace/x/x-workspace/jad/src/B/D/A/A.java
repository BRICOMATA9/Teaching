// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.A;

import C.A.*;
import C.E.M;
import java.util.HashMap;
import java.util.Map;
import org.graphdrawing.graphml.attr.AttributeFactory;
import org.graphdrawing.graphml.reader.GraphElementFactory;
import org.graphdrawing.graphml.reader.GraphMLParseContext;

public class A
    implements GraphElementFactory, AttributeFactory
{
    protected class _A
    {

        String B;
        int A;
        int C;

        protected _A(String s, int i, int j)
        {
            B = s;
            A = i;
            C = j;
        }
    }


    public A(Class class1)
    {
        B = class1;
        E = new Y();
        C = new Y();
        D = new Y();
        A = new HashMap();
    }

    public A(D d)
    {
        this(d.getClass());
        d.R();
        D.add(d);
    }

    public Object createGraphML(GraphMLParseContext graphmlparsecontext)
    {
        return null;
    }

    public Object createGraph(GraphMLParseContext graphmlparsecontext, String s, int i)
    {
        Object obj;
        if(D.isEmpty())
            try
            {
                obj = B.newInstance();
            }
            catch(Exception exception)
            {
                return null;
            }
        else
            obj = D.C();
        E.add(obj);
        D d = (D)obj;
        for(I j = C.B(); j.C(); j.B())
        {
            _A _la = (_A)j.D();
            if(d.B(_la.B) != null)
                continue;
            switch(_la.A)
            {
            case 1: // '\001'
                d.A(_la.B, d.W());
                break;

            case 2: // '\002'
                d.A(_la.B, d.V());
                break;

            default:
                throw new RuntimeException("Unsupported attribute type: " + _la.A);
            }
        }

        return obj;
    }

    public Object createNode(GraphMLParseContext graphmlparsecontext, String s)
    {
        M.A("node added: " + s);
        D d = (D)graphmlparsecontext.getCurrentContainer();
        T t = d.K();
        return t;
    }

    public Object createEdge(GraphMLParseContext graphmlparsecontext, String s, Object obj, Object obj1, Object obj2, Object obj3, boolean flag)
    {
        M.A("edge added: " + s);
        D d = (D)graphmlparsecontext.getCurrentContainer();
        T t = (T)obj;
        T t1 = (T)obj1;
        J j = d.B(t, t1);
        return j;
    }

    public Object createPort(GraphMLParseContext graphmlparsecontext, Object obj, String s)
    {
        return null;
    }

    public Object createHyperEdge(GraphMLParseContext graphmlparsecontext, String s)
    {
        return null;
    }

    public Object createEndPoint(GraphMLParseContext graphmlparsecontext, String s, Object obj, Object obj1, int i)
    {
        return null;
    }

    public void defineAttribute(String s, int i, int j)
    {
        _A _la = new _A(s, j, i);
        C.add(_la);
        A.put(s, _la);
    }

    public void createAttribute(GraphMLParseContext graphmlparsecontext, String s, String s1)
    {
        D d = (D)graphmlparsecontext.getSecondToCurrentContainer();
        Object obj = graphmlparsecontext.getCurrentContainer();
        C.A.M m = d.B(s);
        _A _la = (_A)A.get(s);
        if(obj instanceof T)
        {
            T t = (T)obj;
            K k = (K)m;
            switch(_la.C)
            {
            case 4: // '\004'
                k.A(t, Double.parseDouble(s1));
                break;

            case 3: // '\003'
                k.A(t, Float.parseFloat(s1));
                break;

            case 1: // '\001'
                k.A(t, Integer.parseInt(s1));
                break;

            case 2: // '\002'
                k.A(t, (int)Long.parseLong(s1));
                break;

            case 5: // '\005'
                k.A(t, s1);
                break;

            case 6: // '\006'
                k.A(t, "true".equalsIgnoreCase(s1));
                break;

            default:
                throw new RuntimeException("Undefined Attribute type: " + _la.C);
            }
        } else
        if(obj instanceof J)
        {
            J j = (J)obj;
            L l = (L)m;
            switch(_la.C)
            {
            case 4: // '\004'
                l.A(j, Double.parseDouble(s1));
                break;

            case 3: // '\003'
                l.A(j, Float.parseFloat(s1));
                break;

            case 1: // '\001'
                l.A(j, Integer.parseInt(s1));
                break;

            case 2: // '\002'
                l.A(j, (int)Long.parseLong(s1));
                break;

            case 5: // '\005'
                l.A(j, s1);
                break;

            case 6: // '\006'
                l.A(j, Boolean.valueOf(s1).booleanValue());
                break;

            default:
                throw new RuntimeException("Undefined Attribute type: " + _la.C);
            }
        }
    }

    protected Y E;
    protected Y D;
    protected Class B;
    protected Y C;
    protected Map A;
}
