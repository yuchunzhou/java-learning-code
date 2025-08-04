import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    private int[] sort(int[] sortedNums) {
        if (sortedNums.length <= 1) {
            return sortedNums;
        }

        int pivot = sortedNums[0];
        ArrayList<Integer> leftArrayList = new ArrayList<Integer>();
        ArrayList<Integer> rightArrayList = new ArrayList<Integer>();

        for (int i = 1; i < sortedNums.length; i++) {
            if (sortedNums[i] < pivot) {
                leftArrayList.add(sortedNums[i]);
            } else {
                rightArrayList.add(sortedNums[i]);
            }
        }

        int[] result = new int[sortedNums.length];

        int[] leftArray = this.sort(leftArrayList.stream().mapToInt(n -> n).toArray());
        System.arraycopy(leftArray, 0, result, 0, leftArray.length);

        result[leftArray.length] = pivot;

        int[] rightArray = this.sort(rightArrayList.stream().mapToInt(n -> n).toArray());
        System.arraycopy(rightArray, 0, result, leftArray.length + 1, rightArray.length);

        return result;
    }

    public static void main(String[] args) {
        int[] sortedNums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sortedNums[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("sorted numbers: %s\n", Arrays.toString(sortedNums));

        QuickSort quickSort = new QuickSort();
        int[] sortedResult = quickSort.sort(sortedNums);

        System.out.printf("sorted result: %s\n", Arrays.toString(sortedResult));
    }
}
