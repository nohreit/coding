package cmp167;

public class Driver {
    public static void main(String[] args) {
        // 1. Create a Farm of size 10;
        Farm myFarm = new Farm(10);

        // 2. Create 5 Animal Objects with the details specified in the table below
        Animal a1 = new Animal("cow", 2012, 1000.5, 'f');
        Animal a2 = new Animal("pig", 2009, 550.5, 'm');
        Animal a3 = new Animal("donkey", 1999, 773.42, 'm');
        Animal a4 = new Animal("sheep", 2016, 164.23, 'f');
        Animal a5 = new Animal("goose", 2004, 10.75, 'f');

        // 3. Add the 5 Animal objects to the Farm

        myFarm.addAnimal(a1);
        myFarm.addAnimal(a2);
        myFarm.addAnimal(a3);
        myFarm.addAnimal(a4);
        myFarm.addAnimal(a5);

        // 4. Call the printDetails method from the Farm to print all the Farm and Animal details.

        myFarm.printAllDetails();

    }
}
