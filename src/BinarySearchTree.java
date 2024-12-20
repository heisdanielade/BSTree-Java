import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTree {
    private Node root;
    private int size;

    // version 2 of inserting value -- not used
    public boolean insertV2(int x) {
        if (root == null) { // tree is empty
            root = new Node(x);
            size++;
        } else { // we know that pom is not null
            Node pom = root;
            while (pom != null) {
                if (pom.getValue() == x)
                    return false;
                else {
                    if (pom.getValue() < x) {
                        if (pom.getRight() == null) {
                            pom.setRight(new Node(x, null, null, pom));
                            size++;
                            return true;
                        } else {
                            pom = pom.getRight();
                        }
                    } else {
                        if (pom.getLeft() == null) {
                            pom.setLeft(new Node(x, null, null, pom));
                            size++;
                            return true;
                        } else {
                            pom = pom.getLeft();
                        }
                    }
                }
            }

        }
        return true;
    }

    public void insert(int x) {
        if (root == null) {
            // tree is empty
            root = new Node(x);
            size++;
        } else {
            // we know that pom is not null
            Node pom = root;
            Node pop = null;
            while (pom != null) {
                if (pom.getValue() == x)
                    return;
                pop = pom;
                if (pom.getValue() < x) {
                    pom = pom.getRight();
                } else {
                    pom = pom.getLeft();
                }
            }
            // we know that pop cannot be null
            Node newNode = new Node(x, null, null, pop);
            size++;
            if (pop.getValue() < x) {
                pop.setRight(newNode);
            } else {
                pop.setLeft(newNode);
            }
        }
    }
    // InOrder Traversal
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }
    public void inOrder() {
        if (size == 0)
            System.out.print("Empty tree");
        else
            inOrder(root);
        System.out.println();
    }
    // Version 2: Print elements of BST using InOrder traversal in a list
    private void inOrderValues(Node root, ArrayList<Integer> iv) {
        if (root != null) {
            inOrderValues(root.getLeft(), iv);
            iv.add(root.getValue());
            inOrderValues(root.getRight(), iv);
        }
    }
    public ArrayList<Integer> inOrderValues() {
        ArrayList<Integer> iv = new ArrayList<>();
        if (size == 0) {
            return iv;
        } else
            inOrderValues(root, iv);
        return iv;
    }

    // PreOrder Traversal
    private void preOrder(Node root, ArrayList<Integer> pv) {
        if (root != null) {
            pv.add(root.getValue());
            preOrder(root.getLeft(), pv);
            preOrder(root.getRight(), pv);
        }
    }
    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> pv = new ArrayList<>();
        if(size == 0){
            return pv;
        } else {
            preOrder(root, pv);
        }
        return pv;
    }

    // PostOrder Traversal
    private void postOrder(Node root, ArrayList<Integer> pv) {
        if (root != null) {
            postOrder(root.getLeft(), pv);
            postOrder(root.getRight(), pv);
            pv.add(root.getValue());
        }
    }
    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> pv = new ArrayList<>();
        if(size == 0){
            return pv;
        }
        postOrder(root, pv);
        return pv;
    }

    // Search for an int x in the BST
    public boolean search(int x) {
        if (root == null){
            return false;
        } else {
            Node current = root;
            while (current != null) {
                if (current.getValue() == x){
                    return true;
                } else if (current.getValue() < x){
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            }
        }
        return false;
    }

    // Height of BST
    public int getHeight() {
        return calculateHeight(root);
    }
    private int calculateHeight(Node root) {
        if (root == null){
            return -1;
        }
        // get the subtree with the biggest height then + 1 ( length to root)
        int leftSubTreeHeight = calculateHeight(root.getLeft());
        int rightSubTreeHeight = calculateHeight(root.getRight());
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    // Tree sort Algorithm
    public ArrayList<Integer> treeSort(ArrayList<Integer> elements) {
        for (int val: elements){
            insert(val);
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        inOrderValues(root, sorted);
        return sorted;
    }

    // Bubble sort Algorithm
    public ArrayList<Integer> getAllValues() {
        ArrayList<Integer> values = new ArrayList<>();
        collectValues(root, values);
        return values;
    }
    private void collectValues(Node root, ArrayList<Integer> values) {
        if (root != null) {
            values.add(root.getValue());
            collectValues(root.getLeft(), values);
            collectValues(root.getRight(), values);
        }
    }
    public ArrayList<Integer> bubbleSort(){
        ArrayList<Integer> values = getAllValues();

        int n = values.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    int temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);
                }
            }
        }
        return values; // sorted list
    }

    public void saveExecutionTime() {
        File treeFile = new File("treesort_time_data.csv");
        File bubbleFile = new File("bubblesort_time_data.csv");
        try (PrintWriter treeWriter = new PrintWriter(new FileWriter(treeFile));
             PrintWriter bubbleWriter = new PrintWriter(new FileWriter(bubbleFile))) {

            Random r = new Random();
            for (int i = 500; i <= 10000; i = i + 500) {
                long timeTreeSort = 0;
                long timeBubbleSort = 0;
                for (int j = 0; j < 10; j++) {
                    ArrayList<Integer> array = new ArrayList<>();
                    for (int k = 0; k < i; k++) {
                        array.add(r.nextInt(200) - 100);
                    }
                    long start = System.nanoTime();
                    treeSort(array);
                    long end = System.nanoTime();
                    timeTreeSort += end - start;
                    start = System.nanoTime();
                    bubbleSort();
                    end = System.nanoTime();
                    timeBubbleSort += end - start;
                }
                long result = timeTreeSort / 10;
                treeWriter.println(Integer.toString(i) + "," + Long.toString(result));
                result = timeBubbleSort / 10;
                bubbleWriter.println(Integer.toString(i) + "," + Long.toString(result));
            }
            // Success message
            System.out.println(System.lineSeparator() + "(s) Data saved to files successfully.");
        } catch (IOException e){
            System.out.println("(e) An error occurred: " + e.getMessage());
        }
        }
}