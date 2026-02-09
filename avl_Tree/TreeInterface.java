package avl_Tree;

public interface TreeInterface<T> {

    public void insert(T data);

    public void remove(T data);

    public void levelOrder();

    public void preOrder();

    public void inOrder();

    public void postOrder();

    public T min();

    public T max();

}
