package tree;

public interface Position<T> {

    T getElement() throws IllegalStateException;
}
