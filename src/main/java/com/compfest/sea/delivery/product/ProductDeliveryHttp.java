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
@RequestMapping("/api/v1/products")
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
  @PutMapping("/")
  public ResponsePayload update(@RequestBody Product updateRequestPayload) {
    return new ResponsePayload(productUsecase.update(updateRequestPayload));
  }

  @Override
  @DeleteMapping("/delete/{id}")
  public ResponsePayload delete(@PathVariable("id") Integer productId) {
    return new ResponsePayload(productUsecase.delete(productId));
  }

  @GetMapping("/")
  public List<Product> getAll() {
    return productUsecase.getAll();
  }

  @Override
  @GetMapping("/{merchantId}")
  public List<Product> getAllByMerchantId(@PathVariable Integer merchantId) {
    return productUsecase.getAllByMerchantId(merchantId);
  }

  @Override
  @GetMapping("/detail/{id}")
  public Product get(@PathVariable Integer id) {
    return productUsecase.get(id);
  }
}
