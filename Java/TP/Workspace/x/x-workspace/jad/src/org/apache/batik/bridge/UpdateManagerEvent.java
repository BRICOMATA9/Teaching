// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.image.BufferedImage;
import java.util.EventObject;

public class UpdateManagerEvent extends EventObject
{

    public UpdateManagerEvent(Object obj, BufferedImage bufferedimage, java.util.List list)
    {
        super(obj);
        image = bufferedimage;
        dirtyAreas = list;
        clearPaintingTransform = false;
    }

    public UpdateManagerEvent(Object obj, BufferedImage bufferedimage, java.util.List list, boolean flag)
    {
        super(obj);
        image = bufferedimage;
        dirtyAreas = list;
        clearPaintingTransform = flag;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public java.util.List getDirtyAreas()
    {
        return dirtyAreas;
    }

    public boolean getClearPaintingTransform()
    {
        return clearPaintingTransform;
    }

    protected BufferedImage image;
    protected java.util.List dirtyAreas;
    protected boolean clearPaintingTransform;
}
