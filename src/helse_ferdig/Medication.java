package helse_ferdig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medication implements Comparable<Medication> {

	private String name;
	private double price = Double.NaN;

	public Medication(String name) {
		this.name = name;
	}
	
	public Medication(String name, double price) {
		if(price < 0) throw new IllegalArgumentException("Invalid price");
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if(price < 0) throw new IllegalArgumentException("Invalid price");
		this.price = price;
	}

	// Comparable-grensesnittet:
	@Override
	public int compareTo(Medication medication) {
		return Double.compare(this.getPrice(), medication.getPrice());
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	public static void main(String[] args) {
		List<Medication> meds = new ArrayList<>();
		meds.add(new Medication("Naproxen", 100));
		meds.add(new Medication("Fanalgin", 150));
		meds.add(new Medication("Paracet", 90));
		
		System.out.println(meds);
		Collections.sort(meds);
		System.out.println(meds);
	}

}
