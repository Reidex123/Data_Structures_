package com.avl_Tree;

public class AVL_test {
    public static void main(String[] args) {
        AVL<Integer> avlTree = new AVL<>();

        avlTree.insert(80);
        avlTree.insert(60);
        avlTree.insert(90);
        avlTree.insert(10);
        avlTree.insert(85);
        avlTree.insert(100);

        System.out.println("===========================================");

        System.out.println("Search{100} = " + avlTree.contains(100));
        System.out.println("Search{10} = " + avlTree.contains(10));

        System.out.println("Size = " + avlTree.size());
        System.out.println("Height = " + avlTree.height());

        System.out.print("Level-Order: ");
        avlTree.levelOrder();
        System.out.println();

        System.out.print("Pre-Order: ");
        avlTree.preOrder();
        System.out.println();

        System.out.print("In-Order: ");
        avlTree.inOrder();
        System.out.println();

        System.out.print("Post-Order: ");
        avlTree.postOrder();
        System.out.println();

        System.out.println("===========================================");

        avlTree.remove(90);
        avlTree.remove(85);

        System.out.println("Search{85} = " + avlTree.contains(85));
        System.out.println("Search{90} = " + avlTree.contains(90));

        System.out.println("Size = " + avlTree.size());
        System.out.println("Height = " + avlTree.height());

        System.out.print("Level-Order: ");
        avlTree.levelOrder();
        System.out.println();

        System.out.print("Pre-Order: ");
        avlTree.preOrder();
        System.out.println();

        System.out.print("In-Order: ");
        avlTree.inOrder();
        System.out.println();

        System.out.print("Post-Order: ");
        avlTree.postOrder();
        System.out.println();
    }
}