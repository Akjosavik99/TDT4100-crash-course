package kode;

public interface Employee {

    void setAvailable(boolean isAvailable);
    boolean isAvailable();
    void medicate(Patient patient, Medication medication);
    Hospital getEmployer();
    
}
