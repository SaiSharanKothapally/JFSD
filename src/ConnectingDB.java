import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectingDB { 
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String User = "postgres";
    private static final String Password = "1212";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, User, Password);
    }

    public void insertUser(String name, String email) {
        String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = getConnection();
             var preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(int id, String name, String email) {
        String updateQuery = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = getConnection();
             var preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int id) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             var preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectUsers() {
        String selectQuery = "SELECT * FROM users";
        try (Connection connection = getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectingDB db = new ConnectingDB();
        db.insertUser("Likith", "likith@gmail.com");
        db.insertUser("kousthubh", "kousthubh@gmail.com");

        db.updateUser(1, "Likith Updated", "likith@gmail.com");
        db.deleteUser(1);
        db.selectUsers();
    }


















    // public static void main(String[] args) {
    //     try {
    //          Class.forName("org.postgresql.Driver");
    //         Connection connection = DriverManager.getConnection(URL, User, Password);
    //         if (connection != null) {
    //             System.out.println("Connected to the database successfully!");
    //         } else {
    //             System.out.println("Failed to make connection!");
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("SQL Exception: " + e.getMessage());
    //     }
    //     catch (ClassNotFoundException e) {
    //         System.out.println("Class Not Found Exception: " + e.getMessage());
    //     }
    // }
    
}
 
