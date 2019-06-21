// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.I;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.dnd.Autoscroll;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.ToolTipManager;

// Referenced classes of package C.J:
//            L, a, i, m, 
//            Z, K, b, t, 
//            E, j, V, C, 
//            AA, k, o

public class $A extends JComponent
    implements L, Autoscroll
{

    $A(K k1)
    {
        C = 1.0D;
        O = new AffineTransform();
        V = new java.awt.geom.Point2D.Double();
        J = new java.awt.geom.Rectangle2D.Double();
        Z = 0;
        A = 0;
        U = 0.29999999999999999D;
        F = new ArrayList(5);
        W = new Insets(10, 10, 10, 10);
        setOpaque(true);
        Q = k1;
        setLayout(_ = new a());
        L = new i();
        H = new i();
        N = 25D;
        P = 25D;
        a = Color.gray;
        B = 3;
        b = false;
        I = new m(Q);
        R = new Z();
        T = false;
        ToolTipManager.sharedInstance().registerComponent(this);
    }

    private b O()
    {
        return Q.d();
    }

    public void F()
    {
        if(Z == 666)
            A(true);
        A(0, 0, getWidth(), getHeight());
    }

    private void A(int l, int i1, int j1, int k1)
    {
        if(Z == 1)
        {
            Rectangle rectangle = O().A((byte)0);
            Rectangle rectangle1 = L.A();
            Rectangle rectangle3 = H.A();
            Rectangle rectangle4;
            if(rectangle1.getWidth() > 0.0D)
            {
                if(rectangle.getWidth() >= 0.0D)
                    rectangle4 = rectangle.union(rectangle1);
                else
                    rectangle4 = rectangle1;
            } else
            {
                rectangle4 = rectangle;
            }
            if(rectangle3.getWidth() > 0.0D)
                rectangle4 = rectangle4.union(rectangle3);
            if(rectangle4.getWidth() > 0.0D && (R instanceof Z))
            {
                Z z = (Z)R;
                rectangle4 = A(rectangle4, z.B());
            }
            if(X != null)
            {
                Rectangle rectangle5 = A(rectangle4, X);
                rectangle5 = A(rectangle5, 8 + (int)((double)rectangle5.width * 0.050000000000000003D));
                X = rectangle4;
                rectangle4 = rectangle5;
            }
            l = (int)Math.round((rectangle4.getX() - V.getX()) * C);
            i1 = (int)Math.round((rectangle4.getY() - V.getY()) * C);
            j1 = (int)Math.round(rectangle4.getWidth() * C);
            k1 = (int)Math.round(rectangle4.getHeight() * C);
        } else
        if(Z == 2)
        {
            java.awt.geom.Rectangle2D.Double double1 = B(J);
            if(M != null)
                Rectangle.union(J, M, double1);
            Rectangle rectangle2 = new Rectangle();
            A(double1, rectangle2);
            l = rectangle2.x - 2;
            i1 = rectangle2.y - 2;
            j1 = rectangle2.width + 4;
            k1 = rectangle2.height + 4;
            M = B(J);
        }
        if(Y)
            paintImmediately(l, i1, j1, k1);
        else
            repaint(l, i1, j1, k1);
    }

    public void setBounds(int l, int i1, int j1, int k1)
    {
        if(!getBounds().equals(new Rectangle(l, i1, j1, k1)))
        {
            if(Z == 666)
                A(false);
            super.setBounds(l, i1, j1, k1);
            Q();
        }
    }

    public void reshape(int l, int i1, int j1, int k1)
    {
        if(!getBounds().equals(new Rectangle(l, i1, j1, k1)))
        {
            if(Z == 666)
                A(false);
            super.reshape(l, i1, j1, k1);
            Q();
        }
    }

    public void setBounds(Rectangle rectangle)
    {
        Rectangle rectangle1 = getBounds();
        super.setBounds(rectangle);
        firePropertyChange("Bounds", rectangle1, rectangle);
    }

    public Point T()
    {
        return new Point((int)V.x, (int)V.y);
    }

    public java.awt.geom.Point2D.Double G()
    {
        return new java.awt.geom.Point2D.Double(V.x, V.y);
    }

    public void B(double d, double d1)
    {
        if(!I())
            return;
        java.awt.geom.Point2D.Double double1 = G();
        if(M != null)
            M.setFrame(V.x, V.y, (double)V() / C, (double)H() / C);
        V.x = d;
        V.y = d1;
        Q();
        firePropertyChange("ViewPoint", double1, G());
    }

    public void A(double d, double d1)
    {
        if(!I())
        {
            return;
        } else
        {
            B(d - (double)U() / (2D * C), d1 - (double)L() / (2D * C));
            return;
        }
    }

    public Point2D N()
    {
        java.awt.geom.Point2D.Double double1 = new java.awt.geom.Point2D.Double();
        double1.setLocation(V.getX() + (double)U() / (2D * C), V.getY() + (double)L() / (2D * C));
        return double1;
    }

    public double S()
    {
        return C;
    }

    public void B(double d)
    {
        if(d <= 0.0D)
            throw new IllegalArgumentException("Zoom must be positive! was " + d);
        d = Math.max(9.0000000000000006E-05D, d);
        d = Math.min(100001D, d);
        if(!I())
        {
            return;
        } else
        {
            B(V.x + ((double)U() * (1.0D / C - 1.0D / d)) / 2D, V.y + ((double)L() * (1.0D / C - 1.0D / d)) / 2D);
            double d1 = C;
            C = d;
            firePropertyChange("Zoom", d1, C);
            Q();
            return;
        }
    }

    public void A(double d, double d1, double d2, double d3)
    {
        A(d, d1, d2, d3, Q.getParent() != null);
    }

    private void A(double d, double d1, double d2, double d3, boolean flag)
    {
        double d4 = S();
        A(d, d1, d2, d3, U(), L());
        if(flag)
        {
            Q.f();
            if(getWidth() > 0 && getHeight() > 0)
                A(d, d1, d2, d3, V(), H());
            Q.m();
        }
        double d5 = S();
        if(d5 != d4)
            firePropertyChange("Zoom", d4, d5);
    }

    private void A(double d, double d1, double d2, double d3, int l, int i1)
    {
        double d4 = (double)l / S();
        double d5 = (double)i1 / S();
        if(d4 / d5 > d2 / d3)
        {
            C = (C * d5) / d3;
            B(d - ((double)l / C - d2) / 2D, d1);
        } else
        {
            C = (C * d4) / d2;
            B(d, d1 - ((double)i1 / C - d3) / 2D);
        }
    }

    public void P()
    {
        A(O().X());
    }

    public void A(Rectangle rectangle)
    {
        if(rectangle.getWidth() <= (double)U() && rectangle.getHeight() <= (double)L())
        {
            B(1.0D);
            if(rectangle.getWidth() <= 0.0D || rectangle.getHeight() <= 0.0D)
                B(0.0D, 0.0D);
            else
                A(rectangle.getX() + rectangle.getWidth() / 2D, rectangle.getY() + rectangle.getHeight() / 2D);
            D();
        } else
        {
            A(rectangle.getX() - 10D, rectangle.getY() - 10D, rectangle.getWidth() + 20D, rectangle.getHeight() + 20D, false);
            D();
        }
    }

    public Rectangle C()
    {
        if(D == null)
            M();
        return A(D);
    }

    public java.awt.geom.Rectangle2D.Double M()
    {
        if(D == null)
        {
            Dimension dimension = getPreferredSize();
            D = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, dimension.width, dimension.height);
        }
        return D;
    }

    public void D()
    {
        D.setRect(V.x, V.y, (double)V() / S(), (double)H() / S());
    }

    public void Q()
    {
        double d = (double)V() / C;
        double d1 = (double)H() / C;
        double d2 = V.x;
        double d3 = V.y;
        java.awt.geom.Rectangle2D.Double double1 = M();
        if(double1.x > d2)
        {
            double1.width += double1.x - d2;
            double1.x = d2;
        }
        if(double1.x + double1.width < d2 + d)
            double1.width = (d2 + d) - double1.x;
        if(double1.y > d3)
        {
            double1.height += double1.y - d3;
            double1.y = d3;
        }
        if(double1.y + double1.height < d3 + d1)
            double1.height = (d3 + d1) - double1.y;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D graphics2d = (Graphics2D)((Graphics2D)g).create();
        graphics2d.setRenderingHint(t.A, new Double(J()));
        graphics2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        double d = -V.getX();
        double d1 = -V.getY();
        if(C < 1.5D)
        {
            d = Math.floor(d);
            d1 = Math.floor(d1);
        }
        AffineTransform affinetransform = graphics2d.getTransform();
        graphics2d.scale(C, C);
        graphics2d.translate(d, d1);
        if(G)
            C.J.E.B(graphics2d);
        C(graphics2d);
        AffineTransform affinetransform1 = graphics2d.getTransform();
        graphics2d.setTransform(affinetransform);
        B(graphics2d);
        graphics2d.setTransform(affinetransform1);
        A(graphics2d);
        D(graphics2d);
        E(graphics2d);
        if(Z == 2)
        {
            AffineTransform affinetransform2 = graphics2d.getTransform();
            graphics2d.setTransform(affinetransform);
            java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double((J.getX() - V.getX()) * C, (J.getY() - V.getY()) * C, J.getWidth() * C, J.getHeight() * C);
            Q.A(graphics2d, double1);
            graphics2d.setTransform(affinetransform2);
        }
        if(G)
            C.J.E.A(graphics2d);
        graphics2d.dispose();
    }

    private void C(Graphics2D graphics2d)
    {
        Rectangle rectangle = graphics2d.getClipBounds();
        int l = rectangle.x;
        int i1 = rectangle.y;
        int j1 = rectangle.width;
        int k1 = rectangle.height;
        A(graphics2d, l, i1, j1, k1);
    }

    private void B(Graphics2D graphics2d)
    {
        if(S && C >= U)
        {
            Color color = graphics2d.getColor();
            java.awt.Stroke stroke = graphics2d.getStroke();
            graphics2d.setColor(a);
            graphics2d.setStroke(new BasicStroke(1.0F));
            Rectangle rectangle = graphics2d.getClipBounds();
            double d = Math.floor(V.x / P) * P - V.x;
            double d1 = Math.floor(V.y / N) * N - V.y;
            double d2 = d * C + Math.floor(-1D + (double)rectangle.x / (P * C)) * (P * C);
            double d3 = d1 * C + Math.floor(-1D + (double)rectangle.y / (N * C)) * (N * C);
            double d4 = (double)(rectangle.x + rectangle.width) + P * C;
            double d5 = (double)(rectangle.y + rectangle.height) + N * C;
            double d6 = P * C;
            double d7 = N * C;
label0:
            switch(B)
            {
            default:
                break;

            case 1: // '\001'
                int l = rectangle.y;
                int i1 = rectangle.y + rectangle.height;
                int j1 = rectangle.x;
                int k1 = rectangle.x + rectangle.width;
                for(double d8 = d2; d8 <= d4; d8 += d6)
                {
                    int l1 = (int)d8;
                    graphics2d.drawLine(l1, l, l1, i1);
                }

                for(double d9 = d3; d9 <= d5; d9 += d7)
                {
                    int i2 = (int)d9;
                    graphics2d.drawLine(j1, i2, k1, i2);
                }

                break;

            case 3: // '\003'
                double d10 = d2;
                do
                {
                    if(d10 > d4)
                        break label0;
                    int j2 = (int)d10;
                    for(double d12 = d3; d12 <= d5; d12 += d7)
                    {
                        int l2 = (int)d12;
                        graphics2d.drawLine(j2, l2 - 3, j2, l2 + 3);
                        graphics2d.drawLine(j2 - 3, l2, j2 + 3, l2);
                    }

                    d10 += d6;
                } while(true);

            case 2: // '\002'
                double d11 = d2;
                do
                {
                    if(d11 > d4)
                        break label0;
                    int k2 = (int)d11;
                    for(double d13 = d3; d13 <= d5; d13 += d7)
                    {
                        int i3 = (int)d13;
                        graphics2d.drawLine(k2, i3 - 1, k2, i3 + 1);
                        graphics2d.drawLine(k2 - 1, i3, k2 + 1, i3);
                    }

                    d11 += d6;
                } while(true);
            }
            graphics2d.setStroke(stroke);
            graphics2d.setColor(color);
        }
    }

    private void A(Graphics2D graphics2d, int l, int i1, int j1, int k1)
    {
        Color color = graphics2d.getColor();
        java.awt.Stroke stroke = graphics2d.getStroke();
        AffineTransform affinetransform = graphics2d.getTransform();
        if(I != null)
            I.A(graphics2d, l, i1, j1, k1);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(color);
        graphics2d.setTransform(affinetransform);
    }

    void E(Graphics2D graphics2d)
    {
        if(S() >= U)
        {
            L.A(graphics2d);
            for(I l = O().j(); l.C(); l.B())
                ((V)l.D()).A(graphics2d);

        } else
        {
            for(I i1 = L.B(); i1.C(); i1.B())
                if(i1.D() instanceof C)
                    ((C)i1.D()).B(graphics2d);
                else
                    ((V)i1.D()).A(graphics2d);

            for(I j1 = O().j(); j1.C(); j1.B())
                if(j1.D() instanceof C)
                    ((C)j1.D()).B(graphics2d);
                else
                    ((V)j1.D()).A(graphics2d);

        }
    }

    void A(Graphics2D graphics2d)
    {
        if(S() >= U)
        {
            H.A(graphics2d);
        } else
        {
            for(I l = H.B(); l.C(); l.B())
                if(l.D() instanceof C)
                    ((C)l.D()).B(graphics2d);
                else
                    ((V)l.D()).A(graphics2d);

        }
    }

    public void D(Graphics2D graphics2d)
    {
        if(S() >= U)
            R.A(graphics2d, O());
        else
            R.B(graphics2d, O());
    }

    public void A(double d)
    {
        U = d;
    }

    public double J()
    {
        return U;
    }

    public void C(boolean flag)
    {
        if(flag)
        {
            Z = 1;
            X = O().A((byte)0);
        } else
        {
            Z = 0;
            X = null;
        }
    }

    Rectangle A(java.awt.geom.Rectangle2D.Double double1, Rectangle rectangle)
    {
        if(rectangle == null)
            rectangle = new Rectangle();
        rectangle.setFrame((double1.getX() - V.getX()) * C, (double1.getY() - V.getY()) * C, double1.getWidth() * C, double1.getHeight() * C);
        return rectangle;
    }

    void A(boolean flag)
    {
        if(Z == 666)
        {
            Z = 0;
            if(E != null)
            {
                JTextArea jtextarea = E;
                k k1 = (k)jtextarea.getClientProperty("ylabel");
                PropertyChangeListener propertychangelistener = (PropertyChangeListener)jtextarea.getClientProperty("pcl");
                remove(E);
                E = null;
                o o1 = (o)jtextarea.getClientProperty("activeViewMode");
                java.util.List list = (java.util.List)jtextarea.getClientProperty("disabledViewModes");
                if(o1 != null)
                    A(o1);
                if(list != null)
                {
                    for(Iterator iterator = list.iterator(); iterator.hasNext(); B((o)iterator.next()));
                }
                if(flag)
                {
                    String s = k1.f();
                    String s1 = jtextarea.getText();
                    if(!s1.equals(s))
                    {
                        k1.B(jtextarea.getText());
                        if(propertychangelistener != null)
                            propertychangelistener.propertyChange(new PropertyChangeEvent(k1, "text", s, k1.f()));
                    }
                }
                validate();
                F();
            }
            Q.requestFocus();
        }
    }

    public boolean K()
    {
        return K;
    }

    public double E()
    {
        return P;
    }

    private static Rectangle A(Rectangle rectangle, int l)
    {
        rectangle.x -= l;
        rectangle.y -= l;
        l *= 2;
        rectangle.width += l;
        rectangle.height += l;
        return rectangle;
    }

    private static Rectangle A(java.awt.geom.Rectangle2D.Double double1)
    {
        return new Rectangle((int)double1.x, (int)double1.y, (int)double1.width, (int)double1.height);
    }

    private static java.awt.geom.Rectangle2D.Double B(java.awt.geom.Rectangle2D.Double double1)
    {
        return new java.awt.geom.Rectangle2D.Double(double1.x, double1.y, double1.width, double1.height);
    }

    private static Rectangle A(Rectangle rectangle, Rectangle rectangle1)
    {
        return rectangle.union(rectangle1);
    }

    public Rectangle getVisibleRect()
    {
        return new Rectangle((int)V.x, (int)V.y, (int)((double)V() / S()), (int)((double)H() / S()));
    }

    public AA W()
    {
        return R;
    }

    public void A(AA aa)
    {
        R = aa;
    }

    private boolean I()
    {
        if(Z == 2)
            return true;
        if(Z == 1)
            C(false);
        else
        if(Z != 0)
            return false;
        return true;
    }

    public void A(j j1)
    {
        I = j1;
    }

    public void setToolTipText(String s)
    {
        c = s;
    }

    public String getToolTipText()
    {
        return c;
    }

    public JToolTip createToolTip()
    {
        if(Q != null)
        {
            JToolTip jtooltip = Q.createToolTip();
            jtooltip.setComponent(this);
            return jtooltip;
        } else
        {
            return super.createToolTip();
        }
    }

    private int U()
    {
        return Q.getWidth() <= 0 ? Q.getPreferredSize().width : Q.getWidth();
    }

    private int L()
    {
        return Q.getHeight() <= 0 ? Q.getPreferredSize().height : Q.getHeight();
    }

    int V()
    {
        return getWidth() <= 0 ? U() : getWidth();
    }

    int H()
    {
        return getHeight() <= 0 ? L() : getHeight();
    }

    void B(boolean flag)
    {
        Y = flag;
    }

    boolean R()
    {
        return Y;
    }

    public void autoscroll(Point point)
    {
        if(getParent() instanceof K)
        {
            int l = getWidth();
            int i1 = getHeight();
            int j1 = point.x >= W.left ? point.x <= l - W.right ? 0 : point.x - (l - W.right) : point.x - W.left;
            int k1 = point.y >= W.top ? point.y <= i1 - W.bottom ? 0 : point.y - (i1 - W.bottom) : point.y - W.top;
            if(j1 != 0 || k1 != 0)
            {
                ((K)getParent()).D(V.x + ((double)j1 * 3D) / C, V.y + ((double)k1 * 3D) / C);
                ((K)getParent()).A();
            }
        }
    }

    public Insets getAutoscrollInsets()
    {
        return W;
    }

    public void B(o o1)
    {
        if(o1 != null)
        {
            o1.A(Q);
            addMouseListener(o1);
            addMouseMotionListener(o1);
            F.add(o1);
            o1.A(true);
        }
    }

    public void A(o o1)
    {
        if(o1 != null)
        {
            if(F.remove(o1))
                o1.A(false);
            removeMouseListener(o1);
            removeMouseMotionListener(o1);
        }
    }

    private double C;
    AffineTransform O;
    private java.awt.geom.Rectangle2D.Double D;
    java.awt.geom.Point2D.Double V;
    private Rectangle X;
    private java.awt.geom.Rectangle2D.Double J;
    private java.awt.geom.Rectangle2D.Double M;
    private int Z;
    private int A;
    private K Q;
    private boolean Y;
    private boolean K;
    private double P;
    private double N;
    private Color a;
    private int B;
    private boolean b;
    private i L;
    private i H;
    private a _;
    private boolean T;
    private j I;
    private String c;
    private AA R;
    private double U;
    private boolean S;
    private boolean G;
    private java.util.List F;
    private JTextArea E;
    Insets W;
}
