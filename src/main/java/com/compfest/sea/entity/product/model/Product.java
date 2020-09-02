package com.compfest.sea.entity.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id, quantity, merchantId, categoryId;
    private String name, description;
    private Integer price;
}
