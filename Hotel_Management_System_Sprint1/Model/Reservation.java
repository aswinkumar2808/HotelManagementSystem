package Model;
//package model;

public class Reservation  {

//	private static int count = 1;
	private int userId;
//	private int reservationId;
	private String checkInDate;
	private String checkOutDate;
	private String roomPreferences;
	private String name;
	private String contact;
	public Reservation(String checkInDate,int userId ,String checkOutDate, String roomPreferences, String name,
			String contact) {
		this.userId=userId;
		//this.reservationId = count++;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomPreferences = roomPreferences;
		this.name = name;
		this.contact = contact;
	}
//	public int getReservationId() {
//		return reservationId;
//	}
//	public void setReservationId(int reservationId) {
//		this.reservationId = reservationId;
//	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoomPreferences() {
		return roomPreferences;
	}
	public void setRoomPreferences(String roomPreferences) {
		this.roomPreferences = roomPreferences;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "\n"+"\nReservationId: "  + "\t" + "CheckInDate :" + checkInDate + "\t" +"CheckOutDate : "
				+ checkOutDate + "\t" + "Room Preferences: " + roomPreferences + "\t" + "Name:" + name + "\t" + "Contact:" + contact + "\n" ;
	}
	
	
	
	
	
	
	
	
	
	
}
