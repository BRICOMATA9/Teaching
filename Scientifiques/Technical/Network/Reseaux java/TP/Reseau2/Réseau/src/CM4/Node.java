package CM4;

public class Node<E> {
    protected E       value;
    protected Node<E> next;

    public Node( E e, Node<E> next ) {
        this.value = e;
        this.next = next;
    }

    public void setNext( Node<E> e ) {
        this.next = e;
    }

    public Node<E> getNext() {
        return next;
    }

}
