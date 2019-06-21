// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterGraphics;
import java.io.Serializable;
import javax.swing.JPanel;

// Referenced classes of package org.freehep.graphics2d:
//            VectorGraphics

public class BufferedPanel extends JPanel
    implements Serializable
{

    public BufferedPanel()
    {
        this(true);
    }

    public BufferedPanel(boolean flag)
    {
        super(false);
        oldDimension = new Dimension();
        dim = new Dimension();
        printing = false;
        exporting = false;
        repaint = false;
        setOpaque(flag);
    }

    public void repaint()
    {
        super.repaint();
        repaint = true;
    }

    public void invalidate()
    {
        super.invalidate();
        repaint = true;
    }

    private synchronized boolean shouldRepaint()
    {
        boolean flag = repaint;
        repaint = false;
        return flag;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(g == null || offScreenImage == null)
            return;
        if(g instanceof PrinterGraphics)
            printing = true;
        if(g instanceof VectorGraphics)
            exporting = true;
        if(!isDisplaying())
        {
            paintComponent(VectorGraphics.create(g));
            return;
        }
        if(shouldRepaint())
            paintComponent(offScreenGraphics);
        g.drawImage(offScreenImage, 0, 0, this);
    }

    public Graphics getBufferedGraphics()
    {
        return offScreenGraphics;
    }

    public void paintComponent(VectorGraphics vectorgraphics)
    {
    }

    public void setBounds(int i, int j, int k, int l)
    {
        super.setBounds(i, j, k, l);
        makeImage();
    }

    public boolean isPrinting()
    {
        return printing;
    }

    public boolean isExporting()
    {
        return exporting;
    }

    public boolean isDisplaying()
    {
        return !isExporting() && !isPrinting();
    }

    private void makeImage()
    {
        dim = getSize(dim);
        if(dim.width > 0 && dim.height > 0)
        {
            if(!oldDimension.equals(dim))
            {
                if(isOpaque())
                    offScreenImage = super.createImage(dim.width, dim.height);
                else
                    offScreenImage = new BufferedImage(dim.width, dim.height, 2);
                offScreenGraphics = VectorGraphics.create(offScreenImage.getGraphics());
                oldDimension.setSize(dim);
            }
        } else
        {
            offScreenImage = null;
            offScreenGraphics = null;
        }
    }

    private VectorGraphics offScreenGraphics;
    private Image offScreenImage;
    private Dimension oldDimension;
    private Dimension dim;
    private boolean printing;
    private boolean exporting;
    private boolean repaint;
}
