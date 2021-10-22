package HW10.Task2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static HW10.Task2.Main.Continent.*;
import static HW10.Task2.Main.Country.*;
import static HW10.Task2.Main.Gender.FEMALE;
import static HW10.Task2.Main.Gender.MALE;

/*
    WARNING:
    В цьому коді допоможе розібратися тільки Дух Святий...
    Але він працює :)
*/
public class Main {
    public static void main(String[] args) {
        List<Person> data = Stream.of(
                new Person("Petro", 25, MALE, UKRAINE),
                new Person("Olena", 19, FEMALE, UKRAINE),
                new Person("Marek", 50, MALE, POLAND),
                new Person("Rasine", 65, FEMALE, POLAND),
                new Person("Cherina", 42, FEMALE, FRANCE),
                new Person("Bridgett", 18, FEMALE, FRANCE),
                new Person("Jaron", 42, MALE, ISRAEL),
                new Person("Namir", 18, MALE, ISRAEL),
                new Person("John", 10, MALE, USA),
                new Person("Jane", 78, FEMALE, USA),
                new Person("Alonzo", 12, MALE, ARGENTINA),
                new Person("Azael", 43, FEMALE, ARGENTINA),
                new Person("Thomas", 12, MALE, AUSTRALIA),
                new Person("Brittney", 43, FEMALE, AUSTRALIA)
        ).collect(Collectors.toList());
        List<Person> filteredData = data.stream().filter(x -> x.getAge() >= 18 && x.getAge() < 60).collect(Collectors.toList());
        System.out.println(filteredData
                .stream()
                .collect(Collectors.groupingBy(x -> x.getCountry().continent))
                .entrySet()
                .stream()
                .map(entry -> String.format("•%s\n%s",
                        entry.getKey().toString(),
                        entry.getValue()
                                .stream()
                                .collect(Collectors.groupingBy(Person::getCountry))
                                .entrySet()
                                .stream()
                                .map(entry2 -> String.format("\t○%s\n%s",
                                        entry2.getKey(),
                                        entry2.getValue()
                                                .stream()
                                                .collect(Collectors.groupingBy(Person::getGender))
                                                .entrySet()
                                                .stream()
                                                .map(entry3 -> String.format("\t\t■%s\n%s",
                                                        entry3.getKey(),
                                                        entry3.getValue()
                                                                .stream()
                                                                .collect(Collectors.groupingBy(Person::getName))
                                                                .entrySet()
                                                                .stream()
                                                                .map(entry4 -> String.format("\t\t\t•%s(%s)",
                                                                        entry4.getKey(),
                                                                        entry4.getValue()
                                                                                .stream()
                                                                                .collect(Collectors.groupingBy(Person::getAge))
                                                                                .keySet()
                                                                                .stream()
                                                                                .map(entry5 -> String.format("%s", entry5.toString()))
                                                                                .collect(Collectors.joining("\n"))))
                                                                .collect(Collectors.joining("\n"))))
                                                .collect(Collectors.joining("\n"))))
                                .collect(Collectors.joining("\n"))))
                .collect(Collectors.joining("\n")));
    }

    public enum Gender {
        MALE, FEMALE
    }

    public enum Country {
        UKRAINE("Ukraine", EUROPE),
        POLAND("Poland", EUROPE),
        FRANCE("France", EUROPE),
        CHINA("China", ASIA),
        INDIA("India", ASIA),
        ISRAEL("Israel", ASIA),
        EGYPT("Egypt", AFRICA),
        ALGERIA("Algeria", AFRICA),
        ANGOLA("Angola", AFRICA),
        USA("USA", NORTH_AMERICA),
        CANADA("Canada", NORTH_AMERICA),
        MEXICO("Mexico", NORTH_AMERICA),
        BRAZIL("Brazil", SOUTH_AMERICA),
        ARGENTINA("Argentina", SOUTH_AMERICA),
        BOLIVIA("Bolivia", SOUTH_AMERICA),
        AUSTRALIA("Australia", OCEANIA),
        FIJI("Fiji", OCEANIA),
        NEW_ZEALAND("New Zealand", OCEANIA),
        ;

        private final String country;
        private final Continent continent;

        Country(String country, Continent continent) {
            this.country = country;
            this.continent = continent;
        }

        public String getCountry() {
            return country;
        }

        public Continent getContinent() {
            return continent;
        }
    }

    public enum Continent {
        EUROPE, ASIA, AFRICA, OCEANIA, NORTH_AMERICA, SOUTH_AMERICA, ANTARCTICA
    }
}
