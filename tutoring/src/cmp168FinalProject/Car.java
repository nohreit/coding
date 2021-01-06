package cmp168FinalProject;

import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>, Announcements {

    private final int numDoors;
    private final int numWindows;

    public Car(int numDoors, int numWindows) {
        super(2, 2);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, int numSeatsPerRow) {
        super(2, numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
        super(numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
        super(driver, numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public boolean canOpenDoor(Person p) {
		/*
		 * returns true if the Person is seated in either of 
		 * the exterior seats of a row that has a door 
		 * (column index 0 or last index of that row) and is over age 5.
		 *  It returns false otherwise.
			If the number of doors is less than 2 * numberOfRows, 
			the row/s past numDoors / 2 has/have no doors.
			
			you should be able to use the numberOfSeatsPerRow,  getPeopleOnBoard method and/or the getPeopleInRow method 
			to determine if a Person can open a door based on their location  (column 0 or column  row's length-1)
		 */

        Person[][] car = getPeopleOnBoard();

        if (numDoors > (2 * numberOfRows) && (numDoors / 2) < numberOfRows && p.getAge() > 5) {
            for (Person[] people : car) {
                for (int j = 0; j < people.length; j++) {
                    if (car[0][0].equals(p) || people[numSeatsPerRow.length - 1].equals(p)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canOpenWindow(Person p) {
        /*
         * returns true if the Person is seated in either
         * of the exterior seats of a row that has a window
         * (column index 0 or last index of that row) and is over age 2.
         *  It returns false otherwise. If the number of windows is
         *  less than 2 * numberOfRows, the row/s  past numWindows / 2 has/have no windows.

         */
        Person[][] car = getPeopleOnBoard();
        if (numWindows > (2 * numberOfRows) && (numWindows / 2) < numberOfRows && p.getAge() > 2) {
            for (Person[] people : car) {
                for (int j = 0; j < people.length; j++) {
                    if (people[0].equals(p) || people[numSeatsPerRow.length - 1].equals(p)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car otherCar = (Car) o;
            if (this.numDoors == otherCar.numDoors) {
                if (this.numWindows == otherCar.numWindows) {
                    if (super.maxSeatsPerRow == otherCar.maxSeatsPerRow) {
                        if (super.numberOfRows == otherCar.numberOfRows) {
                            return super.numSeatsPerRow == otherCar.numSeatsPerRow;
                        }
                    }
                }

            }
        }
        return false;
    }

    public String toString() {
        String s;
        StringBuilder names = new StringBuilder();
        for (Person[] people : personsOnBoard) {
            for (Person person : people) {
                if (person != null) {
                    names.append(person.getName()).append(" ");
                }
            }
        }
        s = String.format("Car: number of doors= %02d | number of windows= %02d |"
                + " number of rows= %02d | seats per row= %s | names of people on board= %s\n", numDoors, numWindows, numberOfRows, Arrays.toString(numSeatsPerRow), names.toString());
        return s;
    }

    @Override
    public int compareTo(Car c) {
        /*
         * This method returns -1 if the calling object’s total number of seats
         * is less than the passed in object’s total number of seats,
         *  1  if the calling object’s total number of seats is greater than
         *  the passed in object’s total number of seats, 0 if they have the
         *  same total number of seats.
         */
        return Integer.compare(super.maxSeatsPerRow * super.numberOfRows, c.maxSeatsPerRow * c.numberOfRows);
    }

    @Override
    public String departure() {
        return "All Aboard\n";
    }

    @Override
    public String arrival() {
        return "Everyone out\n";
    }

    @Override
    public String doNotDisturbTheDriver() {
        return "No Backseat Driving\n";
    }

    @Override
    public boolean loadPassenger(Person p) { //FAILED
        /*
         * This abstract method will be implemented by derived classes to load
         * the specified person into the vehicle at the first available seat.
         * Searching for an available seat must start in the first row, please note
         * that a person below the age of 5 or has a height less than 36 is not allowed
         * to sit in the first row. This method returns true if there is room for the
         * specified person, otherwise the method returns false.

         */
        if (p != null) { //if person is not null
            for (int row = 0; row < personsOnBoard.length; row++) {
                for (int col = 0; col < personsOnBoard[row].length; col++) { //starts after the driver's seat
                    if (isSeatEmpty(row, col)) { //if seat is empty
                        if (p.getAge() > 5 && p.getHeight() > 36) {
                            this.personsOnBoard[row][col] = p;
                            return true;
                        } else {
                            if (isSeatEmpty(row, col)) {
                                this.personsOnBoard[row][col] = p;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isSeatEmpty(int row, int col) {
        return this.personsOnBoard[row][col] == null;
    }

    @Override
    public int loadPassengers(Person[] peeps) { //FAILED
        /*
         * This method attempts to load as many of the persons specified in the peeps
         *  array as possible. This method returns the number of people that were loaded
         *  into the Vehicle.

         */
        int count = 0;

        for (int i = 0; i < personsOnBoard.length; i++) {

            for (int j = 1; j < personsOnBoard[i].length; j++) { //starts after the driver's seat

                for (Person peep : peeps) {

                    if (personsOnBoard[i][j] == null) { //if seat is empty

                        personsOnBoard[i][j] = peep; //placing person
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}
