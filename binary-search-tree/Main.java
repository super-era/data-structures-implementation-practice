public class Main {

    public static void main(String[] args) {
        // String[] stuff = {"apple", "banana", "carrot", "diamond", "egg"};

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(1);

        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        // bst.setRoot(new Node(1));
        // bst.getRoot().setLeft(new Node(2));
        // bst.getRoot().setRight(new Node(3));
        // bst.getRoot().getLeft().setLeft(new Node(4));
        // bst.getRoot().getLeft().setRight(new Node(5));
    
        bst.printBST();
    }

}