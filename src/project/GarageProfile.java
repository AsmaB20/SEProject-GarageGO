package project;

public class GarageProfile {
	public String name;
	private double currentDemandLevel = 1.0; // Default level

	public GarageProfile(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentDemandLevel() {
		return currentDemandLevel;
	}

	public void setCurrentDemandLevel(double currentDemandLevel) {
		this.currentDemandLevel = currentDemandLevel;
	}

	@Override
	public String toString() {
		return "GarageProfile [name=" + name + ", currentDemandLevel=" + currentDemandLevel + "]";
	}
	

}
