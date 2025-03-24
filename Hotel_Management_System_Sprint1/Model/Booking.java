package Model;

public class Booking {
	private int bookingId;
	private String roomTypeSelection;
	private double price;
	
	public Booking(int bookingId, String roomTypeSelection, double price) {
		this.bookingId = bookingId;
		this.roomTypeSelection = roomTypeSelection;
		this.price = price;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getRoomTypeSelection() {
		return roomTypeSelection;
	}

	public void setRoomTypeSelection(String roomTypeSelection) {
		this.roomTypeSelection = roomTypeSelection;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
