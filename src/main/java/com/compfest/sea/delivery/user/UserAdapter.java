package com.compfest.sea.delivery.user;

import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.entity.user.payload.InsertUserRequestPayload;

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
}
