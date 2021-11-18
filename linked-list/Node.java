public class Node {
    private int data;
    private Node next;

    // basic constructor
    public Node() {
        this.data = 0;
        this.next = null;
    }

    // parametric constructor
    public Node(int data) {
        this.data = data;
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

    // mutators

    public void setData(int newData) {
        this.data = newData;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }
} 