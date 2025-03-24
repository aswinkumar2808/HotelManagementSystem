package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (con == null || con.isClosed()) {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\aswin\\MySQLiteDB");
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.commit(); 
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
