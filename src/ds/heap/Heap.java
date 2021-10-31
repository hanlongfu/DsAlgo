package ds.heap;

public class Heap {

    private int maxSize;        //because it is array, we set its maxSize
    private Node[] heapArray;
    private int currentSize;    //number of nodes in the array

    public Heap(int size) {
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }


    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    //insert
    //when we insert, we start from the end of the heap
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            System.out.println("the array is already full");
            return false;
        }

        Node newNode = new Node(key);

        // the index of the next available position in the heap
        heapArray[currentSize] = newNode;

        //move up
        percolate_up(currentSize);

        currentSize++;

        return true;
    }

    public void percolate_up(int index) {

        int parentIndex = (index - 1) / 2;

        // node to insert
        Node nodeToInsert = heapArray[index];

        while(index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {
            //move the parent down
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            //move up
            parentIndex = (parentIndex - 1)/2;
        }

        heapArray[index] = nodeToInsert;

    }


    //delete
    //when we remove, always start from the top of the heap
    public Node remove() {
        Node root = heapArray[0];

        //replace root
        heapArray[0] = heapArray[--currentSize];  //decrement first and reference

        percolate_down(0);

        return root;
    }


    public void percolate_down(int index) {

        int largerChildIndex;

        Node top = heapArray[index];  //save last into top variable

        //will run as long as index is not on the bottom row (at least 1 child)
        while(index < currentSize / 2) {
            //left child index position
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            //test which child is larger
            if(rightChildIndex < currentSize && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }

            //break out of the loop
            if(top.getKey() >= heapArray[largerChildIndex].getKey()){
                //successfully made root the largest key
                break;
            }

            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;    //go down
        }

        heapArray[index] = top;

    }




}
