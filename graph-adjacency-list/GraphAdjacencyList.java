import java.util.LinkedList;

public class GraphAdjacencyList {
    private LinkedList<LinkedList<Node>> adjList;        // adjacency list
    private Node[] nodeArr;     // list of nodes in the graph regardless of connections

    // // basic constructor - creates empty graph; adjacency list declared
    // public GraphAdjacencyList() {
    //     this.adjListArray = new LinkedList<Node[]>();   // initialise adjListArray
    // }

    // parametric constructor - initialises a linked list, each element of which is an array of nodes 
    public GraphAdjacencyList(int numNodes) {
        this.nodeArr = new Node[numNodes];      // initialise nodeArr
        this.adjList = new LinkedList<LinkedList<Node>>();   // initialise adjListArray
        for (int i = 0; i < numNodes; i++) {
            this.nodeArr[i] = new Node(i);      // creating a new node with an index and adding it to the list of possible nodes in the graph, nodeArr
            this.adjList.add(new LinkedList<Node>());
        }
    }

    // methods

    // {{1}, {0, 2}, {1}}  - example adjacency list
	// 		 0  1  2	
	//    0 |0  1  0	
	//    1 |1  0  1
	//    2 |0  1  0	   - example adjacency matrix
	// {[0, 1, 0], [1, 0, 1], [0, 1, 0]} - example adjacency matrix as array of integer arrays

    // find Node in list of Nodes (nodeArr) by index

    // transform an adjacency matrix into an adjacency list
    public void matrixToList(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    // go to the ith index in adjListArray and add the node with index j to its list
                    this.adjList.get(i).add(this.nodeArr[j]);
                }
            }
        }
    }

    // print out the adjacency list array
    public void displayAdjList() {
        for (int i = 0; i < this.adjList.size(); i++) {
            System.out.print("Node " + i + " is connected to ");
            for (int j = 0; j < this.adjList.get(i).size() - 1; j++) {
                this.adjList.get(i).get(j).printNode();
                System.out.print(", ");
            }
            this.adjList.get(i).get(this.adjList.get(i).size()-1).printNode();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList g1 = new GraphAdjacencyList(3);

        int[][] adjMatrix = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};

        g1.matrixToList(adjMatrix);

        g1.displayAdjList();
    }

}
