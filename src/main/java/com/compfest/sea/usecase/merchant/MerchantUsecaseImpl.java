package com.compfest.sea.usecase.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.merchant.MerchantDAO;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("MerchantUsecaseImpl")
public class MerchantUsecaseImpl implements MerchantUsecase {
  private MerchantDAO merchantDAO;
  private UserUsecase userUsecase;

  @Autowired
  public MerchantUsecaseImpl(
      @Qualifier("MerchantDAOList") MerchantDAO merchantDAO,
      @Qualifier("UserUsecaseImpl") UserUsecase userUsecase) {
    this.merchantDAO = merchantDAO;
    this.userUsecase = userUsecase;
  }

  @Override
  public List<Merchant> findAll() {
    return merchantDAO.findAll();
  }

  @Override
  public Merchant createMerchant(User newUser, Merchant newMerchant) {
    User created = userUsecase.createUser(newUser);
    newMerchant.setUserID(created.getId());
    merchantDAO.insert(newMerchant);
    return newMerchant;
  }

  @Override
  public Merchant createMerchant(int userId, Merchant newMerchant) {
    newMerchant.setUserID(userId);
    merchantDAO.insert(newMerchant);
    return newMerchant;
  }

  @Override
  public Merchant findByUserId(int userId) {
    return merchantDAO.findByUserId(userId);
  }

  @Override
  public Merchant updateMerchant(int userId, Merchant updatedMerchant) {
    return merchantDAO.updateMerchant(userId, updatedMerchant);
  }

  @Override
  public void deleteMerchant(int userId) {
    merchantDAO.deleteMerchant(userId);
  }

  @Override
  public void verifyMerchant(int userId) {
    // TODO
  }

  @Override
  public void withdrawBalance(int userId, int balance) {
    // TODO
  }
}
