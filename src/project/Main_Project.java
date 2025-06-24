package project;

import java.util.*;

import javax.swing.JOptionPane;

public class Main_Project {
	public static void main(String[] args) {
		// Create owner and garages
        VehicleOwner owner = new VehicleOwner("Ahmed123", "ahmedAhmed@gmail.com", "+9745325648", VehicleType.CAR);
        GarageProfile garage1 = new GarageProfile("MotorPlus");
        garage1.setCurrentDemandLevel(1.3);
        GarageProfile garage2 = new GarageProfile("Quick Change");

        // Add available time for MotorPlus
        Date bookingTime = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000); // 2 hours later
        garage1.addTimeSlot(bookingTime);

        // Create service
        Service oilChange = new Service("Oil charge", 64.0, 30);

        // Book an appointment
        Appointment appointment = BookingService.createBooking(
            owner, garage1,
            Arrays.asList(oilChange),
            bookingTime,
            new FixedPriceStrategy()
        );

        // Show appointment in a popup
        JOptionPane.showMessageDialog(null, appointment.toString(), "Appointment Details", JOptionPane.INFORMATION_MESSAGE);

        // View all bookings for the user
        BookingService.viewBookings(owner);

        // Add garages to search service
        SearchService.AddGarages(new GarageProfile[]{garage1, garage2});
        SearchService.searchGaragesByService("Oil Change");
        SearchService.searchGaragesByVehicleType(VehicleType.CAR);

        // Add reviews to Quick Change
        Review r1 = new Review(owner, garage2, "Excellent service and friendly staff!", 5);
        Review r2 = new Review(owner, garage2, "Quick and affordable.", 4);
        ReviewService.addReview(garage2, r1);
        ReviewService.addReview(garage2, r2);

        // Show reviews
        ReviewService.showReviews(garage2);
        ReviewService.showReviews(garage1);
    }
}
