package com.compfest.sea.entity.product.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertRequestPayload {
    private Integer quantity, merchantId, categoryId;
    private String name, description;
    private Integer price;
}
