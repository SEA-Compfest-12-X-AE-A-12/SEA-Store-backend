package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("UserDAOList")
public class UserDAOList implements UserDAO {
    private static final List<User> DB = new ArrayList<>();

    public List<User> findAll() {
        return DB;
    }

    @Override
    public User insert(User newUser) {
        newUser.setId(DB.size() + 1);
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
