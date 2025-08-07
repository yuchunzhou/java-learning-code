import java.util.ArrayList;
import java.util.Arrays;

class SleepingThread extends Thread {

    private int sortedNum = 0;
    private static ArrayList<Integer> sortedResult = new ArrayList<>();

    public void setSortedNum(int sortedNum) {
        this.sortedNum = sortedNum;
    }

    synchronized private static void updateSortedResult(int sortedNum) {
        sortedResult.add(sortedNum);
    }

    public static int[] getSortedResult() {
        return sortedResult.stream().mapToInt(t -> t).toArray();
    }

    @Override
    public void run() {
        super.run();

        try {
            sleep(sortedNum * 10);
            updateSortedResult(sortedNum);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}

public class SleepingSort {

    public static void main(String[] args) {
        SleepingThread[] sleepingThreads = new SleepingThread[args.length];

        for (int i = 0; i < args.length; i++) {
            SleepingThread sleepingThread = new SleepingThread();
            sleepingThread.setSortedNum(Integer.parseInt(args[i]));
            sleepingThread.start();
            sleepingThreads[i] = sleepingThread;
        }

        for (int i = 0; i < sleepingThreads.length; i++) {
            try {
                sleepingThreads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }

        System.out.printf("sorted result: %s\n", Arrays.toString(SleepingThread.getSortedResult()));
    }
}
