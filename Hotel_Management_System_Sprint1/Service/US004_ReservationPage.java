package Service;
import java.sql.*;
import java.util.*;
import exceptions.ReservationException;
import util.DbConnection;
import util.DateValidator;
import java.sql.Date;
public class US004_ReservationPage extends UserOperations {
	static int count=1;
	static Scanner scanner = new Scanner(System.in);
	int userId = US003_LoginMenu.getUserId;
	public void reservationMenu()  throws ClassNotFoundException,SQLException {
	while(true) {
		
		System.out.println("Enter Choice\n1.Add New Registration\n2.Update User Registration\n3.Delete Reservation\n4.Go to Main Menu");
		
		Class.forName("org.sqlite.JDBC");
		Connection con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				addReservation();	
				break;
			case 2:
				System.out.println("Enter Reservation Id:");
				int userId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Name:");
				String name = scanner.nextLine();
				updateReservation(userId,name);
				break;
			case 3:
				System.out.println("Enter ReservationId:");
				int deletedReservationId = scanner.nextInt();
				scanner.nextLine();
				deleteReservation(deletedReservationId);
				break;	
			case 4:
				displayUserOperations();
				break;
			default:
				System.out.println("Invalid Choice.....");
				break;
			}
		}
	}
	public void addReservation() throws ClassNotFoundException, SQLException {
	    try {
	        Connection con = DbConnection.getConnection();
	        System.out.println("Enter User Details Below:\n");
	        scanner.nextLine();
	        String checkInDate;
	        
	        while (true) {
	            System.out.println("Enter Check-in Date (yyyy-MM-dd):");
	            checkInDate = scanner.nextLine();
	            if (!DateValidator.isValidFormat(checkInDate)) {
	                System.out.println("Invalid Format! Please enter in yyyy-MM-dd format.");
	            } else if (!DateValidator.isValidDate(checkInDate)) {
	                System.out.println("Invalid Date");
	            } else {
	                break;
	            }
	        }
	        Date validcheckInDate = Date.valueOf(checkInDate);
	        String checkOutDate;
	        while (true) {
	            System.out.println("Enter Check-Out Date (yyyy-MM-dd):");
	            checkOutDate = scanner.nextLine();
	            if (!(DateValidator.isValidFormat(checkOutDate))) {
	                System.out.println("Please enter in yyyy-MM-dd format.");
	            } else if (!DateValidator.isValidDate(checkOutDate)) {
	                System.out.println("Invalid Date");
	            } else {
	                break; 
	            }
	        }
	        Date validcheckOutDate = Date.valueOf(checkOutDate);
	        int numberOfDays = (int) ((validcheckOutDate.getTime() - validcheckInDate.getTime()) / (1000 * 60 * 60 * 24));
	        String roomPreferences;
	        while (true) {
	            System.out.println("Enter Room Preferences (Single/Double):");
	            roomPreferences = scanner.nextLine();
	            if (roomPreferences.equalsIgnoreCase("single") || roomPreferences.equalsIgnoreCase("double")) {
	                break;
	            } else {
	                System.out.println("Invalid Option");
	            }
	        }
	        String name = US003_LoginMenu.currentUser.getFullName();
	        String contact = US003_LoginMenu.currentUser.getMobileNumber();
	        String insert = "INSERT INTO Reservations (UserId, CheckInDate, CheckOutDate, RoomPreference, UserName, Contact) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = con.prepareStatement(insert);
	        pstmt.setInt(1, userId);
	        pstmt.setString(2, checkInDate);
	        pstmt.setString(3, checkOutDate);
	        pstmt.setString(4, roomPreferences);
	        pstmt.setString(5, name);
	        pstmt.setString(6, contact);
	        int insertedRows = pstmt.executeUpdate();
	        if (insertedRows > 0) {
	            System.out.println("Reservation Details Added Successfully!");
	          //  con.prepareStatement("Select ReservationId,Room from Reservation where userId = ? ORDER BY ReservationID DESC LIMIT 1");
	            String selectQuery = "SELECT ReservationId, RoomPreference FROM Reservations WHERE userId = ? ORDER BY ReservationID DESC LIMIT 1";
	            PreparedStatement selectPstmt = con.prepareStatement(selectQuery);
	            selectPstmt.setInt(1, userId);
	            
	            ResultSet rs = selectPstmt.executeQuery();
	            int reservationId = 0;
	            String roomType = "";
	            if (rs.next()) { 
	                reservationId = rs.getInt("ReservationId");
	                roomType = rs.getString("RoomPreference");
	            }
	            int total_amount = 0;
	            if(roomType.equalsIgnoreCase("single"))   total_amount = (1500 * numberOfDays);
	            else total_amount = 2500 * numberOfDays;
	            String insertBill = "INSERT INTO BILL (ReservationId, UserId, TotalAmount, PaymentStatus) VALUES (?, ?, ?, ?)";
	            PreparedStatement billPstmt = con.prepareStatement(insertBill);
	            billPstmt.setInt(1, reservationId);
	            billPstmt.setInt(2, userId);
	            billPstmt.setInt(3, total_amount);
	            billPstmt.setString(4, "Pending");
	            billPstmt.executeUpdate();       
	        } else {
	            throw new ReservationException("Unable to add reservation. Please try again.");
	        }
	        pstmt.close();
	        con.close();
	        UserOperations.displayUserOperations();
	    } catch (ReservationException ex) {
	        System.out.println(ex.getMessage());
	    }
	}

	
	public void updateReservation(int reservationId, String newName) throws ClassNotFoundException, SQLException {
		
		try {
			Connection con = DbConnection.getConnection();
			String update = "UPDATE  Reservations SET Username=? WHERE ReservationId=? And userid=?;";
			PreparedStatement pstmt=con.prepareStatement(update);
			
			pstmt.setString(1, newName);
			pstmt.setInt(2,reservationId);
			pstmt.setInt(3, userId);
			
			int updatedRows = pstmt.executeUpdate();
			if(updatedRows>0) {
				System.out.println("Reservation Details Updated Successfully");
			}
			else {
				throw new ReservationException("Unable to update Reservation....Please try again");
			}
			pstmt.close();
			con.close();
		}
		catch(ReservationException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void deleteReservation( int id) throws ClassNotFoundException, SQLException {				
		try {
			Connection con = DbConnection.getConnection();
			String delete = "DELETE FROM Reservations WHERE ReservationId=? AND userId=?";
			
			PreparedStatement pstmt=con.prepareStatement(delete);
			
			pstmt.setInt(1, id);
			pstmt.setInt(2, userId);
			
			int deletedRows=pstmt.executeUpdate();
			if(deletedRows>0) {
				System.out.println("Reservation Details Deleted Successfully");
			}
			else {
				throw new ReservationException("Reservation Not Found....Please try again");
			}
			pstmt.close();
			con.close();
		}
		catch(ReservationException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

