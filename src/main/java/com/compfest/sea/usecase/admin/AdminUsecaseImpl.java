package com.compfest.sea.usecase.admin;

import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.exception.InvalidAdminTokenException;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AdminUsecaseImpl")
class AdminUsecaseImpl implements AdminUsecase {
    private UserUsecase userUsecase;

    @Autowired
    public AdminUsecaseImpl(@Qualifier("UserUsecaseImpl") UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    @Override
    public User registerAdmin(User user) {
        User createdUser = userUsecase.createUser(user);
        return createdUser;
    }

    @Override
    public void acceptTransaction() {
        //TODO
    }

    @Override
    public void rejectTransaction() {
        //TODO
    }
}
