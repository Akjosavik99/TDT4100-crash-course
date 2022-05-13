package kode;

import java.util.Arrays;
import java.util.List;

public class Doctor extends Person implements Employee {

	private Hospital employer;
	private List<Employee> assistants;
	private boolean isAvailable = true;

	public Doctor(String name, int age, Hospital employer, Employee... assistants){
		super(name,age);
		this.assistants = Arrays.asList(assistants);
		this.employer = employer;
	}

	public List<Employee> getAssistants(){
		return this.assistants;
	}

	public void addAssistant(Employee assistant){
		if (!assistants.contains(assistant)){
			assistants.add(assistant);
		}
	}

	public void removeAssistant(Employee assistant){
		if (assistants.contains(assistant)){
			assistants.remove(assistant);
		}
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
