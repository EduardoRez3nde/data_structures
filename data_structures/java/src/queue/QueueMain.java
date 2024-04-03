package queue;

import queue.queue_array.DynamicArrayQueue;
import queue.queue_linked_list.Queue;
import queue.queue_linked_list.QueueLinkedList;

public class QueueMain {

    public static void main(String[] args) {

        QueueLinkedList<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.forEach(elem -> System.out.printf("%d ", elem));
    }
}

