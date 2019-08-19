// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Value
{

    public Value()
    {
    }

    public Value(Value value)
    {
        setValue(value);
    }

    public Value setValue(Value value)
    {
        type = value.getType();
        intValue = value.intValue;
        shortValue = value.shortValue;
        longValue = value.longValue;
        floatValue = value.floatValue;
        doubleValue = value.doubleValue;
        boolValue = value.boolValue;
        byteValue = value.byteValue;
        charValue = value.charValue;
        obj = value.obj;
        return this;
    }

    public Class getType()
    {
        return type;
    }

    public Value set(int i)
    {
        intValue = i;
        type = TYPE_INTEGER;
        return this;
    }

    public Value set(short word0)
    {
        shortValue = word0;
        type = TYPE_SHORT;
        return this;
    }

    public Value set(long l)
    {
        longValue = l;
        type = TYPE_LONG;
        return this;
    }

    public Value set(float f)
    {
        floatValue = f;
        type = TYPE_FLOAT;
        return this;
    }

    public Value set(double d)
    {
        doubleValue = d;
        type = TYPE_DOUBLE;
        return this;
    }

    public Value set(boolean flag)
    {
        boolValue = flag;
        type = TYPE_BOOLEAN;
        return this;
    }

    public Value set(byte byte0)
    {
        byteValue = byte0;
        type = TYPE_BYTE;
        return this;
    }

    public Value set(char c)
    {
        charValue = c;
        type = TYPE_CHAR;
        return this;
    }

    public Value set(String s)
    {
        obj = s;
        type = TYPE_STRING;
        return this;
    }

    public Value set(Date date)
    {
        obj = date;
        type = TYPE_DATE;
        return this;
    }

    public Value set(Object obj1)
    {
        obj = obj1;
        type = obj != null ? obj.getClass() : java.lang.Object.class;
        return this;
    }

    public int getInt()
    {
        if(type == TYPE_INTEGER)
            return intValue;
        if(type == TYPE_SHORT)
            return shortValue;
        if(type == TYPE_BYTE)
            return byteValue;
        else
            throw new ClassCastException("getInt cannot be called for type " + type.toString());
    }

    public short getShort()
    {
        if(type == TYPE_SHORT)
            return shortValue;
        if(type == TYPE_BYTE)
            return (short)byteValue;
        else
            throw new ClassCastException("getShort cannot be called for type " + type.toString());
    }

    public long getLong()
    {
        if(type == TYPE_LONG)
            return longValue;
        if(type == TYPE_INTEGER)
            return (long)intValue;
        if(type == TYPE_SHORT)
            return (long)shortValue;
        if(type == TYPE_BYTE)
            return (long)byteValue;
        else
            throw new ClassCastException("getLong cannot be called for type " + type.toString());
    }

    public float getFloat()
    {
        if(type == TYPE_FLOAT)
            return floatValue;
        if(type == TYPE_INTEGER)
            return (float)intValue;
        if(type == TYPE_SHORT)
            return (float)shortValue;
        if(type == TYPE_LONG)
            return (float)longValue;
        if(type == TYPE_BYTE)
            return (float)byteValue;
        else
            throw new ClassCastException("getFloat cannot be called for type " + type.toString());
    }

    public double getDouble()
    {
        if(type == TYPE_DOUBLE)
            return doubleValue;
        if(type == TYPE_INTEGER)
            return (double)intValue;
        if(type == TYPE_SHORT)
            return (double)shortValue;
        if(type == TYPE_LONG)
            return (double)longValue;
        if(type == TYPE_FLOAT)
            return (double)floatValue;
        if(type == TYPE_BYTE)
            return (double)byteValue;
        if(type == TYPE_DATE)
            return (double)((Date)obj).getTime();
        else
            throw new ClassCastException("getDouble cannot be called for type " + type.toString());
    }

    public boolean getBoolean()
    {
        if(type == TYPE_BOOLEAN)
            return boolValue;
        else
            throw new ClassCastException("getBoolean cannot be called for type " + type.toString());
    }

    public byte getByte()
    {
        if(type == TYPE_BYTE)
            return byteValue;
        else
            throw new ClassCastException("getByte cannot be called for type " + type.toString());
    }

    public char getChar()
    {
        if(type == TYPE_CHAR)
            return charValue;
        else
            throw new ClassCastException("getChar cannot be called for type " + type.toString());
    }

    public String getString()
    {
        if(type == TYPE_STRING)
            return (String)obj;
        if(type == TYPE_INTEGER)
            return String.valueOf(intValue);
        if(type == TYPE_SHORT)
            return String.valueOf(shortValue);
        if(type == TYPE_LONG)
            return String.valueOf(longValue);
        if(type == TYPE_FLOAT)
            return String.valueOf(floatValue);
        if(type == TYPE_DOUBLE)
            return String.valueOf(doubleValue);
        if(type == TYPE_BOOLEAN)
            return String.valueOf(boolValue);
        if(type == TYPE_BYTE)
            return String.valueOf(byteValue);
        if(type == TYPE_CHAR)
            return String.valueOf(charValue);
        if(type == TYPE_DATE)
            return ((Date)obj).toString();
        else
            return obj == null ? "null" : obj.toString();
    }

    public Date getDate()
    {
        if(type == TYPE_DATE)
            return (Date)obj;
        else
            throw new ClassCastException("getDate cannot be called for type " + type.toString());
    }

    public Object getObject()
    {
        if(obj != null)
            return obj;
        if(type == TYPE_INTEGER)
            return new Integer(intValue);
        if(type == TYPE_SHORT)
            return new Short(shortValue);
        if(type == TYPE_LONG)
            return new Long(longValue);
        if(type == TYPE_FLOAT)
            return new Float(floatValue);
        if(type == TYPE_DOUBLE)
            return new Double(doubleValue);
        if(type == TYPE_BOOLEAN)
            return new Boolean(boolValue);
        if(type == TYPE_BYTE)
            return new Byte(byteValue);
        if(type == TYPE_CHAR)
            return new Character(charValue);
        else
            return null;
    }

    public String toString()
    {
        return getString();
    }

    public String toExternal()
    {
        return type.getName() + ":" + getString();
    }

    public Value fromExternal(String s)
        throws IllegalArgumentException
    {
        String as[];
        as = s.split(":", 2);
        if(as.length != 2)
            throw new IllegalArgumentException(getClass() + ": External '" + s + "'does not contain ':' to separate type from value.");
        if(as[0].equals(TYPE_STRING.getName()))
            return set(as[1]);
        if(as[0].equals(TYPE_SHORT.getName()))
            return set(Short.parseShort(as[1]));
        if(as[0].equals(TYPE_LONG.getName()))
            return set(Long.parseLong(as[1]));
        if(as[0].equals(TYPE_FLOAT.getName()))
            return set(Float.parseFloat(as[1]));
        if(as[0].equals(TYPE_DOUBLE.getName()))
            return set(Double.parseDouble(as[1]));
        if(as[0].equals(TYPE_BOOLEAN.getName()))
            return set(Boolean.getBoolean(as[1]));
        if(as[0].equals(TYPE_BYTE.getName()))
            return set(Byte.parseByte(as[1]));
        if(as[0].equals(TYPE_CHAR.getName()))
            return set(as[1].charAt(0));
        if(as[0].equals(TYPE_INTEGER.getName()))
            return set(Integer.parseInt(as[1]));
        if(!as[0].equals(TYPE_DATE.getName()))
            break MISSING_BLOCK_LABEL_333;
        return set((new SimpleDateFormat()).parse(as[1]));
        Object obj1;
        obj1;
        throw new IllegalArgumentException(((ParseException) (obj1)).getMessage());
        if(as[0].equals((java.lang.Object.class).getName()) && as[1].equals("null"))
            return set((Object)null);
        Constructor constructor;
        Class class1 = Class.forName(as[0]);
        constructor = class1.getDeclaredConstructor(new Class[] {
            java.lang.String.class
        });
        constructor.setAccessible(true);
        return set(constructor.newInstance(new Object[] {
            as[1]
        }));
        class1;
        throw new IllegalArgumentException(getClass() + ": Cannot reconstruct value from type: " + as[0] + ", " + "and value " + as[1] + ", due to " + class1.getMessage());
    }

    private int intValue;
    private short shortValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    private boolean boolValue;
    private byte byteValue;
    private char charValue;
    private Object obj;
    private Class type;
    public static final Class TYPE_INTEGER;
    public static final Class TYPE_SHORT;
    public static final Class TYPE_LONG;
    public static final Class TYPE_FLOAT;
    public static final Class TYPE_DOUBLE;
    public static final Class TYPE_BOOLEAN;
    public static final Class TYPE_BYTE;
    public static final Class TYPE_CHAR;
    public static final Class TYPE_STRING;
    public static final Class TYPE_DATE;

    static 
    {
        TYPE_INTEGER = Integer.TYPE;
        TYPE_SHORT = Short.TYPE;
        TYPE_LONG = Long.TYPE;
        TYPE_FLOAT = Float.TYPE;
        TYPE_DOUBLE = Double.TYPE;
        TYPE_BOOLEAN = Boolean.TYPE;
        TYPE_BYTE = Byte.TYPE;
        TYPE_CHAR = Character.TYPE;
        TYPE_STRING = java.lang.String.class;
        TYPE_DATE = java.util.Date.class;
    }
}
