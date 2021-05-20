package lf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Person implements Employee, ListListener
{

	private Hospital employer;
	private List<Employee> assistants;
	private boolean isAvailable = true;

	public Doctor(String name, int age, Hospital employer, Employee... assistants) {
		super(name, age);
		this.assistants = Arrays.asList(assistants);
		this.employer = employer;
	}

	public List<Employee> getAssistants() {
		return assistants;
	}

	public void addAssistant(Employee assistant) {
		if (!assistants.contains(assistant)) {
			assistants.add(assistant);
		}
	}

	public void removeAssistant(Employee assistant) {
		if (assistants.contains(assistant)) {
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

	public List<Nurse> getNurseList() {
		return assistants
				.stream()
				.filter(e -> e instanceof Nurse)
				.map(e -> (Nurse) e)
				.collect(Collectors.toList());
	}

	public Medication diagnose(Patient patient) {
		PatientLog patientLog = employer.getPatientDB().getPatientLog(patient);
		Iterator<Symptom> patientSymptomIterator = patient.iterator();
		Symptom symptom = null;

		while(patientSymptomIterator.hasNext()) {
			symptom = patientSymptomIterator.next();
			for(Disease cause : symptom.getKnownCauses()) {
				patientLog.addDisease(cause);
				if (!patientLog.getGivenMedicationList().contains(cause.getRemedy())) {
					return cause.getRemedy();
				}
			}
		}
		return null;
	}

	@Override
	public void medicate(Patient patient, Medication medication) {
		if (medication == null) {
			return;
		}
		Nurse randomNurse = this.getNurseList().get((int) Math.floor(Math.random()*getNurseList().size()));
		randomNurse.medicate(patient, medication);
	}

	@Override
	public void listChanged(Patient patient) {
		if (this.isAvailable && patient.getCurrentMedication() == null) {
			System.out.println(this.getName() +" handled "+ patient.getName());
			this.medicate(patient, diagnose(patient));
		}
	}

}
