// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package C.G:
//            g, k, I

public class h extends g
{

    public h()
    {
        ED = new ArrayList();
    }

    public void C(k k1)
    {
        ED.add(k1);
    }

    public void A(I i)
    {
        for(int j = 0; j < ED.size() - 1; j++)
            A(j).A(A(j + 1));

        A(ED.size() - 1).A(_());
        A(0).A(i);
    }

    private k A(int i)
    {
        return (k)ED.get(i);
    }

    private List ED;
}
