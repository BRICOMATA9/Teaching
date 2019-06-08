// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import C.J.V;
import C.J._;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public final class C
{
    private static final class _B
        implements V
    {

        public void A(Graphics2D graphics2d)
        {
            java.awt.Stroke stroke = graphics2d.getStroke();
            if(stroke instanceof BasicStroke)
                graphics2d.setStroke(new BasicStroke(((BasicStroke)stroke).getLineWidth()));
            else
                graphics2d.setStroke(new BasicStroke(1.0F));
            graphics2d.drawLine(0, 0, -B, -A);
            graphics2d.drawLine(0, 0, -B, A);
            graphics2d.setStroke(stroke);
        }

        public Rectangle A()
        {
            return new Rectangle(-B, -A, B, 2 * A);
        }

        private final int B;
        private final int A;

        public _B(int i, int j)
        {
            B = i;
            A = j;
        }
    }

    private static final class _D extends _A
    {

        public Rectangle A()
        {
            return new Rectangle(-L, -L, L, 2 * L);
        }

        void C(Graphics2D graphics2d)
        {
            java.awt.Shape shape = graphics2d.getClip();
            graphics2d.clipRect(-L, -L, L, 2 * L);
            graphics2d.draw(M);
            graphics2d.setClip(shape);
        }

        private final Ellipse2D M;
        private int L;

        public _D(int i)
        {
            L = i;
            int j = 2 * i;
            M = new java.awt.geom.Ellipse2D.Double(-i, -i, j, j);
        }
    }

    private static final class _C extends _A
    {

        public Rectangle A()
        {
            int i = 2 * H;
            return new Rectangle(-i, -H, i, i);
        }

        void C(Graphics2D graphics2d)
        {
            if(J)
            {
                Color color = graphics2d.getColor();
                if(K != null)
                    graphics2d.setColor(K);
                graphics2d.fill(I);
                graphics2d.setColor(color);
            }
            graphics2d.draw(I);
        }

        private final Ellipse2D I;
        private int H;
        private boolean J;
        private Color K;

        public _C(int i, boolean flag)
        {
            this(i, flag, null);
        }

        public _C(int i, boolean flag, Color color)
        {
            H = i;
            J = flag;
            K = color;
            int j = 2 * i;
            I = new java.awt.geom.Ellipse2D.Double(-j, -i, j, j);
        }
    }

    private static abstract class _A
        implements V
    {

        public void A(Graphics2D graphics2d)
        {
            java.awt.Stroke stroke = graphics2d.getStroke();
            if(stroke instanceof BasicStroke)
                graphics2d.setStroke(new BasicStroke(((BasicStroke)stroke).getLineWidth()));
            else
                graphics2d.setStroke(new BasicStroke(1.0F));
            java.awt.RenderingHints.Key key = RenderingHints.KEY_ANTIALIASING;
            Object obj = graphics2d.getRenderingHint(key);
            graphics2d.setRenderingHint(key, RenderingHints.VALUE_ANTIALIAS_ON);
            C(graphics2d);
            if(obj != null)
                graphics2d.setRenderingHint(key, obj);
            else
                graphics2d.getRenderingHints().remove(key);
            graphics2d.setStroke(stroke);
        }

        abstract void C(Graphics2D graphics2d);

        private _A()
        {
        }

    }


    public static void A()
    {
        if(_.A("UML:Circle5") != null)
            return;
        for(int i = 5; i < 9; i++)
            _.A("UML:Circle" + i, new _C(i, true), 2 * i, 0.0D);

        for(int j = 5; j < 9; j++)
            _.A("UML:CircleTransparent" + j, new _C(j, false), 2 * j, 2D);

        for(int k = 5; k < 9; k++)
            _.A("UML:CircleWhite" + k, new _C(k, true, Color.WHITE), 2 * k, 0.0D);

        for(int l = 5; l < 9; l++)
            _.A("UML:SemiCircleTransparent" + l, new _D(l), l, 2D);

        _.A("UML:Wedge", new _B(14, 4), 0.0D, 0.0D);
    }
}
