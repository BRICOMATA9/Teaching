// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;


public class DoublyLinkedList
{
    public static class Node
    {

        public final Node getNext()
        {
            return next;
        }

        public final Node getPrev()
        {
            return prev;
        }

        protected final void setNext(Node node)
        {
            next = node;
        }

        protected final void setPrev(Node node)
        {
            prev = node;
        }

        protected final void unlink()
        {
            if(getNext() != null)
                getNext().setPrev(getPrev());
            if(getPrev() != null)
                getPrev().setNext(getNext());
            setNext(null);
            setPrev(null);
        }

        protected final void insertBefore(Node node)
        {
            if(this == node)
                return;
            if(getPrev() != null)
                unlink();
            if(node == null)
            {
                setNext(this);
                setPrev(this);
            } else
            {
                setNext(node);
                setPrev(node.getPrev());
                node.setPrev(this);
                if(getPrev() != null)
                    getPrev().setNext(this);
            }
        }

        private Node next;
        private Node prev;

        public Node()
        {
            next = null;
            prev = null;
        }
    }


    public DoublyLinkedList()
    {
        head = null;
        size = 0;
    }

    public synchronized int getSize()
    {
        return size;
    }

    public synchronized void empty()
    {
        while(size > 0) 
            pop();
    }

    public Node getHead()
    {
        return head;
    }

    public Node getTail()
    {
        return head.getPrev();
    }

    public void touch(Node node)
    {
        if(node == null)
        {
            return;
        } else
        {
            node.insertBefore(head);
            head = node;
            return;
        }
    }

    public void add(int i, Node node)
    {
        if(node == null)
            return;
        if(i == 0)
        {
            node.insertBefore(head);
            head = node;
        } else
        if(i == size)
        {
            node.insertBefore(head);
        } else
        {
            Node node1 = head;
            for(; i != 0; i--)
                node1 = node1.getNext();

            node.insertBefore(node1);
        }
        size++;
    }

    public void add(Node node)
    {
        if(node == null)
        {
            return;
        } else
        {
            node.insertBefore(head);
            head = node;
            size++;
            return;
        }
    }

    public void remove(Node node)
    {
        if(node == null)
            return;
        if(node == head)
            if(head.getNext() == head)
                head = null;
            else
                head = head.getNext();
        node.unlink();
        size--;
    }

    public Node pop()
    {
        if(head == null)
        {
            return null;
        } else
        {
            Node node = head;
            remove(node);
            return node;
        }
    }

    public Node unpush()
    {
        if(head == null)
        {
            return null;
        } else
        {
            Node node = getTail();
            remove(node);
            return node;
        }
    }

    public void push(Node node)
    {
        node.insertBefore(head);
        if(head == null)
            head = node;
        size++;
    }

    public void unpop(Node node)
    {
        node.insertBefore(head);
        head = node;
        size++;
    }

    private Node head;
    private int size;
}
