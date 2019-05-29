package CM4;

import java.util.EmptyStackException;

public class MyStack<E> {
    protected Node<E> head;

    public MyStack() {
        this.head = null;
    }

    public synchronized void push( E e ) {
        Node<E> nnode = new Node<E>( e, head );
        head = nnode;
    }

    public synchronized Node<E> pop() {
        if ( head == null )
            throw new EmptyStackException();
        Node<E> element = head;
        head = head.next;
        return element;
    }

    public synchronized boolean isEmpty() {
        return head == null;
    }
}
