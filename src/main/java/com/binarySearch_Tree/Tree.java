package com.binarySearch_Tree;
import java.util.ArrayDeque;
import java.util.Queue;

import com.Tree.TreeInterface;
/*
 * Copyright (c) 2026 [Hlulani Myambo, Koketso Gaowelwe]
 * Licensed under the MIT License. See LICENSE file in the project root for full license information.
*/

/**
 * Implementation of the Binary Search Tree
 * @version 10 February 2026
 */
public class Tree<T extends Comparable<T>> implements TreeInterface<T> {
    public TreeNode<T> rootNode;

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

    @Override
    public int height() {
        return getHeight(this.rootNode);
    }

    private int getHeight(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
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
    public void insert(T data) {
        rootNode = insert(rootNode, data);
    }

    private TreeNode<T> insert(TreeNode<T> curr, T data) {
        if (curr == null) {
            return new TreeNode<>(data);
        }
        if (data.compareTo(curr.data) < 0) {
            curr.left = insert(curr.left, data);
        } else if (data.compareTo(curr.data) > 0) {
            curr.right = insert(curr.right, data);
        }

        return curr;
    }

    @Override
    public void remove(T data) {
        this.rootNode = remove(data, rootNode);
    }

    private TreeNode<T> remove(T data, TreeNode<T> node) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = remove(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        }

        else {
            // node has 0 or 1 child
            if (node.left == null) {
                return node.right;
            }

            else if (node.right == null) {
                return node.left;
            } else {
                // node has 2 children
                T successor = min(node.right);
                node.data = successor;

                node.right = remove(successor, node.right);
            }
        }

        return node;
    }

    @Override
    public void levelOrder() {
        final Queue<TreeNode<T>> treeNodeQueue = new ArrayDeque<>();
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

    @Override
    public void preOrder() {
        preOrder(rootNode);
    }

    private void preOrder(TreeNode<T> curr) {
        if (curr == null) {
            return;
        }

        visit(curr);
        preOrder(curr.left);
        preOrder(curr.right);
    }

    @Override
    public void inOrder() {
        inOrder(this.rootNode);
    }

    private void inOrder(TreeNode<T> curr) {
        if (curr == null) {
            return;
        }

        inOrder(curr.left);
        visit(curr);
        inOrder(curr.right);
    }

    @Override
    public void postOrder() {
        postOrder(this.rootNode);

    }

    private void postOrder(TreeNode<T> curr) {
        if (curr == null) {
            return;
        }

        postOrder(curr.left);
        postOrder(curr.right);
        visit(curr);
    }

    /*
     * This method prints the value of the current node.
     */
    private void visit(TreeNode<T> node) {
        System.out.print(node.data + " ");
    }

    /*
     * Finding the minimum value in the right subtree
     */
    private T min(TreeNode<T> curr) {
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.data;
    }
}