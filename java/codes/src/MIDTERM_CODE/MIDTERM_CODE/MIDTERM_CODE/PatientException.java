package MIDTERM_CODE;

public class PatientException extends Exception{

	public PatientException() {
		System.out.println("Cannot add anymore patient");
	}
	
	public PatientException(String e) {
		System.out.println(e);
	}
}
