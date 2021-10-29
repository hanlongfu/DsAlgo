package ds.linkedlist2;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFront(10);
        linkedList.addFront(20);
        linkedList.addFront(30);


//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());

        linkedList.addBack(490);

//        linkedList.print();

        System.out.println(linkedList.size());


    }


}
