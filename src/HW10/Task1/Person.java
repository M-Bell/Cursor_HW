package HW10.Task1;

public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                ", Age: " + age +
                ", Gender: " + gender;
    }
}

enum Gender {
    MALE, FEMALE
}