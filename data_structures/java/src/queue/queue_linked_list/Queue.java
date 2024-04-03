package queue.queue_linked_list;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>, QueueLinkedList<T> {

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
    private Node<T> tail = null;
    private int size = 0;

    public Queue() {}

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public T first() {
        if (isEmpty()) return null;
        return head.element;
    }

    public void enqueue(T element) {

        Node<T> newest = new Node<>(element, null);

        if (isEmpty()) {
            tail = newest;
            head = tail;
        }
        else {
            tail.next = newest;
            tail = newest;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T answer = head.element;
        head = head.next;
        size--;
        return answer;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

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

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
