package com.compfest.sea.usecase.user;

import java.util.List;
import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserUsecase extends UserDetailsService {
  List<User> getAllUser();

  User findUserById(int id);

  public User findUserWithRoleByEmail(String email, Role role);

  User createUser(User newUser);

  User updateProfile(int id, User updatedUser);

  void deleteUser(int id);

  String authenticate(String email, String password);
}
