package tree.general_tree;

import queue.queue_linked_list.Queue;
import queue.queue_linked_list.QueueLinkedList;
import tree.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<T> implements Tree<T> {

    public boolean isEmpty() { return size() == 0; }

    public boolean isRoot(Position<T> p) { return p == root(); }

    public boolean isInternal(Position<T> p) { return numChildren(p) > 0; }

    public boolean isExternal(Position<T> p) { return numChildren(p) == 0; }

    public int height(Position<T> p) {
        int h = 0;
        for (Position<T> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    public int depth(Position<T> p) {
        if (isRoot(p))
            return 0;
        return 1 + depth(parent(p));
    }

    private class ElementIterator implements Iterator<T> {

        Iterator<Position<T>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {return posIterator.hasNext();}

        @Override
        public T next() {return posIterator.next().getElement();}

        @Override
        public void remove() {posIterator.remove();}
    }

    public Iterator<T> iterator() { return new ElementIterator(); }

    private void preorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        snapshot.add(p);
        for (Position<T> c : children(p))
            preorderSubtree(c, snapshot);
    }

    public Iterable<Position<T>> preorder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    private void postorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        for (Position<T> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }

    public Iterable<Position<T>> postorder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    public Iterable<Position<T>> breadthFirstSearch() {

        List<Position<T>> list = new ArrayList<>();

        if (!isEmpty()) {
            QueueLinkedList<Position<T>> queue = new Queue<>();
            queue.enqueue(root());

            while (!queue.isEmpty()) {
                Position<T> p = queue.dequeue();
                list.add(p);

                for (Position<T> pos : children(p))
                    queue.enqueue(pos);
            }
        }
        return list;
    }


}
