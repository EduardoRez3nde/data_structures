package queue.queue_linked_list;

public interface QueueLinkedList<T> extends Iterable<T>{

    int size();

    boolean isEmpty();

    T first();

    void enqueue(T element);

    T dequeue();
}
