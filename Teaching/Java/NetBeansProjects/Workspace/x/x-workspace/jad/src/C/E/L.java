// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.Beans;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

// Referenced classes of package C.E:
//            B, Y, F

public class L
    implements B
{
    private static final class _F extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            Class class1 = Class.forName(s, false, getClass().getClassLoader());
            return class1;
            Object obj;
            obj;
            throw new IllegalArgumentException("Did not find class " + s);
            obj;
            throw new IllegalArgumentException("Could not load class" + s);
        }

        protected String A(Object obj)
        {
            return ((Class)obj).getName();
        }

        _F()
        {
            super(L.class$java$lang$Class != null ? L.class$java$lang$Class : (L.class$java$lang$Class = L._mthclass$("java.lang.Class")));
        }
    }

    private static final class _E extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            if(s.indexOf(":/") < 0)
                return (new File(s)).toURL();
            String s2;
            String s3;
            URL url;
            if(!s.startsWith("resource://"))
                break MISSING_BLOCK_LABEL_186;
            String s1 = s.substring("resource://".length());
            s2 = null;
            s3 = null;
            int i = s1.indexOf('#');
            if(i > 0)
            {
                s3 = s1.substring(i);
                s1 = s1.substring(0, i);
            }
            int j = s1.indexOf('?');
            if(j > 0)
            {
                s2 = s1.substring(j);
                s1 = s1.substring(0, j);
            }
            url = getClass().getClassLoader().getResource(s1);
            if(url == null || s3 == null && s2 == null)
                return url;
            s = url.toString();
            if(s2 != null)
                s = s + s2;
            if(s3 != null)
                s = s + s3;
            return new URL(s);
            MalformedURLException malformedurlexception;
            malformedurlexception;
            throw new IllegalArgumentException("Could not convert URL from " + s);
        }

        protected String A(Object obj)
        {
            return ((URL)obj).toString();
        }

        _E()
        {
            super(L.class$java$net$URL != null ? L.class$java$net$URL : (L.class$java$net$URL = L._mthclass$("java.net.URL")));
        }
    }

    private static final class _B extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, "_", false);
            String s1 = stringtokenizer.nextToken();
            Locale locale;
            if(stringtokenizer.hasMoreTokens())
            {
                String s2 = stringtokenizer.nextToken();
                if(stringtokenizer.hasMoreTokens())
                {
                    String s3 = stringtokenizer.nextToken();
                    locale = new Locale(s1, s2, s3);
                } else
                {
                    locale = new Locale(s1, s2);
                }
            } else
            {
                locale = new Locale(s1, "");
            }
            return locale;
        }

        protected String A(Object obj)
        {
            Locale locale = (Locale)obj;
            String s = locale.getLanguage();
            if(locale.getCountry().length() > 0)
            {
                s = s + "_" + locale.getCountry();
                if(locale.getVariant().length() > 0)
                    s = s + "_" + locale.getVariant();
            }
            return s;
        }

        _B()
        {
            super(L.class$java$util$Locale != null ? L.class$java$util$Locale : (L.class$java$util$Locale = L._mthclass$("java.util.Locale")));
        }
    }

    private static final class _H extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, "(,)", false);
            Point2D point2d;
            String s1 = stringtokenizer.nextToken();
            point2d = (Point2D)Beans.instantiate(getClass().getClassLoader(), s1);
            double d = Double.parseDouble(stringtokenizer.nextToken());
            double d1 = Double.parseDouble(stringtokenizer.nextToken());
            point2d.setLocation(d, d1);
            return point2d;
            Object obj;
            obj;
            throw new IllegalArgumentException("Could not parse number " + s);
            obj;
            throw new IllegalArgumentException("Unknown class " + obj);
            obj;
            throw new IllegalArgumentException("Could not load class " + obj);
        }

        protected String A(Object obj)
            throws IllegalArgumentException
        {
            Point2D point2d = (Point2D)obj;
            StringBuffer stringbuffer = new StringBuffer(50);
            stringbuffer.append(point2d.getClass().getName());
            stringbuffer.append('(');
            stringbuffer.append(point2d.getX());
            stringbuffer.append(',');
            stringbuffer.append(point2d.getY());
            stringbuffer.append(')');
            return stringbuffer.toString();
        }

        _H()
        {
            super(L.class$java$awt$geom$Point2D != null ? L.class$java$awt$geom$Point2D : (L.class$java$awt$geom$Point2D = L._mthclass$("java.awt.geom.Point2D")));
        }
    }

    private static final class _D extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, "(,)", false);
            Rectangle2D rectangle2d;
            String s1 = stringtokenizer.nextToken();
            rectangle2d = (Rectangle2D)Beans.instantiate(getClass().getClassLoader(), s1);
            double d = Double.parseDouble(stringtokenizer.nextToken());
            double d1 = Double.parseDouble(stringtokenizer.nextToken());
            double d2 = Double.parseDouble(stringtokenizer.nextToken());
            double d3 = Double.parseDouble(stringtokenizer.nextToken());
            rectangle2d.setFrame(d, d1, d2, d3);
            return rectangle2d;
            Object obj;
            obj;
            throw new IllegalArgumentException("Could not parse number " + s);
            obj;
            throw new IllegalArgumentException("Unknown class " + obj);
            obj;
            throw new IllegalArgumentException("Could not load class " + obj);
        }

        protected String A(Object obj)
            throws IllegalArgumentException
        {
            Rectangle2D rectangle2d = (Rectangle2D)obj;
            StringBuffer stringbuffer = new StringBuffer(50);
            stringbuffer.append(rectangle2d.getClass().getName());
            stringbuffer.append('(');
            stringbuffer.append(rectangle2d.getX());
            stringbuffer.append(',');
            stringbuffer.append(rectangle2d.getY());
            stringbuffer.append(',');
            stringbuffer.append(rectangle2d.getWidth());
            stringbuffer.append(',');
            stringbuffer.append(rectangle2d.getHeight());
            stringbuffer.append(')');
            return stringbuffer.toString();
        }

        _D()
        {
            super(L.class$java$awt$geom$Rectangle2D != null ? L.class$java$awt$geom$Rectangle2D : (L.class$java$awt$geom$Rectangle2D = L._mthclass$("java.awt.geom.Rectangle2D")));
        }
    }

    private static final class _A extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            return Font.decode(s);
        }

        protected String A(Object obj)
            throws IllegalArgumentException
        {
            Font font = (Font)obj;
            StringBuffer stringbuffer = new StringBuffer(50);
            stringbuffer.append(font.getFamily());
            stringbuffer.append('-');
            if(font.getStyle() == 0)
            {
                stringbuffer.append("PLAIN");
            } else
            {
                if((font.getStyle() & 1) == 1)
                    stringbuffer.append("BOLD");
                if((font.getStyle() & 2) == 2)
                    stringbuffer.append("ITALIC");
            }
            stringbuffer.append('-');
            stringbuffer.append(font.getSize());
            return stringbuffer.toString();
        }

        _A()
        {
            super(L.class$java$awt$Font != null ? L.class$java$awt$Font : (L.class$java$awt$Font = L._mthclass$("java.awt.Font")));
        }
    }

    private static final class _G extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            return Color.decode("0x" + s.substring(1));
        }

        protected String A(Object obj)
            throws IllegalArgumentException
        {
            Color color = (Color)obj;
            StringBuffer stringbuffer = new StringBuffer(7);
            stringbuffer.append('#');
            String s = Integer.toHexString(color.getRed());
            if(s.length() == 1)
                stringbuffer.append('0');
            stringbuffer.append(s);
            s = Integer.toHexString(color.getGreen());
            if(s.length() == 1)
                stringbuffer.append('0');
            stringbuffer.append(s);
            s = Integer.toHexString(color.getBlue());
            if(s.length() == 1)
                stringbuffer.append('0');
            stringbuffer.append(s);
            return stringbuffer.toString();
        }

        _G()
        {
            super(L.class$java$awt$Color != null ? L.class$java$awt$Color : (L.class$java$awt$Color = L._mthclass$("java.awt.Color")));
        }
    }

    private static final class _C extends F
    {

        protected Object A(String s)
            throws IllegalArgumentException
        {
            return s;
        }

        protected String A(Object obj)
            throws IllegalArgumentException
        {
            return (String)obj;
        }

        _C()
        {
            super(L.class$java$lang$String != null ? L.class$java$lang$String : (L.class$java$lang$String = L._mthclass$("java.lang.String")));
        }
    }


    protected L()
    {
        H = new HashMap();
    }

    protected void A()
    {
        A(java.lang.Integer.class, ((B) (new Y(java.lang.Integer.class, java.lang.Integer.class))));
        A(java.lang.Float.class, ((B) (new Y(java.lang.Float.class, java.lang.Float.class))));
        A(java.lang.Double.class, ((B) (new Y(java.lang.Double.class, java.lang.Double.class))));
        A(java.lang.Byte.class, ((B) (new Y(java.lang.Byte.class, java.lang.Byte.class))));
        A(java.lang.Short.class, ((B) (new Y(java.lang.Short.class, java.lang.Short.class))));
        A(java.lang.Boolean.class, ((B) (new Y(java.lang.Boolean.class, java.lang.Boolean.class))));
        A(java.lang.Long.class, ((B) (new Y(java.lang.Long.class, java.lang.Long.class))));
        A(Integer.TYPE, ((B) (new Y(java.lang.Integer.class, Integer.TYPE))));
        A(Float.TYPE, ((B) (new Y(java.lang.Float.class, Float.TYPE))));
        A(Double.TYPE, ((B) (new Y(java.lang.Double.class, Double.TYPE))));
        A(Byte.TYPE, ((B) (new Y(java.lang.Byte.class, Byte.TYPE))));
        A(Short.TYPE, ((B) (new Y(java.lang.Short.class, Short.TYPE))));
        A(Boolean.TYPE, ((B) (new Y(java.lang.Boolean.class, Boolean.TYPE))));
        A(Long.TYPE, ((B) (new Y(java.lang.Long.class, Long.TYPE))));
        A(java.lang.String.class, ((B) (new _C())));
        A(java.awt.Color.class, ((B) (new _G())));
        A(java.io.File.class, ((B) (new Y(java.io.File.class))));
        A(java.util.Date.class, ((B) (new Y(java.util.Date.class))));
        A(java.awt.Font.class, ((B) (new _A())));
        A(java.net.URL.class, ((B) (new _E())));
        A(java.awt.geom.Rectangle2D.class, ((B) (new _D())));
        A(java.awt.geom.Point2D.class, ((B) (new _H())));
        A(java.lang.Class.class, ((B) (new _F())));
        A(java.util.Locale.class, ((B) (new _B())));
    }

    public void A(Class class1, B b)
    {
        H.put(class1, b);
    }

    public static L B()
    {
        return I;
    }

    public Object A(String s, Class class1)
        throws IllegalArgumentException
    {
        if(s == null)
            return null;
        B b = A(class1);
        if(b == null)
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + s + " [" + class1 + "]");
        else
            return b.A(s, class1);
    }

    public String A(Object obj, Class class1)
        throws IllegalArgumentException
    {
        if(obj == null)
            return null;
        B b = A(class1);
        if(b == null)
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + obj + " [" + class1 + "]");
        else
            return b.A(obj, class1);
    }

    private B A(Class class1)
    {
        B b = (B)H.get(class1);
        if(b == null)
        {
            for(Iterator iterator = H.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Class class2 = (Class)entry.getKey();
                if(class2.isAssignableFrom(class1))
                    return (B)entry.getValue();
            }

            return null;
        } else
        {
            return b;
        }
    }

    private static L I;
    private Map H;

    static 
    {
        L l = new L();
        l.A();
        I = l;
    }
}
