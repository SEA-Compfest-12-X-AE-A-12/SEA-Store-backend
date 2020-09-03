package com.compfest.sea.delivery.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.merchant.payload.InsertMerchantRequest;
import com.compfest.sea.entity.merchant.payload.UpdateMerchantPayload;
import com.compfest.sea.entity.user.model.User;

public class MerchantAdapter {
    public static User convertInsertMerchantPayloadToUser(InsertMerchantRequest payload) {
        return new User(payload.getName(), payload.getEmail(), payload.getPassword(),
                payload.getPhone(), payload.getAddress(), payload.getRole());
    }

    public static Merchant convertInsertMerchantPayloadToMerchant(InsertMerchantRequest payload) {
        return new Merchant(payload.getDescription(), false, 0);
    }

    public static Merchant convertUpdateMerchantPayloadToMerchant(UpdateMerchantPayload payload) {
        return new Merchant(payload.getDescription(), payload.isVerified(), payload.getBalance());
    }
}
