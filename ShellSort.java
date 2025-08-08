import java.util.Arrays;

public class ShellSort {
    private int getInterval(int length) {
        return length / 2;
    }

    private int[] sort(int[] sortedNums) {
        int interval = getInterval(sortedNums.length);

        while (interval != 0) {
            for (int i = 0; i < sortedNums.length; i++) {
                for (int j = 0; j < sortedNums.length; j += interval) {
                    if (sortedNums.length > j + interval && sortedNums[j] > sortedNums[j + interval]) {
                        int tmp = sortedNums[j];
                        sortedNums[j] = sortedNums[j + interval];
                        sortedNums[j + interval] = tmp;
                    }
                }
            }

            interval = getInterval(interval);
        }

        return sortedNums;
    }

    public static void main(String[] args) {
        int[] sortedNums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sortedNums[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("sorted numbers: %s\n", Arrays.toString(sortedNums));

        ShellSort shellSort = new ShellSort();
        int[] sortedResult = shellSort.sort(sortedNums);

        System.out.printf("sorted result: %s\n", Arrays.toString(sortedResult));
    }
}
