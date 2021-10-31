package ds.binaryheap;

public class BinaryHeapTest {

    public static void main(String[] args) {

        BinaryHeap bh = new BinaryHeap();
        bh.insert(42);
        bh.insert(29);
        bh.insert(18);

        //bh.print();

        bh.insert(35);

        bh.print();

        System.out.println(bh.extractMax());

    }




}
