// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.A;

import A.B.M;
import C.D.Y;
import C.G.j;

// Referenced classes of package A.A:
//            B

public class D extends B
{

    public D()
    {
        super("OVERVIEW_LAYOUT_MODULE");
        A(false);
    }

    protected Y F()
    {
        M m = new M();
        Y y = new Y(E());
        y.A("ORIENTATION", T, A(Q, m.F()));
        y.A("REVERSE_EDGES", m.D());
        y.A("ROUTE_ORTHOGONAL", m.A());
        y.A("BUS_ROUTING", m.C());
        y.A("GROUP_COMPACTION", m.H());
        y.A("RECURSIVE_GROUP_LAYERING", m.G());
        y.A("CYCLE_LAYERING_POLICY", R, A(S, m.I()));
        return y;
    }

    public j O()
    {
        M m = new M();
        Y y = C();
        int i = y.G("ORIENTATION");
        m.B(Q[i]);
        switch(Q[i])
        {
        case 0: // '\0'
            m.J(false);
            m.G(false);
            m.E(false);
            m.I(true);
            break;

        case 1: // '\001'
            m.J(true);
            m.G(false);
            m.E(true);
            m.I(false);
            break;

        case 3: // '\003'
            m.J(false);
            m.G(true);
            m.E(false);
            m.I(false);
            break;

        case 2: // '\002'
            m.J(false);
            m.G(true);
            m.E(false);
            m.I(true);
            break;
        }
        m.B(y.H("REVERSE_EDGES"));
        m.F(y.H("ROUTE_ORTHOGONAL"));
        m.A(y.H("BUS_ROUTING"));
        m.H(y.H("GROUP_COMPACTION"));
        m.D(y.H("RECURSIVE_GROUP_LAYERING"));
        m.C(S[y.G("CYCLE_LAYERING_POLICY")]);
        return m;
    }

    public String toString()
    {
        Y y = C();
        return "OverviewLayoutModule[\nORIENTATION=" + y.E("ORIENTATION") + ";\n" + "REVERSE_EDGES" + "=" + y.H("REVERSE_EDGES") + ";\n" + "ROUTE_ORTHOGONAL" + "=" + y.H("ROUTE_ORTHOGONAL") + ";\n" + "BUS_ROUTING" + "=" + y.H("BUS_ROUTING") + ";\n" + "GROUP_COMPACTION" + "=" + y.H("GROUP_COMPACTION") + ";\n" + "RECURSIVE_GROUP_LAYERING" + "=" + y.H("RECURSIVE_GROUP_LAYERING") + ";\n" + "CYCLE_LAYERING_POLICY" + "=" + y.E("CYCLE_LAYERING_POLICY") + "\n" + "]";
    }

    private static final String T[] = {
        "TOP_TO_BOTTOM", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "BOTTOM_TO_TOP"
    };
    private static final String R[] = {
        "DEFAULT_POLICY", "ASSIGN_CYCLES_TO_SAME_LAYER_POLICY", "BREAK_CYCLES_BY_WEIGHT_POLICY"
    };
    private static final byte Q[] = {
        0, 1, 3, 2
    };
    private static final byte S[] = {
        0, 1, 2
    };

}
