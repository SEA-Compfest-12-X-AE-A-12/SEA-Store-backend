package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;

import java.util.List;

public interface ProductUsecase {
    List<String> insert(InsertRequestPayload insertRequestPayload);
    List<Product> getAll();
    Product get(Integer id);
}
