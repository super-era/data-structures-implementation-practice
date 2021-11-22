public class Main {
    
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.printQueue();

        System.out.println("======================");

        q.enqueue(9);

        q.printQueue();

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.out.println(q.dequeue().getData());

        System.out.println("----------------------------");

        q.printQueue();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }
}
