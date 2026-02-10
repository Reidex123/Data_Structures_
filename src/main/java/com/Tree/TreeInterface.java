package com.Tree;

/**
 * This is the interface of the any tree that will be implemented.
 */
public interface TreeInterface<T extends Comparable<T>> {
    /**
     * This method inserts a node into the element if it does not exists.
     * in case the node exists, the node will be skipped
     * 
     * @param data Which is the node to be inserted in case it is not in the tree
     *             already.
     */
    public void insert(T data);

    /**
     * This method removes the node from the tree in case it exists.
     * 
     * @param data This is the node to be removed from the tree.
     */
    public void remove(T data);

    /**
     * This method checks whether the node exists in the tree or not.
     * 
     * @param data This is the node to be checked whether it exists or not
     * @return boolean - true if exists and false if not exists
     */
    public boolean contains(T data);

    /**
     * This method is for the level order Traversal.
     * prints from the root all the way down to the last right node.
     */
    public void levelOrder();

    /**
     * This method is for the pre-order Traversal.
     * prints from parent node -> left child -> right child
     */
    public void preOrder();

    /**
     * This method is for the in-order Traversal.
     * prints from left child -> parent node -> right child
     */
    public void inOrder();

    /**
     * This method is for the post-order traversal.
     * prints from left child -> right child -> parent node
     */
    public void postOrder();

    /**
     * This method counts the number of nodes in the tree.
     * 
     * @return The size or the number of nodes in the tree.
     */
    public int size();

    /**
     * This method calculates the height of the tree - zero based height.
     * 
     * @return The height of the tree.
     */
    public int height();
}
