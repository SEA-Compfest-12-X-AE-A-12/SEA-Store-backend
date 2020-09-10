package com.compfest.sea.delivery.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.payload.ResponsePayload;

import java.util.List;

public interface ProductDelivery {
  ResponsePayload insert(InsertRequestPayload insertRequestPayload);

  ResponsePayload update(Product updateRequestPayload);

  ResponsePayload delete(Integer productId);

  List<Product> getAll();

  List<Product> getAllByMerchantId(Integer merchantId);

  Product get(Integer id);
}
