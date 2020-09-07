package com.compfest.sea.usecase.user;

import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserUsecase extends UserDetailsService {
  public List<User> getAllUser();

  public User findUserById(int id);

  public User findUserWithRoleByEmail(String email, Role role);

  public User createUser(User newUser);

  public User updateProfile(int id, User updatedUser);

  public void deleteUser(int id);

  public String authenticate(String email, String password);
}
