package positional_list;

public interface PositionalList<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    Position<T> first();

    Position<T> last();

    Position<T> before(Position<T> p) throws IllegalStateException;

    Position<T> after(Position<T> p) throws IllegalStateException;

    Position<T> addFirst(T element);

    Position<T> addLast(T element);

    Position<T> addBefore(Position<T> p, T element) throws IllegalArgumentException;

    Position<T> addAfter(Position<T> p, T element) throws IllegalArgumentException;

    T set(Position<T> p, T element) throws IllegalArgumentException;

    T remove(Position<T> p) throws IllegalArgumentException;

}
