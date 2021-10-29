package ds.queue;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.insert(100);
        queue.insert(1000);
        queue.insert(14);
        queue.insert(12);
        queue.insert(109);

        queue.view();

        System.out.println("\n" + queue.remove());

    }
}
