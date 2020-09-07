package com.compfest.sea.delivery.merchant;

import java.util.List;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.payload.InsertMerchantRequest;
import com.compfest.sea.entity.merchant.payload.UpdateMerchantPayload;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.usecase.merchant.MerchantUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/merchants")
@RestController
public class MerchantDelivery {
  private MerchantUsecase merchantUsecase;

  @Autowired
  public MerchantDelivery(@Qualifier("MerchantUsecaseImpl") MerchantUsecase merchantUsecase) {
    this.merchantUsecase = merchantUsecase;
  }

  @GetMapping
  public List<Merchant> getAllMerchants() {
    return merchantUsecase.findAll();
  }

  @PostMapping
  public Merchant createMerchant(@RequestBody InsertMerchantRequest payload) {
    Merchant merchant;
    // If register as a merchant first without registered as an user, will not have an userId
    if (payload.getUserId() == 0) {
      User user = MerchantAdapter.convertInsertMerchantPayloadToUser(payload);
      merchant = MerchantAdapter.convertInsertMerchantPayloadToMerchant(payload);
      return merchantUsecase.createMerchant(user, merchant);
    }
    // If registered as user before register as a merchant
    merchant = MerchantAdapter.convertInsertMerchantPayloadToMerchant(payload);
    return merchantUsecase.createMerchant(payload.getUserId(), merchant);
  }

  @GetMapping("{id}")
  public Merchant getMerchantByUserId(@PathVariable("id") int userId) {
    return merchantUsecase.findByUserId(userId);
  }

  @PutMapping("{id}")
  public Merchant updateMerchant(@PathVariable("id") int userId, UpdateMerchantPayload payload) {
    Merchant merchant = MerchantAdapter.convertUpdateMerchantPayloadToMerchant(payload);
    return merchantUsecase.updateMerchant(userId, merchant);
  }

  @DeleteMapping("{id}")
  public void deleteMerchant(@PathVariable("id") int userId) {
    merchantUsecase.deleteMerchant(userId);
  }
}
