public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public void insert(E element) {
        root = insertHelper(root, element);
    }

    private Node<E> insertHelper(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.value) < 0) {
            node.leftChild = insertHelper(node.leftChild, element);
        } else if (element.compareTo(node.value) > 0) {
            node.rightChild = insertHelper(node.rightChild, element);
        }

        return node;
    }

    @Override
    public boolean contains(E element) {
        return containsHelper(root, element);
    }

    private boolean containsHelper(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        if (element.compareTo(node.value) < 0) {
            return containsHelper(node.leftChild, element);
        } else if (element.compareTo(node.value) > 0) {
            return containsHelper(node.rightChild, element);
        } else {
            return true;
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> foundNode = searchHelper(root, element);
        if (foundNode != null) {
            return new BinarySearchTree<>(foundNode.value, foundNode.leftChild, foundNode.rightChild);
        } else {
            return new BinarySearchTree<>();
        }
    }

    private Node<E> searchHelper(Node<E> node, E element) {
        if (node == null || element.compareTo(node.value) == 0) {
            return node;
        }

        if (element.compareTo(node.value) < 0) {
            return searchHelper(node.leftChild, element);
        } else {
            return searchHelper(node.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return root != null ? root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return root != null ? root.rightChild : null;
    }

    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    public BinarySearchTree(E value, Node<E> leftChild, Node<E> rightChild) {
        root = new Node<>(value, leftChild, rightChild);
    }

    @Override
    public void toggle(E element) {
        if (contains(element)) {
            root = deleteHelper(root, element);
        } else {
            insert(element);
        }
    }

    private Node<E> deleteHelper(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.value) < 0) {
            node.leftChild = deleteHelper(node.leftChild, element);
        } else if (element.compareTo(node.value) > 0) {
            node.rightChild = deleteHelper(node.rightChild, element);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            Node<E> smallestValueNode = findMin(node.rightChild);
            node.value = smallestValueNode.value;
            node.rightChild = deleteHelper(node.rightChild, smallestValueNode.value);
        }

        return node;
    }

    private Node<E> findMin(Node<E> node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.root.toString(sb, "");
        return sb.toString();
    }
}
