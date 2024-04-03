package array;

public interface ArrayList<T> extends Iterable<T> {

    public int size();

    public int getCapacity();

    public boolean isEmpty();

    public T get(int index);

    public void push(T element);

    public void remove(T element);

    public void insert(int index, T element);

    public void prepend(T element);
    public T pop();

    public void delete(int index);

    public int find(T element);

}
