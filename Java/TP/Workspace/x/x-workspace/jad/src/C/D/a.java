// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.util.*;

// Referenced classes of package C.D:
//            T

public class a extends T
{

    public a()
    {
        D = new ArrayList();
        E = false;
    }

    public void B(String s)
        throws MissingResourceException
    {
        A(ResourceBundle.getBundle(s));
    }

    public void A(ResourceBundle resourcebundle)
    {
        if(resourcebundle != null)
            D.add(resourcebundle);
    }

    private List D;
    private boolean E;
}
