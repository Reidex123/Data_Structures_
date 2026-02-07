package binarySearch_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree<T extends Comparable<T>> implements TreeInterface<T> {

    public TreeNode<T> rootNode;

    public Tree() {
        this.rootNode = null;
    }

    public boolean search(T data) {

        return search(rootNode, data);
    }

    private boolean search(TreeNode<T> curr, T data) {
        if (curr == null) {
            return false;
        }

        if (data.compareTo(curr.data) < 0) {
            return search(curr.left, data);
        } else if (data.compareTo(curr.data) > 0) {
            return search(curr.right, data);
        }

        return true;
    }

    @Override
    public void insert(T data) {
        rootNode = insert(rootNode, data);
    }

    private TreeNode<T> insert(TreeNode<T> curr, T data) {
        if (curr == null) {
            return new TreeNode<>(data);
        }
        if (data.compareTo(curr.data) < 0) {
            curr.left = insert(curr.left, data);
        } else {
            curr.right = insert(curr.right, data);
        }
        return curr;
    }

    @Override
    public void remove(T data) {
        rootNode = remove(data, rootNode);
    }

    private TreeNode<T> remove(T data, TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        else {
            if (data.compareTo(node.data) < 0) {
                node.left = remove(data, node.left);
            } else if (data.compareTo(node.data) > 0) {
                node.right = remove(data, node.right);
            } else {
                // one child or leaf node (no children)
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                T maxValue = max(node.left);
                node.left = remove(maxValue, node.left);
                node.left = remove(maxValue, node.left);
            }
        }
        return node;
    }
    /**
     * Traverse over BST level by level printing the data each node contains
     * using a Queue
     */
    @Override
    public void levelOrder() {

        Queue<TreeNode<T>> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(rootNode);
        TreeNode<T> curr;

        while (treeNodeQueue.peek() != null) { // traverse while the queue is not empty
            curr = treeNodeQueue.remove();

            System.out.print(curr.data + " ");

            if (curr.left != null) {
                treeNodeQueue.add(curr.left);
            }
            if (curr.right != null) {
                treeNodeQueue.add(curr.right);
            }
        }
    }

    /**
     * rootNode, left subtree, right subtree
     */
    @Override
    public void preOrder() {
        preOrder(rootNode);
    }

    private void preOrder(TreeNode<T> curr) {
        System.out.print(curr.data + " ");

        if (curr.left != null) {
            preOrder(curr.left);
        }
        if (curr.right != null) {
            preOrder(curr.right);
        }
    }

    /**
     * left subtree, rootNode, right subtree
     */
    @Override
    public void inOrder() {
        inOrder(rootNode);

    }

    private void inOrder(TreeNode<T> curr) {
        if (curr.left != null) {
            inOrder(curr.left);
        }

        System.out.print(curr.data + " ");

        if (curr.right != null) {
            inOrder(curr.right);
        }
    }

    /**
     * left subtree, rootNode, right subtree
     */
    @Override
    public void postOrder() {
        postOrder(rootNode);

    }

    private void postOrder(TreeNode<T> curr) {
        if (curr.left != null) {
            postOrder(curr.left);
        }
        if (curr.right != null) {
            postOrder(curr.right);
        }

        System.out.print(curr.data + " ");
    }

    /**
     * recursively find the left most node(minimum)
     */
    public T min() {
        return min(rootNode);
    }

    private T min(TreeNode<T> curr) {
        if (curr.left != null) {
            return min(curr.left);
        }

        return curr.data;
    }

    /**
     * recursively find the right most node(maximum)
     */
    public T max() {
        return max(rootNode);
    }

    private T max(TreeNode<T> curr) {
        if (curr.right != null) {
            return max(curr.right);
        }

        return curr.data;
    }

}
