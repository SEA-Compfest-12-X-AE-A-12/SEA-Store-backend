package com.compfest.sea.delivery.user;

import java.util.List;
import com.compfest.sea.entities.user.User;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public List<User> getUser() {
        return userUsecase.getAllUser();
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userUsecase.createUser(user);
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userUsecase.findUserById(id);
    }

    @PutMapping("{id}")
    public User updateProfile(@PathVariable("id") int id, @RequestBody User updatedUser) {
        return userUsecase.updateProfile(id, updatedUser);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userUsecase.deleteUser(id);
    }
}
