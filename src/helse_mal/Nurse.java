package helse_mal;

public class Nurse extends Person //implements Employee 
{

	private Hospital employer;
	private boolean isAvailable = true;

	public Nurse(String name, int age, Hospital employer) {
		super(name, age);
		this.employer = employer;
	}

}
