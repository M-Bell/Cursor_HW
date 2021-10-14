package HW9;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> ints = new DoubleLinkedList<>();
        System.out.println("Working with empty list");
        System.out.println("Get last: " + ints.getLast());
        System.out.println("Size: " + ints.size());
        System.out.println("Is empty: " + ints.isEmpty());
        System.out.println();

        System.out.println("Added elements.\nList:");
        ints.addFirst(1);
        ints.addFirst(2);
        ints.addFirst(3);
        ints.addLast(8);
        ints.addLast(7);
        ints.addLast(6);

        for (Integer a:ints) {
            System.out.println(a);
        }

        System.out.println();
        System.out.println("Working with list with data");
        System.out.println("Get last: " + ints.getLast());
        System.out.println("Get first: " + ints.getFirst());
        System.out.println("Get at existing index (3): " + ints.getAt(3));
        System.out.println("Get at un-existing index(120): " + ints.getAt(120));
        System.out.println("Size: " + ints.size());
        System.out.println("Is empty: " + ints.isEmpty());
        System.out.println("Contains 1: " + ints.contains(1));
        System.out.println("Contains 123: " + ints.contains(123));
        System.out.println("Added element at index 3: ");
        ints.addAt(77, 3);
        for (Integer a:
             ints) {
            System.out.println(a);
        }

        System.out.println("\nRemoved first and last elements");
        ints.removeFirst();
        ints.removeLast();
        for (Integer a:
                ints) {
            System.out.println(a);
        }
        System.out.println("\nRemoved element at 2 index");
        ints.removeAt(2);
        for (Integer a:
                ints) {
            System.out.println(a);
        }

        System.out.println("\nList cleared:");
        ints.clear();
        System.out.println("Is empty: " + ints.isEmpty());

        System.out.println();
    }
}
