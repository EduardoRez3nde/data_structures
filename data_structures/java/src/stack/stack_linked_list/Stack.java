package stack.stack_linked_list;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>, StackLinkedList<T> {

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

    public Stack() {}

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void push(T element) {
        head = new Node<>(element, head);
        size++;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T temp = head.element;
        head = head.next;
        size--;
        return temp;
    }

    public T top() {
        if (isEmpty()) return null;
        return head.element;
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
