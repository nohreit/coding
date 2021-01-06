package cmp168FinalProject;

public class test {

	public static void main(String[] args) throws InvalidDriverException {
		
		Person p1= new Person("Mark", false, 21, 68);
		Person p2= new Person("Johnny", true, 24, 72);
		Person p3= new Person ("Doyoung", false, 24, 70);
		Person p4= new Person("Taeyong", false, 24, 68);
		Person p5= new Person("Zeni", false, 4, 35);
		
		int [] seats = new int[]{2, 3};
		Car c1= new Car(4, 4, p2, seats);
		c1.loadPassenger(p1);
		Person [] peeps= {p5, p4, p3};
		c1.loadPassengers(peeps);
//		c1.loadPassenger(p5);
//		c1.loadPassenger(p3);
//		c1.loadPassenger(p4);
	
//		pln(p1.toString());
//		pln(p2.toString());
//		pln(p3.toString());
//		pln(p4.toString());
//		pln(p5.toString());
//		pln(c1.getNumberOfAvailableSeats() + " getNumberOfAvailableSeats method returns an int\n");
//		pln(c1.getNumberOfAvailableSeatsInRow(0) + " getNumberOfAvailableSeatsInRow method returns an int\n");
//		pln(c1.getNumberOfPeopleInRow(0) + " getNumberOfPeopleInRow method returns an int\n");
//		pln(c1.getNumberOfPeopleOnBoard() + " getNumberOfPeopleOnBoard method returns an int\n");
//		pln(c1.getPersonInSeat(0, 0) + " getPersonInSeat method returns a Person\n");
//		pln("Location: ["+c1.getLocationOfPersonInVehicle(p1)[0]+", "+c1.getLocationOfPersonInVehicle(p1)[1]
//				+"]"
//				+" getLocationOfPersonInVehicle method returns an int[]\n");
		pln("Driver: "+c1.getPeopleInRow(0)[0].toString() + " getPeopleInRow method returns a Person[]\n");
		pln("Seat 1: "+c1.getPeopleInRow(0)[1].toString() + " getPeopleInRow method returns a Person[]\n");
		pln("Seat 2: "+c1.getPeopleInRow(1)[0].toString() + " getPeopleInRow method returns a Person[]\n");
		pln("Seat 3: "+c1.getPeopleInRow(1)[1].toString() + " getPeopleInRow method returns a Person[]\n");
//		pln("Seat 4: "+c1.getPeopleInRow(1)[2].toString() + " getPeopleInRow method returns a Person[]\n");

//		pln(c1.getPeopleOnBoard()[0][0].toString() + " getPeopleOnBoard method returns a Person [][]\n");
//		pln(c1.isPersonInVehicle(p1)+ " isPersonInVehicle method returns a boolean\n");
//		pln(c1.isPersonDriver(p2) + " isPersonDriver method returns a boolean\n");
//		pln(c1.isPersonInVehicle(p2)+ " isPersonInVehicle method returns a boolean\n");
//		pln(c1.isPersonInVehicle(p3)+ " isPersonInVehicle method returns a boolean\n");
//		pln(c1.isPersonInVehicle(p4)+ " isPersonInVehicle method returns a boolean\n");
//		pln(c1.isPersonInVehicle(p5)+ " isPersonInVehicle method returns a boolean\n");
		


	}

	public static void p(Object o){
		System.out.print(o);
	}
	public static void pln(Object o){
		System.out.println(o);
	}
}
