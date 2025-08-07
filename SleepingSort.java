class SleepingThread extends Thread {

    private int sortedNum = 0;

    public void setSortedNum(int sortedNum) {
        this.sortedNum = sortedNum;
    }

    public int getSortedNum() {
        return sortedNum;
    }

    @Override
    public void run() {
        super.run();

        try {
            sleep(this.getSortedNum() * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        } finally {
            System.out.printf("Current number is %d\n", this.getSortedNum());
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
    }
}
