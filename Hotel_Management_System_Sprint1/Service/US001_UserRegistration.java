package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Model.User;
import util.DbConnection;
public class US001_UserRegistration {
	public void userRegistrationMenu() throws ClassNotFoundException, SQLException {
		while(true) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Choice\n1.Create New User\n2.Update User\n3.Display user\n4.Delete User\n5.Go to Main Menu");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			createUserDetails();	
			break;
		case 2:
			System.out.println("Enter UserId");
			int userId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new EmailId:");
			String emailId = scanner.next();
			updateUserDetails(userId,emailId);
			break;
		case 3:
			fetchUserDetails();
			break;
		case 4:
			System.out.println("Enter UserId:");
			int deletedUserId = scanner.nextInt();
			deleteUserDetails(deletedUserId);
			break;	
		case 5:
			US002_LoginMenuDisplay.displayMenu();
		default:
			System.out.println("Invalid Choice.....");
			break;
		}
		}		
	}
	public void createUserDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User Details Below:\nUserID:");
		int userId = scanner.nextInt();
		String userName;
		while(true) {
			System.out.println("UserName");
			userName = scanner.next();
			if(userName.length()<50)   break;
			System.out.println("Name is too long....");
		}
		String emailId;
		while(true) {
			System.out.println("Email-Id:");
			emailId = scanner.next();
			if(emailId.length()<100)   break;
			System.out.println("Emaid id  is too long....");
		}
		String mobileNumber;
		while(true) {
			System.out.println("Mobile Number:");
			mobileNumber = scanner.next();
			if(mobileNumber.length()==10)   break;
			System.out.println("Please enter a valid mobile number....");
		}
		String password;
		while(true) {
			System.out.println("Password:");
			password = scanner.next();
			if(password.length()<30)   break;
			System.out.println("Password  is too long....");
		}
		try {
			Connection connection = DbConnection.getConnection();
		    String insertUser = "INSERT INTO USER(Userid,FullName,Email,MobileNumber,Password) VALUES(?,?,?,?,?)";
		    PreparedStatement ps = connection.prepareStatement(insertUser);
		    ps.setInt(1,userId);
		    ps.setString(2, userName);
		    ps.setString(3, emailId);
		    ps.setString(4, mobileNumber);
		    ps.setString(5, password);
		    int rows = ps.executeUpdate();
		    if(rows>0)   System.out.println("Users Details Added Successfully");
		    else System.out.println("Unable to insert Details");
		    ps.close();
		    connection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	public void updateUserDetails(int userId, String emailId) {	
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DbConnection.getConnection();
		    String validateUser = "SELECT * FROM USER WHERE UserId = ?;";
		    PreparedStatement ps = connection.prepareStatement(validateUser);
		    ps.setInt(1,userId);
		    ResultSet resultUsers = ps.executeQuery();
		    if(resultUsers.next()) {
		    	String updateEmail = "UPDATE USER SET Email = ? WHERE USERID = ?";
		    	PreparedStatement psmt = connection.prepareStatement(updateEmail);
		    	psmt.setString(1, emailId);
		    	psmt.setInt(2, userId);
		    	psmt.executeUpdate();
		    	System.out.println("User Details Updated Successfully");
		    	psmt.close();
		    }
		    else {
		    	System.out.println("User Id not found");
		    }
	    	connection.close();
	    	UserOperations.displayUserOperations();
		    
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void fetchUserDetails() {
		  List<User> userList = new ArrayList<>();
		  try {
			    Connection conn = DbConnection.getConnection();
		    	String fetchUsers = "SELECT * FROM USER;";
		    	PreparedStatement ps = conn.prepareStatement(fetchUsers);
		    	ResultSet rs = ps.executeQuery();
		    	while(rs.next()) {
		    		System.out.println("User Id:"+rs.getInt("userID"));
		    		System.out.println("User Name:"+rs.getString("fullname"));
		    		System.out.println("E-Mail:"+rs.getString("email"));
		    		System.out.println("Mobile Number"+rs.getString("mobileNumber"));
		    		System.out.println("Password:"+rs.getString("password"));	
		    		System.out.println("=================================");
		    	}
		    	rs.close();
		    	ps.close();
		    	conn.close();
		  }
		  catch(Exception ex) {
			 ex.getMessage();
		  }	
	}
	public void deleteUserDetails(int userId) {
		    try {
		    	Connection conn = DbConnection.getConnection();
		    	String deleteUser = "DELETE FROM USER WHERE UserID = ?;";
		    	PreparedStatement ps = conn.prepareStatement(deleteUser);
		    	ps.setInt(1, userId);
		    	int rowsAffected = ps.executeUpdate();
		    	if(rowsAffected==1)   System.out.println("User details deleted Successfully");
		    	else    System.out.println("Invalid User ID");
		    	ps.close();
		    	conn.close();
		    }
		    catch(Exception ex) {
		    	System.out.print(ex);
		    }		
	}

}
