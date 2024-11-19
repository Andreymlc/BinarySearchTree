public class Node<E> {
    public E value;
    public Node<E> leftChild;
    public Node<E> rightChild;

    public Node(E value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(E value, Node<E> leftChild, Node<E> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void toString(StringBuilder sb, String indent) {
        if (rightChild != null) {
            rightChild.toString(sb, indent + "   ");
        }

        sb.append(indent).append(value).append("\n");

        if (leftChild != null) {
            leftChild.toString(sb, indent + "   ");
        }
    }
}

