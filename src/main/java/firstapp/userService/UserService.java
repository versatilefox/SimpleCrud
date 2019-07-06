package firstapp.userService;

import firstapp.user.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User getUserByLogin(String login);
    User getUserById(Long id);
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void editUser(User user);
}
