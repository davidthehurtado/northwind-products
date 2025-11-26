import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "yearup";

        try {
            // 1. Create Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Create Statement
            Statement stmt = conn.createStatement();

            // 3. Execute Query
            ResultSet rs = stmt.executeQuery("SELECT CompanyName FROM Customers");

            // 4. Process Results
            while (rs.next()) {
                System.out.println(rs.getString("CompanyName"));
            }

            // 5. Close Resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}