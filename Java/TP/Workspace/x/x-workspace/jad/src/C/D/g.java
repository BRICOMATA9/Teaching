// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.util.*;

// Referenced classes of package C.D:
//            J

public class g
    implements J
{

    public g(Properties properties)
    {
        A = properties;
    }

    public Map A(String s)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = A.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s1 = (String)entry.getKey();
            if(s1.startsWith(s))
            {
                StringTokenizer stringtokenizer = new StringTokenizer(s1.substring(s.length()), ".", false);
                Object obj = hashmap;
                while(stringtokenizer.hasMoreTokens()) 
                {
                    String s2 = stringtokenizer.nextToken();
                    boolean flag = !stringtokenizer.hasMoreTokens();
                    if(flag)
                    {
                        ((Map) (obj)).put(s2, entry.getValue());
                    } else
                    {
                        Object obj1 = (Map)((Map) (obj)).get(s2);
                        if(obj1 == null)
                        {
                            obj1 = new HashMap();
                            ((Map) (obj)).put(s2, obj1);
                        }
                        obj = obj1;
                    }
                }
            }
        } while(true);
        return hashmap;
    }

    Properties A;
}
