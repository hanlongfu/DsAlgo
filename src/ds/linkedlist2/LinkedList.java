package ds.linkedlist2;

public class LinkedList {

    //Node class
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
        }
    }

    private Node head;

    public void addFront(int data){
        //create new node
        Node newNode = new Node(data);

        //if head
        if(head == null){
            head = newNode;
            return;
        }

        //set newNode's next to the current head
        newNode.next = head;

        // set current head be the new head
        head = newNode;
    }

    public int getFirst(){
        //if head==null
        return head.data;
    }

    public int getLast(){
        if(head == null){
            throw new IllegalStateException("Empty list!");
        }

        Node current = head;

        //while we are not at the tail
        while(current.next != null){
            current = current.next;   //O(N)
        }

        //we are at the tail
        return current.data;

    }

    public void addBack(int data){
        Node newNode = new Node(data);

        //if head...set and return
        if(head == null){
            head = newNode;
            return;
        }

        //start at the head
        Node current = head;

        //traverse the list
        while(current.next != null){
            current = current.next;
        }

        //we are at the tail
        current.next = newNode;

    }


    public void print(){
        Node current = head;
        while(current.next != null){
            System.out.print("[ " + current.data + " ]");
            current = current.next;
        }
        System.out.print("[ " + current.data + " ]");

    }


    public int size() {
        if(head == null){
            return 0;
        } else {
            int count = 1;
            Node current = head;

            while(current.next != null){
                current = current.next;
                count ++;
            }
            return count;
        }
    }

    public void clear(){
        head = null;
    }

    public void delete(int data){

        //empty list
        if(head == null){
            return;
        }

        //remove the first element
        if(head.data == data){
            head = head.next;
            return;
        }

        //remove a middle value
        Node current = head;
        while(current.next != null){

            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

    }








}
