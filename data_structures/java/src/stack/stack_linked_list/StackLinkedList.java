package stack.stack_linked_list;

public interface StackLinkedList<T> extends Iterable<T> {

    boolean isEmpty();

    void push(T element);

    T pop();

    T top();
}
