package queue.queue_array;

import queue.queue_linked_list.QueueLinkedList;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArrayQueue<T> implements Iterable<T>, QueueLinkedList<T> {

    private T []array;
    private int size;
    private int capacity = 16;
    private int top = 0;

    public DynamicArrayQueue() {
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T element) {

        if (size == capacity)
            resize(2 * capacity);

        int avail = (top + size) % array.length;
        array[avail] = element;
        size++;
    }

    public T dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Array is empty");

        top = (top + 1) % array.length;
        T temp = array[--size];
        array[size] = null;

        if (size > 0 && size == array.length / 4)
            resize(array.length / 2);

        return temp;
    }

    public T first() {
        if (isEmpty()) return null;
        return array[top];
    }

    private void resize(int newSize) {

        T[] newArray = (T[]) new Object[newSize];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newSize;
        array = newArray;
        newArray = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return array[--i];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
