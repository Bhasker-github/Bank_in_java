package DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    public Connection con = null;

    public Connection connection() {
        try {
            String un = "root";
            String pss = "mysql";
            String url = "jdbc:mysql://localhost:3306/banking_system"; // Corrected URL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, un, pss);
        } catch (Exception ms) {
            System.out.println("Error Connection Establishment");
            ms.printStackTrace(); 
        }
		return con;
    }
}
