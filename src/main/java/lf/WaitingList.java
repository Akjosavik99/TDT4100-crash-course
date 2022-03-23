package lf;

import java.util.ArrayList;
import java.util.List;

public class WaitingList implements ObservableList {

	List<Patient> patientList = new ArrayList<>();
	List<ListListener> waitingListListeners = new ArrayList<>();

	public void addPatient(Patient patient) {
		if (!this.patientList.contains(patient)) {
			this.patientList.add(patient);
		}
	}

	public void removePatient(Patient patient) {
		if (this.patientList.contains(patient)) {
			this.patientList.remove(patient);
		}
	}

	public Patient handlePatient() {
		Patient nextPatient = this.patientList.remove(0);
		System.out.println(nextPatient.getName() + " ready to be handled");
		fireListChanged(nextPatient);
		return nextPatient;
	}

	@Override
	public void addListener(ListListener listener) {
		if (!this.waitingListListeners.contains(listener)) {
			this.waitingListListeners.add(listener);
		}
	}

	@Override
	public void removeListener(ListListener listener) {
		if (this.waitingListListeners.contains(listener)) {
			this.waitingListListeners.remove(listener);
		}
	}

	@Override
	public void fireListChanged(Patient patient) {
		waitingListListeners.forEach(listener -> listener.listChanged(patient));
	}

}
