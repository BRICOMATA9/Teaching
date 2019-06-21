// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.A;

import A.B.I;
import C.D.Y;
import C.G.j;

// Referenced classes of package A.A:
//            B

public class C extends B
{

    public C()
    {
        super("PACKAGE_LAYOUT_MODULE");
        A(false);
    }

    protected Y F()
    {
        I i = new I();
        Y y = new Y(E());
        y.A("ORIENTATION", P, A(O, i.E()));
        y.A("REVERSE_EDGES", i.D());
        y.A("ROUTE_ORTHOGONAL", i.A());
        y.A("BUS_ROUTING", i.C());
        return y;
    }

    public j O()
    {
        I i = new I();
        Y y = C();
        i.A(O[y.G("ORIENTATION")]);
        i.B(y.H("REVERSE_EDGES"));
        i.C(y.H("ROUTE_ORTHOGONAL"));
        i.A(y.H("BUS_ROUTING"));
        return i;
    }

    public String toString()
    {
        Y y = C();
        return "PackageLayoutModule[\nORIENTATION=" + y.E("ORIENTATION") + ";\n" + "REVERSE_EDGES" + "=" + y.H("REVERSE_EDGES") + ";\n" + "ROUTE_ORTHOGONAL" + "=" + y.H("ROUTE_ORTHOGONAL") + ";\n" + "BUS_ROUTING" + "=" + y.H("BUS_ROUTING") + "\n" + "]";
    }

    private static final String P[] = {
        "TOP_TO_BOTTOM", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "BOTTOM_TO_TOP"
    };
    private static final byte O[] = {
        0, 1, 3, 2
    };

}
