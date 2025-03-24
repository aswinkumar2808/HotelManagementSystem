package database;
import java.sql.*;
public class TableCreation {
	public static void main(String args[]) {
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\aswin\\MySQLiteDB");
//			String userTable = "CREATE TABLE USER (UserID INT PRIMARY KEY, FullName VARCHAR2 (30), Email VARCHAR2 (50),MobileNumber VARCHAR2 (10), Password VARCHAR2 (30) );";
//			String reservationTable = "CREATE TABLE Reservation(Reservation_ID INTEGER PRIMARY KEY AUTOINCREMENT,USer_Id INTEGER NOT NULL,Check_in_date DATE, Check_out_date DATE,Room_no Integer, Status Text Check (Status in ('Approved','Canceled')),FOREIGN KEY(USer_id) REFERENCES users(user_id));";
//			Statement statement = connection.createStatement();
//			String create="create table Reservations(ReservationId Integer Primary Key AutoIncrement,Userid Integer,CheckinDate varchar(30),CheckoutDate varchar(30),RoomPreference varchar(30),UserName varchar(30),Contact varchar(30));";
//    	   String complaintTable="create table Complaints(ComplaintId INTEGER PRIMARY KEY AUTOINCREMENT,UserId INTEGER, Username varchar(30),Contact varchar(10), Room Number int,Complaint Type varchar(40),Rating int);";
//    	   String roomTable = "CREATE TABLE Room (RoomNumber INTEGER PRIMARY KEY, RoomType Varchar NOT NULL CHECK (RoomType IN ('Single', 'Double')), Status TEXT NOT NULL DEFAULT 'Vacant' CHECK (Status IN ('Vacant', 'Occupied')), DateAvailable Varchar NOT NULL, Price REAL NOT NULL, Location varchar NOT NULL);";
//			String createBillTable = "CREATE TABLE Bill (BillId INTEGER PRIMARY KEY AUTOINCREMENT, ReservationId INTEGER NOT NULL, UserId INTEGER NOT NULL, TotalAmount INTEGER NOT NULL, PaymentStatus VARCHAR(10) NOT NULL);";
 //   	    Statement statement = connection.createStatement();
//			statement.execute(createBillTable);
//			statement.close();
//			connection.close();
			
//		}
//		catch(Exception ex) {
//		ex.printStackTrace();
//		}
	}
}
