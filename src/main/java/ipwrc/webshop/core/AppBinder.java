package ipwrc.webshop.core;

import ipwrc.webshop.persistences.ProductDAO;
import ipwrc.webshop.persistences.ShoppingCartDAO;
import ipwrc.webshop.persistences.ShoppingCartProductDAO;
import ipwrc.webshop.persistences.UserDAO;
import ipwrc.webshop.services.ProductService;
import ipwrc.webshop.services.ShoppingCartService;
import ipwrc.webshop.services.UserService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.hibernate.SessionFactory;

public class AppBinder extends AbstractBinder {

  private HibernateBundle hibernateModule;

  public AppBinder(HibernateBundle hibernateModule) {
    this.hibernateModule = hibernateModule;
  }

  @Override
  protected void configure() {
    bind(hibernateModule.getSessionFactory()).to(SessionFactory.class);
    bind(ProductDAO.class).to(ProductDAO.class);
    bind(ProductService.class).to(ProductService.class);
    bind(ShoppingCartDAO.class).to(ShoppingCartDAO.class);
    bind(ShoppingCartService.class).to(ShoppingCartService.class);
    bind(ShoppingCartProductDAO.class).to(ShoppingCartProductDAO.class);
    bind(UserDAO.class).to(UserDAO.class);
    bind(UserService.class).to(UserService.class);
  }
}
