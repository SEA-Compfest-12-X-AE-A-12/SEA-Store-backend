package com.compfest.sea.usecase.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.model.Withdrawal;
import com.compfest.sea.entity.user.model.User;

public interface MerchantUsecase {
  public List<Merchant> findAll();

  public Merchant createMerchant(User newUser, Merchant newMerchant);

  public Merchant createMerchant(int userId, Merchant newMerchant);

  public Merchant findByUserId(int userId);

  public Merchant updateMerchant(int userId, Merchant updatedMerchant);

  public void deleteMerchant(int userId);

  public void verifyMerchant(int userId);

  public Withdrawal withdrawBalance(
          Merchant merchant, String bankName, String accountNumber, int amount) throws Exception;

  public List<Withdrawal> getBalanceHistory(Merchant merchant);
}
