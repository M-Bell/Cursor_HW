package HW9.Tests;

import HW9.DoubleLinkedList;

import java.util.NoSuchElementException;

public class UT {
    public static void main(String[] args) {
        /* Check adding and deleting elements */
        CheckCorrectFirstElementAdding();
        CheckCorrectLastElementAdding();
        CheckCorrectIndexElementAdding();
        CheckCorrectFirstElementDeleting();
        CheckCorrectLastElementDeleting();
        CheckCorrectIndexElementDeleting();
    }

    private static void CheckCorrectIndexElementDeleting() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = -30; i < 30; i++) {
            list.addFirst(i);
        }

        for (int i = 0; i < 20; i++) {
            Integer deleted = list.getAt(i);
            list.removeAt(i);
            if (list.getAt(i).equals(deleted)) {
                throw new NoSuchElementException();
            }
        }
    }

    private static void CheckCorrectIndexElementAdding() {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        list.addFirst(1.0);
        list.addFirst(2.0);
        list.addFirst(3.0);
        list.addFirst(4.0);
        list.addFirst(5.0);
        list.addFirst(6.0);
        list.addFirst(7.0);
        for (int i = 0; i < 30; i++) {
            list.addAt(77.0, i);
            if (!list.getAt(i).equals(77.0)) {
                throw new NoSuchElementException();
            }
        }
    }

    private static void CheckCorrectLastElementDeleting() {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        for (double i = -30; i < 30; i += 0.2) {
            list.addFirst(i);
        }
        for (double i = -30; i < 29; i += 0.2) {
            Double data = list.getLast();
            list.removeLast();
            if (list.getLast().equals(data)) {
                throw new NoSuchElementException();
            }
        }
    }

    private static void CheckCorrectFirstElementDeleting() {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        for (double i = -30; i < 30; i += 0.2) {
            list.addFirst(i);
        }
        for (double i = -30; i < 29; i += 0.2) {
            Double data = list.getFirst();
            list.removeFirst();
            if (list.getFirst().equals(data)) {
                throw new NoSuchElementException();
            }
        }
    }

    private static void CheckCorrectLastElementAdding() {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        for (double i = -30; i < 30; i += 0.3) {
            list.addLast(i);
            if (!list.getLast().equals(i)) {
                throw new NoSuchElementException();
            }
        }
    }

    private static void CheckCorrectFirstElementAdding() {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        for (double i = -30; i < 30; i += 0.3) {
            list.addFirst(i);
            if (!list.getFirst().equals(i)) {
                throw new NoSuchElementException();
            }
        }
    }
}
