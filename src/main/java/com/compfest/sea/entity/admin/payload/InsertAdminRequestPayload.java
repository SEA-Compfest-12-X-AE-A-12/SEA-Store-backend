package com.compfest.sea.entity.admin.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertAdminRequestPayload {
  private String name;
  private String email;
  private String password;
  private String phone;
  private String address;
  private String token;
}
