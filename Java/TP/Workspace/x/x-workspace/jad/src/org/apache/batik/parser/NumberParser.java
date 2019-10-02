// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            AbstractParser, ParseException

public abstract class NumberParser extends AbstractParser
{

    public NumberParser()
    {
    }

    protected float parseFloat()
        throws ParseException, IOException
    {
        int i;
        int j;
        boolean flag;
        boolean flag1;
        int k;
        int l;
        int i1;
        boolean flag2;
label0:
        {
            i = 0;
            j = 0;
            flag = true;
            flag1 = false;
            k = 0;
            l = 0;
            i1 = 0;
            flag2 = true;
            switch(current)
            {
            case 45: // '-'
                flag = false;
                // fall through

            case 43: // '+'
                current = reader.read();
                // fall through

            default:
                switch(current)
                {
                case 47: // '/'
                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return 0.0F;

                case 46: // '.'
                    break;

                case 48: // '0'
                    flag1 = true;
label1:
                    do
                    {
                        current = reader.read();
                        switch(current)
                        {
                        case 46: // '.'
                        case 69: // 'E'
                        case 101: // 'e'
                            break label0;

                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label1;

                        default:
                            return 0.0F;
                        }
                    } while(true);
                    // fall through

                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
                    flag1 = true;
label2:
                    do
                    {
                        if(j < 9)
                        {
                            j++;
                            i = i * 10 + (current - 48);
                        } else
                        {
                            i1++;
                        }
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label2;

                        case 48: // '0'
                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break;
                        }
                    } while(true);
                    break;
                }
                break;
            }
        }
        if(current == 46)
        {
            current = reader.read();
label3:
            switch(current)
            {
            case 69: // 'E'
            case 101: // 'e'
            default:
                if(!flag1)
                {
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return 0.0F;
                }
                break;

            case 48: // '0'
                if(j == 0)
label4:
                    do
                    {
                        current = reader.read();
                        i1--;
                        switch(current)
                        {
                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label4;

                        default:
                            if(!flag1)
                                return 0.0F;
                            break label3;
                        }
                    } while(true);
                // fall through

            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
label5:
                do
                {
                    if(j < 9)
                    {
                        j++;
                        i = i * 10 + (current - 48);
                        i1--;
                    }
                    current = reader.read();
                    switch(current)
                    {
                    default:
                        break label5;

                    case 48: // '0'
                    case 49: // '1'
                    case 50: // '2'
                    case 51: // '3'
                    case 52: // '4'
                    case 53: // '5'
                    case 54: // '6'
                    case 55: // '7'
                    case 56: // '8'
                    case 57: // '9'
                        break;
                    }
                } while(true);
                break;
            }
        }
        switch(current)
        {
        case 69: // 'E'
        case 101: // 'e'
            current = reader.read();
            switch(current)
            {
            case 44: // ','
            case 46: // '.'
            case 47: // '/'
            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                return 0.0F;

            case 45: // '-'
                flag2 = false;
                // fall through

            case 43: // '+'
                current = reader.read();
                switch(current)
                {
                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return 0.0F;

                case 48: // '0'
                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
                    break;
                }
                // fall through

            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
label6:
                switch(current)
                {
                default:
                    break;

                case 48: // '0'
label7:
                    while(true) 
                    {
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label6;

                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label7;
                        }
                    }
                    // fall through

                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
label8:
                    while(true) 
                    {
                        if(l < 3)
                        {
                            l++;
                            k = k * 10 + (current - 48);
                        }
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label8;

                        case 48: // '0'
                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            break;
        }
        if(!flag2)
            k = -k;
        k += i1;
        if(!flag)
            i = -i;
        return buildFloat(i, k);
    }

    public static float buildFloat(int i, int j)
    {
        if(j < -125 || i == 0)
            return 0.0F;
        if(j >= 128)
            return i <= 0 ? (-1.0F / 0.0F) : (1.0F / 0.0F);
        if(j == 0)
            return (float)i;
        if(i >= 0x4000000)
            i++;
        return j <= 0 ? (float)i / pow10[-j] : (float)i * pow10[j];
    }

    private static final float pow10[];

    static 
    {
        pow10 = new float[128];
        for(int i = 0; i < pow10.length; i++)
            pow10[i] = (float)Math.pow(10D, i);

    }
}
