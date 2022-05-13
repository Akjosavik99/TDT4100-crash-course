package kode;

public interface Employee {

    void setAvailable(boolean isAvailable);
    boolean isAvailable();
    
    Hospital getEmployer();
}
