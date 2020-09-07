package com.compfest.sea.entity.product.model;

import lombok.Getter;
import lombok.Setter;

public class Product {
  @Getter @Setter private Integer id, quantity, merchantId, categoryId;
  @Getter @Setter private String name, description;
  @Getter @Setter private Integer price;

  public Product(
      Integer id,
      Integer quantity,
      Integer merchantId,
      Integer categoryId,
      String name,
      String description,
      Integer price) {
    this.id = id;
    this.quantity = quantity;
    this.merchantId = merchantId;
    this.categoryId = categoryId;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
