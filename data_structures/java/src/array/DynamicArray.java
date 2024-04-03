package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>, ArrayList<T> {

    private T []array;
    private int size;
    private int capacity = 16;

    public DynamicArray() {
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

    public T get(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("index out of range");
        return array[index];
    }

    public void push(T element) {

        if (size == capacity)
            resize(2 * capacity);

        array[size] = element;
        size++;
    }

    public void remove(T element) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == element) {
                array[i] = array[size - 1];
                size--;
            }
        }
    }
    public void insert(int index, T element) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index out of range");

        if (size == capacity)
            resize(2 * capacity);

        for (int j = size - 1; j >= index; j--)
            array[j + 1] = array[j];

        array[index] = element;
        size++;
    }

    public void prepend(T element) {
        if (size == capacity)
            resize(2 * capacity);
        insert(0, element);
    }

    public T pop() {

        if (isEmpty())
            throw new IllegalArgumentException("Array is empty");

        T temp = array[--size];
        array[size] = null;

        if (size > 0 && size == array.length / 4)
            resize(array.length / 2);

        return temp;
    }

    public void delete(int index) {
         if (index < 0 || index > size)
             throw new IndexOutOfBoundsException("index out of range");
         for (int i = index; i < size - 1; i++)
             array[i] = array[i + 1];
         size--;
    }

    public int find(T element) {
        for (int i = 0; i < size - 1; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
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

        private int i = 0;
        private boolean removable;

        @Override
        public boolean hasNext() {return i < size;}

        @Override
        public T next() {
            if (i == size) throw new NoSuchElementException("No next element");
            removable = true;
            return array[i++];
        }

        @Override
        public void remove() throws IllegalStateException {
            if (!removable) throw new IllegalStateException("Nothing to remove");
            DynamicArray.this.delete(i - 1);
            i--;
            removable = false;
        }
    }
}
