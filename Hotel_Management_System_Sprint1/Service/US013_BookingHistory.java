package Service;
import java.sql.*;
import java.util.*;

import Model.Reservation;
import util.DbConnection;


public class US013_BookingHistory extends AdminOperations{
	
    public void displayPreviousBookings() throws ClassNotFoundException, SQLException{  	
    	try {
    		Connection connection = DbConnection.getConnection();
    		Statement statement = connection.createStatement();
    		String select = "SELECT * FROM Reservation";
    		ResultSet rs = statement.executeQuery(select);
    		ResultSetMetaData meta = rs.getMetaData();
			
    		while(rs.next())
    		{
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
    		rs.close();
    		statement.close();
    		connection.close();
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    }
}