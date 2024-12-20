import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        System.out.println("--------Binary Search Tree-------");

        BinarySearchTree bst = new BinarySearchTree();

        int[] elements = {10,5,15,7,12,1,8,17,19};
        for (int e: elements) {
            bst.insert(e);
        }

        // InOrder Traversal
        System.out.println(System.lineSeparator() + "-> InOrder values: " + bst.inOrderValues());

        // PreOrder Traversal
        System.out.println("-> PreOrder values: " + bst.preOrder());

        // PostOrder Traversal
        System.out.println("-> PostOrder values: " + bst.postOrder());

        // Height of BST
        System.out.printf("-> Height: %s", bst.getHeight());

        // Search for x in the BST
        int x = 20;
        System.out.printf(System.lineSeparator() + "-> Search (value %d exists): %s", x, bst.search(x));

        // Tree sort Algorithms
        System.out.println(System.lineSeparator() + "-> TreeSort Algorithm: " + bst.treeSort(elements));

        // Bubble sort Algorithms
        System.out.println("-> BubbleSort Algorithm: " + bst.bubbleSort());

        // Save Execution time of Algorithms to csv files
        bst.saveExecutionTime();

    }
}