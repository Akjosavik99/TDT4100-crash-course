package helse_mal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

	public class PatientLog {

	// private List<MedicalCondition> knownConditionsList = new ArrayList<>();
	private Collection<Disease> knownDiseasesList = new ArrayList<>();
	private Collection<Medication> givenMedicationList = new ArrayList<>();
	
	private final Patient patient;
	
	public PatientLog(Patient patient) {
		this.patient = patient;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void addMedication(Medication medication) {
		if (!givenMedicationList.contains(medication)) {
			givenMedicationList.add(medication);
		}
	}
	
	public void addDisease(Disease disease) {
		if (!knownDiseasesList.contains(disease)) {
			knownDiseasesList.add(disease);
		}
	}
	
	
	public Collection<Medication> getGivenMedicationList() {
		return givenMedicationList;
	}
	
	public Collection<Disease> getKnownDiseasesList() {
		return knownDiseasesList;
	}
}
