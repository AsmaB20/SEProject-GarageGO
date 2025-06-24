package practice;

import java.util.*;

public class GarageProfile {
    private String name;
    private double currentDemandLevel = 1.0;
    private List<Date> availableTimeSlots = new ArrayList<>();
    private ArrayList<String> availableServiceNames = new ArrayList<>(Arrays.asList("Oil Change", "Tire Replacement", "Diagnostics"));
    private ArrayList<VehicleType> supportedVehicleTypes = new ArrayList<>(Arrays.asList(VehicleType.CAR, VehicleType.MOTORCYCLE));
    private ArrayList<Review> reviews = new ArrayList<>();

    public GarageProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCurrentDemandLevel() {
        return currentDemandLevel;
    }

    public void setCurrentDemandLevel(double currentDemandLevel) {
        this.currentDemandLevel = currentDemandLevel;
    }

    public List<Date> getAvailableTimeSlots() {
        return availableTimeSlots;
    }

    public void addTimeSlot(Date slot) {
        availableTimeSlots.add(slot);
    }

    public void removeTimeSlot(Date slot) {
        availableTimeSlots.remove(slot);
    }

    public ArrayList<String> getAvailableServiceNames() {
        return availableServiceNames;
    }

    public ArrayList<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "GarageProfile [name=" + name + ", demand=" + currentDemandLevel + "]";
    }
}
