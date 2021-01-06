package cmp168FinalProject;

public class Person {

    private final String name;
    private final boolean hasDriverLicense;
    private final int age; //Years
    private final int height; //Inches

    public Person(String name, boolean driverLicense, int age, int height) {
        this.name = name;
        this.hasDriverLicense = driverLicense;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public boolean hasDriverLicense() {
        return hasDriverLicense;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public Person clone() {
        return new Person(name, hasDriverLicense, age, height);
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            if (this.name.equals(p.name) && this.hasDriverLicense == p.hasDriverLicense &&
                    this.age == p.age)
                return this.height == p.height;
        }
        return false;
    }

    public String toString() {
        return String.format("Person [name= %10s | age= %02d | height= %02d |"
                + " %s]", name, age, height, (hasDriverLicense() ? "has license" : "no license"));
    }
}
