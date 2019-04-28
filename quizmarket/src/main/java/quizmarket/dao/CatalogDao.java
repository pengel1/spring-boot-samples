package quizmarket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quizmarket.models.Catalog;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CatalogDao {

  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Catalog catalog) {
    getSession().save(catalog);
    return;
  }
  
  public void delete(Catalog catalog) {
    getSession().delete(catalog);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Catalog> getAll() {
    return getSession().createQuery("from Catalog").list();
  }

  public Catalog getById(long id) {
    return (Catalog) getSession().load(Catalog.class, id);
  }

  public void update(Catalog catalog) {
    getSession().update(catalog);
    return;
  }

} // class CatalogDao
