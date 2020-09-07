package com.compfest.sea.entity.product.payload;

import lombok.Getter;
import lombok.Setter;

public class InsertRequestPayload {
  @Getter @Setter private Integer quantity, merchantId, categoryId;
  @Getter @Setter private String name, description;
  @Getter @Setter private Integer price;

  public InsertRequestPayload(
      Integer quantity,
      Integer merchantId,
      String name,
      String description,
      Integer categoryId,
      Integer price) {
    this.quantity = quantity;
    this.merchantId = merchantId;
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.price = price;
  }
}
