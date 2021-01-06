package cmp167;

public class Farm {
    private String farmName;
    private int numAnimals;
    private Animal[] animals;


    public Farm() {
        this.numAnimals = 0;
        this.farmName = "";
        this.animals = new Animal[10];
    }

    public Farm(String name) {
        this.farmName = name;
        this.numAnimals = 0;
        this.animals = new Animal[10];
    }

    public Farm(int n) {
        this.numAnimals = 0;

        this.farmName = "";

        if(n < 0) n = 0; // n is the size of the Animal array
        this.animals = new Animal[n];
    }

    public Farm(String name, int n) {
        this.farmName = name;
        this.numAnimals = 0;
        if(n < 0) n = 0;
        this.animals = new Animal[n];
    }

    public void addAnimal(Animal a) { //this
        if (numAnimals >= animals.length)
            resizeAnimalArray();
        animals[numAnimals++] = a;
    }

    public void resizeAnimalArray() {
        if (this.animals.length == 0)
            this.animals = new Animal[1];
        else {
            Animal[] temp = this.animals;
            this.animals = new Animal[this.animals.length * 2];
            if (temp.length >= 0) System.arraycopy(temp, 0, this.animals, 0, temp.length);
        }
    }


    public String getFarmName() {
        return this.farmName;
    }

    public void setFarmName(String s) {
        this.farmName = s;
    }

    public Animal getAnimal(int index) {
        if (index < 0 || index >= numAnimals)
            return null;
        else
            return animals[index];
    }

    public int getNumAnimals() {
        return this.numAnimals;
    }

    public Animal getFirstAnimal() {
        return this.animals[0];
    }

    public Animal getLastAnimal() {
        return this.animals[numAnimals-1];
    } // this

    public Animal[] getAnimals() {
        return animals;
    }

    public void printAllDetails() {
        System.out.printf( "FarmName: %20s | Number of Animals: %4d | Farm Size: %4d\n",
                this.farmName, this.numAnimals, this.animals.length);
        for(int i = 0; i < this.numAnimals; i++){
            animals[i].printDetails();
        }
    }


    public Animal removeAnimal(int index) { //this
        if(index < 0 || index >= animals.length) { // check index validity
            return null;
        }

        Animal removed = animals[index]; // removed animal
        numAnimals--;

        if(index == animals.length -1){ // check if it is the last index
            animals[index] = null; // remove the last animal.
        }else {
            for (int i = index; i < numAnimals; i++) {
                animals[i] = animals[i + 1];
            }
        }

        return removed;
    }

    public void removeAllAnimals() {
        animals = new Animal[0];
        numAnimals = 0;
    }

    public double getTotalWeightOfAllAnimals() {
        double total = 0;
        for (int i = 0; i < numAnimals; i++) {
            total += animals[i].getWeight();
        }
        return total;
    }

    public double getAverageWeightOfAllAnimals() {
        double sum = getTotalWeightOfAllAnimals();
        return sum / numAnimals;
    }

    public int getNumberOfAnimalsAboveWeight(double check) {
        int count = 0;
        for (int i = 0; i < numAnimals; i++) {
            if (animals[i].getWeight() > check)
                count++;
        }
        return count;
    }


    public int getNumberOfAnimalsBelowWeight(double check) {
        int count = 0;
        for (int i = 0; i < numAnimals; i++) {
            if (animals[i].getWeight() < check)
                count++;
        }
        return count;
    }

    public void increaseWeightOfAllAnimals() {
        for (int i =0; i < numAnimals; i++) {
            animals[i].gainWeight();
        }
    }

    public void increaseWeightOfAllAnimals(double extra) {
        for (int i = 0; i < numAnimals; i++) {
            animals[i].gainWeight(extra);
        }
    }

}
