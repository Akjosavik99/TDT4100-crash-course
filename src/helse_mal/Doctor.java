package helse_mal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor //extends Person implements Employee //, ListListener
{
	
	private List<Employee> assistants;
	private boolean isAvailable = true;
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	/*
	public Medication diagnose(Patient patient) {
		
		PatientLog patientLog = employer.getPatientDB().getPatientLog(patient);
		
		Iterator<Symptom> patientSymptomIterator = patient.iterator();
		
		Symptom symptom = null;
		
		while (patientSymptomIterator.hasNext()) {
			
			symptom = patientSymptomIterator.next();
			
			for(Disease disease : symptom.getKnownCauses()) {
				patientLog.addDisease(disease);
				if(!patientLog.getGivenMedicationList().contains(cause.getRemedy())) {
					return cause.getRemedy();
				}
			}
		}
		return null;
	}*/
}
