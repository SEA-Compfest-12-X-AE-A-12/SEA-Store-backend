package com.compfest.sea.repository.user;

import java.util.List;
import com.compfest.sea.entities.user.User;

public interface UserDAO {
    public List<User> getAllUser();

    public User insert(User newUser);

    public User getUserById(int id);

    public User getUserByEmail(String email);

    public User updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
