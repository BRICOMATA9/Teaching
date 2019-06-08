// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import org.apache.batik.dom.events.DocumentEventSupport;
import org.apache.batik.dom.traversal.TraversalSupport;
import org.apache.batik.i18n.Localizable;
import org.apache.batik.i18n.LocalizableSupport;
import org.apache.batik.util.CleanerThread;
import org.apache.batik.util.SoftDoublyIndexedTable;
import org.w3c.dom.*;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.traversal.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentNode, GenericDocumentType, ExtendedNode, AbstractAttr, 
//            AbstractDOMImplementation

public abstract class AbstractDocument extends AbstractParentNode
    implements Document, DocumentEvent, DocumentTraversal, Localizable
{
    protected class IdSoftRef extends org.apache.batik.util.CleanerThread.SoftReferenceCleared
    {

        public void setList(List list1)
        {
            list = list1;
        }

        public void cleared()
        {
            if(elementsById == null)
                return;
            synchronized(elementsById)
            {
                if(list != null)
                {
                    list.remove(this);
                } else
                {
                    Object obj = elementsById.remove(id);
                    if(obj != this)
                        elementsById.put(id, obj);
                }
            }
        }

        String id;
        List list;

        IdSoftRef(Object obj, String s)
        {
            super(obj);
            id = s;
        }

        IdSoftRef(Object obj, String s, List list1)
        {
            super(obj);
            id = s;
            list = list1;
        }
    }


    protected AbstractDocument()
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
    }

    public AbstractDocument(DocumentType documenttype, DOMImplementation domimplementation)
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
        implementation = domimplementation;
        if(documenttype != null)
        {
            if(documenttype instanceof GenericDocumentType)
            {
                GenericDocumentType genericdocumenttype = (GenericDocumentType)documenttype;
                if(genericdocumenttype.getOwnerDocument() == null)
                    genericdocumenttype.setOwnerDocument(this);
            }
            appendChild(documenttype);
        }
    }

    public void setLocale(Locale locale)
    {
        localizableSupport.setLocale(locale);
    }

    public Locale getLocale()
    {
        return localizableSupport.getLocale();
    }

    public String formatMessage(String s, Object aobj[])
        throws MissingResourceException
    {
        return localizableSupport.formatMessage(s, aobj);
    }

    public boolean getEventsEnabled()
    {
        return eventsEnabled;
    }

    public void setEventsEnabled(boolean flag)
    {
        eventsEnabled = flag;
    }

    public String getNodeName()
    {
        return "#document";
    }

    public short getNodeType()
    {
        return 9;
    }

    public DocumentType getDoctype()
    {
        for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 10)
                return (DocumentType)node;

        return null;
    }

    public void setDoctype(DocumentType documenttype)
    {
        if(documenttype != null)
        {
            appendChild(documenttype);
            ((ExtendedNode)documenttype).setReadonly(true);
        }
    }

    public DOMImplementation getImplementation()
    {
        return implementation;
    }

    public Element getDocumentElement()
    {
        for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1)
                return (Element)node;

        return null;
    }

    public Node importNode(Node node, boolean flag)
        throws DOMException
    {
        return importNode(node, flag, false);
    }

    public Node importNode(Node node, boolean flag, boolean flag1)
    {
        Object obj;
        switch(node.getNodeType())
        {
        case 1: // '\001'
            Element element = createElementNS(node.getNamespaceURI(), node.getNodeName());
            obj = element;
            if(node.hasAttributes())
            {
                NamedNodeMap namednodemap = node.getAttributes();
                int i = namednodemap.getLength();
                for(int j = 0; j < i; j++)
                {
                    Attr attr = (Attr)namednodemap.item(j);
                    if(attr.getSpecified())
                    {
                        AbstractAttr abstractattr = (AbstractAttr)importNode(((Node) (attr)), true);
                        if(flag1 && abstractattr.isId())
                            abstractattr.setIsId(false);
                        element.setAttributeNodeNS(abstractattr);
                    }
                }

            }
            break;

        case 2: // '\002'
            obj = createAttributeNS(node.getNamespaceURI(), node.getNodeName());
            break;

        case 3: // '\003'
            obj = createTextNode(node.getNodeValue());
            flag = false;
            break;

        case 4: // '\004'
            obj = createCDATASection(node.getNodeValue());
            flag = false;
            break;

        case 5: // '\005'
            obj = createEntityReference(node.getNodeName());
            break;

        case 7: // '\007'
            obj = createProcessingInstruction(node.getNodeName(), node.getNodeValue());
            flag = false;
            break;

        case 8: // '\b'
            obj = createComment(node.getNodeValue());
            flag = false;
            break;

        case 11: // '\013'
            obj = createDocumentFragment();
            break;

        case 6: // '\006'
        case 9: // '\t'
        case 10: // '\n'
        default:
            throw createDOMException((short)9, "import.node", new Object[0]);
        }
        if(flag)
        {
            for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
                ((Node) (obj)).appendChild(importNode(node1, true));

        }
        return ((Node) (obj));
    }

    public Node cloneNode(boolean flag)
    {
        Document document = (Document)newNode();
        copyInto(document);
        if(flag)
        {
            for(Node node = getFirstChild(); node != null; node = node.getNextSibling())
                document.appendChild(document.importNode(node, flag));

        }
        return document;
    }

    public abstract boolean isId(Attr attr);

    public Element getElementById(String s)
    {
        return getChildElementById(getDocumentElement(), s);
    }

    public Element getChildElementById(Node node, String s)
    {
        if(s == null || s.length() == 0)
            return null;
        if(elementsById == null)
            return null;
        Node node1 = getRoot(node);
        Object obj = elementsById.get(s);
        if(obj == null)
            return null;
        if(obj instanceof IdSoftRef)
        {
            obj = ((IdSoftRef)obj).get();
            if(obj == null)
            {
                elementsById.remove(s);
                return null;
            }
            Element element = (Element)obj;
            if(getRoot(element) == node1)
                return element;
            else
                return null;
        }
        List list = (List)obj;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            IdSoftRef idsoftref = (IdSoftRef)iterator.next();
            Object obj1 = idsoftref.get();
            if(obj1 == null)
            {
                iterator.remove();
            } else
            {
                Element element1 = (Element)obj1;
                if(getRoot(element1) == node1)
                    return element1;
            }
        }

        return null;
    }

    protected Node getRoot(Node node)
    {
        Node node1 = node;
        for(; node != null; node = node.getParentNode())
            node1 = node;

        return node1;
    }

    public void removeIdEntry(Element element, String s)
    {
        Object obj;
label0:
        {
            if(s == null)
                return;
            if(elementsById == null)
                return;
            synchronized(elementsById)
            {
                obj = elementsById.get(s);
                if(obj != null)
                    break label0;
            }
            return;
        }
        if(!(obj instanceof IdSoftRef))
            break MISSING_BLOCK_LABEL_62;
        elementsById.remove(s);
        map;
        JVM INSTR monitorexit ;
        return;
        List list;
label1:
        {
            list = (List)obj;
            Iterator iterator;
label2:
            do
            {
                for(iterator = list.iterator(); iterator.hasNext(); iterator.remove())
                {
                    IdSoftRef idsoftref = (IdSoftRef)iterator.next();
                    obj = idsoftref.get();
                    if(obj != null)
                        continue label2;
                }

                break label1;
            } while(element != obj);
            iterator.remove();
        }
        if(list.size() == 0)
            elementsById.remove(s);
        map;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
    }

    public void addIdEntry(Element element, String s)
    {
        Object obj;
label0:
        {
            if(s == null)
                return;
            if(elementsById == null)
            {
                HashMap hashmap = new HashMap();
                synchronized(hashmap)
                {
                    elementsById = hashmap;
                    elementsById.put(s, new IdSoftRef(element, s));
                }
                return;
            }
            synchronized(elementsById)
            {
                obj = elementsById.get(s);
                if(obj != null)
                    break label0;
                elementsById.put(s, new IdSoftRef(element, s));
            }
            return;
        }
        IdSoftRef idsoftref;
        if(!(obj instanceof IdSoftRef))
            break MISSING_BLOCK_LABEL_228;
        idsoftref = (IdSoftRef)obj;
        Object obj1 = idsoftref.get();
        if(obj1 != null)
            break MISSING_BLOCK_LABEL_165;
        elementsById.put(s, new IdSoftRef(element, s));
        map;
        JVM INSTR monitorexit ;
        return;
        ArrayList arraylist = new ArrayList(4);
        idsoftref.setList(arraylist);
        arraylist.add(idsoftref);
        arraylist.add(new IdSoftRef(element, s, arraylist));
        elementsById.put(s, arraylist);
        map;
        JVM INSTR monitorexit ;
        return;
        List list = (List)obj;
        list.add(new IdSoftRef(element, s, list));
        map;
        JVM INSTR monitorexit ;
          goto _L1
        exception1;
        throw exception1;
_L1:
    }

    public void updateIdEntry(Element element, String s, String s1)
    {
        if(s == s1 || s != null && s.equals(s1))
        {
            return;
        } else
        {
            removeIdEntry(element, s);
            addIdEntry(element, s1);
            return;
        }
    }

    public AbstractParentNode.ElementsByTagName getElementsByTagName(Node node, String s)
    {
        if(elementsByTagNames == null)
            return null;
        SoftDoublyIndexedTable softdoublyindexedtable = (SoftDoublyIndexedTable)elementsByTagNames.get(node);
        if(softdoublyindexedtable == null)
            return null;
        else
            return (AbstractParentNode.ElementsByTagName)softdoublyindexedtable.get(null, s);
    }

    public void putElementsByTagName(Node node, String s, AbstractParentNode.ElementsByTagName elementsbytagname)
    {
        if(elementsByTagNames == null)
            elementsByTagNames = new WeakHashMap(11);
        SoftDoublyIndexedTable softdoublyindexedtable = (SoftDoublyIndexedTable)elementsByTagNames.get(node);
        if(softdoublyindexedtable == null)
            elementsByTagNames.put(node, softdoublyindexedtable = new SoftDoublyIndexedTable());
        softdoublyindexedtable.put(null, s, elementsbytagname);
    }

    public AbstractParentNode.ElementsByTagNameNS getElementsByTagNameNS(Node node, String s, String s1)
    {
        if(elementsByTagNamesNS == null)
            return null;
        SoftDoublyIndexedTable softdoublyindexedtable = (SoftDoublyIndexedTable)elementsByTagNamesNS.get(node);
        if(softdoublyindexedtable == null)
            return null;
        else
            return (AbstractParentNode.ElementsByTagNameNS)softdoublyindexedtable.get(s, s1);
    }

    public void putElementsByTagNameNS(Node node, String s, String s1, AbstractParentNode.ElementsByTagNameNS elementsbytagnamens)
    {
        if(elementsByTagNamesNS == null)
            elementsByTagNamesNS = new WeakHashMap(11);
        SoftDoublyIndexedTable softdoublyindexedtable = (SoftDoublyIndexedTable)elementsByTagNamesNS.get(node);
        if(softdoublyindexedtable == null)
            elementsByTagNamesNS.put(node, softdoublyindexedtable = new SoftDoublyIndexedTable());
        softdoublyindexedtable.put(s, s1, elementsbytagnamens);
    }

    public Event createEvent(String s)
        throws DOMException
    {
        if(documentEventSupport == null)
            documentEventSupport = ((AbstractDOMImplementation)implementation).createDocumentEventSupport();
        return documentEventSupport.createEvent(s);
    }

    public NodeIterator createNodeIterator(Node node, int i, NodeFilter nodefilter, boolean flag)
        throws DOMException
    {
        if(traversalSupport == null)
            traversalSupport = new TraversalSupport();
        return traversalSupport.createNodeIterator(this, node, i, nodefilter, flag);
    }

    public TreeWalker createTreeWalker(Node node, int i, NodeFilter nodefilter, boolean flag)
        throws DOMException
    {
        return TraversalSupport.createTreeWalker(this, node, i, nodefilter, flag);
    }

    public void detachNodeIterator(NodeIterator nodeiterator)
    {
        traversalSupport.detachNodeIterator(nodeiterator);
    }

    public void nodeToBeRemoved(Node node)
    {
        if(traversalSupport != null)
            traversalSupport.nodeToBeRemoved(node);
    }

    protected AbstractDocument getCurrentDocument()
    {
        return this;
    }

    protected Node export(Node node, Document document)
    {
        throw createDOMException((short)9, "import.document", new Object[0]);
    }

    protected Node deepExport(Node node, Document document)
    {
        throw createDOMException((short)9, "import.document", new Object[0]);
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractDocument abstractdocument = (AbstractDocument)node;
        abstractdocument.implementation = implementation;
        abstractdocument.localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractDocument abstractdocument = (AbstractDocument)node;
        abstractdocument.implementation = implementation;
        abstractdocument.localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
        return node;
    }

    protected void checkChildType(Node node, boolean flag)
    {
        short word0 = node.getNodeType();
        switch(word0)
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 9: // '\t'
        default:
            throw createDOMException((short)3, "child.type", new Object[] {
                new Integer(getNodeType()), getNodeName(), new Integer(word0), node.getNodeName()
            });

        case 1: // '\001'
        case 7: // '\007'
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
            break;
        }
        if(!flag && word0 == 1 && getDocumentElement() != null || word0 == 10 && getDoctype() != null)
            throw createDOMException((short)3, "child.type", new Object[] {
                new Integer(getNodeType()), getNodeName(), new Integer(word0), node.getNodeName()
            });
        else
            return;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(implementation.getClass().getName());
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
        Class class1 = Class.forName((String)objectinputstream.readObject());
        try
        {
            Method method = class1.getMethod("getDOMImplementation", null);
            implementation = (DOMImplementation)method.invoke(null, null);
        }
        catch(Exception exception)
        {
            try
            {
                implementation = (DOMImplementation)class1.newInstance();
            }
            catch(Exception exception1) { }
        }
    }

    protected static final String RESOURCES = "org.apache.batik.dom.resources.Messages";
    protected transient LocalizableSupport localizableSupport;
    protected transient DOMImplementation implementation;
    protected transient TraversalSupport traversalSupport;
    protected transient DocumentEventSupport documentEventSupport;
    protected transient boolean eventsEnabled;
    protected transient WeakHashMap elementsByTagNames;
    protected transient WeakHashMap elementsByTagNamesNS;
    protected transient Map elementsById;
}
