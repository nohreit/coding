package cmp168;

public class Driver {
    public static void main(String[] args) {
//        Airplane a1 = new Airplane("Amazonas", 10);
//
//        Passenger[] passengers = new Passenger[10];
//
//        for (int i = 0; i < passengers.length; i++) {
//            passengers[i] = new Passenger("Passenger" + i, 2010 + i, 175 - i, 'u', 1);
//        }
//
//        for (int i = 0; i < passengers.length; i++) {
//            a1.addPassenger(passengers[i]);
//        }
//
//        a1.printAllDetails();
//        a1.removePassenger(9);
//        a1.printAllDetails();
//
////        pln("Number of passengers above weight: "+ a1.getNumberOfPassengersAboveWeight(200));

        Person[] persons = new Person[10];

        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person("Person" + i, 2010 + i, 175 - i,
                    1.75,'u', 1, 3);
        }

        for (int i = 0; i < persons.length; i++) {
            pln(persons[i].toString());
        }

    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
