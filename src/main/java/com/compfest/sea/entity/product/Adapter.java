package com.compfest.sea.entity.product;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;

public class Adapter {
  public static Product convertInsertPayloadToModel(InsertRequestPayload insertRequestPayload) {
    try {
      return new Product(
          0,
          insertRequestPayload.getName(),
          insertRequestPayload.getDescription(),
          insertRequestPayload.getPrice(),
          insertRequestPayload.getQuantity(),
          insertRequestPayload.getMerchantId(),
          Category.valueOf(insertRequestPayload.getCategory()),
          true);
    } catch (Exception e) {
      return null;
    }
  }
}
