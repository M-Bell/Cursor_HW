package HW10.Task3;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> input = Stream.of("John", "Smith", "John", "Doe", "Jane", "Doe");

        PersonList out = input.collect(toPersonList());
        for (Person p: out) {
            System.out.println(p);
        }

    }

    public static Collector<String, ?, PersonList> toPersonList() {
        return Collectors.collectingAndThen(Collectors.toList(), PersonList::new);
    }

    static class PersonList extends AbstractList<Person> {
        private final List<String> elements;
        private final int addSize;

        public PersonList(List<String> elements) {
            Objects.requireNonNull(elements, "elements must not be null");
            this.elements = new ArrayList<>(elements);
            addSize = elements.size()/2;
            if (this.elements.size() % 2 != 0) {
                throw new IllegalArgumentException("number of elements must have even size");
            }
        }

        @Override
        public Person get(int index) {
            String name = elements.get(0);
            elements.remove(name);
            String surname = elements.get(0);
            elements.remove(surname);
            return new Person(name, surname);
        }

        @Override
        public int size() {
            return elements.size() + addSize;
        }
    }
}
