package ipwrc.webshop.core;

import io.dropwizard.db.PooledDataSourceFactory;
import ipwrc.webshop.WebShopConfiguration;
import ipwrc.webshop.models.Product;
import ipwrc.webshop.models.ShoppingCart;
import ipwrc.webshop.models.ShoppingCartProduct;
import ipwrc.webshop.models.User;

public class HibernateBundle extends io.dropwizard.hibernate.HibernateBundle<WebShopConfiguration> {

  public HibernateBundle() {
    super(Product.class, ShoppingCart.class, ShoppingCartProduct.class, User.class);
  }

  @Override
  public PooledDataSourceFactory getDataSourceFactory(WebShopConfiguration webShopConfiguration) {
    return webShopConfiguration.getDataSourceFactory();
  }
}
