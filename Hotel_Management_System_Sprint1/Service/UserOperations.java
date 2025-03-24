package Service;
import java.sql.SQLException;
import java.util.*;
public class UserOperations {
	public static void displayUserOperations() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n-------------------- Customer Menu ---------------------");
		String userOperations[] = {"Reservation","Booking History","Room Status","Checkout/Billing","Complaint&Feedback","Contact Support","Main Menu","Exit"};
		for(int i=0; i<userOperations.length; i++)   System.out.println(i+1 + ". "+ userOperations[i]);
		System.out.println("Enter Choice:");
		int choice = scanner.nextInt();		
		switch(choice) {
		case 1:
			US004_ReservationPage reservation = new US004_ReservationPage();
			reservation.reservationMenu();		
			break;
		case 2:
			US005_ViewPreviousBookings booking = new US005_ViewPreviousBookings();
			booking.userBookingHistory();
			break;
		case 3:
			US008_CheckRoomStatus.showRoomStatusForCustomer();
			break;
		case 4:
			US009_UserCheckoutPage ch = new US009_UserCheckoutPage();
			ch.checkoutDetails();
			break;
		case 5:
			US006_ComplaintSystem complaint = new US006_ComplaintSystem();
			complaint.customerComplaint();
			break;
		case 6:
			US007_CustomerSupport support = new US007_CustomerSupport();
			support.displaySupport();
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