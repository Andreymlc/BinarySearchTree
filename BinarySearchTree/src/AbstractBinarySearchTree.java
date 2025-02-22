public interface AbstractBinarySearchTree<E extends Comparable<E>> {

    void insert(E element);

    boolean contains(E element);

    AbstractBinarySearchTree<E> search(E element);

    Node<E> getRoot();

    Node<E> getLeft();

    Node<E> getRight();

    E getValue();
    void toggle(E element);
}