// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.io.Serializable;
import org.w3c.dom.*;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.dom:
//            AbstractNode, ExtendedNode, AbstractDocument, AbstractText

public abstract class AbstractParentNode extends AbstractNode
{
    protected class ChildNodes
        implements NodeList, Serializable
    {

        public Node item(int i)
        {
            if(i < 0 || i >= children)
                return null;
            if(i < children >> 1)
            {
                Object obj = firstChild;
                for(int j = 0; j < i; j++)
                    obj = ((Node) (obj)).getNextSibling();

                return ((Node) (obj));
            }
            Object obj1 = lastChild;
            for(int k = children - 1; k > i; k--)
                obj1 = ((Node) (obj1)).getPreviousSibling();

            return ((Node) (obj1));
        }

        public int getLength()
        {
            return children;
        }

        public ExtendedNode append(ExtendedNode extendednode)
        {
            if(lastChild == null)
            {
                firstChild = extendednode;
            } else
            {
                lastChild.setNextSibling(extendednode);
                extendednode.setPreviousSibling(lastChild);
            }
            lastChild = extendednode;
            children++;
            return extendednode;
        }

        public ExtendedNode insert(ExtendedNode extendednode, ExtendedNode extendednode1)
        {
            if(extendednode1 == null)
                return append(extendednode);
            if(extendednode1 == firstChild)
            {
                firstChild.setPreviousSibling(extendednode);
                extendednode.setNextSibling(firstChild);
                firstChild = extendednode;
                children++;
                return extendednode;
            }
            if(extendednode1 == lastChild)
            {
                ExtendedNode extendednode2 = (ExtendedNode)extendednode1.getPreviousSibling();
                extendednode2.setNextSibling(extendednode);
                extendednode1.setPreviousSibling(extendednode);
                extendednode.setNextSibling(extendednode1);
                extendednode.setPreviousSibling(extendednode2);
                children++;
                return extendednode;
            }
            ExtendedNode extendednode3 = (ExtendedNode)extendednode1.getPreviousSibling();
            if(extendednode3.getNextSibling() == extendednode1 && extendednode3.getParentNode() == extendednode1.getParentNode())
            {
                extendednode3.setNextSibling(extendednode);
                extendednode.setPreviousSibling(extendednode3);
                extendednode.setNextSibling(extendednode1);
                extendednode1.setPreviousSibling(extendednode);
                children++;
                return extendednode;
            } else
            {
                throw createDOMException((short)8, "child.missing", new Object[] {
                    new Integer(extendednode1.getNodeType()), extendednode1.getNodeName()
                });
            }
        }

        public ExtendedNode replace(ExtendedNode extendednode, ExtendedNode extendednode1)
        {
            if(extendednode1 == firstChild)
            {
                ExtendedNode extendednode2 = (ExtendedNode)firstChild.getNextSibling();
                extendednode.setNextSibling(extendednode2);
                if(extendednode1 == lastChild)
                    lastChild = extendednode;
                else
                    extendednode2.setPreviousSibling(extendednode);
                firstChild.setNextSibling(null);
                firstChild = extendednode;
                return extendednode1;
            }
            if(extendednode1 == lastChild)
            {
                ExtendedNode extendednode3 = (ExtendedNode)lastChild.getPreviousSibling();
                extendednode.setPreviousSibling(extendednode3);
                extendednode3.setNextSibling(extendednode);
                lastChild.setPreviousSibling(null);
                lastChild = extendednode;
                return extendednode1;
            }
            ExtendedNode extendednode4 = (ExtendedNode)extendednode1.getPreviousSibling();
            ExtendedNode extendednode5 = (ExtendedNode)extendednode1.getNextSibling();
            if(extendednode4.getNextSibling() == extendednode1 && extendednode5.getPreviousSibling() == extendednode1 && extendednode4.getParentNode() == extendednode1.getParentNode() && extendednode5.getParentNode() == extendednode1.getParentNode())
            {
                extendednode4.setNextSibling(extendednode);
                extendednode.setPreviousSibling(extendednode4);
                extendednode.setNextSibling(extendednode5);
                extendednode5.setPreviousSibling(extendednode);
                extendednode1.setPreviousSibling(null);
                extendednode1.setNextSibling(null);
                return extendednode1;
            } else
            {
                throw createDOMException((short)8, "child.missing", new Object[] {
                    new Integer(extendednode1.getNodeType()), extendednode1.getNodeName()
                });
            }
        }

        public ExtendedNode remove(ExtendedNode extendednode)
        {
            if(extendednode == firstChild)
                if(extendednode == lastChild)
                {
                    firstChild = null;
                    lastChild = null;
                    children--;
                    return extendednode;
                } else
                {
                    firstChild = (ExtendedNode)firstChild.getNextSibling();
                    firstChild.setPreviousSibling(null);
                    extendednode.setNextSibling(null);
                    children--;
                    return extendednode;
                }
            if(extendednode == lastChild)
            {
                lastChild = (ExtendedNode)lastChild.getPreviousSibling();
                lastChild.setNextSibling(null);
                extendednode.setPreviousSibling(null);
                children--;
                return extendednode;
            }
            ExtendedNode extendednode1 = (ExtendedNode)extendednode.getPreviousSibling();
            ExtendedNode extendednode2 = (ExtendedNode)extendednode.getNextSibling();
            if(extendednode1.getNextSibling() == extendednode && extendednode2.getPreviousSibling() == extendednode && extendednode1.getParentNode() == extendednode.getParentNode() && extendednode2.getParentNode() == extendednode.getParentNode())
            {
                extendednode1.setNextSibling(extendednode2);
                extendednode2.setPreviousSibling(extendednode1);
                extendednode.setPreviousSibling(null);
                extendednode.setNextSibling(null);
                children--;
                return extendednode;
            } else
            {
                throw createDOMException((short)8, "child.missing", new Object[] {
                    new Integer(extendednode.getNodeType()), extendednode.getNodeName()
                });
            }
        }

        protected ExtendedNode firstChild;
        protected ExtendedNode lastChild;
        protected int children;

        public ChildNodes()
        {
        }
    }

    protected class ElementsByTagNameNS
        implements NodeList
    {

        public Node item(int i)
        {
            if(size == -1)
                initialize();
            if(table == null || i < 0 || i > size)
                return null;
            else
                return table[i];
        }

        public int getLength()
        {
            if(size == -1)
                initialize();
            return size;
        }

        public void invalidate()
        {
            size = -1;
        }

        protected void append(Node node)
        {
            if(table == null)
                table = new Node[11];
            else
            if(size == table.length - 1)
            {
                Node anode[] = new Node[table.length * 2 + 1];
                for(int i = 0; i < size; i++)
                    anode[i] = table[i];

                table = anode;
            }
            table[size++] = node;
        }

        protected void initialize()
        {
            size = 0;
            for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
                initialize(node);

        }

        private void initialize(Node node)
        {
            if(node.getNodeType() == 1)
            {
                String s = node.getNamespaceURI();
                String s1 = s != null ? node.getLocalName() : node.getNodeName();
                if(nsMatch(namespaceURI, node.getNamespaceURI()) && (localName.equals("*") || localName.equals(s1)))
                    append(node);
            }
            for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
                initialize(node1);

        }

        private boolean nsMatch(String s, String s1)
        {
            if(s == null && s1 == null)
                return true;
            if(s == null || s1 == null)
                return false;
            if(s.equals("*"))
                return true;
            else
                return s.equals(s1);
        }

        protected Node table[];
        protected int size;
        protected String namespaceURI;
        protected String localName;

        public ElementsByTagNameNS(String s, String s1)
        {
            size = -1;
            namespaceURI = s;
            localName = s1;
        }
    }

    protected class ElementsByTagName
        implements NodeList
    {

        public Node item(int i)
        {
            if(size == -1)
                initialize();
            if(table == null || i < 0 || i >= size)
                return null;
            else
                return table[i];
        }

        public int getLength()
        {
            if(size == -1)
                initialize();
            return size;
        }

        public void invalidate()
        {
            size = -1;
        }

        protected void append(Node node)
        {
            if(table == null)
                table = new Node[11];
            else
            if(size == table.length - 1)
            {
                Node anode[] = new Node[table.length * 2 + 1];
                for(int i = 0; i < size; i++)
                    anode[i] = table[i];

                table = anode;
            }
            table[size++] = node;
        }

        protected void initialize()
        {
            size = 0;
            for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
                initialize(node);

        }

        private void initialize(Node node)
        {
            if(node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                if(name.equals("*") || name.equals(s))
                    append(node);
            }
            for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
                initialize(node1);

        }

        protected Node table[];
        protected int size;
        protected String name;

        public ElementsByTagName(String s)
        {
            size = -1;
            name = s;
        }
    }


    public AbstractParentNode()
    {
    }

    public NodeList getChildNodes()
    {
        return childNodes != null ? childNodes : (childNodes = new ChildNodes());
    }

    public Node getFirstChild()
    {
        return childNodes != null ? childNodes.firstChild : null;
    }

    public Node getLastChild()
    {
        return childNodes != null ? childNodes.lastChild : null;
    }

    public Node insertBefore(Node node, Node node1)
        throws DOMException
    {
        if(node1 != null && (childNodes == null || node1.getParentNode() != this))
            throw createDOMException((short)8, "child.missing", new Object[] {
                new Integer(node1.getNodeType()), node1.getNodeName()
            });
        checkAndRemove(node, false);
        if(node.getNodeType() == 11)
        {
            Node node3;
            for(Node node2 = node.getFirstChild(); node2 != null; node2 = node3)
            {
                node3 = node2.getNextSibling();
                insertBefore(node2, node1);
            }

            return node;
        }
        if(childNodes == null)
            childNodes = new ChildNodes();
        ExtendedNode extendednode = childNodes.insert((ExtendedNode)node, (ExtendedNode)node1);
        extendednode.setParentNode(this);
        nodeAdded(extendednode);
        fireDOMNodeInsertedEvent(extendednode);
        fireDOMSubtreeModifiedEvent();
        return extendednode;
    }

    public Node replaceChild(Node node, Node node1)
        throws DOMException
    {
        if(childNodes == null || node1.getParentNode() != this)
            throw createDOMException((short)8, "child.missing", new Object[] {
                new Integer(node1.getNodeType()), node1.getNodeName()
            });
        checkAndRemove(node, true);
        if(node.getNodeType() == 11)
        {
            Node node2 = node.getLastChild();
            if(node2 == null)
                return node;
            Node node4 = node2.getPreviousSibling();
            replaceChild(node2, node1);
            Node node5 = node2;
            for(Node node3 = node4; node3 != null; node3 = node4)
            {
                node4 = node3.getPreviousSibling();
                insertBefore(node3, node5);
                node5 = node3;
            }

            return node;
        } else
        {
            fireDOMNodeRemovedEvent(node1);
            getCurrentDocument().nodeToBeRemoved(node1);
            nodeToBeRemoved(node1);
            ExtendedNode extendednode = (ExtendedNode)node;
            ExtendedNode extendednode1 = childNodes.replace(extendednode, (ExtendedNode)node1);
            extendednode.setParentNode(this);
            extendednode1.setParentNode(null);
            nodeAdded(extendednode);
            fireDOMNodeInsertedEvent(extendednode);
            fireDOMSubtreeModifiedEvent();
            return extendednode;
        }
    }

    public Node removeChild(Node node)
        throws DOMException
    {
        if(childNodes == null || node.getParentNode() != this)
            throw createDOMException((short)8, "child.missing", new Object[] {
                new Integer(node.getNodeType()), node.getNodeName()
            });
        if(isReadonly())
        {
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        } else
        {
            fireDOMNodeRemovedEvent(node);
            getCurrentDocument().nodeToBeRemoved(node);
            nodeToBeRemoved(node);
            ExtendedNode extendednode = childNodes.remove((ExtendedNode)node);
            extendednode.setParentNode(null);
            fireDOMSubtreeModifiedEvent();
            return extendednode;
        }
    }

    public Node appendChild(Node node)
        throws DOMException
    {
        checkAndRemove(node, false);
        if(node.getNodeType() == 11)
        {
            Node node2;
            for(Node node1 = node.getFirstChild(); node1 != null; node1 = node2)
            {
                node2 = node1.getNextSibling();
                appendChild(node1);
            }

            return node;
        }
        if(childNodes == null)
            childNodes = new ChildNodes();
        ExtendedNode extendednode = childNodes.append((ExtendedNode)node);
        extendednode.setParentNode(this);
        nodeAdded(extendednode);
        fireDOMNodeInsertedEvent(extendednode);
        fireDOMSubtreeModifiedEvent();
        return extendednode;
    }

    public boolean hasChildNodes()
    {
        return childNodes != null && childNodes.getLength() != 0;
    }

    public void normalize()
    {
        Node node = getFirstChild();
        if(node != null)
        {
            node.normalize();
            for(Node node1 = node.getNextSibling(); node1 != null;)
                if(node.getNodeType() == 3 && node1.getNodeType() == 3)
                {
                    String s = node.getNodeValue() + node1.getNodeValue();
                    AbstractText abstracttext = (AbstractText)node;
                    abstracttext.setNodeValue(s);
                    removeChild(node1);
                    node1 = node.getNextSibling();
                } else
                {
                    node1.normalize();
                    node = node1;
                    node1 = node1.getNextSibling();
                }

        }
    }

    public NodeList getElementsByTagName(String s)
    {
        if(s == null)
            return EMPTY_NODE_LIST;
        AbstractDocument abstractdocument = getCurrentDocument();
        ElementsByTagName elementsbytagname = abstractdocument.getElementsByTagName(this, s);
        if(elementsbytagname == null)
        {
            elementsbytagname = new ElementsByTagName(s);
            abstractdocument.putElementsByTagName(this, s, elementsbytagname);
        }
        return elementsbytagname;
    }

    public NodeList getElementsByTagNameNS(String s, String s1)
    {
        if(s1 == null)
            return EMPTY_NODE_LIST;
        AbstractDocument abstractdocument = getCurrentDocument();
        ElementsByTagNameNS elementsbytagnamens = abstractdocument.getElementsByTagNameNS(this, s, s1);
        if(elementsbytagnamens == null)
        {
            elementsbytagnamens = new ElementsByTagNameNS(s, s1);
            abstractdocument.putElementsByTagNameNS(this, s, s1, elementsbytagnamens);
        }
        return elementsbytagnamens;
    }

    public void fireDOMNodeInsertedIntoDocumentEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            super.fireDOMNodeInsertedIntoDocumentEvent();
            for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
                ((AbstractNode)node).fireDOMNodeInsertedIntoDocumentEvent();

        }
    }

    public void fireDOMNodeRemovedFromDocumentEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            super.fireDOMNodeRemovedFromDocumentEvent();
            for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
                ((AbstractNode)node).fireDOMNodeRemovedFromDocumentEvent();

        }
    }

    protected void nodeAdded(Node node)
    {
    }

    protected void nodeToBeRemoved(Node node)
    {
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        for(Node node1 = getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            Node node2 = ((AbstractNode)node1).deepExport(node1.cloneNode(false), abstractdocument);
            node.appendChild(node2);
        }

        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        for(Node node1 = getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            Node node2 = node1.cloneNode(true);
            node.appendChild(node2);
        }

        return node;
    }

    protected void fireDOMSubtreeModifiedEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMSubtreeModified", true, false, null, null, null, null, (short)1);
            dispatchEvent(mutationevent);
        }
    }

    protected void fireDOMNodeInsertedEvent(Node node)
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMNodeInserted", true, false, this, null, null, null, (short)2);
            AbstractNode abstractnode = (AbstractNode)node;
            abstractnode.dispatchEvent(mutationevent);
            abstractnode.fireDOMNodeInsertedIntoDocumentEvent();
        }
    }

    protected void fireDOMNodeRemovedEvent(Node node)
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMNodeRemoved", true, false, this, null, null, null, (short)3);
            AbstractNode abstractnode = (AbstractNode)node;
            abstractnode.dispatchEvent(mutationevent);
            abstractnode.fireDOMNodeRemovedFromDocumentEvent();
        }
    }

    protected void checkAndRemove(Node node, boolean flag)
    {
        checkChildType(node, flag);
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        if(node.getOwnerDocument() != getCurrentDocument())
            throw createDOMException((short)4, "node.from.wrong.document", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        if(this == node)
            throw createDOMException((short)3, "add.self", new Object[] {
                getNodeName()
            });
        Node node1 = node.getParentNode();
        if(node1 == null)
            return;
        for(Node node2 = getParentNode(); node2 != null; node2 = node2.getParentNode())
            if(node2 == node)
                throw createDOMException((short)3, "add.ancestor", new Object[] {
                    new Integer(getNodeType()), getNodeName()
                });

        node1.removeChild(node);
    }

    protected ChildNodes childNodes;
}
