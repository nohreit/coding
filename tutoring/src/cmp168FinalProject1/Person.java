package cmp168FinalProject1;

public class Person {

	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;
	
	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
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
