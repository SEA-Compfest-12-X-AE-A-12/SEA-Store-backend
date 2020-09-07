package com.compfest.sea.repository.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;

public interface MerchantDAO {
  public List<Merchant> findAll();

  public Merchant insert(Merchant newMerchant);

  public Merchant findByUserId(int userId);

  public Merchant updateMerchant(int userId, Merchant updatedMerchant);

  public void deleteMerchant(int userId);
}
