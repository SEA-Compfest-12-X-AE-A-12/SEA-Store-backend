package com.compfest.sea.usecase.user;

import com.compfest.sea.config.security.jwt.JwtUtils;
import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserUsecaseImpl")
public class UserUsecaseImpl implements UserUsecase {
    private UserDAO userDAO;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private PasswordEncoder encoder;

    @Autowired
    public UserUsecaseImpl(@Qualifier("UserDAOList") UserDAO userDAO,
            AuthenticationManager authenticationManager, JwtUtils jwtUtils,
            PasswordEncoder encoder) {
        this.userDAO = userDAO;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.encoder = encoder;
        userDAO.insert(new User(1, "admin", "admin@mail.com", encoder.encode("admin123"), "123",
                "address", Role.ADMIN));
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }

    public List<User> findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User findUserWithRoleByEmail(String email, Role role) {
        List<User> users = findUserByEmail(email);
        return users.stream().filter(user -> user.getRole().equals(role)).findAny().orElse(null);
    }


    @Override
    public User createUser(User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userDAO.insert(newUser);
    }

    @Override
    public User updateProfile(int id, User updatedUser) {
        updatedUser.setId(id);
        return userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public String authenticate(String email, String password) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return jwtUtils.generateJwtToken(auth);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users = findUserByEmail(email);
        return users.get(0);
    }
}
