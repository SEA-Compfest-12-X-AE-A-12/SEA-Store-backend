package com.compfest.sea.entity.merchant.payload;

import com.compfest.sea.entity.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertMerchantRequest {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Role role;
    private String description;
}
