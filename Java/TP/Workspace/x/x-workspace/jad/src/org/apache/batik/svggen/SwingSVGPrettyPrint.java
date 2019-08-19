// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGGraphics2D, SVGGeneratorContext, SVGIDGenerator

public abstract class SwingSVGPrettyPrint
    implements SVGSyntax
{

    public SwingSVGPrettyPrint()
    {
    }

    public static void print(JComponent jcomponent, SVGGraphics2D svggraphics2d)
    {
        if((jcomponent instanceof JComboBox) || (jcomponent instanceof JScrollBar))
        {
            printHack(jcomponent, svggraphics2d);
            return;
        }
        SVGGraphics2D svggraphics2d1 = (SVGGraphics2D)svggraphics2d.create();
        svggraphics2d1.setColor(jcomponent.getForeground());
        svggraphics2d1.setFont(jcomponent.getFont());
        Element element = svggraphics2d1.getTopLevelGroup();
        if(jcomponent.getWidth() <= 0 || jcomponent.getHeight() <= 0)
            return;
        Rectangle rectangle = svggraphics2d1.getClipBounds();
        if(rectangle == null)
            svggraphics2d1.setClip(0, 0, jcomponent.getWidth(), jcomponent.getHeight());
        paintComponent(jcomponent, svggraphics2d1);
        paintBorder(jcomponent, svggraphics2d1);
        paintChildren(jcomponent, svggraphics2d1);
        Element element1 = svggraphics2d1.getTopLevelGroup();
        element1.setAttributeNS(null, "id", svggraphics2d.getGeneratorContext().idGenerator.generateID(jcomponent.getClass().getName()));
        element.appendChild(element1);
        svggraphics2d.setTopLevelGroup(element);
    }

    private static void printHack(JComponent jcomponent, SVGGraphics2D svggraphics2d)
    {
        SVGGraphics2D svggraphics2d1 = (SVGGraphics2D)svggraphics2d.create();
        svggraphics2d1.setColor(jcomponent.getForeground());
        svggraphics2d1.setFont(jcomponent.getFont());
        Element element = svggraphics2d1.getTopLevelGroup();
        if(jcomponent.getWidth() <= 0 || jcomponent.getHeight() <= 0)
            return;
        Rectangle rectangle = svggraphics2d1.getClipBounds();
        if(rectangle == null)
            svggraphics2d1.setClip(0, 0, jcomponent.getWidth(), jcomponent.getHeight());
        jcomponent.paint(svggraphics2d1);
        Element element1 = svggraphics2d1.getTopLevelGroup();
        element1.setAttributeNS(null, "id", svggraphics2d.getGeneratorContext().idGenerator.generateID(jcomponent.getClass().getName()));
        element.appendChild(element1);
        svggraphics2d.setTopLevelGroup(element);
    }

    private static void paintComponent(JComponent jcomponent, SVGGraphics2D svggraphics2d)
    {
        ComponentUI componentui = UIManager.getUI(jcomponent);
        if(componentui != null)
        {
            componentui.installUI(jcomponent);
            componentui.update(svggraphics2d, jcomponent);
        }
    }

    private static void paintBorder(JComponent jcomponent, SVGGraphics2D svggraphics2d)
    {
        Border border = jcomponent.getBorder();
        if(border != null)
            if((jcomponent instanceof AbstractButton) || (jcomponent instanceof JPopupMenu) || (jcomponent instanceof JToolBar) || (jcomponent instanceof JMenuBar) || (jcomponent instanceof JProgressBar))
            {
                if((jcomponent instanceof AbstractButton) && ((AbstractButton)jcomponent).isBorderPainted() || (jcomponent instanceof JPopupMenu) && ((JPopupMenu)jcomponent).isBorderPainted() || (jcomponent instanceof JToolBar) && ((JToolBar)jcomponent).isBorderPainted() || (jcomponent instanceof JMenuBar) && ((JMenuBar)jcomponent).isBorderPainted() || (jcomponent instanceof JProgressBar) && ((JProgressBar)jcomponent).isBorderPainted())
                    border.paintBorder(jcomponent, svggraphics2d, 0, 0, jcomponent.getWidth(), jcomponent.getHeight());
            } else
            {
                border.paintBorder(jcomponent, svggraphics2d, 0, 0, jcomponent.getWidth(), jcomponent.getHeight());
            }
    }

    private static void paintChildren(JComponent jcomponent, SVGGraphics2D svggraphics2d)
    {
        int i = jcomponent.getComponentCount() - 1;
        boolean flag = false;
        Rectangle rectangle = new Rectangle();
        for(; i >= 0; i--)
        {
            Component component = jcomponent.getComponent(i);
            if(component == null || !JComponent.isLightweightComponent(component) || !component.isVisible())
                continue;
            Rectangle rectangle1 = null;
            boolean flag1 = component instanceof JComponent;
            if(flag1)
            {
                rectangle1 = rectangle;
                ((JComponent)component).getBounds(rectangle1);
            } else
            {
                rectangle1 = component.getBounds();
            }
            boolean flag2 = svggraphics2d.hitClip(rectangle1.x, rectangle1.y, rectangle1.width, rectangle1.height);
            if(!flag2)
                continue;
            SVGGraphics2D svggraphics2d1 = (SVGGraphics2D)svggraphics2d.create(rectangle1.x, rectangle1.y, rectangle1.width, rectangle1.height);
            svggraphics2d1.setColor(component.getForeground());
            svggraphics2d1.setFont(component.getFont());
            if(component instanceof JComponent)
                print((JComponent)component, svggraphics2d1);
            else
                component.paint(svggraphics2d1);
        }

    }
}
