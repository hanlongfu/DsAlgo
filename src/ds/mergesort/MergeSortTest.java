package ds.mergesort;

public class MergeSortTest {

    public static void main(String[] args) {

        int arr[] = {4, 7, 14, 1, 3, 9, 17};
        int l = 0;                 //left pointer
        int r = arr.length - 1;    //right pointer

        MergeSort ms = new MergeSort();
        ms.sort(arr, l, r);


    }


}
