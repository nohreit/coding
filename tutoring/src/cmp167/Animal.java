package cmp167;

public class Animal {

    private String name;
    private int birthYr;
    private double weight;
    private char gender;

    public Animal() {

        name = "";
        birthYr = 1900;
        weight = 0;
        gender = 'u';
    }

    public Animal(String n, int b, double w, char g) {

        name = n;
        birthYr = b;
        setWeight(w);
        setGender(g);
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYr;
    }

    public double getWeight() {
        return weight;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String n) {
        name = n;
    }

    public void setBirthYear(int b) {
        birthYr = b;
    }

    public void setWeight(double w) {
        if (w < 0)
            weight = -1;
        else
            weight = w;
    }

    public void setGender(char g) {

        if (g == 'M' || g == 'm')
            gender = 'm';

        else if (g == 'F' || g == 'f')
            gender = 'f';

        else
            gender = 'u';

    }

    public int calculateAge(int currentYr) {

        if (currentYr < birthYr)
            return -1;
        return (currentYr - birthYr);
    }

    public boolean isMale() {

        if (gender == 'M' || gender == 'm')
            return true;

        else
            return false;
    }

    public boolean isFemale() {

        if (gender == 'F' || gender == 'f')
            return true;

        else
            return false;
    }

    public void printDetails() {
        System.out.printf( "Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c\n",
                this.name, this.birthYr, this.weight, this.gender);
    }

    public void gainWeight() {
        weight += 1;
    }

    public void gainWeight(double w) {

        if (w > 0)
            weight += w;
    }

    public void loseWeight() {

        if (1 <= weight)
            weight -= 1;
    }

    public void loseWeight(double w) {

        if ((w > 0) && (weight - w > 0))
            weight -= w;
    }

}
