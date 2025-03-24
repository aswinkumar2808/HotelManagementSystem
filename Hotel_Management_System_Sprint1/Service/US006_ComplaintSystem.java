package Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import util.DbConnection;
public class US006_ComplaintSystem extends UserOperations {
	public static void customerComplaint() throws ClassNotFoundException,SQLException
	{
		try {
			Scanner sc=new Scanner(System.in);
			int userId = US003_LoginMenu.getUserId;
			String username= US003_LoginMenu.currentUser.getFullName();
			String contactNumber=US003_LoginMenu.currentUser.getMobileNumber();
			System.out.println("Enter Room Number");
			int roomNumber=sc.nextInt();
			System.out.println("Select Complaint Type");
			System.out.println(" 1. Poor Housekeeping\n 2. Noisy Guests\n 3. Uncomfortable Beds\n 4. Slow services\n 5. Lack of Amenities\n 6. Unfriendly Staff ");
			int complaintChoice=sc.nextInt();
			sc.nextLine();	
			String[] complaints= {" Poor Housekeeping","Noisy Guests","Uncomfortable Beds","Slow services","Lack of Amenities","Unfriendly Staff"};
			String complaintType=(complaintChoice>=1 && complaintChoice<=6)? complaints[complaintChoice-1]:"other";
			System.out.println("Enter Feedback (Rating out of 5)");
			int rating;
			while(true) {
				rating = sc.nextInt();
				if(rating>=1&&rating<=5)  break;
				else System.out.println("Enter a valid rating");
			}
			Connection con = DbConnection.getConnection();
			String insert="Insert into Complaints (UserId,Username,Contact,RoomNumber,ComplaintType,Rating) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, userId);
			pstmt.setString(2, username);
			pstmt.setString(3,contactNumber);
			pstmt.setInt(4, roomNumber);
			pstmt.setString(5, complaintType);
			pstmt.setInt(6,rating);
			int insertedComplaint = pstmt.executeUpdate();
			if(insertedComplaint>0)   {
				System.out.println("Complaint registered successfully");
				UserOperations.displayUserOperations();
			}
			else {
				System.out.println("Unable to send complaint....Try Again Later");
				UserOperations.displayUserOperations();
			}
			pstmt.close();
			con.close();

		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	
	}
}