package project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GarageGoSystem {
	private static Scanner scanner = new Scanner(System.in);
    private static VehicleOwner currentUser;
    private static List<GarageProfile> garages = new ArrayList<>();
    private static List<Service> availableServices = new ArrayList<>();
    private static PricingStrategy pricingStrategy = new FixedPriceStrategy();
    
    public static void initializeData() {
        // Create some sample garages
        GarageProfile garage1 = new GarageProfile("MotorPlus");
        garage1.setCurrentDemandLevel(1.3);
        garage1.addTimeSlot(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 2 hours later
        garage1.addTimeSlot(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)); // 1 day later

        GarageProfile garage2 = new GarageProfile("Quick Change");
        garage2.addTimeSlot(new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000)); // 3 hours later
        
        garages.add(garage1);
        garages.add(garage2);
        SearchService.AddGarages(garages.toArray(new GarageProfile[0]));// to create an empty list and to let JVM know the type of the sending list and to convert an ArrayList to array normal

        // Create some sample services
        availableServices.add(new Service("Oil Change", 64.0, 30));
        availableServices.add(new Service("Tire Replacement", 120.0, 60));
        availableServices.add(new Service("Diagnostics", 85.0, 45));
    }

    public static void loginMenu() {
        System.out.println("\n=== Welcome to Garage Booking System ===");
        System.out.println("1. Login as Vehicle Owner");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                loginAsOwner();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                loginMenu();
        }
    }

    private static void loginAsOwner() {
        System.out.println("\n=== Vehicle Owner Login ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        
        System.out.println("Select your vehicle type:");
        System.out.println("1. CAR\n2. MOTORCYCLE\n3. TRUCK");
        System.out.print("Choose (1-3): ");
        int typeChoice = scanner.nextInt();
        VehicleType type = VehicleType.values()[typeChoice - 1];
        
        currentUser = new VehicleOwner(username, email, phone, type);
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Book a new appointment");
            System.out.println("2. View my bookings");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Reschedule a booking");
            System.out.println("5. Search for garages");
            System.out.println("6. View garage reviews");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    rescheduleBooking();
                    break;
                case 5:
                    searchGaragesMenu();
                    break;
                case 6:
                    viewReviews();
                    break;
                case 7:
                    currentUser = null;
                    loginMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookAppointment() {
        System.out.println("\n=== Book New Appointment ===");
        
        // Show available services
        System.out.println("\nAvailable Services:");
        for (int i = 0; i < availableServices.size(); i++) {
            System.out.println((i + 1) + ". " + availableServices.get(i).getName() + 
                              " (QAR " + availableServices.get(i).getBasePrice() + 
                              ", " + availableServices.get(i).getDurationInMinutes() + " mins)");
        }
        
        System.out.print("Select services : ");
        String[] serviceChoices = scanner.nextLine().split(",");
        List<Service> selectedServices = new ArrayList<>();
        
        for (String choice : serviceChoices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            if (index >= 0 && index < availableServices.size()) {
                selectedServices.add(availableServices.get(index));
            }
        }
        
        // Search for garages that support these services
        System.out.println("\nAvailable Garages for your services:");
        List<GarageProfile> suitableGarages = new ArrayList<>();
        for (GarageProfile garage : garages) {
            boolean supportsAll = true;
            for (Service service : selectedServices) {
                if (!garage.getAvailableServiceNames().contains(service.getName())) {
                    supportsAll = false;
                    break;
                }
            }
            if (supportsAll && garage.getSupportedVehicleTypes().contains(currentUser.getVehicleType())) {
                suitableGarages.add(garage);
            }
        }
        
        if (suitableGarages.isEmpty()) {
            System.out.println("No garages available for your selected services.");
            return;
        }
        
        for (int i = 0; i < suitableGarages.size(); i++) {
            System.out.println((i + 1) + ". " + suitableGarages.get(i).getName());
        }
        
        System.out.print("Select a garage: ");
        int garageChoice = scanner.nextInt() - 1;
        GarageProfile selectedGarage = suitableGarages.get(garageChoice);
        
        // Show available time slots
        System.out.println("\nAvailable Time Slots:");
        List<Date> availableSlots = selectedGarage.getAvailableTimeSlots();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm a");
        
        for (int i = 0; i < availableSlots.size(); i++) {
            System.out.println((i + 1) + ". " + sdf.format(availableSlots.get(i)));
        }
        
        System.out.print("Select a time slot: ");
        int timeChoice = scanner.nextInt() - 1;
        Date selectedTime = availableSlots.get(timeChoice);
        
        // Choose pricing strategy
        System.out.println("\nSelect Pricing Strategy:");
        System.out.println("1. Fixed Price");
        System.out.println("2. Dynamic Pricing (based on demand)");
        System.out.print("Choose (1-2): ");
        int pricingChoice = scanner.nextInt();
        
        PricingStrategy strategy = (pricingChoice == 1) ? new FixedPriceStrategy() : new DynamicDemandStrategy();
        
        // Create booking
        Appointment appointment = BookingService.createBooking(
            currentUser, 
            selectedGarage, 
            selectedServices, 
            selectedTime, 
            strategy
        );
        
        if (appointment != null) {
            System.out.println("\nBooking created successfully!");
            System.out.println(appointment);
        }
    }

    private static void viewBookings() {
        BookingService.viewBookings(currentUser);
    }

    private static void cancelBooking() {
        List<Appointment> bookings = currentUser.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("You have no bookings to cancel.");
            return;
        }
        
        System.out.println("\nYour Bookings:");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }
        
        System.out.print("Select a booking to cancel: ");
        int choice = scanner.nextInt() - 1;
        
        BookingService.cancelBooking(currentUser, bookings.get(choice));
    }

    private static void rescheduleBooking() {
        List<Appointment> bookings = currentUser.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("You have no bookings to reschedule.");
            return;
        }
        
        System.out.println("\nYour Bookings:");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }
        
        System.out.print("Select a booking to reschedule: ");
        int choice = scanner.nextInt() - 1;
        Appointment selectedAppointment = bookings.get(choice);
        
        // Show available time slots
        System.out.println("\nAvailable Time Slots:");
        List<Date> availableSlots = selectedAppointment.getGarage().getAvailableTimeSlots();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm a");
        
        for (int i = 0; i < availableSlots.size(); i++) {
            System.out.println((i + 1) + ". " + sdf.format(availableSlots.get(i)));
        }
        
        System.out.print("Select a new time slot: ");
        int timeChoice = scanner.nextInt() - 1;
        Date newTime = availableSlots.get(timeChoice);
        
        BookingService.rescheduleBooking(currentUser, selectedAppointment, newTime);
    }

    private static void searchGaragesMenu() {
        System.out.println("\n=== Search Garages ===");
        System.out.println("1. Search by service");
        System.out.println("2. Search by vehicle type");
        System.out.println("3. Back to main menu");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                System.out.print("Enter service name to search: ");
                String serviceName = scanner.nextLine();
                SearchService.searchGaragesByService(serviceName);
                break;
            case 2:
                System.out.println("Select vehicle type:");
                System.out.println("1. CAR\n2. MOTORCYCLE\n3. TRUCK");
                System.out.print("Choose (1-3): ");
                int typeChoice = scanner.nextInt();
                VehicleType type = VehicleType.values()[typeChoice - 1];
                SearchService.searchGaragesByVehicleType(type);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void viewReviews() {
        System.out.println("\n=== View Garage Reviews ===");
        for (int i = 0; i < garages.size(); i++) {
            System.out.println((i + 1) + ". " + garages.get(i).getName());
        }
        
        System.out.print("Select a garage to view reviews: ");
        int choice = scanner.nextInt() - 1;
        
        ReviewService.showReviews(garages.get(choice));
    }
}

