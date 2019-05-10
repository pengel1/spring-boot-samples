package quizmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import quizmarket.dao.UserDao;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDao.getByEmail(username);
    }
}