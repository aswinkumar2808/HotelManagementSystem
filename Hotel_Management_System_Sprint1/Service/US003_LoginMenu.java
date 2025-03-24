package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Model.User;
import util.DbConnection;
public class US003_LoginMenu {
	public static int getUserId = 0;
	public static User currentUser = null;
	public void displayLoginMenu() throws ClassNotFoundException, SQLException {
		Scanner sc1=new Scanner(System.in);
		Map<String,String> admin=new HashMap<String, String>();
		Map<String,String> feedback=new HashMap<String, String>();	
		admin.put("admin1", "pwd@000");
		admin.put("admin2", "pwd@111");		
		feedback.put("user1","Good");
		feedback.put("user2","Bad");		
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("3.Exit");
		System.out.println("Enter choice: ");
		int choice=sc1.nextInt();
		sc1.nextLine();		
		while(true) {
			switch(choice) {
			case 1:
				System.out.println("Enter Username: ");
				String username1=sc1.nextLine();
				System.out.println("Enter Password: ");
				String password1=sc1.nextLine();
				AdminOperations.displayAdminOperations();
				break;
			case 2:
				System.out.println("Enter Username: ");
				String username=sc1.nextLine();
				System.out.println("Enter Password: ");
				String userPassword=sc1.nextLine();
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DbConnection.getConnection();
				    String validateUser = "SELECT * FROM USER WHERE FullName = ? AND Password = ?;";
				    PreparedStatement ps = connection.prepareStatement(validateUser);
		
				    ps.setString(1,username);
				    ps.setString(2, userPassword);
				    ResultSet resultUsers = ps.executeQuery();
				    if(resultUsers.next()) {
				    	getUserId=resultUsers.getInt(1);
				    	currentUser=new User(resultUsers.getInt(1),resultUsers.getString(2),resultUsers.getString(3),resultUsers.getString(4),resultUsers.getString(5));
//				    	currentUser.setUserId(resultUsers.getInt(1));
//				    	currentUser.setFullName(resultUsers.getString(2));
//				    	currentUser.setEmailId(resultUsers.getString(3));
//				    	currentUser.setMobileNumber(resultUsers.getString(4));
//				    	currentUser.setPassword(resultUsers.getString(5));
				    	
				    	
				    	System.out.println(".....Login Successful....");
				    	UserOperations.displayUserOperations();
				    }
				    else {
				    	System.out.println("Invalid username or password...Please Try Again");
				    }
				    ps.close();
				    connection.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				break;
			case 3:
				System.exit(0);
			}			
		}
		
	}
}
