class ThreadClass extends Thread {
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

public class SleepSort {

    public static void main(String[] args) {
        for (String arg : args) {
            ThreadClass threadClass = new ThreadClass();
            threadClass.setSortedNum(Integer.parseInt(arg));
            threadClass.start();
        }
    }
}
