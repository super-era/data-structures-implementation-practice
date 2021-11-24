public class Item {
    private int data;
    private Item next;

    // basic constructor
    public Item() {
        this.data = 0;
        this.next = null;
    }

    // parametric constructor
    public Item(int data) {
        this.data = data;
        this.next = null;
    }

    // methods

    // print contents of Item

    public void printItem() {
        System.out.println("Item: " + this.data);
    }

    // accessors

    public int getData() {
        return this.data;
    }

    public Item getNext() {
        return this.next;
    }

    // mutators

    public void setData(int newData) {
        this.data = newData;
    }

    public void setNext(Item newNext) {
        this.next = newNext;
    }
}
