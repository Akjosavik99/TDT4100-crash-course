package helse_mal;

public class Disease implements Cause {

	private Medication remedy;
	private String name;
	
	public Disease(String name) {
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

	@Override
	public Medication getRemedy() {
		return remedy;
	}

	@Override
	public void setRemedy(Medication remedy) {
		this.remedy = remedy;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

}
