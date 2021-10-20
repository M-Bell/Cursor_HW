package HW10.Task1;

public record Person(String name, int age, Gender gender) {

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