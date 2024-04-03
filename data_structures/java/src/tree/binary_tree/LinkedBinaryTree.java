package tree.binary_tree;

import tree.Position;

import java.util.Iterator;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T>{

    private static class Node<T> implements Position<T> {

        private T element;
        private Node<T> parent;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
            this.element = element;
            this.parent = parent;
            this.leftChild = left;
            this.rightChild = right;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public T getElement() throws IllegalStateException {
            return element;
        }
    }
    private Node<T> createNode(T element, Node<T> parent, Node<T> left, Node<T> right) {
        return new Node<>(element, parent, left, right);
    }

    private Node<T> root = null;
    private int size = 0;

    public LinkedBinaryTree() {}

    private Node<T> validate(Position<T> p) throws IllegalArgumentException {

        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        Node<T> node = (Node<T>) p;

        if (node.parent == node)
            throw new IllegalArgumentException("P is no longer in the Tree");
        return node;
    }

    public Position<T> addRoot(T element) throws IllegalArgumentException {
        if (root != null)
            throw new IllegalStateException("Tree is not empty");
        root = createNode(element, null, null, null);
        size++;
        return root;
    }

    public Position<T> addLeft(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.leftChild != null) throw new IllegalStateException("P already has a left child");
        parent.leftChild = createNode(element, parent, null, null);
        size++;
        return parent;
    }

    public Position<T> addRight(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.rightChild != null) throw new IllegalStateException("P already has a right child");
        parent.rightChild = createNode(element, parent, null, null);
        size++;
        return parent;
    }

    public T set(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T temp = node.element;
        node.element = element;
        return temp;
    }

    public void attach(Position<T> p, LinkedBinaryTree<T> T1, LinkedBinaryTree<T> T2)
            throws IllegalArgumentException {

        if (isInternal(p))
            throw new IllegalArgumentException("P must be a leaf");

        Node<T> node = validate(p);
        size += T1.size + T2.size;

        if (!T1.isEmpty()) {
            T1.root.parent = node;
            node.leftChild = T1.root;
            T1.root = null;
            T1.size = 0;
        }
        if (!T2.isEmpty()) {
            T2.root.parent = node;
            node.rightChild = T2.root;
            T2.root = null;
            T2.size = 0;
        }
    }

    public T remove(Position<T> p) throws IllegalArgumentException {

        if (numChildren(p) == 2) throw new IllegalArgumentException("P ha two children");
        Node<T> node = validate(p);
        Node<T> child = (node.leftChild != null ? node.leftChild : node.rightChild);

        if (child != null) child.parent = node.parent;

        if (node == root) root = child;

        else {
            Node<T> parent = node.parent;

            if (node == parent.leftChild)
                parent.leftChild = child;
            else
                parent.rightChild = child;
        }
        size--;
        T temp = node.element;
        node.element = null;
        node.leftChild = null;
        node.rightChild = null;
        node.parent = node;
        return temp;
    }

    @Override
    public Position<T> left(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.leftChild;
    }

    @Override
    public Position<T> right(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.rightChild;
    }

    @Override
    public Position<T> root() { return root; }

    @Override
    public Position<T> parent(Position<T> p) {
        Node<T> node = validate(p);
        return node.parent;
    }

    @Override
    public int size() { return size; }

    @Override
    public Iterable<Position<T>> positions() {return inorder();}
}
