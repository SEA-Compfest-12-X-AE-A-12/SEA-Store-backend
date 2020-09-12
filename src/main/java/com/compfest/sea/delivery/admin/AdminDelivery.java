package com.compfest.sea.delivery.admin;

import com.compfest.sea.entity.admin.payload.InsertAdminRequestPayload;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.exception.InvalidAdminTokenException;
import com.compfest.sea.usecase.admin.AdminUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/admin")
@RestController
public class AdminDelivery {
  private AdminUsecase adminUsecase;

  @Autowired
  public AdminDelivery(@Qualifier("AdminUsecaseImpl") AdminUsecase adminUsecase) {
    this.adminUsecase = adminUsecase;
  }

  @PostMapping
  public User register(@RequestBody InsertAdminRequestPayload payload) {
    if (payload.getToken() != System.getenv("token")) {
      throw new InvalidAdminTokenException("admin");
    }
    User adminUser = AdminAdapter.convertInsertAdminPayloadToUser(payload);
    return adminUsecase.registerAdmin(adminUser);
  }
}
