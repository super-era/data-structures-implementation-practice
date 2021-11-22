// instantiations of the Node class model the elements in the queue

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

    // prints info in node
    public void printNode() {
        System.out.println(this.data);
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
