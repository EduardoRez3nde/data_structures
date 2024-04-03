package bag;

import stack.stack_linked_list.StackLinkedList;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>, BagLinkedList<T> {

    private static class Node<T> {

        private T element;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.element = data;
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

    private Node<T> head = null;
    private int size = 0;

    public Bag() {}

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void push(T element) {

        Node<T> newest = new Node<>(element, null);

        if (isEmpty())
            head = newest;

        else {
            newest.next = head;
            head = newest;
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T answer = current.element;
            current = current.next;
            return answer;
        }
    }
}
