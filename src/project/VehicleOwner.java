package project;

import java.util.*;

public class VehicleOwner extends User {
	private String phoneNumber;
	private Set<Appointment> appointments;
	private VehicleType vehicleType;

	public VehicleOwner(String username, String email, String phoneNumber, VehicleType vehicleType) {
		super(username, email);
		this.phoneNumber = phoneNumber;
		this.vehicleType = vehicleType;
		this.appointments = new HashSet<>();

	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleOwner [phoneNumber=" + phoneNumber + ", appointments=" + appointments + ", vehicleType="
				+ vehicleType + "]";
	}

}
