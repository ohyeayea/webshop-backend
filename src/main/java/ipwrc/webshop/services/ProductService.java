package ipwrc.webshop.services;

import ipwrc.webshop.models.Product;
import ipwrc.webshop.persistences.ProductDAO;

import javax.inject.Inject;
import java.util.List;

public class ProductService {

  private ProductDAO productDAO;

  @Inject
  public ProductService(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  public List<Product> getAllProducts() {
    return this.productDAO.getAllProducts();
  }

  public Product getProduct(int productId) {
    return this.productDAO.getProduct(productId);
  }

  public Product addProduct(Product product) {
    return this.productDAO.addProduct(product);
  }

  public Product updateProduct(Product product) {
    return this.productDAO.updateProduct(product);
  }

  public Product deleteProduct(int productId) {
    return this.productDAO.deleteProduct(productId);
  }
}
