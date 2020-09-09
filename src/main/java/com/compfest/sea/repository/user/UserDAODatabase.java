package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository("userRepoDB")
public class UserDAODatabase implements UserDAO {
    @Autowired @Lazy UserDAOJPA userDAOJPA;

    @Override
    public List<User> findAll() {
        return userDAOJPA.findAll();
    }

    @Override
    public User insert(User newUser) {
        return userDAOJPA.save(newUser);
    }

    @Override
    public User findUserById(int id) {
        return userDAOJPA.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> findUserByEmail(String email) {
        return userDAOJPA.findAllByEmail(email);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        return userDAOJPA.save(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        User user = userDAOJPA.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setActive(false);
        userDAOJPA.save(user);
    }
}
