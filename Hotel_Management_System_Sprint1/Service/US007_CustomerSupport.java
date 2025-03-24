package Service;
import java.sql.SQLException;

import Model.Support;

public class US007_CustomerSupport {
	public void displaySupport() throws ClassNotFoundException, SQLException {
		Support support = new Support();
		System.out.println("Contact Support:\n--------------------------------------\nContact No:"+ support.getContactNumber()+"\n\nE-Mail: "+support.getEmail()+"\n\nAddress: "+ support.getAddress()+"\n--------------------------------------");
		UserOperations.displayUserOperations();
	}
}
