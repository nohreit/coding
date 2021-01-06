package MIDTERM_CODE;

   public class Doctor implements SeesPatients{

	private static int numDoctors=0; //increment inside the constructor
	private String name;
	private int licenseNumber;
	private Patient[] patients;
	private int numOfPatients;
	
	public Doctor(String name) {
		this.name= name;
		numDoctors++;
		licenseNumber=numDoctors;
		patients= new Patient[MAX_PATIENTS];
		numOfPatients=0;
	}
	
	public static int getNumDoctors() {
		return numDoctors;
	}

	public int getLicenseNumber() {
		return licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfPatients() {
		return this.numOfPatients;
	}
	
	@Override
	public String toString() {
		return String.format("Doctor= name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString());
	}
	
	@Override
	public boolean equals(Object d) {
		if(d instanceof Doctor){
			Doctor otherD = (Doctor)d;
			if(this.name == otherD.name) {
				if(this.getNumberOfPatients() == otherD.getNumberOfPatients()) {
					return true;
				}
			 }
	    }
		return false;
    }
	
	public int compareTo(Doctor d) {
		Doctor oDoctor= (Doctor) d;

		if(this.getNumberOfPatients() > oDoctor.getNumberOfPatients()) {
			return 1;
		}
		else if(this.getNumberOfPatients() < oDoctor.getNumberOfPatients()) {
			return -1;
		}
		return 0;
	}

	@Override
	public void addPatient(Patient p) throws PatientException {
		if(this.numOfPatients != MAX_PATIENTS) {
			patients[numOfPatients++]= p;
		} else {
			throw new PatientException("Cannot add more patients");
		}
	}

	@Override
	public Patient[] getPatients() {
		return patients;
	}

	@Override
	public String getPatientsAsString() {
		String s= "patients= ";
		for(int i=0; i<this.getNumberOfPatients(); i++) {
			s+= patients[i].toString()+ (i != (this.numOfPatients -1) ? ", " : "");
		}
		return s;
	}

	@Override
	//fix
	public boolean isPatient(Patient p) {
		for(int i=0; i<numOfPatients; i++) {
			if( patients[i].equals(p))
				return true;
		}
		return false;
	}
	
}
