// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G

public class J
    implements G
{

    public J()
    {
        DE = 1.0F;
        D6 = false;
        DD = new Color(127, 127, 255);
        D9 = DD.brighter();
        D8 = DD.darker();
        DA = DD.darker().darker();
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(10F * DE);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(10F * DE);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.E);
            if(obj != null && (obj instanceof Color))
            {
                DD = (Color)obj;
                D9 = DD.brighter();
                D8 = DD.darker();
            }
            obj = map.get(G.A);
            if(obj != null && (obj instanceof Color))
                DA = (Color)obj;
        }
    }

    public void A(float f)
    {
        DE = f;
    }

    public void D(boolean flag)
    {
        D6 = flag;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        Color color = graphics2d.getColor();
        float f = i;
        float f1 = j;
        if(D6)
            graphics2d.setColor(DA.brighter());
        else
            graphics2d.setColor(D9);
        float f2 = 8F * DE;
        float f3 = 4F * DE;
        DC.reset();
        DC.moveTo(f, f1 + f2);
        DC.lineTo(f + f2, f1);
        DC.lineTo(f + f2 + f3, f1 + f3);
        DC.lineTo(f + f3, f1 + f3 + f2);
        DC.closePath();
        graphics2d.fill(DC);
        float f4 = 6.5F * DE;
        float f5 = 2.5F * DE;
        float f6 = f + 1.5F * DE;
        float f7 = f1 + 1.5F * DE;
        graphics2d.setColor(D8);
        DC.reset();
        DC.moveTo(f, f1 + f2);
        DC.lineTo(f6, f1 + f2);
        DC.lineTo(f6 + f5 + f4, f7 + f5);
        DC.lineTo(f + f2 + f3, f1 + f3);
        DC.lineTo(f + f3, f1 + f3 + f2);
        DC.closePath();
        graphics2d.fill(DC);
        if(D6)
            graphics2d.setColor(DA);
        else
            graphics2d.setColor(DD);
        DC.reset();
        DC.moveTo(f6, f7 + f4);
        DC.lineTo(f6 + f4, f7);
        DC.lineTo(f6 + f4 + f5, f7 + f5);
        DC.lineTo(f6 + f5, f7 + f5 + f4);
        DC.closePath();
        graphics2d.fill(DC);
        graphics2d.setColor(color);
    }

    private float DE;
    private boolean D6;
    private Color DD;
    private Color D9;
    private Color D8;
    private Color DA;
    private static final java.awt.geom.Rectangle2D.Float DB = new java.awt.geom.Rectangle2D.Float();
    private static final GeneralPath DC = new GeneralPath();

}
