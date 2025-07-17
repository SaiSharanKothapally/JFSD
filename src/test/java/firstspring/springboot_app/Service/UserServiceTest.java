package firstspring.springboot_app.Service;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import firstspring.springboot_app.User;
import firstspring.springboot_app.userService;
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class UserServiceTest {
   
    userService userService = new userService();
    @Test
    void TestingAddUser() {
        // Implement test logic for getAllUsers
        User user = new User();
        user.setId(1);
        user.setName("John Doe");
        user.setEmail("john@gmail.com");
        userService.addUser(user);
        List<User> users = userService.getAllUsers();
        // Verify that the user was added correctly
        org.junit.jupiter.api.Assertions.assertEquals(1, users.size());
        org.junit.jupiter.api.Assertions.assertEquals(user.getName(), users.get(0).getName());
    }
}
