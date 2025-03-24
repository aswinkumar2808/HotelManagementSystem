package Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.*;
import util.DbConnection;

public class US010_UserBillingPage {
	 static US009_UserCheckoutPage bill;
	 static void processPayment() {
		 Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Payment Page ---");
        System.out.println("Select Payment Method:");
        System.out.println("1. Debit Card");
        System.out.println("2. Credit Card");
        System.out.print("Enter your choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();
        if (paymentChoice == 1 || paymentChoice == 2) {
            collectCardDetails();
        } else {
            System.out.println("Invalid option. Returning to billing page...");
        }
    }

    private static void collectCardDetails() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Card Details:");
        System.out.print("Card Holder Name: ");
        String cardHolder = sc.nextLine();
        System.out.print("Card Number: ");
        String cardNumber = sc.nextLine();
        System.out.print("CVV: ");
        String cvv = sc.nextLine();
        System.out.print("Expiry Date (MM/YY): ");
        String expiryDate = sc.nextLine();
        System.out.println("\nProcessing payment...");
        System.out.println("\nPayment Successful!");
        generateInvoice(cardHolder);
    }

    private static void generateInvoice(String cardHolder) {
        int total = 0;
        try {
            Connection connection = DbConnection.getConnection();
            String selectQuery = "SELECT SUM(TotalAmount) AS TotalBill FROM Bill WHERE UserId = ?";
            PreparedStatement psmt = connection.prepareStatement(selectQuery);
            psmt.setInt(1, US003_LoginMenu.getUserId);

            ResultSet rs = psmt.executeQuery();
            
            if (rs.next()) {
                total = rs.getInt("TotalBill"); 
            } else {
                System.out.println("No records found.");
                UserOperations.displayUserOperations();
            }
            System.out.println("\n--- Invoice Generated ---");
            System.out.println("Card Holder: " + cardHolder);
            System.out.println("Amount Paid: ₹" + total);
            System.out.println("Payment Status: Successful");
            System.out.println("----------------------------");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }
