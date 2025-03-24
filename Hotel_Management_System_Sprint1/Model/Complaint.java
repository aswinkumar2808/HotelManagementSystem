package Model;

public class Complaint
{
	int userId;
	String username;
	String contactnumber;
	int roomnumber;
	String complainttype;
	int feedback;

public Complaint(int userId,String username,String contactnumber,int roomNumber2,String complainttype,int feedback)
{
	this.userId = userId;
	this.username=username;
	this.contactnumber=contactnumber;
	this.roomnumber=roomNumber2;
	this.complainttype=complainttype;
	this.feedback=feedback;
}
@Override
public String toString() {
	return "Username:"+username+"\nContact:"+contactnumber+"\nRoom Number:"+roomnumber+"\ncomplaint :"+complainttype+"\nRating:"+feedback;  
}
}







