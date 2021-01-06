package cmp168FinalProject1;

import java.util.Arrays;
public class Car extends Vehicle implements Comparable<Car>, Announcements {

	private int numDoors;
	private int numWindows;
	

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
	
	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors; 
		this.numWindows = numWindows;
	}
	
	public boolean canOpenDoor(Person p) {
		int[] location = getLocationOfPersonInVehicle(p);
		int[] test = {-1, 1};
		
		if (!(Arrays.equals(location, test))) {
			if (location[1] == 0 || (location[1] == numSeatsPerRow[(location[0])] -1) ) {
				if (p.getAge() <= 5) {
					return false;
				}
				else if (numDoors < (2 * numberOfRows) && location[0] > (numDoors / 2)) {
					return false;
				}
				else{
					return true;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean canOpenWindow(Person p) {
		int[] location = getLocationOfPersonInVehicle(p);
		int[] test = {-1, -1};
		
		if (!(Arrays.equals(location, test))) {
			if (location[1] == 0 || (location[1] == numSeatsPerRow[(location[1]-1)]) ) {
				if (p.getAge() <=2) {
					return false;
				}
				else if (getNumWindows() < (2 * numberOfRows) && location[0] > (getNumWindows() / 2)) {
					return false;
				}
				else{
					return true;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public int getNumWindows() {
		return numWindows;
	}
	
	public int getNumDoors() {
		return numDoors;
	}
	
	
	
	@Override 
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car a = (Car)obj;
			boolean checkArray = true;
			if (numberOfRows == a.numberOfRows && maxSeatsPerRow == a.maxSeatsPerRow) {
				for (int i = 0; i<numberOfRows; i++) {
					if (numSeatsPerRow[i] != a.numSeatsPerRow[i]) {
						checkArray = false;
					}
				}
			}
			if (checkArray && a.numDoors == numDoors && a.numWindows == numWindows) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String b = "[";
		for (int i = 0; i<numberOfRows; i++) {
			b += Integer.toString(numSeatsPerRow[i]);
			if (i != numberOfRows -1) {
				b += ",";
			}
		}
		b += "]";
		
		String c = "[";
		
		for (int i = 0; i<numberOfRows; i++) {
			for (int j = 0; j<maxSeatsPerRow; j++) {
				if (personsOnBoard[i][j] instanceof Person) {
					c += personsOnBoard[i][j].getName();
					c += ",";
				}
			}
		}
		if (c.endsWith(",")) {
			c = c.substring(0, c.length()-1);
		}
		c += "]";
		String a = String.format("Car: number of doors = %02d | number of windows = %02d | number of rows = %02d | seats per row = %s | names of people on board = %s\n", numDoors, numWindows, numberOfRows, b, c );
		return a;
	}
	
	public int compareTo(Car c) {
		int cTotalSeats = c.getNumberOfAvailableSeats() + c.getNumberOfPeopleOnBoard();
		int currTotalSeats = getNumberOfAvailableSeats() + getNumberOfPeopleOnBoard();
		
		if (currTotalSeats < cTotalSeats) {
			return -1;
		}
		else if (currTotalSeats == cTotalSeats) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public boolean loadPassenger(Person p) {
		for (int row = 0; row<this.numberOfRows && p != null; row++) {
			for (int col = 0; col<this.numSeatsPerRow[row]; col++) {
				if(this.isEmpty(this.personsOnBoard[row][col])) {
					if (p.hasDriverLicense() && (row == 0 && col == 0))
						this.personsOnBoard[0][0] = p;
					else {
						if (p.getAge() >= 5 && p.getHeight() >= 36 && this.isEmpty(this.personsOnBoard[row][col]))
							this.personsOnBoard[0][0] = p;
						else if
					}
				}
			}
		}
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int count = 0;
		int numPeopleToLoad = peeps.length;
		int avail = getNumberOfAvailableSeats();
		while (avail > 0 && numPeopleToLoad > 0) {
			for (Person p : peeps) {
				loadPassenger(p);
				count++;
				avail--;
				numPeopleToLoad--;
			}
		}
		
		return count;
	}

	@Override
	public String departure() {
		return "All Aboard\n";
	}

	@Override
	public String arrival() {
		return "Everyone Out\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return "No Backseat Driving\n";
	}
	
	public static void main(String[] args) {
		Car p = new Car(2, 4);
		Person personA = new Person("Daphne", true, 19, 65);
		Person personB = new Person("Daphne", true, 18, 65);
		Person personC = new Person("Daphne", true, 17, 65);

		p.personsOnBoard[0][0] = personC;

		System.out.println("Is personA driver? " + p.isPersonDriver(personA));
		System.out.println("Is personA driver? " + p.isPersonDriver(personB));
		System.out.println("Is personA driver? " + p.isPersonDriver(personC));

	}
}
