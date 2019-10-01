// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.E.M;
import java.awt.*;
import java.awt.geom.Point2D;

// Referenced classes of package C.J:
//            j, K

public class m
    implements j
{

    public m(K k)
    {
        E = 4;
        A = k;
        D = Color.white;
        B = new Point(0, 0);
    }

    public void A(Color color)
    {
        D = color;
    }

    public void A(Graphics2D graphics2d, int i, int k, int l, int i1)
    {
        Color color = graphics2d.getColor();
        java.awt.geom.AffineTransform affinetransform = graphics2d.getTransform();
        A(graphics2d);
        if(C != null)
            switch(E)
            {
            case 4: // '\004'
                G(graphics2d);
                break;

            case 3: // '\003'
                B(graphics2d);
                break;

            case 1: // '\001'
                E(graphics2d);
                break;

            case 2: // '\002'
                F(graphics2d);
                break;

            case 0: // '\0'
                H(graphics2d);
                break;

            case 5: // '\005'
                C(graphics2d);
                break;

            default:
                M.A("Unknown background rendering mode: " + E);
                break;
            }
        graphics2d.setColor(color);
        graphics2d.setTransform(affinetransform);
    }

    void A(Graphics2D graphics2d)
    {
        if(D != null)
        {
            Rectangle rectangle = graphics2d.getClipBounds();
            graphics2d.setColor(D);
            graphics2d.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    void C(Graphics2D graphics2d)
    {
        int i = C.getWidth(null);
        int k = C.getHeight(null);
        graphics2d.drawImage(C, B.x, B.y, null);
    }

    void G(Graphics2D graphics2d)
    {
        D(graphics2d);
        int i = C.getWidth(null);
        int k = C.getHeight(null);
        graphics2d.drawImage(C, B.x, B.y, null);
    }

    void B(Graphics2D graphics2d)
    {
        D(graphics2d);
        int i = C.getWidth(null);
        int k = C.getHeight(null);
        int l = A.getWidth();
        int i1 = A.getHeight();
        graphics2d.drawImage(C, (l - i) / 2, (i1 - k) / 2, null);
    }

    void E(Graphics2D graphics2d)
    {
        D(graphics2d);
        Rectangle rectangle = graphics2d.getClipBounds();
        int i = C.getWidth(null);
        int k = C.getHeight(null);
        int l = -B.x + rectangle.x;
        int i1 = -B.y + rectangle.y;
        int j1 = l % i;
        l = rectangle.x - j1;
        if(j1 != 0)
            l -= i;
        j1 = i1 % k;
        i1 = rectangle.y - j1;
        if(j1 != 0)
            i1 -= k;
        for(int k1 = i1; k1 < rectangle.y + rectangle.height; k1 += k)
        {
            for(int l1 = l; l1 < rectangle.x + rectangle.width; l1 += i)
                graphics2d.drawImage(C, l1, k1, null);

        }

    }

    void F(Graphics2D graphics2d)
    {
        D(graphics2d);
        Rectangle rectangle = graphics2d.getClipBounds();
        int i = C.getWidth(null);
        int k = C.getHeight(null);
        boolean flag = true;
        for(int l = 0; l < rectangle.y + rectangle.height; l += k)
        {
            for(int i1 = flag ? 0 : -i / 2; i1 < rectangle.x + rectangle.width; i1 += i)
                graphics2d.drawImage(C, i1, l, null);

            flag = !flag;
        }

    }

    void H(Graphics2D graphics2d)
    {
        D(graphics2d);
        int i = A.getWidth();
        int k = A.getHeight();
        graphics2d.drawImage(C, 0, 0, i, k, null);
    }

    protected void D(Graphics2D graphics2d)
    {
        Point2D point2d = A.k();
        double d = 1.0D / A.h();
        graphics2d.translate(point2d.getX(), point2d.getY());
        graphics2d.scale(d, d);
    }

    protected K A;
    private Image C;
    private Color D;
    private Point B;
    private byte E;
}
