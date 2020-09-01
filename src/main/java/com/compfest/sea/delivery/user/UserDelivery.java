package com.compfest.sea.delivery.user;

import com.compfest.sea.entities.user.User;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserDelivery {

    private UserUsecase userUsecase;

    @Autowired
    public UserDelivery(@Qualifier("UserUsecaseImpl") UserUsecase usecase) {
        userUsecase = usecase;
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userUsecase.createUser(user);
    }
}
