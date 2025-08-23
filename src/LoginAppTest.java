import java.sql.Connection;
import java.sql.SQLException;

public class LoginAppTest {
    public static void main(String[] args) {
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseConnection.getConnection();
            AuthService authService = new AuthService(dbConnection);

            LoginApp app = new LoginApp(authService);
            app.start();

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database or a SQL error occurred: " + e.getMessage());
        } finally {
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.err.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
    }
}
