package com.compfest.sea.entity.merchant.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawBalanceRequest {
  private String bankName;
  private String accountNumber;
  private Integer amount;
}
