import java.util.Arrays;

public class SelectionSort {

    private int[] sort(int[] sortedNums) {
        for (int i = 0; i < sortedNums.length; i++) {
            int min_num_index = i;

            for (int j = i + 1; j < sortedNums.length; j++) {
                if (sortedNums[j] < sortedNums[min_num_index]) {
                    min_num_index = j;
                }
            }

            if (i != min_num_index) {
                int tmp = sortedNums[i];
                sortedNums[i] = sortedNums[min_num_index];
                sortedNums[min_num_index] = tmp;
            }

        }

        return sortedNums;

    }

    public static void main(String[] args) {
        int[] sortedNums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sortedNums[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("sorted numbers: %s\n", Arrays.toString(sortedNums));

        SelectionSort selectionSort = new SelectionSort();
        int[] sortedResult = selectionSort.sort(sortedNums);

        System.out.printf("sorted result: %s\n", Arrays.toString(sortedResult));
    }
}
