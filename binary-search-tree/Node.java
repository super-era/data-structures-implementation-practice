public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    // basic constructor
    public Node() {
        this.left = null;
        this.right = null;
    }

    // parametric constructor
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // methods

    public void printNode() {
        System.out.println(this.data);
    }

    // accessors

    public T getData() {
        return this.data;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    // mutators

    public void setData(T newData) {
        this.data = newData;
    }

    public void setLeft(Node<T> newLeft) {
        this.left = newLeft;
    }

    public void setRight(Node<T> newRight) {
        this.right = newRight;
    }
 
}
