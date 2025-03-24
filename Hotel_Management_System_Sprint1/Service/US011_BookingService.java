package Service;
import java.sql.SQLException;
import java.util.*;

import Model.Booking;
public class US011_BookingService {
	static int noOfCustomer=0;
	static int temp=0;
	public void displayBookingServices() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Booking[] b=new Booking[50];
		int choice;
		
		do{
			System.out.println("1. To add booking");
			System.out.println("2. To update booking");
			System.out.println("3. To delete booking");
			System.out.println("4. Go to Main Menu");
			
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
				case 1:{
					System.out.println("How many booking want to create? ");
					int n=sc.nextInt();	
					addBooking(b,n);
					break;
				}
				case 2:{
					System.out.println("Enter customer id to update : ");
					int cId=sc.nextInt();
					updateBooking(cId,b);
					break;
				}
				case 3:{
					System.out.println("Enter customer id to delete : ");
					int cId=sc.nextInt();
					deleteBooking(cId,b);
					break;
				}
				case 4:{
					AdminOperations.displayAdminOperations();
					break;
				}
			
			}
		}while(choice!=4);

	}
	public static void addBooking(Booking[] b, int n) {
		Scanner in1=new Scanner(System.in);
		temp=temp+n;
		for(int i=noOfCustomer;i<temp;i++) {
			System.out.println("Enter Booking Id: ");
			int bookingId=in1.nextInt();
			in1.nextLine();
			System.out.println("Enter the Room type: ");
			String roomTypeSelection=in1.nextLine();
			System.out.println("Enter Room Price: ");
			double price=in1.nextDouble();
			
			b[i]=new Booking(bookingId,roomTypeSelection,price);
		}
		noOfCustomer = noOfCustomer + n;
	
		for(int i=0;i<noOfCustomer;i++) {
			System.out.println("Booking Id : "+b[i].getBookingId());
			System.out.println("Room Type : "+b[i].getRoomTypeSelection());
			System.out.println("price : "+b[i].getPrice());
		}	
		
	}
	public static void updateBooking(int cId,Booking[] b) {
		Scanner in2=new Scanner(System.in);
		for(int i=0;i<noOfCustomer;i++) {
			if(b[i]!=null) {
			if(b[i].getBookingId() == cId) {
				String roomType=in2.nextLine();
				b[i].setRoomTypeSelection(roomType);			
			}
			}				
		}	
		for(int i=0;i<noOfCustomer;i++) {
			System.out.println("Booking Id : "+b[i].getBookingId());
			System.out.println("Room Type : "+b[i].getRoomTypeSelection());
			System.out.println("price : "+b[i].getPrice());
		}	
		}
	public static void deleteBooking(int cId,Booking[]b ) {
		
		for(int i=0;i<noOfCustomer;i++) {
			if(b[i].getBookingId() == cId) {				
				b[i]=b[i+1];				
			}			
		}
		System.out.println("customer detail is deleted");
		noOfCustomer--;
		
		for(int i=0;i<noOfCustomer;i++) {
			System.out.println("Booking Id : "+b[i].getBookingId());
			System.out.println("Room Type : "+b[i].getRoomTypeSelection());
			System.out.println("price : "+b[i].getPrice());
		}	
		
	}

}
