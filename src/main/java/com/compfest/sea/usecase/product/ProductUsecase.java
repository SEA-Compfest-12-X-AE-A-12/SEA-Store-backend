package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;

import java.util.List;

public interface ProductUsecase {
    List<String> insert(InsertRequestPayload insertRequestPayload);
    List<String> update(Product updateRequestPayload);
    List<Product> getAll();
    List<Product> getAllByMerchantId(Integer merchantId);
    Product get(Integer id);
}
