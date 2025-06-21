package project;

public class Service {
	private String name;
	private double basePrice;
	private int durationInMinutes;

	public Service(String name, double basePrice, int durationInMinutes) {
		this.name = name;
		this.basePrice = basePrice;
		this.durationInMinutes = durationInMinutes;
	}

	public String getName() {
		return name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	@Override
	public String toString() {
		return "Service [name=" + name + ", basePrice=" + basePrice + ", durationInMinutes=" + durationInMinutes + "]";
	}

}
