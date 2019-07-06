package firstapp.dao;

import firstapp.user.User;

public interface UserDAO extends GenericDAO<Long, User>{
    User getUserByLogin(String login);
}
