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

        System.out.println("\nSearch {30}: " + binaryTree.search(30)); // true
        System.out.println("Search {50}: " + binaryTree.search(50)); // false

        System.out.print("Level-Order: ");
        binaryTree.levelOrder(); // 10, 5, 15, 3, 7, 30
        System.out.println();

        System.out.print("Pre-Order: ");
        binaryTree.preOrder(); // 10, 5, 3, 7, 15, 30
        System.out.println();

        System.out.print("In-Order: ");
        binaryTree.inOrder(); // 3, 5, 7, 10, 15, 30
        System.out.println();

        System.out.print("Post-Order: ");
        binaryTree.postOrder(); // 3, 7, 5, 30, 15, 10
        System.out.println();

        System.out.println("----------------------------------------");

        binaryTree.remove(5);
        binaryTree.remove(30);
        System.out.println("Removed 5 and 30!!");

        System.out.print("Level-Order: ");
        binaryTree.levelOrder(); // 10, 15, 3, 7
        System.out.println();

        System.out.print("Pre-Order: ");
        binaryTree.preOrder(); // 10, 3, 7, 15
        System.out.println();

        System.out.print("In-Order: ");
        binaryTree.inOrder(); // 3, 7, 10, 15
        System.out.println();

        System.out.print("Post-Order: ");
        binaryTree.postOrder(); // 3, 7, 30, 15
        System.out.println();
    }
}
