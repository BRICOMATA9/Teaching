// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import junit.framework.AssertionFailedError;

public class Assert extends junit.framework.Assert
{

    protected Assert()
    {
    }

    public static void assertEquals(File file, File file1, boolean flag)
        throws FileNotFoundException, IOException
    {
        Object obj = new BufferedInputStream(new FileInputStream(file));
        if(file.getPath().toLowerCase().endsWith(".gz"))
            obj = new GZIPInputStream(((InputStream) (obj)));
        Object obj1 = new BufferedInputStream(new FileInputStream(file1));
        if(file1.getPath().toLowerCase().endsWith(".gz"))
            obj1 = new GZIPInputStream(((InputStream) (obj1)));
        assertEquals(((InputStream) (obj)), ((InputStream) (obj1)), flag, "File " + file1.getPath());
    }

    public static void assertEquals(InputStream inputstream, InputStream inputstream1, boolean flag, String s)
        throws IOException
    {
        if(flag)
        {
            int i = diff(inputstream, inputstream1);
            if(i >= 0)
                throw new AssertionFailedError(s + ": comparison failed at offset " + i);
        } else
        {
            int j = diff(new BufferedReader(new InputStreamReader(inputstream)), new BufferedReader(new InputStreamReader(inputstream1)));
            if(j >= 0)
                throw new AssertionFailedError(s + ": comparison failed at line " + j);
        }
    }

    private static int diff(InputStream inputstream, InputStream inputstream1)
        throws IOException
    {
        int k = 0;
        int i;
        int j;
        do
        {
            i = inputstream.read();
            j = inputstream1.read();
            k++;
        } while(i >= 0 && j >= 0 && i == j);
        inputstream.close();
        inputstream1.close();
        return i != j ? k - 1 : -1;
    }

    private static int diff(BufferedReader bufferedreader, BufferedReader bufferedreader1)
        throws IOException
    {
        int i = 1;
        String s;
        String s1;
        do
        {
            s = bufferedreader.readLine();
            s1 = bufferedreader1.readLine();
            i++;
        } while(s != null && s1 != null && s.equals(s1));
        bufferedreader.close();
        bufferedreader1.close();
        return s != null || s1 != null ? i - 1 : -1;
    }
}
