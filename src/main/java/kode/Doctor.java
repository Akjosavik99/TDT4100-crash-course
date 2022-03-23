package kode;

import java.util.List;

public class Doctor {

	private List<Employee> assistants;
	private boolean isAvailable = true;

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
}
