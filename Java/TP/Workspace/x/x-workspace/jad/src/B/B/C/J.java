// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.C;
import C.H.A.M;
import C.H.A.N;
import C.H.A.Z;
import C.H.K;
import C.J.O;
import C.J._;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class J
{

    public J()
    {
    }

    public Color E(String s)
    {
        if("".equals(s))
            return B;
        else
            return K.A(s);
    }

    public O A(String s)
    {
        int i = Integer.parseInt(s.substring(s.length() - 1));
        byte byte0 = C.H.A.J.G(s.substring(0, s.length() - 2));
        return O.A(i, byte0);
    }

    public _ F(String s)
    {
        _ _l = (_)A.get(s);
        if(_l != null)
            return _l;
        else
            return C.H.A.J.H(s);
    }

    public Double B(String s)
    {
        return new Double(s);
    }

    public Byte D(String s)
    {
        return new Byte(N.J(s));
    }

    public Font C(String s)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, "-");
        String s1 = stringtokenizer.nextToken();
        String s2 = stringtokenizer.nextToken();
        String s3 = stringtokenizer.nextToken();
        return new Font(s1, Z.M(s2), Integer.parseInt(s3));
    }

    public String C(Object obj)
    {
        O o = (O)obj;
        String s = M.C(o.A());
        return s + "_" + (int)o.getLineWidth();
    }

    public String B(Object obj)
    {
        return K.A((Color)obj);
    }

    public String D(Object obj)
    {
        Font font = (Font)obj;
        return font.getFamily() + '-' + C.H.A.K.A(font.getStyle()) + '-' + font.getSize();
    }

    public String A(Object obj)
    {
        return M.A((_)obj);
    }

    public String E(Object obj)
    {
        return obj.toString();
    }

    static final Color B = new Color(255, 255, 255, 0);
    static final Map A;

    static 
    {
        A = new HashMap();
        B.B.A.C.A();
        A.put("circle", _.A("UML:Circle5"));
        A.put("transparent_circle", _.A("UML:CircleTransparent7"));
        A.put("transparent_semi_circle", _.A("UML:SemiCircleTransparent7"));
        A.put("white_circle", _.A("UML:CircleWhite5"));
        A.put("uml", _.A("UML:Wedge"));
    }
}
