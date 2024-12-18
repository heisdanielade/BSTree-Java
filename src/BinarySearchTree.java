import java.util.ArrayList;
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
        // get the subTree with the biggest height then + 1 ( length to root)
        int leftSubTreeHeight = calculateHeight(root.getLeft());
        int rightSubTreeHeight = calculateHeight(root.getRight());
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

}