import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded credentials (bad practice)
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "admin";
        String dbPassword = "password123";

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = conn.createStatement();

            // SQL Injection vulnerability
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            stmt.executeQuery(query);

            System.out.println("Login attempted with query: " + query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}