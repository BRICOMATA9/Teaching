// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.io.Serializable;
import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.*;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentChildNode, AbstractParentNode, AbstractDocument, AbstractAttr, 
//            AbstractAttrNS

public abstract class AbstractElement extends AbstractParentChildNode
    implements Element
{
    protected static class Entry
        implements Serializable
    {

        public boolean match(String s, String s1)
        {
            if(namespaceURI != null)
            {
                if(!namespaceURI.equals(s))
                    return false;
            } else
            if(s != null)
                return false;
            return name.equals(s1);
        }

        public int hash;
        public String namespaceURI;
        public String name;
        public Node value;
        public Entry next;

        public Entry(int i, String s, String s1, Node node, Entry entry)
        {
            hash = i;
            namespaceURI = s;
            name = s1;
            value = node;
            next = entry;
        }
    }

    public class NamedNodeHashMap
        implements NamedNodeMap, Serializable
    {

        public Node getNamedItem(String s)
        {
            if(s == null)
                return null;
            else
                return get(null, s);
        }

        public Node setNamedItem(Node node)
            throws DOMException
        {
            if(node == null)
            {
                return null;
            } else
            {
                checkNode(node);
                return setNamedItem(null, node.getNodeName(), node);
            }
        }

        public Node removeNamedItem(String s)
            throws DOMException
        {
            return removeNamedItemNS(null, s);
        }

        public Node item(int i)
        {
            if(i < 0 || i >= count)
                return null;
            int j = 0;
            for(int k = 0; k < table.length; k++)
            {
                Entry entry = table[k];
                if(entry == null)
                    continue;
                do
                {
                    if(j++ == i)
                        return entry.value;
                    entry = entry.next;
                } while(entry != null);
            }

            return null;
        }

        public int getLength()
        {
            return count;
        }

        public Node getNamedItemNS(String s, String s1)
        {
            return get(s, s1);
        }

        public Node setNamedItemNS(Node node)
            throws DOMException
        {
            if(node == null)
            {
                return null;
            } else
            {
                String s = node.getNamespaceURI();
                return setNamedItem(s, s != null ? node.getLocalName() : node.getNodeName(), node);
            }
        }

        public Node removeNamedItemNS(String s, String s1)
            throws DOMException
        {
            if(isReadonly())
                throw createDOMException((short)7, "readonly.node.map", new Object[0]);
            if(s1 == null)
                throw createDOMException((short)8, "attribute.missing", new Object[] {
                    ""
                });
            AbstractAttr abstractattr = (AbstractAttr)remove(s, s1);
            if(abstractattr == null)
            {
                throw createDOMException((short)8, "attribute.missing", new Object[] {
                    s1
                });
            } else
            {
                abstractattr.setOwnerElement(null);
                fireDOMAttrModifiedEvent(abstractattr.getNodeName(), abstractattr, abstractattr.getNodeValue(), "", (short)3);
                return abstractattr;
            }
        }

        public Node setNamedItem(String s, String s1, Node node)
            throws DOMException
        {
            ((AbstractAttr)node).setOwnerElement(AbstractElement.this);
            AbstractAttr abstractattr = (AbstractAttr)put(s, s1, node);
            if(abstractattr != null)
            {
                abstractattr.setOwnerElement(null);
                fireDOMAttrModifiedEvent(s1, abstractattr, abstractattr.getNodeValue(), "", (short)3);
            }
            fireDOMAttrModifiedEvent(s1, (Attr)node, "", node.getNodeValue(), (short)2);
            return abstractattr;
        }

        protected void checkNode(Node node)
        {
            if(isReadonly())
                throw createDOMException((short)7, "readonly.node.map", new Object[0]);
            if(getOwnerDocument() != node.getOwnerDocument())
                throw createDOMException((short)4, "node.from.wrong.document", new Object[] {
                    new Integer(node.getNodeType()), node.getNodeName()
                });
            if(node.getNodeType() == 2 && ((Attr)node).getOwnerElement() != null)
                throw createDOMException((short)4, "inuse.attribute", new Object[] {
                    node.getNodeName()
                });
            else
                return;
        }

        protected Node get(String s, String s1)
        {
            int i = hashCode(s, s1) & 0x7fffffff;
            int j = i % table.length;
            for(Entry entry = table[j]; entry != null; entry = entry.next)
                if(entry.hash == i && entry.match(s, s1))
                    return entry.value;

            return null;
        }

        protected Node put(String s, String s1, Node node)
        {
            int i = hashCode(s, s1) & 0x7fffffff;
            int j = i % table.length;
            for(Entry entry = table[j]; entry != null; entry = entry.next)
                if(entry.hash == i && entry.match(s, s1))
                {
                    Node node1 = entry.value;
                    entry.value = node;
                    return node1;
                }

            int k = table.length;
            if(count++ >= k * 3 >>> 2)
            {
                rehash();
                j = i % table.length;
            }
            Entry entry1 = new Entry(i, s, s1, node, table[j]);
            table[j] = entry1;
            return null;
        }

        protected Node remove(String s, String s1)
        {
            int i = hashCode(s, s1) & 0x7fffffff;
            int j = i % table.length;
            Entry entry = null;
            for(Entry entry1 = table[j]; entry1 != null; entry1 = entry1.next)
            {
                if(entry1.hash == i && entry1.match(s, s1))
                {
                    Node node = entry1.value;
                    if(entry == null)
                        table[j] = entry1.next;
                    else
                        entry.next = entry1.next;
                    count--;
                    return node;
                }
                entry = entry1;
            }

            return null;
        }

        protected void rehash()
        {
            Entry aentry[] = table;
            table = new Entry[aentry.length * 2 + 1];
            for(int i = aentry.length - 1; i >= 0; i--)
            {
                for(Entry entry = aentry[i]; entry != null;)
                {
                    Entry entry1 = entry;
                    entry = entry.next;
                    int j = entry1.hash % table.length;
                    entry1.next = table[j];
                    table[j] = entry1;
                }

            }

        }

        protected int hashCode(String s, String s1)
        {
            int i = s != null ? s.hashCode() : 0;
            return i ^ s1.hashCode();
        }

        protected static final int INITIAL_CAPACITY = 3;
        protected Entry table[];
        protected int count;

        public NamedNodeHashMap()
        {
            table = new Entry[3];
        }
    }


    protected AbstractElement()
    {
    }

    protected AbstractElement(String s, AbstractDocument abstractdocument)
    {
        ownerDocument = abstractdocument;
        if(!DOMUtilities.isValidName(s))
            throw createDOMException((short)5, "xml.name", new Object[] {
                s
            });
        else
            return;
    }

    public short getNodeType()
    {
        return 1;
    }

    public boolean hasAttributes()
    {
        return attributes != null && attributes.getLength() != 0;
    }

    public NamedNodeMap getAttributes()
    {
        return attributes != null ? attributes : (attributes = createAttributes());
    }

    public String getTagName()
    {
        return getNodeName();
    }

    public boolean hasAttribute(String s)
    {
        return attributes != null && attributes.getNamedItem(s) != null;
    }

    public String getAttribute(String s)
    {
        if(attributes == null)
        {
            return "";
        } else
        {
            Attr attr = (Attr)attributes.getNamedItem(s);
            return attr != null ? attr.getValue() : "";
        }
    }

    public void setAttribute(String s, String s1)
        throws DOMException
    {
        if(attributes == null)
            attributes = createAttributes();
        Attr attr = getAttributeNode(s);
        if(attr == null)
        {
            attr = getOwnerDocument().createAttribute(s);
            attr.setValue(s1);
            attributes.setNamedItem(attr);
        } else
        {
            attr.setValue(s1);
        }
    }

    public void removeAttribute(String s)
        throws DOMException
    {
        if(!hasAttribute(s))
        {
            return;
        } else
        {
            attributes.removeNamedItem(s);
            return;
        }
    }

    public Attr getAttributeNode(String s)
    {
        if(attributes == null)
            return null;
        else
            return (Attr)attributes.getNamedItem(s);
    }

    public Attr setAttributeNode(Attr attr)
        throws DOMException
    {
        if(attr == null)
            return null;
        if(attributes == null)
            attributes = createAttributes();
        return (Attr)attributes.setNamedItemNS(attr);
    }

    public Attr removeAttributeNode(Attr attr)
        throws DOMException
    {
        if(attr == null)
            return null;
        if(attributes == null)
        {
            throw createDOMException((short)8, "attribute.missing", new Object[] {
                attr.getName()
            });
        } else
        {
            String s = attr.getNamespaceURI();
            return (Attr)attributes.removeNamedItemNS(s, s != null ? attr.getLocalName() : attr.getNodeName());
        }
    }

    public void normalize()
    {
        super.normalize();
        if(attributes != null)
        {
            NamedNodeMap namednodemap = getAttributes();
            for(int i = namednodemap.getLength() - 1; i >= 0; i--)
                namednodemap.item(i).normalize();

        }
    }

    public boolean hasAttributeNS(String s, String s1)
    {
        return attributes != null && attributes.getNamedItemNS(s, s1) != null;
    }

    public String getAttributeNS(String s, String s1)
    {
        if(attributes == null)
        {
            return "";
        } else
        {
            Attr attr = (Attr)attributes.getNamedItemNS(s, s1);
            return attr != null ? attr.getValue() : "";
        }
    }

    public void setAttributeNS(String s, String s1, String s2)
        throws DOMException
    {
        if(attributes == null)
            attributes = createAttributes();
        Attr attr = getAttributeNodeNS(s, s1);
        if(attr == null)
        {
            attr = getOwnerDocument().createAttributeNS(s, s1);
            attr.setValue(s2);
            attributes.setNamedItemNS(attr);
        } else
        {
            attr.setValue(s2);
        }
    }

    public void removeAttributeNS(String s, String s1)
        throws DOMException
    {
        if(!hasAttributeNS(s, s1))
        {
            return;
        } else
        {
            attributes.removeNamedItemNS(s, s1);
            return;
        }
    }

    public Attr getAttributeNodeNS(String s, String s1)
    {
        if(attributes == null)
            return null;
        else
            return (Attr)attributes.getNamedItemNS(s, s1);
    }

    public Attr setAttributeNodeNS(Attr attr)
        throws DOMException
    {
        if(attr == null)
            return null;
        if(attributes == null)
            attributes = createAttributes();
        return (Attr)attributes.setNamedItemNS(attr);
    }

    protected void nodeAdded(Node node)
    {
        invalidateElementsByTagName(node);
    }

    protected void nodeToBeRemoved(Node node)
    {
        invalidateElementsByTagName(node);
    }

    private void invalidateElementsByTagName(Node node)
    {
        if(node.getNodeType() != 1)
            return;
        AbstractDocument abstractdocument = getCurrentDocument();
        String s = node.getNamespaceURI();
        String s1 = node.getNodeName();
        String s2 = s != null ? node.getLocalName() : node.getNodeName();
        Object obj = this;
        do
        {
            if(obj == null)
                break;
            switch(((Node) (obj)).getNodeType())
            {
            case 1: // '\001'
            case 9: // '\t'
                AbstractParentNode.ElementsByTagName elementsbytagname = abstractdocument.getElementsByTagName(((Node) (obj)), s1);
                if(elementsbytagname != null)
                    elementsbytagname.invalidate();
                elementsbytagname = abstractdocument.getElementsByTagName(((Node) (obj)), "*");
                if(elementsbytagname != null)
                    elementsbytagname.invalidate();
                AbstractParentNode.ElementsByTagNameNS elementsbytagnamens = abstractdocument.getElementsByTagNameNS(((Node) (obj)), s, s2);
                if(elementsbytagnamens != null)
                    elementsbytagnamens.invalidate();
                elementsbytagnamens = abstractdocument.getElementsByTagNameNS(((Node) (obj)), "*", s2);
                if(elementsbytagnamens != null)
                    elementsbytagnamens.invalidate();
                elementsbytagnamens = abstractdocument.getElementsByTagNameNS(((Node) (obj)), s, "*");
                if(elementsbytagnamens != null)
                    elementsbytagnamens.invalidate();
                elementsbytagnamens = abstractdocument.getElementsByTagNameNS(((Node) (obj)), "*", "*");
                if(elementsbytagnamens != null)
                    elementsbytagnamens.invalidate();
                break;
            }
            obj = ((Node) (obj)).getParentNode();
        } while(true);
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
            invalidateElementsByTagName(node1);

    }

    protected NamedNodeMap createAttributes()
    {
        return new NamedNodeHashMap();
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractElement abstractelement = (AbstractElement)node;
        if(attributes != null)
        {
            NamedNodeMap namednodemap = attributes;
            for(int i = namednodemap.getLength() - 1; i >= 0; i--)
            {
                AbstractAttr abstractattr = (AbstractAttr)namednodemap.item(i);
                if(!abstractattr.getSpecified())
                    continue;
                Attr attr = (Attr)abstractattr.deepExport(abstractattr.cloneNode(false), abstractdocument);
                if(abstractattr instanceof AbstractAttrNS)
                    abstractelement.setAttributeNodeNS(attr);
                else
                    abstractelement.setAttributeNode(attr);
            }

        }
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractElement abstractelement = (AbstractElement)node;
        if(attributes != null)
        {
            NamedNodeMap namednodemap = attributes;
            for(int i = namednodemap.getLength() - 1; i >= 0; i--)
            {
                AbstractAttr abstractattr = (AbstractAttr)namednodemap.item(i);
                if(!abstractattr.getSpecified())
                    continue;
                Attr attr = (Attr)abstractattr.deepExport(abstractattr.cloneNode(false), abstractdocument);
                if(abstractattr instanceof AbstractAttrNS)
                    abstractelement.setAttributeNodeNS(attr);
                else
                    abstractelement.setAttributeNode(attr);
            }

        }
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractElement abstractelement = (AbstractElement)node;
        if(attributes != null)
        {
            NamedNodeMap namednodemap = attributes;
            for(int i = namednodemap.getLength() - 1; i >= 0; i--)
            {
                AbstractAttr abstractattr = (AbstractAttr)namednodemap.item(i).cloneNode(true);
                if(abstractattr instanceof AbstractAttrNS)
                    abstractelement.setAttributeNodeNS(abstractattr);
                else
                    abstractelement.setAttributeNode(abstractattr);
            }

        }
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractElement abstractelement = (AbstractElement)node;
        if(attributes != null)
        {
            NamedNodeMap namednodemap = attributes;
            for(int i = namednodemap.getLength() - 1; i >= 0; i--)
            {
                AbstractAttr abstractattr = (AbstractAttr)namednodemap.item(i).cloneNode(true);
                if(abstractattr instanceof AbstractAttrNS)
                    abstractelement.setAttributeNodeNS(abstractattr);
                else
                    abstractelement.setAttributeNode(abstractattr);
            }

        }
        return node;
    }

    protected void checkChildType(Node node, boolean flag)
    {
        switch(node.getNodeType())
        {
        case 2: // '\002'
        case 6: // '\006'
        case 9: // '\t'
        case 10: // '\n'
        default:
            throw createDOMException((short)3, "child.type", new Object[] {
                new Integer(getNodeType()), getNodeName(), new Integer(node.getNodeType()), node.getNodeName()
            });

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        case 8: // '\b'
        case 11: // '\013'
            return;
        }
    }

    public void fireDOMAttrModifiedEvent(String s, Attr attr, String s1, String s2, short word0)
    {
        switch(word0)
        {
        case 2: // '\002'
            if(((AbstractAttr)attr).isId())
                ownerDocument.addIdEntry(this, s2);
            attrAdded(attr, s2);
            break;

        case 1: // '\001'
            if(((AbstractAttr)attr).isId())
                ownerDocument.updateIdEntry(this, s1, s2);
            attrModified(attr, s1, s2);
            break;

        default:
            if(((AbstractAttr)attr).isId())
                ownerDocument.removeIdEntry(this, s1);
            attrRemoved(attr, s1);
            break;
        }
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled() && !s1.equals(s2))
        {
            AbstractDocument abstractdocument1 = abstractdocument;
            MutationEvent mutationevent = (MutationEvent)abstractdocument1.createEvent("MutationEvents");
            mutationevent.initMutationEvent("DOMAttrModified", true, false, attr, s1, s2, s, word0);
            dispatchEvent(mutationevent);
        }
    }

    protected void attrAdded(Attr attr, String s)
    {
    }

    protected void attrModified(Attr attr, String s, String s1)
    {
    }

    protected void attrRemoved(Attr attr, String s)
    {
    }

    protected NamedNodeMap attributes;
}
