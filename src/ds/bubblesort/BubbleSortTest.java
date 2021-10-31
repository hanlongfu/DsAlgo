package ds.bubblesort;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] numbers = {7, 100, 1, 4, 6, 2};
        BubbleSort bs = new BubbleSort();

        int[] numbers_sorted = bs.sort(numbers);

        for (int i = 0; i < numbers_sorted.length ; i++) {
            System.out.println(numbers_sorted[i]);
        }


    }

}

