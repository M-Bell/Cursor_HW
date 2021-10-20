package HW10.Task3;

import java.util.List;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name = '" + name + '\'' +
                ", surname = '" + surname + '\'';
    }
}
