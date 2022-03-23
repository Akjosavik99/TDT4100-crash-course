package lf;

public class Medication implements Comparable<Medication> {

	private String name;
	private double price = Double.NaN;

	public Medication(String name) {
		this.name = name;
	}

	public Medication(String name, double price) {
		checkPrice(price);
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		checkPrice(price);
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	private void checkPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be below zero");
		}
	}

	@Override
	public int compareTo(Medication o) {
		return Double.compare(this.getPrice(), o.getPrice());
	}

}
