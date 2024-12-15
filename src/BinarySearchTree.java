import java.util.ArrayList;
public class BinarySearchTree {
    private Node root;
    private int size;

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

    public boolean insert(int x) {
        if (root == null) {
            // tree is empty
            root = new Node(x);
            size++;
            return true;
        } else {
            // we know that pom is not null
            Node pom = root;
            Node pop = null;
            while (pom != null) {
                if (pom.getValue() == x)
                    return false;
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
            return true;

        }
    }

    // InOrder
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

}