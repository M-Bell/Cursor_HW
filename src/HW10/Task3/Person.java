package HW10.Task3;

public record Person(String name, String surname) {

    @Override
    public String toString() {
        return "Name = '" + name + '\'' +
                ", surname = '" + surname + '\'';
    }
}
