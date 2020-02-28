package ipwrc.webshop.persistences;

import io.dropwizard.hibernate.AbstractDAO;
import ipwrc.webshop.models.ShoppingCart;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ShoppingCartDAO extends AbstractDAO<ShoppingCart> {

  public ShoppingCartDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
    shoppingCart.setId((Integer) currentSession().save(shoppingCart));
    return shoppingCart;
  }

  public ShoppingCart getShoppingCart(int shoppingCartId) {
    return get(shoppingCartId);
  }

  public List<ShoppingCart> getAllShoppingCarts() {
    CriteriaBuilder builder = currentSession().getCriteriaBuilder();
    CriteriaQuery<ShoppingCart> criteria = builder.createQuery(ShoppingCart.class);
    criteria.from(ShoppingCart.class);

    return currentSession().createQuery(criteria).getResultList();
  }

  public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
    return persist(shoppingCart);
  }

  public ShoppingCart deleteShoppingCart(int shoppingCartId) {
    ShoppingCart shoppingCart = get(shoppingCartId);

    if (shoppingCart == null)
      return null;

    this.currentSession().delete(shoppingCart);
    return shoppingCart;
  }
}
