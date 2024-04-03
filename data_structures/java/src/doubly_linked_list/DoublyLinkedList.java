package doubly_linked_list;

public class DoublyLinkedList<T> {

    private static class Node<T> {

        private Node<T> previous;
        private T element;
        private Node<T> next;

        public Node(Node<T> prev, T elem, Node<T> next) {
            this.previous = prev;
            this.element = elem;
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
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
    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(header, null, null);
        header.next = trailer;
    }

    private void addBetween(Node<T> predecessor, T element, Node<T> successor) { // Time = O(1)
        Node<T> newest = new Node<>(predecessor, element, successor);
        predecessor.next = newest;
        successor.previous = newest;
        size++;
    }

    private T remove(Node<T> node) {                    // Time = O(1)
        Node<T> predecessor = node.previous;
        Node<T> successor = node.next;
        predecessor.next = successor;
        successor.next = predecessor;
        size--;
        return node.element;
    }

    public int size() { return size; }                  // Time = O(1)

    public boolean isEmpty() { return size == 0; }      // Time = O(1)

    public T first() {                                  // Time = O(1)
        if (isEmpty()) return null;
        return header.next.element;
    }

    public T last() {                                   // Time = O(1)
        if (isEmpty()) return null;
        return trailer.previous.element;
    }

    public void addFirst(T element) {                   // Time = O(1)
        addBetween(header, element, header.next);
    }

    public void addLast(T element) {                    // Time = O(1)
        addBetween(trailer.previous, element, trailer);
    }

    public T removeFirst() {                            // Time = O(1)
        if (isEmpty()) return null;
        return remove(header.next);
    }

    public T removeLast() {                             // Time = O(1)
        if (isEmpty()) return null;
        return remove(trailer.next);
    }
}
