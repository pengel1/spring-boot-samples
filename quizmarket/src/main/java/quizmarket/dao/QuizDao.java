package quizmarket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quizmarket.models.Quiz;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuizDao {

  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Quiz quiz) {
    getSession().save(quiz);
    return;
  }
  
  public void delete(Quiz quiz) {
    getSession().delete(quiz);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Quiz> getAll(String search) {
    search = search == null ? "%" : "%" + search + "%";
    System.out.println("QUIZ IS LIKE " + search);
    return getSession().createQuery("from Quiz where title like :title_param ")
            .setParameter("title_param", search).list();
  }

  public Quiz getById(long id) {
    return (Quiz) getSession().load(Quiz.class, id);
  }

  public void update(Quiz quiz) {
    getSession().update(quiz);
    return;
  }

} // class QuizDao
