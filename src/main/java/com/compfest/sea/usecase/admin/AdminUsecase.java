package com.compfest.sea.usecase.admin;

import com.compfest.sea.entity.user.model.User;

public interface AdminUsecase {
    User registerAdmin(User user);

    void acceptTransaction();

    void rejectTransaction();
}
