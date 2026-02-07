package binarySearch_Tree;
public class Main {
    public static void main(String[] args) {
        Tree<Integer> binaryTree = new Tree<>();

        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(30);
        binaryTree.insert(3);
        binaryTree.insert(7);

        binaryTree.levelOrder();

        System.out.println("\n" + binaryTree.search(30)); // true
        System.out.println(binaryTree.search(50)); // false

        binaryTree.preOrder();
    }
}
