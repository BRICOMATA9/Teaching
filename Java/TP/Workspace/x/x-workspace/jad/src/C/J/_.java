// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.Hashtable;

// Referenced classes of package C.J:
//            O, V

public final class _
{

    private _(Shape shape, Color color, double d, double d1)
    {
        S = O.I;
        A(shape, color, O.I, null, d, d1);
    }

    private _(V v, double d, double d1)
    {
        S = O.I;
        G = 0;
        F = v;
        N = d;
        Q = d1;
    }

    private void A(Shape shape, Color color, Stroke stroke, Color color1, double d, double d1)
    {
        if(shape == null)
            shape = A((byte)1).D;
        else
            D = shape;
        Q = d1;
        N = d;
        I = color;
        S = stroke;
        C = color1;
        G = 0;
    }

    public static _ A(String s, V v, double d, double d1)
    {
        _ _l = new _(v, d, d1);
        _l.R = s;
        H.put(s, _l);
        return _l;
    }

    public static _ A(String s)
    {
        if(!H.containsKey(s))
            return null;
        else
            return (_)H.get(s);
    }

    public static _ A(byte byte0)
    {
        return B[byte0];
    }

    public byte C()
    {
        return G;
    }

    public String B()
    {
        return R;
    }

    public void A(Graphics2D graphics2d, AffineTransform affinetransform)
    {
        if(F != null)
            break MISSING_BLOCK_LABEL_126;
        if(this == K)
            return;
        if(I != null)
        {
            Shape shape = affinetransform.createTransformedShape(D);
            Color color = graphics2d.getColor();
            Stroke stroke = graphics2d.getStroke();
            graphics2d.setColor(I);
            graphics2d.fill(shape);
            graphics2d.setStroke(S);
            graphics2d.setColor(C == null ? color : C);
            graphics2d.draw(shape);
            graphics2d.setColor(color);
            graphics2d.setStroke(stroke);
            break MISSING_BLOCK_LABEL_151;
        }
        Shape shape1 = affinetransform.createTransformedShape(D);
        graphics2d.fill(shape1);
        break MISSING_BLOCK_LABEL_151;
        Exception exception;
        exception;
        throw exception;
        AffineTransform affinetransform1 = graphics2d.getTransform();
        graphics2d.transform(affinetransform);
        F.A(graphics2d);
        graphics2d.setTransform(affinetransform1);
    }

    public double A()
    {
        return N;
    }

    public double D()
    {
        return Q;
    }

    private static final Hashtable H;
    private static final _ B[];
    private static double J = 0.0D;
    public static final _ K;
    public static final _ M;
    public static final _ L;
    public static final _ A;
    public static final _ P;
    public static final _ O;
    public static final _ E;
    private Color I;
    private Shape D;
    private byte G;
    private String R;
    private double N;
    private double Q;
    private Color C;
    private Stroke S;
    private V F;

    static 
    {
        H = new Hashtable(11);
        B = new _[8];
        GeneralPath generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.lineTo(-12F, -5F);
        generalpath.lineTo(-9F, 0.0F);
        generalpath.lineTo(-12F, 5F);
        generalpath.closePath();
        M = new _(generalpath, null, 8D, 0.0D);
        generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.lineTo(-12F, -6F);
        generalpath.lineTo(-12F, 6F);
        generalpath.closePath();
        L = new _(generalpath, null, 11D, 0.0D);
        generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.lineTo(-16F, -6F);
        generalpath.lineTo(-16F, 6F);
        generalpath.closePath();
        A = new _(generalpath, Color.white, 15D, 0.0D);
        generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.lineTo(-7F, 5F);
        generalpath.lineTo(-14F, 0.0F);
        generalpath.lineTo(-7F, -5F);
        generalpath.closePath();
        P = new _(generalpath, null, 7D, 0.0D);
        E = new _(generalpath, Color.white, 7D, 0.0D);
        generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.lineTo(-8F, -6F);
        generalpath.lineTo(-5F, 0.0F);
        generalpath.lineTo(-8F, 6F);
        generalpath.closePath();
        O = new _(generalpath, null, 4D, 0.0D);
        generalpath = new GeneralPath(1, 6);
        generalpath.moveTo(0.0F, 0.0F);
        generalpath.closePath();
        K = new _(generalpath, null, 0.0D, 0.0D);
        H.put("Arrow.STANDARD", M);
        H.put("Arrow.DELTA", L);
        H.put("Arrow.WHITE_DELTA", A);
        H.put("Arrow.DIAMOND", P);
        H.put("Arrow.WHITE_DIAMOND", E);
        H.put("Arrow.SHORT", O);
        H.put("Arrow.NONE", K);
        B[1] = K;
        B[2] = M;
        B[3] = L;
        B[4] = A;
        B[5] = P;
        B[6] = E;
        B[7] = O;
        K.G = 1;
        M.G = 2;
        L.G = 3;
        A.G = 4;
        P.G = 5;
        E.G = 6;
        O.G = 7;
    }
}
