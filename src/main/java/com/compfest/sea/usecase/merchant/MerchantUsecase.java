package com.compfest.sea.usecase.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.user.model.User;

public interface MerchantUsecase {
  public List<Merchant> findAll();

  public Merchant createMerchant(User newUser, Merchant newMerchant);

  public Merchant createMerchant(int userId, Merchant newMerchant);

  public Merchant findByUserId(int userId);

  public Merchant updateMerchant(int userId, Merchant updatedMerchant);

  public void deleteMerchant(int userId);

  public void verifyMerchant(int userId);

  public void withdrawBalance(int userId, int balance);
}
