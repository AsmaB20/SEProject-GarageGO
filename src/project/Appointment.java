package project;

import java.util.*;

<<<<<<< Updated upstream
	public Appointment(String name) {
		super();
		this.name = name;
	}
=======
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

>>>>>>> Stashed changes
}
