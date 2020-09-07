package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.User;
import java.util.List;

public interface UserDAO {
  public List<User> findAll();

  public User insert(User newUser);

  public User findUserById(int id);

  public List<User> findUserByEmail(String email);

  public User updateUser(int id, User updatedUser);

  public void deleteUser(int id);
}
