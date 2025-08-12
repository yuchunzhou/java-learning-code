import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort {

    private int[] sort(int[] sortedNums) {
        int[] count = new int[Arrays.stream(sortedNums).max().getAsInt() + 1];
        List<Integer> sortedNums_ = Arrays.stream(sortedNums).boxed().collect(Collectors.toList());

        for (int sortedNum : sortedNums) {
            count[sortedNum] = Collections.frequency(sortedNums_, sortedNum);
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] output = new int[Arrays.stream(count).max().getAsInt()];
        for (int sortedNum : sortedNums) {
            int index = count[sortedNum] - 1;
            output[index] = sortedNum;
            count[sortedNum]--;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] sortedNums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sortedNums[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("sorted numbers: %s\n", Arrays.toString(sortedNums));

        CountingSort countingSort = new CountingSort();
        System.out.printf("sorted result: %s\n", Arrays.toString(countingSort.sort(sortedNums)));
    }
}
