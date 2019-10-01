// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.util.*;

public class TranscodingHints extends HashMap
{
    public static abstract class Key
    {

        public abstract boolean isCompatibleValue(Object obj);

        protected Key()
        {
        }
    }


    public TranscodingHints()
    {
        TranscodingHints(null);
    }

    public TranscodingHints(Map map)
    {
        HashMap(7);
        if(map != null)
            putAll(map);
    }

    public boolean containsKey(Object obj)
    {
        return containsKey(obj);
    }

    public Object get(Object obj)
    {
        return get(obj);
    }

    public Object put(Object obj, Object obj1)
    {
        if(!((Key)obj).isCompatibleValue(obj1))
            throw new IllegalArgumentException(obj1 + " incompatible with " + obj);
        else
            return put(obj, obj1);
    }

    public Object remove(Object obj)
    {
        return remove(obj);
    }

    public void putAll(TranscodingHints transcodinghints)
    {
        putAll(transcodinghints);
    }

    public void putAll(Map map)
    {
        if(map instanceof TranscodingHints)
        {
            putAll((TranscodingHints)map);
        } else
        {
            java.util.Map.Entry entry;
            for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); put(entry.getKey(), entry.getValue()))
                entry = (java.util.Map.Entry)iterator.next();

        }
    }
}
