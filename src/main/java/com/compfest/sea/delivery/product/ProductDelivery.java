package com.compfest.sea.delivery.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.payload.ResponsePayload;
import java.util.List;
import org.springframework.web.bind.annotation.*;

public interface ProductDelivery {
  public ResponsePayload insert(InsertRequestPayload insertRequestPayload);

  public List<Product> getAll();

  public List<Product> getAllByMerchantId(Integer merchantId);

  Product get(Integer id);
}
