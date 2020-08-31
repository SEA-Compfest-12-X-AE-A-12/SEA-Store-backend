package com.compfest.sea.delivery.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.usecase.product.ProductUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("productDelivery1")
public class ProductDeliveryHttp implements ProductDelivery {
    private final ProductUsecase productUsecase;

    @Autowired
    public ProductDeliveryHttp(@Qualifier("productUsecase1") ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    @Override
    public List<String> insert(InsertProductPayload insertProductPayload) {
        return productUsecase.insert(insertProductPayload);
    }

    @Override
    public String ping() {
        return "pong";
    }
}
