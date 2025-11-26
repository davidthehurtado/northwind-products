import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "yearup";

        try {
            // Load driver (older style, but matches workbook)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. Open connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Create PreparedStatement with our query
            String sql = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // 3. Execute query
            ResultSet rs = stmt.executeQuery();

            // 4. Print header
            System.out.printf("%-5s %-35s %-10s %-10s%n", "Id", "Name", "Price", "Stock");
            System.out.println("--------------------------------------------------------------");

            // 5. Process each row
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                double price = rs.getDouble("UnitPrice");
                int stock = rs.getInt("UnitsInStock");

                System.out.printf("%-5d %-35s %-10.2f %-10d%n", id, name, price, stock);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}