import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------Binary Search Tree-------");

        BinarySearchTree bst = new BinarySearchTree();

        int[] elements = {10,5,15,7,12,1,8,17,19};
        for (int e: elements) {
            bst.insert(e);
        }

        // InOrder Traversal
        bst.inOrder();
        ArrayList<Integer> inBstValues = bst.inOrderValues();
        System.out.println(System.lineSeparator() + "-> InOrder values: " + inBstValues);

        // PreOrder Traversal
        bst.preOrder();
        ArrayList<Integer> preBstValues = bst.preOrder();
        System.out.println("-> PreOrder values: " + preBstValues);

        // PostOrder Traversal
        bst.preOrder();
        ArrayList<Integer> postBstValues = bst.postOrder();
        System.out.println("-> PreOrder values: " + postBstValues);

        // Height of BST
        System.out.printf("-> Height: %s", bst.getHeight());

        // Search for x in the BST
        int x = 20;
        System.out.printf(System.lineSeparator() + "-> Search (value %d exists): %s", x, bst.search(x));

        // Tree sort Algorithms
        int[] sortedArray = bst.treeSort();
        System.out.println(System.lineSeparator() + "-> TreeSort Algorithm: " + Arrays.toString(sortedArray));

        // Bubble sort Algorithms
        System.out.println("-> BubbleSort Algorithm: " + bst.bubbleSort());

        // Get Execution time TreeSort & BubbleSort Algorithms


    }
}