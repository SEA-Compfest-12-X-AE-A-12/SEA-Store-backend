package com.compfest.sea.delivery.user;

import java.util.List;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.entity.user.payload.InsertUserRequestPayload;
import com.compfest.sea.entity.user.payload.LoginRequestPayload;
import com.compfest.sea.entity.user.payload.LoginResponse;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
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
    public User register(@RequestBody InsertUserRequestPayload payload) {
        User convertedFromPayload = UserAdapter.convertInsertUserRequestPayloadToUser(payload);
        return userUsecase.createUser(convertedFromPayload);
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

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequestPayload payload) {
        return new LoginResponse(userUsecase.authenticate(payload.getEmail(), payload.getPassword()));
    }
}
