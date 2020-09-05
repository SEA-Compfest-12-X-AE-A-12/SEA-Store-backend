package com.compfest.sea.delivery.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.payload.ResponsePayload;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ProductDelivery {
    public ResponsePayload insert(InsertRequestPayload insertRequestPayload);
    public ResponsePayload update(Product updateRequestPayload);
    public ResponsePayload delete(Integer productId);
    public List<Product>  getAll();
    public List<Product> getAllByMerchantId(Integer merchantId);
    Product get(Integer id);
}
