package practice;

import java.util.*;

public class VehicleOwner extends User {
    private String phoneNumber;
    private VehicleType vehicleType;
    private List<Appointment> bookings = new ArrayList<>();

    public VehicleOwner(String username, String email, String phoneNumber, VehicleType vehicleType) {
        super(username, email);
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void addBooking(Appointment appointment) {
        bookings.add(appointment);
    }

    public List<Appointment> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "VehicleOwner [phone=" + phoneNumber + ", type=" + vehicleType + "]";
    }
}

