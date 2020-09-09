package com.compfest.sea.usecase.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.model.Withdrawal;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.merchant.MerchantDAO;
import com.compfest.sea.repository.merchant.WithdrawalDAO;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("MerchantUsecaseImpl")
public class MerchantUsecaseImpl implements MerchantUsecase {
  private MerchantDAO merchantDAO;
  private WithdrawalDAO withdrawalDAO;
  private UserUsecase userUsecase;

  @Autowired
  public MerchantUsecaseImpl(
      @Qualifier("merchantRepoDB") MerchantDAO merchantDAO,
      @Qualifier("withdrawalRepoDB") WithdrawalDAO withdrawalDAO,
      @Qualifier("UserUsecaseImpl") UserUsecase userUsecase) {
    this.merchantDAO = merchantDAO;
    this.withdrawalDAO = withdrawalDAO;
    this.userUsecase = userUsecase;
  }

  @Override
  public List<Merchant> findAll() {
    return merchantDAO.findAll();
  }

  @Override
  public Merchant createMerchant(User newUser, Merchant newMerchant) {
    User created = userUsecase.createUser(newUser);
    newMerchant.setUser(created);
    merchantDAO.insert(newMerchant);
    return newMerchant;
  }

  @Override
  public Merchant createMerchant(int userId, Merchant newMerchant) {
    newMerchant.setUser(userUsecase.findUserById(userId));
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
  public Withdrawal withdrawBalance(Merchant merchant, String bankName, String accountNumber, int amount) throws Exception {
    int balance = merchant.getBalance();
    if (amount >= 0 && amount <= balance) {
      merchant.setBalance(balance-amount);
      merchantDAO.updateMerchant(merchant.getUserID(), merchant);
      return withdrawalDAO.insert(new Withdrawal(amount, bankName, accountNumber, merchant));
    } else {
      throw new Exception("Invalid amount");
    }
  }
}
