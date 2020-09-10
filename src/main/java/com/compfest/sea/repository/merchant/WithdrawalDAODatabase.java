package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.model.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("withdrawalRepoDB")
public class WithdrawalDAODatabase implements WithdrawalDAO {
  @Autowired @Lazy WithdrawalDAOJPA withdrawalDAOJPA;

  @Override
  public Withdrawal insert(Withdrawal newWithdrawal) {
    return withdrawalDAOJPA.save(newWithdrawal);
  }

  @Override
  public List<Withdrawal> findAllByMerchant(Merchant merchant) {
    return withdrawalDAOJPA.findAllByMerchant(merchant);
  }
}
