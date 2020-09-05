package com.compfest.sea.usecase.user;

import java.util.List;
import com.compfest.sea.entity.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserUsecase extends UserDetailsService {
  List<User> getAllUser();

  User findUserById(int id);

  User findUserByEmail(String email);

  User createUser(User newUser);

  User updateProfile(int id, User updatedUser);

  void deleteUser(int id);

  String authenticate(String email, String password);
}
