// you can add nodes to the queue, and you can 'enqueue' and 'dequeue' nodes

// future ideas for implementation:
// ------------------------------------------------------------------
//  - build a dequeue method that removes and returns the smallest value or the largest value
//    in the queue
//  - use java generics

import java.util.Random;

public class Queue {
    private Node top;

    // basic constructor
    public Queue() {
        this.top = null;
    }

    // parametric constructor - constructs a random number of nodes inside the queue
    public Queue(int numNodes) {
        Random random = new Random();
        this.top = new Node(random.nextInt(20));
        Node current = this.top;
        int count = 1;
        while ((current != null) && (count != numNodes)) {
            current.setNext(new Node(random.nextInt(20)));
            count++;
            current = current.getNext();
        }
    }

    // methods

    // adds existing node to end of queue
    public void enqueue(Node node) {
        if (this.top == null) {     // queue is empty
            this.top = node;
            node.setNext(null);
        } else {
            Node current = this.top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    // creates new node and adds it to the queue
    public void enqueue(int newData) {
        Node newNode = new Node(newData);
        if (this.top == null) {
            this.top = newNode;
            newNode.setNext(null);
        } else {
            Node current = this.top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // removes and returns first node in line
    public Node dequeue() {
        Node topNode = this.top;
        if (this.top == null) {
            return null;
        } else {
            this.top = this.top.getNext();
            return topNode;
        }
    }

    // prints queue from first to last
    public void printQueue() {
        if (this.top == null) {
            System.out.println("This queue is empty.");
        } else {
            Node current = this.top;
            while (current != null) {
                current.printNode();
                current = current.getNext();
            }
        }

    }
}
