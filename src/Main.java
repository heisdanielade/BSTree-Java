import java.util.ArrayList;

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

        // InOrder
        bst.inOrder();
        ArrayList<Integer> bstValues = bst.inOrderValues();
        System.out.println(System.lineSeparator() + "-> InOrder values: " + bstValues);

        // Height of BST
        System.out.printf("-> Height: %s", bst.getHeight());

        // Search for an element in the BST
        int x = 12;
        System.out.printf(System.lineSeparator() + "-> Value %d in the BST: %s", x, bst.search(x));

    }
}