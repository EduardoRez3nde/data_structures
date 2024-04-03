package singly_linked_list;

public class SinglyLinkedList<T extends Comparable<T>> implements LinkedList<T> {

    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public int compareTo(Node<T> o) {
            return this.data.compareTo(o.data);
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    public T last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (isEmpty()) tail = head;
        size++;
        // Time = O(1)
    }

    public void addLast(T element) {

        Node<T> newest = new Node<>(element, null);

        if (isEmpty())
            head = newest;
        else
            tail.next = newest;
        tail = newest;
        size++;
        // Time = O(1)
    }

    public T removeFirst() {

        if (isEmpty())
            return null;

        T temp = head.data;
        head = head.next;
        size--;

        if (size == 0)
            tail = head;

        return temp;
        // Time = O(1)
    }

    public T get(int index) {

        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            if (i == index)
                return current.getData();
            current = current.next;
        }
        return null;
        // Melhor Caso = O(1)
        // Pior Caso = O(n)
    }

    public T removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("List is Empty");

        T temp = tail.data;

        if (size == 1) {
            head = head.next;
            tail = head;
        }
        else {
            Node<T> cur = head;
            int i = 1;

            while (i < size - 1 && cur != null) {
                cur = cur.next;
                i++;
            }
            if (cur != null) {
                cur.next = tail.next;
                tail = cur;
            }
        }
        size--;
        return temp;
        // Time = O(n)
    }

    public void insert(int index, T element) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index Invalid");

        if (index == 0) addFirst(element);
            // Time = O(1)

        else if (index == size) addLast(element);
            // Time = O(1)
        else {
            int i = 1;
            Node<T> newest = new Node<>(element, null);
            Node<T> current = head;

            while (i < index) {
                current = current.next;
                i++;
            }
            newest.next = current.next;
            current.next = newest;
            size++;
            // Time = O(n)
        }
    }

    public void remove(int index) {

        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index Invalid");

        if (index == 0 && !isEmpty()) head = head.next;

        else {
            int i = 1;
            Node<T> prev = head;
            Node<T> current = head.next;

            while (i < index) {
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;

            if (index == size - 1) tail = prev;
        }
        size--;
    }

    public void reverse() {

        if (isEmpty()) return;

        Node<T> newHead = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
        }
        tail = head;
        head = newHead;

        if (tail != null) tail.next = null;
    }
}

