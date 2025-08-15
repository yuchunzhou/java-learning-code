import java.util.Arrays;

public class BinarySearch {

    private boolean search(int[] searchedNums, int searchedNum) {
        if (searchedNums.length == 1) {
            return searchedNums[0] == searchedNum;
        }

        int mid = searchedNums.length / 2;

        if (searchedNums[mid] == searchedNum) {
            return true;
        } else if (searchedNums[mid] > searchedNum) {
            return this.search(Arrays.copyOfRange(searchedNums, 0, mid), searchedNum);
        } else {
            return this.search(Arrays.copyOfRange(searchedNums, mid, searchedNums.length), searchedNum);
        }
    }

    public static void main(String[] args) {
        int[] searchedNums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            searchedNums[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(searchedNums);

        System.out.printf("searched numbers: %s\n", Arrays.toString(searchedNums));

        int searchedNum = Integer.parseInt(args[args.length - 1]);
        System.out.printf("searched number: %s\n", searchedNum);

        BinarySearch binarySearch = new BinarySearch();
        System.out.printf("find it? %s\n", binarySearch.search(searchedNums, searchedNum));
    }
}
