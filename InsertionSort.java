import java.util.Arrays;

public class InsertionSort {

    private int[] sort(int[] sortedNums) {
        for (int i = 1; i < sortedNums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedNums[j] > sortedNums[i]) {
                    int tmp = sortedNums[i];
                    sortedNums[i] = sortedNums[j];
                    sortedNums[j] = tmp;
                }
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

        InsertionSort insertionSort = new InsertionSort();
        int[] sortedResult = insertionSort.sort(sortedNums);

        System.out.printf("sorted result: %s\n", Arrays.toString(sortedResult));
    }
}
