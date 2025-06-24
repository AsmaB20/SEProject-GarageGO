
package practice;

import java.util.*;

public class BookingService {

	public static Appointment createBooking(VehicleOwner owner, GarageProfile garage, List<Service> selectedServices,
			Date selectedTime, PricingStrategy pricingStrategy) {
		if (!garage.getAvailableTimeSlots().contains(selectedTime)) {
			System.out.println("Slot not available!");
			return null;
		}

		Appointment.AppointmentBuilder builder = new Appointment.AppointmentBuilder(owner, garage)
				.setAppointmentDateTime(selectedTime).setStatus(Status.PENDING);

		for (Service service : selectedServices)
			builder.addService(service, pricingStrategy.calculatePrice(service, garage));

		Appointment appointment = builder.build();
		owner.addBooking(appointment);
		garage.removeTimeSlot(selectedTime);
		System.out.println("\n\u2705 Booking created:\n" + appointment);
		return appointment;
	}

	public static void viewBookings(VehicleOwner owner) {
		List<Appointment> bookings = owner.getBookings();
		if (bookings.isEmpty()) {
			System.out.println("\u274C No bookings found.");
			return;
		}
		System.out.println("\n\uD83D\uDCCB Your Bookings:");
		for (Appointment a : bookings)
			System.out.println("- " + a);
	}

	public static void cancelBooking(VehicleOwner owner, Appointment appointment) {
		if (!owner.getBookings().contains(appointment)) {
			System.out.println("\u274C Booking not found.");
			return;
		}
		Date now = new Date();
		long diff = appointment.getAppointmentDateTime().getTime() - now.getTime();
		if (diff < 60 * 60 * 1000) {
			System.out.println("\u274C Cannot cancel within 1 hour of the appointment.");
			return;
		}
		appointment.setStatus(Status.CANCELLED);
		owner.getBookings().remove(appointment);
		appointment.getGarage().addTimeSlot(appointment.getAppointmentDateTime());
		System.out.println(" Booking cancelled.");
	}

	public static void rescheduleBooking(VehicleOwner owner, Appointment appointment, Date newTime) {
		if (!owner.getBookings().contains(appointment)) {
			System.out.println("\u274C Booking not found.");
			return;
		}

		if (!appointment.getGarage().getAvailableTimeSlots().contains(newTime)) {
			System.out.println("\u274C New time slot not available.");
			return;
		}

		Date now = new Date();
		long diff = appointment.getAppointmentDateTime().getTime() - now.getTime();
		if (diff < 60 * 60 * 1000) {
			System.out.println("\u274C Cannot reschedule within 1 hour of the appointment.");
			return;
		}

		appointment.getGarage().addTimeSlot(appointment.getAppointmentDateTime());
		appointment.setAppointmentDateTime(newTime);
		appointment.getGarage().removeTimeSlot(newTime);
		System.out.println(" Booking rescheduled to: " + newTime);
	}
}
