package cmp168FinalProject1;

import java.util.ArrayList;

public abstract class Vehicle {
    protected Person[][] personsOnBoard;
    protected int numberOfRows;
    protected int maxSeatsPerRow;
    protected int[] numSeatsPerRow;

    public Vehicle(int numRows, int numSeatPerRow) {
        this.numberOfRows = numRows;
        this.maxSeatsPerRow = numSeatPerRow;
        this.numSeatsPerRow = new int[this.maxSeatsPerRow];
        this.personsOnBoard = new Person[this.numberOfRows][this.maxSeatsPerRow];
    }

    public Vehicle(int[] numSeatsPerRow) {
        this.numSeatsPerRow = numSeatsPerRow;
        this.numberOfRows = numSeatsPerRow.length;
        this.maxSeatsPerRow = numSeatsPerRow[0];
        for (int value : numSeatsPerRow) {
            this.maxSeatsPerRow = Math.max(this.maxSeatsPerRow, value);
        }

        this.personsOnBoard = new Person[this.numberOfRows][this.maxSeatsPerRow];
    }

    public Vehicle(Person driver, int[] numSeatsPerRow) {
        this.numSeatsPerRow = numSeatsPerRow;
        this.numberOfRows = numSeatsPerRow.length;
        this.maxSeatsPerRow = numSeatsPerRow[0];
        for (int value : numSeatsPerRow) {
            this.maxSeatsPerRow = Math.max(this.maxSeatsPerRow, value);
        }

        this.personsOnBoard = new Person[this.numberOfRows][this.maxSeatsPerRow];

        if (driver.hasDriverLicense()) {
            this.personsOnBoard[0][0] = driver;
        }
    }

    public abstract boolean loadPassenger(Person p);

    public abstract int loadPassengers(Person[] peeps);

    public Person getDriver() {
        if (this.personsOnBoard[0][0] != null) {
            return this.personsOnBoard[0][0];
        } else {
            return null;
        }
    }

    public void setDriver(Person p) throws InvalidDriverException {
        if (!(p.hasDriverLicense())) {
            throw new InvalidDriverException();
        } else {
            this.personsOnBoard[0][0] = p;
        }
    }

    public boolean hasDriver() {
        return personsOnBoard[0][0] != null;
    }

    public int getNumberOfAvailableSeats() {
        int count = 0;

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numSeatsPerRow[row]; col++) {

                if (personsOnBoard[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getNumberOfAvailableSeatsInRow(int row) {
        int count = 0;

        if (row < 0 || row > numberOfRows - 1) {
            count = -1;
        } else {
            for (int i = 0; i < numSeatsPerRow[row]; i++) {
                if (personsOnBoard[row][i] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumberOfPeopleOnBoard() {
        int count = 0;

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numSeatsPerRow[row]; col++) {
                if (!this.isEmpty(personsOnBoard[row][col])) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getNumberOfPeopleInRow(int row) {
        int count = 0;

        for (int i = 0; i < numSeatsPerRow[row]; i++) {
            if (personsOnBoard[row][i] != null) {
                count++;
            }
        }

        return count;
    }

    public Person getPersonInSeat(int row, int col) {
        if (row >= 0 && row < numberOfRows && col >= 0 && col < numSeatsPerRow[row]) {
            return personsOnBoard[row][col];
        } else {
            return null;
        }
    }

    public int[] getLocationOfPersonInVehicle(Person p) {

        int[] b = {-1, 1};

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numSeatsPerRow[i]; j++) {

                if (personsOnBoard[i][j] != null) {
                    if (personsOnBoard[i][j].equals(p)) {
                        b[0] = i;
                        b[1] = j;
                    }
                }
            }
        }
        return b;
    }

    public Person[] getPeopleInRow(int row) {
        ArrayList<Person> list = new ArrayList<Person>();

        if (row < 0 || row > numberOfRows - 1) {
            return null;
        }

        for (int i = 0; i < numSeatsPerRow[row]; i++) {
            if (personsOnBoard[row][i] != null) {
                Person b = personsOnBoard[row][i].clone();
                list.add(b);
            }
        }

        if (list.size() < 1) {
            return null;
        }

        return list.toArray(new Person[0]);

    }

    public Person[][] getPeopleOnBoard() {
        Person[][] result = new Person[personsOnBoard.length][];
        for (int i = 0; i < personsOnBoard.length; i++) {
            result[i] = personsOnBoard[i].clone();

        }
        return result;
    }

    public boolean isPersonInVehicle(Person p) {
        int[] orig = getLocationOfPersonInVehicle(p);

        return (orig[0] != -1);
    }

    public boolean isPersonDriver(Person p) {
        return personsOnBoard[0][0] != null && personsOnBoard[0][0].equals(p);
    }

    public boolean isEmpty(Object isAvailable){
    	return isAvailable == null;
	}

}
