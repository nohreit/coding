package cmp168FinalProject;

public class Bus extends Car{

	public Bus(int[] numSeatsPerRow) {
		super(2,(2* numSeatsPerRow.length-1), numSeatsPerRow);
		numSeatsPerRow[0]=1;
	}
	public Bus(Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
		super(2,(2*numSeatsPerRow.length-1),driver, numSeatsPerRow);
		numSeatsPerRow[0]=1;
	}
	
	public boolean canOpenDoor(Person p) {
		/**
		 * This method returns true if the Person is the driver, 
		 * or seated in the last populated row. 
		 * The Person must also be above the age of 5, and taller than 40 inches. It returns false otherwise.
		 */
		
		Person [][] bus= getPeopleOnBoard();
		for(int i=0; i<bus.length; i++) {
			for(int j=0; j<bus[i].length;j++) {
				if(bus[0][0] == p || bus[bus.length-1][j] == p) {
					if(p.getAge() > 5 && p.getHeight() > 40) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean canOpenWindow(Person p) {
		/**
		 * This method returns true if it’s parent class’s 
		 * canOpenWindow method returns true, and the Person is above the age of 5.

		 */
		if(super.canOpenDoor(p)==true) {
			if(p.getAge() > 5) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String s= "Bus is an extension of" + super.toString();
		return s;
	}
	
	@Override
	public String departure() {
		String s= super.departure() + "The Bus\n";
		return s;
	}

	@Override
	public String arrival() {
		String s= super.arrival() + "Of The Bus\n";
		return s;
	}

	@Override
	public String doNotDisturbTheDriver() {
		String s= super.doNotDisturbTheDriver() + "On The Bus\n";
		return s;
	}
}
