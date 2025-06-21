package project;

import java.util.*;

import javax.swing.JOptionPane;

public class Main_Project {
	public static void main(String[] args) {
		VehicleOwner owner = new VehicleOwner("Ahmed123","ahmedAhmed@gmail.com","+9745325648",VehicleType.CAR);
        GarageProfile garage = new GarageProfile("MotorPlus");
        Service oilChange = new Service("Oil charge",64.0,30); 

        Appointment appointment = new Appointment.AppointmentBuilder(owner, garage)
            .setAppointmentDateTime(new Date())
            .setStatus(Status.CONFIRMED)
            .addService(oilChange, 100.0)
            .build();

        // Show appointment info in a dialog box
        //( just show it centered on the screen,Your message that is going to print, Title of the message, The icon behind the message
        JOptionPane.showMessageDialog(null, appointment.toString(), "Appointment Details", JOptionPane.INFORMATION_MESSAGE);

        // Demand-based pricing
        garage.setCurrentDemandLevel(1.3);

        Service service = new Service("Oil Change", 150.0, 30);
        PricingStrategy strategy = new DynamicDemandStrategy();

        double finalPrice = strategy.calculatePrice(service, garage);

        // Show final price
        JOptionPane.showMessageDialog(null, "Final Price: QAR " + finalPrice, "Pricing Result", JOptionPane.INFORMATION_MESSAGE);
    }
	
}
