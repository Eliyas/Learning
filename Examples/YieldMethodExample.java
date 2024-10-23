class YieldExample extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 3) {
                System.out.println(Thread.currentThread().getName() + " yielding...");
                Thread.yield(); // Yield the current thread
            }
        }
    }
}

public class YieldMethodExample {
    public static void main(String[] args) {
        YieldExample thread1 = new YieldExample();
        YieldExample thread2 = new YieldExample();
        thread1.start();
        thread2.start();
    }
}
