public class Test {
    public static void main(String[] args) {
        System.out.println("Task 1: ");
        for (double i = 0; i < 2; i+=0.5) {
            Circle circle = new Circle(i);
            System.out.println("Circle radius = " + i + ";\nCircle area = " + circle.getArea() + "\n");
        }

        System.out.println("Task 2: ");
        Car car1 = new Car();
        System.out.println("Car 1:");
        System.out.println(car1);
        System.out.print("Drive func if engine stopped --- ");
        car1.drive();
        System.out.print("Start engine --- ");
        car1.start();
        System.out.print("Drive func if engine started  --- ");
        car1.drive();
        System.out.println("Car 1:");
        System.out.println(car1);
        System.out.print("Acceleration func --- ");
        car1.accelerate(10);
        System.out.println("Car 1:");
        System.out.println(car1);
        System.out.print("Stop engine --- ");
        car1.stop();
        System.out.println("Car 1:");
        System.out.println(car1);

        System.out.println("Task 3: ");
        Money amount1 = new Money(100, (byte) 25);
        Money amount2 = new Money(10, (byte) 50);
        System.out.println("Value 1: " + amount1);
        System.out.println("Value 2: " + amount2);
        System.out.println("Value 1 + Value 2 = " + Money.add(amount1, amount2));
        System.out.println("Value 1 - Value 2 = " + Money.subtract(amount1, amount2));
        System.out.println("Value 1 * Value 2 = " + Money.multiply(amount1, amount2));
        System.out.println("Value 1 * 0.74 = " + Money.multiply(amount1, new Money(0.74)));
        System.out.println("Value 1 / Value 2 = " + Money.divide(amount1, amount2));
        System.out.println("Value 1 / 0.26 = " + Money.divide(amount1, new Money(0.26)));
        System.out.println("Value 1 > Value 2 = " + Money.more(amount1, amount2));
        System.out.println("Value 1 == Value 2 = " + Money.equal(amount1, amount2));
        System.out.println("Value 1 == Value 1 = " + Money.equal(amount1, amount1));
        System.out.println("Value 1 < Value 2 = " + Money.less(amount1, amount2));


    }
}
