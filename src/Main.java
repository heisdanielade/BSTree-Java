import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------Binary Search Tree-------");

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(12);
        bst.insert(1);
        bst.insert(8);
        bst.insert(17);
        bst.insert(19);

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
        int x = 17;
        System.out.printf(System.lineSeparator() + "-> Search value %d in the BST: %s", x, bst.search(x));

        // Tree sort Algorithms
        int[] sortedArray = bst.treeSort();
        System.out.println(System.lineSeparator() + "-> TreeSort Algorithm: " + Arrays.toString(sortedArray));

        

    }
}