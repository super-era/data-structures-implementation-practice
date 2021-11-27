public class Node {
    private int index;

    // basic constructor
    public Node() {
        this.index = 0;
    }

    // parametric constructor
    public Node(int index) {
        this.index = index;
    }

    // methods
    public void printNode() {
        System.out.print("Node " + this.index);
    }

    // accessors
    public int getIndex() {
        return this.index;
    }

    // mutator
    public void setIndex(int newIndex) {
        this.index = newIndex;
    }
}