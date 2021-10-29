package ds.linkedlist;

public class Main {

    public static void main(String[] args) {

       LinkedList list = new LinkedList();
       list.insert(5);
       list.insert(10);
       list.insert(11);
       list.insert(100);
       //list.insertAtStart(25);
       list.insertAt(2, 555555);
       list.insertAt(0, 1984);

       list.show();

       list.deleteAt(1);
    }



}
