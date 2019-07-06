package firstapp.security;

import firstapp.user.User;
import firstapp.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String login) {
        System.out.println("detail service");
        User user = userService.getUserByLogin(login);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(
                    "Cannot find user " + login);
        }
    }
}
