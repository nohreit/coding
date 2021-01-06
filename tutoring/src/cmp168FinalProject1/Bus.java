package cmp168FinalProject1;

public class Bus extends Car{

	public Bus(int[] numSeatsPerRow) {
		super(2, ((2 * (numSeatsPerRow).length) -1), numSeatsPerRow);
	}
	
	public Bus(Person driver, int[] numSeatsPerRow) {
		super(2, ((2 * (numSeatsPerRow).length) -1), driver, numSeatsPerRow);	
	}
	
	@Override
	public boolean canOpenDoor(Person p) {
		if (p == personsOnBoard[0][0]) {
			return true;
		}
		
		int lastPopulatedRow = 0;
		
		for (int i = 0; i< numberOfRows; i++) {
			if (getNumberOfPeopleInRow(i) == 0) {
				lastPopulatedRow = i-1;
				break;
			}
		}
		int[] location = getLocationOfPersonInVehicle(p);

		return p.getAge() > 5 && p.getHeight() > 40 && location[0] == lastPopulatedRow;
	}

	@Override
	public boolean canOpenWindow(Person p) {
		boolean a = super.canOpenWindow(p);
		return a && p.getAge() > 5;
	}
	
	@Override
	public String toString() {
		String b = super.toString();
		String a = "Bus is an extension of ";
		return a + b;
	}
	
	
	@Override
	public boolean loadPassenger(Person p) {
		return super.loadPassenger(p);
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return super.loadPassengers(peeps);
	}
	
	@Override
	public String departure() {
		return super.departure() + "The Bus\n";
	}

	@Override
	public String arrival() {
		return super.arrival() + "Of The Bus\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return super.doNotDisturbTheDriver() + "On The Bus\n";
	}
	
}
