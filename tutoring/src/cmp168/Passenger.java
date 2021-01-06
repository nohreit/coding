package cmp168;

public class Passenger {

    private String name;
    private int birthYear;
    private double weight;
    private char gender;
    private int numCarryOn;
    private double height;

    public Passenger() {
        name = "";
        birthYear = 1900;
        weight = 0.0;
        gender = 'u';
        numCarryOn = 0;

    }

    public Passenger(String name, int birthYear, double weight, char gender, int numCarryOn) {
        this.name = name;
        this.birthYear = birthYear;
        if(weight < 0) weight =-1; //weight is correct logic
        this.weight = weight;
        if(gender != 'f' && gender != 'm')gender = 'u';
        this.gender = gender;
        if(numCarryOn < 0) numCarryOn = 0;
        if(numCarryOn > 2) numCarryOn = 2;
        this.numCarryOn = numCarryOn;
    }

    public Passenger(String name, int birthYear, double weight, double height,  char gender, int numCarryOn) {
        this.name = name;
        this.birthYear = birthYear;
        if(weight < 0) weight =-1; //weight is correct logic
        this.weight = weight;
        if(height < 0) height =-1;
        this.height = height;
        if(gender != 'f' && gender != 'm')gender = 'u';
        this.gender = gender;
        if(numCarryOn < 0) numCarryOn = 0;
        if(numCarryOn > 2) numCarryOn = 2;
        this.numCarryOn = numCarryOn;
    }

    public int calculateAge(int currentYear) {
        int age = currentYear - this.birthYear;
        if(age < 0) {
            age = -1;
        }
        return age;
    }

    public void gainWeight() {
        weight++;

    }

    public void gainWeight(double weight) {
        this.weight += weight;
        if(this.weight < 0) this.weight = 0;
    }


    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getWeight() {
        return weight;
    }

    public char getGender() {
        return gender;
    }

    public int getNumCarryOn() {
        return numCarryOn;
    }

    public double getHeight() {
        return height;
    }

    public boolean isFemale() {
        return this.getGender() == 'f';
    }

    public boolean isMale() {
        return this.getGender() == 'm';
    }

    public void loseWeight() {
        this.weight--;
        if(this.weight < 0) this.weight = 0;
    }

    public void loseWeight(double w) {
        this.weight -= w;
        if(this.weight < 0) this.weight = 0;
    }


    public void printDetails() {
        System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f |  Height: %10.2f | Gender: %c | NumCarryOn: %2d\\n ");

    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setWeight(double weight) {
        if(weight < 0) weight = -1;
        this.weight = weight;
    }

    public void setGender(char gender) {
        if(gender != 'f' && gender != 'm')gender = 'u';
        this.gender = gender;
    }

    public void setNumCarryOn(int numCarryOn) {
        if(numCarryOn < 0) numCarryOn = 0;
        if(numCarryOn > 2) numCarryOn = 2;
        this.numCarryOn = numCarryOn;
    }

    public void setHeight(double height) {
        if(height < 0) height = -1;
        this.height = height;
    }

    public double calculateBMI() {
        if(height != 0) {
            return (this.weight*703)/Math.pow(this.height,2);
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f " +
                        "| Gender: %c | NumCarryOn: %2d\n",
                this.getName(),
                this.getBirthYear(),
                this.getWeight(),
                this.getHeight(),
                this.getGender(),
                this.numCarryOn);
    }

    @Override
    public boolean equals(Object p) {
        if(p instanceof Passenger) {
            Passenger pass = (Passenger) p;
            return (getBirthYear() == pass.getBirthYear() &&
                    getGender() == pass.getGender() &&
                    getName().equals(pass.getName()) &&
                    getWeight() - pass.getWeight() <= 0.5 &&
                    getHeight() - pass.getHeight() <= 0.5);
        }

        return false;
    }


}


