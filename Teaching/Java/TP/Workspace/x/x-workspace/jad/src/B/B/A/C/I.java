// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.E;
import C.A.M;
import C.J.*;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package B.B.A.C:
//            B, M

class I extends B
{

    I(E e, Y y, M m)
    {
        super(e, y, m);
    }

    I(B b, Y y)
    {
        super(b, y);
    }

    public B.B.A.C.M B(Y y)
    {
        return new I(this, y);
    }

    protected void C(Y y, double d, double d1, double d2, 
            double d3)
    {
        if(y instanceof g)
            switch(((g)y).E3())
            {
            case 2: // '\002'
            case 7: // '\007'
            case 8: // '\b'
                double d4 = 0.0D;
                double d7 = 0.0D;
                for(Iterator iterator1 = O.iterator(); iterator1.hasNext();)
                {
                    DA da1 = (DA)iterator1.next();
                    d4 = Math.max(da1.g(), d4);
                    d7 += da1.V();
                }

                double d10 = (d + 0.5D * d2) - 0.5D * d4;
                double d13 = (d1 + 0.5D * d3) - 0.5D * d7;
                super.C(y, d10, d13, d4, (d1 + d3) - d13);
                break;

            case 3: // '\003'
            case 4: // '\004'
            case 9: // '\t'
            case 10: // '\n'
                double d5 = 0.0D;
                for(Iterator iterator = O.iterator(); iterator.hasNext();)
                {
                    DA da = (DA)iterator.next();
                    d5 = Math.max(da.g(), d5);
                }

                double d8 = (d + 0.5D * d2) - 0.5D * d5;
                double d11 = d1;
                super.C(y, d8, d11, d5, (d1 + d3) - d11);
                break;

            case 5: // '\005'
                double d6 = 0.0D;
                double d9 = 0.0D;
                for(Iterator iterator2 = O.iterator(); iterator2.hasNext();)
                {
                    DA da2 = (DA)iterator2.next();
                    d6 = Math.max(da2.g(), d6);
                    d9 += da2.V();
                }

                double d12 = (d + 0.5D * d2) - 0.5D * d6;
                double d14 = (d1 + d3) - d9;
                super.C(y, d12, d14, d6, (d1 + d3) - d14);
                break;

            case 6: // '\006'
            default:
                super.C(y, d, d1, d2, d3);
                break;
            }
        else
            super.C(y, d, d1, d2, d3);
    }
}
