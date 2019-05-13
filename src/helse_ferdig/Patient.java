package helse_ferdig;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Patient extends Person implements Iterable<Symptom> {

	private List<Symptom> symptomsList;
	private Medication currentMedication = null;

	public Patient(String name, int age, Symptom... symptoms) {
		super(name, age);
		this.symptomsList = Arrays.asList(symptoms);
	}

	@Override
	public Iterator<Symptom> iterator() {
		return symptomsList.iterator();
	}
	
	public void receiveMedication(Medication medication) {
		if(this.currentMedication == null) {
			this.currentMedication = medication;
		} else {
			throw new IllegalArgumentException("Patient is already on medication");
		}
	}
	
	public Medication getCurrentMedication() {
		return currentMedication;
	}

	
}
