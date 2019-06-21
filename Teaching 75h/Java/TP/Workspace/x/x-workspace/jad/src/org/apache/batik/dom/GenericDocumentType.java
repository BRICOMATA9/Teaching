// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractChildNode

public class GenericDocumentType extends AbstractChildNode
    implements DocumentType
{

    public GenericDocumentType(String s, String s1, String s2)
    {
        qualifiedName = s;
        publicId = s1;
        systemId = s2;
    }

    public String getNodeName()
    {
        return qualifiedName;
    }

    public short getNodeType()
    {
        return 10;
    }

    public boolean isReadonly()
    {
        return true;
    }

    public void setReadonly(boolean flag)
    {
    }

    public String getName()
    {
        return null;
    }

    public NamedNodeMap getEntities()
    {
        return null;
    }

    public NamedNodeMap getNotations()
    {
        return null;
    }

    public String getPublicId()
    {
        return publicId;
    }

    public String getSystemId()
    {
        return systemId;
    }

    public String getInternalSubset()
    {
        return null;
    }

    protected Node newNode()
    {
        return new GenericDocumentType(qualifiedName, publicId, systemId);
    }

    protected String qualifiedName;
    protected String publicId;
    protected String systemId;
}
