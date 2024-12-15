public class Node {
    private int value;
    private Node left,right;
    private Node parent;
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node(int value, Node left, Node right,Node parent) {
        super();
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public Node(int value) {
        this(value,null,null,null);
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

}