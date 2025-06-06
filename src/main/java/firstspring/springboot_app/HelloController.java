package firstspring.springboot_app;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class HelloController {
    @Autowired
    private userService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @GetMapping("/greet")
    public String sayGoodbye() {
        return "Goodbye, World!";
    }
    @GetMapping("/welcome")
    public String sayWelcome() {
        return "Welcome to Spring Boot!"; }

    @GetMapping("/user/{name}")
    public String handleSubmit(@PathVariable String name) {
        if (name == null || name.isEmpty()) {
            return "Name cannot be empty!";
        } else return "Form submitted successfully!"+name;
        
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return "Name cannot be empty!";
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return "Email cannot be empty!";
        }
        userService.addUser(user);
        userRepository.insertUser(user.getName(), user.getEmail());
        return "User added successfully!";
    }
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        if (updatedUser.getName() == null || updatedUser.getName().isEmpty()) {
            return "Name cannot be empty!";
        }
        if (updatedUser.getEmail() == null || updatedUser.getEmail().isEmpty()) {
            return "Email cannot be empty!";
        }
        boolean isUpdatedService = userService.updateUser(id, updatedUser);
        boolean isUpdatedDb = userRepository.updateUser(id, updatedUser.getName(), updatedUser.getEmail());
        if (isUpdatedService && isUpdatedDb) {
            return "User updated successfully!";
        } else {
            return "User not found!";
        }
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null; // or throw an exception if preferred
    }
    @GetMapping("/db/users")
    public List<User> getAllUsersFromDb() {
        userRepository.selectUsers();
        List<User> users = new ArrayList<>();
        try (Connection connection = UserRepository.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                users.add(new User(name, email, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
       
    }
    
}
