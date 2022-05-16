package kode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Patient extends Person implements Iterable<Symptom>{

    private List<Symptom> symptomsList;
    private Medication currentMedication = null;


    public Patient(String name, int age, Symptom symptom, Symptom fever) {
        super(name, age);
        this.symptomsList = Arrays.asList(symptom);
    }

    @Override
    public Iterator<Symptom> iterator() {
        return symptomsList.iterator();
    }

    public void recieveMedication(Medication medication){
        if (currentMedication == null){
            this.currentMedication = medication;
        }
        else{
            throw new IllegalStateException("Patient is already on medication.");
        }
    }

    public Medication getCurrentMedication(){
        return this.currentMedication;
    }

    public void stopMedication(){
        this.currentMedication = null;
    }
}
