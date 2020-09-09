package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Withdrawal;

public interface WithdrawalDAO {
  public Withdrawal insert(Withdrawal newWithdrawal);
}
