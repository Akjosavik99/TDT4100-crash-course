package helse_ferdig;

public interface Cause {
	
	String getName();
	void setName(String name);
	
	Medication getRemedy();
	void setRemedy(Medication medication);

}
