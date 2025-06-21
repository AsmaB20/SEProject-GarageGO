package project;

import java.util.*;

public class Main_Project {
	public static void main(String[] args) {
		VehicleOwner owner = new VehicleOwner("Ahmed123","ahmedAhmed@gmail.com","+9745325648",VehicleType.CAR);
        GarageProfile garage = new GarageProfile();
        Service oilChange = new Service("Oil charge",64.0,30); 

        Appointment appointment = new Appointment.AppointmentBuilder(owner, garage)
            .setAppointmentDateTime(new Date())
            .setStatus(Status.CONFIRMED)
            .addService(oilChange, 100.0)
            .build();

        System.out.println(appointment);
        
        garage.setCurrentDemandLevel(1.3);

        Service service = new Service("Oil Change", 150.0, 30);
        PricingStrategy strategy = new DynamicDemandStrategy();

        double finalPrice = strategy.calculatePrice(service, garage);
        System.out.println("Final Price: " + finalPrice);
	}
	
}
