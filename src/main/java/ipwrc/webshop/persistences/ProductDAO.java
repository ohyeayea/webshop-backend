package ipwrc.webshop.persistences;

import io.dropwizard.hibernate.AbstractDAO;
import ipwrc.webshop.models.Product;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {

  public ProductDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Product addProduct(Product product) {
    product.setId((Integer) currentSession().save(product));
    return product;
  }

  public Product getProduct(int productId) {
    return get(productId);
  }

  public List<Product> getAllProducts() {
    CriteriaBuilder builder = currentSession().getCriteriaBuilder();
    CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
    criteria.from(Product.class);

    return currentSession().createQuery(criteria).getResultList();
  }

  public Product updateProduct(Product product) {
    return persist(product);
  }

  public Product deleteProduct(int productId) {
    Product product = get(productId);

    if (product == null)
      return null;

    this.currentSession().delete(product);
    return product;
  }
}
