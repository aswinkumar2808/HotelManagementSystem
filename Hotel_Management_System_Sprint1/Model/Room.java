package Model;
//package Hotel_roomStatus;

import java.util.ArrayList;

public class Room {
	
	    public int roomNumber;
	    public String type;
	    public String status;
	    public String dateAvailable;
	    public double price;
	    public String location;
	    public Room(int roomNumber, String type, double price, String location, String dateAvailable) {
	        this.roomNumber = roomNumber;
	        this.type = type;
	        this.status = "Vacant";
	        this.price = price;
	        this.location = location;
	        this.dateAvailable = dateAvailable;
	    }
	    
	    public void updateStatus(String newStatus) {
	        this.status = newStatus;
	    }

	    public void updateAvailability(String newDate) {
	        this.dateAvailable = newDate;
	    }
	    
	    @Override
	    public String toString() {
	    	return roomNumber + "\t" + type + "\t" + status + "\t" + dateAvailable + "\t"+ price + "\t" + location;
	    }
	}
	
