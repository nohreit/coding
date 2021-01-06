package cmp168;

public class Infant extends Person{

	private InfantToy [] toys;
	private int numBabyToys;

	// This is the infant toy class
	public class InfantToy{
		private String infantToyName;
		private int infantToyRating;
		
		
		public InfantToy(String infantToyName, int infantToyRating) {
			this.infantToyName = infantToyName;
			this.infantToyRating = infantToyRating;
			
		}
		
		public String toString() {
			return  String.format("Name: %20s | Rating: %d",
					this.infantToyName,
					this.infantToyRating);
		}
	}
	
	public Infant() {
		super();
		this.toys = new InfantToy [10];
		this.numBabyToys = 0;
	}
	
	public Infant(String name, int birthYear, double weight, double height,  char gender, int numCarryOn, int numOffSpring) {
		super(name, birthYear, weight, height, gender, numCarryOn, 0);

		
	}
	
	public void addInfantToy(String infantToyName, int infantToyRating) {
		if(numBabyToys == 10) {
			System.out.println("can't add anymore toys!");
		}
		else {
			toys[numBabyToys] = new InfantToy(infantToyName, infantToyRating);
					numBabyToys++;		
		}
			
		
	}
	
	public String getInfantAsString(int index) {
		// if index is valid
		return toys[index].toString();
	}
	
	public int getNumInfantsToys() {
		return getNumInfantsToys();
		
	}
	
	public int getNumInfantToyName(String numInfantToyName) {
		return getNumInfantToyName(numInfantToyName);
		
	}
	
	public int getInfantToyRating(int InfantToyRating) {
		return getInfantToyRating(InfantToyRating);
		
	}
	
	public int getHighestInfantToyRating() {
		int maxi = toys[0].infantToyRating;

		for (int i = 0; i < toys.length; i++) {
			maxi = Math.max(maxi, toys[i].infantToyRating);
		}
		return maxi;
	}
	
	public void printDetails() {
		
	}
	
	public String toString() {
		return super.toString()+
				String.format("");
	}
	
}
