package ipwrc.webshop.services;

import ipwrc.webshop.models.User;
import ipwrc.webshop.persistences.UserDAO;

import javax.inject.Inject;
import java.util.List;

public class UserService {

  private UserDAO userDAO;

  @Inject
  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public List<User> getAllUsers() {
    return this.userDAO.getAllUsers();
  }

  public User getUser(int userId) {
    return this.userDAO.getUser(userId);
  }

  public User addUser(User user) {
    return this.userDAO.addUser(user);
  }

  public User updateUser(User user) {
    return this.userDAO.updateUser(user);
  }

  public User deleteUser(int userId) {
    return this.userDAO.deleteUser(userId);
  }
}
