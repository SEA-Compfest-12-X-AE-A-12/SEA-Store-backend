package com.compfest.sea.entity.product;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.user.model.User;

public class Adapter {
  public static Product convertInsertPayloadToModel(
    InsertRequestPayload insertRequestPayload, User merchant) {
    try {
      return new Product(
          0,
          insertRequestPayload.getName(),
          insertRequestPayload.getDescription(),
          insertRequestPayload.getPrice(),
          insertRequestPayload.getQuantity(),
          merchant,
          Category.valueOf(insertRequestPayload.getCategory()),
          true);
    } catch (Exception e) {
      return null;
    }
  }
}
