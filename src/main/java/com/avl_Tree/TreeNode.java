package com.avl_Tree;

/**
 * Implementation of avl tree node
 * 
 * @version 10 February 2026
 */
public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public int height;
    public int balanceFactor;

    public TreeNode(T data) {
        this.data = data;
    }
}
