package bag;

public interface BagLinkedList<T> extends Iterable<T> {

    public boolean isEmpty();

    public void push(T element);

    public int size();
}
