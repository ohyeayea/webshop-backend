package ipwrc.webshop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "product")
@Table(name = "product")
public class Product extends WebshopEntity {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer id;

  @NotNull
  private String title;

  @NotNull
  private String description;

  @NotNull
  @Column(name = "image_url")
  private String imageUrl;

  @NotNull
  private Double price;

  @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<ShoppingCartProduct> shoppingCartProducts;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<ShoppingCartProduct> getShoppingCartProducts() {
    return shoppingCartProducts;
  }

  public void setShoppingCartProducts(List<ShoppingCartProduct> shoppingCartProducts) {
    this.shoppingCartProducts = shoppingCartProducts;
  }
}
