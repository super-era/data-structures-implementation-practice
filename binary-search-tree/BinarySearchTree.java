public class BinarySearchTree<T extends Comparable<T>>{
    private Node<T> root;

    // basic constructor - empty tree
    public BinarySearchTree() {
        this.root = null;
    }

    // parametric constructor - set root only
    public BinarySearchTree(T data) {
        this.root = new Node<T>(data);
    }

    // parametric constructor - input array of info, turned into nodes
    public BinarySearchTree(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    // methods

    // insert Node into tree by calling recursive method
    public void insert(T data) {
        if (this.root == null) {
            this.root = new Node<T>(data);
        } else {
            insertRec(this.root, data);
        }
    }

    // recursively inserts new Node into tree
    private void insertRec(Node<T> current, T data) {
        Node<T> newNode = new Node<T>(data);
        if (newNode.getData() == current.getData()) {
            System.out.println("This node is already in the tree!");
        } else {
            if (newNode.getData().compareTo(current.getData()) < 0) {
				if (current.getLeft() == null) {
					current.setLeft(newNode);
				} else {
					insertRec(current.getLeft(), data);
				}
			} else if (newNode.getData().compareTo(current.getData()) > 0) {
				if (current.getRight() == null) {
					current.setRight(newNode);
				} else {
					insertRec(current.getRight(), data);
				}
			}
        }
    }

    // searches BST for some data by calling recursive method
    public boolean search(T data) {
        if (this.root == null) {
            System.out.println("The binary search tree is empty!");
            return false;
        } else {
            return searchRec(this.root, data);
        }
    }

    // recursively searches each node's children for the data in the argument
    public boolean searchRec(Node<T> current, T data) {
        if (current != null) {
			if (data.compareTo(current.getData()) < 0) {
			return searchRec(current.getLeft(), data);
			} else if (data.compareTo(current.getData()) > 0) {
			return searchRec(current.getRight(), data);
			} else {
				System.out.println(data + " has been found in the binary tree!");
				return true;
			}
		} else {
			System.out.println(data + " is not in the binary tree.");
			return false;
		}
	}

	// prints a binary search tree
	public void printBST() {
		if (this.root == null) {
			System.out.println("The binary search tree is empty.");
		} else {
			System.out.print("In-order: ");
			printBSTRecInorder(this.root);
			System.out.print("Pre-order: ");
			printBSTRecPreorder(this.root);
			System.out.print("Post-order: ");
			printBSTRecPostorder(this.root);
		}
	}

	// recursively prints each node in the tree in-order
	private void printBSTRecInorder(Node<T> node) {
		String binary_tree = "";
		if (node == null) {
			return;
		}
		printBSTRecInorder(node.getLeft());
		binary_tree += node.getData() + ", ";
		System.out.print(binary_tree);
		printBSTRecInorder(node.getRight());
	}
	
	// recursively prints each node in the tree pre-order
	private void printBSTRecPreorder(Node<T> node) {
		String binary_tree = "";
		if (node == null) {
			return;
		}
		binary_tree += node.getData() + ", ";
		System.out.print(binary_tree);
		printBSTRecPreorder(node.getLeft());
		printBSTRecPreorder(node.getRight());
	}
	
	// recursively prints each node in the tree pre-order
	private void printBSTRecPostorder(Node<T> node) {
		if (node == null) {
			return;
		}
		printBSTRecPostorder(node.getLeft());
		printBSTRecPostorder(node.getRight());
		System.out.print(node.getData() + ", ");
	}
	

	// accessor

	public Node<T> getRoot() {
		return this.root;
	}


	// mutator (not strictly necessary)

	public void setRoot(Node<T> newRoot) {
		this.root = newRoot;
	}

}