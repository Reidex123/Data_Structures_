package avl_Tree;

public class AVL<T extends Comparable<T>> implements TreeInterface<T> {

    public TreeNode<T> rootNode;

    @Override
    public void insert(T data) {
        rootNode = insert(data, rootNode);
    }

    private TreeNode<T> insert(T data, TreeNode<T> node) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        } else {
            return node;
        }

        updateHeight(node);

        return applyRotation(node);

    }

    @Override
    public void remove(T data) {
        rootNode = remove(data, rootNode);
    }

    private TreeNode<T> remove(T data, TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = remove(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        }
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            T successor = max(node.left);
            node.left = remove(successor, node.left);
        }

        updateHeight(node);

        return applyRotation(node);
    }

    private TreeNode<T> applyRotation(TreeNode<T> node) {
        int balance = balance(node);

        if (balance > 1) { // left-heavy
            if (balance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        if (balance < -1) { // right-heavy
            if (balance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return null;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> node) {
        TreeNode<T> rightNode = node.right;
        TreeNode<T> childNode = rightNode.left;
        rightNode.left = node;
        node.right = childNode;

        updateHeight(node);
        updateHeight(rightNode);

        return rightNode;
    }

    private TreeNode<T> rotateRight(TreeNode<T> node) {
        TreeNode<T> leftNode = node.left;
        TreeNode<T> childNode = leftNode.right;
        leftNode.right = node;
        node.left = childNode;

        updateHeight(node);
        updateHeight(leftNode);

        return leftNode;
    }

    private int balance(TreeNode<T> node) {
        return node != null ? height(node.left) - height(node.right) : 0;
    }

    private void updateHeight(TreeNode<T> node) {
        int maxHeight = Math.max(height(node.left), height(node.right));

        node.height = maxHeight + 1;
    }

    private int height(TreeNode<T> node) {
        return node != null ? node.height : 0;
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
