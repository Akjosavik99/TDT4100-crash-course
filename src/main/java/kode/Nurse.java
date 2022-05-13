package kode;



public class Nurse extends Person implements Employee {
	private Hospital employer;
	private boolean isAvailable = true;

	public Nurse(String name, int age, Hospital employer) {
		super(name, age);
		this.employer = employer;
	}

	@Override
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public Hospital getEmployer() {
		return employer;
	}
}
