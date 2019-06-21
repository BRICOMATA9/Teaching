// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G

public class F
    implements G
{

    public F()
    {
        A5 = 1.0F;
        C3 = false;
        C2 = false;
        B5 = new Color(255, 132, 255);
        AA = B5.brighter();
        BA = B5.darker();
        A2 = B5.darker().darker();
        C1 = B5;
        A3 = Color.YELLOW.darker();
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(12F * A5);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(12F * A5);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.C);
            if(obj != null && (obj instanceof Color))
            {
                B5 = (Color)obj;
                AA = B5.brighter();
                BA = B5.darker();
            }
            obj = map.get(G.G);
            if(obj != null && (obj instanceof Color))
                A2 = (Color)obj;
            obj = map.get(G.D);
            if(obj != null && (obj instanceof Color))
                C1 = (Color)obj;
            obj = map.get(G.L);
            if(obj != null && (obj instanceof Color))
                A3 = (Color)obj;
        }
    }

    public void A(float f)
    {
        A5 = f;
    }

    public void B(boolean flag)
    {
        C3 = flag;
    }

    public void A(boolean flag)
    {
        C2 = flag;
    }

    public boolean C()
    {
        return C2;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        Color color = graphics2d.getColor();
        float f = i;
        float f1 = j;
        if(C2)
            graphics2d.setColor(A3.brighter());
        else
        if(C3)
            graphics2d.setColor(A2.brighter());
        else
            graphics2d.setColor(AA);
        float f2 = 4F * A5;
        float f3 = 8F * A5;
        A4.reset();
        A4.moveTo(f, f1 + f2);
        A4.lineTo(f + f2, f1);
        A4.lineTo(f + f2 + f3, f1 + f3);
        A4.lineTo(f + f3, f1 + f3 + f2);
        A4.closePath();
        graphics2d.fill(A4);
        float f4 = 2.5F * A5;
        float f5 = 6.5F * A5;
        float f6 = f + 1.5F * A5;
        float f7 = f1 + 1.5F * A5;
        if(C2)
            graphics2d.setColor(A3.darker());
        else
            graphics2d.setColor(BA);
        A4.reset();
        A4.moveTo(f, f1 + f2);
        A4.lineTo(f6, f1 + f2);
        A4.lineTo(f6 + f5 + f4, f7 + f5);
        A4.lineTo(f + f2 + f3, f1 + f3);
        A4.lineTo(f + f3, f1 + f3 + f2);
        A4.closePath();
        graphics2d.fill(A4);
        if(C())
            graphics2d.setColor(C1);
        else
        if(C3)
            graphics2d.setColor(A2);
        else
            graphics2d.setColor(B5);
        A4.reset();
        A4.moveTo(f6, f7 + f4);
        A4.lineTo(f6 + f4, f7);
        A4.lineTo(f6 + f4 + f5, f7 + f5);
        A4.lineTo(f6 + f5, f7 + f5 + f4);
        A4.closePath();
        graphics2d.fill(A4);
        graphics2d.setColor(color);
    }

    private float A5;
    private boolean C3;
    private boolean C2;
    private Color B5;
    private Color AA;
    private Color BA;
    private Color A2;
    private Color C1;
    private Color A3;
    private static final java.awt.geom.Rectangle2D.Float C0 = new java.awt.geom.Rectangle2D.Float();
    private static final GeneralPath A4 = new GeneralPath();

}
