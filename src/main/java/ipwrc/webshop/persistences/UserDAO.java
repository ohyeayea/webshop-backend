package ipwrc.webshop.persistences;

import io.dropwizard.hibernate.AbstractDAO;
import ipwrc.webshop.models.User;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

  public UserDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public User addUser(User user) {
    user.setId((Integer) currentSession().save(user));
    return user;
  }

  public User getUser(int userId) {
    return get(userId);
  }

  public List<User> getAllUsers() {
    CriteriaBuilder builder = currentSession().getCriteriaBuilder();
    CriteriaQuery<User> criteria = builder.createQuery(User.class);
    criteria.from(User.class);

    return currentSession().createQuery(criteria).getResultList();
  }

  public User updateUser(User user) {
    return persist(user);
  }

  public User deleteUser(int userId) {
    User user = get(userId);

    if (user == null)
      return null;

    this.currentSession().delete(user);
    return user;
  }
}