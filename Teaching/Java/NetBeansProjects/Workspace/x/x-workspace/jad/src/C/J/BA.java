// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.*;

// Referenced classes of package C.J:
//            $A, K

class BA
    implements LayoutManager, ScrollPaneConstants
{

    BA()
    {
        D = new Dimension(-1, -1);
    }

    protected Component A(Component component, Component component1)
    {
        if(component != null && component != component1)
            component.getParent().remove(component);
        return component1;
    }

    public void addLayoutComponent(String s, Component component)
    {
        if(s.equals("CANVAS"))
            C = ($A)A(C, component);
        else
        if(s.equals("VERTICAL_SCROLLBAR"))
            A = (JScrollBar)A(A, component);
        else
        if(s.equals("HORIZONTAL_SCROLLBAR"))
            B = (JScrollBar)A(B, component);
        else
        if(s.equals("CORNER_COMPONENT"))
            E = (JComponent)A(E, component);
    }

    public void removeLayoutComponent(Component component)
    {
        if(component == C)
            C = null;
        else
        if(component == A)
            A = null;
        else
        if(component == B)
            B = null;
        else
        if(component == E)
            E = null;
    }

    public Dimension preferredLayoutSize(Container container)
    {
        K k = (K)container;
        int i = k.Z();
        int j = k.n();
        Insets insets = k.getInsets();
        int l = insets.left + insets.right;
        int i1 = insets.top + insets.bottom;
        Rectangle rectangle = null;
        Dimension dimension = null;
        if(C != null)
        {
            rectangle = k.X();
            dimension = C.getPreferredSize();
        }
        if(dimension != null)
        {
            l += dimension.width;
            i1 += dimension.height;
        }
        if(A != null && i != 21)
            if(i == 22)
                l += A.getPreferredSize().width;
            else
            if(dimension != null && rectangle != null && (double)rectangle.height > (double)dimension.height / k.h())
                l += A.getPreferredSize().width;
        if(B != null && j != 31)
            if(j == 32)
                i1 += B.getPreferredSize().height;
            else
            if(dimension != null && rectangle != null && (double)rectangle.width > (double)dimension.width / k.h())
                i1 += B.getPreferredSize().height;
        return new Dimension(l, i1);
    }

    public Dimension minimumLayoutSize(Container container)
    {
        K k = (K)container;
        int i = k.Z();
        int j = k.n();
        Insets insets = k.getInsets();
        int l = insets.left + insets.right;
        int i1 = insets.top + insets.bottom;
        if(C != null)
        {
            Dimension dimension = C.getMinimumSize();
            l += dimension.width;
            i1 += dimension.height;
        }
        if(A != null && i != 21)
        {
            Dimension dimension1 = A.getMinimumSize();
            l += dimension1.width;
            i1 = Math.max(i1, dimension1.height);
        }
        if(B != null && j != 21)
        {
            Dimension dimension2 = B.getMinimumSize();
            l = Math.max(l, dimension2.width);
            i1 += dimension2.height;
        }
        return new Dimension(l, i1);
    }

    public void layoutContainer(Container container)
    {
        K k = (K)container;
        Rectangle rectangle = new Rectangle(k.getSize());
        boolean flag = false;
        if(D.width != rectangle.width || D.height != rectangle.height)
        {
            flag = true;
            D.setSize(rectangle.width, rectangle.height);
        }
        int i = k.Z();
        int j = k.n();
        Insets insets = k.getInsets();
        rectangle.x = insets.left;
        rectangle.y = insets.top;
        rectangle.width -= insets.left + insets.right;
        rectangle.height -= insets.top + insets.bottom;
        if(flag && k.b())
        {
            Rectangle rectangle1 = new Rectangle(rectangle);
            if(j == 32)
                rectangle1.height -= B.getPreferredSize().height;
            if(i == 22)
                rectangle1.width -= A.getPreferredSize().width;
            C.setBounds(rectangle1);
            C.P();
        }
        Rectangle rectangle2 = k.X();
        Dimension dimension = k.getSize();
        double d = k.h();
        double d1 = 1.0D;
        Rectangle rectangle3 = new Rectangle(0, rectangle.y, 0, 0);
        java.awt.Point point = k.i();
        boolean flag1;
        if(i == 22)
            flag1 = true;
        else
        if(i == 21)
            flag1 = false;
        else
            flag1 = (double)rectangle2.y + d1 < point.getY() || (double)(rectangle2.y + rectangle2.height) - d1 > point.getY() + (double)dimension.height / d;
        if(A != null && flag1)
        {
            int l = A.getPreferredSize().width;
            rectangle.width -= l;
            rectangle3.x = rectangle.x + rectangle.width;
            rectangle3.width = l;
        }
        Rectangle rectangle4 = new Rectangle(rectangle.x, 0, 0, 0);
        boolean flag2;
        if(j == 32)
            flag2 = true;
        else
        if(j == 31)
            flag2 = false;
        else
        if(flag1)
            flag2 = (double)rectangle2.x + d1 < point.getX() || (double)(rectangle2.x + rectangle2.width) - d1 > point.getX() + (double)(dimension.width - rectangle3.width) / d;
        else
            flag2 = (double)rectangle2.x + d1 < point.getX() || (double)(rectangle2.x + rectangle2.width) - d1 > point.getX() + (double)dimension.width / d;
        if(B != null && flag2)
        {
            int i1 = B.getPreferredSize().height;
            rectangle.height -= i1;
            rectangle4.y = rectangle.y + rectangle.height;
            rectangle4.height = i1;
            if(A != null && !flag1 && i != 21)
            {
                flag1 = (double)rectangle2.y + d1 < point.getY() || (double)(rectangle2.y + rectangle2.height) - d1 > point.getY() + (double)rectangle.height / d;
                if(flag1)
                {
                    int j1 = A.getPreferredSize().width;
                    rectangle.width -= j1;
                    rectangle3.x = rectangle.x + rectangle.width;
                    rectangle3.width = j1;
                }
            }
        }
        rectangle3.height = rectangle.height;
        rectangle4.width = rectangle.width;
        if(C != null)
            C.setBounds(rectangle);
        if(E != null && A != null && flag1 && B != null && flag2)
            E.setBounds(rectangle.width, rectangle.height, rectangle3.width, rectangle4.height);
        k.m();
        if(A != null)
            if(flag1)
            {
                A.setBounds(rectangle3);
                A.setVisible(true);
            } else
            {
                A.setVisible(false);
            }
        if(B != null)
            if(flag2)
            {
                B.setBounds(rectangle4);
                B.setVisible(true);
            } else
            {
                B.setVisible(false);
            }
    }

    public boolean A(Container container)
    {
        K k = (K)container;
        int i = k.Z();
        int j = k.n();
        Rectangle rectangle = new Rectangle(k.getSize());
        Insets insets = k.getInsets();
        rectangle.x = insets.left;
        rectangle.y = insets.top;
        rectangle.width -= insets.left + insets.right;
        rectangle.height -= insets.top + insets.bottom;
        Rectangle rectangle1 = k.X();
        Dimension dimension = k.getSize();
        double d = k.h();
        Rectangle rectangle2 = new Rectangle(0, rectangle.y, 0, 0);
        boolean flag;
        if(i == 22)
            flag = true;
        else
        if(i == 21)
            flag = false;
        else
            flag = (double)rectangle1.height > (double)dimension.height / d;
        if(A != null && flag)
        {
            int l = A.getPreferredSize().width;
            rectangle.width -= l;
            rectangle2.x = rectangle.x + rectangle.width;
            rectangle2.width = l;
        }
        Rectangle rectangle3 = new Rectangle(rectangle.x, 0, 0, 0);
        boolean flag1 = false;
        if(j == 32)
            flag1 = true;
        else
        if(j == 31)
            flag1 = false;
        else
        if(flag)
            flag1 = (double)rectangle1.width > (double)(dimension.width - rectangle2.width) / d;
        else
            flag1 = (double)rectangle1.width > (double)dimension.width / d;
        if(B != null && flag1)
        {
            int i1 = B.getPreferredSize().height;
            rectangle.height -= i1;
            rectangle3.y = rectangle.y + rectangle.height;
            rectangle3.height = i1;
            if(A != null && !flag && i != 21)
                flag = (double)rectangle1.height > (double)rectangle.height / k.h();
        }
        return flag != A.isVisible() || flag1 != B.isVisible();
    }

    protected $A C;
    protected JScrollBar A;
    protected JScrollBar B;
    protected JComponent E;
    Dimension D;
}
