package ipwrc.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "shopping_cart")
@Table(name = "shopping_cart")
public class ShoppingCart extends WebshopEntity {

  @NotNull
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "total_price")
  private Integer totalPrice;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user")
  @JsonBackReference
  private User user;

  @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<ShoppingCartProduct> shoppingCartProducts;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<ShoppingCartProduct> getShoppingCartProducts() {
    return shoppingCartProducts;
  }

  public void setShoppingCartProducts(List<ShoppingCartProduct> shoppingCartProducts) {
    this.shoppingCartProducts = shoppingCartProducts;
  }
}
