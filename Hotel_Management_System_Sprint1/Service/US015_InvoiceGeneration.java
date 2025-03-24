package Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import util.DbConnection;

public class US015_InvoiceGeneration {
    static int bill_amount = 0;

    public void generateInvoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User Id:");
        int userId = scanner.nextInt();
        int total = 0;
        String userName = "";

        try {
            Connection connection = DbConnection.getConnection();

            String selectQuery = "SELECT SUM(b.TotalAmount) AS TotalBill, u.FullName AS UserName FROM Bill b JOIN User u ON b.UserId = u.UserId WHERE b.UserId = ?";


            PreparedStatement psmt = connection.prepareStatement(selectQuery);
            psmt.setInt(1, userId);

            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("TotalBill");
                userName = rs.getString("UserName");
                if (userName == null) {
                    System.out.println("No records found or invalid UserId.");
                    return;
                }

                System.out.println("\n--- Invoice Generated ---");
                System.out.println("UserName: " + userName);
                System.out.println("Amount Paid: ₹" + total);
                System.out.println("Payment Status: Successful");
                System.out.println("----------------------------");

            } else {
                System.out.println("No records found.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
