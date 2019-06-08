// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.A.P;
import C.A.Y;
import C.E.M;
import C.H.A.B;
import C.H.A.D;
import C.H.A.E;
import C.H.A.H;
import C.H.A.Q;
import C.H.A.c;
import C.H.A.d;
import C.J.b;
import java.awt.Color;
import java.io.*;

// Referenced classes of package C.H:
//            L

public class K extends L
{

    public K()
    {
    }

    public String A()
    {
        return "gml";
    }

    public void A(b b1, InputStream inputstream)
        throws IOException
    {
        b1.N();
        A(b1, ((Reader) (new InputStreamReader(inputstream))));
        b1.P();
    }

    public void A(b b1, String s)
        throws IOException
    {
        Exception exception;
        b1.N();
        java.net.URL url = b1.e();
        b1.A((new File(s)).toURL());
        FileReader filereader = new FileReader(s);
        try
        {
            A(b1, ((Reader) (filereader)));
        }
        catch(IOException ioexception)
        {
            b1.A(url);
            throw ioexception;
        }
        finally
        {
            filereader.close();
        }
        filereader.close();
        b1.P();
        break MISSING_BLOCK_LABEL_77;
        b1.P();
        throw exception;
    }

    protected void A(b b1, Reader reader)
        throws IOException
    {
        C.H.A.H._A _la = K().A(b1);
        H h = new H(_la);
        h.A(reader);
    }

    public static synchronized B K()
    {
        if(_ == null)
            _ = new d();
        return _;
    }

    public static synchronized E L()
    {
        if(a == null)
            a = new D();
        return a;
    }

    public void A(b b1, OutputStream outputstream)
        throws IOException
    {
        PrintWriter printwriter = new PrintWriter(outputstream);
        c c1 = new c(printwriter);
        E e = L();
        Q q = e.A();
        M.A(this, "saving in gml format....");
        q.A(b1, c1);
        printwriter.flush();
    }

    public static String A(Color color)
    {
        StringBuffer stringbuffer = new StringBuffer(9);
        stringbuffer.append('#');
        String s = Integer.toHexString(color.getRed()).toUpperCase();
        for(int i = 2 - s.length(); i > 0; i--)
            stringbuffer.append('0');

        stringbuffer.append(s);
        s = Integer.toHexString(color.getGreen()).toUpperCase();
        for(int j = 2 - s.length(); j > 0; j--)
            stringbuffer.append('0');

        stringbuffer.append(s);
        s = Integer.toHexString(color.getBlue()).toUpperCase();
        for(int k = 2 - s.length(); k > 0; k--)
            stringbuffer.append('0');

        stringbuffer.append(s);
        if(color.getAlpha() != 255)
        {
            String s1 = Integer.toHexString(color.getAlpha()).toUpperCase();
            for(int l = 2 - s1.length(); l > 0; l--)
                stringbuffer.append('0');

            stringbuffer.append(s1);
        }
        return stringbuffer.toString();
    }

    public static Color A(String s)
    {
        if(s.length() < 1 || s.charAt(0) != '#')
            return Color.black;
        int i;
        if(s.length() > 7)
        {
            i = Integer.parseInt(s.substring(1, 7), 16);
            int j = Integer.parseInt(s.substring(7), 16);
            i += (j & 0xff) << 24;
        } else
        {
            int k = Integer.parseInt(s.substring(1), 16);
            i = k + 0xff000000;
        }
        for(P p = Z.I(); p != null; p = p.C())
        {
            Color color1 = (Color)p.A();
            if(color1.getRGB() == i)
            {
                Z.A(p);
                Z.C(p);
                return color1;
            }
        }

        Color color = new Color(i, true);
        if(Z.size() >= 32)
        {
            P p1 = Z.G();
            Z.A(p1);
            p1.A(color);
            Z.C(p1);
        } else
        {
            Z.B(color);
        }
        return color;
    }

    private static Y Z;
    private static B _;
    private static E a;

    static 
    {
        Z = new Y();
        Z.add(Color.black);
        Z.add(Color.red);
        Z.add(Color.blue);
        Z.add(Color.yellow);
        Z.add(Color.green);
        Z.add(Color.white);
    }
}
