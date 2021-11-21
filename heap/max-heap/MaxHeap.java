import java.util.Arrays;

public class MaxHeap {
    private int capacity;       // the maximum number of elements that the 'items' array can hold at this time
    private int size = 0;       // the number of elements the 'items' array holds at the moment
    private int[] items;

    // a max-heap is the opposite of a min-heap - the parent element is always larger than the two child elements.
    // once again, the left element does not have to be bigger than the right element, which means that the heap
    // is unlikely to be fully sorted at first glance.

    // basic constructor
    public MaxHeap() {
        this.capacity = 10;
        this.items = new int[capacity];
    }

    // parametric constructor
    public MaxHeap(int[] arr) {
        this.capacity = arr.length;
        this.items = new int[this.capacity];

        for (int i = 0; i < this.capacity; i++) {
            add(arr[i]);
        }
    } 
    
    // methods

    // returns the first element of the array (largest element)
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        } else {
            return items[0];
        }
    }

    // removes the root (e.g. the largest number in the heap) and replaces it with the last element in the heap array
    // returns the removed root
    public int pull() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int num = this.items[0];
        this.items[0] = this.items[size - 1];
        size--;
        heapifyDown();
        return num;
    }

    // adds an element to the array and heapifyUps it
    public void add(int num) {
        ensureExtraCapacity();
        this.items[size] = num;
        size++;
        heapifyUp();
    }

    // turns the array into a heap from the bottom up
    public void heapifyUp() {
        int index = size - 1;       // last element in heap
        while ((hasParent(index)) && (parent(index)) < this.items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // turns the array into a heap from the top down
    public void heapifyDown() {
        int index = 0;      // root
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if ((hasRightChild(index)) && (rightChild(index) > leftChild(index))) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (this.items[index] > this.items[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }

    // helper methods

    // returns the indexes of the parent and left and right children (if present), based on an index in the argument
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // checks if an element at a particular index has a parent or left/right children
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // returns the parent and children of an element at a particular index
    public int leftChild(int index) {
        return this.items[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return this.items[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return this.items[getParentIndex(index)];
    }

    // swaps two elements by index
    public void swap(int index1, int index2) {
        int temp = this.items[index1];
        this.items[index1] = this.items[index2];
        this.items[index2] = temp;
    }

    // doubles heap capacity if items array is full
    public void ensureExtraCapacity() {
        if (capacity == size) {
            this.items = Arrays.copyOf(this.items, capacity * 2);
            capacity *= 2;
        }
    }

    // prints heap
    public void printHeap() {
        if (size == 0) {
            System.out.println("The heapis empty.");
        } else {
            System.out.print("[");
            for (int i = 0; i < size - 1; i++) {
                System.out.print(this.items[i] + ", ");
            }
            System.out.println(this.items[size - 1] + "]");
        }
    }

    public static void main(String[] args) {

        // the max-heap array means i need to take the last element and put it at the top

        int[] arr = {9, 4, 3, 5, 1, 7, 2};

        System.out.print("original input: ");
        printArray(arr);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");

        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.print("adding and heapifying up each time: ");
        maxHeap.printHeap();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
        
        maxHeap.pull();
        System.out.print("removing the first element, putting the last element first, and heapifying up: ");
        maxHeap.printHeap();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");


        
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
