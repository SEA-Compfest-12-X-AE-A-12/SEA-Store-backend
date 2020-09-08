package com.compfest.sea.entity.merchant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
  private int userID;
  private String description;
  private boolean isVerified;
  private int balance;

  public Merchant(String description, boolean isVerified, int balance) {
    this.description = description;
    this.isVerified = isVerified;
    this.balance = balance;
  }
}
