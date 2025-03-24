package Service;
import java.sql.SQLException;
import java.util.Scanner;
public class US002_LoginMenuDisplay {
	public static void displayMenu() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("............Welcome to Hotel Hope............\n----------------Main Menu---------------\nPlease Select An Option Below:\n1.User Management(Admin only) 2.Login 3.Exit");
		int selectChoice = scanner.nextInt();
		switch(selectChoice) {
		case 1:
			US001_UserRegistration user = new US001_UserRegistration();
			user.userRegistrationMenu();
			break;
		case 2:
			US003_LoginMenu login = new US003_LoginMenu();
			login.displayLoginMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		}
	}
}
