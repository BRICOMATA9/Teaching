// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.*;
import java.util.*;

public class ClassFileUtilities
{

    protected ClassFileUtilities()
    {
    }

    public static Set getClassDependencies(String s, Set set)
        throws IOException
    {
        FileInputStream fileinputstream = new FileInputStream(s);
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        computeClassDependencies(fileinputstream, set, hashset1, hashset);
        return hashset;
    }

    private static void computeClassDependencies(InputStream inputstream, Set set, Set set1, Set set2)
        throws IOException
    {
        for(Iterator iterator = getClassDependencies(inputstream).iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if(!set1.contains(s))
            {
                set1.add(s);
                Iterator iterator1 = set.iterator();
                while(iterator1.hasNext()) 
                {
                    String s1 = (String)iterator1.next();
                    StringBuffer stringbuffer = new StringBuffer(s1);
                    stringbuffer.append('/').append(s).append(".class");
                    String s2 = stringbuffer.toString();
                    File file = new File(s2);
                    if(file.isFile())
                    {
                        set2.add(s2);
                        computeClassDependencies(((InputStream) (new FileInputStream(file))), set, set1, set2);
                    }
                }
            }
        }

    }

    public static Set getClassDependencies(InputStream inputstream)
        throws IOException
    {
        DataInputStream datainputstream = new DataInputStream(inputstream);
        if(datainputstream.readInt() != 0xcafebabe)
            throw new IOException("Invalid classfile");
        datainputstream.readInt();
        short word0 = datainputstream.readShort();
        String as[] = new String[word0];
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        for(int i = 1; i < word0; i++)
            switch(datainputstream.readByte() & 0xff)
            {
            case 5: // '\005'
            case 6: // '\006'
                datainputstream.readLong();
                i++;
                break;

            case 3: // '\003'
            case 4: // '\004'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
                datainputstream.readInt();
                break;

            case 7: // '\007'
                hashset.add(new Integer(datainputstream.readShort() & 0xffff));
                break;

            case 8: // '\b'
                datainputstream.readShort();
                break;

            case 12: // '\f'
                datainputstream.readShort();
                hashset1.add(new Integer(datainputstream.readShort() & 0xffff));
                break;

            case 1: // '\001'
                as[i] = datainputstream.readUTF();
                break;

            case 2: // '\002'
            default:
                throw new RuntimeException();
            }

        HashSet hashset2 = new HashSet();
        for(Iterator iterator = hashset.iterator(); iterator.hasNext(); hashset2.add(as[((Integer)iterator.next()).intValue()]));
        for(Iterator iterator1 = hashset1.iterator(); iterator1.hasNext(); hashset2.addAll(getDescriptorClasses(as[((Integer)iterator1.next()).intValue()])));
        return hashset2;
    }

    protected static Set getDescriptorClasses(String s)
    {
        HashSet hashset = new HashSet();
        int i = 0;
        char c = s.charAt(i);
label0:
        switch(c)
        {
        default:
            break;

        case 40: // '('
            char c1;
label1:
            while(true) 
            {
                c1 = s.charAt(++i);
                switch(c1)
                {
                default:
                    break;

                case 91: // '['
                    do
                        c1 = s.charAt(++i);
                    while(c1 == '[');
                    if(c1 != 'L')
                        break;
                    // fall through

                case 76: // 'L'
                    c1 = s.charAt(++i);
                    StringBuffer stringbuffer = new StringBuffer();
                    for(; c1 != ';'; c1 = s.charAt(++i))
                        stringbuffer.append(c1);

                    hashset.add(stringbuffer.toString());
                    break;

                case 41: // ')'
                    c1 = s.charAt(++i);
                    break label1;
                }
            }
            switch(c1)
            {
            case 86: // 'V'
            default:
                break;

            case 91: // '['
                char c2;
                do
                    c2 = s.charAt(++i);
                while(c2 == '[');
                if(c2 != 'L')
                    break label0;
                // fall through

            case 76: // 'L'
                char c3 = s.charAt(++i);
                StringBuffer stringbuffer1 = new StringBuffer();
                for(; c3 != ';'; c3 = s.charAt(++i))
                    stringbuffer1.append(c3);

                hashset.add(stringbuffer1.toString());
                break;
            }
            break;

        case 91: // '['
            char c4;
            do
                c4 = s.charAt(++i);
            while(c4 == '[');
            if(c4 != 'L')
                break;
            // fall through

        case 76: // 'L'
            char c5 = s.charAt(++i);
            StringBuffer stringbuffer2 = new StringBuffer();
            for(; c5 != ';'; c5 = s.charAt(++i))
                stringbuffer2.append(c5);

            hashset.add(stringbuffer2.toString());
            break;
        }
        return hashset;
    }

    public static final byte CONSTANT_UTF8_INFO = 1;
    public static final byte CONSTANT_INTEGER_INFO = 3;
    public static final byte CONSTANT_FLOAT_INFO = 4;
    public static final byte CONSTANT_LONG_INFO = 5;
    public static final byte CONSTANT_DOUBLE_INFO = 6;
    public static final byte CONSTANT_CLASS_INFO = 7;
    public static final byte CONSTANT_STRING_INFO = 8;
    public static final byte CONSTANT_FIELDREF_INFO = 9;
    public static final byte CONSTANT_METHODREF_INFO = 10;
    public static final byte CONSTANT_INTERFACEMETHODREF_INFO = 11;
    public static final byte CONSTANT_NAMEANDTYPE_INFO = 12;
}
