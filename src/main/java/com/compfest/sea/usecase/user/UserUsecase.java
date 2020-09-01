package com.compfest.sea.usecase.user;

import java.util.List;
import com.compfest.sea.entities.user.User;
import org.springframework.stereotype.Service;

@Service
public interface UserUsecase {
    public List<User> getAllUser();

    public User findUserById(int id);

    public User findUserByEmail(String email);

    public User createUser(User newUser);

    public User updateProfile(int id, User updatedUser);

    public void deleteUser(int id);
}
