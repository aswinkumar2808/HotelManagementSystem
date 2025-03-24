package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbConnection;

public class US012_ActiveComplaintsCount extends AdminOperations{
    public void displayActiveComplaintsCount() throws ClassNotFoundException, SQLException{
    	try {
    		Connection con = DbConnection.getConnection();
    		Statement stmt=con.createStatement();
        	String select = "select * from Complaints;";	
        	ResultSet rs = stmt.executeQuery(select);
    		ResultSetMetaData meta = rs.getMetaData();		
    		while(rs.next())
    		{
    			System.out.println("----------------------------");
    			System.out.println(meta.getColumnName(2)+" : "+rs.getInt(2));
    			System.out.println(meta.getColumnName(3)+" : "+rs.getString(3));
    			System.out.println(meta.getColumnName(4)+" : "+rs.getString(4));
    			System.out.println(meta.getColumnName(5)+" : "+rs.getInt(5));
    			System.out.println(meta.getColumnName(6)+" : "+rs.getString(6));
    			System.out.println(meta.getColumnName(7)+" : "+rs.getInt(7));
    			System.out.println("----------------------------");
    		} 				
    		rs.close();
    		stmt.close();
    		con.close();
    		displayAdminOperations();
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    }
}