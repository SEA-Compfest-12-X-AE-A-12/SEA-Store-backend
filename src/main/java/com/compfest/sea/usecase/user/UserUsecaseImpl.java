package com.compfest.sea.usecase.user;

import com.compfest.sea.entities.user.User;
import com.compfest.sea.repository.user.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserUsecaseImpl implements UserUsecase {
    private UserDAO userDAO;

    @Override
    public User findUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User createUser(User newUser) {
        return userDAO.insert(newUser);
    }

    @Override
    public User updateProfile(int id, User updatedUser) {
        return userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
