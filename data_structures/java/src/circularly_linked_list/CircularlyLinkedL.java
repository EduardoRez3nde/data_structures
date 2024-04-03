package circularly_linked_list;

public interface CircularlyLinkedL<T> {

    public int size();

    public boolean isEmpty();

    public T first();

    public T last();

    public void rotate();

    public void addFirst(T element);

    public void addLast(T element);

    public T removeFirst();
}
