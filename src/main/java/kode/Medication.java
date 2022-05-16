package kode;

public class Medication implements Comparable<Medication> {

	private String name;
	private double price = Double.NaN;

	public Medication(String name){
		this.name = name;
	}

	public Medication(String name, double price){
		this(name);
		checkPrice(price);
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
		checkPrice(price);
		this.price = price;
	}
	
	private void checkPrice(double price){
		if (price < 0){
			throw new IllegalArgumentException("Price cannot be below zero");
		}
	}

	@Override
	public int compareTo(Medication m) {
		return Double.compare(this.getPrice(), m.getPrice());
	}

}
