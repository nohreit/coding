package MIDTERM_CODE;


public class Pediatrician extends Doctor{
	 private boolean hasPrivatePractice= false;//default
	 private String hospitalName="";//default
	 
	
	public Pediatrician(String name) {
		super(name);
	}
	
	public Pediatrician(String name, boolean practice, String hospital) {
		super(name);
		this.hasPrivatePractice=practice;
		setHospitalName(hospital);
	}
	public boolean hasPrivatePractice() {
		return hasPrivatePractice;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String name) {
		this.hospitalName=name;
	}
	
	@Override
	//fix
	public void addPatient(Patient p) throws PatientException{
		if((2020-p.getBirthYear()) < 18) {
			super.addPatient(p);
		}  else {
			throw new PatientException("Patient cannot be added");
		}
	}
	
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nPediatrician: %s | hospital name= %15s",
				(hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
	}
	
	@Override
	public boolean equals(Object p) {
		if(p instanceof Pediatrician) {
			Pediatrician otherP= (Pediatrician)p;
			if(super.equals(otherP)) {
				if(this.hasPrivatePractice== otherP.hasPrivatePractice) {
					if(this.hospitalName.equals(otherP.hospitalName)) {
						return true;
					}
				}
			}
		}return false;
		
	}

	@Override
	public Patient[] getPatients() {
		return super.getPatients();
	}

	@Override
	public String getPatientsAsString(){
		return super.getPatientsAsString();
	}
		

	@Override
	public boolean isPatient(Patient p) {
		return super.isPatient(p);
	}


}
