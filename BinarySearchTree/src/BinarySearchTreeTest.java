public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        System.out.println("Вставка элементов:");
        bst.insert(10);
        bst.insert(11);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        System.out.println("Элементы вставлены: 10, 11, 15, 3, 7, 12, 18\n");

        System.out.println("Проверка наличия элементов:");
        System.out.println("Contains 7: " + bst.contains(7));
        System.out.println("Contains 20: " + bst.contains(20));
        System.out.println("Contains 15: " + bst.contains(15));
        System.out.println("Contains 10: " + bst.contains(10));
        System.out.println("Contains 11: " + bst.contains(11));
        System.out.println("Contains 3: " + bst.contains(3));
        System.out.println("Contains 18: " + bst.contains(18));
        System.out.println("Contains 8: " + bst.contains(8));
        System.out.println();

        System.out.println("Поиск поддерева с элементом:");
        AbstractBinarySearchTree<Integer> searchResult = bst.search(7);
        if (searchResult.getRoot() != null) {
            System.out.println("Found node with value: " + searchResult.getValue());  // 7
        } else {
            System.out.println("Node not found");
        }

        searchResult = bst.search(20);
        if (searchResult.getRoot() != null) {
            System.out.println("Found node with value: " + searchResult.getValue());
        } else {
            System.out.println("Node not found");
        }
        System.out.println();

        System.out.println("Получение корня дерева:");
        System.out.println("Root value: " + bst.getValue());

        System.out.println("Левое поддерево:");
        Node<Integer> left = bst.getLeft();
        if (left != null) {
            System.out.println("Left child of root: " + left.value);
        } else {
            System.out.println("Left child of root is null");
        }

        System.out.println("Правое поддерево:");
        Node<Integer> right = bst.getRight();
        if (right != null) {
            System.out.println("Right child of root: " + right.value);
        } else {
            System.out.println("Right child of root is null");
        }

        System.out.println("\nТестирование получения значения узлов:");
        Node<Integer> leftChildOfRoot = bst.getLeft();
        if (leftChildOfRoot != null) {
            System.out.println("Left child of root: " + leftChildOfRoot.value);

            Node<Integer> leftChildOfLeft = leftChildOfRoot.leftChild;
            if (leftChildOfLeft != null) {
                System.out.printf("Left child of %d: %d\n", leftChildOfLeft.value, leftChildOfLeft.value);
            } else {
                System.out.printf("Left child of %d is null\n", leftChildOfRoot.value);
            }

            Node<Integer> rightChildOfLeft = leftChildOfRoot.rightChild;
            if (rightChildOfLeft != null) {
                System.out.printf("Right child of %d: %d\n", leftChildOfRoot.value, rightChildOfLeft.value);
            } else {
                System.out.printf("Right child of %d is null", leftChildOfRoot.value);
            }
        } else {
            System.out.println("Left child of root is null");
        }

        Node<Integer> rightChildOfRoot = bst.getRight();
        if (rightChildOfRoot != null) {
            System.out.println("Right child of root: " + rightChildOfRoot.value);

            Node<Integer> leftChildOfRight = rightChildOfRoot.leftChild;
            if (leftChildOfRight != null) {
                System.out.printf("Left child of %d: %d\n", rightChildOfRoot.value, leftChildOfRight.value);
            } else {
                System.out.printf("Left child of %d is null\n", rightChildOfRoot.value);
            }

            Node<Integer> rightChildOfRight = rightChildOfRoot.rightChild;
            if (rightChildOfRight != null) {
                System.out.printf("Right child of %d: %d\n", rightChildOfRoot.value, rightChildOfRight.value);
            } else {
                System.out.printf("Right child of %d is null\n", rightChildOfRoot.value);
            }
        } else {
            System.out.println("Right child of root is null");
        }

        System.out.println();
        System.out.println("Тестирование метода toggle:");
        bst.toggle(5);
        System.out.println("Contains 5: " + bst.contains(5));
        bst.toggle(5);
        System.out.println("Contains 5: " + bst.contains(5));
        bst.toggle(10);
        System.out.println("Contains 10: " + bst.contains(10));

        System.out.println();
        System.out.println(bst);
    }
}
