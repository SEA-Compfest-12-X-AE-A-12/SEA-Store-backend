package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.model.Withdrawal;

import java.util.List;

public interface WithdrawalDAO {
  public Withdrawal insert(Withdrawal newWithdrawal);

  public List<Withdrawal> findAllByMerchant(Merchant merchant);
}
