package HW9;
/*
 * Structure: Double Linked List
 * Author: Maksym Shyiko
 * * * * * * * * * * * * * * * * * * * *
 * Functions:
 * Add/Get/Remove first element
 * Add/Get/Remove last element
 * AddAt/GetAt/RemoveAt certain index
 * Size
 * Contains
 * Clear
 * IsEmpty
 * Implemented interface Iterable
 */

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {
    private Node head;
    private int size = 0;

    public void addFirst(T item) {
        size++;
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addLast(T item) {
        size++;
        if (head == null) {
            addFirst(item);
            return;
        }
        Node newNode = new Node();
        newNode.data = item;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void addAt(T item, int index) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        size++;
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (counter == index) {
                Node newNode = new Node();
                newNode.data = item;
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                temp.prev = newNode;
                newNode.next = temp;
                return;
            }
            temp = temp.next;
            counter++;
        }
    }

    public void clear() {
        size = 0;
        head = null;
    }

    public void removeFirst() {
        if (head == null) return;
        size--;
        head = head.next;
        if (head == null) return;
        if (head.prev != null) {
            head.prev = null;
        }
    }

    public void removeLast() {
        if (head == null) return;
        size--;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = null;
        } else {
            head = null;
        }
    }

    public void removeAt(int index) {
        if (index >= size) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        size--;
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (counter == index) {
                Node previousNode = temp.prev;
                Node nextNode = temp.next;
                previousNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = previousNode;
                }
                return;
            }
            temp = temp.next;
            counter++;
        }
    }

    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    public T getLast() {
        if (head == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T getAt(int index) {
        if (head == null) return null;
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (counter == index) {
                return temp.data;
            }
            temp = temp.next;
            counter++;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean contains(T item) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(item)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T out = temp.data;
                temp = temp.next;
                return out;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("DoubleLinkedList: ");
        Node temp = head;
        while (temp != null) {
            res.append("\n").append(temp).append(";");
            temp = temp.next;
        }
        return res.toString();
    }

    private class Node {
        private T data;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return "Data: " + data;
        }
    }
}
