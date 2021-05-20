package lf;

import java.util.ArrayList;
import java.util.Collection;

public class PatientDatabase {

	private Collection<PatientLog> patientLogs = new ArrayList<>();

	public PatientLog getPatientLog(Patient patient) {
		return patientLogs
				.stream()
				.filter(patientLog -> patientLog.getPatient() == patient)
				.findFirst()
				.orElseThrow(
						() -> new IllegalArgumentException("Patient does not have a log")
				);
	}

	// Legger til PatientLog dersom Patient-objektet vi gir som input
	// ikke allerede har en tilhørende PatientLog i systemet
	public void addPatientLog(Patient patient) {
		if (patientLogs.stream()
					   .anyMatch(patientLog -> patientLog.getPatient() == patient))
		{
			throw new IllegalArgumentException("Patient already has a registered PatientLog");
		}
		patientLogs.add(new PatientLog(patient));
	}

	public void removePatientLog(PatientLog patientLog) {
		if (patientLogs.contains(patientLog)) {
			patientLogs.remove(patientLog);
		}
	}


}
