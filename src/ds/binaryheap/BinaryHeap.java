package ds.binaryheap;

import java.util.Arrays;

public class BinaryHeap {
    private int capacity = 10;
    private int size = 0;

    public int[] items = new int[capacity];

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }


    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }
    private boolean hasParent(int index) {
        return parentIndex(index) > 0;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }
    private int parent(int index) {
        return items[parentIndex(index)];
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void insert(int item) {
        ensureCapacity();  //make sure we have enough space in the array
        items[size] = item;  // put in last spot
        size++;              // increment count
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;  //start at the last element

        //while my parents are less than me
        while (hasParent(index) && parent(index) < items[index]) {
            //swap the index
            swap(parentIndex(index), index);
            // keep walking up the tree recursively to replace smaller parent with its child
            index = parentIndex(index);
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];   //grab the max
        items[0] = items[size - 1]; //swap top and bottom
        size--;
        heapifyDown();
        return item;
    }


    public void heapifyDown() {
        int index = 0;  //start at the top

        //as long as i have children
        //only need to check left because if no left, there is no right
        while(hasLeftChild(index)) {

            //take the larger of the two indices
            int largerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = rightChildIndex(index);
            }

            //compare
            //parent larger than both its children
            if(items[index] > items[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }

            //then move down to smaller child
            index = largerChildIndex;

        }
    }

    public void print() {
        for (int i = 0; i < size ; i++) {
            System.out.println(i + "[" + items[i] + "]");
        }
    }


    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }


}
