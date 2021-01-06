package cmp168FinalProject1;

public class Bicycle extends Vehicle implements Comparable<Bicycle> {

	private double weight;
	public static int[] seats = {1};
	public static double ACCURACY_RANGE = 0.5;
	
	public Bicycle() {
		super(1, 1);
		weight = 0.0;
	}
	
	public Bicycle(Person driver) {
		super(driver, seats);
		weight = 0.0;
	}
	
	public Bicycle(Person driver, double w) {
		super(driver, seats);
		if (w <0) {
			weight = 0;
		}
		else {
			weight = w;
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double w) {
		if (w <0) {
			weight = 0;
		}
		else {
			weight = w;
		}
	}		
			
	
	@Override
	public void setDriver(Person p) throws InvalidDriverException{
		if (p.getAge()<3) {
			throw new InvalidDriverException();
		}
		else {
			personsOnBoard[0][0] = p;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bicycle) {
			Bicycle a = (Bicycle)obj;
			return Math.abs(weight - a.getWeight()) <= ACCURACY_RANGE;
		}
		return false;
	}
	

	@Override
	public int compareTo(Bicycle o) {
		
		if (this.weight - o.getWeight() <=  ACCURACY_RANGE || this.weight - o.getWeight() >= ACCURACY_RANGE) {
			return 0;
		}
		else if (this.weight  - o.getWeight() > ACCURACY_RANGE) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Bicycle [ rider= " + this.getDriver().getName() + " | weight= " + this.weight + " ]";
	}

	
	public static void main(String[] args) throws InvalidDriverException {
		Person pA = new Person("Daphne", false, 16, 65);
		Person pB = new Person("Daphne", true, 15, 65);
		Person pC = new Person("Daphne", true, 14, 65);

		Bicycle a = new Bicycle(pA);
		Bicycle b = new Bicycle(pB);
		System.out.println(a.getWeight());
		System.out.println(b.getWeight());
		System.out.println(Integer.toString(a.compareTo(b)));
		a.setDriver(pA);
		System.out.println(a.getDriver().toString());
	}
}