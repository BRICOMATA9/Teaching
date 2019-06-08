// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import java.awt.geom.Line2D;

// Referenced classes of package B.B.A.C:
//            O

class F
{

    public static F A()
    {
        return (F)A.get();
    }

    F()
    {
    }

    static final ThreadLocal A = new ThreadLocal() {

        public Object initialValue()
        {
            return new F();
        }

    };
    public final O B = new O();
    public final Line2D C = new java.awt.geom.Line2D.Double();

}
