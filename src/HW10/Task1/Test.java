package HW10.Task1;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> input = List.of(new Person("Dan", 22, Gender.MALE),
                new Person("Carol", 89, Gender.FEMALE),
                new Person("John", 12, Gender.MALE),
                new Person("Lisa", 23, Gender.FEMALE),
                new Person("Ann", 99, Gender.FEMALE),
                new Person("Billie", 59, Gender.MALE),
                new Person("Stephan", 18, Gender.MALE));
        System.out.println("Input");
        for (Person person : input) {
            System.out.println(person);
        }
        HashSet<Person> filteredStream = (HashSet<Person>) input.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 60)
                .collect(Collectors.toSet());
        System.out.println("Filtered input");
        for (Person person : filteredStream) {
            System.out.println(person);
        }
        String[] data = input.stream().map(x -> x.getName() + " - " + x.getGender().toString().toLowerCase().charAt(0)).toArray(String[]::new);
        System.out.println("Formatted output");
        for (String res : data) {
            System.out.println(res);
        }
    }
}
