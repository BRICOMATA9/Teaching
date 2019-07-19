// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.util;

import java.util.Arrays;

public class Base64
{

    public Base64()
    {
    }

    public static final char[] encodeToChar(byte abyte0[], boolean flag)
    {
        int i = abyte0 == null ? 0 : abyte0.length;
        if(i == 0)
            return new char[0];
        int j = (i / 3) * 3;
        int k = (i - 1) / 3 + 1 << 2;
        int l = k + (flag ? (k - 1) / 76 << 1 : 0);
        char ac[] = new char[l];
        int i1 = 0;
        int j1 = 0;
        int l1 = 0;
        do
        {
            if(i1 >= j)
                break;
            int i2 = (abyte0[i1++] & 0xff) << 16 | (abyte0[i1++] & 0xff) << 8 | abyte0[i1++] & 0xff;
            ac[j1++] = CA[i2 >>> 18 & 0x3f];
            ac[j1++] = CA[i2 >>> 12 & 0x3f];
            ac[j1++] = CA[i2 >>> 6 & 0x3f];
            ac[j1++] = CA[i2 & 0x3f];
            if(flag && ++l1 == 19 && j1 < l - 2)
            {
                ac[j1++] = '\r';
                ac[j1++] = '\n';
                l1 = 0;
            }
        } while(true);
        i1 = i - j;
        if(i1 > 0)
        {
            int k1 = (abyte0[j] & 0xff) << 10 | (i1 != 2 ? 0 : (abyte0[i - 1] & 0xff) << 2);
            ac[l - 4] = CA[k1 >> 12];
            ac[l - 3] = CA[k1 >>> 6 & 0x3f];
            ac[l - 2] = i1 != 2 ? '=' : CA[k1 & 0x3f];
            ac[l - 1] = '=';
        }
        return ac;
    }

    public static final byte[] decode(char ac[])
    {
        int i = ac == null ? 0 : ac.length;
        if(i == 0)
            return new byte[0];
        int j = 0;
        for(int k = 0; k < i; k++)
            if(IA[ac[k]] < 0)
                j++;

        if((i - j) % 4 != 0)
            return null;
        int l = 0;
        int i1 = i;
        do
        {
            if(i1 <= 1 || IA[ac[--i1]] > 0)
                break;
            if(ac[i1] == '=')
                l++;
        } while(true);
        i1 = ((i - j) * 6 >> 3) - l;
        byte abyte0[] = new byte[i1];
        int j1 = 0;
        int k1 = 0;
        do
        {
            if(k1 >= i1)
                break;
            int l1 = 0;
            for(int i2 = 0; i2 < 4; i2++)
            {
                int j2 = IA[ac[j1++]];
                if(j2 >= 0)
                    l1 |= j2 << 18 - i2 * 6;
                else
                    i2--;
            }

            abyte0[k1++] = (byte)(l1 >> 16);
            if(k1 < i1)
            {
                abyte0[k1++] = (byte)(l1 >> 8);
                if(k1 < i1)
                    abyte0[k1++] = (byte)l1;
            }
        } while(true);
        return abyte0;
    }

    public static final byte[] decodeFast(char ac[])
    {
        int i = ac.length;
        if(i == 0)
            return new byte[0];
        int j = 0;
        int k;
        for(k = i - 1; j < k && IA[ac[j]] < 0; j++);
        for(; k > 0 && IA[ac[k]] < 0; k--);
        byte byte0 = ac[k] != '=' ? 0 : ((byte)(ac[k - 1] != '=' ? 1 : 2));
        int l = (k - j) + 1;
        int i1 = i <= 76 ? 0 : (ac[76] != '\r' ? 0 : l / 78) << 1;
        int j1 = ((l - i1) * 6 >> 3) - byte0;
        byte abyte0[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        int j2 = (j1 / 3) * 3;
        do
        {
            if(k1 >= j2)
                break;
            int i3 = IA[ac[j++]] << 18 | IA[ac[j++]] << 12 | IA[ac[j++]] << 6 | IA[ac[j++]];
            abyte0[k1++] = (byte)(i3 >> 16);
            abyte0[k1++] = (byte)(i3 >> 8);
            abyte0[k1++] = (byte)i3;
            if(i1 > 0 && ++l1 == 19)
            {
                j += 2;
                l1 = 0;
            }
        } while(true);
        if(k1 < j1)
        {
            int i2 = 0;
            for(int k2 = 0; j <= k - byte0; k2++)
                i2 |= IA[ac[j++]] << 18 - k2 * 6;

            for(int l2 = 16; k1 < j1; l2 -= 8)
                abyte0[k1++] = (byte)(i2 >> l2);

        }
        return abyte0;
    }

    public static final byte[] encodeToByte(byte abyte0[], boolean flag)
    {
        int i = abyte0 == null ? 0 : abyte0.length;
        if(i == 0)
            return new byte[0];
        int j = (i / 3) * 3;
        int k = (i - 1) / 3 + 1 << 2;
        int l = k + (flag ? (k - 1) / 76 << 1 : 0);
        byte abyte1[] = new byte[l];
        int i1 = 0;
        int j1 = 0;
        int l1 = 0;
        do
        {
            if(i1 >= j)
                break;
            int i2 = (abyte0[i1++] & 0xff) << 16 | (abyte0[i1++] & 0xff) << 8 | abyte0[i1++] & 0xff;
            abyte1[j1++] = (byte)CA[i2 >>> 18 & 0x3f];
            abyte1[j1++] = (byte)CA[i2 >>> 12 & 0x3f];
            abyte1[j1++] = (byte)CA[i2 >>> 6 & 0x3f];
            abyte1[j1++] = (byte)CA[i2 & 0x3f];
            if(flag && ++l1 == 19 && j1 < l - 2)
            {
                abyte1[j1++] = 13;
                abyte1[j1++] = 10;
                l1 = 0;
            }
        } while(true);
        i1 = i - j;
        if(i1 > 0)
        {
            int k1 = (abyte0[j] & 0xff) << 10 | (i1 != 2 ? 0 : (abyte0[i - 1] & 0xff) << 2);
            abyte1[l - 4] = (byte)CA[k1 >> 12];
            abyte1[l - 3] = (byte)CA[k1 >>> 6 & 0x3f];
            abyte1[l - 2] = i1 != 2 ? 61 : (byte)CA[k1 & 0x3f];
            abyte1[l - 1] = 61;
        }
        return abyte1;
    }

    public static final byte[] decode(byte abyte0[])
    {
        int i = abyte0.length;
        int j = 0;
        for(int k = 0; k < i; k++)
            if(IA[abyte0[k] & 0xff] < 0)
                j++;

        if((i - j) % 4 != 0)
            return null;
        int l = 0;
        int i1 = i;
        do
        {
            if(i1 <= 1 || IA[abyte0[--i1] & 0xff] > 0)
                break;
            if(abyte0[i1] == 61)
                l++;
        } while(true);
        i1 = ((i - j) * 6 >> 3) - l;
        byte abyte1[] = new byte[i1];
        int j1 = 0;
        int k1 = 0;
        do
        {
            if(k1 >= i1)
                break;
            int l1 = 0;
            for(int i2 = 0; i2 < 4; i2++)
            {
                int j2 = IA[abyte0[j1++] & 0xff];
                if(j2 >= 0)
                    l1 |= j2 << 18 - i2 * 6;
                else
                    i2--;
            }

            abyte1[k1++] = (byte)(l1 >> 16);
            if(k1 < i1)
            {
                abyte1[k1++] = (byte)(l1 >> 8);
                if(k1 < i1)
                    abyte1[k1++] = (byte)l1;
            }
        } while(true);
        return abyte1;
    }

    public static final byte[] decodeFast(byte abyte0[])
    {
        int i = abyte0.length;
        if(i == 0)
            return new byte[0];
        int j = 0;
        int k;
        for(k = i - 1; j < k && IA[abyte0[j] & 0xff] < 0; j++);
        for(; k > 0 && IA[abyte0[k] & 0xff] < 0; k--);
        byte byte0 = abyte0[k] != 61 ? 0 : ((byte)(abyte0[k - 1] != 61 ? 1 : 2));
        int l = (k - j) + 1;
        int i1 = i <= 76 ? 0 : (abyte0[76] != 13 ? 0 : l / 78) << 1;
        int j1 = ((l - i1) * 6 >> 3) - byte0;
        byte abyte1[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        int j2 = (j1 / 3) * 3;
        do
        {
            if(k1 >= j2)
                break;
            int i3 = IA[abyte0[j++]] << 18 | IA[abyte0[j++]] << 12 | IA[abyte0[j++]] << 6 | IA[abyte0[j++]];
            abyte1[k1++] = (byte)(i3 >> 16);
            abyte1[k1++] = (byte)(i3 >> 8);
            abyte1[k1++] = (byte)i3;
            if(i1 > 0 && ++l1 == 19)
            {
                j += 2;
                l1 = 0;
            }
        } while(true);
        if(k1 < j1)
        {
            int i2 = 0;
            for(int k2 = 0; j <= k - byte0; k2++)
                i2 |= IA[abyte0[j++]] << 18 - k2 * 6;

            for(int l2 = 16; k1 < j1; l2 -= 8)
                abyte1[k1++] = (byte)(i2 >> l2);

        }
        return abyte1;
    }

    public static final String encodeToString(byte abyte0[], boolean flag)
    {
        return new String(encodeToChar(abyte0, flag));
    }

    public static final byte[] decode(String s)
    {
        int i = s == null ? 0 : s.length();
        if(i == 0)
            return new byte[0];
        int j = 0;
        for(int k = 0; k < i; k++)
            if(IA[s.charAt(k)] < 0)
                j++;

        if((i - j) % 4 != 0)
            return null;
        int l = 0;
        int i1 = i;
        do
        {
            if(i1 <= 1 || IA[s.charAt(--i1)] > 0)
                break;
            if(s.charAt(i1) == '=')
                l++;
        } while(true);
        i1 = ((i - j) * 6 >> 3) - l;
        byte abyte0[] = new byte[i1];
        int j1 = 0;
        int k1 = 0;
        do
        {
            if(k1 >= i1)
                break;
            int l1 = 0;
            for(int i2 = 0; i2 < 4; i2++)
            {
                int j2 = IA[s.charAt(j1++)];
                if(j2 >= 0)
                    l1 |= j2 << 18 - i2 * 6;
                else
                    i2--;
            }

            abyte0[k1++] = (byte)(l1 >> 16);
            if(k1 < i1)
            {
                abyte0[k1++] = (byte)(l1 >> 8);
                if(k1 < i1)
                    abyte0[k1++] = (byte)l1;
            }
        } while(true);
        return abyte0;
    }

    public static final byte[] decodeFast(String s)
    {
        int i = s.length();
        if(i == 0)
            return new byte[0];
        int j = 0;
        int k;
        for(k = i - 1; j < k && IA[s.charAt(j) & 0xff] < 0; j++);
        for(; k > 0 && IA[s.charAt(k) & 0xff] < 0; k--);
        byte byte0 = s.charAt(k) != '=' ? 0 : ((byte)(s.charAt(k - 1) != '=' ? 1 : 2));
        int l = (k - j) + 1;
        int i1 = i <= 76 ? 0 : (s.charAt(76) != '\r' ? 0 : l / 78) << 1;
        int j1 = ((l - i1) * 6 >> 3) - byte0;
        byte abyte0[] = new byte[j1];
        int k1 = 0;
        int l1 = 0;
        int j2 = (j1 / 3) * 3;
        do
        {
            if(k1 >= j2)
                break;
            int i3 = IA[s.charAt(j++)] << 18 | IA[s.charAt(j++)] << 12 | IA[s.charAt(j++)] << 6 | IA[s.charAt(j++)];
            abyte0[k1++] = (byte)(i3 >> 16);
            abyte0[k1++] = (byte)(i3 >> 8);
            abyte0[k1++] = (byte)i3;
            if(i1 > 0 && ++l1 == 19)
            {
                j += 2;
                l1 = 0;
            }
        } while(true);
        if(k1 < j1)
        {
            int i2 = 0;
            for(int k2 = 0; j <= k - byte0; k2++)
                i2 |= IA[s.charAt(j++)] << 18 - k2 * 6;

            for(int l2 = 16; k1 < j1; l2 -= 8)
                abyte0[k1++] = (byte)(i2 >> l2);

        }
        return abyte0;
    }

    private static final char CA[];
    private static final int IA[];

    static 
    {
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        IA = new int[256];
        Arrays.fill(IA, -1);
        int i = 0;
        for(int j = CA.length; i < j; i++)
            IA[CA[i]] = i;

        IA[61] = 0;
    }
}
