package com.binarySearch_Tree;
/*
 * Copyright (c) 2026 [Hlulani Myambo, Koketso Gaowelwe]
 * Licensed under the MIT License. See LICENSE file in the project root for full license information.
*/

/**
 * Implementation of the BST node
 * @since 10 February 2026
 */
public class TreeNode<T> {
    public T data;
    public TreeNode<T> left, right;

    public TreeNode(T data) {
        this.data = data;
    }
}
