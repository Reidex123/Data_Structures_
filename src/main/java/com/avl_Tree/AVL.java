package com.avl_Tree;

import com.Tree.TreeInterface;

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
        }

        update(node);

        return balance(node);

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
        } else if (data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.left.height > node.right.height) {
                    T successor = max(node.left);
                    node.data = successor;
                    node.left = remove(successor, node.left);
                } else {
                    T successor = min(node.right);
                    node.data = successor;
                    node.right = remove(successor, node.right);
                }
            }
        }

        update(node);

        return balance(node);
    }

    private TreeNode<T> balance(TreeNode<T> node) {
        if (node.balanceFactor == -2) {
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        } else if (node.balanceFactor == 2) {
            if (node.left.balanceFactor <= 0) {
                return rightRightCase(node);
            } else {
                return rightleftCase(node);
            }
        }

        return node;
    }

    private TreeNode<T> rightleftCase(TreeNode<T> node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private TreeNode<T> rightRightCase(TreeNode<T> node) {
        return leftRotation(node);
    }

    private TreeNode<T> leftRightCase(TreeNode<T> node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private TreeNode<T> leftLeftCase(TreeNode<T> node) {
        return rightRotation(node);
    }

    private void update(TreeNode<T> node) {
        int rightNodeHeight = node.right != null ? node.right.height : -1;
        int leftNodeHeight = node.left != null ? node.left.height : -1;

        node.height = 1 + Math.max(rightNodeHeight, leftNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private TreeNode<T> leftRotation(TreeNode<T> node) {
        TreeNode<T> newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;

        update(node);
        update(newParent);

        return newParent;
    }

    private TreeNode<T> rightRotation(TreeNode<T> node) {
        TreeNode<T> newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;

        update(node);
        update(newParent);

        return newParent;
    }

    @Override
    public void levelOrder() {
        levelOrder(rootNode);
    }

    private void levelOrder(TreeNode<T> node) {
        final java.util.Queue<TreeNode<T>> treeNodeQueue = new java.util.ArrayDeque<>();
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

    private T min(TreeNode<T> curr) {
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.data;
    }

    private T max(TreeNode<T> curr) {
        while (curr.right != null) {
            curr = curr.right;
        }

        return curr.data;
    }

    @Override
    public boolean contains(T data) {
        return contains(rootNode, data);
    }

    private boolean contains(TreeNode<T> curr, T data) {
        if (curr == null) {
            return false;
        }

        if (data.compareTo(curr.data) < 0) {
            return contains(curr.left, data);
        } else if (data.compareTo(curr.data) > 0) {
            return contains(curr.right, data);
        }

        return true;
    }

    @Override
    public int size() {
        return this.getSize(this.rootNode);
    }

    private int getSize(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + getSize(node.left) + getSize(node.right);
    }

    /*
     * Returning the height of the tree overall
     */
    @Override
    public int height() {
        return this.rootNode.height;
    }
}
