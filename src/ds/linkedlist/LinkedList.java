package ds.linkedlist;

public class LinkedList {

    //head is null by default
    Node head;

    //insert at the end
    public void insert(int data){
        //create a new node
        Node node = new Node();
        node.data = data;
        node.next = null;    //not absolutely necessary

        if(head == null){  //first node
            head = node;
        } else {           //there are other nodes
            Node n = head;
            //traverse the list
            while(n.next != null){
                //move to the next node
                //when finished, n is the last node
                n = n.next;
            }
            //assign the new node to the last node
            n.next = node;
        }

    }


    //insert at the start
    public void insertAtStart(int data){
        //the following three lines create a new node
        Node node = new Node();
        node.data = data;
        node.next = null;

        //previous head becomes the second node
        node.next = head;
        //inserted node becomes the head
        head = node;

    }

    //insert at any location
    public void insertAt(int index, int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(index==0){
            insertAtStart(data);
            return;
        }

        Node n = head;
        for(int i=0; i<index-1; i++){
            n = n.next;
        }
        node.next = n.next;
        n.next=node;

    }

    //delete a node
    public void deleteAt(int index){
        //delete the first node
        if(index == 0){
            head = head.next;
        } else{  //delete a node in the middle
            Node n = head;
            Node n1 = null;
            for (int i = 0; i <index-1; i++) {     //traversing a list
                n = n.next;
            }
            n1 = n.next;  //n1 is the element after n
            n.next = n1.next;
            System.out.println(n1.data + " has been deleted");
            n1 = null;    //remove n1 for garbage collection
        }

    }

    //print the value
    public void show(){
        Node node = head;
        while(node.next != null){
            System.out.println(node.data);
            //move to the next node
            node = node.next;
        }

        System.out.println(node.data);
    }













}
