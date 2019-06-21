// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.util.Properties;
import javax.imageio.ImageWriteParam;

public interface ImageParamConverter
{

    public abstract ImageWriteParam getWriteParam(Properties properties);
}
