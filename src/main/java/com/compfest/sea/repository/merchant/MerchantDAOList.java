package com.compfest.sea.repository.merchant;

import java.util.ArrayList;
import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import org.springframework.stereotype.Repository;

@Repository("MerchantDAOList")
public class MerchantDAOList implements MerchantDAO {

  private static List<Merchant> DB = new ArrayList<Merchant>();

  @Override
  public List<Merchant> findAll() {
    return DB;
  }

  @Override
  public Merchant insert(Merchant newMerchant) {
    DB.add(newMerchant);
    return newMerchant;
  }

  @Override
  public Merchant findByUserId(int userId) {
    Merchant merchant = DB.stream().filter(m -> m.getUserID() == userId).findAny().orElse(null);
    return merchant;
  }

  @Override
  public Merchant updateMerchant(int userId, Merchant updatedMerchant) {
    deleteMerchant(userId);
    return insert(updatedMerchant);
  }

  @Override
  public void deleteMerchant(int userId) {
    DB.removeIf(m -> m.getUserID() == userId);
  }
}
