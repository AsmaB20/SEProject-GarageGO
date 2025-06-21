package project;

import java.util.*;

public class VehicleOwner extends User {
	private String phoneNumber;
	private VehicleType vehicleType;

	public VehicleOwner(String username, String email, String phoneNumber, VehicleType vehicleType) {
		super(username, email);
		this.phoneNumber = phoneNumber;
		this.vehicleType = vehicleType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleOwner [phoneNumber=" + phoneNumber + ", vehicleType=" + vehicleType + "]";
	}

}
