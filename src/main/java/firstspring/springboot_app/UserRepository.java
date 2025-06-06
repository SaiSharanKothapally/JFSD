package firstspring.springboot_app;
import java.sql.Connection;
import java .util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Repository
public class UserRepository { 
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String User = "postgres";
    private static final String Password = "1212";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, User, Password);
    }

    public void insertUser(String name, String email) {
        String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    public boolean updateUser(int id, String name, String email) {
        String updateQuery = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void deleteUser(int id) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectUsers() {
        String selectQuery = "SELECT * FROM users";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
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
        UserRepository db = new UserRepository();
        db.insertUser("Likith", "likith@gmail.com");
        db.insertUser("kousthubh", "kousthubh@gmail.com");

        db.updateUser(1, "Likith Updated", "likith@gmail.com");
        db.deleteUser(1);
        db.selectUsers();
    }

}

