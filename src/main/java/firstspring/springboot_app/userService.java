package firstspring.springboot_app;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class userService {

    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(int id, User updatedUser) {
        Optional<User> userOpt = users.stream().filter(u -> u.getId() == id).findFirst();
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return users.removeIf(u -> u.getId() == id);
    }
}