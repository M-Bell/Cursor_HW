package HW16;

public class Test {
    public static void main(String[] args) {
        Base base = new Base();
        CounterThread ct1 = new CounterThread(base, 1);
        CounterThread ct2 = new CounterThread(base, 2);

        ct1.start();
        ct2.start();
    }
}
