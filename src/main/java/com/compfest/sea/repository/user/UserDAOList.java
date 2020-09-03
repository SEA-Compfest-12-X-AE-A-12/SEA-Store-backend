package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("UserDAOList")
public class UserDAOList implements UserDAO {

    private static final List<User> DB = new ArrayList<>();

    public UserDAOList(PasswordEncoder encoder) {
        DB.add(new User(1, "admin", "admin@mail.com", encoder.encode("admin123"), "123", "address", Role.ADMIN));
    }

    public List<User> findAll() {
        return DB;
    }

    @Override
    public User insert(User newUser) {
        DB.add(newUser);
        return newUser;
    }

    @Override
    public User findUserById(int id) {
        return DB.stream().filter(user -> id == user.getId()).findAny().orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return DB.stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
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
