package queue.doubly_ended_queue;

public interface DoublyEndedQueue<T> {

    public int size();

    public boolean isEmpty();

    public T first();

    public T last();

    public void addFirst(T element);

    public void addLast(T element);

    public T removeFirst();

    public T removeLast();
}
