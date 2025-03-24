package Service;
import Model.Room;
//package Hotel_roomStatus;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Room;

public class US008_CheckRoomStatus {
	    public static void showRoomStatusForAdmin() throws ClassNotFoundException, SQLException {
	        while (true) {
	        	Scanner scanner  = new Scanner(System.in);
	        	System.out.print("\nEnter Room Number to Update: ");
	            int roomNo = scanner.nextInt();
	            scanner.nextLine();
	            System.out.print("Update Status (Vacant/Occupied): ");
                String status = scanner.nextLine();
                String date = scanner.nextLine();
                try {
                	Connection connection = DbConnection.getConnection();
                	String updateRoomQuery = "UPDATE Room SET STATUS=?, DateAvailable=? WHERE RoomNumber=?";
                	PreparedStatement pstmt = connection.prepareStatement(updateRoomQuery);
                	pstmt.setString(1, status);
                	pstmt.setString(2,date);
                	pstmt.setInt(3, roomNo);
                	int updatedRooms = pstmt.executeUpdate();
                	if(updatedRooms==1)  System.out.println("Room Details Updated Successfully");
                	else System.out.println("Unable to update please try again");
                	AdminOperations.displayAdminOperations();
                }
                catch(Exception ex) {
                	
                }
	        }
	    }
	    public static void showRoomStatusForCustomer() throws ClassNotFoundException, SQLException {
	    	try {
	    		Connection connection = DbConnection.getConnection();
	    		Statement statement = connection.createStatement();
	    		String fetchRooms = "SELECT * FROM Room";
	    		ResultSet rs = statement.executeQuery(fetchRooms);
	    		boolean isRoomAvailable = false;
	    		while(rs.next()) {
	    			isRoomAvailable = true;
	    			System.out.println("==============================================================================================================================");
					System.out.print(rs.getMetaData().getColumnName(1) +  " : " + rs.getString("RoomNumber")+" || ");
					System.out.print(rs.getMetaData().getColumnName(2)+ " : " +   rs.getString("RoomType")+" || ");
					System.out.print(rs.getMetaData().getColumnName(3) + " : " + rs.getString("Status")+" || ");
					System.out.println(rs.getMetaData().getColumnName(4) + " : " +rs.getString("DateAvailable")+" || ");
					System.out.print(rs.getMetaData().getColumnName(5) + " : " + rs.getDouble("Price")+" || ");
					System.out.println(rs.getMetaData().getColumnName(6) + " : " +rs.getString("Location"));
	    		}
	    	   if(!isRoomAvailable)  System.out.println("No rooms available...Try later");
	    	   UserOperations.displayUserOperations();
	    	}
	    	catch(Exception ex) {
	    		System.out.println(ex.getMessage());
	    	}
	    }
	}

