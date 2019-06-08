// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Comment;

// Referenced classes of package org.apache.batik.dom:
//            AbstractCharacterData

public abstract class AbstractComment extends AbstractCharacterData
    implements Comment
{

    public AbstractComment()
    {
    }

    public String getNodeName()
    {
        return "#comment";
    }

    public short getNodeType()
    {
        return 8;
    }
}
