package MIDTERM_CODE;

public class test {

	public static void main(String[] args) throws PatientException {
		Patient p1= new Patient("Youngjae", 1996, "cough");
		Patient p2= new Patient("Yugyeom", 1997, "cough");
		Patient p3= new Patient("Bambam", 1997, "cough");
		
		Patient p4= new Patient("Isabella", 2017, "cough");
		Patient p5= new Patient("Allison", 2015, "cough");		
		Patient p6= new Patient("Fer", 2018, "cough");
		
		Patient p7= new Patient("Tim", 1949, "cough");		
		Patient p8= new Patient("Tom", 1949, "cough");
		Patient p9= new Patient("T", 1949, "cough");
		
		Pediatrician pe1= new Pediatrician("Jinyoung", true, "JYPHospital");
		Gerontologist g1= new Gerontologist("Jaebeom", true, 10.0);
		Doctor d1= new Doctor("Jackson");
		
		
		System.out.println(Patient.getNumPatients());
	
		d1.addPatient(p4);
		d1.addPatient(p5);
		d1.addPatient(p6);
		
		//System.out.println(d1.toString());
		pe1.addPatient(p4);
		pe1.addPatient(p5);
		pe1.addPatient(p6);
		pe1.addPatient(p7);
		
		System.out.println(pe1.toString());

	}

}
