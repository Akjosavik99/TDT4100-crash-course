package helse_mal;

import java.util.ArrayList;
import java.util.List;

public class Symptom {
	
	private List<Cause> knownCauses = new ArrayList<>();
	private String description;
	
	public Symptom(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Cause> getKnownCauses() {
		return knownCauses;
	}
	
	public void addKnownCause(Cause cause) {
		if (!knownCauses.contains(cause)) {
			knownCauses.add(cause);
		}
	}


	@Override
	public String toString() {
		return this.getDescription();
	}

	

}
