// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import C.A.Y;
import java.util.*;

// Referenced classes of package C.D:
//            L, a

class O
    implements L
{

    O()
    {
        A = true;
        B = new HashMap();
        C = new Y();
    }

    void A(boolean flag)
    {
        A = flag;
    }

    public void A(String s)
    {
        C.add(s);
        for(Iterator iterator = B.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                ResourceBundle resourcebundle = ResourceBundle.getBundle(s, (Locale)entry.getKey());
                ((a)entry.getValue()).A(resourcebundle);
            }
            catch(MissingResourceException missingresourceexception) { }
        }

    }

    private boolean A;
    private HashMap B;
    private Y C;
}
