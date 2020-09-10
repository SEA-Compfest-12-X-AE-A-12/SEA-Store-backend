package com.compfest.sea.usecase.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.user.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class TestUserUsecase {

  @Mock UserDAO userDAO;

  @Mock PasswordEncoder encoder;

  @InjectMocks UserUsecaseImpl usecase;

  @Test
  public void whenSaveUserItShouldReturnUser() {
    User user = new User();
    user.setName("name");

    when(userDAO.insert(user)).thenReturn(user);
    when(encoder.encode(user.getPassword())).thenReturn(user.getPassword());
    User created = usecase.createUser(user);
    verify(userDAO).insert(user);

    assertThat(created.getName(), is(user.getName()));
  }

  @Test
  public void whenGetAllUserItShouldReturnAList() {
    List<User> createdUsers = new ArrayList<User>(Arrays.asList(new User(), new User()));

    when(userDAO.findAll()).thenReturn(createdUsers);
    List<User> users = usecase.getAllUser();

    verify(userDAO).findAll();
    assertThat(users.size(), is(2));
  }

  @Test
  public void whenGetUserByIdItShouldReturnAUser() {
    User user = new User(2, "name", "email", "password", "phone", "address", Role.CUSTOMER);
    when(userDAO.findUserById(2)).thenReturn(user);
    User user2 = usecase.findUserById(2);
    verify(userDAO).findUserById(2);
    assertThat(user2.getName(), is(user.getName()));
  }

  @Test
  public void whenDeleteUserItShouldNotReturnAnything() {
    usecase.deleteUser(2);
    verify(userDAO).deleteUser(2);
  }

  @Test
  public void whenUpdateUserItShouldReturnAUser() {
    User user = new User(2, "name", "email", "password", "phone", "address", Role.CUSTOMER);
    when(userDAO.updateUser(user.getId(), user)).thenReturn(user);

    User updatedUser = usecase.updateProfile(user.getId(), user);
    verify(userDAO).updateUser(user.getId(), user);

    assertThat(updatedUser.getName(), is(user.getName()));
  }
}
