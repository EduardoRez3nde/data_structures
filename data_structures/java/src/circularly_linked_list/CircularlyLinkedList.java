package circularly_linked_list;

public class CircularlyLinkedList<T> implements CircularlyLinkedL<T> {

    private static class Node<T> {

        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public T first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public T last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) tail = tail.getNext();
    }

    public void addFirst(T element) {

        if (isEmpty()) {
            tail = new Node<>(element, null);
            tail.setNext(tail);
        }
        else {
            Node<T> newest = new Node<>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    public T removeFirst() {

        if (isEmpty()) return null;

        Node<T> head = tail.getNext();
        T temp = head.getElement();

        if (head == tail) tail = null;
        else tail.setNext(head.getNext());

        head = null;
        size--;
        return temp;
    }
}
