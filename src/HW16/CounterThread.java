package HW16;

public class CounterThread extends Thread {

    private final Base base;
    private int number;

    public CounterThread(Base base, int number) {
        this.base = base;
        this.number = number;

    }

    @Override
    public void run() {
        synchronized (base) {
            for (int i = 0; i < 10; i++) {
                base.notify();
                try {
                    System.out.println("Thread " + (number % 2 == 0 ? 2 : 1) + ": " + number);
                    base.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.number += 2;
            }
        }
    }
}
