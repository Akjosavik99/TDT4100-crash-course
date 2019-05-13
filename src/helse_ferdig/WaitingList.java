package helse_ferdig;

import java.util.ArrayList;
import java.util.List;

public class WaitingList implements ObservableList {
	
	List<Patient> patientList = new ArrayList<>();
	List<ListListener> listListeners = new ArrayList<>();

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
		this.fireListChanged(nextPatient);
		return nextPatient;
	}
	

	// Observator-observable-teknikken:
	
	@Override
	public void addListener(ListListener listener) {
		if(!this.listListeners.contains(listener)) {
			this.listListeners.add(listener);
		}
	}

	@Override
	public void removeListener(ListListener listener) {
		if(this.listListeners.contains(listener)) {
			this.listListeners.remove(listener);
		}
	}

	@Override
	public void fireListChanged(Patient patient) {
		for(ListListener listener : this.listListeners) {
			listener.listChanged(patient, this.patientList.size());
		}
		
	}

}
