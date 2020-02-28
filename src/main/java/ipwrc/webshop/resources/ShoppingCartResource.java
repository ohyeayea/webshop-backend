package ipwrc.webshop.resources;

import io.dropwizard.hibernate.UnitOfWork;
import ipwrc.webshop.models.ShoppingCart;
import ipwrc.webshop.services.ShoppingCartService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shoppingCart")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ShoppingCartResource {

  private ShoppingCartService shoppingCartService;

  @Inject
  public ShoppingCartResource(ShoppingCartService shoppingCartService) {
    this.shoppingCartService = shoppingCartService;
  }

  @GET
  @UnitOfWork
  public List<ShoppingCart> getAllShoppingCarts() {
    return this.shoppingCartService.getAllShoppingCarts();
  }

  @GET
  @Path("/{id}")
  @UnitOfWork
  public ShoppingCart getShoppingCart(@PathParam("id") int shoppingCartId){
    return this.shoppingCartService.getShoppingCart(shoppingCartId);
  }

  @POST
  @UnitOfWork
  public ShoppingCart addShoppingCart(@Valid @NotNull ShoppingCart shoppingCart){
    return this.shoppingCartService.addShoppingCart(shoppingCart);
  }

  @PUT
  @UnitOfWork
  public ShoppingCart updateShoppingCart(@Valid @NotNull ShoppingCart shoppingCart){
    return this.shoppingCartService.updateShoppingCart(shoppingCart);
  }

  @DELETE
  @UnitOfWork
  @Path("/{id}")
  public ShoppingCart deleteShoppingCart(@PathParam("id") int shoppingCartId){
    return this.shoppingCartService.deleteShoppingCart(shoppingCartId);
  }
}
