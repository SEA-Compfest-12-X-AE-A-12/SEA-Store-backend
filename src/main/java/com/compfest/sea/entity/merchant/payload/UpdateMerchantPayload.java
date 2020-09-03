package com.compfest.sea.entity.merchant.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMerchantPayload {
    private String description;
    private boolean isVerified;
    private int balance;
}
