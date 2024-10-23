class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class JoinMethodExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.join(); // Wait for thread1 to finish
        System.out.println("Thread has finished execution.");
    }
}