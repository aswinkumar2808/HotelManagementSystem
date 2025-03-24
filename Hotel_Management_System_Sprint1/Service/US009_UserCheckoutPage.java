package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import Model.Reservation;
import util.DbConnection;

class US009_UserCheckoutPage {
	    static int totalAmount= 0;
	    public void checkoutDetails() {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\n--- Checkout & Billing Page ---");
	            System.out.println("1. View Bill");
	            System.out.println("2. Pay Bill");
	            System.out.println("3. Cancel Checkout");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            int userId = US003_LoginMenu.getUserId;
	            try {
	            	Connection connection = DbConnection.getConnection();
	            	switch(choice) {
	            	case 1:
	            		String selectQuery = "SELECT * FROM Bill WHERE UserId = ?";
	            		PreparedStatement pstmt = connection.prepareStatement(selectQuery);
	            		pstmt.setInt(1, userId);
	            		ResultSet rs = pstmt.executeQuery();
	            		while(rs.next()) {
	            			System.out.println("===============================================");
	            			System.out.println("Bill ID: "+rs.getInt(1));
	            			System.out.println("Reservation ID: " +rs.getInt(2));
	            			totalAmount+=rs.getInt(4);
	            			System.out.println("Amount:"+rs.getInt(4));
	            		}
	            		System.out.println("Total Amount = "+totalAmount);
	            		break;
	            	case 2:
	            		US010_UserBillingPage.processPayment();
	            		break;
	            	
	            	default:
	            		System.out.println("Invalid Choice");
	            		break;
	            	}
	            		
	            }
	            catch(Exception ex) {
	            	
	            }
	           
	        }
	    }

	 

	    
	}


