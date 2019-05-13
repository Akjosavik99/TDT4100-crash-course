package helse_ferdig;

public class MedicalCondition implements Cause {

	private Medication remedy;
	private String name;
	
	public MedicalCondition(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public Medication getRemedy() {
		return remedy;
	}
	
	public void setRemedy(Medication remedy) {
		this.remedy = remedy;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}


}
