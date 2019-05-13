package helse_ferdig;

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

	public void save(String path) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		System.out.println("Writing to file");
		
		String log = "";
		
		for(Disease disease : this.knownDiseasesList) {
			log += disease.toString() + ",";
		}
		log += "\n";
		for(Medication medication : this.givenMedicationList) {
			log += medication.toString() + ",";
		}
		
		writer.write(log);
		writer.close();
	}

	public void load(String path) throws IOException {
		
	    BufferedReader reader = new BufferedReader(new FileReader(path));
		System.out.println("Reading from file");
		
	    String currentLine = reader.readLine();
	    
	    this.knownDiseasesList = Arrays.asList(currentLine.split(","))
	    							   .stream()
	    							   //.filter(s -> !s.equals(""))
	    							   .map(s -> new Disease(s))
	    							   .collect(Collectors.toList());

	    currentLine = reader.readLine();
	    
	    this.givenMedicationList = Arrays.asList(currentLine.split(","))
	    							   .stream()
	    							   //.filter(s -> !s.equals(""))
	    							   .map(s -> new Medication(s))
	    							   .collect(Collectors.toList());
	    
	    reader.close();
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
