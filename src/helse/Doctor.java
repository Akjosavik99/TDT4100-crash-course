package helse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Person implements Employee, ListListener {
	
	private Hospital employer;
	private List<Employee> assistants;
	private boolean isAvailable = true;

	public Doctor(String name, int age, Hospital employer) {
		super(name, age);
		this.employer = employer;
		this.assistants = new ArrayList<>();
	}

	public Doctor(String name, int age, Hospital employer, Employee... assistants) {
		super(name, age);
		this.employer = employer;
		this.assistants = Arrays.asList(assistants);
	}
	
	/* Kunne eventuelt ha skrevet konstruktøren ovenfor på følgende måte vha this():
		public Doctor(String name, int age, Hospital employer, Employee... assistants) {
			this(name, age, employer);
			this.assistants = Arrays.asList(assistants);
		} 
	 */
	
	public List<Nurse> getNurseList() {
		return assistants.stream().filter(employee -> employee instanceof Nurse)
							      .map(e -> (Nurse) e)
							      .collect(Collectors.toList());
		
	}
	
	public List<Employee> getAssistants() {
		return assistants;
	}
	
	
	@Override
	public void medicate(Patient patient, Medication medication) {
		if(patient.getCurrentMedication() == null && medication != null) {
			System.out.println(this.getName() +" handled "+ patient.getName());
			Nurse randomNurse = this.getNurseList().get((int) Math.floor(Math.random()*this.getNurseList().size()));
			randomNurse.medicate(patient, medication);
		}
	}
	
	
	public Medication diagnose(Patient patient) {
		
		PatientLog patientLog = employer.getPatientDB().getPatientLog(patient);
		
		Iterator<Symptom> patientSymptomIterator = patient.iterator();
		
		Symptom symptom = null;
		
		while (patientSymptomIterator.hasNext()) {
			
			symptom = patientSymptomIterator.next();
			
			for(Cause cause : symptom.getKnownCauses()) {
				patientLog.addDisease((Disease) cause);
				if(!patientLog.getGivenMedicationList().contains(cause.getRemedy())) {
					return cause.getRemedy();
				}
			}
		}
		return null;
	}

	@Override
	public Hospital getEmployer() {
		return this.employer;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public void listChanged(Patient patient, int listSize) {
		if(this.isAvailable()) {
			this.medicate(patient, diagnose(patient));
		}
	}
	
}
