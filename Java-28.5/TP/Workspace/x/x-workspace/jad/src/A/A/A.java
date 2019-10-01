// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.A;

import A.B.G;
import C.D.Y;
import C.G.j;

// Referenced classes of package A.A:
//            B

public class A extends B
{

    public A()
    {
        super("TYPE_LAYOUT_MODULE");
        A(false);
    }

    protected Y F()
    {
        G g = new G();
        Y y = new Y(E());
        y.A("PACKAGE_DISTANCE", g.N());
        y.A("RELATION_DISTANCE", g.M());
        y.A("RELATION_TYPE_DISTANCE", g.J());
        y.A("RELATION_BUS_ROUTING", g.O());
        y.A("RELATION_TYPE_ALIGNMENT", W, A(V, g.L()));
        y.A("RELATION_TYPE_LABEL_LAYOUT_POLICY", X, A(U, g.K()));
        return y;
    }

    public j O()
    {
        G g = new G();
        Y y = C();
        g.A(y.F("PACKAGE_DISTANCE"));
        g.C(y.F("RELATION_DISTANCE"));
        g.B(y.F("RELATION_TYPE_DISTANCE"));
        g.K(y.H("RELATION_BUS_ROUTING"));
        g.E(V[y.G("RELATION_TYPE_ALIGNMENT")]);
        g.D(U[y.G("RELATION_TYPE_LABEL_LAYOUT_POLICY")]);
        return g;
    }

    public String toString()
    {
        Y y = C();
        return "TypeLayoutModule[\nPACKAGE_DISTANCE=" + y.F("PACKAGE_DISTANCE") + ";\n" + "RELATION_DISTANCE" + "=" + y.F("RELATION_DISTANCE") + ";\n" + "RELATION_BUS_ROUTING" + "=" + y.H("RELATION_BUS_ROUTING") + ";\n" + "RELATION_TYPE_ALIGNMENT" + "=" + y.E("RELATION_TYPE_ALIGNMENT") + ";\n" + "RELATION_TYPE_DISTANCE" + "=" + y.F("RELATION_TYPE_DISTANCE") + ";\n" + "RELATION_TYPE_LABEL_LAYOUT_POLICY" + "=" + y.E("RELATION_TYPE_LABEL_LAYOUT_POLICY") + "\n" + "]";
    }

    private static final String W[] = {
        "LEFT", "CENTER", "RIGHT", "SHORTEST_DISTANCE", "LONGEST_DISTANCE"
    };
    private static final String X[] = {
        "AS_IS", "OUTWARDS"
    };
    private static final byte V[] = {
        0, 1, 2, 3, 4
    };
    private static final byte U[] = {
        0, 1
    };

}
