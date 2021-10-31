package ds.mergesort;

public class MergeSort {

    //main function that sorts arr[l...r] using merge()
    public void sort(int arr[], int l, int r) {
        System.out.println("splitting l r: " + l + " " + r);
        if(l < r) {
            //find the middle point
            int m = (l+r)/2;

            //sort first and second halves
            sort(arr, l, m);
            sort(arr, m+1, r);

            //merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //merge two subarrays of arr[].
    //first subarray is arr[l...m]
    //second subarray is arr[m+1..r]
    public void merge(int arr[], int l, int m, int r) {
        System.out.println("merge l m r:" + l + " " + m + " " + r);

        //find sizes of two subarrays to be merged
        int n1 = m-l+1;
        int n2 = r-m;

        //create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //copy data to temp arrays
        for (int i = 0; i < n1 ; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        //merge the temp array

        //initial indices of first and second subarrays
        int i = 0, j=0;

        //inital index of merged subarray array
        int k = l;

        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of L[] if any
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //copy remaining elements of R[] if any
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        System.out.println("After merge");
        printArray(arr);

    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i <n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();

    }



}
