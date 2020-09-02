package com.compfest.sea.usecase.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.user.UserDAO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUserUsecase {

    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserUsecaseImpl usecase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSaveUserItShouldReturnUser() {
        User user = new User();
        user.setName("name");

        when(userDAO.insert(user)).thenReturn(user);
        User created = usecase.createUser(user);
        verify(userDAO).insert(user);

        assertThat(created.getName(), is(user.getName()));
    }

    @Test
    public void whenGetAllUserItShouldReturnAList() {
        List<User> createdUsers = new ArrayList<User>(Arrays.asList(new User(), new User()));

        when(userDAO.getAllUser()).thenReturn(createdUsers);
        List<User> users = usecase.getAllUser();

        verify(userDAO).getAllUser();
        assertThat(users.size(), is(2));
    }
}
