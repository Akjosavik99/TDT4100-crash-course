package kode;

import java.util.ArrayList;
import java.util.List;

public class WaitingList
{

	List<Patient> patientList = new ArrayList<>();
	List<ListListener> waitingListListeners = new ArrayList<>();

	public void addPatient(Patient patient) {
		if(!this.patientList.contains(patient)) {
			this.patientList.add(patient);
		}
	}

	public void removePatient(Patient patient) {
		if(this.patientList.contains(patient)) {
			this.patientList.remove(patient);
		}
	}

	public Patient handlePatient() {
		Patient nextPatient = this.patientList.remove(0);
		System.out.println(nextPatient.getName()+" ready to be handled");
		// send til lyttere
		return nextPatient;
	}

}
