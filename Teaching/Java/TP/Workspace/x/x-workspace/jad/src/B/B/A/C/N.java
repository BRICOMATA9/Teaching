// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.H;
import C.A.M;
import C.J.DA;
import C.J.Y;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package B.B.A.C:
//            L, M

public class N extends L
{

    public N(Collection collection, Y y, M m, B.B.A.H h)
    {
        B((Color)m.D("section.fill.color"));
        A((Color)m.D("section.gradient.color"));
        Font font = (Font)m.D("section.feature.font");
        Color color = (Color)m.D("section.feature.text.color");
        Insets insets = new Insets(1, 4, 1, 4);
        DA da;
        for(Iterator iterator = collection.iterator(); iterator.hasNext(); O.add(da))
        {
            H h1 = (H)iterator.next();
            da = y.E();
            da.B((byte)4);
            da.D((byte)0);
            da.C((byte)2);
            da.E((byte)16);
            y.C(da);
            if(Modifier.isStatic(h1.D()))
                da.B(true);
            da.B(h.B(h1));
            da.A(h.C(h1));
            da.A(font);
            da.C(color);
            da.A(insets);
        }

    }

    protected N(N n, Y y)
    {
        super(n, y);
        int i = n.O.size();
        O = new ArrayList(i);
        for(int j = 0; j < i; j++)
        {
            DA da = y.E();
            da.A((DA)n.O.get(j));
            y.C(da);
            O.add(da);
        }

    }

    public B.B.A.C.M B(Y y)
    {
        return new N(this, y);
    }
}
