package com.compfest.sea.usecase.admin;

import com.compfest.sea.entity.user.model.Role;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.usecase.user.UserUsecase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAdminUsecase {
  private AdminUsecase adminUsecase;

  @Mock private UserUsecase userUsecase;

  @BeforeEach
  void setUp() {
    adminUsecase = new AdminUsecaseImpl(userUsecase);
  }

  @Test
  public void whenRegisterAdmin_shouldReturnRegisteredAdmin() {
    Role customer = Role.CUSTOMER;
    User user = new User("test", "test@gmail.com", "test123", "0123456789", "test", customer);

    adminUsecase.registerAdmin(user);
    Mockito.verify(userUsecase, Mockito.times(1)).createUser(user);
  }
}
