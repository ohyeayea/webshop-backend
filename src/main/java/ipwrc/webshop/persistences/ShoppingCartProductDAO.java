package ipwrc.webshop.persistences;

import io.dropwizard.hibernate.AbstractDAO;
import ipwrc.webshop.models.ShoppingCartProduct;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ShoppingCartProductDAO extends AbstractDAO<ShoppingCartProduct> {

  public ShoppingCartProductDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public ShoppingCartProduct addShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
    shoppingCartProduct.setId((Integer) currentSession().save(shoppingCartProduct));
    return shoppingCartProduct;
  }

  public ShoppingCartProduct getShoppingCartProduct(int shoppingCartProductId) {
    return get(shoppingCartProductId);
  }

  public List<ShoppingCartProduct> getAllShoppingCartProducts() {
    CriteriaBuilder builder = currentSession().getCriteriaBuilder();
    CriteriaQuery<ShoppingCartProduct> criteria = builder.createQuery(ShoppingCartProduct.class);
    criteria.from(ShoppingCartProduct.class);

    return currentSession().createQuery(criteria).getResultList();
  }

  public ShoppingCartProduct updateShoppingCartProducts(ShoppingCartProduct shoppingCartProduct) {
    return persist(shoppingCartProduct);
  }

  public ShoppingCartProduct deleteShoppingCartProduct(int shoppingCartProductId) {
    ShoppingCartProduct shoppingCartProduct = get(shoppingCartProductId);

    if (shoppingCartProduct == null)
      return null;

    this.currentSession().delete(shoppingCartProduct);
    return shoppingCartProduct;
  }
}
