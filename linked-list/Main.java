public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList(10, false);

        list1.addNode(3);

        list1.printList();

        System.out.println("------------------------------------------");

        System.out.println("Sorted list: ");

        printOrder(false);

        list1.sortList(list1, false);

        list1.printList();

        System.out.println("------------------------------------------");

        list1.findNodeByData(3);

        System.out.println("------------------------------------------");

        list1.removeNodeByData(3);

        System.out.println("------------------------------------------");

        list1.printList();

    }

    public static void printOrder(boolean descending) {
        if (descending) {
            System.out.println("(descending order)");
        } else {
            System.out.println("(ascending order)");
        }
    }
}