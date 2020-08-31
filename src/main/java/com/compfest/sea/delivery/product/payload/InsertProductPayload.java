package com.compfest.sea.delivery.product.payload;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class InsertProductPayload {
    @Getter @Setter
    private Integer quantity, merchantId, categoryId;
    @Getter @Setter private String name, description;
    @Getter @Setter private Integer price;

    public InsertProductPayload(Integer quantity, Integer merchantId, String name, String description, Integer categoryId, Integer price) {
        this.quantity = quantity;
        this.merchantId = merchantId;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
    }
}
