public class SharedCounter implements Runnable {

    private static int counter = 0;

    synchronized private static void increment() {
        SharedCounter.counter++;
    }

    @Override
    public void run() {
        increment();
    }

    public static void main(String[] args) {
        int countTimes = Integer.parseInt(args[0]);
        Thread[] threads = new Thread[countTimes];

        for (int i = 0; i < countTimes; i++) {
            SharedCounter sharedCounter = new SharedCounter();
            Thread thread = new Thread(sharedCounter);
            threads[i] = thread;
            thread.start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }

        System.out.printf("counter's value: %d\n", SharedCounter.counter);
    }
}
