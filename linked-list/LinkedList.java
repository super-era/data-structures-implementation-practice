import java.util.Random;
import java.util.ArrayList;

public class LinkedList {
    private Node head;

    // basic constructor
    public LinkedList() {

    }

    // parametric constructor (for convenience)
    // initialises a user-specified number of nodes with random data
    // no two nodes will be initialised with the same data if the user uses "true" for the boolean in the argument
    public LinkedList(int numNodes, boolean noIdenticalNodes) {
        Random random = new Random();
        this.head = new Node(random.nextInt(20));
        Node current = this.head;
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        for (int i = 0; i < numNodes - 1; i++) {
            int data = random.nextInt(20);
            if (noIdenticalNodes) {
                while (tempArr.lastIndexOf(data) != -1) {
                    data = random.nextInt(20);
                }
                tempArr.add(data);
            }
            current.setNext(new Node(data));
            current = current.getNext();
        }
    }

    // methods

    // add new Node to LinkedList
    public void addNode(int newData) {
        Node newNode = new Node(newData);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // remove and return the last Node in the LinkedList
    public Node removeLastNode() {
        Node removed = null;
        Node prev = null;
        if (this.head == null) {
            System.out.println("This list is empty.");
        } else {
            Node current = this.head;
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }
            removed = current;
            prev.setNext(null);
        }
        return removed;
    }

    // remove and return the first Node in the LinkedList
    public Node removeFirstNode() {
        Node removed = null;
        if (this.head == null) {
            System.out.println("This list is empty.");
        } else {
            removed = this.head;
            this.head = this.head.getNext();
        } 
        return removed;
    }

    // find and return a Node in the LinkedList based on data attribute
    // (uncomment/comment relevant code to display/hide a print statement re: the number of times a particular node appears)
    // (equivalent of a simple linear (iterative) search)
    public Node findNodeByData(int data) {
        Node target = null;
        Node current = this.head;
        int count = 0;       // extension of method
        while (current != null) {
            if (current.getData() == data) {
                target = current;
                count++;        // extension of method
            }
            current = current.getNext();
        }
        if (target != null) {
            System.out.println("Found node " + data + "! It appears " + count + " times in this list." );       // extension of method
        }
        return target;
    }

    // finding and returning a Node in the LinkedList based on data attributes
    // (using a recursive method as per Skiena (2020))
    public Node findNodeByDataRec(Node nodeInList, int data) {
        if (nodeInList == null) {
            return null;
        } else {
            if (nodeInList.getData() == data) {
                return nodeInList;
            } else {
                return findNodeByDataRec(nodeInList.getNext(), data);
            }
        }
    }

    // remove and return a Node in the LinkedList by data attribute
    // if multiple nodes with the same data attribute exist, the method will remove all nodes
    // with the same data attribute, but only return the last node with that particular data attribute.
    // (Uses linear (iterative) search.)
    public Node removeNodeByData(int data) {
        Node target = null;
        Node current = this.head;
        Node prev = null;
        int count = 0;
        while (current != null) {
            if (current.getData() == data) {
                target = current;
                if (current == this.head) {
                    this.head = this.head.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                count++;
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        System.out.println("Removed " + count + " nodes with data attribute " + data + "!");
        return target;
    }

    // swap the data in two nodes - to be used inside sortList()
    private void swapNodes(Node one, Node two) {
        int temp = two.getData();
        two.setData(one.getData());
        one.setData(temp);
    }

    // sort LinkedList in either ascending or descending order using bubble sort
    public LinkedList sortList(LinkedList list, boolean descending) {
        if (this.head == null) {
            System.out.println("This list is empty.");
        } else {
            Node first = this.head;
            Node current = null;

            while (first != null) {
                current = first.getNext();
                while (current != null) {
                    if (descending) {
                        if (current.getData() > first.getData()) {
                            swapNodes(current, first);
                        }
                    } else {
                        if (current.getData() < first.getData()) {
                            swapNodes(current, first);
                        }
                    }
                    current = current.getNext();
                }
                first = first.getNext();
            }

        }

        return list;
            
    }

    // print the data attribute of each node in the list
    public void printList() {
        if (this.head == null) {
            System.out.println("This list is empty.");
        } else {
            Node current = this.head;
            while (current != null) {
                current.printNode();
                current = current.getNext();
            } 
        } 
    }

    // accessor

    public Node getHead() {
        return this.head;
    }

    // mutator

    public void setHead(Node newHead) {
        this.head = newHead;
    }
}

