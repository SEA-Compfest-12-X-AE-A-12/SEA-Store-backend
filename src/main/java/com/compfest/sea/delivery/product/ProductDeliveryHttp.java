package com.compfest.sea.delivery.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.payload.ResponsePayload;
import com.compfest.sea.usecase.product.ProductUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1/sea/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductDeliveryHttp implements ProductDelivery {
    private final ProductUsecase productUsecase;

    @Autowired
    public ProductDeliveryHttp(@Qualifier("productUsecase1") ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    @Override
    @PostMapping("/insert")
    public ResponsePayload insert(@RequestBody InsertRequestPayload insertRequestPayload) {
        return new ResponsePayload(productUsecase.insert(insertRequestPayload));
    }

    @Override
    @GetMapping("/")
    public List<Product> getAll() {
        return productUsecase.getAll();
    }
}
