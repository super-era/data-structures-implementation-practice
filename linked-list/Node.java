public class Node {
    private int data;
    // bi-directional pointers
    private Node prev;
    private Node next;

    // basic constructor
    public Node() {
        this.data = 0;
        this.prev = null;
        this.next = null;
    }

    // parametric constructor
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // methods

    // prints the data attribute in the node
    public void printNode() {
        System.out.println("Node: " + this.data);
    }


    // accessors

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    // mutators

    public void setData(int newData) {
        this.data = newData;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }

    public void setPrev(Node newPrev) {
        this.prev = newPrev;
    }
} 