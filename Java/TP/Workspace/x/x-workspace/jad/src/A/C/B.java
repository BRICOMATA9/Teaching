// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.C;

import C.I.A;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class B
    implements A
{

    public B()
    {
    }

    public void B(String s, boolean flag)
    {
        B.add(s);
    }

    public void A(String s, boolean flag)
    {
        B.add(s);
    }

    public void A(String s, String s1)
    {
        B.add(s);
    }

    public void B(String s, String s1)
    {
        A.add(s);
    }

    public void A(String s, String s1, String s2, boolean flag, boolean flag1, int i)
    {
        if(flag)
            return;
        if(flag1)
            s2 = B(s2);
        B.add(s2);
    }

    public void A(String s, String s1, String s2, int i)
    {
        int j = s2.indexOf(')');
        A(s2.substring(1, j));
        A(s2.substring(j + 1, s2.length()));
    }

    private void A(String s)
    {
        int i = 0;
        do
        {
            if(i >= s.length())
                break;
            for(; s.charAt(i) == '['; i++);
            if(i < s.length())
                if(s.charAt(i) == 'L')
                {
                    int j = s.indexOf(';', i);
                    String s1 = s.substring(i + 1, j).replace('/', '.');
                    A.add(s1);
                    i = j + 1;
                } else
                {
                    i++;
                }
        } while(true);
    }

    public Collection A()
    {
        A.removeAll(B);
        return A;
    }

    private String B(String s)
    {
        if(s.charAt(0) == '[')
        {
            int i;
            for(i = 1; s.charAt(i) == '['; i++);
            s = s.substring(i + 1, s.length() - 1);
        }
        return s;
    }

    public static Collection A(URL url)
    {
        B b = new B();
        InputStream inputstream = null;
        inputstream = url.openStream();
        C.I.B b1 = new C.I.B(inputstream);
        b1.A(b);
        if(inputstream != null)
            inputstream.close();
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        if(inputstream != null)
            inputstream.close();
        throw exception;
        IOException ioexception;
        ioexception;
        return b.A();
    }

    private final Set A = new HashSet();
    private final Set B = new HashSet();
}
