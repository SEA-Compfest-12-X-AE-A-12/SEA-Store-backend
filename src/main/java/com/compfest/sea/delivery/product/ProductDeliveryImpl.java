package com.compfest.sea.delivery.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.usecase.product.ProductUsecase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDeliveryImpl implements ProductDelivery {
    private final ProductUsecase productUsecase;

    @Autowired
    public ProductDeliveryImpl(ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    @Override
    public List<String> insert(InsertProductPayload insertProductPayload) {
        return productUsecase.insert(insertProductPayload);
    }
}
