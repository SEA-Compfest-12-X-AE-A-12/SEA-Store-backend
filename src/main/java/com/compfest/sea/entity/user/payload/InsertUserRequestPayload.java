package com.compfest.sea.entity.user.payload;

import com.compfest.sea.entity.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertUserRequestPayload {
  private String name;
  private String email;
  private String password;
  private String phone;
  private String address;
  private Role role;
}
