// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.PrintStream;
import java.util.*;

public class DiscreteAngle
{

    public DiscreteAngle()
    {
        angles = new TreeSet();
    }

    public double getAngle(double d)
    {
        if(angles.isEmpty())
            return d;
        Iterator iterator = angles.iterator();
        Double double1 = (Double)iterator.next();
        if(!iterator.hasNext())
            return double1.doubleValue();
        while(iterator.hasNext()) 
        {
            Double double2 = (Double)iterator.next();
            double d1 = (double2.doubleValue() - double1.doubleValue()) / 2D + double1.doubleValue();
            if(d <= d1)
                return double1.doubleValue();
            double1 = double2;
        }
        return double1.doubleValue();
    }

    public Double addAngle(double d)
    {
        Double double1 = new Double(d);
        angles.add(double1);
        return double1;
    }

    public boolean removeAngle(double d)
    {
        for(Iterator iterator = angles.iterator(); iterator.hasNext();)
        {
            Double double1 = (Double)iterator.next();
            if(double1.doubleValue() == d)
                return removeAngle(double1);
        }

        return false;
    }

    public boolean removeAngle(Double double1)
    {
        return double1 == null ? false : angles.remove(double1);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("Angles: ");
        Iterator iterator = angles.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Double double1 = (Double)iterator.next();
            stringbuffer.append(double1.doubleValue());
            if(iterator.hasNext())
                stringbuffer.append(", ");
        } while(true);
        return stringbuffer.toString();
    }

    public static void main(String args[])
    {
        DiscreteAngle discreteangle = new DiscreteAngle();
        discreteangle.addAngle(0.0D);
        discreteangle.addAngle(90D);
        discreteangle.addAngle(180D);
        discreteangle.addAngle(270D);
        discreteangle.addAngle(360D);
        discreteangle.addAngle(10D);
        discreteangle.addAngle(190D);
        System.out.println("  0 results in " + discreteangle.getAngle(0.0D));
        System.out.println("  1 results in " + discreteangle.getAngle(1.0D));
        System.out.println("  5 results in " + discreteangle.getAngle(5D));
        System.out.println(" 80 results in " + discreteangle.getAngle(80D));
        System.out.println(" 90 results in " + discreteangle.getAngle(90D));
        System.out.println("170 results in " + discreteangle.getAngle(170D));
        System.out.println("185 results in " + discreteangle.getAngle(185D));
        System.out.println("186 results in " + discreteangle.getAngle(186D));
        System.out.println("231 results in " + discreteangle.getAngle(231D));
        System.out.println("359 results in " + discreteangle.getAngle(359D));
    }

    private SortedSet angles;
}
