package avl_Tree;

public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public int height;

    public TreeNode(T data) {
        this.data = data;
    }

}
