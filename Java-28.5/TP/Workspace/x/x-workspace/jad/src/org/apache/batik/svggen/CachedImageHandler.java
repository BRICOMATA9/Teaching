// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;


// Referenced classes of package org.apache.batik.svggen:
//            GenericImageHandler, ImageCacher

public interface CachedImageHandler
    extends GenericImageHandler
{

    public abstract ImageCacher getImageCacher();
}
