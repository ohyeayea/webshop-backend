package ipwrc.webshop.resources;

import io.dropwizard.hibernate.UnitOfWork;
import ipwrc.webshop.models.Product;
import ipwrc.webshop.services.ProductService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ProductResource {

  private ProductService productService;

  @Inject
  public ProductResource(ProductService productService) {
    this.productService = productService;
  }

  @GET
  @UnitOfWork
  public List<Product> getAllProducts() {
    return this.productService.getAllProducts();
  }

  @GET
  @Path("/{id}")
  @UnitOfWork
  public Product getProduct(@PathParam("id") int productId){
    return this.productService.getProduct(productId);
  }

  @POST
  @UnitOfWork
  public Product addProduct(@Valid @NotNull Product product){
    return this.productService.addProduct(product);
  }

  @PUT
  @UnitOfWork
  public Product updateProduct(@Valid @NotNull Product product){
    return this.productService.updateProduct(product);
  }

  @DELETE
  @UnitOfWork
  @Path("/{id}")
  public Product deleteProduct(@PathParam("id") int productId){
    return this.productService.deleteProduct(productId);
  }
}
