package com.compfest.sea.usecase.user;

import java.util.List;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserUsecaseImpl")
public class UserUsecaseImpl implements UserUsecase {
    private UserDAO userDAO;

    @Autowired
    public UserUsecaseImpl(@Qualifier("UserDAOList") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

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
