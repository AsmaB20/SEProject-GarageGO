package project;

import java.util.*;

public class Main_Project {
	public static void main(String[] args) {
		VehicleOwner owner = new VehicleOwner(); // Assume constructor/init done
        GarageProfile garage = new GarageProfile(); // Assume constructor/init done
        Service oilChange = new Service(); // Assume initialized

        Appointment appointment = new Appointment.AppointmentBuilder(owner, garage)
            .setAppointmentDateTime(new Date())
            .setStatus(Status.CONFIRMED)
            .addService(oilChange, 100.0)
            .build();

        System.out.println(appointment);
	}
	
}
