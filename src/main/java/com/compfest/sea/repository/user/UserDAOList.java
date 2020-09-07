package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository("UserDAOList")
public class UserDAOList implements UserDAO {

  private static final List<User> DB = new ArrayList<>();

  private static int lastId = 0;

  public List<User> findAll() {
    return DB;
  }

  @Override
  public User insert(User newUser) {
    lastId++;
    newUser.setId(lastId);
    DB.add(newUser);
    return newUser;
  }

  @Override
  public User findUserById(int id) {
    return DB.stream().filter(user -> id == user.getId()).findAny().orElse(null);
  }

  @Override
  public List<User> findUserByEmail(String email) {
    return DB.stream().filter(user -> email.equals(user.getEmail())).collect(Collectors.toList());
  }

  @Override
  public User updateUser(int id, User updatedUser) {
    DB.removeIf(user -> user.getId() == id);
    DB.add(updatedUser);
    return updatedUser;
  }

  @Override
  public void deleteUser(int id) {
    DB.removeIf(user -> user.getId() == id);
  }
}
