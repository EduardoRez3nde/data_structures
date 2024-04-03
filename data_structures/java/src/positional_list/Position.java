package positional_list;

public interface Position<T> {

    T getElement() throws IllegalStateException;
}
