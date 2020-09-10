package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalDAOJPA extends JpaRepository<Withdrawal, Integer> {
  public List<Withdrawal> findAllByMerchant(Merchant merchant);
}
