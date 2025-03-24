package Model;


public class User {
	                                                                                              
	private int userId;
	
	private String fullName;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String password; 

	public User(int userId, String fullName, String emailId, String mobileNumber, String password) {
		this.userId = userId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserId:" + userId +"\n"+ "FullName:" + fullName + "\n"+"EmailId: " + emailId + "\n"+ "Mobile Number: "
				+ mobileNumber +"\n"+ "Password: " + password + "\n";
	}
	
	
	
	
	
	

}
