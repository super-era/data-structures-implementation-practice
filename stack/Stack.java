// stacks are Last In First Out (LIFO) data structures

import java.util.Random;

public class Stack {
    private Item top;

    // basic constructor
    public Stack() {
        this.top = null;
    }

    // parametric constructor
    public Stack(int numItems) {
        Random random = new Random();
        this.top = new Item(random.nextInt(20));
        for (int i = 1; i < numItems; i++) {
            Item newItem = new Item(random.nextInt(20));
            this.push(newItem);
        }
    }

    // methods

    // push item onto top of stack
    public void push(Item newItem) {
        if (this.top != null) {
            newItem.setNext(this.top);
        }
        this.top = newItem;
    }

    // remove and return top item from stack
    public Item pop() {
        Item removed = null;
        if (this.top != null) {
            removed = this.top;
            this.top = this.top.getNext();
        }
        return removed;
    }

    // prints stack
    public void printStack() {
        Item current = this.top;
        while (current != null) {
            current.printItem();
            current = current.getNext();
        }
    }

    // accessor

    public Item getTop() {
        return this.top;
    }

    // mutator

    public void setTop(Item newTop) {
        this.top = newTop;
    }

    public static void main (String[] args) {
        Stack stack = new Stack(5);

        stack.printStack();

        System.out.println("----------------------------");

        stack.push(new Item(1));

        stack.push(new Item(21));

        stack.printStack();

        System.out.println("++++++++++++++++++++++++++++++++");

        Item temp = stack.pop();

        stack.printStack();

        System.out.println("========================================");

        temp.printItem();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
}