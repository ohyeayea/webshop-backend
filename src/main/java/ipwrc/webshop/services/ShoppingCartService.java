package ipwrc.webshop.services;

import ipwrc.webshop.models.ShoppingCart;
import ipwrc.webshop.persistences.ShoppingCartDAO;

import javax.inject.Inject;
import java.util.List;

public class ShoppingCartService {

  private ShoppingCartDAO shoppingCartDAO;

  @Inject
  public ShoppingCartService(ShoppingCartDAO shoppingCartDAO) {
    this.shoppingCartDAO = shoppingCartDAO;
  }

  public List<ShoppingCart> getAllShoppingCarts() {
    return this.shoppingCartDAO.getAllShoppingCarts();
  }

  public ShoppingCart getShoppingCart(int shoppingCartId) {
    return this.shoppingCartDAO.getShoppingCart(shoppingCartId);
  }

  public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
    return this.shoppingCartDAO.addShoppingCart(shoppingCart);
  }

  public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
    return this.shoppingCartDAO.updateShoppingCart(shoppingCart);
  }

  public ShoppingCart deleteShoppingCart(int shoppingCartId) {
    return this.shoppingCartDAO.deleteShoppingCart(shoppingCartId);
  }
}
