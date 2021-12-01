public class Main {

    public static void main(String[] args) {
        // String[] stuff = {"apple", "banana", "carrot", "diamond", "egg"};

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(1);

        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        bst.insert(3);
        bst.insert(5);
    
        bst.printBST();
    }

}
