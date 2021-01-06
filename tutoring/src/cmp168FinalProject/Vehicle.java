package cmp168FinalProject;

public abstract class Vehicle {

	protected Person [][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int [] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatsPearRow) {
		this.numberOfRows = numRows;
		
		this.maxSeatsPerRow = numSeatsPearRow;
		
		this.numSeatsPerRow = new int[this.maxSeatsPerRow];
		
		this.personsOnBoard = new Person [numberOfRows][maxSeatsPerRow];
	}
	
	public Vehicle(int[] numSeatsPerRow) {
		this.numberOfRows= numSeatsPerRow.length;
		this.numSeatsPerRow = numSeatsPerRow;

		this.maxSeatsPerRow=numSeatsPerRow[0];
		for (int value : numSeatsPerRow) {
			this.maxSeatsPerRow = Math.max(this.maxSeatsPerRow, value);
		}

		this.personsOnBoard = new Person[this.numberOfRows][maxSeatsPerRow];
	}
	
	public Vehicle(Person driver, int [] numSeatsPerRow ) throws InvalidDriverException{
		
		this.maxSeatsPerRow= (Math.max(numSeatsPerRow[0], numSeatsPerRow[1]));
		numberOfRows= numSeatsPerRow.length;
		
		this.setRowsLength(numSeatsPerRow);
		setDriver(driver);
		
	}
	//*********\\
	private Person[][] setRowsLength(int [] seatsPerRow) {
		personsOnBoard= new Person[seatsPerRow.length][]; //[row][column]
		
		for(int i=0; i< seatsPerRow.length; i++) {
			personsOnBoard[i]= new Person[seatsPerRow[i]];
			
		}
		return personsOnBoard;
	}
	
	//**********\\
	abstract boolean loadPassenger(Person p);
	abstract int loadPassengers(Person[] peeps);
	
		
	public void setDriver(Person p) throws InvalidDriverException{
		if(p != null) {
			if(p.hasDriverLicense()) {
				personsOnBoard[0][0]= p;
			}
		}
		else {
			throw new InvalidDriverException();
		}
		
	}
	
	public Person getDriver() {
		if(personsOnBoard[0][0] != null) {
			return personsOnBoard[0][0];
		}
		return null;
	}
	
	public boolean hasDriver() {
		return personsOnBoard[0][0] != null;
	}
	

	
	public int getNumberOfAvailableSeats() { 
		int seats= 0;
		
		for(int row=0; row<numberOfRows;row++) {
			for(int col=0; col< personsOnBoard[row].length; col++) {
				
				if(personsOnBoard[row][col] == null) {
					
					seats +=1;
				}
			}
			
		}
		return seats;
	}
	
	public int getNumberOfAvailableSeatsInRow(int row) { 
		int count=0;
		
		if(row < numberOfRows && row >= 0) {
			
			for(int col=0; col< personsOnBoard[row].length; col++) {
				
				if(personsOnBoard[row][col] == null) {
					
					count +=1;
				}
			}
			
		}else {
		
			count= -1;
		
		}
		return count;
	}
	
	public int getNumberOfPeopleOnBoard() { 
		int count=0;
		for (Person[] people : personsOnBoard) {
			for (Person person : people) {
				if (person != null) {
					count += 1;
				}
			}

		}
		return count;
	}
	
	public int getNumberOfPeopleInRow(int row) { 
		int count= 0;
		if(row <= numberOfRows && row >= 0) {
			for(int i=0; i< numSeatsPerRow.length;i++) {
				if(personsOnBoard[row][i] != null) {
					count +=1;
				}
			}
			
		}
		else {
			count= -1;
		}
		
		return count;
	
	}
	
	public Person getPersonInSeat(int row, int col) {
		if(row< numberOfRows && row >=0 && col< maxSeatsPerRow && col >=0) {
			return personsOnBoard[row][col];
		}
		return null;
	}
	
	public int[] getLocationOfPersonInVehicle(Person p) {  //returning address location
		/**
		 * returns the location of the person in the vehicle by returning and
		 * int array [row,seat] please note that if the person is not seated in 
		 * the vehicle the method will return [-1,-1]
		 */
		int[] location= new int[2];
		if(p!= null) {
			for(int i=0; i<personsOnBoard.length; i++) {
				for(int j=0; j<personsOnBoard[i].length; j++) {
						if(personsOnBoard[i][j] == p) {
							location= new int[]{i,j};
							//break;
						}
					}
				}
		}
		else {
			location= new int[]{-1,-1};
		}
	//	System.out.println(location[0] + " "+ location[1]);
		return location;
	}
	
	public Person[] getPeopleInRow(int row) {  //returning address location
		/**
		 * return a Person array containing a clone of all the persons in
		 * the row. the populated Person array will not contain empty index
		 * locations. if the specified row has no one, or the specified row is invalid 
		 * return null;
		 */
		Person [] peopleInRow= new Person[numSeatsPerRow.length];
		
		if(row<= numberOfRows && row >= 0) {
			for(int col=0; col<numSeatsPerRow.length; col++) {
				
				if(personsOnBoard[row][col] != null) {
					
					peopleInRow[col]= personsOnBoard[row][col].clone();
				}
				else {
					return null;
				}
			}
			return peopleInRow;
		}
		return null;
	}
	
	public Person[][] getPeopleOnBoard(){ //returning address location
		/**
		 * returns a full clone of the personsOnBoard array with clones of the
		 * Person objects contained within. Please note that the personsOnBoard.clone() is not
		 * Sufficient to clone a 2D array.
		 */
		Person[][] pCopy= new Person[personsOnBoard.length][];
		setRows(pCopy,numSeatsPerRow );
		
		for(int row=0; row<personsOnBoard.length;row++) {
			//.clone();
			System.arraycopy(personsOnBoard[row], 0, pCopy[row], 0, personsOnBoard[row].length);
		}
		return pCopy;
	}
	private Person [][] setRows(Person [][] copy, int [] seatsRow){
		//copy= new Person[seatsRow.length][];
		for(int i=0; i<seatsRow.length; i++) {
			copy[i]= new Person[seatsRow[i]];
		}
		return copy;
	}
	
	public boolean isPersonInVehicle(Person p) { 
		if(p != null) {
			for (Person[] people : personsOnBoard) {
				for (Person person : people) {
					if (person == p) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isPersonDriver(Person p) {  
		if(p != null) {
			return personsOnBoard[0][0] == p;
		}
		return false;
	}
	

}
