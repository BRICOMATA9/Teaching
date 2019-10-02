// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.awt.*;

class a
    implements LayoutManager
{

    a()
    {
    }

    public void addLayoutComponent(String s, Component component)
    {
    }

    public void removeLayoutComponent(Component component)
    {
    }

    public Dimension preferredLayoutSize(Container container)
    {
        return new Dimension(1, 1);
    }

    public Dimension minimumLayoutSize(Container container)
    {
        return new Dimension(1, 1);
    }

    public void layoutContainer(Container container)
    {
        synchronized(container.getTreeLock())
        {
            if(container.getComponentCount() > 0)
            {
                Component component = container.getComponent(0);
                Dimension dimension = component.getPreferredSize();
                if(C != null)
                {
                    dimension.width = Math.max(dimension.width, C.width);
                    dimension.height = Math.max(dimension.height, C.height);
                } else
                {
                    C = dimension;
                }
                if(component.isVisible())
                {
                    component.setSize(dimension.width, dimension.height);
                    component.setLocation(B, A);
                }
            }
        }
    }

    int B;
    int A;
    Dimension C;
}
