package ds.queue;

public class Queue {

    private int maxSize;
    private long[] qArray= new long[maxSize];

    private int front;   //index position of the element in the front
    private int rear;    //index position of the element in the back
    private int nItems;  //counter to record the number of items in our queue

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.qArray = new long[maxSize]; //initialize the array

        front = 0;     //index position of the first element
        rear = -1;     //no item in the array yet
        nItems = 0;    //no elements in the array yet

    }

    public void insert(long j){
        if(rear == maxSize -1){    //
            rear = -1;
        }
        rear++;
        qArray[rear] = j;
        nItems++;
    }

    public long remove(){
        long temp = qArray[front];
        front++;
        if(front == maxSize)
            front = 0;        //removed everything
        nItems--;
        return temp;
    }

    public long peekFront(){
        return qArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public void view(){
        System.out.print("[ ");
        for (int i = 0; i <qArray.length; i++) {
            System.out.print(qArray[i]+ " ");
        }
        System.out.print(" ]");
    }


}
