import java.util.Arrays;

public class BubbleSort {

    private int[] sort(int[] sortedNums) {
        for (int i = 0; i < sortedNums.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < sortedNums.length - 1; j++) {
                if (sortedNums[j] > sortedNums[j + 1]) {
                    int tmp = sortedNums[j + 1];
                    sortedNums[j + 1] = sortedNums[j];
                    sortedNums[j] = tmp;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
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

        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedResult = bubbleSort.sort(sortedNums);

        System.out.printf("sorted result: %s\n", Arrays.toString(sortedResult));
    }
}
