package Service;
import java.sql.*;
import java.util.*;

import Model.Reservation;
import util.DbConnection;
public class US014_BookingHistoryById extends AdminOperations{
	//static List<Reservations> reservations=new ArrayList<>();
	public  void showBookingHistory() throws ClassNotFoundException, SQLException
	{
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter UserId");
			int userId=sc.nextInt();		 
			Connection con = DbConnection.getConnection();
			String selectQuery = "SELECT * FROM Reservations WHERE UserId = ?";
			PreparedStatement pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, userId);	
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			boolean isRecordsFound = false;	
			while(rs.next()) {			
				isRecordsFound = true;
				System.out.println("----------------------------");
				System.out.println("RESERVATION ID: "+rs.getInt(1));
				System.out.println("USERID: "+rs.getInt(2));
				System.out.println("CHECK IN DATE: "+rs.getString(3));
				System.out.println("CHECK OUT DATE: "+rs.getString(4));
				System.out.println("ROOM: "+rs.getString(5));
				System.out.println("NAME: "+rs.getString(6));
				System.out.println("CONTACT: "+rs.getString(7));
				System.out.println("----------------------------");
			}	
			if(!isRecordsFound) System.out.println("No bookings found for the given User Id...");
			displayAdminOperations();
			rs.close();
			pstmt.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
