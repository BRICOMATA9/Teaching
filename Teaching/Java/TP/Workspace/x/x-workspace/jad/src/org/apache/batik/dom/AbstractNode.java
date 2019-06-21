// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.io.Serializable;
import org.apache.batik.dom.events.EventSupport;
import org.apache.batik.dom.events.NodeEventTarget;
import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.*;
import org.w3c.dom.events.*;

// Referenced classes of package org.apache.batik.dom:
//            ExtendedNode, AbstractDocument

public abstract class AbstractNode
    implements ExtendedNode, Serializable
{

    public AbstractNode()
    {
    }

    public void setNodeName(String s)
    {
    }

    public void setOwnerDocument(Document document)
    {
        ownerDocument = (AbstractDocument)document;
    }

    public void setSpecified(boolean flag)
    {
        throw createDOMException((short)11, "node.type", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public String getNodeValue()
        throws DOMException
    {
        return null;
    }

    public void setNodeValue(String s)
        throws DOMException
    {
    }

    public Node getParentNode()
    {
        return null;
    }

    public void setParentNode(Node node)
    {
        throw createDOMException((short)3, "parent.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public NodeList getChildNodes()
    {
        return EMPTY_NODE_LIST;
    }

    public Node getFirstChild()
    {
        return null;
    }

    public Node getLastChild()
    {
        return null;
    }

    public void setPreviousSibling(Node node)
    {
        throw createDOMException((short)3, "sibling.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public Node getPreviousSibling()
    {
        return null;
    }

    public void setNextSibling(Node node)
    {
        throw createDOMException((short)3, "sibling.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public Node getNextSibling()
    {
        return null;
    }

    public boolean hasAttributes()
    {
        return false;
    }

    public NamedNodeMap getAttributes()
    {
        return null;
    }

    public Document getOwnerDocument()
    {
        return ownerDocument;
    }

    public String getNamespaceURI()
    {
        return null;
    }

    public Node insertBefore(Node node, Node node1)
        throws DOMException
    {
        throw createDOMException((short)3, "children.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public Node replaceChild(Node node, Node node1)
        throws DOMException
    {
        throw createDOMException((short)3, "children.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public Node removeChild(Node node)
        throws DOMException
    {
        throw createDOMException((short)3, "children.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public Node appendChild(Node node)
        throws DOMException
    {
        throw createDOMException((short)3, "children.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    public boolean hasChildNodes()
    {
        return false;
    }

    public Node cloneNode(boolean flag)
    {
        return flag ? deepCopyInto(newNode()) : copyInto(newNode());
    }

    public void normalize()
    {
    }

    public boolean isSupported(String s, String s1)
    {
        return getCurrentDocument().getImplementation().hasFeature(s, s1);
    }

    public String getPrefix()
    {
        return getNamespaceURI() != null ? DOMUtilities.getPrefix(getNodeName()) : null;
    }

    public void setPrefix(String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s1 = getNamespaceURI();
        if(s1 == null)
            throw createDOMException((short)14, "namespace", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s2 = getLocalName();
        if(s == null)
            setNodeName(s2);
        if(!s.equals("") && !DOMUtilities.isValidName(s))
            throw createDOMException((short)5, "prefix", new Object[] {
                new Integer(getNodeType()), getNodeName(), s
            });
        if(!DOMUtilities.isValidPrefix(s))
            throw createDOMException((short)14, "prefix", new Object[] {
                new Integer(getNodeType()), getNodeName(), s
            });
        if(s.equals("xml") && !"http://www.w3.org/XML/1998/namespace".equals(s1) || s.equals("xmlns") && !"http://www.w3.org/2000/xmlns/".equals(s1))
        {
            throw createDOMException((short)14, "namespace.uri", new Object[] {
                new Integer(getNodeType()), getNodeName(), s1
            });
        } else
        {
            setNodeName(s + ":" + s2);
            return;
        }
    }

    public String getLocalName()
    {
        return getNamespaceURI() != null ? DOMUtilities.getLocalName(getNodeName()) : null;
    }

    public DOMException createDOMException(short word0, String s, Object aobj[])
    {
        return new DOMException(word0, getCurrentDocument().formatMessage(s, aobj));
        Exception exception;
        exception;
        return new DOMException(word0, s);
    }

    public void addEventListener(String s, EventListener eventlistener, boolean flag)
    {
        if(eventSupport == null)
        {
            eventSupport = new EventSupport();
            AbstractDocument abstractdocument = getCurrentDocument();
            abstractdocument.setEventsEnabled(true);
        }
        eventSupport.addEventListener(s, eventlistener, flag);
    }

    public void removeEventListener(String s, EventListener eventlistener, boolean flag)
    {
        if(eventSupport != null)
            eventSupport.removeEventListener(s, eventlistener, flag);
    }

    public NodeEventTarget getParentNodeEventTarget()
    {
        return (NodeEventTarget)getParentNode();
    }

    public boolean dispatchEvent(Event event)
        throws EventException
    {
        return EventSupport.dispatchEvent(this, event);
    }

    public EventSupport getEventSupport()
    {
        return eventSupport;
    }

    public void fireDOMNodeInsertedIntoDocumentEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMNodeInsertedIntoDocument", true, false, null, null, null, null, (short)2);
            dispatchEvent(mutationevent);
        }
    }

    public void fireDOMNodeRemovedFromDocumentEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMNodeRemovedFromDocument", true, false, null, null, null, null, (short)3);
            dispatchEvent(mutationevent);
        }
    }

    protected void fireDOMCharacterDataModifiedEvent(String s, String s1)
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMCharacterDataModified", true, false, null, s, s1, null, (short)1);
            dispatchEvent(mutationevent);
        }
    }

    protected AbstractDocument getCurrentDocument()
    {
        return ownerDocument;
    }

    protected abstract Node newNode();

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        AbstractNode abstractnode = (AbstractNode)node;
        abstractnode.ownerDocument = abstractdocument;
        abstractnode.setReadonly(false);
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        AbstractNode abstractnode = (AbstractNode)node;
        abstractnode.ownerDocument = abstractdocument;
        abstractnode.setReadonly(false);
        return node;
    }

    protected Node copyInto(Node node)
    {
        AbstractNode abstractnode = (AbstractNode)node;
        abstractnode.ownerDocument = ownerDocument;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        AbstractNode abstractnode = (AbstractNode)node;
        abstractnode.ownerDocument = ownerDocument;
        return node;
    }

    protected void checkChildType(Node node, boolean flag)
    {
        throw createDOMException((short)3, "children.not.allowed", new Object[] {
            new Integer(getNodeType()), getNodeName()
        });
    }

    protected static final NodeList EMPTY_NODE_LIST = new NodeList() {

        public Node item(int i)
        {
            return null;
        }

        public int getLength()
        {
            return 0;
        }

    };
    protected AbstractDocument ownerDocument;
    protected transient EventSupport eventSupport;

}
