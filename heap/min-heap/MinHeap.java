// implementation of a min-heap in Java with the use of arrays
// based on https://www.youtube.com/watch?v=t0Cq6tVNRBA
// -------------------------------------------------------------------
// ideas for future implementation:
// - use arraylist instead of arrays??
// - try and do heap with nodes

import java.util.Arrays;

public class MinHeap {
    private int capacity;
    private int size = 0;
    private int[] items;

    // a min-heap has the smallest element as the root
    // the rule with a min-heap is that if a node has child nodes, 
    // its children will be bigger than the parent. Left child nodes do not 
    // necessarily need to be smaller than right child nodes.

    // basic constructor
    public MinHeap() {
        this.capacity = 10;

        items = new int[capacity];
        
    }

    // parametric constructor
    public MinHeap(int[] arr) {
        this.capacity = arr.length;
        
        items = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            printHeap();
            System.out.println("Adding " + arr[i] + ": ");
            add(arr[i]);
            printHeap();
            System.out.println("======================================");
        }

    }

    // methods

    // looks at the array and returns the first element (at index 0 - the root of the heap) if the array isn't empty
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return this.items[0];
    }

    // looks at the array, finds the smallest element (the first element in a sorted min-heap), extracts it from the array and returns it
    // the first element is replaced by the last element in the array
    public int pull() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = this.items[0];
        this.items[0] = this.items[size - 1];
        size--;         // doesn't change the array's capacity, just the class' attribute keeping track of how big it is
        heapifyDown();
        return item;
    }

    // adding an element to the bottom of the tree/heap/array
    public void add(int item) {
        ensureExtraCapacity();
        this.items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;       // last item in the array/heap
        while ((hasParent(index)) && (parent(index) > this.items[index])) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if ((hasRightChild(index)) && (rightChild(index) < leftChild(index))) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (this.items[index] < this.items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }



    // helper methods
    // get parent and child indexes
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    } 

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }


    // check if a particular element has a parent or children
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;     // if the index of the potential child is larger than the size of the array, then the child doesn't exist
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;      // if the parent index is more than or equal to zero, it exists. The only element without a parent will be the root.
    }

    // returns the children or parent of an element if they exist
    private int leftChild(int index) {
        return this.items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return this.items[getParentIndex(index)];
    }
 
    // swap two elements in the array
    // internal method
    private void swap(int index1, int index2) {
        int temp = this.items[index1];
        this.items[index1] =  items[index2];
        this.items[index2] = temp;
    }

    // doubles capacity when array reaches limit
    // internal method
    private void ensureExtraCapacity() {
        if (size == capacity) {
            this.items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    // prints the heap (this.items)
    public void printHeap() {
        if (size == 0) {
            System.out.println("Heap is empty.");
        } else {
            System.out.print("[");
            for (int i = 0; i < size-1; i++) {
                System.out.print(this.items[i] + ", ");
            }
            System.out.println(this.items[size - 1] + "]");
        }
    }

    
    public static void main(String[] args) {

        // the min-heap array means i need to take the last element and put it at the top

        int[] arr = {9, 4, 3, 5, 1, 7, 2};

        printArray(arr);

        MinHeap minHeap = new MinHeap(arr);
        
        minHeap.pull();

        minHeap.printHeap();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
    }

    // static methods

    // prints arrays declared and initialised in the main method
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

}