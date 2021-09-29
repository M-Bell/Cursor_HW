package HW3;

public class Money {
    private long bills;
    private byte coins;

    public Money(long bills, byte coins) {
        this.bills = bills;
        this.coins = coins;
    }

    public Money(double value) {
        this.bills = (long) value;
        this.coins = (byte) ((value - bills) * 100);
    }

    public static Money add(Money val1, Money val2) {
        return new Money(val1.getNumericValue() + val2.getNumericValue());
    }

    public static Money subtract(Money val1, Money val2) {
        return new Money(val1.getNumericValue() - val2.getNumericValue());
    }

    public static Money multiply(Money val1, Money val2) {
        return new Money(val1.getNumericValue() * val2.getNumericValue());
    }

    public static Money divide(Money val1, Money val2) {
        return new Money(val1.getNumericValue() / val2.getNumericValue());
    }

    public static boolean more(Money val1, Money val2) {
        return val1.getNumericValue() > val2.getNumericValue();
    }

    public static boolean equal(Money val1, Money val2) {
        return val1.getNumericValue() == val2.getNumericValue();
    }

    public static boolean less(Money val1, Money val2) {
        return val1.getNumericValue() < val2.getNumericValue();
    }

    public double getNumericValue() {
        return bills + (double) coins / 100;
    }

    @Override
    public String toString() {
        return bills + "," + coins;
    }
}