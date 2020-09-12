package com.compfest.sea.delivery.admin;

import com.compfest.sea.entity.admin.payload.InsertAdminRequestPayload;
import com.compfest.sea.entity.user.model.User;

public class AdminAdapter {
    public static User convertInsertAdminPayloadToUser(InsertAdminRequestPayload payload) {
        return new User(payload.getName(), payload.getEmail(), payload.getPassword(),
                payload.getPhone(), payload.getAddress(), payload.getRole());
    }
}
