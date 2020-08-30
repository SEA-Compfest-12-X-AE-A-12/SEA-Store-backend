package com.compfest.sea.usecase.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;

import java.util.List;

public interface ProductUsecase {
    List<String> insert(InsertProductPayload insertProductPayload);
}
