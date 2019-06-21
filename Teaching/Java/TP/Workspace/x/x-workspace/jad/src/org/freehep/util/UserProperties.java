// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class UserProperties extends Properties
{

    public UserProperties()
    {
        altDefaults = new Properties();
    }

    public UserProperties(Properties properties)
    {
        super(properties);
        altDefaults = new Properties();
    }

    public UserProperties(Properties properties, Properties properties1)
    {
        super(properties);
        altDefaults = properties1;
    }

    public Enumeration propertyNames()
    {
        ArrayList arraylist = new ArrayList();
        for(Enumeration enumeration = super.propertyNames(); enumeration.hasMoreElements(); arraylist.add(enumeration.nextElement()));
        if(altDefaults != null)
        {
            for(Enumeration enumeration1 = altDefaults.propertyNames(); enumeration1.hasMoreElements(); arraylist.add(enumeration1.nextElement()));
        }
        return Collections.enumeration(arraylist);
    }

    public void setProperties(Properties properties)
    {
        String s;
        for(Enumeration enumeration = properties.propertyNames(); enumeration.hasMoreElements(); setProperty(s, properties.getProperty(s)))
            s = (String)enumeration.nextElement();

    }

    public Object setProperty(String s, String s1)
    {
        if(s1 == null)
            return super.setProperty(s, "null");
        else
            return super.setProperty(s, s1);
    }

    public Object setProperty(String s, String as[])
    {
        return setProperty(((Properties) (this)), s, as);
    }

    public static Object setProperty(Properties properties, String s, String as[])
    {
        if(as == null)
            return properties.setProperty(s, "null");
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < as.length; i++)
        {
            if(i != 0)
                stringbuffer.append(", ");
            stringbuffer.append(as[i]);
        }

        return properties.setProperty(s, stringbuffer.toString());
    }

    public Object setProperty(String s, java.awt.Color color)
    {
        return setProperty(((Properties) (this)), s, color);
    }

    public static Object setProperty(Properties properties, String s, java.awt.Color color)
    {
        if(color == null)
            return properties.setProperty(s, "null");
        else
            return properties.setProperty(s, color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getAlpha());
    }

    public Object setProperty(String s, java.awt.Rectangle rectangle)
    {
        return setProperty(((Properties) (this)), s, rectangle);
    }

    public static Object setProperty(Properties properties, String s, java.awt.Rectangle rectangle)
    {
        if(rectangle == null)
            return properties.setProperty(s, "null");
        else
            return properties.setProperty(s, rectangle.x + ", " + rectangle.y + ", " + rectangle.width + ", " + rectangle.height);
    }

    public Object setProperty(String s, java.awt.Insets insets)
    {
        return setProperty(((Properties) (this)), s, insets);
    }

    public static Object setProperty(Properties properties, String s, java.awt.Insets insets)
    {
        if(insets == null)
            return properties.setProperty(s, "null");
        else
            return properties.setProperty(s, insets.top + ", " + insets.left + ", " + insets.bottom + ", " + insets.right);
    }

    public Object setProperty(String s, java.awt.Dimension dimension)
    {
        return setProperty(((Properties) (this)), s, dimension);
    }

    public static Object setProperty(Properties properties, String s, java.awt.Dimension dimension)
    {
        if(dimension == null)
            return properties.setProperty(s, "null");
        else
            return properties.setProperty(s, dimension.width + ", " + dimension.height);
    }

    public Object setProperty(String s, int i)
    {
        return setProperty(((Properties) (this)), s, i);
    }

    public static Object setProperty(Properties properties, String s, int i)
    {
        return properties.setProperty(s, Integer.toString(i));
    }

    public Object setProperty(String s, double d)
    {
        return setProperty(((Properties) (this)), s, d);
    }

    public static Object setProperty(Properties properties, String s, double d)
    {
        return properties.setProperty(s, Double.toString(d));
    }

    public Object setProperty(String s, float f)
    {
        return setProperty(((Properties) (this)), s, f);
    }

    public static Object setProperty(Properties properties, String s, float f)
    {
        return properties.setProperty(s, Float.toString(f));
    }

    public Object setProperty(String s, boolean flag)
    {
        return setProperty(((Properties) (this)), s, flag);
    }

    public static Object setProperty(Properties properties, String s, boolean flag)
    {
        return properties.setProperty(s, Boolean.toString(flag));
    }

    public String getProperty(String s)
    {
        String s1 = super.getProperty(s);
        return s1 == null ? altDefaults.getProperty(s) : s1;
    }

    public String getProperty(String s, String s1)
    {
        String s2 = getProperty(s);
        return s2 == null ? s1 : s2;
    }

    public String[] getPropertyStringArray(String s)
    {
        return getPropertyStringArray(s, null);
    }

    public String[] getPropertyStringArray(String s, String as[])
    {
        String s1 = getProperty(s);
        if(s1 == null)
            return as;
        if(s1.equals("null"))
            return null;
        else
            return s1.split(", ");
    }

    public java.awt.Color getPropertyColor(String s)
    {
        return getPropertyColor(s, null);
    }

    public java.awt.Color getPropertyColor(String s, java.awt.Color color)
    {
        String s1 = getProperty(s);
        if(s1 == null)
            return color;
        if(s1.equals("null"))
        {
            return null;
        } else
        {
            String as[] = s1.split(", ");
            return new java.awt.Color(Integer.parseInt(as[0]), Integer.parseInt(as[1]), Integer.parseInt(as[2]), Integer.parseInt(as[3]));
        }
    }

    public java.awt.Rectangle getPropertyRectangle(String s)
    {
        return getPropertyRectangle(s, null);
    }

    public java.awt.Rectangle getPropertyRectangle(String s, java.awt.Rectangle rectangle)
    {
        String s1 = getProperty(s);
        if(s1 == null)
            return rectangle;
        if(s1.equals("null"))
        {
            return null;
        } else
        {
            String as[] = s1.split(", ");
            return new java.awt.Rectangle(Integer.parseInt(as[0]), Integer.parseInt(as[1]), Integer.parseInt(as[2]), Integer.parseInt(as[3]));
        }
    }

    public java.awt.Insets getPropertyInsets(String s)
    {
        return getPropertyInsets(s, null);
    }

    public java.awt.Insets getPropertyInsets(String s, java.awt.Insets insets)
    {
        String s1 = getProperty(s);
        if(s1 == null)
            return insets;
        if(s1.equals("null"))
        {
            return null;
        } else
        {
            String as[] = s1.split(", ");
            return new java.awt.Insets(Integer.parseInt(as[0]), Integer.parseInt(as[1]), Integer.parseInt(as[2]), Integer.parseInt(as[3]));
        }
    }

    public java.awt.Dimension getPropertyDimension(String s)
    {
        return getPropertyDimension(s, null);
    }

    public java.awt.Dimension getPropertyDimension(String s, java.awt.Dimension dimension)
    {
        String s1 = getProperty(s);
        if(s1 == null)
            return dimension;
        if(s1.equals("null"))
        {
            return null;
        } else
        {
            String as[] = s1.split(", ");
            return new java.awt.Dimension(Integer.parseInt(as[0]), Integer.parseInt(as[1]));
        }
    }

    public int getPropertyInt(String s)
    {
        return getPropertyInt(s, 0);
    }

    public int getPropertyInt(String s, int i)
    {
        return (new Integer(getProperty(s, Integer.toString(i)))).intValue();
    }

    public double getPropertyDouble(String s)
    {
        return getPropertyDouble(s, 0.0D);
    }

    public double getPropertyDouble(String s, double d)
    {
        return (new Double(getProperty(s, Double.toString(d)))).doubleValue();
    }

    public float getPropertyFloat(String s)
    {
        return getPropertyFloat(s, 0.0F);
    }

    public float getPropertyFloat(String s, float f)
    {
        return (new Float(getProperty(s, Float.toString(f)))).floatValue();
    }

    public boolean isProperty(String s)
    {
        return isProperty(s, false);
    }

    public boolean isProperty(String s, boolean flag)
    {
        return (new Boolean(getProperty(s, Boolean.toString(flag)))).booleanValue();
    }

    private static final long serialVersionUID = 0x2dc3038bf82f6838L;
    protected Properties altDefaults;
}
