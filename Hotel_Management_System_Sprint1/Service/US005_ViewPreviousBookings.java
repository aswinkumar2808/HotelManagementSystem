package Service;
import java.sql.*;
import java.util.*;

import Model.Reservation;
import util.DbConnection;
public class US005_ViewPreviousBookings {
	int userId = US003_LoginMenu.getUserId;
	public  void userBookingHistory() {
		try {
			Connection connection = DbConnection.getConnection();
			String fetchBookings = "Select * FROM Reservations WHERE UserId = ?";
			PreparedStatement pstmt = connection.prepareStatement(fetchBookings);
			pstmt.setInt(1, userId);
			ResultSet resultBookings = pstmt.executeQuery();
			boolean recordsFound = false;
			int num =0;
			while(resultBookings.next()) {
				recordsFound = true;
				System.out.println("==============================================================================================================================");
				System.out.print(resultBookings.getMetaData().getColumnName(1) +  " : " + resultBookings.getString("ReservationId")+" || ");
				System.out.print(resultBookings.getMetaData().getColumnName(3) + " : " +   resultBookings.getString("CheckInDate")+" || ");
				System.out.print(resultBookings.getMetaData().getColumnName(4) + " : " + resultBookings.getString("CheckOutDate")+" || ");
				System.out.println(resultBookings.getMetaData().getColumnName(5) + " : " +resultBookings.getString("RoomPreference"));
			}
			 if (!recordsFound) {
		            System.out.println("No Previous Bookings Found");
		        }
		}
		catch(Exception ex) {
			System.out.print("An Error Occured...Please try again"+ex.getMessage());
		}
	}
}