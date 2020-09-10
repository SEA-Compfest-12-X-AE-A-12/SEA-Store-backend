package com.compfest.sea.entity.user.payload;

import com.compfest.sea.entity.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestPayload {
  private String email;
  private String password;
  private Role role;
}
