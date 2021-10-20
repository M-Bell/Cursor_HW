package HW10.Task2;

class Person{
    private final String name;
    private final int age;
    private final Main.Gender gender;
    private final Main.Country country;

    public Person(String name, int age, Main.Gender gender, Main.Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Main.Gender getGender() {
        return gender;
    }

    public Main.Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + '(' + age + ')';
    }
}
