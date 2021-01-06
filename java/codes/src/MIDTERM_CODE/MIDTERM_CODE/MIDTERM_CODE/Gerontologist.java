package MIDTERM_CODE;

public class Gerontologist extends Doctor {
	private boolean performsHouseCalls= true;//default
	private double visitFee=0.0;

	public Gerontologist(String name) {
		super(name);
		this.performsHouseCalls= true;
		this.visitFee=0.0;
	}
	
	public Gerontologist(String name, boolean calls, double fee) {
		super(name);
		this.performsHouseCalls= calls;
		setVisitFee(fee);
	}
	
	public boolean performsHouseCalls() {
		return performsHouseCalls;
	}
	
	public double getVisitFee() {
		return visitFee;
	}
	
	public void setPerformsHouseCalls(boolean calls) {
		this.performsHouseCalls= calls;
	}
	
	public void setVisitFee(double money) {
		if(money >0.0) {
			this.visitFee=money;
		}
		else {
			this.visitFee=0.0;
		}
	}
	
	
	@Override
	//fix
	public void addPatient(Patient p) throws PatientException{
		if((2020-p.getBirthYear()) > 65) {
			super.addPatient(p);
		} else {
			throw new PatientException("Patient cannot be added");
		}
	}
	
	@Override
	public String toString() {
		String s= super.toString();
		s+= String.format("\nGerontologist: %s | visit fee= %02.2f", (performsHouseCalls ? "performs house calls": "no house calls"), visitFee);
		
		return s;
	}
	
	@Override
	public boolean equals(Object g) {
		if(g instanceof Gerontologist) {
			Gerontologist otherG= (Gerontologist)g;
			if(super.equals(otherG)) {
				if(Math.abs(this.visitFee- otherG.visitFee)<0.5){
					if(this.performsHouseCalls==otherG.performsHouseCalls) {
						return true;
					}
				}
			}
		} return false;
	}

	@Override
	public Patient[] getPatients() {
		return super.getPatients();
	}

	@Override
	public String getPatientsAsString() {
		return super.getPatientsAsString();
	}

	@Override
	public boolean isPatient(Patient p) {
		return super.isPatient(p);
	}

}
