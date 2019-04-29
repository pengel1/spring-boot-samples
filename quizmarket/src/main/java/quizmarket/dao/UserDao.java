package quizmarket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quizmarket.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(User user) {
    getSession().save(user);
    return;
  }
  
  public void delete(User user) {
    getSession().delete(user);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<User> getAll() {
    return getSession().createQuery("from User").list();
  }

  public User getByEmailAndToken(String email, String token) {
    return (User) getSession().createQuery("from User where email = :email and token = :token")
            .setParameter("email", email)
            .setParameter("token", token).list().get(0);
  }

  public void update(User user) {
    getSession().update(user);
    return;
  }

} // class UserDao
