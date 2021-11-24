// you can add nodes to the queue, and you can 'enqueue' and 'dequeue' nodes

// future ideas for implementation:
// ------------------------------------------------------------------
//  - add bidirectionality to this queue implementation (i.e. 'front' and 'rear' attributes)
//  - build a dequeue method that removes and returns the smallest value or the largest value
//    in the queue
//  - use java generics

import java.util.Random;

public class Queue {
    private Node front;

    // basic constructor
    public Queue() {
        this.front = null;
    }

    // parametric constructor - constructs a random number of nodes inside the queue
    public Queue(int numNodes) {
        Random random = new Random();
        this.front = new Node(random.nextInt(20));
        Node current = this.front;
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
        if (this.front == null) {     // queue is empty
            this.front = node;
            node.setNext(null);
        } else {
            Node current = this.front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    // creates new node and adds it to the queue
    public void enqueue(int newData) {
        Node newNode = new Node(newData);
        if (this.front == null) {
            this.front = newNode;
            newNode.setNext(null);
        } else {
            Node current = this.front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // removes and returns first node in line
    public Node dequeue() {
        Node frontNode = this.front;
        if (this.front == null) {
            return null;
        } else {
            this.front = this.front.getNext();
            return frontNode;
        }
    }

    // prints queue from first to last
    public void printQueue() {
        if (this.front == null) {
            System.out.println("This queue is empty.");
        } else {
            Node current = this.front;
            while (current != null) {
                current.printNode();
                current = current.getNext();
            }
        }

    }
}
