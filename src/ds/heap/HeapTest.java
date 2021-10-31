package ds.heap;

public class HeapTest {
    public static void main(String[] args) {

        Heap heap = new Heap(5);

        heap.insert(1);
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        System.out.println(heap.getSize());


    }

}
