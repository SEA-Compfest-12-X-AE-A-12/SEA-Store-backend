package com.compfest.sea.repository.user;

import com.compfest.sea.entity.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAOJPA extends JpaRepository<User, Integer> {
    List<User> findAllByEmail(String email);

    List<User> findAll();
}
