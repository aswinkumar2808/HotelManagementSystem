package Service;

import java.sql.SQLException;
import java.util.Scanner;
import Service.US003_LoginMenu;

public class AdminOperations {
	public static void displayAdminOperations() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n-------------------- Admin Menu ---------------------");
		String adminOperations[] = {"Booking Hotel Servics","Booking History","Booking History By Id","Room Status","Check-Out Billing Invoice","View Active Complaints","Main Menu","Exit"};
		for(int i=0; i<adminOperations.length; i++)   System.out.println(i+1 + ". "+ adminOperations[i]);
		
		System.out.println("Enter Choice:\n");
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			US011_BookingService booking = new US011_BookingService();
			booking.displayBookingServices();
			break;
		case 2:
			US013_BookingHistory bookingHistory = new US013_BookingHistory();
			bookingHistory.displayPreviousBookings();
			break;
		case 3:
			US014_BookingHistoryById adminBooking = new US014_BookingHistoryById();
			adminBooking.showBookingHistory();
			break;
		case 4:
			US008_CheckRoomStatus.showRoomStatusForAdmin();
			break;
		case 5:
			US015_InvoiceGeneration invoice = new US015_InvoiceGeneration();
			invoice.generateInvoice();
			break;
		case 6:
			US012_ActiveComplaintsCount activeCount = new US012_ActiveComplaintsCount();
			activeCount.displayActiveComplaintsCount();
			break;
		case 7:
			US002_LoginMenuDisplay.displayMenu();
			break;
		case 8:
			System.out.println("Thanks for visiting");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}
}
