package ipwrc.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "shopping_cart_product")
@Table(name = "shopping_cart_product")
public class ShoppingCartProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Column(name = "shopping_cart_id")
  private Integer shoppingCartId;

  @NotNull
  @Column(name = "product_id")
  private Integer productId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product")
  @JsonBackReference
  private Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shopping_cart")
  @JsonBackReference
  private ShoppingCart shoppingCart;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getShoppingCartId() {
    return shoppingCartId;
  }

  public void setShoppingCartId(Integer shoppingCartId) {
    this.shoppingCartId = shoppingCartId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setProduct(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }
}