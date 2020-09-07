package com.compfest.sea.delivery.user;

import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.entity.user.payload.InsertUserRequestPayload;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAdapter {
  public static User convertInsertUserRequestPayloadToUser(InsertUserRequestPayload payload) {
    return new User(
        payload.getName(),
        payload.getEmail(),
        payload.getPassword(),
        payload.getPhone(),
        payload.getAddress(),
        payload.getRole());
  }
  public static Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
