// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractDocumentFragment, AbstractDocument

public class GenericDocumentFragment extends AbstractDocumentFragment
{

    protected GenericDocumentFragment()
    {
    }

    public GenericDocumentFragment(AbstractDocument abstractdocument)
    {
        ownerDocument = abstractdocument;
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    protected Node newNode()
    {
        return new GenericDocumentFragment();
    }

    protected boolean readonly;
}
