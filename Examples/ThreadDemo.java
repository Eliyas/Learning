class Counter extends Thread {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Counter counter1 = new Counter(5);
        Counter counter2 = new Counter(5);

        counter1.start(); // Start thread 1
        counter2.start(); // Start thread 2
    }
}
