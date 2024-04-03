package singly_linked_list;

public interface LinkedList<T> {

    public int size();

    public boolean isEmpty();

    public T first();

    public T last();

    public void addLast(T element);
    public T removeFirst();

    public T get(int index);

    public T removeLast();
    public void insert(int index, T element);

    public void remove(int index);

    public void reverse();
}
