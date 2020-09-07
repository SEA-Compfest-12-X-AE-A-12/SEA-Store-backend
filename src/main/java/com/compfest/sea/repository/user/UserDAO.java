package com.compfest.sea.repository.user;

import java.util.List;
import com.compfest.sea.entity.user.model.User;

public interface UserDAO {
  List<User> findAll();

  User insert(User newUser);

  User findUserById(int id);
  
  public List<User> findUserByEmail(String email);

  User updateUser(int id, User updatedUser);

  void deleteUser(int id);
}
