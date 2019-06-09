// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.B.H;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import javax.swing.Icon;

// Referenced classes of package B.B.A:
//            F

public class L
    implements F
{
    static class _A
        implements Icon, Serializable
    {

        private void A(Font font)
        {
            C = font;
            TextLayout textlayout = new TextLayout(E + "|", font, B);
            Rectangle2D rectangle2d = textlayout.getBounds();
            A = rectangle2d.getWidth();
            K = rectangle2d.getHeight();
            I = rectangle2d.getY();
        }

        public int getIconWidth()
        {
            return Math.max(8, (int)A);
        }

        public int getIconHeight()
        {
            return (int)K;
        }

        public void paintIcon(Component component, Graphics g, int i, int j)
        {
            Color color = g.getColor();
            Font font = g.getFont();
            g.setColor(Color.BLACK);
            g.setFont(C);
            ((Graphics2D)g).drawString(E, i, (float)((double)j - I));
            g.setFont(font);
            g.setColor(color);
        }

        private static final FontRenderContext B = new FontRenderContext(new AffineTransform(), false, false);
        private static final Font H = new Font("Dialog", 0, 12);
        public static final Icon D = new _A('+');
        public static final Icon G = new _A('#');
        public static final Icon F = new _A('/');
        public static final Icon J = new _A('-');
        private final String E;
        private double A;
        private double K;
        private double I;
        private Font C;


        private _A(char c)
        {
            E = Character.toString(c);
            A(H);
        }
    }


    public L()
    {
    }

    public Icon A(H h)
    {
        int i = h.D();
        Icon icon;
        if(Modifier.isPublic(i))
            icon = _A.D;
        else
        if(Modifier.isProtected(i))
            icon = _A.G;
        else
        if(Modifier.isPrivate(i))
            icon = _A.J;
        else
            icon = _A.F;
        return icon;
    }
}
