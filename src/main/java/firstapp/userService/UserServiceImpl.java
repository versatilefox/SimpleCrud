package firstapp.userService;

import firstapp.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import firstapp.user.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    @Override
    public User getUserByLogin(String login) {
        User user = userDAO.getUserByLogin(login);
        return user;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public User getUserById(Long id) {
        return userDAO.find(id);
    }

    @Transactional( rollbackFor = Exception.class, readOnly = false)
    @Override
    public void addUser(User user) {
        userDAO.create(user);
    }

    @Transactional( rollbackFor = Exception.class, readOnly = false)
    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public void deleteUserById(Long id) {
        userDAO.delete(id);
    }

    @Transactional( rollbackFor = Exception.class, readOnly = false)
    @Override
    public void editUser(User user) {
        userDAO.edit(user);
    }



}
