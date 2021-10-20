package HW10.Task2;

record Person(String name, int age, Main.Gender gender, Main.Country country) {

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
