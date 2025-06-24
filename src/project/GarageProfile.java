package project;

import java.util.ArrayList;
import java.util.Arrays;

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
/////Added methods for searchService//////
	
	private ArrayList<String> availableServiceNames = new ArrayList<>(Arrays.asList("Oil Change", "Tire Replacement", "Diagnostics"));
	private ArrayList<VehicleType> supportedVehicleTypes = new ArrayList<>(Arrays.asList(VehicleType.CAR, VehicleType.MOTORCYCLE));

	public ArrayList<String> getAvailableServiceNames() {
	    return availableServiceNames;
	}

	public ArrayList<VehicleType> getSupportedVehicleTypes() {
	    return supportedVehicleTypes;
	}
	
	/////Methods for reviews////
	// ========== Add this to your GarageProfile class ==========
	private ArrayList<Review> reviews = new ArrayList<>();

	public ArrayList<Review> getReviews() {
	    return reviews;
	}

}
