import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey(); //возвращает ключ узла
    AbstractBinaryTree<E> getLeft(); //возвращает левое поддерево узла
    AbstractBinaryTree<E> getRight(); //возвращает правый поддерево узла
    void setKey(E key); //устанавливает ключ узла
    List<AbstractBinaryTree<E>> preOrder(); //возвращает дерево в preOrder порядке
    List<AbstractBinaryTree<E>> inOrder(); //возвращает дерево в inOrder порядке
    List<AbstractBinaryTree<E>> postOrder(); //возвращает дерево в postOrder
    void forEachInOrder(Consumer<E> consumer); //отсортированый вывод
    void toString(StringBuilder sb, String indent);
}
