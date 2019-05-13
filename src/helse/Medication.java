package helse;

public class Medication implements Comparable<Medication> {

	private String name;
	private double price = Double.NaN;

	public Medication(String name) {
		this.name = name;
	}
	
	public Medication(String name, double price) {
		this.name = name;
		if(price < 0) throw new IllegalArgumentException("Invalid price");
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

}
