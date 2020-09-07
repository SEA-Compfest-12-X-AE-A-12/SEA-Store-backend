package com.compfest.sea.entity.merchant.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertMerchantRequest {
  private int userId;
  private String name;
  private String email;
  private String password;
  private String phone;
  private String address;
  private String description;
}
