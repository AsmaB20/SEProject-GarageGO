package project;

import java.util.*;

public class Appointment {
	private VehicleOwner vehicleOwner;
    private GarageProfile garage;
    private Date appointmentDateTime;
    private Status status;
    private Map<Service, Double> services;
    
 // Private constructor used by the builder
    private Appointment(AppointmentBuilder builder) {
        this.vehicleOwner = builder.vehicleOwner;
        this.garage = builder.garage;
        this.appointmentDateTime = builder.appointmentDateTime;
        this.status = builder.status;
        this.services = builder.services;
    }

	public VehicleOwner getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(VehicleOwner vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public GarageProfile getGarage() {
		return garage;
	}

	public void setGarage(GarageProfile garage) {
		this.garage = garage;
	}

	public Date getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Map<Service, Double> getServices() {
		return services;
	}

	public void setServices(Map<Service, Double> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentDateTime, garage, services, status, vehicleOwner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(appointmentDateTime, other.appointmentDateTime) && Objects.equals(garage, other.garage)
				&& Objects.equals(services, other.services) && status == other.status
				&& Objects.equals(vehicleOwner, other.vehicleOwner);
	}

	@Override
	public String toString() {
		return "Appointment [vehicleOwner=" + vehicleOwner + ", garage=" + garage + ", appointmentDateTime="
				+ appointmentDateTime + ", status=" + status + ", services=" + services + "]";
	}
    

}
