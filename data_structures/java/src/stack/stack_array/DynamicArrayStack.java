package stack.stack_array;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArrayStack<T> implements Iterable<T>, StackArray<T> {

    private T[] stack;
    private int size = 0;
    private int capacity = 16;

    public DynamicArrayStack() {
        stack = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize(int newCapacity) {

        T[] temp = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++)
            temp[i] = stack[i];

        capacity = newCapacity;
        stack = temp;
    }

    public void push(T item) {
        if (size == stack.length)
            resize(2 * stack.length);
        stack[size++] = item;
    }

    public T pop() {

        if (isEmpty())
            throw new IllegalArgumentException("Stack is Empty");

        T temp = stack[--size];
        stack[size] = null;

        if (size > 0 && size == stack.length / 4)
            resize(stack.length / 2);

        return temp;
    }

    public T top() {
        if (isEmpty()) return null;
        return stack[--size];
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return stack[--i];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
