// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftDoublyIndexedTable
{
    protected class Entry extends SoftReference
    {

        public boolean match(Object obj, Object obj1)
        {
            if(key1 != null)
            {
                if(!key1.equals(obj))
                    return false;
            } else
            if(obj != null)
                return false;
            if(key2 != null)
                return key2.equals(obj1);
            else
                return obj1 == null;
        }

        public int hash;
        public Object key1;
        public Object key2;
        public Entry next;

        public Entry(int i, Object obj, Object obj1, Object obj2, Entry entry)
        {
            SoftReference(obj2, referenceQueue);
            hash = i;
            key1 = obj;
            key2 = obj1;
            next = entry;
        }
    }


    public SoftDoublyIndexedTable()
    {
        referenceQueue = new ReferenceQueue();
        table = new Entry[11];
    }

    public SoftDoublyIndexedTable(int i)
    {
        referenceQueue = new ReferenceQueue();
        table = new Entry[i];
    }

    public int size()
    {
        return count;
    }

    public Object get(Object obj, Object obj1)
    {
        int i = hashCode(obj, obj1) & 0x7fffffff;
        int j = i % table.length;
        for(Entry entry = table[j]; entry != null; entry = entry.next)
            if(entry.hash == i && entry.match(obj, obj1))
                return entry.get();

        return null;
    }

    public Object put(Object obj, Object obj1, Object obj2)
    {
        removeClearedEntries();
        int i = hashCode(obj, obj1) & 0x7fffffff;
        int j = i % table.length;
        Entry entry = table[j];
        if(entry != null)
        {
            if(entry.hash == i && entry.match(obj, obj1))
            {
                Object obj3 = entry.get();
                table[j] = new Entry(i, obj, obj1, obj2, entry.next);
                return obj3;
            }
            Entry entry1 = entry;
            for(entry = entry.next; entry != null; entry = entry.next)
            {
                if(entry.hash == i && entry.match(obj, obj1))
                {
                    Object obj4 = entry.get();
                    entry = new Entry(i, obj, obj1, obj2, entry.next);
                    entry1.next = entry;
                    return obj4;
                }
                entry1 = entry;
            }

        }
        int k = table.length;
        if(count++ >= k * 3 >>> 2)
        {
            rehash();
            j = i % table.length;
        }
        table[j] = new Entry(i, obj, obj1, obj2, table[j]);
        return null;
    }

    public void clear()
    {
        table = new Entry[11];
        count = 0;
        referenceQueue = new ReferenceQueue();
    }

    protected void rehash()
    {
        Entry aentry[] = table;
        table = new Entry[aentry.length * 2 + 1];
        for(int i = aentry.length - 1; i >= 0; i--)
        {
            for(Entry entry = aentry[i]; entry != null;)
            {
                Entry entry1 = entry;
                entry = entry.next;
                int j = entry1.hash % table.length;
                entry1.next = table[j];
                table[j] = entry1;
            }

        }

    }

    protected int hashCode(Object obj, Object obj1)
    {
        int i = obj != null ? obj.hashCode() : 0;
        return i ^ (obj1 != null ? obj1.hashCode() : 0);
    }

    protected void removeClearedEntries()
    {
        Entry entry;
label0:
        for(; (entry = (Entry)referenceQueue.poll()) != null; count--)
        {
            int i = entry.hash % table.length;
            Entry entry1 = table[i];
            if(entry1 == entry)
            {
                table[i] = entry.next;
                continue;
            }
            do
            {
                if(entry1 == null)
                    continue label0;
                Entry entry2 = entry1.next;
                if(entry2 == entry)
                {
                    entry1.next = entry.next;
                    continue label0;
                }
                entry1 = entry2;
            } while(true);
        }

    }

    protected static final int INITIAL_CAPACITY = 11;
    protected Entry table[];
    protected int count;
    protected ReferenceQueue referenceQueue;
}
