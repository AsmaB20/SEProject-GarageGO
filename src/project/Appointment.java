package project;

import java.util.*;

public class Appointment {
	// Required parameters
	private VehicleOwner vehicleOwner;
	private GarageProfile garage;
	// Optional parameters
	private Date appointmentDateTime;
	private Status status;
	private Map<Service, Double> services;

	// Private constructor
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
		return "Appointment [\nvehicleOwner=" + vehicleOwner + ", \ngarage=" + garage + ", \nappointmentDateTime="
				+ appointmentDateTime + ", \nstatus=" + status + ", \nservices=" + services + "]";
	}

	public static class AppointmentBuilder {
		// Required parameters
		private VehicleOwner vehicleOwner;
		private GarageProfile garage;
		// Optional parameters
		private Date appointmentDateTime;
		private Status status;
		private Map<Service, Double> services;

		// Constructor for required parameters

		public AppointmentBuilder(VehicleOwner vehicleOwner, GarageProfile garage) {
			this.vehicleOwner = vehicleOwner;
			this.garage = garage;
			services= new HashMap<>();
		}

		public Appointment build() {
			return new Appointment(this);
		}

		// Instead of the setter
		public AppointmentBuilder addService(Service service, double price) {
			if (service != null && price != 0.0)
				this.services.put(service, price);
			return this;
		}

		public AppointmentBuilder setAppointmentDateTime(Date date) {
		    this.appointmentDateTime = date;
		    return this;
		}

		public AppointmentBuilder setStatus(Status status) {
		    this.status = status;
		    return this;
		}
		@Override
		public String toString() {
			return "AppointmentBuilder [vehicleOwner=" + vehicleOwner + ", garage=" + garage + ", appointmentDateTime="
					+ appointmentDateTime + ", status=" + status + ", services=" + services + "]";
		}

	}

}
