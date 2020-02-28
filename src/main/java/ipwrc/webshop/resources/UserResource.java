package ipwrc.webshop.resources;

import io.dropwizard.hibernate.UnitOfWork;
import ipwrc.webshop.models.User;
import ipwrc.webshop.services.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

  private UserService userService;

  @Inject
  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @GET
  @UnitOfWork
  public List<User> getAllUsers() {
    return this.userService.getAllUsers();
  }

  @GET
  @Path("/{id}")
  @UnitOfWork
  public User getUser(@PathParam("id") int userId){
    return this.userService.getUser(userId);
  }

  @POST
  @UnitOfWork
  public User addUser(@Valid @NotNull User user){
    return this.userService.addUser(user);
  }

  @PUT
  @UnitOfWork
  public User updateUser(@Valid @NotNull User user){
    return this.userService.updateUser(user);
  }

  @DELETE
  @UnitOfWork
  @Path("/{id}")
  public User deleteUser(@PathParam("id") int userId){
    return this.userService.deleteUser(userId);
  }
}
