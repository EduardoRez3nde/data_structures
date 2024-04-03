package tree.binary_tree;

import tree.Position;
import tree.general_tree.AbstractTree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {

    public Position<T> sibling(Position<T> p) {
        Position<T> parent = parent(p);
        if (parent == null) return null;
        if (parent == left(p)) return right(parent);
        return left(parent);
    }

    public int numChildren(Position<T> p) {
        int count = 0;
        if (left(p) != null) count++;
        if (right(p) != null) count++;
        return count;
    }

    public Iterable<Position<T>> children(Position<T> p) {
        List<Position<T>> list = new ArrayList<>(2);
        if (left(p) != null)
            list.add(left(p));
        if (right(p) != null)
            list.add(right(p));
        return list;
    }

    private void inorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }

    public Iterable<Position<T>> inorder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }
}
