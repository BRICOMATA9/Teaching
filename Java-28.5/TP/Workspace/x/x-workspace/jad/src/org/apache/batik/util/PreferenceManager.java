// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessControlException;
import java.util.*;

public class PreferenceManager
{

    protected static String getSystemProperty(String s)
    {
        return System.getProperty(s);
        AccessControlException accesscontrolexception;
        accesscontrolexception;
        return "";
    }

    public PreferenceManager(String s)
    {
        PreferenceManager(s, null);
    }

    public PreferenceManager(String s, Map map)
    {
        internal = null;
        defaults = null;
        prefFileName = null;
        fullName = null;
        prefFileName = s;
        defaults = map;
        internal = new Properties();
    }

    public static void setPreferenceDirectory(String s)
    {
        PREF_DIR = s;
    }

    public static String getPreferenceDirectory()
    {
        return PREF_DIR;
    }

    public void load()
        throws IOException
    {
        FileInputStream fileinputstream;
        fileinputstream = null;
        if(fullName != null)
            try
            {
                fileinputstream = new FileInputStream(fullName);
            }
            catch(IOException ioexception)
            {
                fullName = null;
            }
        if(fullName == null)
        {
            if(PREF_DIR != null)
                try
                {
                    fileinputstream = new FileInputStream(fullName = PREF_DIR + FILE_SEP + prefFileName);
                }
                catch(IOException ioexception1)
                {
                    fullName = null;
                }
            if(fullName == null)
                try
                {
                    fileinputstream = new FileInputStream(fullName = USER_HOME + FILE_SEP + prefFileName);
                }
                catch(IOException ioexception2)
                {
                    try
                    {
                        fileinputstream = new FileInputStream(fullName = USER_DIR + FILE_SEP + prefFileName);
                    }
                    catch(IOException ioexception3)
                    {
                        fullName = null;
                    }
                }
        }
        if(fullName == null)
            break MISSING_BLOCK_LABEL_229;
        internal.load(fileinputstream);
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_229;
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
    }

    public void save()
        throws IOException
    {
        FileOutputStream fileoutputstream;
        fileoutputstream = null;
        if(fullName != null)
            try
            {
                fileoutputstream = new FileOutputStream(fullName);
            }
            catch(IOException ioexception)
            {
                fullName = null;
            }
        if(fullName == null)
        {
            if(PREF_DIR != null)
                try
                {
                    fileoutputstream = new FileOutputStream(fullName = PREF_DIR + FILE_SEP + prefFileName);
                }
                catch(IOException ioexception1)
                {
                    fullName = null;
                }
            if(fullName == null)
                try
                {
                    fileoutputstream = new FileOutputStream(fullName = USER_HOME + FILE_SEP + prefFileName);
                }
                catch(IOException ioexception2)
                {
                    fullName = null;
                    throw ioexception2;
                }
        }
        internal.store(fileoutputstream, prefFileName);
        fileoutputstream.close();
        break MISSING_BLOCK_LABEL_180;
        Exception exception;
        exception;
        fileoutputstream.close();
        throw exception;
    }

    private Object getDefault(String s)
    {
        if(defaults != null)
            return defaults.get(s);
        else
            return null;
    }

    public Rectangle getRectangle(String s)
    {
        Rectangle rectangle;
        String s1;
        Rectangle rectangle1;
        rectangle = (Rectangle)getDefault(s);
        s1 = internal.getProperty(s);
        if(s1 == null)
            return rectangle;
        rectangle1 = new Rectangle();
        StringTokenizer stringtokenizer;
        stringtokenizer = new StringTokenizer(s1, " ", false);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_65;
        internal.remove(s);
        return rectangle;
        int i;
        String s2 = stringtokenizer.nextToken();
        i = Integer.parseInt(s2);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_98;
        internal.remove(s);
        return rectangle;
        int j;
        String s3 = stringtokenizer.nextToken();
        j = Integer.parseInt(s3);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_131;
        internal.remove(s);
        return rectangle;
        int k;
        String s4 = stringtokenizer.nextToken();
        k = Integer.parseInt(s4);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_164;
        internal.remove(s);
        return rectangle;
        String s5 = stringtokenizer.nextToken();
        int l = Integer.parseInt(s5);
        rectangle1.setBounds(i, j, k, l);
        return rectangle1;
        NumberFormatException numberformatexception;
        numberformatexception;
        internal.remove(s);
        return rectangle;
    }

    public Dimension getDimension(String s)
    {
        Dimension dimension;
        String s1;
        Dimension dimension1;
        dimension = (Dimension)getDefault(s);
        s1 = internal.getProperty(s);
        if(s1 == null)
            return dimension;
        dimension1 = new Dimension();
        StringTokenizer stringtokenizer;
        stringtokenizer = new StringTokenizer(s1, " ", false);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_65;
        internal.remove(s);
        return dimension;
        int i;
        String s2 = stringtokenizer.nextToken();
        i = Integer.parseInt(s2);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_98;
        internal.remove(s);
        return dimension;
        String s3 = stringtokenizer.nextToken();
        int j = Integer.parseInt(s3);
        dimension1.setSize(i, j);
        return dimension1;
        NumberFormatException numberformatexception;
        numberformatexception;
        internal.remove(s);
        return dimension;
    }

    public Point getPoint(String s)
    {
        Point point;
        String s1;
        Point point1;
        point = (Point)getDefault(s);
        s1 = internal.getProperty(s);
        if(s1 == null)
            return point;
        point1 = new Point();
        StringTokenizer stringtokenizer;
        stringtokenizer = new StringTokenizer(s1, " ", false);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_65;
        internal.remove(s);
        return point;
        int i;
        String s2 = stringtokenizer.nextToken();
        i = Integer.parseInt(s2);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_98;
        internal.remove(s);
        return point;
        int j;
        String s3 = stringtokenizer.nextToken();
        j = Integer.parseInt(s3);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_131;
        internal.remove(s);
        return point;
        point1.setLocation(i, j);
        return point1;
        NumberFormatException numberformatexception;
        numberformatexception;
        internal.remove(s);
        return point;
    }

    public Color getColor(String s)
    {
        Color color;
        String s1;
        color = (Color)getDefault(s);
        s1 = internal.getProperty(s);
        if(s1 == null)
            return color;
        StringTokenizer stringtokenizer;
        stringtokenizer = new StringTokenizer(s1, " ", false);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_56;
        internal.remove(s);
        return color;
        int i;
        String s2 = stringtokenizer.nextToken();
        i = Integer.parseInt(s2);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_89;
        internal.remove(s);
        return color;
        int j;
        String s3 = stringtokenizer.nextToken();
        j = Integer.parseInt(s3);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_122;
        internal.remove(s);
        return color;
        int k;
        String s4 = stringtokenizer.nextToken();
        k = Integer.parseInt(s4);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_155;
        internal.remove(s);
        return color;
        int l;
        String s5 = stringtokenizer.nextToken();
        l = Integer.parseInt(s5);
        return new Color(i, j, k, l);
        NumberFormatException numberformatexception;
        numberformatexception;
        internal.remove(s);
        return color;
    }

    public Font getFont(String s)
    {
        Font font;
        String s1;
        font = (Font)getDefault(s);
        s1 = internal.getProperty(s);
        if(s1 == null)
            return font;
        StringTokenizer stringtokenizer;
        stringtokenizer = new StringTokenizer(s1, " ", false);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_56;
        internal.remove(s);
        return font;
        String s2;
        s2 = stringtokenizer.nextToken();
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_82;
        internal.remove(s);
        return font;
        int i;
        String s3 = stringtokenizer.nextToken();
        i = Integer.parseInt(s3);
        if(stringtokenizer.hasMoreTokens())
            break MISSING_BLOCK_LABEL_115;
        internal.remove(s);
        return font;
        int j;
        String s4 = stringtokenizer.nextToken();
        j = Integer.parseInt(s4);
        return new Font(s2, j, i);
        NumberFormatException numberformatexception;
        numberformatexception;
        internal.remove(s);
        return font;
    }

    public String getString(String s)
    {
        String s1 = internal.getProperty(s);
        if(s1 == null)
            s1 = (String)getDefault(s);
        return s1;
    }

    public String[] getStrings(String s)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        do
        {
            String s1 = getString(s + i);
            i++;
            if(s1 == null)
                break;
            arraylist.add(s1);
        } while(true);
        if(arraylist.size() != 0)
        {
            String as[] = new String[arraylist.size()];
            return (String[])arraylist.toArray(as);
        } else
        {
            return (String[])getDefault(s);
        }
    }

    public URL getURL(String s)
    {
        URL url = (URL)getDefault(s);
        String s1 = internal.getProperty(s);
        if(s1 == null)
            return url;
        URL url1 = null;
        try
        {
            url1 = new URL(s1);
        }
        catch(MalformedURLException malformedurlexception)
        {
            internal.remove(s);
            return url;
        }
        return url1;
    }

    public URL[] getURLs(String s)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        do
        {
            URL url = getURL(s + i);
            i++;
            if(url == null)
                break;
            arraylist.add(url);
        } while(true);
        if(arraylist.size() != 0)
        {
            URL aurl[] = new URL[arraylist.size()];
            return (URL[])arraylist.toArray(aurl);
        } else
        {
            return (URL[])getDefault(s);
        }
    }

    public File getFile(String s)
    {
        File file = (File)getDefault(s);
        String s1 = internal.getProperty(s);
        if(s1 == null)
            return file;
        File file1 = new File(s1);
        if(file1.exists())
        {
            return file1;
        } else
        {
            internal.remove(s);
            return file;
        }
    }

    public File[] getFiles(String s)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        do
        {
            File file = getFile(s + i);
            i++;
            if(file == null)
                break;
            arraylist.add(file);
        } while(true);
        if(arraylist.size() != 0)
        {
            File afile[] = new File[arraylist.size()];
            return (File[])arraylist.toArray(afile);
        } else
        {
            return (File[])getDefault(s);
        }
    }

    public int getInteger(String s)
    {
        int i = 0;
        if(getDefault(s) != null)
            i = ((Integer)getDefault(s)).intValue();
        String s1 = internal.getProperty(s);
        if(s1 == null)
            return i;
        int j;
        try
        {
            j = Integer.parseInt(s1);
        }
        catch(NumberFormatException numberformatexception)
        {
            internal.remove(s);
            return i;
        }
        return j;
    }

    public float getFloat(String s)
    {
        float f = 0.0F;
        if(getDefault(s) != null)
            f = ((Float)getDefault(s)).floatValue();
        String s1 = internal.getProperty(s);
        if(s1 == null)
            return f;
        float f1;
        try
        {
            f1 = Float.parseFloat(s1);
        }
        catch(NumberFormatException numberformatexception)
        {
            setFloat(s, f);
            return f;
        }
        return f1;
    }

    public boolean getBoolean(String s)
    {
        if(internal.getProperty(s) != null)
            return internal.getProperty(s).equals("true");
        if(getDefault(s) != null)
            return ((Boolean)getDefault(s)).booleanValue();
        else
            return false;
    }

    public void setRectangle(String s, Rectangle rectangle)
    {
        if(rectangle != null && !rectangle.equals(getDefault(s)))
            internal.setProperty(s, rectangle.x + " " + rectangle.y + " " + rectangle.width + " " + rectangle.height);
        else
            internal.remove(s);
    }

    public void setDimension(String s, Dimension dimension)
    {
        if(dimension != null && !dimension.equals(getDefault(s)))
            internal.setProperty(s, dimension.width + " " + dimension.height);
        else
            internal.remove(s);
    }

    public void setPoint(String s, Point point)
    {
        if(point != null && !point.equals(getDefault(s)))
            internal.setProperty(s, point.x + " " + point.y);
        else
            internal.remove(s);
    }

    public void setColor(String s, Color color)
    {
        if(color != null && !color.equals(getDefault(s)))
            internal.setProperty(s, color.getRed() + " " + color.getGreen() + " " + color.getBlue() + " " + color.getAlpha());
        else
            internal.remove(s);
    }

    public void setFont(String s, Font font)
    {
        if(font != null && !font.equals(getDefault(s)))
            internal.setProperty(s, font.getName() + " " + font.getSize() + " " + font.getStyle());
        else
            internal.remove(s);
    }

    public void setString(String s, String s1)
    {
        if(s1 != null && !s1.equals(getDefault(s)))
            internal.setProperty(s, s1);
        else
            internal.remove(s);
    }

    public void setStrings(String s, String as[])
    {
        int i = 0;
        if(as != null)
        {
            for(int j = 0; j < as.length; j++)
                if(as[j] != null)
                {
                    setString(s + i, as[j]);
                    i++;
                }

        }
        do
        {
            String s1 = getString(s + i);
            if(s1 != null)
            {
                setString(s + i, null);
                i++;
            } else
            {
                return;
            }
        } while(true);
    }

    public void setURL(String s, URL url)
    {
        if(url != null && !url.equals(getDefault(s)))
            internal.setProperty(s, url.toString());
        else
            internal.remove(s);
    }

    public void setURLs(String s, URL aurl[])
    {
        int i = 0;
        if(aurl != null)
        {
            for(int j = 0; j < aurl.length; j++)
                if(aurl[j] != null)
                {
                    setURL(s + i, aurl[j]);
                    i++;
                }

        }
        do
        {
            String s1 = getString(s + i);
            if(s1 != null)
            {
                setString(s + i, null);
                i++;
            } else
            {
                return;
            }
        } while(true);
    }

    public void setFile(String s, File file)
    {
        if(file != null && !file.equals(getDefault(s)))
            internal.setProperty(s, file.getAbsolutePath());
        else
            internal.remove(s);
    }

    public void setFiles(String s, File afile[])
    {
        int i = 0;
        if(afile != null)
        {
            for(int j = 0; j < afile.length; j++)
                if(afile[j] != null)
                {
                    setFile(s + i, afile[j]);
                    i++;
                }

        }
        do
        {
            String s1 = getString(s + i);
            if(s1 != null)
            {
                setString(s + i, null);
                i++;
            } else
            {
                return;
            }
        } while(true);
    }

    public void setInteger(String s, int i)
    {
        if(getDefault(s) != null && ((Integer)getDefault(s)).intValue() != i)
            internal.setProperty(s, Integer.toString(i));
        else
            internal.remove(s);
    }

    public void setFloat(String s, float f)
    {
        if(getDefault(s) != null && ((Float)getDefault(s)).floatValue() != f)
            internal.setProperty(s, Float.toString(f));
        else
            internal.remove(s);
    }

    public void setBoolean(String s, boolean flag)
    {
        if(getDefault(s) != null && ((Boolean)getDefault(s)).booleanValue() != flag)
            internal.setProperty(s, flag ? "true" : "false");
        else
            internal.remove(s);
    }

    protected Properties internal;
    protected Map defaults;
    protected String prefFileName;
    protected String fullName;
    protected static final String USER_HOME = getSystemProperty("user.home");
    protected static final String USER_DIR = getSystemProperty("user.dir");
    protected static final String FILE_SEP = getSystemProperty("file.separator");
    private static String PREF_DIR = null;

}
