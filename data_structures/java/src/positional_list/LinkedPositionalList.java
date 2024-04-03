package positional_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<T> implements PositionalList<T>, Iterable<T> {

    private static class Node<T> implements Position<T> {

        private Node<T> previous;
        private T element;
        private Node<T> next;

        public Node(Node<T> p, T e, Node<T> n) {
            previous = p;
            element = e;
            next = n;
        }

        public Node<T> getPrevious() {return previous;}

        public void setPrevious(Node<T> previous) {this.previous = previous;}

        public Node<T> getNext() {return next;}

        public void setNext(Node<T> next) {this.next = next;}

        public void setElement(T element) {this.element = element;}

        public T getElement() {
            if (next == null)
                throw new IllegalStateException("Position Invalid");
            return element;
        }
    }
    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(header, null, null);
        header.next = trailer;
    }

    private Node<T> validate(Position<T> p) {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Position Invalid");
        Node<T> node = (Node<T>) p;
        if (node.next == null)
            throw new IllegalArgumentException("p is Invalid");
        return node;
    }

    private Position<T> position(Node<T> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    private Position<T> addBetween(Node<T> predecessor, T element, Node<T> successor) {
        Node<T> newest = new Node<>(predecessor, element, successor);
        predecessor.next = newest;
        successor.previous = newest;
        size++;
        return newest;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    @Override
    public Position<T> first() {return position(header.next);}

    @Override
    public Position<T> last() {return position(trailer.previous);}

    @Override
    public Position<T> before(Position<T> p) throws IllegalStateException {
        Node<T> node = validate(p);
        return position(node.previous);
    }

    @Override
    public Position<T> after(Position<T> p) throws IllegalStateException {
        Node<T> node = validate(p);
        return position(node.next);
    }

    @Override
    public Position<T> addFirst(T element) {
        return addBetween(header, element, header.next);
    }

    @Override
    public Position<T> addLast(T element) {
        return addBetween(trailer.previous, element, trailer);
    }

    @Override
    public Position<T> addBefore(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(node.previous, element, node);
    }

    @Override
    public Position<T> addAfter(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(node, element, node.next);
    }

    @Override
    public T set(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T temp = node.element;
        node.element = element;
        return temp;
    }

    @Override
    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        Node<T> predecessor = node.previous;
        Node<T> successor = node.next;
        predecessor.next = successor;
        successor.previous = predecessor;
        size--;

        T temp = node.element;
        node.next = null;
        node.element = null;
        node.previous = null;
        return temp;
    }

    public static void insertionSort(PositionalList<Integer> list) {

        Position<Integer> marker = list.first();

        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();

            if (value > marker.getElement())
                marker = pivot;

            else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk);

                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }

    private class PositionIterator implements Iterator<Position<T>> {

        private Position<T> current = first();
        private Position<T> recent = null;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Position<T> next() throws NoSuchElementException {
            if (current == null) throw new NoSuchElementException("nothing left");
            recent = current;
            current = after(current);
            return recent;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionIterable implements Iterable<Position<T>> {
        @Override
        public Iterator<Position<T>> iterator() { return new PositionIterator(); }
    }

    public Iterable<Position<T>> positions() { return new PositionIterable(); }

    private class ElementPosition implements Iterator<T> {

        Iterator<Position<T>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() { return posIterator.hasNext(); }

        @Override
        public T next() { return posIterator.next().getElement(); }

        @Override
        public void remove() { posIterator.remove(); }
    }

    @Override
    public Iterator<T> iterator() { return new ElementPosition(); }
}
