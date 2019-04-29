package quizmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import quizmarket.dao.UserDao;
import quizmarket.models.User;

public class LoginService {

    @Autowired
    private UserDao _userDao;

    public User createUser(String firstName, String lastName, String token, String email, String image) {
        User user = new User(firstName, lastName, token, email, image);
        _userDao.save(user);
        return user;
    }

    public User login(String email, String token) {
        return _userDao.getByEmailAndToken(email, token);
    }

}
