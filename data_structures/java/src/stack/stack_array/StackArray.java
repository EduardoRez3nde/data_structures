package stack.stack_array;

public interface StackArray<T> extends Iterable<T> {

    void push(T element);

    T pop();

    int size();

    boolean isEmpty();

    int getCapacity();

    T top();
}
