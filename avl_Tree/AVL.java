package avl_Tree;

public class AVL<T extends Comparable<T>> implements TreeInterface<T> {

    public TreeNode<T> rootNode;

    @Override
    public void insert(T data) {
    }

    @Override
    public void remove(T data) {
    }

    @Override
    public void levelOrder() {
        levelOrder(rootNode);
    }

    private void levelOrder(TreeNode<T> node) {
        java.util.Queue<TreeNode<T>> treeNodeQueue = new java.util.ArrayDeque<>();
        treeNodeQueue.add(node);
        TreeNode<T> current;


        while (treeNodeQueue.peek() != null) {
            current = treeNodeQueue.remove();
            System.out.print(current.data + " ");

            if (current.left != null) {
                treeNodeQueue.add(current.left);
            }
            if (current.right != null) {
                treeNodeQueue.add(current.right);
            }
        }
    }

    @Override
    public void preOrder() {
        preOrder(rootNode);
    }

    private void preOrder(TreeNode<T> node) {
        System.out.print(node.data + " ");

        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    @Override
    public void inOrder() {
        inOrder(rootNode);
    }

    private void inOrder(TreeNode<T> node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(rootNode);
    }

    private void postOrder(TreeNode<T> node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.data + " ");
    }

    @Override
    public void updateHeight() {
    }

    @Override
    public T min() {
        return min(rootNode);
    }

    private T min(TreeNode<T> node) {
        if (node == null) {
            Runtime.getRuntime().exit(0);
        }
        if (node.left != null) {
            return min(node.left);
        }
        return node.data;
    }

    @Override
    public T max() {
        return max(rootNode);
    }

    private T max(TreeNode<T> node) {
        if (node == null) {
            Runtime.getRuntime().exit(0);
        }
        if (node.right != null) {
            return max(node.right);
        }
        return node.data;
    }

}
