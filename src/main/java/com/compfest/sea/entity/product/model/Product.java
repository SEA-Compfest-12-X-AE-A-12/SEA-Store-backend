package com.compfest.sea.entity.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer id, quantity, merchantId, categoryId;
    private String name, description;
    private Integer price;
}
