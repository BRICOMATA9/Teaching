// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;

import java.util.EventObject;

// Referenced classes of package C.A:
//            D, T, J

public class C extends EventObject
{

    public C(D d, byte byte0, Object obj)
    {
        super(d);
        A = byte0;
        B = obj;
    }

    public byte A()
    {
        return A;
    }

    public Object B()
    {
        return B;
    }

    public D C()
    {
        return (D)getSource();
    }

    public String toString()
    {
        return A(A());
    }

    private String A(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return "NODE_CREATION";

        case 1: // '\001'
            return "EDGE_CREATION";

        case 2: // '\002'
            return "PRE_NODE_REMOVAL";

        case 3: // '\003'
            return "POST_NODE_REMOVAL";

        case 4: // '\004'
            return "PRE_EDGE_REMOVAL";

        case 5: // '\005'
            return "POST_EDGE_REMOVAL";

        case 6: // '\006'
            return "NODE_REINSERTION";

        case 7: // '\007'
            return "EDGE_REINSERTION";

        case 8: // '\b'
            return "PRE_EDGE_CHANGE";

        case 9: // '\t'
            return "POST_EDGE_CHANGE";

        case 10: // '\n'
            return "SUBGRAPH_INSERTION";

        case 11: // '\013'
            return "SUBGRAPH_REMOVAL";

        case 12: // '\f'
            return "PRE_EVENT";

        case 13: // '\r'
            return "POST_EVENT";
        }
        return "UNKNOWN TYPE (" + byte0 + ")";
    }

    static C A(D d, T t)
    {
        return new C(d, (byte)0, t);
    }

    static C C(D d, J j)
    {
        return new C(d, (byte)1, j);
    }

    static C D(D d, T t)
    {
        return new C(d, (byte)2, t);
    }

    static C C(D d, T t)
    {
        return new C(d, (byte)3, t);
    }

    static C B(D d, J j)
    {
        return new C(d, (byte)4, j);
    }

    static C A(D d, J j)
    {
        return new C(d, (byte)5, j);
    }

    static C B(D d, T t)
    {
        return new C(d, (byte)6, t);
    }

    static C D(D d, J j)
    {
        return new C(d, (byte)7, j);
    }

    static C B(D d)
    {
        return new C(d, (byte)12, null);
    }

    static C A(D d)
    {
        return new C(d, (byte)13, null);
    }

    private Object B;
    private byte A;
}
