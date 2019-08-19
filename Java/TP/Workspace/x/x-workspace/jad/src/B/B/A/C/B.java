// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.E;
import C.A.M;
import C.J.DA;
import C.J.Y;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

// Referenced classes of package B.B.A.C:
//            L

abstract class B extends L
{

    B(E e, Y y, M m)
    {
        B((Color)m.D("header.fill.color"));
        A((Color)m.D("header.gradient.color"));
        for(int i = y.L(); i-- > 0;)
            y.A(y.A(i));

        y.B(y.E());
        String s = (String)m.D("stereotype.label.text");
        if(s != null && s.trim().length() > 0)
        {
            DA da = y.E();
            y.C(da);
            da.B((byte)4);
            O.add(da);
            da.B(s);
            da.C((Color)m.D("stereotype.label.text.color"));
            da.A((Font)m.D("stereotype.label.font"));
            da.D((byte)1);
        }
        DA da1 = y.H();
        da1.B((byte)4);
        O.add(da1);
        R = da1;
        da1.B(e.E());
        da1.C((Color)m.D("name.label.text.color"));
        da1.A((Font)m.D("name.label.font"));
        da1.D((byte)1);
        String s1 = (String)m.D("type.label.text");
        if(s1 != null && s1.trim().length() > 0)
        {
            DA da2 = y.E();
            y.C(da2);
            da2.B((byte)4);
            O.add(da2);
            da2.B(s1);
            da2.C((Color)m.D("type.label.text.color"));
            da2.A((Font)m.D("type.label.font"));
            da2.D((byte)0);
        }
        String s2 = (String)m.D("constraint.label.text");
        if(s2 != null && s2.trim().length() > 0)
        {
            DA da3 = y.E();
            y.C(da3);
            da3.B((byte)4);
            O.add(da3);
            da3.B(s2);
            da3.C((Color)m.D("constraint.label.text.color"));
            da3.A((Font)m.D("constraint.label.font"));
            da3.D((byte)2);
        }
        int j = O.size();
        if(j == 1)
            ((DA)O.get(0)).A(new Insets(4, 4, 4, 4));
        else
        if(j > 1)
        {
            ((DA)O.get(0)).A(new Insets(2, 4, 1, 4));
            Insets insets = new Insets(1, 4, 1, 4);
            int k = 1;
            for(int l = j - 1; k < l; k++)
                ((DA)O.get(k)).A(insets);

            ((DA)O.get(j - 1)).A(new Insets(1, 4, 2, 4));
        }
    }

    B(B b, Y y)
    {
        super(b, y);
        for(int i = y.L(); i-- > 0;)
            y.A(y.A(i));

        y.B(y.E());
        R = y.H();
        int j = b.O.size();
        O = new ArrayList(j);
        for(int k = 0; k < j; k++)
        {
            DA da = (DA)b.O.get(k);
            DA da1;
            if(da != b.R)
            {
                da1 = y.E();
                y.C(da1);
            } else
            {
                da1 = R;
            }
            da1.A(da);
            O.add(da1);
        }

    }

    DA N()
    {
        return R;
    }

    private final DA R;
}
